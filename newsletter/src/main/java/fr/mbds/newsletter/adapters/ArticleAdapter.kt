package fr.mbds.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.mbds.newsletter.R
import fr.mbds.newsletter.model.Article

class ArticleAdapter (private val dataset: List<Article>):
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item, parent, false)
        return ViewHolder(rootView)
    }

    class ViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Article) {
            val txtTitle = root.findViewById<TextView>(R.id.article_title)
            val txtDescription = root.findViewById<TextView>(R.id.article_description)
            val imageView = root.findViewById<ImageView>(R.id.article_image)
            txtTitle.text = item.title
            txtDescription.text = item.description


        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(
            dataset[position]
        )
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
