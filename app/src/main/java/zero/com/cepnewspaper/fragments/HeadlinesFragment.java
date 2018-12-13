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
import zero.com.cepnewspaper.R;
import zero.com.cepnewspaper.adapters.HeadlinesAdapter;
import zero.com.cepnewspaper.networks.ApiService;
import zero.com.cepnewspaper.networks.vos.NewsResponseVO;
import zero.com.cepnewspaper.utils.RetrofitHelper;
import zero.com.cepnewspaper.utils.ShareConstant;

/**
 * A simple {@link Fragment} subclass.
 */
public class HeadlinesFragment extends Fragment {

    @BindView(R.id.rv_headlines)
    RecyclerView recyclerView;

    private HeadlinesAdapter headlinesAdapter;

    ProgressDialog progressDialog;

    public HeadlinesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_headlines, container, false);

        ButterKnife.bind(this,view);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        headlinesAdapter = new HeadlinesAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(headlinesAdapter);

        getHeadlines();

        return view;
    }

    private void getHeadlines() {

        ApiService apiService = RetrofitHelper.getinstance().getApiService();
        apiService.getHeadlines(ShareConstant.COUNTRY,ShareConstant.CATEGORY,ShareConstant.API_KEY)
                .enqueue(new Callback<NewsResponseVO>() {
                    @Override
                    public void onResponse(Call<NewsResponseVO> call, Response<NewsResponseVO> response) {
                        progressDialog.hide();
                        headlinesAdapter.setNewData(response.body().getArticles());
                    }

                    @Override
                    public void onFailure(Call<NewsResponseVO> call, Throwable t) {

                    }
                });
    }

}
