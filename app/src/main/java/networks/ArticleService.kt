package networks

import adapters.Article
import retrofit2.Call
import retrofit2.http.GET

interface ArticleService {
    //@GET("everything?q=bitcoin&from=2019-09-05&sortBy=publishedAt&apiKey=83bcaeb55039497e9deb8bfaba193a92/")
    @GET("/articles")
    fun list(): Call<List<Article>>
}