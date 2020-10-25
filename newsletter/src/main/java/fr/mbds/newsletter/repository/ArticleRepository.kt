package fr.mbds.newsletter.repository

import fr.mbds.newsletter.model.Article
import fr.mbds.newsletter.services.ArticleService
import retrofit2.Retrofit

class ArticleRepository {
    private val service: ArticleService

    init {
        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org/")
        }.build()
        service = retrofit.create(ArticleService::class.java)
    }

    fun list(): List<Article> {
        val response = service.getArticles().execute()
        return response.body() ?: emptyList()
    }
}
