package cisw322.appweek8labturist;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by suksun on 3/7/2017 AD.
 */

public class Myconfigdb extends SQLiteDatabase {
    //ประกาศตัวแปรฐานข้อมูล
    private static  final String dbname = "kalasindb.db";
    private  static  final int dbversion = 1;
    private  static  final String createtablekalasin =
            "create table kalasintable(idno integer primary key,"+
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




}
