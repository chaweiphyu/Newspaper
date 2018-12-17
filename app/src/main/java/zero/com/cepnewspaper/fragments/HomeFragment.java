package zero.com.cepnewspaper.fragments;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import zero.com.cepnewspaper.R;
import zero.com.cepnewspaper.adapters.NewsListAdapter;
import zero.com.cepnewspaper.networks.ApiService;
import zero.com.cepnewspaper.networks.vos.ArticlesResponseVO;
import zero.com.cepnewspaper.networks.vos.NewsResponseVO;
import zero.com.cepnewspaper.utils.RetrofitHelper;
import zero.com.cepnewspaper.utils.ShareConstant;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.rv_newspaper)
    RecyclerView recyclerView;

    private NewsListAdapter newsAdapter;

    ProgressDialog progressDialog;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        ButterKnife.bind(this,view);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        newsAdapter = new NewsListAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsAdapter);

        getEverything();

        return view;

    }

    private void getEverything() {

        ApiService apiService = RetrofitHelper.getinstance().getApiService();
        apiService.getNews(ShareConstant.Q,ShareConstant.FROM,ShareConstant.SORT_BY,ShareConstant.API_KEY).enqueue(new Callback<NewsResponseVO>() {
            @Override
            public void onResponse(Call<NewsResponseVO> call, Response<NewsResponseVO> response) {
                progressDialog.hide();
                NewsResponseVO newsResponseVO = response.body();
                if (newsResponseVO != null && newsResponseVO.getArticles()!=null  && newsResponseVO.getArticles().size()>0) {
                    newsAdapter.setNewData(newsResponseVO.getArticles());
                }

            }

            @Override
            public void onFailure(Call<NewsResponseVO> call, Throwable t) {

            }
        });
    }

}
