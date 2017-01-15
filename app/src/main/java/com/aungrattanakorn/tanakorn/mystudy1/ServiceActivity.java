package com.aungrattanakorn.tanakorn.mystudy1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServiceActivity extends AppCompatActivity {

    //Explicit
    private ListView listView;
    private String[] nameString, userString, passwordString, imageString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        //Bind Widget
        listView = (ListView) findViewById(R.id.livOfficer);

        //Create ListView
        try {

            SynUser synUser = new SynUser(ServiceActivity.this);
            synUser.execute();
            String strJSON = synUser.get();

            JSONArray jsonArray = new JSONArray(strJSON);
            nameString = new String[jsonArray.length()];
            userString = new String[jsonArray.length()];
            passwordString = new String[jsonArray.length()];
            imageString = new String[jsonArray.length()];

            for (int i=0;i<jsonArray.length();i++) {

                JSONObject jsonObject =jsonArray.getJSONObject(i);
                nameString[i] = jsonObject.getString("NAME");
                userString[i] = jsonObject.getString("User");
                passwordString[i] = jsonObject.getString("Password");
                imageString[i] = jsonObject.getString("Image");

            } //for

            final MyAdapter myAdapter = new MyAdapter(ServiceActivity.this, nameString, imageString);
            listView.setAdapter(myAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    MyAlert myAlert = new MyAlert(ServiceActivity.this);
                    myAlert.errorDialog(userString[position], passwordString[position]);
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }

    } //Main Method

} //Main Class
