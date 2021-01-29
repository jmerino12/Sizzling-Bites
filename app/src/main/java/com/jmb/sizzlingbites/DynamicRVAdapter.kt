package com.jmb.sizzlingbites

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jmb.sizzlingbites.DRVInterface.LoadMore

/**
 * Created by jmerino on 1/29/21
 */
class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val progressbar = itemView.findViewById(R.id.progress_bar) as ProgressBar
}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val nameView = itemView.findViewById(R.id.name) as TextView
}

class DynamicRVAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    val VIEW_TYPE_ITEM: Int = 0
    val VIEW_TYPE_LOADING: Int = 1
    lateinit var loadMore: LoadMore
    var isLoading: Boolean = false
    lateinit var activity: Activity
    var items: List<DynamicRvModel> = ArrayList()
    val visibleThreshold: Int = 5
    var lastvisibleItem: Int = 0
    var totalItemsCount: Int = 0

    public constructor(recyclerView: RecyclerView, activity: Activity, items: List<DynamicRvModel>) : this() {
        this.activity = activity
        this.items = items


        val linearLayoutManager: LinearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                totalItemsCount = linearLayoutManager.itemCount
                lastvisibleItem = linearLayoutManager.findLastVisibleItemPosition()
                if (!isLoading && totalItemsCount <= (lastvisibleItem + visibleThreshold)) {
                    if (loadMore != null) {
                        loadMore.onLoadMore()
                        isLoading = true
                    }
                }
            }
        });
    }

    override fun getItemViewType(position: Int): Int {
        return if (items.get(position) == null) VIEW_TYPE_LOADING else VIEW_TYPE_ITEM
    }


    @JvmName("setLoadMore1")
    fun setLoadMore(loadMore: LoadMore) {
        this.loadMore = loadMore

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ITEM) {
            val view = LayoutInflater.from(activity).inflate(R.layout.dynamic_rv_item_layout, parent, false)
            return LoadingViewHolder(view)
        }
        val view = LayoutInflater.from(activity).inflate(R.layout.dynamic_rv_progress_bar, parent, false)
        return LoadingViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            val item = items[position]
            val itemViewHolder: ItemViewHolder = holder
            itemViewHolder.nameView.text = item.name
        } else if (holder is LoadingViewHolder) {
            val loadingViewHolder: LoadingViewHolder = holder
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    public fun setLoaded() {
        isLoading = false
    }
}