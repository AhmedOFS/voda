


package com.example.voda
import android.content.Context
import android.content.Intent
import android.view.*

import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class RecViewAdapter(val context: Context,  var mList: List<Airline>) : RecyclerView.Adapter<RecViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.card1, parent, false)

        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
   val viewmod = mList[position]

      holder.textView.text= viewmod.name
        holder.itemView.setOnClickListener{
            val intent = Intent(context,display::class.java)
            intent.putExtra("name",viewmod.name)
            intent.putExtra("country",viewmod.country)
            intent.putExtra("slogan",viewmod.slogan)
            intent.putExtra("headquarters",viewmod.head_quarters)
            intent.putExtra("website",viewmod.website)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
       return mList.size
    }

class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView){

    val textView: TextView = itemView.findViewById(R.id.name)


   //val rec: recyclerView= itemView.findViewById(R.)
}
}