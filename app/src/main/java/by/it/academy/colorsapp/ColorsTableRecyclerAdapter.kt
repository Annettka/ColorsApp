package by.it.academy.colorsapp

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ColorsTableRecyclerAdapter(
    private val values: MutableList<by.it.academy.colorsapp.Color>
) :
    RecyclerView.Adapter<ColorsTableRecyclerAdapter.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_handbook_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val colorName = values[position].colorName
        val colorHex = values[position].colorHEXCode
        holder.colorName?.text = colorName
        holder.colorHexCode?.text = colorHex
        if (holder.colorHexCode?.text == "#000000") {
            holder.colorName?.setTextColor(Color.WHITE)
            holder.colorHexCode?.setTextColor(Color.WHITE)
        }

        holder.colorName?.setBackgroundColor(Color.parseColor(colorHex))
        holder.colorHexCode?.setBackgroundColor(Color.parseColor(colorHex))
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var colorName: TextView? = null
        var colorHexCode: TextView? = null

        init {
            colorName = itemView.findViewById(R.id.color_name)
            colorHexCode = itemView.findViewById(R.id.color_hexCode)
        }
    }
}