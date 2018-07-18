package com.example.a.orderboy;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by A on 2015-08-03.
 */
public class ReviewActivity extends Activity implements AdapterView.OnItemClickListener {
    ListView listss;
    ImageButton iv;
    BufferedReader reader;
    String  error=null;
    String view[]={"","","","","","","","","","","",""};
    String head[]={"","","","","","","","","","","",""};
    int val[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        iv = (ImageButton)findViewById(R.id.imageButton);
        listss = (ListView)findViewById(R.id.lis);



    }
    public void a(View v){
        Intent ss1 = new Intent(ReviewActivity.this, RewriteActivity.class);
        startActivity(ss1);
    }
    public void a1(View v){
        ReadData t1 = new ReadData();
        t1.execute(new String[]{"http://223.194.115.137/readjson2.php"});
    }
    private class ReadData extends AsyncTask<String, Void, String>{
        String text="";
        private InputStream is1;
        ArrayList<String> list1;
        String line="";


        ProgressDialog dia = new ProgressDialog(ReviewActivity.this);
        protected  void onPreExecute(){
            dia.setMessage("Reading Data");
            dia.show();
        }
        protected String doInBackground(String... params) {
            for(String url1 : params) {
                try {
                    HttpClient client = new DefaultHttpClient();
                    HttpPost post = new HttpPost(url1);
                    HttpResponse response = client.execute(post);
                    is1 = response.getEntity().getContent();
                } catch (ClientProtocolException e) {
                    Toast.makeText(ReviewActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                    error = "ClientProtocolException:" + e.getMessage();
                }  catch (IOException e) {
                    Toast.makeText(ReviewActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                    error = "ClientProtocolException:" + e.getMessage();
                }

                try {
                    reader = new BufferedReader(new InputStreamReader(is1, "iso-8859-1"),8);

                    while ((line = reader.readLine()) != null) {
                        text = line + "\n";
                    }
                    is1.close();

                } catch (UnsupportedEncodingException e) {
                    error = "Unsuppor Encoding:" + e.getMessage();
                } catch (IOException e) {
                    error = "Error IO:" + e.getMessage();
                }


                list1  = new ArrayList<String>();
                try {
                    JSONArray ja = new JSONArray(text);
                    for(int i=0;i<ja.length();i++){
                        JSONObject jo = ja.getJSONObject(i);
                        list1.add(jo.getString("pro_name")+"\n"+"별점"+jo.getString("qty"));
                        view[i]=(jo.getString("tex"));
                        head[i]=jo.getString("pro_name");
                        String as = jo.getString("qty");
                        val[i] = Integer.parseInt(as);
                    }
                } catch (JSONException e) {
                    error ="Error Convert to JSON or Error JSON Format." + e.getMessage();
                }
            }
            return error;
        }

        protected void onPostExecute(String result) {
            if(dia.isShowing()){
                dia.dismiss();
            }
            if(result != null){
                Toast.makeText(ReviewActivity.this , error, Toast.LENGTH_LONG).show();
            }
            else{

                ArrayAdapter<String> adap1 = new ArrayAdapter(
                        ReviewActivity.this,
                        android.R.layout.simple_list_item_1,
                        list1);
                listss.setAdapter(adap1);
                listss.setOnItemClickListener(ReviewActivity.this);
            }
        }


    }
    public void onItemClick(AdapterView<?> parentView, View clickedView, int position, long id){
        AlertDialog.Builder as = new AlertDialog.Builder(this);
        as.setTitle(head[position]);
        as.setMessage(view[position] + "\n" + "별점" + val[position]);
        as.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        as.show();
    }
}