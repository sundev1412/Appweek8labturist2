package cisw322.appweek8labturist;

import android.content.Intent;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
    } // oncreate

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
