package cisw322.appweek8labturist;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;

import static cisw322.appweek8labturist.R.styleable.View;

public class KalasinListView extends AppCompatActivity {

    private String[] typecatstr, titlestr,
            urlpic1str, urlpic2str, urlpic3str,
            detailstr, latstr, lngstr;
    ListView listview11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalasin_list_view);

        makelistview();

    }//oncreate

    private void makelistview() {
        final String strtype = getIntent().getStringExtra("strtype");

        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("kalasindb.db", MODE_PRIVATE, null);
        final Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM tbkalasin WHERE Typecat = " + "'" + strtype + "'", null);


        //Read All Data

        objCursor.moveToFirst();
        int intCursor = objCursor.getCount();
        typecatstr = new String[intCursor];
        titlestr = new String[intCursor];
        urlpic1str = new String[intCursor];
        urlpic2str = new String[intCursor];
        urlpic3str = new String[intCursor];
        detailstr = new String[intCursor];
        latstr = new String[intCursor];
        lngstr = new String[intCursor];

        for (int i = 0; i < intCursor; i++) {

            typecatstr[i] = objCursor.getString(objCursor.getColumnIndex("Typecat"));
            titlestr[i] = objCursor.getString(objCursor.getColumnIndex("Title"));
            urlpic1str[i] = objCursor.getString(objCursor.getColumnIndex("Urlpic1"));
            urlpic2str[i] = objCursor.getString(objCursor.getColumnIndex("Urlpic2"));
            urlpic3str[i] = objCursor.getString(objCursor.getColumnIndex("Urlpic3"));
            detailstr[i] = objCursor.getString(objCursor.getColumnIndex("Detail"));
            latstr[i] = objCursor.getString(objCursor.getColumnIndex("Lat"));
            lngstr[i] = objCursor.getString(objCursor.getColumnIndex("Lng"));

            objCursor.moveToNext();

        }   // for

        objCursor.close();

        MyAdapter myadt = new MyAdapter(KalasinListView.this, titlestr, detailstr, urlpic1str);
         listview11 = (ListView) findViewById(R.id.listviewnew);
        listview11.setAdapter(myadt);


    }

}//main
