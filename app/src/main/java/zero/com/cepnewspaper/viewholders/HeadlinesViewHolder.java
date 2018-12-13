package zero.com.cepnewspaper.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import zero.com.cepnewspaper.R;
import zero.com.cepnewspaper.networks.vos.ArticlesResponseVO;

public class HeadlinesViewHolder extends RecyclerView.ViewHolder {

    private ArticlesResponseVO articlesResponse;

    @BindView(R.id.iv_news_photo)
    ImageView newsPhoto;

    @BindView(R.id.tv_source)
    TextView source;

    @BindView(R.id.tv_news_title)
    TextView newsTitle;

    @BindView(R.id.tv_time)
    TextView time;

    public HeadlinesViewHolder(View itemView) {
        super(itemView);

        ButterKnife.bind(this,itemView);

    }

    public void bind(ArticlesResponseVO articlesResponse){
        this.articlesResponse = articlesResponse;

        Glide.with(newsPhoto.getContext())
                .load(articlesResponse.getUrlToImage())
                .apply(RequestOptions.placeholderOf(R.drawable.newspaper))
                .into(newsPhoto);

        source.setText(articlesResponse.getSource().getName());

        newsTitle.setText(articlesResponse.getTitle());

        time.setText(articlesResponse.getPublishedAt());
    }
}
