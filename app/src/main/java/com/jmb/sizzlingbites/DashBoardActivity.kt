package com.jmb.sizzlingbites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jmb.sizzlingbites.DRVInterface.LoadMore
import com.jmb.sizzlingbites.DRVInterface.UpdateRecycleView
import java.util.*
import kotlin.collections.ArrayList

class DashBoardActivity : AppCompatActivity(), UpdateRecycleView {
    lateinit var mRecyclerView: RecyclerView
    lateinit var mRecyclerView2: RecyclerView

    val mAdapter: StaticRvAdapter = StaticRvAdapter()
    var dynamicRVAdapter: DynamicRVAdapterClass = DynamicRVAdapterClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        setUpRecyclerView()
        setUpRecycleView2()
    }

    fun getSuperheros(): MutableList<StaticRvModel> {
        var superheros: MutableList<StaticRvModel> = ArrayList()
        superheros.add(StaticRvModel(R.drawable.burger, "Burger"))
        superheros.add(StaticRvModel(R.drawable.papas, "Potatoes"))
        superheros.add(StaticRvModel(R.drawable.pizza, "Pizza"))
        superheros.add(StaticRvModel(R.drawable.img1, "Sandwich"))
        superheros.add(StaticRvModel(R.drawable.img1, "icecream"))
        return superheros
    }

    fun setUpRecyclerView() {
        mRecyclerView = findViewById<RecyclerView>(R.id.rv_1)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mAdapter.RecyclerAdapter(getSuperheros(), this, this)
        mRecyclerView.adapter = mAdapter
    }

    fun setUpRecycleView2() {
        mRecyclerView2 = findViewById(R.id.rv_2)
        mRecyclerView2.setHasFixedSize(true)
        mRecyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //dynamicRVAdapter = DynamicRVAdapter(mRecyclerView2, this, getItems())
        mRecyclerView2.adapter = dynamicRVAdapter

    }


    override fun callBack(position: Int, list: List<DynamicRvModel>) {
        dynamicRVAdapter = DynamicRVAdapterClass(list)
        dynamicRVAdapter.notifyDataSetChanged()
        mRecyclerView2.adapter = dynamicRVAdapter
    }
}