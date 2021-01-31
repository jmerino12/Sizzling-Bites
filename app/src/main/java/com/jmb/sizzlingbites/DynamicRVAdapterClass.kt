package com.jmb.sizzlingbites


import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by jmerino on 1/30/21
 */
class DynamicRVAdapterClass() :  RecyclerView.Adapter<DynamicRVAdapterClass.ViewHolder>() {

    var dynamicRvModelList: List<DynamicRvModel> = ArrayList()

    public constructor(items: List<DynamicRvModel>) : this() {
        this.dynamicRvModelList = items
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById(R.id.imageView5) as ImageView
        val name = view.findViewById(R.id.name) as TextView
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.dynamic_rv_item_layout, parent, false))
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = dynamicRvModelList[position].name
        holder.image.setImageResource(dynamicRvModelList[position].image)
    }
    override fun getItemCount(): Int {
        return dynamicRvModelList.size
    }
}

