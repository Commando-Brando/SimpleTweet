package com.codepath.apps.SimpleTweetApp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.codepath.apps.SimpleTweetApp.models.Tweet;

import java.util.List;

/*
    adapter for our RecyclerView
    it inflates a item_tweet.fxml view
    and binds tweet data to each view
 */
public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{

    Context context;
    List<Tweet> tweets;
    // pass in the context and list of tweets
    public TweetsAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    // for each row, inflate the layout
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    // bind values based on the position of the element in RV
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // retrieves data at position
        Tweet tweet = tweets.get(position);
        // binds the tweet with the ViewHolder
        holder.bind(tweet);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    // Clean all elements of the recycler
    public void clear(){
        tweets.clear();
        notifyDataSetChanged();
    }

    // Add a list of items -- change to type used
    public void addAll(List<Tweet> tweetList){
        tweets.addAll(tweetList);
        notifyDataSetChanged();
    }

    // our ViewHolder that inflates the view
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivProfileImage;
        TextView tvBody;
        TextView tvScreenName;
        TextView tvDisplayName;
        TextView tvTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvBody = itemView.findViewById(R.id.tvBody);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            tvDisplayName = itemView.findViewById(R.id.tvDisplayName);
            tvTime = itemView.findViewById(R.id.tvTime);

        }

        // binds all the tweet data to a specific tweet aka instance of item_tweet.fxml which is loaded into the RecyclerView
        public void bind(Tweet tweet) {
            tvBody.setText(tweet.body);
            tvScreenName.setText(tweet.user.screenName);
            tvDisplayName.setText(tweet.user.displayName);
            Glide.with(context).load(tweet.user.profileImageUrl).circleCrop().into(ivProfileImage);
            tvTime.setText(TimeFormatter.getTimeDifference(tweet.time));
        }
    }
}
