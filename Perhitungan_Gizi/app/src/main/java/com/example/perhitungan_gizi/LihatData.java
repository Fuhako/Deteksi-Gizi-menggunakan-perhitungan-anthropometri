package com.example.perhitungan_gizi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LihatData extends AppCompatActivity {
    TextView nama, umur, BeratBadan, PanjangBadan, jk,statusbb,statuspb,statusbbtb,statusimt, pu;
    DataBaseHelper dbhelper;

    Button tampilData;
    long id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);
        dbhelper = new DataBaseHelper(this);

        id = getIntent().getLongExtra(DataBaseHelper.clm_id, 0);

        nama =  findViewById(R.id.nama);
        umur = findViewById(R.id.umur);
        BeratBadan = findViewById(R.id.beratbadan);
        PanjangBadan = findViewById(R.id.panjangbadan);
        jk = findViewById(R.id.jk);
        pu = findViewById(R.id.pu);
        statusbb = findViewById(R.id.statusbb);
        statuspb = findViewById(R.id.statuspb);
        statusbbtb = findViewById(R.id.statusbbtb);
        statusimt = findViewById(R.id.statusimt);
        tampilData = findViewById(R.id.tampildata);
        tampilData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LihatData. this, TampilkanData.class);
                startActivity(intent);
            }
        });

        getData(); //fungsinya yaitu mendapatkan data dari tampilan data yang di edit
    }

    private void getData(){
        Cursor cursor = dbhelper.oneData(id);

        if(cursor.moveToFirst()){
            String Nama = cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_nama));
            String Umur = cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_umur));
            String Bb = cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_bb));
            String Pb = cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_pb));
            String JK = cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_JenisKelamin));
            String PU = cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_PosisiUkur));
            String StatusBb = cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_statusbb));
            String StatusPb = cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_statuspb));
            String StatusBbTb = cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_statusbbtb));
            String StatusImt = cursor.getString(cursor.getColumnIndex(DataBaseHelper.clm_statusimt));
            nama.setText(Nama);
            umur.setText(Umur);
            BeratBadan.setText(Bb);
            PanjangBadan.setText(Pb);
            jk.setText(JK);
            pu.setText(PU);
            statusbb.setText(StatusBb);
            statuspb.setText(StatusPb);
            statusbbtb.setText(StatusBbTb);
            statusimt.setText(StatusImt);
        }
    }
    private boolean doubleBackToExitPressedOnce;
    private Handler mHandler = new Handler();

    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            doubleBackToExitPressedOnce = false;
        }
    };

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        if (mHandler != null) { mHandler.removeCallbacks(mRunnable); }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan Kembali untuk kembali", Toast.LENGTH_SHORT).show();

        mHandler.postDelayed(mRunnable, 2000);

    }
}
