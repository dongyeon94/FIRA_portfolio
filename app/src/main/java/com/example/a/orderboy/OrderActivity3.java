package com.example.a.orderboy;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderActivity3 extends Activity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order3);


        TextView text1 =   (TextView) findViewById(R.id.textView6);
        TextView text2 =   (TextView) findViewById(R.id.textView11);
        TextView text3 =   (TextView) findViewById(R.id.textView12);
        TextView text4 =   (TextView) findViewById(R.id.textView13);
        TextView text5 =   (TextView) findViewById(R.id.textView14);
        Intent in = getIntent();

        String m1 =in.getStringExtra("menu1");
        String m2 =in.getStringExtra("menu2");
        String m3 =in.getStringExtra("menu3");
        String m4 =in.getStringExtra("menu4");
        String m5 =in.getStringExtra("price");

        if(m1.equals("")) text1.setText("");
        else text1.setText(String.valueOf(m1));

        if(m2.equals("")) text2.setText("");
        else text2.setText(String.valueOf(m2));

        if(m3.equals("")) text3.setText("");
        else text3.setText(String.valueOf(m3));

        if(m4.equals("")) text4.setText("");
        else text4.setText(String.valueOf(m4));

        if(m5.equals("")) text5.setText("");
        else text5.setText("합계 :"+String.valueOf(m5));

    }

}



