package fr.mbds.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import fr.mbds.newsletter.R
import fr.mbds.newsletter.adapters.ArticleAdapter
import fr.mbds.newsletter.databinding.FragmentArticlesBinding
import fr.mbds.newsletter.model.Article
import fr.mbds.newsletter.model.Category
import fr.mbds.newsletter.repository.ArticleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListArticleFragment :Fragment(){

    private val repository = ArticleRepository()
    private val category: Category? = null
    private var articleAdapter: ArticleAdapter = ArticleAdapter(listOf())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        lifecycleScope.launch {
            articleAdapter.dataset = emptyList()
            getData()
        }
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    //S'execute dans un thread secondaire
    private suspend fun getData() {
        withContext(Dispatchers.IO) {
            val result = repository.list(category ?: Category("", ""))
            bindData(result)
        }
    }

    //S'execute sur le thread principal
    private suspend fun bindData(result: List<Article>) {
        withContext(Dispatchers.Main) {
            articleAdapter.dataset = result
        }
    }
}