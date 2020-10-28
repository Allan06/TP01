package fr.mbds.newsletter.model


/* Classe basée sur l'exemple Java: https://medium.com/@sraju432/news-application-using-retrofit-2-be8d052c7aca */
class Article(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)