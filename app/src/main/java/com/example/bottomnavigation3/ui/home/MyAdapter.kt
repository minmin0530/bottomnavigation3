package com.example.bottomnavigation3.ui.home

import android.content.res.ColorStateList
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomnavigation3.R
import com.google.android.material.card.MaterialCardView

class MyAdapter(private val myDataset: Array<String>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(
        view
    ) {
        val itemNameTextView: TextView
        val itemDescriptionTextView: TextView
        val itemImageView: ImageView
        val itemQuestView: MaterialCardView
        val color: Int

        init {
            itemNameTextView = view.findViewById(R.id.itemNameTextView)
            itemDescriptionTextView = view.findViewById(R.id.itemDescriptionTextView)
            itemImageView = view.findViewById(R.id.itemImageView)
            itemQuestView = view.findViewById(R.id.itemQuestView)
            itemNameTextView.textSize = 30f
            itemDescriptionTextView.textSize = 30f
            itemImageView.layout(0,0,100,100)
            itemQuestView.layout(0,0, 200, 100)

            color = view.context.resources.getColor(android.R.color.holo_purple)

        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemNameTextView.text = myDataset[position]
        holder.itemDescriptionTextView.text = myDataset[position]
        holder.itemImageView.setImageResource(R.mipmap.ic_launcher)

        val res = StateListDrawable()
        val drawable = GradientDrawable()
        drawable.setColor(holder.color)
        drawable.cornerRadius = 40f
        res.addState(intArrayOf(), drawable)
        holder.itemQuestView.apply {
            setBackgroundDrawable(res)
        }
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }
}