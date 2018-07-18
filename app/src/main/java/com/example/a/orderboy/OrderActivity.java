package com.example.a.orderboy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class OrderActivity extends Activity {

    public String id;
    public String pw;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    public void onClick1(View v){
        EditText text_id  = (EditText) findViewById(R.id.TNB);
        id = text_id .getText().toString();

        Intent intent = new Intent(getApplicationContext(), OrderActivity2.class);
        intent.putExtra("TabelNum",id);


        startActivity(intent);
    }


}
