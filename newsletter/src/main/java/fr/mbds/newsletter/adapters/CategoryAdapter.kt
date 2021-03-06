package fr.mbds.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.mbds.newsletter.model.Category
import fr.mbds.newsletter.R

class CategoryAdapter(private val dataset: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Category) {
            val txtName = root.findViewById<TextView>(R.id.category_name)
            val imageView = root.findViewById<ImageView>(R.id.category_image)
            txtName.text = item.name

            Glide
                .with(root)
                .load(item.image)
                .fitCenter()
                .placeholder(R.drawable.placeholder)
                .into(imageView);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)

        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount(): Int = dataset.size
}