package com.codepath.apps.SimpleTweetApp.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/*
    User class is a blueprint for a user's data
    It takes in a Json object and then parses the data and returns it using a static method
 */
@Parcel
@Entity
public class User {

    @ColumnInfo
    @PrimaryKey
    public long id;

    @ColumnInfo public String name;
    @ColumnInfo public String screenName;
    @ColumnInfo public String displayName;
    @ColumnInfo public String profileImageUrl;

    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.name = jsonObject.getString("name");
        user.id = jsonObject.getLong("id");
        user.screenName = "@" + jsonObject.getString("screen_name");
        user.displayName = jsonObject.getString("name");
        user.profileImageUrl = jsonObject.getString("profile_image_url_https");
        return user;
    }

    public static List<User> fromJsonTweetArray(List<Tweet> tweetsFromNetwork) {
        List<User> users = new ArrayList<>();
        for(int i = 0; i < tweetsFromNetwork.size(); i++){
            users.add(tweetsFromNetwork.get(i).user);
        }
        return users;
    }
}
