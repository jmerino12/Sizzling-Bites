package com.jmb.sizzlingbites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jmb.sizzlingbites.DRVInterface.LoadMore
import java.util.*
import kotlin.collections.ArrayList

class DashBoardActivity : AppCompatActivity() {
    lateinit var mRecyclerView: RecyclerView
    lateinit var mRecyclerView2: RecyclerView

    val mAdapter: StaticRvAdapter = StaticRvAdapter()
    var dynamicRVAdapter: DynamicRVAdapter = DynamicRVAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        setUpRecyclerView()
        setUpRecycleView2()
    }

    fun getSuperheros(): MutableList<StaticRvModel> {
        var superheros: MutableList<StaticRvModel> = ArrayList()
        superheros.add(StaticRvModel(R.drawable.img1, "Burger"))
        superheros.add(StaticRvModel(R.drawable.img1, "Potatoes"))
        superheros.add(StaticRvModel(R.drawable.img1, "Pizza"))
        superheros.add(StaticRvModel(R.drawable.img1, "Sandwich"))
        superheros.add(StaticRvModel(R.drawable.img1, "icecream"))
        return superheros
    }

    fun setUpRecyclerView() {
        mRecyclerView = findViewById<RecyclerView>(R.id.rv_1)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mAdapter.RecyclerAdapter(getSuperheros(), this)
        mRecyclerView.adapter = mAdapter
    }

    fun setUpRecycleView2() {
        mRecyclerView2 = findViewById(R.id.rv_2)
        mRecyclerView2.setHasFixedSize(true)
        mRecyclerView2.layoutManager = LinearLayoutManager(this)
        dynamicRVAdapter = DynamicRVAdapter(mRecyclerView2, this, getItems())
        mRecyclerView2.adapter = dynamicRVAdapter

        dynamicRVAdapter.setLoadMore(object : LoadMore {
            override fun onLoadMore() {
                if (getItems().size <= 10) {
                    getItems().add(DynamicRvModel("null"))
                    dynamicRVAdapter.notifyItemInserted(getItems().size - 1)
                    val updateHandler = Handler()
                    val runnable = Runnable {
                        doJob() // some action(s)
                    }
                    updateHandler.postDelayed(runnable, 5000)
                }else{
                    Toast.makeText(this@DashBoardActivity, "Data completed", Toast.LENGTH_SHORT).show()
                }
            }
        })


    }

    private fun doJob() {
        getItems().removeAt(getItems().size - 1)
        dynamicRVAdapter.notifyItemRemoved(getItems().size - 1)

        val index = getItems().size
        val end = index + 10
        for (i in index..end) {
            val name: String = UUID.randomUUID().toString()
            getItems().add(DynamicRvModel(name))
        }
        dynamicRVAdapter.notifyDataSetChanged()
        dynamicRVAdapter.setLoaded()

    }

    fun getItems(): MutableList<DynamicRvModel> {
        var items: MutableList<DynamicRvModel> = ArrayList()
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        items.add(DynamicRvModel("icecream"))
        return items
    }
}