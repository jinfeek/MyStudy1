package com.aungrattanakorn.tanakorn.mystudy1;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by Jinfeek on 1/15/2017.
 */

public class SynUser extends AsyncTask<Void, Void, String> {

    //ExPlicit
    private Context context;
    private static final String urlJSON = "http://swiftcodingthai.com/14jan/get_user_Jew.php";


    public SynUser(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... params) {

        try {

            OkHttpClient okHttpClient =new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlJSON).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }
} //Main Class
