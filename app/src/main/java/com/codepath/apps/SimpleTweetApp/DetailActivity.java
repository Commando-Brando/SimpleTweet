package com.codepath.apps.SimpleTweetApp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.Parcel;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.SimpleTweetApp.models.Tweet;

import org.parceler.Parcels;
import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {

    ImageView ivProfile;
    TextView tvDisplayName;
    TextView tvScreenName;
    TextView tvTime;
    TextView tvBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivProfile = findViewById(R.id.ivProfileImage2);
        tvDisplayName = findViewById(R.id.tvDisplayName3);
        tvScreenName = findViewById(R.id.tvScreenName2);
        tvTime = findViewById(R.id.tvTime3);
        tvBody = findViewById(R.id.tvBody3);

        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));

        Glide.with(this).load(tweet.user.profileImageUrl).circleCrop().into(ivProfile);
        tvDisplayName.setText(tweet.user.displayName);
        tvScreenName.setText(tweet.user.screenName);
        tvTime.setText(TimeFormatter.getTimeStamp(tweet.time));
        tvBody.setText(tweet.body);

    }
}