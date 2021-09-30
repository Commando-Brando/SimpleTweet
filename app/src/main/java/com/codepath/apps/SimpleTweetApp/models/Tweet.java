package com.codepath.apps.SimpleTweetApp.models;

import com.codepath.apps.SimpleTweetApp.TimeFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Tweet {

    public String body;
    public User user;
    public String time;
    public long id;

    // empty constructor for the Parceler Library
    public Tweet(){ }

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        tweet.time = jsonObject.getString("created_at");
        tweet.id = jsonObject.getLong("id");
        return tweet;
    }

    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<Tweet>();
        for(int i = 0; i < jsonArray.length(); i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }

    public static String getFormattedTimestamp(String jsonraw){
        return TimeFormatter.getTimeDifference(jsonraw);
    }

}
