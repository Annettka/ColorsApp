package by.it.academy.colorsapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val values: List<String>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemView = values[position]
        val context = holder.textView?.context
        holder.textView?.text = itemView
        if (holder.textView?.text == "#000000")
            holder.textView?.setTextColor(Color.WHITE)
        holder.textView?.setBackgroundColor(Color.parseColor(itemView))
        holder.textView?.setOnClickListener {
            val intent = Intent(context, ColorActivity::class.java)
            intent.putExtra("color", itemView)
            context?.startActivity(intent)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null

        init {
            textView = itemView.findViewById(R.id.textViewColor)
//            itemView.setOnClickListener {
//                val context = itemView.context
//                val intent = Intent(context, ColorActivity::class.java).apply {
//                    putExtra("color", color)
//                }
//                context.startActivity(intent)
//            }
        }
    }
}