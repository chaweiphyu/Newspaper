package zero.com.cepnewspaper.viewholders;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import zero.com.cepnewspaper.R;
import zero.com.cepnewspaper.activities.HomeDetailActivity;
import zero.com.cepnewspaper.networks.vos.ArticlesResponseVO;

public class NewsListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ArticlesResponseVO articlesResponseVO;

    @BindView(R.id.tv_source)
    TextView source;

    @BindView(R.id.tv_news_title)
    TextView newsTitle;

    @BindView(R.id.iv_news_photo)
    ImageView newsPhoto;

    @BindView(R.id.tv_time)
    TextView time;

    public NewsListViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);

        itemView.setOnClickListener(this);
    }

    public void bind(ArticlesResponseVO articlesResponseVO){
        this.articlesResponseVO = articlesResponseVO;


        Glide.with(newsPhoto.getContext())
                .load(articlesResponseVO.getUrlToImage())
                .apply(RequestOptions.placeholderOf(R.drawable.newspaper))
                .into(newsPhoto);

        source.setText(articlesResponseVO.getSource().getName());

        newsTitle.setText(articlesResponseVO.getTitle());

        time.setText(articlesResponseVO.getPublishedAt());

    }

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        if (position != RecyclerView.NO_POSITION){
            Intent intent = new Intent(itemView.getContext(), HomeDetailActivity.class);
            intent.putExtra("title",articlesResponseVO.getTitle());
            intent.putExtra("image",articlesResponseVO.getUrlToImage());
            intent.putExtra("source",articlesResponseVO.getSource().getName());
            intent.putExtra("time",articlesResponseVO.getPublishedAt());
            intent.putExtra("description",articlesResponseVO.getDescription());
            itemView.getContext().startActivity(intent);
        }

    }
}
