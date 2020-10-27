package fr.mbds.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.mbds.newsletter.R
import fr.mbds.newsletter.model.Article
import fr.mbds.newsletter.model.Category

class ArticleAdapter (var dataset: List<Article>):
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
    lateinit var category: Category
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_articles, parent, false)
        return ViewHolder(rootView)
    }

    class ViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        fun bind(item: Article) {
            val txtAuth = root.findViewById<TextView>(R.id.article_author)
            val txtTitle = root.findViewById<TextView>(R.id.article_title)
            val txtDescription = root.findViewById<TextView>(R.id.article_description)
            val imageView = root.findViewById<ImageView>(R.id.article_image)

            txtAuth.text = item.author;
            txtTitle.text = item.title
            txtDescription.text = item.description

            Glide
                .with(root)
                .load(item.urlToImage)
                .fitCenter()
                .placeholder(R.drawable.placeholder)
                .into(imageView);
        }
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])

        holder.itemView.setOnClickListener{category}
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}
