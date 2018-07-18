package com.example.a.orderboy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view)
    {
        Intent intent = new Intent(this,OrderActivity.class);
        startActivity(intent);
    }

    public void onClick20(View view1)
    {
        Intent intent1 = new Intent(this,CookingActivity.class);
        startActivity(intent1);
    }

    public void onClick22(View view2)
    {
        Intent intent2 = new Intent(this,ReviewActivity.class);
        startActivity(intent2);
    }


}
