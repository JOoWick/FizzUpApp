package android.univ.fr.fizzupapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imageView: ImageView = view.findViewById(R.id.exerciseImage)
    val textView: TextView = view.findViewById(R.id.exerciseName)
}