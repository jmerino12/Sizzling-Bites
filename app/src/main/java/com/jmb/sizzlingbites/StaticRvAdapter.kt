package com.jmb.sizzlingbites

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jmb.sizzlingbites.DRVInterface.UpdateRecycleView

/**
 * Created by jmerino on 1/27/21
 */
class StaticRvAdapter : RecyclerView.Adapter<StaticRvAdapter.ViewHolder>() {
    var superheros: MutableList<StaticRvModel> = ArrayList()
    lateinit var context: Context
    var row_index: Int? = -1
    lateinit var updateRecycleView: UpdateRecycleView
    var activity: Activity? = null
    private var isCheck: Boolean = true
    var isSelected: Boolean = true
    fun RecyclerAdapter(superheros: MutableList<StaticRvModel>, activity: Activity, updateRecycleView: UpdateRecycleView) {
        this.superheros = superheros
        this.activity = activity
        this.updateRecycleView = updateRecycleView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.static_rv_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = superheros.get(position)
        holder.name.text = item.text
        holder.image.setImageResource(item.image)
        if (this.isCheck)  {
            var list: MutableList<DynamicRvModel> = ArrayList()
            list.add(DynamicRvModel("Burger 1", R.drawable.burger))
            list.add(DynamicRvModel("Burger 2", R.drawable.burger))
            list.add(DynamicRvModel("Burger 3", R.drawable.burger))
            list.add(DynamicRvModel("Burger 4", R.drawable.burger))
            list.add(DynamicRvModel("Burger 5", R.drawable.burger))
            list.add(DynamicRvModel("Burger 6", R.drawable.burger))
            list.add(DynamicRvModel("Burger 7", R.drawable.burger))
            list.add(DynamicRvModel("Burger 8", R.drawable.burger))
            list.add(DynamicRvModel("Burger 9 ", R.drawable.burger))
            updateRecycleView.callBack(position, list)
            isCheck = false
        }
        holder.layout.setOnClickListener {
            row_index = position
            notifyDataSetChanged()
            if (position == 0) {
                var list: MutableList<DynamicRvModel> = ArrayList()
                list.add(DynamicRvModel("Burger 1", R.drawable.burger))
                list.add(DynamicRvModel("Burger 2", R.drawable.burger))
                list.add(DynamicRvModel("Burger 3", R.drawable.burger))
                list.add(DynamicRvModel("Burger 4", R.drawable.burger))
                list.add(DynamicRvModel("Burger 5", R.drawable.burger))
                list.add(DynamicRvModel("Burger 6", R.drawable.burger))
                list.add(DynamicRvModel("Burger 7", R.drawable.burger))
                list.add(DynamicRvModel("Burger 8", R.drawable.burger))
                list.add(DynamicRvModel("Burger 9 ", R.drawable.burger))
                updateRecycleView.callBack(position, list)

            } else if (position == 1) {
                var list: MutableList<DynamicRvModel> = ArrayList()
                list.add(DynamicRvModel("Papas 1", R.drawable.papas))
                list.add(DynamicRvModel("Papas 2", R.drawable.papas))
                list.add(DynamicRvModel("Papas 3", R.drawable.papas))
                list.add(DynamicRvModel("Papas 4", R.drawable.papas))
                list.add(DynamicRvModel("Papas 5", R.drawable.papas))
                list.add(DynamicRvModel("Papas 6", R.drawable.papas))
                list.add(DynamicRvModel("Papas 7", R.drawable.papas))
                list.add(DynamicRvModel("Papas 8", R.drawable.papas))
                list.add(DynamicRvModel("Papas 9 ", R.drawable.papas))


                updateRecycleView.callBack(position, list)
            } else if (position == 2) {
                var list: MutableList<DynamicRvModel> = ArrayList()
                list.add(DynamicRvModel("Pizza 1", R.drawable.pizza))
                list.add(DynamicRvModel("Pizza 2", R.drawable.pizza))
                list.add(DynamicRvModel("Pizza 3", R.drawable.pizza))
                list.add(DynamicRvModel("Pizza 4", R.drawable.pizza))
                list.add(DynamicRvModel("Pizza 5", R.drawable.pizza))
                list.add(DynamicRvModel("Pizza 6", R.drawable.pizza))
                list.add(DynamicRvModel("Pizza 7", R.drawable.pizza))
                list.add(DynamicRvModel("Pizza 8", R.drawable.pizza))
                list.add(DynamicRvModel("Pizza 9 ", R.drawable.pizza))

                updateRecycleView.callBack(position, list)
            } else {
                var list: MutableList<DynamicRvModel> = ArrayList()
                list.add(DynamicRvModel("Burger 1", R.drawable.burger))
                list.add(DynamicRvModel("Burger 2", R.drawable.burger))
                list.add(DynamicRvModel("Burger 3", R.drawable.burger))
                list.add(DynamicRvModel("Burger 4", R.drawable.burger))
                list.add(DynamicRvModel("Burger 5", R.drawable.burger))
                list.add(DynamicRvModel("Burger 6", R.drawable.burger))
                list.add(DynamicRvModel("Burger 7", R.drawable.burger))
                list.add(DynamicRvModel("Burger 8", R.drawable.burger))
                list.add(DynamicRvModel("Burger 9 ", R.drawable.burger))
                updateRecycleView.callBack(position, list)
            }
        }

        if (isSelected) {
            if (position == 0) {
                holder.layout.setBackgroundResource(R.drawable.static_rv_bg_selected)
                isSelected = false
            }
        }else{
            if (row_index == position) {
                holder.layout.setBackgroundResource(R.drawable.static_rv_bg_selected)
            } else {
                holder.layout.setBackgroundResource(R.drawable.static_rv_bg)
            }
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
        fun bind(superhero: StaticRvModel, context: Context, position: Int, row_index: Int) {
            name.text = superhero.text
            image.setImageResource(superhero.image)
            layout.setOnClickListener {

            }
        }
    }
}