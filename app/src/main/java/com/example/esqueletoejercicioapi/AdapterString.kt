package com.example.esqueletoejercicioapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AdapterString : RecyclerView.Adapter<AdapterString.StringViewHolder>()  {

    private var datos  = listOf<String>()

    class StringViewHolder(val root: View, val textView: TextView) : RecyclerView.ViewHolder(root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main_item, parent, false)
        val textView = view.findViewById<TextView>(R.id.tv_activity_main_item)
        return StringViewHolder(view, textView)
    }

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        holder.textView.text = datos[position]
        if (position%2 ==0){
            holder.root.setBackgroundColor(ContextCompat.getColor(holder.root.context, R.color.design_default_color_primary_variant))
        } else {
            holder.root.setBackgroundColor(ContextCompat.getColor(holder.root.context, R.color.material_on_primary_disabled))
        }

    }

    override fun getItemCount(): Int {
        return datos.size
    }

    suspend fun setData(string : List<String>){
        datos = string
        withContext(Dispatchers.Main){
            notifyDataSetChanged()
        }
    }

}