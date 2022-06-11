package com.example.perhitungan_gizi;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
//    private static final int database_version = 2;
    private static final String database_name = "DB_Posyandu";
    private static final String table_name = "PerhitunganGizi";
    private static final String table_user = "t_user";


    public static final String clm_id = "_id";
    public static final String clm_nama = "Nama";
    public static final String clm_umur = "Umur";
    public static final String clm_bb = "BeratBadan";
    public static final String clm_pb = "PanjangBadan";
    public static final String clm_JenisKelamin = "JK";
    public static final String clm_PosisiUkur = "PosisiUkur";
    public static final String clm_statusbb = "HasilBBu";
    public static final String clm_statuspb = "HasilPBuatauTBu";
    public static final String clm_statusbbtb = "HasilBBTB";
    public static final String clm_statusimt = "HasilIMTu";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "username";
    public static final String COL_3 = "password";
    private SQLiteDatabase db;

    public DataBaseHelper(Context context) {
        super(context, database_name, null, 2);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE " + table_name + "(" + clm_id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + clm_nama + " TEXT," + clm_umur + " TEXT," + clm_bb + " TEXT," + clm_pb + " TEXT,"
                + clm_JenisKelamin + " TEXT," + clm_PosisiUkur + " TEXT," + clm_statusbb + " TEXT,"
                + clm_statuspb + " TEXT," + clm_statusbbtb + " TEXT," + clm_statusimt + " TEXT" + ")";
        String tabeluser = " CREATE TABLE " + table_user + "(" + COL_1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_2 + " TEXT," + COL_3 + " TEXT" + ")";
        db.execSQL(tabeluser);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int x) {
        db.execSQL("DROP TABLE IF EXISTS " + table_name);
        db.execSQL("DROP TABLE IF EXISTS " + table_user);
    }

    public long addUser(String user, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",user);
        contentValues.put("password",password);
        long res = db.insert("t_user",null, contentValues);
        db.close();
        return res;
    }

    public boolean checkUser(String username, String password){
        String[] columns = {COL_1};
        SQLiteDatabase db =  getReadableDatabase();
        String selection = COL_2 + "=?" + " and " + COL_3 + "=?";
        String[] selectionArgs = { username, password };
        Cursor cursor = db.query(table_user,columns,selection,selectionArgs,null, null, null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count > 0)
            return true;
        else
            return false;
    }

    //Get All SQLite Data
    public Cursor allData(){
        Cursor cur = db.rawQuery("SELECT * FROM " + table_name , null);
        return cur;
    }

    //Get 1 Data By ID
    public Cursor oneData(Long id){
        Cursor cur = db.rawQuery("SELECT * FROM " + table_name + " WHERE " + clm_id + "=" + id, null);
        return cur;
    }

    //Insert Data to Database
    public void insertData(ContentValues values){

        db.insert(table_name, null, values);
    }

    //Update Data
    public void updateData(ContentValues values, long id){
        db.update(table_name, values, clm_id + "=" + id, null);
    }

    //Delete Data
    public void deleteData(long id){

        db.delete(table_name, clm_id + "=" + id, null);
    }
}
