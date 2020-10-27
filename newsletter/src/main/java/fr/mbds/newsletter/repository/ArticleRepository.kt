package fr.mbds.newsletter.repository

import com.google.gson.Gson
import fr.mbds.newsletter.BuildConfig
import fr.mbds.newsletter.model.Article
import fr.mbds.newsletter.model.Category
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

        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org/")
            addConverterFactory(GsonConverterFactory.create(Gson()))
            client(client)
        }.build()

        service = retrofit.create(ArticleService::class.java)
        }

    fun list(category: Category): List<Article> {
        val response = service.getArticles(category.name).execute()
        return response.body() ?: emptyList()
    }
}
