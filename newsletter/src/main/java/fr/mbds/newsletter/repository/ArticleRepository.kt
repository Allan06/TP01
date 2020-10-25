package fr.mbds.newsletter.repository

import com.google.gson.Gson
import fr.mbds.newsletter.BuildConfig
import fr.mbds.newsletter.model.Article
import fr.mbds.newsletter.services.ArticleService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ArticleRepository {
    private val service: ArticleService

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor()

        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
             httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()

        val gsonConverterFactory = GsonConverterFactory.create(Gson())

        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org/")
            addConverterFactory(gsonConverterFactory)
            client(client)
        }.build()

        service = retrofit.create(ArticleService::class.java)
        }

    fun list(): List<Article> {
        val response = service.getArticles().execute()
        return response.body() ?: emptyList()
    }
}
