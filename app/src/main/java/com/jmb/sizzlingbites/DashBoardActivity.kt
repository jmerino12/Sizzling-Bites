package com.jmb.sizzlingbites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DashBoardActivity : AppCompatActivity() {
    lateinit var mRecyclerView: RecyclerView
    val mAdapter: StaticRvAdapter = StaticRvAdapter()


    val dynamicRVAdapter: DynamicRVAdapter = DynamicRVAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        setUpRecyclerView()
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


        var items: MutableList<DynamicRvModel> = ArrayList()

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