package cisw322.appweek8labturist;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by suksun on 3/7/2017 AD.
 */

class CreateTable {
    private  Myconfigdb myconfigdb;
    private SQLiteDatabase writedb,readdb;
    /*
    (idno integer primary key,"+
                    "Typecat text,"+
                    "Title text,"+
                    "Urlpic1 text,"+
                    "Urlpic2 text,"+
                    "Urlpic3 text,"+
                    "Detail text,"+
                    "Lat text,"+
                    "Lng text)";
     */


    public static final String KALASIN_TABLE = "tbkalasin";
    public static final String COLUMN_IDNO = "idno";
    public static final String COLUMN_TYPECAT = "Typecat";
    public static final String COLUMN_TITLE = "Title";
    public static final String COLUMN_URLPIC1 = "Urlpic1";
    public static final String COLUMN_URLPIC2 = "Urlpic2";
    public static final String COLUMN_URLPIC3 = "Urlpic3";
    public static final String COLUMN_DETAIL = "detail";
    public static final String COLUMN_LAT = "Lat";
    public static final String COLUMN_LNG = "Lng";

    public CreateTable(Context context) {
        myconfigdb = new Myconfigdb(context);
        writedb = myconfigdb.getWritableDatabase();
        readdb = myconfigdb.getReadableDatabase();

    }

    public  long addtbkalasin(String strtypecat,String strtitle,String
                              strurlpic1,String strurlpic2,String strurlpic3,
                              String strdetail,String strlat,String strlng){

         ContentValues valeadd = new ContentValues();
        valeadd.put(COLUMN_TYPECAT, strtypecat);
        valeadd.put(COLUMN_TITLE, strtitle);
        valeadd.put(COLUMN_URLPIC1, strurlpic1);
        valeadd.put(COLUMN_URLPIC2, strurlpic2);
        valeadd.put(COLUMN_URLPIC3, strurlpic3);
        valeadd.put(COLUMN_DETAIL, strdetail);
        valeadd.put(COLUMN_LAT, strlat);
        valeadd.put(COLUMN_LNG, strlng);

        return writedb.insert(KALASIN_TABLE,null,valeadd);
    }
}
