package com.example.apicallappication.ADAPTER

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicallappication.R
import com.example.apicallappication.RESPONSE.SecondResopenItem

class AdapterSecondApi(var context: Context,var  result: List<SecondResopenItem?>) : RecyclerView.Adapter<AdapterSecondApi.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtId : TextView = itemView.findViewById(R.id.txtId)
        var txtTitle : TextView = itemView.findViewById(R.id.txtTitle)
        var txtUserId : TextView = itemView.findViewById(R.id.txtUserId)
        var txtcompleted : TextView = itemView.findViewById(R.id.txtcompleted)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var View = LayoutInflater.from(context).inflate(R.layout.second_api_item_file_,parent,false)
        return MyViewHolder(View)
    }

    override fun getItemCount(): Int {

       return  result.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.txtId.text = result[position]?.id.toString()
        holder.txtTitle.text = result[position]?.title.toString()
        holder.txtcompleted.text = result[position]?.completed.toString()
        holder.txtUserId.text = result[position]?.userId.toString()
    }
}