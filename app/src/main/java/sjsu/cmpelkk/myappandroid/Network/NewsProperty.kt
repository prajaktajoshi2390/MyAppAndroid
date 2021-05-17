package sjsu.cmpelkk.myappandroid.Network

import androidx.activity.OnBackPressedCallback
import com.squareup.moshi.Json

data class NewsProperty(
    // val id: String,
    // used to map main from the JSON to mainpart in our class
    val mainpart: TopHeadlines
    // val name: String,
    // val cod: Double
)

data class MainNewsPart(
    val temp: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Double,
    val humidity: Double
)

data class TopHeadlines(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

data class Article (
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

data class Source(val id: String, val name: String)