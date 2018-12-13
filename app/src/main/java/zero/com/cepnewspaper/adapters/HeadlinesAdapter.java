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
import zero.com.cepnewspaper.viewholders.HeadlinesViewHolder;
import zero.com.cepnewspaper.viewholders.NewsListViewHolder;

public class HeadlinesAdapter extends RecyclerView.Adapter<HeadlinesViewHolder> {

    private List<ArticlesResponseVO> articlesResponseVOList = new ArrayList<>();

    public void setNewData(List<ArticlesResponseVO> articlesResponseVOList){
        this.articlesResponseVOList = articlesResponseVOList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HeadlinesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_headlines,parent,false);

        return new HeadlinesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeadlinesViewHolder holder, int position) {
        holder.bind(articlesResponseVOList.get(position));
    }

    @Override
    public int getItemCount() {
        return articlesResponseVOList.size();
    }
}
