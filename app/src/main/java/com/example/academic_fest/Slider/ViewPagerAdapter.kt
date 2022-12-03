package com.example.academic_fest.Slider

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.academic_fest.R

class ViewPagerAdapter(val imageList: List<Int>)
    :RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
        inner class ViewPagerViewHolder(view: View):RecyclerView.ViewHolder(view){
            val image :ImageView= view.findViewById(R.id.image2)
        }
        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType:Int,

        ): ViewPagerViewHolder {
            val layoutView = LayoutInflater.from(parent.context).inflate(R.layout.iten_list,parent,false)
            return  ViewPagerViewHolder(layoutView)
        }

    override fun onBindViewHolder (holder: ViewPagerViewHolder, position: Int) {

        val list = imageList[position]
        holder.image.setImageResource(list)

    }


    override fun getItemCount(): Int {
        return imageList.size
    }

}