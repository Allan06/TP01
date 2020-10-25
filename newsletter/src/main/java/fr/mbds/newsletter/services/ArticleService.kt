package fr.mbds.newsletter.services

import fr.mbds.newsletter.model.Article
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleService{

    @GET("everything?apiKey=0e2c97075a8f4826adfdcd85df5f1838")
    fun getArticles(): Call<List<Article>>
}