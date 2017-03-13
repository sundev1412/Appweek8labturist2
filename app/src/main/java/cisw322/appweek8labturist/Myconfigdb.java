package cisw322.appweek8labturist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by suksun on 3/7/2017 AD.
 */

public class Myconfigdb extends SQLiteOpenHelper {
    //ประกาศตัวแปรฐานข้อมูล
    private static  final String dbname = "kalasindb.db";
    private  static  final int dbversion = 1;
    private  static  final String createtablekalasin =
            "create table tbkalasin(idno integer primary key,"+
                    "Typecat text,"+
                    "Title text,"+
                    "Urlpic1 text,"+
                    "Urlpic2 text,"+
                    "Urlpic3 text,"+
                    "Detail text,"+
                    "Lat text,"+
                    "Lng text)";
    public Myconfigdb(Context context) {
        super(context,dbname,null,dbversion);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createtablekalasin); //add new

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
