package fr.mbds.newsletter.model

import java.io.Serializable


/* Classe basée sur l'exemple Java: https://medium.com/@sraju432/news-application-using-retrofit-2-be8d052c7aca */
class Article(
    val source: Source,
    val url: String,
    val urlToImage: String,
    val author: String,
    val title: String,
    val description: String,
    val content: String): Serializable{

    data class Source(val id: String, val name: String)
}