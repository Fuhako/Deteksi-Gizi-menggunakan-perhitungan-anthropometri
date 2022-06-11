package com.example.perhitungan_gizi;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomCursorAdapter extends CursorAdapter {

    private LayoutInflater layoutInflater;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public CustomCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View v = layoutInflater.inflate(R.layout.row_data, viewGroup, false);
        MyHolder holder = new MyHolder();
        holder.ListID = (TextView)v.findViewById(R.id.listID);
        holder.ListNama = (TextView)v.findViewById(R.id.listNama);
        holder.ListUmur = (TextView)v.findViewById(R.id.ListUmur);
        holder.ListJenisKelamin = (TextView)v.findViewById(R.id.ListJk);
        v.setTag(holder);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        MyHolder holder = (MyHolder)view.getTag();

        holder.ListID.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_id)));
        holder.ListNama.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_nama)));
        holder.ListUmur.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_umur)));
        holder.ListJenisKelamin.setText(cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_JenisKelamin)));
    }

    class MyHolder{
        TextView ListID;
        TextView ListNama;
        TextView ListUmur;
        TextView ListJenisKelamin;
    }
}