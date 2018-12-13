package zero.com.cepnewspaper.networks;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zero.com.cepnewspaper.networks.vos.NewsResponseVO;

public interface ApiService {

    @GET("v2/everything")
    Call<NewsResponseVO> getNews(
            @Query("q") String q,
            @Query("from")String from,
            @Query("sortBy")String sortBy,
            @Query("apiKey")String apiKey
    );

    @GET("v2/top-headlines")
    Call<NewsResponseVO> getHeadlines(
            @Query("country")String country,
            @Query("category")String category,
            @Query("apiKey")String apiKey
    );

}
