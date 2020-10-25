package fr.mbds.newsletter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import fr.mbds.newsletter.model.Article
import fr.mbds.newsletter.repository.ArticleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListArticleFragment :Fragment(){
    private val repository = ArticleRepository()

    //S'execute dans un thread secondaire
    private suspend fun getData() {
        withContext(Dispatchers.IO) {
            val result = repository.list()
            bindData(result)
        }
    }

    //S'execute sur le thread principal
    private suspend fun bindData(result: List<Article>) {
        withContext(Dispatchers.Main) {

        }
    }
}