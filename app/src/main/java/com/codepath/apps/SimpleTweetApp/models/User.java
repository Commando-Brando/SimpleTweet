package com.codepath.apps.SimpleTweetApp.models;

import org.json.JSONException;
import org.json.JSONObject;

/*
    User class is a blueprint for a user's data
    It takes in a Json object and then parses the data and returns it using a static method
 */
public class User {

    public String name;
    public String screenName;
    public String displayName;
    public String profileImageUrl;

    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.name = jsonObject.getString("name");
        user.screenName = "@" + jsonObject.getString("screen_name");
        user.displayName = jsonObject.getString("name");
        user.profileImageUrl = jsonObject.getString("profile_image_url_https");
        return user;
    }
}
