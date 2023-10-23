package com.example.apicallappication.ADAPTER

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicallappication.RESPONSE.ObjectResponeItem
import com.example.apicallappication.R

class ApiAdapter(var context: Context, var result: List<ObjectResponeItem?>, var onClick :(Int ) -> Unit) : RecyclerView.Adapter<ApiAdapter.MyViewHolder>() {
    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

        var txtId : TextView = itemView.findViewById(R.id.txtId)
        var txtName : TextView = itemView.findViewById(R.id.txtName)
        var txtEmail : TextView = itemView.findViewById(R.id.txtEmail)
        var txtGender : TextView = itemView.findViewById(R.id.txtGender)
        var txtStatus : TextView = itemView.findViewById(R.id.txtStatus)
        var cardView : CardView = itemView.findViewById(R.id.cardView)





    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var View = LayoutInflater.from(context).inflate(R.layout.api_item_file,parent,false)
        return  MyViewHolder(View)

    }

    override fun getItemCount(): Int {
        return  result.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txtId.text = result[position]?.id.toString()
        holder.txtName.text = result[position]?.name.toString()
        holder.txtEmail.text = result[position]?.email.toString()
        holder.txtGender.text = result[position]?.gender.toString()
        holder.txtStatus.text = result[position]?.status.toString()


        holder.cardView.setOnClickListener {

            onClick.invoke(
                result[position]!!.id!!.toInt()
//                result[position]!!.name.toString(),
//                result[position]!!.email.toString(),
//                result[position]!!.gender.toString(),
//                result[position]!!.status.toString()
            )

        }
    }
}