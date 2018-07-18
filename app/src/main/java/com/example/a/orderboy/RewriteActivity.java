package com.example.a.orderboy;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class RewriteActivity extends Activity {

    TextView tex1,tex2,tex3,tex4;
    EditText edit1,edit2,edit3,edit4;
    Button btn;

    int intrate;
    String stringrate;
    RatingBar rate;

    private String t1="",t2="",t3="",t4="";
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewrite);

        rate = (RatingBar)findViewById(R.id.rate1);
        rate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                stringrate = Integer.toString((int) rating);
            }
        });




        tex1 = (TextView)findViewById(R.id.textView1);
        tex2 = (TextView)findViewById(R.id.textView2);
        tex3 = (TextView)findViewById(R.id.textView3);
        tex4 = (TextView)findViewById(R.id.textView4);

        edit1 = (EditText)findViewById(R.id.editText1);
        edit2 = (EditText)findViewById(R.id.editText2);
        edit3 = (EditText)findViewById(R.id.editText3);
        edit4 = (EditText)findViewById(R.id.editText4);


        btn = (Button)findViewById(R.id.btn1);

    }

    public void b(View v){
        Intent as = new Intent(RewriteActivity.this , ReviewActivity.class);
        startActivity(as);
    }

    //입력 버튼
    public void abc(View v){
        t1 = edit1.getText().toString();
        t2 = edit2.getText().toString();
        t3 = edit3.getText().toString();
        //t4 = edit4.getText().toString();
        if(t1.equals("")||t2.equals("")||t3.equals("")||stringrate.equals(""))
        {Toast.makeText(RewriteActivity.this,"값을 입력해 주세요",Toast.LENGTH_LONG).show();}
        else {

            Inser t1 = new Inser();
            t1.execute(new String[]{"http://223.194.115.137/b3.php"});
        }
    }


    private  class Inser extends AsyncTask<String, Void, Boolean>{
        ProgressDialog dia = new ProgressDialog(RewriteActivity.this);
        protected  void onPreExecute(){
            dia.setMessage("Sending Data");
            dia.show();
        }
        protected Boolean doInBackground(String... urls) {
            for(String url1 : urls){
                try{
                    ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair >();
                    pairs.add(new BasicNameValuePair("tid", t1));
                    pairs.add(new BasicNameValuePair("tpword", t2));
                    pairs.add(new BasicNameValuePair("ttitle", t3));
                    pairs.add(new BasicNameValuePair("tabel", t4));
                    pairs.add(new BasicNameValuePair("tsubject", stringrate));

                    HttpClient client = new DefaultHttpClient();
                    HttpPost post = new HttpPost(url1);
                    post.setEntity(new UrlEncodedFormEntity(pairs,"utf-8"));
                    HttpResponse response = client.execute(post);
                }
                catch (ClientProtocolException e) {Toast.makeText(RewriteActivity.this, e.toString(), Toast.LENGTH_LONG).show(); return false;}
                catch (UnsupportedEncodingException e) {Toast.makeText(RewriteActivity.this, e.toString(), Toast.LENGTH_LONG).show();return false;}
                catch (IOException e) {Toast.makeText(RewriteActivity.this, e.toString(), Toast.LENGTH_LONG).show();return false;}
            }
            return true;
        }
        protected void onPostExecute(Boolean result) {
            if(result == true){Toast.makeText(RewriteActivity.this, "insert success", Toast.LENGTH_LONG).show();}
            else{Toast.makeText(RewriteActivity.this, "Error", Toast.LENGTH_LONG).show();}
            dia.dismiss();
        }



    }
}