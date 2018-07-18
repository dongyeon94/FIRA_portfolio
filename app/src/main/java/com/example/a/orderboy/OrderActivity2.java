package com.example.a.orderboy;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

public class OrderActivity2 extends Activity {

    public String menu1="", menu2="", menu3="", menu4="";
    public String m1="", m2="", m3="", m4="";
    public int menu1_1=0, menu2_2=0, menu3_3=0, menu4_4=0;
    public int price1=0, price2=0, price3=0, price4=0;
    public String total="";
    public String TN;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);

        //번호 불러오기
        TextView TBN = (TextView) findViewById(R.id.TBN);
        Intent intent = getIntent();
        TN = intent.getStringExtra("TabelNum");
        TBN.setText(String.valueOf(TN));
    }











        // 음식 부과 설명
    public void onClick1(View v) {

        AlertDialog.Builder as = new AlertDialog.Builder(this);
        as.setTitle("김치찌개");
        as.setMessage("주재료 : 꽁치(꽁치 통조림) 280g, 배추김치 2컵(300g)\n" +
                "· 부재료 : 설탕 1작은술(3g), 청양고추 1개(10g), 다시마국물 2와 1/2컵(500ml), 마늘 1큰술(10g), 고춧가루 1큰술(5g), 소금(소금 약간), 대파 10cm(20g)\n" +
                "· 대체재료 : 꽁치 → 고등어, 오징어 (개인 기호에 맞춰 첨가하여 요리를 응용한다.)\n");
        as.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        as.show();
    }

    public void onClick2(View v) {

        AlertDialog.Builder as = new AlertDialog.Builder(this);
        as.setTitle("된장찌개");
        as.setMessage("주재료 : 꽁치(꽁치 통조림) 280g, 배추김치 2컵(300g)\n" +
                "· 부재료 : 설탕 1작은술(3g), 청양고추 1개(10g), 다시마국물 2와 1/2컵(500ml), 마늘 1큰술(10g), 고춧가루 1큰술(5g), 소금(소금 약간), 대파 10cm(20g)\n" +
                "· 대체재료 : 꽁치 → 고등어, 오징어 (개인 기호에 맞춰 첨가하여 요리를 응용한다.)\n");
        as.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        as.show();
    }

    public void onClick3(View v) {

        AlertDialog.Builder as = new AlertDialog.Builder(this);
        as.setTitle("부대찌개");
        as.setMessage("주재료 : 햄(통조림햄) 150g, 돼지고기(다진 돼지고기) 150g, 소시지 100g\n" +
                "· 부재료 : 양파 1/4개(50g), 마카로니(삶은 것) 1/3컵(30g), 콩 통조림 3큰술(30g), 김치 1컵(150g), 청주 1큰술(15ml), 떡국떡 1/2컵(50g), 대파 15cm(30g), 육수 재료(다시마 10×10cm(5g), 국물용 멸치 20마리(20g), 물 4컵(800ml)), 양념 재료(고춧가루 3큰술(15g), 고추장 1작은술(5g), 간장(재래간장) 1큰술(15ml), 마늘(다진 마늘) 1큰술(10g))\n" +
                "· 대체재료 : 돼지고기 → 쇠고기 (개인 기호에 맞춰 돼지고기 대신 쇠고기로 대체하여도 좋다.)\n");
        as.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        as.show();
    }


    public void onClick4(View v) {

        AlertDialog.Builder as = new AlertDialog.Builder(this);
        as.setTitle("순대국");
        as.setMessage("  주재료 : 순대 100g, 사골육수 4컵(800ml)\n" +
                "· 부재료 : 돼지고기(돼지 내장 삶은 것) 80g, 대파 20cm(40g), 들깻가루 2큰술(20g), 새우젓(새우젓 약간), 고춧가루 3큰술(15g), 표고버섯가루 약간, 재래간장 1작은술(5ml), 마늘(다진 마늘) 1큰술(10g), 생강즙(생강즙 약간), 후춧가루(후춧가루 약간), 양파즙(양파즙 약간)\n");
        as.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });

        as.show();
    }
    //O K 버튼
    public void onClick5(View v) {

        EditText text_id  = (EditText) findViewById(R.id.editText);
        menu1 = text_id .getText().toString();

        menu1_1= Integer.parseInt(menu1);

        AlertDialog.Builder as = new AlertDialog.Builder(this);
        as.setTitle("안내");
        as.setMessage("추가 되었습니다");
        as.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }
        );
        as.show();

        m1 = "김치찌개 가격:"+"7000"+"\n"+"수량"+menu1_1+"\n"+"가격"+7000*menu1_1;
        price1 =7000*menu1_1;

    }

    public void onClick6(View v) {
        EditText text_id2  = (EditText) findViewById(R.id.editText2);
        menu2 = text_id2 .getText().toString();

        menu2_2= Integer.parseInt(menu2);

        AlertDialog.Builder as = new AlertDialog.Builder(this);
        as.setTitle("안내");
        as.setMessage("추가 되었습니다");
        as.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }
        );
        as.show();

        m2 = "된장찌개 가격:"+"6000"+"\n"+"수량"+menu2_2+"\n"+"가격"+6000*menu2_2;
        price2 =6000*menu2_2;

    }

    public void onClick7(View v) {
        EditText text_id  = (EditText) findViewById(R.id.editText3);
        menu3 = text_id .getText().toString();
        menu3_3= Integer.parseInt(menu3);

        AlertDialog.Builder as = new AlertDialog.Builder(this);
        as.setTitle("안내");
        as.setMessage("추가 되었습니다");
        as.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }
        );
        as.show();

        m3 = "부대찌개 가격:"+"5500"+"\n"+"수량"+menu3_3+"\n"+"가격"+5500*menu3_3;
        price3 =5500*menu3_3;

    }

    public void onClick8(View v) {
        EditText text_id  = (EditText) findViewById(R.id.editText4);
        menu4 = text_id .getText().toString();
        menu4_4= Integer.parseInt(menu4);

        AlertDialog.Builder as = new AlertDialog.Builder(this);
        as.setTitle("안내");
        as.setMessage("추가 되었습니다");
        as.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                }
        );
        as.show();

        m4 = "순대국 가격:"+"5000"+"\n"+"수량"+menu4_4+"\n"+"가격"+5000*menu4_4;
        price4 =5000*menu4_4;

    }

    public void onClick9(View v) {
        Intent inc = new Intent(getApplicationContext(),OrPhotoActivity.class);
        startActivity(inc);
    }

    public void onClick10(View v){
        Intent ins = new Intent(getApplicationContext(),OrderActivity3.class);
        total = Integer.toString(price1+price2+price3+price4);
        ins.putExtra("menu1", m1);
        ins.putExtra("menu2", m2);
        ins.putExtra("menu3", m3);
        ins.putExtra("menu4", m4);
        ins.putExtra("price", total);

        Inser tt = new Inser();
        tt.execute(new String[]{"http://223.194.115.137/b2.php"});
        startActivity(ins);

    }

    private  class Inser extends AsyncTask<String, Void, Boolean> {
        ProgressDialog dia = new ProgressDialog(OrderActivity2.this);
        protected  void onPreExecute(){
            dia.setMessage("Sending Data");
            dia.show();
        }
        protected Boolean doInBackground(String... urls) {
            for(String url1 : urls){
                try{
                    ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair >();
                    pairs.add(new BasicNameValuePair("tabel", TN));
                    pairs.add(new BasicNameValuePair("kimchi", menu1));
                    pairs.add(new BasicNameValuePair("doenjang", menu2));
                    pairs.add(new BasicNameValuePair("budae", menu3));
                    pairs.add(new BasicNameValuePair("soondae", menu4));
                    pairs.add(new BasicNameValuePair("price", "123"));

                    HttpClient client = new DefaultHttpClient();
                    HttpPost post = new HttpPost(url1);
                    post.setEntity(new UrlEncodedFormEntity(pairs,"utf-8"));
                    HttpResponse response = client.execute(post);
                }
                catch (ClientProtocolException e) {
                    Toast.makeText(OrderActivity2.this, e.toString(), Toast.LENGTH_LONG).show(); return false;}
                catch (UnsupportedEncodingException e) {Toast.makeText(OrderActivity2.this, e.toString(), Toast.LENGTH_LONG).show();return false;}
                catch (IOException e) {Toast.makeText(OrderActivity2.this, e.toString(), Toast.LENGTH_LONG).show();return false;}
            }
            return true;
        }
        protected void onPostExecute(Boolean result) {
            if(result == true){Toast.makeText(OrderActivity2.this, "insert success", Toast.LENGTH_LONG).show();}
            else{Toast.makeText(OrderActivity2.this, "Error", Toast.LENGTH_LONG).show();}
            dia.dismiss();
        }



    }

}



