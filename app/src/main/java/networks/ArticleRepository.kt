package networks

import adapters.Article
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleRepository {
    val baseUrl : String = "https://newsapi.org/v2/everything?q=bitcoin&from=2019-08-25&sortBy=publishedAt&apiKey="
    val key : String = "83bcaeb55039497e9deb8bfaba193a92"
    private val service: ArticleService
    init {
        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org/v2/")
            addConverterFactory(GsonConverterFactory.create())
        }.build()
        service = retrofit.create(ArticleService::class.java)
    }

    fun list(): List<Article> {
        val response =  service.list().execute()
        return response.body() ?: emptyList()
    }
}
