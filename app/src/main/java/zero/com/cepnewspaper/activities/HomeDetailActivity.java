package zero.com.cepnewspaper.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import zero.com.cepnewspaper.R;

public class HomeDetailActivity extends AppCompatActivity{

    @BindView(R.id.tv_news_title)
    TextView title;

    @BindView(R.id.iv_news_photo)
    ImageView newsImage;

    @BindView(R.id.tv_source)
    TextView source;

    @BindView(R.id.tv_time)
    TextView time;

    @BindView(R.id.tv_desc)
    TextView desc;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        ButterKnife.bind(this,this);
        setSupportActionBar(toolbar);

        if (getIntent().getExtras() != null){
            title.setText(getIntent().getStringExtra("title"));
            Glide.with(newsImage.getContext()).load(getIntent().getStringExtra("image")).into(newsImage);
            source.setText(getIntent().getStringExtra("source"));
            time.setText(getIntent().getStringExtra("time"));
            desc.setText(getIntent().getStringExtra("description"));
        }

    }
}
