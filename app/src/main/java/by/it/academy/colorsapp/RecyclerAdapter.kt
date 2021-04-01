package by.it.academy.colorsapp

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val values: MutableList<by.it.academy.colorsapp.Color>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView?.apply {
            text = values [position].colorHEXCode
            if (text == "#000000")
                setTextColor(Color.WHITE)
            setBackgroundColor(Color.parseColor(text as String))
            setOnClickListener {
                val intent = Intent(context, ColorActivity::class.java)
                intent.putExtra("color", text)
                context?.startActivity(intent)
            }
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView? = null

        init {
            textView = itemView.findViewById(R.id.textViewColor)
        }
    }
}