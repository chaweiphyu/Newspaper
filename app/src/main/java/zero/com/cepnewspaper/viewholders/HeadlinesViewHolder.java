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

public class HeadlinesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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

        itemView.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        int position = getAdapterPosition();
        if (position != RecyclerView.NO_POSITION){
            Intent intent = new Intent(itemView.getContext(), HomeDetailActivity.class);
            intent.putExtra("title",articlesResponse.getTitle());
            intent.putExtra("image",articlesResponse.getUrlToImage());
            intent.putExtra("source",articlesResponse.getSource().getName());
            intent.putExtra("time",articlesResponse.getPublishedAt());
            intent.putExtra("description",articlesResponse.getDescription());
            itemView.getContext().startActivity(intent);
        }
    }
}
