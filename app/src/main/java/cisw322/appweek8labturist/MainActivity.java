package cisw322.appweek8labturist;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //ประกาศตัวแปร
    private ImageView btnimage1,btnimage2;
    private  CreateTable createTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ผูกตัวแปรกับไอดี
        btnimage1 = (ImageView)findViewById(R.id.imageView);
        btnimage2 = (ImageView)findViewById(R.id.imageView2);

        // เชื่อมต่อฐานข้อมูล
        createTable = new CreateTable(this);

        // ดักเหตุการณ์คลิกที่ภาพ
        btnimage1.setOnClickListener(this);
        btnimage2.setOnClickListener(this);

        Synjson synjson = new Synjson(this);
        synjson.execute();

    } // oncreate

    private  class Synjson extends AsyncTask<Void,Void,String>{
        private Context context;
        private  static final String urltablejson = "http://suksun.biz/appkalasin/jsontbkalasin.php";
        public Synjson(Context context){
            this.context = context;
        } //constructor
        @Override
        protected String doInBackground(Void... voids) {
            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urltablejson).build();

                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();
            } catch (Exception e) {
                Log.d("testlog1", "error inbackground ==> " + e.toString());
                return null;
            }
        }// background

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {

                JSONArray objJsonArray = new JSONArray(s);
                for (int i = 0; i < objJsonArray.length(); i++) {

                    JSONObject object = objJsonArray.getJSONObject(i);

                    String strtypecat = object.getString("Typecat");
                    String strtitle = object.getString("Title");
                    String strurlpic1 = object.getString("Urlpic1");
                    String strurlpic2 = object.getString("Urlpic2");
                    String strurlpic3 = object.getString("Urlpic3");
                    String strdetail = object.getString("Detail");
                    String strlat = object.getString("Lat");
                    String strlng = object.getString("Lng");

                    createTable.addtbkalasin(strtypecat, strtitle,
                            strurlpic1, strurlpic2, strurlpic3, strdetail,
                            strlat, strlng);

                }// onpostex
            }catch(JSONException e){
                    e.printStackTrace();
                }
            }
        }

    @Override
    public void onClick(View v) {
          String strtype = "Hotel";
        switch (v.getId()){
            case R.id.imageView:
                strtype = "Hotel";
                break;
            case R.id.imageView2:
                strtype ="Res";
                break;
            //ถ้ามีปุ่มเพิ่มค่อยใส่เพิ่มได้
        }
//สั่งให้ไปอีกหน้าโชว์แต่ละประเภท
        Intent gotoact = new Intent(MainActivity.this,KalasinListView.class);
        gotoact.putExtra("strtype",strtype);
        startActivity(gotoact);
    }//onclick
} //mainactivity
