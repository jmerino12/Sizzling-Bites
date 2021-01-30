package com.jmb.sizzlingbites

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by jmerino on 1/27/21
 */
class StaticRvAdapter : RecyclerView.Adapter<StaticRvAdapter.ViewHolder>() {
    var superheros: MutableList<StaticRvModel> = ArrayList()
    lateinit var context: Context
    var row_index: Int = 0
    fun RecyclerAdapter(superheros: MutableList<StaticRvModel>, context: Context) {
        this.superheros = superheros
        this.context = context
        this.row_index = -1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.static_rv_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = superheros.get(position)
        holder.name.text = item.text
        holder.image.setImageResource(item.image)
        holder.layout.setOnClickListener {
            row_index = position
            notifyDataSetChanged()
        }
        if (row_index == position){
            holder.layout.setBackgroundResource(R.drawable.static_rv_bg_selected)
        }else{
            holder.layout.setBackgroundResource(R.drawable.static_rv_bg)
        }
        //holder.bind(item, context, position,row_index)
    }

    override fun getItemCount(): Int {
        return superheros.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById(R.id.image) as ImageView
        val name = view.findViewById(R.id.texto) as TextView
        val layout = view.findViewById(R.id.linearLayout) as LinearLayout
        fun bind(superhero: StaticRvModel, context: Context, position: Int, row_index: Int){
            name.text = superhero.text
            image.setImageResource(superhero.image)
            layout.setOnClickListener {

            }
        }
    }
}