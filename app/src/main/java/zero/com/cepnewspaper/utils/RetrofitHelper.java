package zero.com.cepnewspaper.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zero.com.cepnewspaper.networks.ApiService;

public class RetrofitHelper {

    private static RetrofitHelper objinstance;

    private Retrofit retrofit;

    private ApiService apiService;

    private RetrofitHelper() {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);

    }

    public static RetrofitHelper getinstance() {
        if (objinstance == null) {
            objinstance = new RetrofitHelper();
        }
        return objinstance;
    }

    public ApiService getApiService(){
        return apiService;
    }
}
