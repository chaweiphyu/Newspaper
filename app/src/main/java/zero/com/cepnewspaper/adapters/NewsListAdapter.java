package zero.com.cepnewspaper.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import zero.com.cepnewspaper.R;
import zero.com.cepnewspaper.networks.vos.ArticlesResponseVO;
import zero.com.cepnewspaper.viewholders.NewsListViewHolder;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListViewHolder> {

    private List<ArticlesResponseVO> articlesResponseVOList = new ArrayList<>();

    public void setNewData(List<ArticlesResponseVO> articlesResponseVO) {
        this.articlesResponseVOList = articlesResponseVO;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_newspaper, parent, false);

        return new NewsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsListViewHolder holder, int position) {
        holder.bind(articlesResponseVOList.get(position));
    }

    @Override
    public int getItemCount() {
        return articlesResponseVOList.size();
    }
}
