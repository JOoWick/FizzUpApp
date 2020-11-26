package android.univ.fr.fizzupapp

import android.univ.fr.fizzupapp.model.DataX
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyRecyclerViewAdapter(private val dataList: MutableList<DataX>) :
    RecyclerView.Adapter<MyRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewHolder {
        val context = parent.context
        return MyRecyclerViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyRecyclerViewHolder, position: Int) {
        val data = dataList[position]
        val name = holder.textView
        val image = holder.imageView
        name.text = data.name
        Picasso.get().load(data.imageUrl).into(image)
    }

    override fun getItemCount(): Int = dataList.size
}