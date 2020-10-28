package fr.mbds.newsletter.services

import fr.mbds.newsletter.model.Article
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call


interface ArticleService{

    //@GET("everything?apiKey=0e2c97075a8f4826adfdcd85df5f1838")
    @GET("top-headlines")
    fun getArticles(
        @Query("q") category: String,
        @Query("country") country: String = "fr",
        @Query("apiKey") apiKey: String = "0e2c97075a8f4826adfdcd85df5f1838",
    ): Call<List<Article>>
}