package by.it.academy.colorsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HandbookFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_handbook, container, false)
        val rView = view.findViewById<RecyclerView>(R.id.recycler_view_colors_handbook)
        rView.layoutManager = LinearLayoutManager(context)
        rView.adapter = ColorsTableRecyclerAdapter(getColorNamesList(),getColorHexList())
        return view
    }

    private fun getColorNamesList(): List<String> {
        return this.resources.getStringArray(R.array.color_names).toList()
    }
    private fun getColorHexList(): List<String> {
        return this.resources.getStringArray(R.array.colors).toList()
    }
}