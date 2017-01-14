package com.aungrattanakorn.tanakorn.mystudy1;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Jinfeek on 1/14/2017.
 */

public class MyAlert {


    //Explicit
    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    }

    public void errorDialog(String strTitile, String strMessage) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.doremon48);
        builder.setTitle(strTitile);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                dialogInterface.dismiss();
            }
        });
        builder.show();

    } //ErrorDialog

} //Main Class
