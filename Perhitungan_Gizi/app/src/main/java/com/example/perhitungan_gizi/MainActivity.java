package com.example.perhitungan_gizi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import android.content.ContentValues;
import android.content.Intent;

import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editText_Nama, editText_Umur, editText_BeratBadan, editText_PanjangBadan;
    DataBaseHelper dbhelper;
    String vHasilBB, vHasilPb, vHasilBBTB, vHasilIMT, imt;
    TextView statusbb, statuspb, statusbbtb, statusimt;
    Spinner jeniskelamin, posisiukur;
    Button hitung, clear, tampilData, button;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper = new DataBaseHelper(this);


        id = getIntent().getLongExtra(DataBaseHelper.clm_id, 0);
        editText_Nama = findViewById(R.id.edNama);
        editText_Umur = findViewById(R.id.edUmur);
        editText_BeratBadan = findViewById(R.id.edBb);
        editText_PanjangBadan = findViewById(R.id.edPb);
        jeniskelamin = findViewById(R.id.spinnerJK);
        hitung = findViewById(R.id.btnHitung);
        posisiukur = findViewById(R.id.spinnerPU);
        statusbb = findViewById(R.id.statusBb);
        statuspb = findViewById(R.id.statusPb);
        statusbbtb = findViewById(R.id.statusBbTb);
        statusimt = findViewById(R.id.statusImt);
        tampilData = (Button) findViewById(R.id.tampildata);
        tampilData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TampilkanData.class);
                startActivity(intent);
            }
        });
        clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                CLEAR();
            }
        });
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database();
            }
        });
        hitung.setOnClickListener(v -> {

            int umur = Integer.valueOf(editText_Umur.getText().toString());
            float Bb = Float.valueOf(editText_BeratBadan.getText().toString());
            float Pb = Float.valueOf(editText_PanjangBadan.getText().toString());
            float bbm, bbu = 0, pbm, pbu = 0, BbTbm, HBbTbm = 0, imtm = 0, himt, imt;


            // BB/U
            if (jeniskelamin.getSelectedItem().toString().equals("Laki laki")) {
                switch (umur) {
                    case 0:
                        bbm = (float) (Bb - 3.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 3.3) / (3.3 - 2.9));

                        } else {
                            bbu = (float) ((Bb - 3.3) / (3.9 - 3.3));
                        }
                        break;
                    case 1:
                        bbm = (float) (Bb - 4.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 4.5) / (4.5 - 3.9));
                        } else {
                            bbu = (float) ((Bb - 4.5) / (5.1 - 4.5));
                        }
                        break;
                    case 2:
                        bbm = (float) (Bb - 5.6);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 5.6) / (5.6 - 4.9));
                        } else {
                            bbu = (float) ((Bb - 5.6) / (6.3 - 5.6));
                        }
                        break;
                    case 3:
                        bbm = (float) (Bb - 6.4);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 6.4) / (6.4 - 5.7));
                        } else {
                            bbu = (float) ((Bb - 6.4) / (7.2 - 6.4));
                        }
                        break;
                    case 4:
                        bbm = (float) (Bb - 7.0);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 7.0) / (7.0 - 6.2));
                        } else {
                            bbu = (float) ((Bb - 7.0) / (7.8 - 7.0));
                        }
                        break;
                    case 5:
                        bbm = (float) (Bb - 7.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 7.5) / (7.5 - 6.7));
                        } else {
                            bbu = (float) ((Bb - 7.5) / (8.4 - 7.5));
                        }
                        break;
                    case 6:
                        bbm = (float) (Bb - 7.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 7.9) / (7.9 - 7.1));
                        } else {
                            bbu = (float) ((Bb - 7.9) / (8.8 - 7.9));
                        }
                        break;
                    case 7:
                        bbm = (float) (Bb - 8.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 8.3) / (8.3 - 7.4));
                        } else {
                            bbu = (float) ((Bb - 8.3) / (9.2 - 8.3));
                        }
                        break;
                    case 8:
                        bbm = (float) (Bb - 8.6);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 8.6) / (8.6 - 7.7));
                        } else {
                            bbu = (float) ((Bb - 8.6) / (9.6 - 8.6));
                        }
                        break;
                    case 9:
                        bbm = (float) (Bb - 8.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 8.9) / (8.9 - 8.0));
                        } else {
                            bbu = (float) ((Bb - 8.9) / (9.9 - 8.9));
                        }
                        break;
                    case 10:
                        bbm = (float) (Bb - 9.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 9.2) / (9.2 - 8.2));
                        } else {
                            bbu = (float) ((Bb - 9.2) / (10.2 - 9.2));
                        }
                        break;
                    case 11:
                        bbm = (float) (Bb - 9.4);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 9.4) / (9.4 - 8.5));
                        } else {
                            bbu = (float) ((Bb - 9.4) / (10.5 - 9.4));
                        }
                        break;
                    case 12:
                        bbm = (float) (Bb - 9.6);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 9.6) / (9.6 - 8.6));
                        } else {
                            bbu = (float) ((Bb - 9.6) / (10.8 - 9.6));
                        }
                        break;
                    case 13:
                        bbm = (float) (Bb - 9.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 9.9) / (9.9 - 8.8));
                        } else {
                            bbu = (float) ((Bb - 9.9) / (11.0 - 9.9));
                        }
                        break;
                    case 14:
                        bbm = (float) (Bb - 10.1);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 10.1) / (10.1 - 9.0));
                        } else {
                            bbu = (float) ((Bb - 10.1) / (11.3 - 10.1));
                        }
                        break;
                    case 15:
                        bbm = (float) (Bb - 10.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 10.3) / (10.3 - 9.2));
                        } else {
                            bbu = (float) ((Bb - 10.3) / (11.5 - 10.3));
                        }
                        break;
                    case 16:
                        bbm = (float) (Bb - 10.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 10.5) / (10.5 - 9.4));
                        } else {
                            bbu = (float) ((Bb - 10.5) / (9.4 - 10.5));
                        }
                        break;
                    case 17:
                        bbm = (float) (Bb - 10.7);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 10.7) / (10.7 - 9.6));
                        } else {
                            bbu = (float) ((Bb - 10.7) / (12.0 - 10.7));
                        }
                        break;
                    case 18:
                        bbm = (float) (Bb - 10.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 10.9) / (10.9 - 9.8));
                        } else {
                            bbu = (float) ((Bb - 10.9) / (12.2 - 10.9));
                        }
                        break;
                    case 19:
                        bbm = (float) (Bb - 11.1);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 11.1) / (11.1 - 10.0));
                        } else {
                            bbu = (float) ((Bb - 11.1) / (12.5 - 11.1));
                        }
                        break;
                    case 20:
                        bbm = (float) (Bb - 11.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 11.3) / (11.3 - 10.1));
                        } else {
                            bbu = (float) ((Bb - 11.3) / (12.7 - 11.3));
                        }
                        break;
                    case 21:
                        bbm = (float) (Bb - 11.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 11.5) / (11.5 - 10.3));
                        } else {
                            bbu = (float) ((Bb - 11.5) / (12.9 - 11.5));
                        }
                        break;
                    case 22:
                        bbm = (float) (Bb - 11.8);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 11.8) / (11.8 - 10.5));
                        } else {
                            bbu = (float) ((Bb - 11.8) / (13.2 - 11.8));
                        }
                        break;
                    case 23:
                        bbm = (float) (Bb - 12.0);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 12.0) / (12.0 - 10.7));
                        } else {
                            bbu = (float) ((Bb - 12.0) / (13.4 - 12.0));
                        }
                        break;
                    case 24:
                        bbm = (float) (Bb - 12.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 12.2) / (12.2 - 10.8));
                        } else {
                            bbu = (float) ((Bb - 12.2) / (13.6 - 12.2));
                        }
                        break;
                    case 25:
                        bbm = (float) (Bb - 12.4);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 12.4) / (12.4 - 11.0));
                        } else {
                            bbu = (float) ((Bb - 12.4) / (13.9 - 12.4));
                        }
                        break;
                    case 26:
                        bbm = (float) (Bb - 12.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 12.5) / (12.5 - 11.2));
                        } else {
                            bbu = (float) ((Bb - 12.5) / (14.1 - 12.5));
                        }
                        break;
                    case 27:
                        bbm = (float) (Bb - 12.7);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 12.7) / (12.7 - 11.3));
                        } else {
                            bbu = (float) ((Bb - 12.7) / (14.3 - 12.7));
                        }
                        break;
                    case 28:
                        bbm = (float) (Bb - 12.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 12.9) / (12.9 - 11.5));
                        } else {
                            bbu = (float) ((Bb - 12.9) / (14.5 - 12.9));
                        }
                        break;
                    case 29:
                        bbm = (float) (Bb - 13.1);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 13.1) / (13.1 - 11.7));
                        } else {
                            bbu = (float) ((Bb - 13.1) / (14.8 - 13.1));
                        }
                        break;
                    case 30:
                        bbm = (float) (Bb - 13.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 13.3) / (13.3 - 11.8));
                        } else {
                            bbu = (float) ((Bb - 13.3) / (15.0 - 13.3));
                        }
                        break;
                    case 31:
                        bbm = (float) (Bb - 13.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 13.5) / (13.5 - 12.0));
                        } else {
                            bbu = (float) ((Bb - 13.5) / (15.2 - 13.5));
                        }
                        break;
                    case 32:
                        bbm = (float) (Bb - 13.7);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 13.7) / (13.7 - 12.1));
                        } else {
                            bbu = (float) ((Bb - 13.7) / (15.4 - 13.7));
                        }
                        break;
                    case 33:
                        bbm = (float) (Bb - 13.8);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 13.8) / (13.8 - 12.3));
                        } else {
                            bbu = (float) ((Bb - 13.8) / (15.6 - 13.8));
                        }
                        break;
                    case 34:
                        bbm = (float) (Bb - 14.0);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 14.0) / (14.0 - 12.4));
                        } else {
                            bbu = (float) ((Bb - 14.0) / (15.8 - 14.0));
                        }
                        break;
                    case 35:
                        bbm = (float) (Bb - 14.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 14.2) / (14.2 - 12.6));
                        } else {
                            bbu = (float) ((Bb - 14.0) / (16.0 - 14.2));
                        }
                        break;
                    case 36:
                        bbm = (float) (Bb - 14.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 14.3) / (14.3 - 12.7));
                        } else {
                            bbu = (float) ((Bb - 14.3) / (16.2 - 14.3));
                        }
                        break;
                    case 37:
                        bbm = (float) (Bb - 14.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 14.5) / (14.5 - 12.9));
                        } else {
                            bbu = (float) ((Bb - 14.5) / (16.4 - 14.5));
                        }
                        break;
                    case 38:
                        bbm = (float) (Bb - 14.7);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 14.7) / (14.7 - 13.0));
                        } else {
                            bbu = (float) ((Bb - 14.7) / (16.6 - 14.7));
                        }
                        break;
                    case 39:
                        bbm = (float) (Bb - 14.8);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 14.8) / (14.8 - 13.1));
                        } else {
                            bbu = (float) ((Bb - 14.8) / (16.8 - 14.9));
                        }
                        break;
                    case 40:
                        bbm = (float) (Bb - 15.0);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 15.0) / (15.0 - 13.3));
                        } else {
                            bbu = (float) ((Bb - 15.0) / (17.0 - 15.0));
                        }
                        break;
                    case 41:
                        bbm = (float) (Bb - 15.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 15.2) / (15.2 - 13.4));
                        } else {
                            bbu = (float) ((Bb - 15.2) / (17.2 - 15.2));
                        }
                        break;
                    case 42:
                        bbm = (float) (Bb - 15.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 15.3) / (15.3 - 13.6));
                        } else {
                            bbu = (float) ((Bb - 15.3) / (17.4 - 15.3));
                        }
                        break;
                    case 43:
                        bbm = (float) (Bb - 15.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 15.5) / (15.5 - 13.7));
                        } else {
                            bbu = (float) ((Bb - 15.5) / (17.6 - 15.5));
                        }
                        break;
                    case 44:
                        bbm = (float) (Bb - 15.7);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 15.7) / (15.7 - 13.8));
                        } else {
                            bbu = (float) ((Bb - 15.7) / (17.8 - 15.7));
                        }
                        break;
                    case 45:
                        bbm = (float) (Bb - 15.8);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 15.8) / (15.8 - 14.0));
                        } else {
                            bbu = (float) ((Bb - 15.8) / (18.0 - 15.8));
                        }
                        break;
                    case 46:
                        bbm = (float) (Bb - 16.0);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 16.0) / (16.0 - 14.1));
                        } else {
                            bbu = (float) ((Bb - 16.0) / (18.2 - 16.0));
                        }
                        break;
                    case 47:
                        bbm = (float) (Bb - 16.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 16.2) / (16.2 - 14.3));
                        } else {
                            bbu = (float) ((Bb - 16.2) / (18.4 - 16.2));
                        }
                        break;
                    case 48:
                        bbm = (float) (Bb - 16.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 16.3) / (16.3 - 14.4));
                        } else {
                            bbu = (float) ((Bb - 16.3) / (18.6 - 16.3));
                        }
                        break;
                    case 49:
                        bbm = (float) (Bb - 16.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 16.5) / (16.5 - 14.5));
                        } else {
                            bbu = (float) ((Bb - 16.5) / (18.8 - 16.5));
                        }
                        break;
                    case 50:
                        bbm = (float) (Bb - 16.7);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 16.7) / (16.7 - 14.7));
                        } else {
                            bbu = (float) ((Bb - 16.7) / (19.0 - 16.7));
                        }
                        break;
                    case 51:
                        bbm = (float) (Bb - 16.8);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 16.8) / (16.8 - 14.8));
                        } else {
                            bbu = (float) ((Bb - 16.8) / (19.2 - 16.8));
                        }
                        break;
                    case 52:
                        bbm = (float) (Bb - 17.0);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 17.0) / (17.0 - 15.0));
                        } else {
                            bbu = (float) ((Bb - 17.0) / (19.4 - 17.0));
                        }
                        break;
                    case 53:
                        bbm = (float) (Bb - 17.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 17.2) / (17.2 - 15.1));
                        } else {
                            bbu = (float) ((Bb - 17.2) / (19.6 - 17.2));
                        }
                        break;
                    case 54:
                        bbm = (float) (Bb - 17.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 17.3) / (17.3 - 15.2));
                        } else {
                            bbu = (float) ((Bb - 17.3) / (19.8 - 17.3));
                        }
                        break;
                    case 55:
                        bbm = (float) (Bb - 17.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 17.5) / (17.5 - 15.4));
                        } else {
                            bbu = (float) ((Bb - 17.5) / (20.0 - 17.5));
                        }
                        break;
                    case 56:
                        bbm = (float) (Bb - 17.7);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 17.7) / (17.7 - 15.5));
                        } else {
                            bbu = (float) ((Bb - 17.7) / (20.2 - 17.7));
                        }
                        break;
                    case 57:
                        bbm = (float) (Bb - 17.8);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 17.8) / (17.8 - 15.6));
                        } else {
                            bbu = (float) ((Bb - 17.8) / (20.4 - 17.8));
                        }
                        break;
                    case 58:
                        bbm = (float) (Bb - 18.0);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 18.0) / (18.0 - 15.8));
                        } else {
                            bbu = (float) ((Bb - 18.0) / (20.6 - 18.0));
                        }
                        break;
                    case 59:
                        bbm = (float) (Bb - 18.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 18.2) / (18.2 - 15.9));
                        } else {
                            bbu = (float) ((Bb - 18.2) / (20.8 - 18.2));
                        }
                        break;
                    case 60:
                        bbm = (float) (Bb - 18.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 18.3) / (18.3 - 16.0));
                        } else {
                            bbu = (float) ((Bb - 18.3) / (21.0 - 18.3));
                        }
                        break;
                }
            }

            //Data Untuk Perempuan
            else if (jeniskelamin.getSelectedItem().toString().equals("Perempuan")) {
                switch (umur) {
                    case 0:
                        bbm = (float) (Bb - 3.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 3.2) / (3.2 - 2.8));
                        } else {
                            bbu = (float) ((Bb - 3.2) / (3.7 - 3.2));
                        }
                        break;
                    case 1:
                        bbm = (float) (Bb - 4.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 4.2) / (4.2 - 3.6));
                        } else {
                            bbu = (float) ((Bb - 4.2) / (4.8 - 4.2));
                        }
                        break;
                    case 2:
                        bbm = (float) (Bb - 5.1);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 5.1) / (5.1 - 4.5));
                        } else {
                            bbu = (float) ((Bb - 5.1) / (5.8 - 5.1));
                        }
                        break;
                    case 3:
                        bbm = (float) (Bb - 5.8);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 5.8) / (5.8 - 5.2));
                        } else {
                            bbu = (float) ((Bb - 5.8) / (6.6 - 5.8));
                        }
                        break;
                    case 4:
                        bbm = (float) (Bb - 6.4);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 6.4) / (6.4 - 5.7));
                        } else {
                            bbu = (float) ((Bb - 6.4) / (7.3 - 6.4));
                        }
                        break;
                    case 5:
                        bbm = (float) (Bb - 6.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 6.9) / (6.9 - 6.1));
                        } else {
                            bbu = (float) ((Bb - 6.9) / (7.8 - 6.9));
                        }
                        break;
                    case 6:
                        bbm = (float) (Bb - 7.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 7.3) / (7.3 - 6.5));
                        } else {
                            bbu = (float) ((Bb - 7.3) / (8.2 - 7.3));
                        }
                        break;
                    case 7:
                        bbm = (float) (Bb - 7.6);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 7.6) / (7.6 - 6.8));
                        } else {
                            bbu = (float) ((Bb - 8.3) / (8.6 - 7.6));
                        }
                        break;
                    case 8:
                        bbm = (float) (Bb - 7.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 7.9) / (7.9 - 7.0));
                        } else {
                            bbu = (float) ((Bb - 7.9) / (9.0 - 7.9));
                        }
                        break;
                    case 9:
                        bbm = (float) (Bb - 8.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 8.2) / (8.2 - 7.3));
                        } else {
                            bbu = (float) ((Bb - 8.2) / (9.3 - 8.2));
                        }
                        break;
                    case 10:
                        bbm = (float) (Bb - 8.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 8.5) / (8.5 - 7.5));
                        } else {
                            bbu = (float) ((Bb - 8.5) / (9.6 - 8.5));
                        }
                        break;
                    case 11:
                        bbm = (float) (Bb - 8.7);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 8.7) / (8.7 - 7.7));
                        } else {
                            bbu = (float) ((Bb - 8.7) / (9.9 - 8.7));
                        }
                        break;
                    case 12:
                        bbm = (float) (Bb - 8.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 8.9) / (8.9 - 7.9));
                        } else {
                            bbu = (float) ((Bb - 8.9) / (10.1 - 8.9));
                        }
                        break;
                    case 13:
                        bbm = (float) (Bb - 9.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 9.2) / (9.2 - 8.1));
                        } else {
                            bbu = (float) ((Bb - 9.2) / (10.4 - 9.2));
                        }
                        break;
                    case 14:
                        bbm = (float) (Bb - 9.4);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 9.4) / (9.4 - 8.4));
                        } else {
                            bbu = (float) ((Bb - 9.4) / (10.6 - 9.4));
                        }
                        break;
                    case 15:
                        bbm = (float) (Bb - 9.6);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 9.6) / (9.6 - 8.5));
                        } else {
                            bbu = (float) ((Bb - 9.6) / (10.6 - 9.6));
                        }
                        break;
                    case 16:
                        bbm = (float) (Bb - 9.8);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 9.8) / (9.8 - 8.7));
                        } else {
                            bbu = (float) ((Bb - 9.8) / (11.1 - 9.8));
                        }
                        break;
                    case 17:
                        bbm = (float) (Bb - 10.0);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 10.0) / (10.0 - 8.9));
                        } else {
                            bbu = (float) ((Bb - 10.0) / (11.4 - 10.0));
                        }
                        break;
                    case 18:
                        bbm = (float) (Bb - 10.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 10.2) / (10.2 - 9.1));
                        } else {
                            bbu = (float) ((Bb - 10.2) / (11.6 - 10.2));
                        }
                        break;
                    case 19:
                        bbm = (float) (Bb - 10.4);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 10.4) / (10.4 - 9.2));
                        } else {
                            bbu = (float) ((Bb - 10.4) / (11.8 - 10.4));
                        }
                        break;
                    case 20:
                        bbm = (float) (Bb - 10.6);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 10.6) / (10.6 - 9.4));
                        } else {
                            bbu = (float) ((Bb - 10.6) / (12.1 - 10.6));
                        }
                        break;
                    case 21:
                        bbm = (float) (Bb - 10.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 10.9) / (10.9 - 9.6));
                        } else {
                            bbu = (float) ((Bb - 10.9) / (12.3 - 10.9));
                        }
                        break;
                    case 22:
                        bbm = (float) (Bb - 11.1);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 11.1) / (11.1 - 10.0));
                        } else {
                            bbu = (float) ((Bb - 11.1) / (12.5 - 11.1));
                        }
                        break;
                    case 23:
                        bbm = (float) (Bb - 11.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 11.3) / (11.3 - 10.0));
                        } else {
                            bbu = (float) ((Bb - 11.3) / (12.8 - 11.3));
                        }
                        break;
                    case 24:
                        bbm = (float) (Bb - 11.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 11.5) / (11.5 - 10.2));
                        } else {
                            bbu = (float) ((Bb - 11.5) / (13.0 - 11.5));
                        }
                        break;
                    case 25:
                        bbm = (float) (Bb - 11.7);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 11.7) / (11.7 - 10.3));
                        } else {
                            bbu = (float) ((Bb - 11.7) / (13.3 - 11.7));
                        }
                        break;
                    case 26:
                        bbm = (float) (Bb - 11.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 11.9) / (11.9 - 10.5));
                        } else {
                            bbu = (float) ((Bb - 11.9) / (13.5 - 11.9));
                        }
                        break;
                    case 27:
                        bbm = (float) (Bb - 12.1);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 12.1) / (12.1 - 10.7));
                        } else {
                            bbu = (float) ((Bb - 12.1) / (13.7 - 12.1));
                        }
                        break;
                    case 28:
                        bbm = (float) (Bb - 12.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 12.3) / (12.3 - 10.9));
                        } else {
                            bbu = (float) ((Bb - 12.3) / (14.0 - 12.3));
                        }
                        break;
                    case 29:
                        bbm = (float) (Bb - 12.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 12.5) / (12.5 - 11.1));
                        } else {
                            bbu = (float) ((Bb - 12.5) / (14.2 - 12.5));
                        }
                        break;
                    case 30:
                        bbm = (float) (Bb - 12.7);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 12.7) / (12.7 - 11.2));
                        } else {
                            bbu = (float) ((Bb - 12.7) / (14.4 - 12.7));
                        }
                        break;
                    case 31:
                        bbm = (float) (Bb - 12.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 12.9) / (12.9 - 11.4));
                        } else {
                            bbu = (float) ((Bb - 12.9) / (14.7 - 12.9));
                        }
                        break;
                    case 32:
                        bbm = (float) (Bb - 13.1);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 13.1) / (13.1 - 11.6));
                        } else {
                            bbu = (float) ((Bb - 13.1) / (14.9 - 13.1));
                        }
                        break;
                    case 33:
                        bbm = (float) (Bb - 13.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 13.3) / (13.3 - 11.7));
                        } else {
                            bbu = (float) ((Bb - 13.3) / (15.1 - 13.3));
                        }
                        break;
                    case 34:
                        bbm = (float) (Bb - 13.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 13.5) / (13.5 - 11.9));
                        } else {
                            bbu = (float) ((Bb - 13.5) / (15.4 - 13.5));
                        }
                        break;
                    case 35:
                        bbm = (float) (Bb - 13.7);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 13.7) / (13.7 - 12.0));
                        } else {
                            bbu = (float) ((Bb - 13.7) / (15.6 - 13.7));
                        }
                        break;
                    case 36:
                        bbm = (float) (Bb - 113.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 13.9) / (13.9 - 12.2));
                        } else {
                            bbu = (float) ((Bb - 13.9) / (15.8 - 13.9));
                        }
                        break;
                    case 37:
                        bbm = (float) (Bb - 14.0);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 14.0) / (14.0 - 12.4));
                        } else {
                            bbu = (float) ((Bb - 14.0) / (16.0 - 14.0));
                        }
                        break;
                    case 38:
                        bbm = (float) (Bb - 14.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 14.2) / (14.2 - 12.5));
                        } else {
                            bbu = (float) ((Bb - 14.2) / (16.3 - 14.2));
                        }
                        break;
                    case 39:
                        bbm = (float) (Bb - 14.4);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 14.4) / (14.4 - 12.7));
                        } else {
                            bbu = (float) ((Bb - 14.4) / (16.5 - 14.4));
                        }
                        break;
                    case 40:
                        bbm = (float) (Bb - 14.6);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 14.6) / (14.6 - 12.8));
                        } else {
                            bbu = (float) ((Bb - 14.6) / (16.7 - 14.6));
                        }
                        break;
                    case 41:
                        bbm = (float) (Bb - 14.8);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 14.8) / (14.8 - 13.0));
                        } else {
                            bbu = (float) ((Bb - 14.8) / (16.9 - 14.8));
                        }
                        break;
                    case 42:
                        bbm = (float) (Bb - 15.0);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 15.0) / (15.0 - 13.1));
                        } else {
                            bbu = (float) ((Bb - 15.0) / (17.2 - 15.0));
                        }
                        break;
                    case 43:
                        bbm = (float) (Bb - 15.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 15.2) / (15.2 - 13.3));
                        } else {
                            bbu = (float) ((Bb - 15.2) / (17.4 - 15.2));
                        }
                        break;
                    case 44:
                        bbm = (float) (Bb - 15.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 15.3) / (15.3 - 13.4));
                        } else {
                            bbu = (float) ((Bb - 15.3) / (17.6 - 15.3));
                        }
                        break;
                    case 45:
                        bbm = (float) (Bb - 15.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 15.5) / (15.5 - 13.6));
                        } else {
                            bbu = (float) ((Bb - 15.5) / (17.8 - 15.5));
                        }
                        break;
                    case 46:
                        bbm = (float) (Bb - 15.7);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 15.7) / (15.7 - 13.7));
                        } else {
                            bbu = (float) ((Bb - 16.0) / (18.1 - 15.7));
                        }
                        break;
                    case 47:
                        bbm = (float) (Bb - 15.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 15.9) / (15.9 - 13.9));
                        } else {
                            bbu = (float) ((Bb - 16.2) / (18.3 - 15.9));
                        }
                        break;
                    case 48:
                        bbm = (float) (Bb - 16.1);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 16.1) / (16.1 - 14.0));
                        } else {
                            bbu = (float) ((Bb - 16.1) / (18.5 - 16.1));
                        }
                        break;
                    case 49:
                        bbm = (float) (Bb - 16.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 16.3) / (16.3 - 14.2));
                        } else {
                            bbu = (float) ((Bb - 16.3) / (18.8 - 16.3));
                        }
                        break;
                    case 50:
                        bbm = (float) (Bb - 16.4);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 16.4) / (16.4 - 14.3));
                        } else {
                            bbu = (float) ((Bb - 16.4) / (19.0 - 16.4));
                        }
                        break;
                    case 51:
                        bbm = (float) (Bb - 16.6);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 16.6) / (16.6 - 14.5));
                        } else {
                            bbu = (float) ((Bb - 16.6) / (19.2 - 16.6));
                        }
                        break;
                    case 52:
                        bbm = (float) (Bb - 16.8);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 16.8) / (16.8 - 14.6));
                        } else {
                            bbu = (float) ((Bb - 16.8) / (19.4 - 16.8));
                        }
                        break;
                    case 53:
                        bbm = (float) (Bb - 17.0);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 17.0) / (17.0 - 14.8));
                        } else {
                            bbu = (float) ((Bb - 17.0) / (19.7 - 17.0));
                        }
                        break;
                    case 54:
                        bbm = (float) (Bb - 17.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 17.2) / (17.2 - 14.9));
                        } else {
                            bbu = (float) ((Bb - 17.2) / (19.9 - 17.2));
                        }
                        break;
                    case 55:
                        bbm = (float) (Bb - 17.3);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 17.3) / (17.3 - 15.1));
                        } else {
                            bbu = (float) ((Bb - 17.3) / (20.1 - 17.3));
                        }
                        break;
                    case 56:
                        bbm = (float) (Bb - 17.5);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 17.5) / (17.5 - 15.2));
                        } else {
                            bbu = (float) ((Bb - 17.5) / (20.3 - 17.5));
                        }
                        break;
                    case 57:
                        bbm = (float) (Bb - 17.7);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 17.7) / (17.7 - 15.3));
                        } else {
                            bbu = (float) ((Bb - 17.7) / (20.6 - 17.7));
                        }
                        break;
                    case 58:
                        bbm = (float) (Bb - 17.9);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 17.9) / (17.9 - 15.5));
                        } else {
                            bbu = (float) ((Bb - 17.9) / (20.8 - 17.9));
                        }
                        break;
                    case 59:
                        bbm = (float) (Bb - 18.0);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 18.0) / (18.0 - 15.6));
                        } else {
                            bbu = (float) ((Bb - 18.0) / (21.0 - 18.0));
                        }
                        break;
                    case 60:
                        bbm = (float) (Bb - 18.2);
                        if (bbm < 0) {
                            bbu = (float) ((Bb - 18.2) / (18.2 - 15.8));
                        } else {
                            bbu = (float) ((Bb - 18.2) / (21.2 - 18.2));
                        }
                        break;
                }
            }
            if (bbu < -3) {
                vHasilBB = "Berat Badan SANGAT KURANG";
            } else if (bbu >= -3 && bbu < -2) {
                vHasilBB = "Berat Badan KURANG";
            } else if (bbu >= -2 && bbu <= 1) {
                vHasilBB = "Berat Badan NORMAL";
            } else if (bbu > 1) {
                vHasilBB = "Berat Badan LEBIH";
            } else {
                vHasilBB = "PERHITUNGAN SALAH!";
            }
            statusbb.setText("" + vHasilBB);


            //Data PB/U
            //Data untuk Laki laki
            if (jeniskelamin.getSelectedItem().toString().equals("Laki laki")) {
                if (posisiukur.getSelectedItem().toString().equals("Terlentang")) {
                    switch (umur) {
                        case 0:
                            pbm = (float) (Pb - 49.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 49.9) / (49.9 - 48.0));
                            } else {
                                pbu = (float) ((Pb - 49.9) / (51.8 - 49.9));
                            }
                            break;
                        case 1:
                            pbm = (float) (Pb - 54.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 54.7) / (54.7 - 52.8));
                            } else {
                                pbu = (float) ((Pb - 54.7) / (56.7 - 54.7));
                            }
                            break;
                        case 2:
                            pbm = (float) (Pb - 58.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 58.4) / (58.4 - 56.4));
                            } else {
                                pbu = (float) ((Pb - 58.4) / (60.4 - 58.4));
                            }
                            break;
                        case 3:
                            pbm = (float) (Pb - 61.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 61.4) / (61.4 - 59.4));
                            } else {
                                pbu = (float) ((Pb - 61.4) / (63.5 - 61.4));
                            }
                            break;
                        case 4:
                            pbm = (float) (Pb - 63.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 63.9) / (63.9 - 61.8));
                            } else {
                                pbu = (float) ((Pb - 63.9) / (66.0 - 63.9));
                            }
                            break;
                        case 5:
                            pbm = (float) (Pb - 65.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 65.9) / (65.9 - 63.8));
                            } else {
                                pbu = (float) ((Pb - 65.9) / (68.0 - 65.9));
                            }
                            break;
                        case 6:
                            pbm = (float) (Pb - 67.6);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 67.6) / (67.6 - 65.5));
                            } else {
                                pbu = (float) ((Pb - 67.6) / (69.8 - 67.6));
                            }
                            break;
                        case 7:
                            pbm = (float) (Pb - 69.2);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 69.2) / (69.2 - 67.0));
                            } else {
                                pbu = (float) ((Pb - 69.2) / (71.3 - 69.2));
                            }
                            break;
                        case 8:
                            pbm = (float) (Pb - 70.6);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 70.6) / (70.6 - 68.4));
                            } else {
                                pbu = (float) ((Pb - 70.6) / (72.8 - 70.6));
                            }
                            break;
                        case 9:
                            pbm = (float) (Pb - 72.0);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 72.0) / (72.0 - 69.7));
                            } else {
                                pbu = (float) ((Pb - 72.0) / (74.2 - 72.0));
                            }
                            break;
                        case 10:
                            pbm = (float) (Pb - 73.3);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 73.3) / (73.3 - 71.0));
                            } else {
                                pbu = (float) ((Pb - 73.3) / (75.6 - 73.3));
                            }
                            break;
                        case 11:
                            pbm = (float) (Pb - 74.5);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 74.5) / (74.5 - 72.2));
                            } else {
                                pbu = (float) ((Pb - 74.5) / (76.9 - 74.5));
                            }
                            break;
                        case 12:
                            pbm = (float) (Pb - 75.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 75.7) / (75.7 - 73.4));
                            } else {
                                pbu = (float) ((Pb - 75.7) / (78.1 - 75.7));
                            }
                            break;
                        case 13:
                            pbm = (float) (Pb - 76.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 76.9) / (76.9 - 74.5));
                            } else {
                                pbu = (float) ((Pb - 76.9) / (79.3 - 76.9));
                            }
                            break;
                        case 14:
                            pbm = (float) (Pb - 78.0);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 78.0) / (78.0 - 75.6));
                            } else {
                                pbu = (float) ((Pb - 78.0) / (80.5 - 78.0));
                            }
                            break;
                        case 15:
                            pbm = (float) (Pb - 79.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 79.1) / (79.1 - 76.6));
                            } else {
                                pbu = (float) ((Pb - 79.1) / (81.7 - 79.1));
                            }
                            break;
                        case 16:
                            pbm = (float) (Pb - 80.2);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 80.2) / (80.2 - 77.6));
                            } else {
                                pbu = (float) ((Pb - 80.2) / (82.8 - 80.2));
                            }
                            break;
                        case 17:
                            pbm = (float) (Pb - 81.2);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 81.2) / (81.2 - 78.6));
                            } else {
                                pbu = (float) ((Pb - 81.2) / (83.9 - 81.2));
                            }
                            break;
                        case 18:
                            pbm = (float) (Pb - 82.3);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 82.3) / (82.3 - 79.6));
                            } else {
                                pbu = (float) ((Pb - 82.3) / (85.0 - 82.3));
                            }
                            break;
                        case 19:
                            pbm = (float) (Pb - 83.2);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 83.2) / (83.2 - 80.5));
                            } else {
                                pbu = (float) ((Pb - 83.2) / (86.0 - 83.2));
                            }
                            break;
                        case 20:
                            pbm = (float) (Pb - 84.2);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 84.2) / (84.2 - 81.4));
                            } else {
                                pbu = (float) ((Pb - 84.2) / (87.0 - 84.2));
                            }
                            break;
                        case 21:
                            pbm = (float) (Pb - 85.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 85.1) / (85.1 - 82.3));
                            } else {
                                pbu = (float) ((Pb - 85.1) / (88.0 - 85.1));
                            }
                            break;
                        case 22:
                            pbm = (float) (Pb - 86.0);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 86.0) / (86.0 - 83.1));
                            } else {
                                pbu = (float) ((Pb - 86.0) / (89.0 - 86.0));
                            }
                            break;
                        case 23:
                            pbm = (float) (Pb - 86.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 86.9) / (86.9 - 83.9));
                            } else {
                                pbu = (float) ((Pb - 86.9) / (89.9 - 86.9));
                            }
                            break;
                        case 24:
                            pbm = (float) (Pb - 87.8);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 87.8) / (87.8 - 84.8));
                            } else {
                                pbu = (float) ((Pb - 87.8) / (85.0 - 87.8));
                            }
                            break;
                    }
                } else if (posisiukur.getSelectedItem().toString().equals("Berdiri")) {
                    switch (umur) {
                        case 24:
                            pbm = (float) (Pb - 87.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 87.1) / (87.1 - 84.1));
                            } else {
                                pbu = (float) ((Pb - 87.1) / (90.2 - 87.1));
                            }
                            break;
                        case 25:
                            pbm = (float) (Pb - 88.0);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 88.0) / (88.0 - 85.6));
                            } else {
                                pbu = (float) ((Pb - 88.0) / (91.1 - 88.0));
                            }
                            break;
                        case 26:
                            pbm = (float) (Pb - 88.8);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 88.8) / (88.8 - 84.9));
                            } else {
                                pbu = (float) ((Pb - 88.8) / (91.1 - 88.8));
                            }
                            break;
                        case 27:
                            pbm = (float) (Pb - 89.6);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 89.6) / (89.6 - 86.4));
                            } else {
                                pbu = (float) ((Pb - 89.6) / (92.9 - 89.6));
                            }
                            break;
                        case 28:
                            pbm = (float) (Pb - 90.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 90.4) / (90.4 - 87.1));
                            } else {
                                pbu = (float) ((Pb - 90.4) / (93.7 - 90.4));
                            }
                            break;
                        case 29:
                            pbm = (float) (Pb - 91.2);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 91.2) / (91.2 - 87.8));
                            } else {
                                pbu = (float) ((Pb - 91.2) / (94.5 - 91.2));
                            }
                            break;
                        case 30:
                            pbm = (float) (Pb - 91.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 91.9) / (91.9 - 88.5));
                            } else {
                                pbu = (float) ((Pb - 91.9) / (95.3 - 91.9));
                            }
                            break;
                        case 31:
                            pbm = (float) (Pb - 92.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 92.7) / (92.7 - 89.2));
                            } else {
                                pbu = (float) ((Pb - 92.7) / (96.1 - 92.7));
                            }
                            break;
                        case 32:
                            pbm = (float) (Pb - 93.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 93.4) / (93.4 - 89.9));
                            } else {
                                pbu = (float) ((Pb - 93.4) / (96.9 - 93.4));
                            }
                            break;
                        case 33:
                            pbm = (float) (Pb - 94.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 94.1) / (94.1 - 90.5));
                            } else {
                                pbu = (float) ((Pb - 94.1) / (97.6 - 94.1));
                            }
                            break;
                        case 34:
                            pbm = (float) (Pb - 94.8);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 94.8) / (94.8 - 91.1));
                            } else {
                                pbu = (float) ((Pb - 94.8) / (98.4 - 94.8));
                            }
                            break;
                        case 35:
                            pbm = (float) (Pb - 95.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 95.4) / (95.4 - 91.8));
                            } else {
                                pbu = (float) ((Pb - 95.4) / (99.1 - 95.4));
                            }
                            break;
                        case 36:
                            pbm = (float) (Pb - 96.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 96.1) / (96.1 - 92.4));
                            } else {
                                pbu = (float) ((Pb - 96.1) / (99.8 - 96.1));
                            }
                            break;
                        case 37:
                            pbm = (float) (Pb - 96.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 96.7) / (96.7 - 93.0));
                            } else {
                                pbu = (float) ((Pb - 96.7) / (100.5 - 96.7));
                            }
                            break;
                        case 38:
                            pbm = (float) (Pb - 97.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 97.4) / (97.4 - 93.6));
                            } else {
                                pbu = (float) ((Pb - 97.4) / (101.2 - 97.4));
                            }
                            break;
                        case 39:
                            pbm = (float) (Pb - 98.0);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 98.0) / (98.0 - 94.2));
                            } else {
                                pbu = (float) ((Pb - 98.0) / (101.8 - 98.0));
                            }
                            break;
                        case 40:
                            pbm = (float) (Pb - 98.6);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 98.6) / (98.6 - 94.7));
                            } else {
                                pbu = (float) ((Pb - 98.6) / (102.5 - 98.6));
                            }
                            break;
                        case 41:
                            pbm = (float) (Pb - 99.2);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 99.2) / (99.2 - 95.3));
                            } else {
                                pbu = (float) ((Pb - 99.2) / (103.2 - 99.2));
                            }
                            break;
                        case 42:
                            pbm = (float) (Pb - 99.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 99.9) / (99.9 - 95.9));
                            } else {
                                pbu = (float) ((Pb - 99.9) / (103.8 - 99.9));
                            }
                            break;
                        case 43:
                            pbm = (float) (Pb - 100.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 100.4) / (100.4 - 96.4));
                            } else {
                                pbu = (float) ((Pb - 100.4) / (104.5 - 100.4));
                            }
                            break;
                        case 44:
                            pbm = (float) (Pb - 101.0);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 101.0) / (101.0 - 97.0));
                            } else {
                                pbu = (float) ((Pb - 101.0) / (105.1 - 101.0));
                            }
                            break;
                        case 45:
                            pbm = (float) (Pb - 101.6);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 101.6) / (101.6 - 97.5));
                            } else {
                                pbu = (float) ((Pb - 101.6) / (105.7 - 101.6));
                            }
                            break;
                        case 46:
                            pbm = (float) (Pb - 102.2);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 102.2) / (102.2 - 98.1));
                            } else {
                                pbu = (float) ((Pb - 102.2) / (106.3 - 102.2));
                            }
                            break;
                        case 47:
                            pbm = (float) (Pb - 102.8);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 102.8) / (102.8 - 98.6));
                            } else {
                                pbu = (float) ((Pb - 102.8) / (106.9 - 102.8));
                            }
                            break;
                        case 48:
                            pbm = (float) (Pb - 103.3);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 103.3) / (103.3 - 99.1));
                            } else {
                                pbu = (float) ((Pb - 103.3) / (107.5 - 103.3));
                            }
                            break;
                        case 49:
                            pbm = (float) (Pb - 103.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 103.9) / (103.9 - 99.7));
                            } else {
                                pbu = (float) ((Pb - 103.9) / (108.1 - 103.9));
                            }
                            break;
                        case 50:
                            pbm = (float) (Pb - 104.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 104.4) / (104.4 - 100.2));
                            } else {
                                pbu = (float) ((Pb - 104.4) / (108.7 - 104.4));
                            }
                            break;
                        case 51:
                            pbm = (float) (Pb - 105.0);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 105.0) / (105.0 - 100.7));
                            } else {
                                pbu = (float) ((Pb - 105.0) / (109.3 - 105.0));
                            }
                            break;
                        case 52:
                            pbm = (float) (Pb - 105.6);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 105.6) / (105.6 - 101.2));
                            } else {
                                pbu = (float) ((Pb - 105.6) / (109.9 - 105.6));
                            }
                            break;
                        case 53:
                            pbm = (float) (Pb - 106.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 106.1) / (106.1 - 101.7));
                            } else {
                                pbu = (float) ((Pb - 106.1) / (110.5 - 106.1));
                            }
                            break;
                        case 54:
                            pbm = (float) (Pb - 106.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 106.7) / (106.7 - 102.3));
                            } else {
                                pbu = (float) ((Pb - 106.7) / (111.1 - 106.7));
                            }
                            break;
                        case 55:
                            pbm = (float) (Pb - 107.2);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 107.2) / (107.2 - 102.8));
                            } else {
                                pbu = (float) ((Pb - 107.2) / (111.7 - 107.2));
                            }
                            break;
                        case 56:
                            pbm = (float) (Pb - 107.8);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 107.8) / (107.8 - 103.3));
                            } else {
                                pbu = (float) ((Pb - 107.8) / (112.3 - 107.8));
                            }
                            break;
                        case 57:
                            pbm = (float) (Pb - 108.3);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 108.3) / (108.3 - 103.8));
                            } else {
                                pbu = (float) ((Pb - 108.3) / (112.8 - 108.3));
                            }
                            break;
                        case 58:
                            pbm = (float) (Pb - 108.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 108.9) / (108.9 - 104.3));
                            } else {
                                pbu = (float) ((Pb - 108.9) / (113.4 - 108.9));
                            }
                            break;
                        case 59:
                            pbm = (float) (Pb - 109.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 109.4) / (109.4 - 104.8));
                            } else {
                                pbu = (float) ((Pb - 109.4) / (114.0 - 109.4));
                            }
                            break;
                        case 60:
                            pbm = (float) (Pb - 110.0);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 110.0) / (110.0 - 105.3));
                            } else {
                                pbu = (float) ((Pb - 110.0) / (114.6 - 110.0));
                            }
                            break;
                    }
                }
            }

            //Data Pb/U dan Tb/U Perempuan
            else if (jeniskelamin.getSelectedItem().toString().equals("Perempuan")) {
                if (posisiukur.getSelectedItem().toString().equals("Terlentang")) {
                    switch (umur) {
                        case 0:
                            pbm = (float) (Pb - 49.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 49.1) / (49.1 - 47.3));
                            } else {
                                pbu = (float) ((Pb - 49.1) / (51.0 - 49.1));
                            }
                            break;
                        case 1:
                            pbm = (float) (Pb - 53.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 53.7) / (53.7 - 51.7));
                            } else {
                                pbu = (float) ((Pb - 53.7) / (55.6 - 53.7));
                            }
                            break;
                        case 2:
                            pbm = (float) (Pb - 57.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 57.1) / (57.1 - 55.0));
                            } else {
                                pbu = (float) ((Pb - 58.4) / (59.1 - 57.1));
                            }
                            break;
                        case 3:
                            pbm = (float) (Pb - 59.8);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 59.8) / (59.8 - 57.7));
                            } else {
                                pbu = (float) ((Pb - 59.8) / (61.9 - 59.8));
                            }
                            break;
                        case 4:
                            pbm = (float) (Pb - 62.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 62.1) / (62.1 - 59.9));
                            } else {
                                pbu = (float) ((Pb - 62.1) / (64.3 - 62.1));
                            }
                            break;
                        case 5:
                            pbm = (float) (Pb - 64.0);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 64.0) / (64.0 - 61.8));
                            } else {
                                pbu = (float) ((Pb - 64.0) / (66.2 - 64.0));
                            }
                            break;
                        case 6:
                            pbm = (float) (Pb - 65.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 65.7) / (65.7 - 63.5));
                            } else {
                                pbu = (float) ((Pb - 65.7) / (68.0 - 65.7));
                            }
                            break;
                        case 7:
                            pbm = (float) (Pb - 67.3);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 67.3) / (67.3 - 65.0));
                            } else {
                                pbu = (float) ((Pb - 67.3) / (69.6 - 67.3));
                            }
                            break;
                        case 8:
                            pbm = (float) (Pb - 68.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 68.7) / (68.7 - 66.4));
                            } else {
                                pbu = (float) ((Pb - 68.7) / (71.1 - 68.7));
                            }
                            break;
                        case 9:
                            pbm = (float) (Pb - 70.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 70.1) / (70.1 - 67.7));
                            } else {
                                pbu = (float) ((Pb - 70.1) / (72.6 - 70.1));
                            }
                            break;
                        case 10:
                            pbm = (float) (Pb - 71.5);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 71.5) / (71.5 - 69.0));
                            } else {
                                pbu = (float) ((Pb - 71.5) / (73.9 - 71.5));
                            }
                            break;
                        case 11:
                            pbm = (float) (Pb - 72.8);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 72.8) / (72.8 - 70.3));
                            } else {
                                pbu = (float) ((Pb - 72.8) / (75.3 - 72.8));
                            }
                            break;
                        case 12:
                            pbm = (float) (Pb - 74.0);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 74.0) / (74.0 - 71.4));
                            } else {
                                pbu = (float) ((Pb - 74.0) / (76.6 - 74.0));
                            }
                            break;
                        case 13:
                            pbm = (float) (Pb - 75.2);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 75.2) / (75.2 - 72.6));
                            } else {
                                pbu = (float) ((Pb - 75.2) / (77.8 - 75.2));
                            }
                            break;
                        case 14:
                            pbm = (float) (Pb - 76.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 76.4) / (76.4 - 73.7));
                            } else {
                                pbu = (float) ((Pb - 76.4) / (79.1 - 76.4));
                            }
                            break;
                        case 15:
                            pbm = (float) (Pb - 77.5);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 77.5) / (77.5 - 74.8));
                            } else {
                                pbu = (float) ((Pb - 77.5) / (80.2 - 77.5));
                            }
                            break;
                        case 16:
                            pbm = (float) (Pb - 78.6);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 78.6) / (78.6 - 75.8));
                            } else {
                                pbu = (float) ((Pb - 78.6) / (81.4 - 78.6));
                            }
                            break;
                        case 17:
                            pbm = (float) (Pb - 79.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 79.7) / (79.7 - 76.8));
                            } else {
                                pbu = (float) ((Pb - 79.7) / (82.5 - 79.7));
                            }
                            break;
                        case 18:
                            pbm = (float) (Pb - 80.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 80.7) / (80.7 - 77.8));
                            } else {
                                pbu = (float) ((Pb - 80.7) / (83.6 - 80.7));
                            }
                            break;
                        case 19:
                            pbm = (float) (Pb - 81.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 81.7) / (81.7 - 78.8));
                            } else {
                                pbu = (float) ((Pb - 81.7) / (84.7 - 81.7));
                            }
                            break;
                        case 20:
                            pbm = (float) (Pb - 82.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 82.7) / (82.7 - 79.7));
                            } else {
                                pbu = (float) ((Pb - 82.7) / (85.7 - 82.7));
                            }
                            break;
                        case 21:
                            pbm = (float) (Pb - 83.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 83.7) / (83.7 - 80.6));
                            } else {
                                pbu = (float) ((Pb - 83.7) / (86.7 - 83.7));
                            }
                            break;
                        case 22:
                            pbm = (float) (Pb - 84.6);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 84.6) / (84.6 - 81.5));
                            } else {
                                pbu = (float) ((Pb - 84.6) / (87.7 - 84.6));
                            }
                            break;
                        case 23:
                            pbm = (float) (Pb - 85.5);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 85.5) / (85.5 - 82.3));
                            } else {
                                pbu = (float) ((Pb - 85.5) / (88.7 - 85.5));
                            }
                            break;
                        case 24:
                            pbm = (float) (Pb - 86.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 86.4) / (86.4 - 83.2));
                            } else {
                                pbu = (float) ((Pb - 87.8) / (89.6 - 86.4));
                            }
                            break;
                    }
                } else if (posisiukur.getSelectedItem().toString().equals("Berdiri")) {
                    switch (umur) {
                        case 24:
                            pbm = (float) (Pb - 85.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 85.7) / (85.7 - 82.5));
                            } else {
                                pbu = (float) ((Pb - 85.7) / (88.9 - 85.7));
                            }
                            break;
                        case 25:
                            pbm = (float) (Pb - 86.6);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 86.6) / (86.6 - 83.3));
                            } else {
                                pbu = (float) ((Pb - 86.6) / (89.9 - 86.6));
                            }
                            break;
                        case 26:
                            pbm = (float) (Pb - 87.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 87.4) / (87.4 - 84.1));
                            } else {
                                pbu = (float) ((Pb - 87.4) / (90.8 - 87.4));
                            }
                            break;
                        case 27:
                            pbm = (float) (Pb - 88.3);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 88.3) / (88.3 - 84.9));
                            } else {
                                pbu = (float) ((Pb - 88.3) / (91.7 - 88.3));
                            }
                            break;
                        case 28:
                            pbm = (float) (Pb - 89.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 89.1) / (89.1 - 85.7));
                            } else {
                                pbu = (float) ((Pb - 89.1) / (92.7 - 89.1));
                            }
                            break;
                        case 29:
                            pbm = (float) (Pb - 89.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 89.9) / (89.9 - 86.4));
                            } else {
                                pbu = (float) ((Pb - 89.9) / (93.4 - 89.9));
                            }
                            break;
                        case 30:
                            pbm = (float) (Pb - 90.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 90.7) / (90.7 - 87.1));
                            } else {
                                pbu = (float) ((Pb - 90.7) / (94.2 - 90.7));
                            }
                            break;
                        case 31:
                            pbm = (float) (Pb - 91.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 91.4) / (91.4 - 87.9));
                            } else {
                                pbu = (float) ((Pb - 91.4) / (95.0 - 91.4));
                            }
                            break;
                        case 32:
                            pbm = (float) (Pb - 92.2);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 92.2) / (92.2 - 88.6));
                            } else {
                                pbu = (float) ((Pb - 92.2) / (95.8 - 92.2));
                            }
                            break;
                        case 33:
                            pbm = (float) (Pb - 92.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 92.9) / (92.9 - 89.3));
                            } else {
                                pbu = (float) ((Pb - 92.9) / (96.6 - 92.9));
                            }
                            break;
                        case 34:
                            pbm = (float) (Pb - 93.6);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 93.6) / (93.6 - 89.9));
                            } else {
                                pbu = (float) ((Pb - 93.6) / (97.4 - 93.6));
                            }
                            break;
                        case 35:
                            pbm = (float) (Pb - 94.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 94.4) / (94.4 - 90.6));
                            } else {
                                pbu = (float) ((Pb - 94.4) / (98.1 - 94.4));
                            }
                            break;
                        case 36:
                            pbm = (float) (Pb - 95.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 95.1) / (95.1 - 91.2));
                            } else {
                                pbu = (float) ((Pb - 95.1) / (98.9 - 95.1));
                            }
                            break;
                        case 37:
                            pbm = (float) (Pb - 95.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 95.7) / (95.7 - 91.2));
                            } else {
                                pbu = (float) ((Pb - 95.7) / (99.6 - 95.7));
                            }
                            break;
                        case 38:
                            pbm = (float) (Pb - 96.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 96.4) / (96.4 - 92.5));
                            } else {
                                pbu = (float) ((Pb - 96.4) / (100.3 - 96.4));
                            }
                            break;
                        case 39:
                            pbm = (float) (Pb - 97.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 97.1) / (97.1 - 93.1));
                            } else {
                                pbu = (float) ((Pb - 97.1) / (101.0 - 97.1));
                            }
                            break;
                        case 40:
                            pbm = (float) (Pb - 97.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 97.7) / (97.7 - 93.8));
                            } else {
                                pbu = (float) ((Pb - 97.7) / (101.7 - 97.7));
                            }
                            break;
                        case 41:
                            pbm = (float) (Pb - 98.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 98.4) / (98.4 - 94.4));
                            } else {
                                pbu = (float) ((Pb - 98.4) / (102.4 - 98.4));
                            }
                            break;
                        case 42:
                            pbm = (float) (Pb - 99.0);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 99.0) / (99.0 - 95.0));
                            } else {
                                pbu = (float) ((Pb - 99.0) / (103.1 - 99.0));
                            }
                            break;
                        case 43:
                            pbm = (float) (Pb - 99.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 99.7) / (99.7 - 95.6));
                            } else {
                                pbu = (float) ((Pb - 99.7) / (103.8 - 99.7));
                            }
                            break;
                        case 44:
                            pbm = (float) (Pb - 100.3);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 100.3) / (100.3 - 96.2));
                            } else {
                                pbu = (float) ((Pb - 100.3) / (104.5 - 100.3));
                            }
                            break;
                        case 45:
                            pbm = (float) (Pb - 100.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 100.9) / (100.9 - 96.7));
                            } else {
                                pbu = (float) ((Pb - 100.9) / (105.1 - 100.9));
                            }
                            break;
                        case 46:
                            pbm = (float) (Pb - 101.5);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 101.5) / (101.5 - 97.3));
                            } else {
                                pbu = (float) ((Pb - 101.5) / (105.8 - 101.5));
                            }
                            break;
                        case 47:
                            pbm = (float) (Pb - 102.1);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 102.1) / (102.1 - 97.9));
                            } else {
                                pbu = (float) ((Pb - 102.1) / (106.4 - 102.1));
                            }
                            break;
                        case 48:
                            pbm = (float) (Pb - 102.7);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 102.7) / (102.7 - 98.4));
                            } else {
                                pbu = (float) ((Pb - 102.7) / (107.0 - 102.7));
                            }
                            break;
                        case 49:
                            pbm = (float) (Pb - 103.3);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 103.3) / (103.3 - 99.0));
                            } else {
                                pbu = (float) ((Pb - 103.3) / (107.7 - 103.3));
                            }
                            break;
                        case 50:
                            pbm = (float) (Pb - 103.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 103.9) / (103.9 - 99.5));
                            } else {
                                pbu = (float) ((Pb - 103.9) / (108.3 - 103.9));
                            }
                            break;
                        case 51:
                            pbm = (float) (Pb - 104.5);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 104.5) / (104.5 - 100.1));
                            } else {
                                pbu = (float) ((Pb - 104.5) / (108.9 - 104.5));
                            }
                            break;
                        case 52:
                            pbm = (float) (Pb - 105.0);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 105.0) / (105.0 - 100.6));
                            } else {
                                pbu = (float) ((Pb - 105.0) / (109.5 - 105.0));
                            }
                            break;
                        case 53:
                            pbm = (float) (Pb - 105.6);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 105.6) / (105.6 - 101.1));
                            } else {
                                pbu = (float) ((Pb - 105.6) / (110.1 - 105.6));
                            }
                            break;
                        case 54:
                            pbm = (float) (Pb - 106.2);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 106.2) / (106.2 - 101.6));
                            } else {
                                pbu = (float) ((Pb - 106.2) / (110.7 - 106.2));
                            }
                            break;
                        case 55:
                            pbm = (float) (Pb - 106.8);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 106.7) / (106.7 - 102.2));
                            } else {
                                pbu = (float) ((Pb - 106.7) / (111.3 - 106.7));
                            }
                            break;
                        case 56:
                            pbm = (float) (Pb - 107.3);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 107.3) / (107.3 - 102.7));
                            } else {
                                pbu = (float) ((Pb - 107.3) / (111.9 - 107.3));
                            }
                            break;
                        case 57:
                            pbm = (float) (Pb - 107.8);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 107.8) / (107.8 - 103.2));
                            } else {
                                pbu = (float) ((Pb - 107.8) / (112.5 - 107.8));
                            }
                            break;
                        case 58:
                            pbm = (float) (Pb - 108.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 108.4) / (108.4 - 103.7));
                            } else {
                                pbu = (float) ((Pb - 108.4) / (113.0 - 108.4));
                            }
                            break;
                        case 59:
                            pbm = (float) (Pb - 108.9);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 108.9) / (108.9 - 104.2));
                            } else {
                                pbu = (float) ((Pb - 108.9) / (113.6 - 108.9));
                            }
                            break;
                        case 60:
                            pbm = (float) (Pb - 109.4);
                            if (pbm < 0) {
                                pbu = (float) ((Pb - 109.4) / (109.4 - 104.7));
                            } else {
                                pbu = (float) ((Pb - 109.4) / (114.2 - 109.4));
                            }
                            break;
                    }
                }
            }
            if (pbu < -3) {
                vHasilPb = "Sangat PENDEK";
            } else if (pbu >= -3 && pbu < -2) {
                vHasilPb = "PENDEK";
            } else if (pbu >= -2 && pbu < 3) {
                vHasilPb = "NORMAL";
            } else if (pbu >= 3) {
                vHasilPb = "TINGGI";
            }
            statuspb.setText("" + vHasilPb);

            //Data BB/TB
            //Data Untuk Laki laki
            if (jeniskelamin.getSelectedItem().toString().equals("Laki laki")) {
                if (posisiukur.getSelectedItem().toString().equals("Terlentang")) {
                    if (umur <= 24) {
                        if (Pb == 45.0 && Pb < 40.5) {
                            BbTbm = (float) (Bb - 2.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 2.4) / (2.4 - 2.2));
                            } else {
                                HBbTbm = (float) ((Bb - 2.4) / (2.7 - 2.4));
                            }
                        } else if (Pb == 45.5) {
                            BbTbm = (float) (Bb - 2.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 2.5) / (2.5 - 2.3));
                            } else {
                                HBbTbm = (float) ((Bb - 2.5) / (2.8 - 2.5));
                            }
                        } else if (Pb == 46.0) {
                            BbTbm = (float) (Bb - 2.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 2.6) / (2.6 - 2.4));
                            } else {
                                HBbTbm = (float) ((Bb - 2.6) / (2.9 - 2.6));
                            }
                        } else if (Pb == 46.5) {
                            BbTbm = (float) (Bb - 2.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 2.7) / (2.7 - 2.5));
                            } else {
                                HBbTbm = (float) ((Bb - 2.7) / (3.0 - 2.7));
                            }
                        } else if (Pb == 47.0) {
                            BbTbm = (float) (Bb - 2.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 2.8) / (2.8 - 2.5));
                            } else {
                                HBbTbm = (float) ((Bb - 2.8) / (3.0 - 2.8));
                            }
                        } else if (Pb == 47.5) {
                            BbTbm = (float) (Bb - 2.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 2.9) / (2.9 - 2.6));
                            } else {
                                HBbTbm = (float) ((Bb - 2.9) / (3.1 - 2.9));
                            }
                        } else if (Pb == 48.0) {
                            BbTbm = (float) (Bb - 2.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 2.9) / (2.9 - 2.7));
                            } else {
                                HBbTbm = (float) ((Bb - 2.9) / (3.2 - 2.9));
                            }
                        } else if (Pb == 48.5) {
                            BbTbm = (float) (Bb - 3.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.0) / (3.0 - 2.8));
                            } else {
                                HBbTbm = (float) ((Bb - 3.0) / (3.3 - 3.0));
                            }
                        } else if (Pb == 49.0) {
                            BbTbm = (float) (Bb - 3.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.1) / (3.1 - 2.9));
                            } else {
                                HBbTbm = (float) ((Bb - 3.1) / (3.4 - 3.1));
                            }
                        } else if (Pb == 49.5) {
                            BbTbm = (float) (Bb - 3.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.2) / (3.2 - 3.0));
                            } else {
                                HBbTbm = (float) ((Bb - 3.2) / (3.5 - 3.2));
                            }
                        } else if (Pb == 50.0) {
                            BbTbm = (float) (Bb - 3.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.3) / (3.3 - 3.0));
                            } else {
                                HBbTbm = (float) ((Bb - 3.3) / (3.6 - 3.3));
                            }
                        } else if (Pb == 50.5) {
                            BbTbm = (float) (Bb - 3.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.4) / (3.4 - 3.1));
                            } else {
                                HBbTbm = (float) ((Bb - 3.4) / (3.8 - 3.4));
                            }
                        } else if (Pb == 51.0) {
                            BbTbm = (float) (Bb - 3.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.5) / (3.5 - 3.2));
                            } else {
                                HBbTbm = (float) ((Bb - 3.5) / (3.9 - 3.5));
                            }
                        } else if (Pb == 51.5) {
                            BbTbm = (float) (Bb - 3.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.6) / (3.6 - 3.3));
                            } else {
                                HBbTbm = (float) ((Bb - 3.6) / (4.0 - 3.6));
                            }
                        } else if (Pb == 52.0) {
                            BbTbm = (float) (Bb - 3.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.8) / (3.8 - 3.5));
                            } else {
                                HBbTbm = (float) ((Bb - 3.8) / (4.1 - 3.8));
                            }
                        } else if (Pb == 52.5) {
                            BbTbm = (float) (Bb - 3.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.9) / (3.9 - 3.6));
                            } else {
                                HBbTbm = (float) ((Bb - 3.9) / (4.2 - 3.9));
                            }
                        } else if (Pb == 53.0) {
                            BbTbm = (float) (Bb - 4.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.0) / (4.0 - 3.7));
                            } else {
                                HBbTbm = (float) ((Bb - 4.0) / (4.4 - 4.0));
                            }
                        } else if (Pb == 53.5) {
                            BbTbm = (float) (Bb - 4.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.1) / (4.1 - 3.8));
                            } else {
                                HBbTbm = (float) ((Bb - 4.1) / (4.5 - 4.1));
                            }
                        } else if (Pb == 54.0) {
                            BbTbm = (float) (Bb - 4.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.3) / (4.3 - 3.9));
                            } else {
                                HBbTbm = (float) ((Bb - 4.3) / (4.7 - 4.3));
                            }
                        } else if (Pb == 54.5) {
                            BbTbm = (float) (Bb - 4.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.4) / (4.4 - 4.0));
                            } else {
                                HBbTbm = (float) ((Bb - 4.4) / (4.8 - 4.4));
                            }
                        } else if (Pb == 55.0) {
                            BbTbm = (float) (Bb - 4.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.5) / (4.5 - 4.2));
                            } else {
                                HBbTbm = (float) ((Bb - 4.5) / (5.0 - 4.5));
                            }
                        } else if (Pb == 55.5) {
                            BbTbm = (float) (Bb - 4.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.7) / (4.7 - 4.3));
                            } else {
                                HBbTbm = (float) ((Bb - 4.7) / (5.1 - 4.7));
                            }
                        } else if (Pb == 56.0) {
                            BbTbm = (float) (Bb - 4.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.8) / (4.8 - 4.4));
                            } else {
                                HBbTbm = (float) ((Bb - 4.8) / (5.3 - 4.8));
                            }
                        } else if (Pb == 56.5) {
                            BbTbm = (float) (Bb - 5.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.0) / (5.0 - 4.6));
                            } else {
                                HBbTbm = (float) ((Bb - 5.0) / (5.4 - 5.0));
                            }
                        } else if (Pb == 57.0) {
                            BbTbm = (float) (Bb - 5.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.1) / (5.1 - 4.7));
                            } else {
                                HBbTbm = (float) ((Bb - 5.1) / (5.6 - 5.1));
                            }
                        } else if (Pb == 57.5) {
                            BbTbm = (float) (Bb - 5.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.3) / (5.3 - 4.9));
                            } else {
                                HBbTbm = (float) ((Bb - 5.3) / (5.7 - 5.3));
                            }
                        } else if (Pb == 58.0) {
                            BbTbm = (float) (Bb - 5.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.4) / (5.4 - 5.0));
                            } else {
                                HBbTbm = (float) ((Bb - 5.4) / (5.9 - 5.4));
                            }
                        } else if (Pb == 58.5) {
                            BbTbm = (float) (Bb - 5.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.6) / (5.6 - 5.1));
                            } else {
                                HBbTbm = (float) ((Bb - 5.6) / (6.1 - 5.5));
                            }
                        } else if (Pb == 59.0) {
                            BbTbm = (float) (Bb - 5.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.7) / (5.7 - 5.3));
                            } else {
                                HBbTbm = (float) ((Bb - 5.7) / (6.2 - 5.7));
                            }
                        } else if (Pb == 59.5) {
                            BbTbm = (float) (Bb - 5.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.9) / (5.9 - 5.4));
                            } else {
                                HBbTbm = (float) ((Bb - 5.9) / (6.4 - 5.9));
                            }
                        } else if (Pb == 60.0) {
                            BbTbm = (float) (Bb - 6.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.0) / (6.0 - 5.5));
                            } else {
                                HBbTbm = (float) ((Bb - 6.0) / (6.5 - 6.0));
                            }
                        } else if (Pb == 60.5) {
                            BbTbm = (float) (Bb - 6.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.1) / (6.1 - 5.6));
                            } else {
                                HBbTbm = (float) ((Bb - 6.1) / (6.7 - 6.1));
                            }
                        } else if (Pb == 61.0) {
                            BbTbm = (float) (Bb - 6.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.3) / (6.3 - 5.8));
                            } else {
                                HBbTbm = (float) ((Bb - 6.3) / (6.8 - 6.3));
                            }
                        } else if (Pb == 61.5) {
                            BbTbm = (float) (Bb - 6.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.4) / (6.4 - 5.9));
                            } else {
                                HBbTbm = (float) ((Bb - 6.4) / (7.0 - 6.4));
                            }
                        } else if (Pb == 62.0) {
                            BbTbm = (float) (Bb - 6.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.5) / (6.5 - 6.0));
                            } else {
                                HBbTbm = (float) ((Bb - 6.5) / (7.1 - 6.5));
                            }
                        } else if (Pb == 62.5) {
                            BbTbm = (float) (Bb - 6.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.7) / (6.7 - 6.1));
                            } else {
                                HBbTbm = (float) ((Bb - 6.7) / (7.2 - 6.7));
                            }
                        } else if (Pb == 63.0) {
                            BbTbm = (float) (Bb - 6.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.8) / (6.8 - 6.2));
                            } else {
                                HBbTbm = (float) ((Bb - 6.8) / (7.4 - 6.8));
                            }
                        } else if (Pb == 63.5) {
                            BbTbm = (float) (Bb - 6.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.9) / (6.9 - 6.4));
                            } else {
                                HBbTbm = (float) ((Bb - 6.9) / (7.5 - 6.9));
                            }
                        } else if (Pb == 64.0) {
                            BbTbm = (float) (Bb - 7.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.0) / (7.0 - 6.5));
                            } else {
                                HBbTbm = (float) ((Bb - 7.0) / (7.6 - 7.0));
                            }
                        } else if (Pb == 64.5) {
                            BbTbm = (float) (Bb - 7.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.1) / (7.1 - 6.6));
                            } else {
                                HBbTbm = (float) ((Bb - 7.1) / (7.8 - 7.1));
                            }
                        } else if (Pb == 65.0) {
                            BbTbm = (float) (Bb - 7.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.3) / (7.3 - 6.7));
                            } else {
                                HBbTbm = (float) ((Bb - 7.3) / (7.9 - 7.3));
                            }
                        } else if (Pb == 65.5) {
                            BbTbm = (float) (Bb - 7.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.4) / (7.4 - 6.8));
                            } else {
                                HBbTbm = (float) ((Bb - 7.4) / (8.0 - 7.4));
                            }
                        } else if (Pb == 66.0) {
                            BbTbm = (float) (Bb - 7.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.5) / (7.5 - 6.9));
                            } else {
                                HBbTbm = (float) ((Bb - 7.5) / (8.2 - 7.5));
                            }
                        } else if (Pb == 66.5) {
                            BbTbm = (float) (Bb - 7.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.6) / (7.6 - 7.0));
                            } else {
                                HBbTbm = (float) ((Bb - 7.6) / (8.3 - 7.6));
                            }
                        } else if (Pb == 67.0) {
                            BbTbm = (float) (Bb - 7.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.7) / (7.7 - 7.1));
                            } else {
                                HBbTbm = (float) ((Bb - 7.7) / (8.4 - 7.7));
                            }
                        } else if (Pb == 67.5) {
                            BbTbm = (float) (Bb - 7.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.9) / (7.9 - 7.2));
                            } else {
                                HBbTbm = (float) ((Bb - 7.9) / (8.5 - 7.9));
                            }
                        } else if (Pb == 68.0) {
                            BbTbm = (float) (Bb - 8.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.0) / (8.0 - 7.3));
                            } else {
                                HBbTbm = (float) ((Bb - 8.0) / (8.7 - 8.0));
                            }
                        } else if (Pb == 68.5) {
                            BbTbm = (float) (Bb - 8.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.1) / (8.1 - 7.5));
                            } else {
                                HBbTbm = (float) ((Bb - 8.1) / (8.8 - 8.1));
                            }
                        } else if (Pb == 69.0) {
                            BbTbm = (float) (Bb - 8.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.2) / (8.2 - 7.6));
                            } else {
                                HBbTbm = (float) ((Bb - 8.2) / (8.9 - 8.2));
                            }
                        } else if (Pb == 69.5) {
                            BbTbm = (float) (Bb - 8.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.3) / (8.3 - 7.7));
                            } else {
                                HBbTbm = (float) ((Bb - 8.3) / (9.0 - 8.3));
                            }
                        } else if (Pb == 70.0) {
                            BbTbm = (float) (Bb - 8.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.4) / (8.4 - 7.8));
                            } else {
                                HBbTbm = (float) ((Bb - 8.4) / (9.2 - 8.4));
                            }
                        } else if (Pb == 70.5) {
                            BbTbm = (float) (Bb - 8.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.5) / (8.5 - 7.9));
                            } else {
                                HBbTbm = (float) ((Bb - 8.5) / (9.3 - 8.5));
                            }
                        } else if (Pb == 71.0) {
                            BbTbm = (float) (Bb - 8.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.6) / (8.6 - 8.0));
                            } else {
                                HBbTbm = (float) ((Bb - 8.6) / (9.4 - 8.6));
                            }
                        } else if (Pb == 71.5) {
                            BbTbm = (float) (Bb - 8.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.8) / (8.8 - 8.1));
                            } else {
                                HBbTbm = (float) ((Bb - 8.8) / (9.5 - 8.8));
                            }
                        } else if (Pb == 72.0) {
                            BbTbm = (float) (Bb - 8.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.9) / (8.9 - 8.2));
                            } else {
                                HBbTbm = (float) ((Bb - 8.9) / (9.6 - 8.9));
                            }
                        } else if (Pb == 72.5) {
                            BbTbm = (float) (Bb - 9.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.0) / (9.0 - 8.3));
                            } else {
                                HBbTbm = (float) ((Bb - 9.0) / (9.8 - 9.0));
                            }
                        } else if (Pb == 73.0) {
                            BbTbm = (float) (Bb - 9.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.1) / (9.1 - 8.4));
                            } else {
                                HBbTbm = (float) ((Bb - 9.1) / (9.9 - 9.1));
                            }
                        } else if (Pb == 73.5) {
                            BbTbm = (float) (Bb - 9.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.2) / (9.2 - 8.5));
                            } else {
                                HBbTbm = (float) ((Bb - 9.2) / (10.0 - 9.2));
                            }
                        } else if (Pb == 74.0) {
                            BbTbm = (float) (Bb - 9.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.3) / (9.3 - 8.6));
                            } else {
                                HBbTbm = (float) ((Bb - 9.3) / (10.1 - 9.3));
                            }
                        } else if (Pb == 74.5) {
                            BbTbm = (float) (Bb - 9.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.4) / (9.4 - 8.7));
                            } else {
                                HBbTbm = (float) ((Bb - 9.4) / (10.2 - 9.4));
                            }
                        } else if (Pb == 75.0) {
                            BbTbm = (float) (Bb - 9.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.5) / (9.5 - 8.8));
                            } else {
                                HBbTbm = (float) ((Bb - 9.5) / (10.3 - 9.5));
                            }
                        } else if (Pb == 75.5) {
                            BbTbm = (float) (Bb - 9.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.6) / (9.6 - 8.8));
                            } else {
                                HBbTbm = (float) ((Bb - 9.6) / (10.4 - 9.7));
                            }
                        } else if (Pb == 76.0) {
                            BbTbm = (float) (Bb - 9.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.7) / (9.7 - 8.9));
                            } else {
                                HBbTbm = (float) ((Bb - 9.7) / (10.6 - 9.7));
                            }
                        } else if (Pb == 76.5) {
                            BbTbm = (float) (Bb - 9.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.8) / (9.8 - 9.0));
                            } else {
                                HBbTbm = (float) ((Bb - 9.8) / (10.7 - 9.8));
                            }
                        } else if (Pb == 77.0) {
                            BbTbm = (float) (Bb - 9.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.9) / (9.9 - 9.1));
                            } else {
                                HBbTbm = (float) ((Bb - 9.9) / (10.8 - 9.9));
                            }
                        } else if (Pb == 77.5) {
                            BbTbm = (float) (Bb - 10.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.0) / (10.0 - 9.2));
                            } else {
                                HBbTbm = (float) ((Bb - 10.0) / (10.9 - 10.0));
                            }
                        } else if (Pb == 78.0) {
                            BbTbm = (float) (Bb - 10.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.1) / (10.1 - 9.3));
                            } else {
                                HBbTbm = (float) ((Bb - 10.1) / (11.0 - 10.1));
                            }
                        } else if (Pb == 78.5) {
                            BbTbm = (float) (Bb - 10.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.2) / (10.2 - 9.4));
                            } else {
                                HBbTbm = (float) ((Bb - 10.2) / (11.1 - 10.2));
                            }
                        } else if (Pb == 79.0) {
                            BbTbm = (float) (Bb - 10.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.3) / (10.3 - 9.5));
                            } else {
                                HBbTbm = (float) ((Bb - 10.3) / (11.2 - 10.3));
                            }
                        } else if (Pb == 79.5) {
                            BbTbm = (float) (Bb - 10.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.4) / (10.4 - 9.5));
                            } else {
                                HBbTbm = (float) ((Bb - 10.4) / (11.3 - 10.4));
                            }
                        } else if (Pb == 80.0) {
                            BbTbm = (float) (Bb - 10.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.4) / (10.4 - 9.5));
                            } else {
                                HBbTbm = (float) ((Bb - 10.4) / (11.4 - 10.4));
                            }
                        } else if (Pb == 80.5) {
                            BbTbm = (float) (Bb - 10.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.5) / (10.5 - 9.7));
                            } else {
                                HBbTbm = (float) ((Bb - 10.5) / (11.5 - 10.5));
                            }
                        } else if (Pb == 81.0) {
                            BbTbm = (float) (Bb - 10.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.6) / (10.6 - 9.8));
                            } else {
                                HBbTbm = (float) ((Bb - 10.6) / (11.8 - 10.6));
                            }
                        } else if (Pb == 81.5) {
                            BbTbm = (float) (Bb - 10.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.7) / (10.7 - 9.9));
                            } else {
                                HBbTbm = (float) ((Bb - 10.7) / (11.7 - 10.7));
                            }
                        } else if (Pb == 82.0) {
                            BbTbm = (float) (Bb - 10.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.8) / (10.8 - 10.0));
                            } else {
                                HBbTbm = (float) ((Bb - 10.8) / (11.8 - 10.8));
                            }
                        } else if (Pb == 82.5) {
                            BbTbm = (float) (Bb - 10.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.9) / (10.9 - 10.1));
                            } else {
                                HBbTbm = (float) ((Bb - 10.9) / (11.9 - 10.9));
                            }
                        } else if (Pb == 83.0) {
                            BbTbm = (float) (Bb - 11.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.0) / (11.0 - 10.2));
                            } else {
                                HBbTbm = (float) ((Bb - 11.0) / (12.0 - 11.0));
                            }
                        } else if (Pb == 83.5) {
                            BbTbm = (float) (Bb - 11.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.2) / (11.2 - 10.3));
                            } else {
                                HBbTbm = (float) ((Bb - 11.2) / (12.1 - 11.2));
                            }
                        } else if (Pb == 84.0) {
                            BbTbm = (float) (Bb - 11.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.3) / (11.3 - 10.4));
                            } else {
                                HBbTbm = (float) ((Bb - 11.3) / (12.2 - 11.3));
                            }
                        } else if (Pb == 84.5) {
                            BbTbm = (float) (Bb - 11.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.4) / (11.4 - 10.5));
                            } else {
                                HBbTbm = (float) ((Bb - 11.4) / (12.4 - 11.4));
                            }
                        } else if (Pb == 85.0) {
                            BbTbm = (float) (Bb - 11.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.5) / (11.5 - 10.6));
                            } else {
                                HBbTbm = (float) ((Bb - 11.5) / (12.5 - 11.5));
                            }
                        } else if (Pb == 85.5) {
                            BbTbm = (float) (Bb - 11.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.6) / (11.6 - 10.7));
                            } else {
                                HBbTbm = (float) ((Bb - 11.6) / (12.6 - 11.6));
                            }
                        } else if (Pb == 86.0) {
                            BbTbm = (float) (Bb - 11.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.7) / (11.7 - 10.8));
                            } else {
                                HBbTbm = (float) ((Bb - 11.7) / (12.8 - 11.7));
                            }
                        } else if (Pb == 86.5) {
                            BbTbm = (float) (Bb - 11.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.9) / (11.9 - 11.0));
                            } else {
                                HBbTbm = (float) ((Bb - 11.9) / (12.9 - 11.9));
                            }
                        } else if (Pb == 87.0) {
                            BbTbm = (float) (Bb - 12.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.0) / (12.0 - 11.1));
                            } else {
                                HBbTbm = (float) ((Bb - 12.0) / (13.0 - 12.0));
                            }
                        } else if (Pb == 87.5) {
                            BbTbm = (float) (Bb - 12.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.1) / (12.1 - 11.2));
                            } else {
                                HBbTbm = (float) ((Bb - 12.1) / (13.2 - 12.1));
                            }
                        } else if (Pb == 88.0) {
                            BbTbm = (float) (Bb - 12.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.2) / (12.2 - 11.3));
                            } else {
                                HBbTbm = (float) ((Bb - 12.2) / (13.3 - 12.2));
                            }
                        } else if (Pb == 88.5) {
                            BbTbm = (float) (Bb - 12.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.4) / (12.4 - 11.3));
                            } else {
                                HBbTbm = (float) ((Bb - 12.4) / (13.4 - 12.4));
                            }
                        } else if (Pb == 89.0) {
                            BbTbm = (float) (Bb - 12.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.5) / (12.5 - 11.5));
                            } else {
                                HBbTbm = (float) ((Bb - 12.5) / (13.5 - 12.5));
                            }
                        } else if (Pb == 89.5) {
                            BbTbm = (float) (Bb - 12.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.6) / (12.6 - 11.6));
                            } else {
                                HBbTbm = (float) ((Bb - 12.6) / (13.7 - 12.6));
                            }
                        } else if (Pb == 90.0) {
                            BbTbm = (float) (Bb - 12.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.7) / (12.7 - 11.8));
                            } else {
                                HBbTbm = (float) ((Bb - 12.7) / (13.8 - 12.7));
                            }
                        } else if (Pb == 90.5) {
                            BbTbm = (float) (Bb - 12.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.8) / (12.8 - 11.9));
                            } else {
                                HBbTbm = (float) ((Bb - 12.8) / (13.9 - 12.8));
                            }
                        } else if (Pb == 91.0) {
                            BbTbm = (float) (Bb - 13.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.0) / (13.0 - 12.0));
                            } else {
                                HBbTbm = (float) ((Bb - 13.0) / (14.1 - 13.0));
                            }
                        } else if (Pb == 91.5) {
                            BbTbm = (float) (Bb - 13.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.1) / (13.1 - 12.1));
                            } else {
                                HBbTbm = (float) ((Bb - 13.1) / (14.2 - 13.1));
                            }
                        } else if (Pb == 92.0) {
                            BbTbm = (float) (Bb - 13.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.2) / (13.2 - 12.2));
                            } else {
                                HBbTbm = (float) ((Bb - 13.2) / (14.3 - 13.2));
                            }
                        } else if (Pb == 92.5) {
                            BbTbm = (float) (Bb - 13.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.3) / (13.3 - 12.3));
                            } else {
                                HBbTbm = (float) ((Bb - 13.3) / (14.4 - 13.3));
                            }
                        } else if (Pb == 93.0) {
                            BbTbm = (float) (Bb - 13.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.4) / (13.4 - 12.4));
                            } else {
                                HBbTbm = (float) ((Bb - 13.4) / (14.6 - 13.4));
                            }
                        } else if (Pb == 93.5) {
                            BbTbm = (float) (Bb - 13.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.5) / (13.5 - 12.5));
                            } else {
                                HBbTbm = (float) ((Bb - 13.5) / (14.7 - 13.5));
                            }
                        } else if (Pb == 94.0) {
                            BbTbm = (float) (Bb - 13.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.7) / (13.7 - 12.6));
                            } else {
                                HBbTbm = (float) ((Bb - 13.7) / (14.8 - 13.7));
                            }
                        } else if (Pb == 94.5) {
                            BbTbm = (float) (Bb - 13.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.8) / (13.8 - 12.7));
                            } else {
                                HBbTbm = (float) ((Bb - 13.8) / (14.9 - 13.8));
                            }
                        } else if (Pb == 95.0) {
                            BbTbm = (float) (Bb - 13.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.9) / (13.9 - 12.8));
                            } else {
                                HBbTbm = (float) ((Bb - 13.9) / (15.1 - 13.9));
                            }
                        } else if (Pb == 95.5) {
                            BbTbm = (float) (Bb - 14.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.0) / (14.0 - 12.9));
                            } else {
                                HBbTbm = (float) ((Bb - 14.0) / (15.2 - 14.0));
                            }
                        } else if (Pb == 96.0) {
                            BbTbm = (float) (Bb - 14.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.1) / (14.1 - 13.1));
                            } else {
                                HBbTbm = (float) ((Bb - 14.1) / (15.3 - 14.1));
                            }
                        } else if (Pb == 96.5) {
                            BbTbm = (float) (Bb - 14.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.3) / (14.3 - 13.2));
                            } else {
                                HBbTbm = (float) ((Bb - 14.3) / (15.5 - 14.3));
                            }
                        } else if (Pb == 97.0) {
                            BbTbm = (float) (Bb - 14.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.4) / (14.4 - 13.3));
                            } else {
                                HBbTbm = (float) ((Bb - 14.4) / (15.6 - 14.4));
                            }
                        } else if (Pb == 97.5) {
                            BbTbm = (float) (Bb - 14.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.5) / (14.5 - 13.4));
                            } else {
                                HBbTbm = (float) ((Bb - 14.5) / (15.7 - 14.5));
                            }
                        } else if (Pb == 98.0) {
                            BbTbm = (float) (Bb - 14.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.6) / (14.6 - 13.5));
                            } else {
                                HBbTbm = (float) ((Bb - 14.6) / (15.9 - 14.6));
                            }
                        } else if (Pb == 98.5) {
                            BbTbm = (float) (Bb - 14.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.8) / (14.8 - 13.6));
                            } else {
                                HBbTbm = (float) ((Bb - 14.8) / (16.0 - 14.8));
                            }
                        } else if (Pb == 99.0) {
                            BbTbm = (float) (Bb - 14.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.9) / (14.9 - 13.7));
                            } else {
                                HBbTbm = (float) ((Bb - 14.9) / (16.2 - 14.9));
                            }
                        } else if (Pb == 99.5) {
                            BbTbm = (float) (Bb - 15.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.0) / (15.0 - 13.9));
                            } else {
                                HBbTbm = (float) ((Bb - 15.0) / (16.3 - 15.0));
                            }
                        } else if (Pb == 100.0) {
                            BbTbm = (float) (Bb - 15.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.2) / (15.2 - 14.0));
                            } else {
                                HBbTbm = (float) ((Bb - 15.2) / (16.5 - 15.2));
                            }
                        } else if (Pb == 100.5) {
                            BbTbm = (float) (Bb - 15.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.3) / (15.3 - 14.1));
                            } else {
                                HBbTbm = (float) ((Bb - 15.3) / (16.6 - 15.3));
                            }
                        } else if (Pb == 101.0) {
                            BbTbm = (float) (Bb - 15.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.4) / (15.4 - 14.2));
                            } else {
                                HBbTbm = (float) ((Bb - 15.4) / (16.8 - 15.5));
                            }
                        } else if (Pb == 101.5) {
                            BbTbm = (float) (Bb - 15.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.6) / (15.6 - 14.4));
                            } else {
                                HBbTbm = (float) ((Bb - 15.6) / (16.9 - 15.6));
                            }
                        } else if (Pb == 102.0) {
                            BbTbm = (float) (Bb - 15.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.7) / (15.7 - 14.5));
                            } else {
                                HBbTbm = (float) ((Bb - 15.7) / (17.1 - 15.7));
                            }
                        } else if (Pb == 102.5) {
                            BbTbm = (float) (Bb - 15.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.9) / (15.9 - 14.6));
                            } else {
                                HBbTbm = (float) ((Bb - 15.9) / (17.3 - 15.9));
                            }
                        } else if (Pb == 103.0) {
                            BbTbm = (float) (Bb - 16.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.0) / (16.0 - 14.8));
                            } else {
                                HBbTbm = (float) ((Bb - 16.0) / (17.4 - 16.0));
                            }
                        } else if (Pb == 103.5) {
                            BbTbm = (float) (Bb - 16.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.2) / (16.2 - 14.9));
                            } else {
                                HBbTbm = (float) ((Bb - 16.2) / (17.6 - 16.2));
                            }
                        } else if (Pb == 104.0) {
                            BbTbm = (float) (Bb - 16.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.3) / (16.3 - 15.0));
                            } else {
                                HBbTbm = (float) ((Bb - 16.3) / (17.8 - 16.3));
                            }
                        } else if (Pb == 104.5) {
                            BbTbm = (float) (Bb - 16.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.5) / (16.5 - 15.2));
                            } else {
                                HBbTbm = (float) ((Bb - 16.5) / (17.9 - 16.5));
                            }
                        } else if (Pb == 105.0) {
                            BbTbm = (float) (Bb - 16.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.6) / (16.6 - 15.3));
                            } else {
                                HBbTbm = (float) ((Bb - 16.6) / (18.1 - 16.6));
                            }
                        } else if (Pb == 105.5) {
                            BbTbm = (float) (Bb - 16.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.8) / (16.8 - 15.4));
                            } else {
                                HBbTbm = (float) ((Bb - 16.8) / (18.3 - 16.8));
                            }
                        } else if (Pb == 106.0) {
                            BbTbm = (float) (Bb - 16.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.9) / (16.9 - 15.6));
                            } else {
                                HBbTbm = (float) ((Bb - 16.9) / (18.5 - 16.9));
                            }
                        } else if (Pb == 106.5) {
                            BbTbm = (float) (Bb - 17.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.1) / (17.1 - 15.7));
                            } else {
                                HBbTbm = (float) ((Bb - 17.1) / (18.6 - 17.1));
                            }
                        } else if (Pb == 107.0) {
                            BbTbm = (float) (Bb - 17.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.3) / (17.3 - 15.9));
                            } else {
                                HBbTbm = (float) ((Bb - 17.3) / (18.8 - 17.3));
                            }
                        } else if (Pb == 107.5) {
                            BbTbm = (float) (Bb - 17.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.4) / (17.4 - 16.0));
                            } else {
                                HBbTbm = (float) ((Bb - 17.4) / (19.0 - 17.4));
                            }
                        } else if (Pb == 108.0) {
                            BbTbm = (float) (Bb - 17.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.6) / (17.6 - 16.2));
                            } else {
                                HBbTbm = (float) ((Bb - 17.6) / (19.2 - 17.6));
                            }
                        } else if (Pb == 108.5) {
                            BbTbm = (float) (Bb - 17.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.8) / (17.8 - 16.3));
                            } else {
                                HBbTbm = (float) ((Bb - 17.8) / (19.4 - 17.8));
                            }
                        } else if (Pb == 109.0) {
                            BbTbm = (float) (Bb - 17.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.9) / (17.9 - 16.5));
                            } else {
                                HBbTbm = (float) ((Bb - 17.9) / (19.6 - 17.9));
                            }
                        } else if (Pb == 109.5) {
                            BbTbm = (float) (Bb - 18.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.1) / (18.1 - 16.6));
                            } else {
                                HBbTbm = (float) ((Bb - 18.1) / (19.8 - 18.1));
                            }
                        } else if (Pb == 110.0) {
                            BbTbm = (float) (Bb - 18.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.3) / (18.3 - 16.8));
                            } else {
                                HBbTbm = (float) ((Bb - 18.3) / (20.0 - 18.3));
                            }
                        }
                    }
                } else if (posisiukur.getSelectedItem().toString().equals("Berdiri")) {
                    if (umur >= 24) {
                        if (Pb == 65.0) {
                            BbTbm = (float) (Bb - 7.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.4) / (7.4 - 6.9));
                            } else {
                                HBbTbm = (float) ((Bb - 7.4) / (8.1 - 7.4));
                            }
                        } else if (Pb == 65.5) {
                            BbTbm = (float) (Bb - 7.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.6) / (7.5 - 7.0));
                            } else {
                                HBbTbm = (float) ((Bb - 7.6) / (8.2 - 7.5));
                            }
                        } else if (Pb == 66.0) {
                            BbTbm = (float) (Bb - 7.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.7) / (7.7 - 7.1));
                            } else {
                                HBbTbm = (float) ((Bb - 7.7) / (8.3 - 7.7));
                            }
                        } else if (Pb == 66.5) {
                            BbTbm = (float) (Bb - 7.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.8) / (7.8 - 7.2));
                            } else {
                                HBbTbm = (float) ((Bb - 7.8) / (8.5 - 7.8));
                            }
                        } else if (Pb == 67.0) {
                            BbTbm = (float) (Bb - 7.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.9) / (7.9 - 7.3));
                            } else {
                                HBbTbm = (float) ((Bb - 7.9) / (8.6 - 7.9));
                            }
                        } else if (Pb == 67.5) {
                            BbTbm = (float) (Bb - 8.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.0) / (8.0 - 7.4));
                            } else {
                                HBbTbm = (float) ((Bb - 8.0) / (8.7 - 8.0));
                            }
                        } else if (Pb == 68.0) {
                            BbTbm = (float) (Bb - 8.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.1) / (8.1 - 7.5));
                            } else {
                                HBbTbm = (float) ((Bb - 8.1) / (8.8 - 8.1));
                            }
                        } else if (Pb == 68.5) {
                            BbTbm = (float) (Bb - 8.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.2) / (8.2 - 7.6));
                            } else {
                                HBbTbm = (float) ((Bb - 8.2) / (9.0 - 8.2));
                            }
                        } else if (Pb == 69.0) {
                            BbTbm = (float) (Bb - 8.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.4) / (8.4 - 7.7));
                            } else {
                                HBbTbm = (float) ((Bb - 8.4) / (9.1 - 8.4));
                            }
                        } else if (Pb == 69.5) {
                            BbTbm = (float) (Bb - 8.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.5) / (8.5 - 7.8));
                            } else {
                                HBbTbm = (float) ((Bb - 8.5) / (9.2 - 8.5));
                            }
                        } else if (Pb == 70.0) {
                            BbTbm = (float) (Bb - 8.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.6) / (8.6 - 7.9));
                            } else {
                                HBbTbm = (float) ((Bb - 8.6) / (9.3 - 8.6));
                            }
                        } else if (Pb == 70.5) {
                            BbTbm = (float) (Bb - 8.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.7) / (8.7 - 8.0));
                            } else {
                                HBbTbm = (float) ((Bb - 8.7) / (9.5 - 8.7));
                            }
                        } else if (Pb == 71.0) {
                            BbTbm = (float) (Bb - 8.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.8) / (8.8 - 8.1));
                            } else {
                                HBbTbm = (float) ((Bb - 8.8) / (9.6 - 8.8));
                            }
                        } else if (Pb == 71.5) {
                            BbTbm = (float) (Bb - 8.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.8) / (8.8 - 8.2));
                            } else {
                                HBbTbm = (float) ((Bb - 8.8) / (9.7 - 8.8));
                            }
                        } else if (Pb == 72.0) {
                            BbTbm = (float) (Bb - 9.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.0) / (9.0 - 8.3));
                            } else {
                                HBbTbm = (float) ((Bb - 9.0) / (9.8 - 9.0));
                            }
                        } else if (Pb == 72.5) {
                            BbTbm = (float) (Bb - 9.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.1) / (9.1 - 8.4));
                            } else {
                                HBbTbm = (float) ((Bb - 9.1) / (9.9 - 9.1));
                            }
                        } else if (Pb == 73.0) {
                            BbTbm = (float) (Bb - 9.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.2) / (9.2 - 8.5));
                            } else {
                                HBbTbm = (float) ((Bb - 9.2) / (10.0 - 9.2));
                            }
                        } else if (Pb == 73.5) {
                            BbTbm = (float) (Bb - 9.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.3) / (9.3 - 8.6));
                            } else {
                                HBbTbm = (float) ((Bb - 9.3) / (10.2 - 9.3));
                            }
                        } else if (Pb == 74.0) {
                            BbTbm = (float) (Bb - 9.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.4) / (9.4 - 8.7));
                            } else {
                                HBbTbm = (float) ((Bb - 9.4) / (10.3 - 9.4));
                            }
                        } else if (Pb == 74.5) {
                            BbTbm = (float) (Bb - 9.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.5) / (9.5 - 8.8));
                            } else {
                                HBbTbm = (float) ((Bb - 9.5) / (10.4 - 9.5));
                            }
                        } else if (Pb == 75.0) {
                            BbTbm = (float) (Bb - 9.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.6) / (9.6 - 8.9));
                            } else {
                                HBbTbm = (float) ((Bb - 9.6) / (10.5 - 9.6));
                            }
                        } else if (Pb == 75.5) {
                            BbTbm = (float) (Bb - 9.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.7) / (9.7 - 9.0));
                            } else {
                                HBbTbm = (float) ((Bb - 9.7) / (10.6 - 9.7));
                            }
                        } else if (Pb == 76.0) {
                            BbTbm = (float) (Bb - 9.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.8) / (9.8 - 9.1));
                            } else {
                                HBbTbm = (float) ((Bb - 9.8) / (10.7 - 9.8));
                            }
                        } else if (Pb == 76.5) {
                            BbTbm = (float) (Bb - 9.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.9) / (9.9 - 9.2));
                            } else {
                                HBbTbm = (float) ((Bb - 9.9) / (10.8 - 9.9));
                            }
                        } else if (Pb == 77.0) {
                            BbTbm = (float) (Bb - 10.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.0) / (10.0 - 9.2));
                            } else {
                                HBbTbm = (float) ((Bb - 10.0) / (10.9 - 10.0));
                            }
                        } else if (Pb == 77.5) {
                            BbTbm = (float) (Bb - 10.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.1) / (10.1 - 9.3));
                            } else {
                                HBbTbm = (float) ((Bb - 10.1) / (11.0 - 10.1));
                            }
                        } else if (Pb == 78.0) {
                            BbTbm = (float) (Bb - 10.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.1) / (10.2 - 9.4));
                            } else {
                                HBbTbm = (float) ((Bb - 10.1) / (11.1 - 10.2));
                            }
                        } else if (Pb == 78.5) {
                            BbTbm = (float) (Bb - 10.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.3) / (10.3 - 9.5));
                            } else {
                                HBbTbm = (float) ((Bb - 10.3) / (11.2 - 10.3));
                            }
                        } else if (Pb == 79.0) {
                            BbTbm = (float) (Bb - 10.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.4) / (10.4 - 9.6));
                            } else {
                                HBbTbm = (float) ((Bb - 10.4) / (11.3 - 10.4));
                            }
                        } else if (Pb == 79.5) {
                            BbTbm = (float) (Bb - 10.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.5) / (10.5 - 9.7));
                            } else {
                                HBbTbm = (float) ((Bb - 10.5) / (11.4 - 10.5));
                            }
                        } else if (Pb == 80.0) {
                            BbTbm = (float) (Bb - 10.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.6) / (10.6 - 9.7));
                            } else {
                                HBbTbm = (float) ((Bb - 10.6) / (11.5 - 10.6));
                            }
                        } else if (Pb == 80.5) {
                            BbTbm = (float) (Bb - 10.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.7) / (10.7 - 9.8));
                            } else {
                                HBbTbm = (float) ((Bb - 10.7) / (11.6 - 10.7));
                            }
                        } else if (Pb == 81.0) {
                            BbTbm = (float) (Bb - 10.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.8) / (10.8 - 9.9));
                            } else {
                                HBbTbm = (float) ((Bb - 10.8) / (11.7 - 10.8));
                            }
                        } else if (Pb == 81.5) {
                            BbTbm = (float) (Bb - 10.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.9) / (10.9 - 10.0));
                            } else {
                                HBbTbm = (float) ((Bb - 10.9) / (11.8 - 10.9));
                            }
                        } else if (Pb == 82.0) {
                            BbTbm = (float) (Bb - 11.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.0) / (11.0 - 10.1));
                            } else {
                                HBbTbm = (float) ((Bb - 11.0) / (11.9 - 11.0));
                            }
                        } else if (Pb == 82.5) {
                            BbTbm = (float) (Bb - 11.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.1) / (11.1 - 10.2));
                            } else {
                                HBbTbm = (float) ((Bb - 11.1) / (12.1 - 11.1));
                            }
                        } else if (Pb == 83.0) {
                            BbTbm = (float) (Bb - 11.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.2) / (11.2 - 10.3));
                            } else {
                                HBbTbm = (float) ((Bb - 11.2) / (12.2 - 11.2));
                            }
                        } else if (Pb == 83.5) {
                            BbTbm = (float) (Bb - 11.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.3) / (11.3 - 10.4));
                            } else {
                                HBbTbm = (float) ((Bb - 11.3) / (12.3 - 11.3));
                            }
                        } else if (Pb == 84.0) {
                            BbTbm = (float) (Bb - 11.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.4) / (11.4 - 10.5));
                            } else {
                                HBbTbm = (float) ((Bb - 11.4) / (12.4 - 11.4));
                            }
                        } else if (Pb == 84.5) {
                            BbTbm = (float) (Bb - 11.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.5) / (11.5 - 10.7));
                            } else {
                                HBbTbm = (float) ((Bb - 11.5) / (12.5 - 11.5));
                            }
                        } else if (Pb == 85.0) {
                            BbTbm = (float) (Bb - 11.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.7) / (11.7 - 10.8));
                            } else {
                                HBbTbm = (float) ((Bb - 11.7) / (12.7 - 11.7));
                            }
                        } else if (Pb == 85.5) {
                            BbTbm = (float) (Bb - 11.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.8) / (11.8 - 10.9));
                            } else {
                                HBbTbm = (float) ((Bb - 11.8) / (12.8 - 11.8));
                            }
                        } else if (Pb == 86.0) {
                            BbTbm = (float) (Bb - 11.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.9) / (11.9 - 11.0));
                            } else {
                                HBbTbm = (float) ((Bb - 11.9) / (12.9 - 11.9));
                            }
                        } else if (Pb == 86.5) {
                            BbTbm = (float) (Bb - 12.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.0) / (12.0 - 11.1));
                            } else {
                                HBbTbm = (float) ((Bb - 12.0) / (13.1 - 12.0));
                            }
                        } else if (Pb == 87.0) {
                            BbTbm = (float) (Bb - 12.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.2) / (12.2 - 11.2));
                            } else {
                                HBbTbm = (float) ((Bb - 12.2) / (13.2 - 12.2));
                            }
                        } else if (Pb == 87.5) {
                            BbTbm = (float) (Bb - 12.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.3) / (12.3 - 11.3));
                            } else {
                                HBbTbm = (float) ((Bb - 12.3) / (13.3 - 12.3));
                            }
                        } else if (Pb == 88.0) {
                            BbTbm = (float) (Bb - 12.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.4) / (12.4 - 11.5));
                            } else {
                                HBbTbm = (float) ((Bb - 12.4) / (13.5 - 12.4));
                            }
                        } else if (Pb == 88.5) {
                            BbTbm = (float) (Bb - 12.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.5) / (12.5 - 11.6));
                            } else {
                                HBbTbm = (float) ((Bb - 12.5) / (13.6 - 12.5));
                            }
                        } else if (Pb == 89.0) {
                            BbTbm = (float) (Bb - 12.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.6) / (12.6 - 11.7));
                            } else {
                                HBbTbm = (float) ((Bb - 12.6) / (13.7 - 12.6));
                            }
                        } else if (Pb == 89.5) {
                            BbTbm = (float) (Bb - 12.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.8) / (12.8 - 11.8));
                            } else {
                                HBbTbm = (float) ((Bb - 12.8) / (13.9 - 12.8));
                            }
                        } else if (Pb == 90.0) {
                            BbTbm = (float) (Bb - 12.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.9) / (12.9 - 11.9));
                            } else {
                                HBbTbm = (float) ((Bb - 12.9) / (14.0 - 12.9));
                            }
                        } else if (Pb == 90.5) {
                            BbTbm = (float) (Bb - 13.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.0) / (13.0 - 12.0));
                            } else {
                                HBbTbm = (float) ((Bb - 13.0) / (14.1 - 13.0));
                            }
                        } else if (Pb == 91.0) {
                            BbTbm = (float) (Bb - 13.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.1) / (13.1 - 12.1));
                            } else {
                                HBbTbm = (float) ((Bb - 13.1) / (14.3 - 13.1));
                            }
                        } else if (Pb == 91.5) {
                            BbTbm = (float) (Bb - 13.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.2) / (13.2 - 12.2));
                            } else {
                                HBbTbm = (float) ((Bb - 13.2) / (14.4 - 13.2));
                            }
                        } else if (Pb == 92.0) {
                            BbTbm = (float) (Bb - 13.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.4) / (13.4 - 12.3));
                            } else {
                                HBbTbm = (float) ((Bb - 13.4) / (14.5 - 13.4));
                            }
                        } else if (Pb == 92.5) {
                            BbTbm = (float) (Bb - 13.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.5) / (13.5 - 12.4));
                            } else {
                                HBbTbm = (float) ((Bb - 13.5) / (14.6 - 13.5));
                            }
                        } else if (Pb == 93.0) {
                            BbTbm = (float) (Bb - 13.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.6) / (13.6 - 12.6));
                            } else {
                                HBbTbm = (float) ((Bb - 13.6) / (14.7 - 13.6));
                            }
                        } else if (Pb == 93.5) {
                            BbTbm = (float) (Bb - 13.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.7) / (13.7 - 12.7));
                            } else {
                                HBbTbm = (float) ((Bb - 13.7) / (14.9 - 13.7));
                            }
                        } else if (Pb == 94.0) {
                            BbTbm = (float) (Bb - 13.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.8) / (13.8 - 12.8));
                            } else {
                                HBbTbm = (float) ((Bb - 13.8) / (15.0 - 13.8));
                            }
                        } else if (Pb == 94.5) {
                            BbTbm = (float) (Bb - 13.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.9) / (13.9 - 12.9));
                            } else {
                                HBbTbm = (float) ((Bb - 13.9) / (15.1 - 13.9));
                            }
                        } else if (Pb == 95.0) {
                            BbTbm = (float) (Bb - 14.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.1) / (14.1 - 13.0));
                            } else {
                                HBbTbm = (float) ((Bb - 14.1) / (15.3 - 14.1));
                            }
                        } else if (Pb == 95.5) {
                            BbTbm = (float) (Bb - 14.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.2) / (14.2 - 13.1));
                            } else {
                                HBbTbm = (float) ((Bb - 14.2) / (15.4 - 14.2));
                            }
                        } else if (Pb == 96.0) {
                            BbTbm = (float) (Bb - 14.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.3) / (14.3 - 13.2));
                            } else {
                                HBbTbm = (float) ((Bb - 14.3) / (15.5 - 14.3));
                            }
                        } else if (Pb == 96.5) {
                            BbTbm = (float) (Bb - 14.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.4) / (14.4 - 13.3));
                            } else {
                                HBbTbm = (float) ((Bb - 14.4) / (15.7 - 14.4));
                            }
                        } else if (Pb == 97.0) {
                            BbTbm = (float) (Bb - 14.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.6) / (14.6 - 13.4));
                            } else {
                                HBbTbm = (float) ((Bb - 14.6) / (15.8 - 14.6));
                            }
                        } else if (Pb == 97.5) {
                            BbTbm = (float) (Bb - 14.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.7) / (14.7 - 13.6));
                            } else {
                                HBbTbm = (float) ((Bb - 14.7) / (15.9 - 14.7));
                            }
                        } else if (Pb == 98.0) {
                            BbTbm = (float) (Bb - 14.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.8) / (14.8 - 13.7));
                            } else {
                                HBbTbm = (float) ((Bb - 14.8) / (16.1 - 14.8));
                            }
                        } else if (Pb == 98.5) {
                            BbTbm = (float) (Bb - 14.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.9) / (14.9 - 13.8));
                            } else {
                                HBbTbm = (float) ((Bb - 14.9) / (16.2 - 14.9));
                            }
                        } else if (Pb == 99.0) {
                            BbTbm = (float) (Bb - 15.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.1) / (15.1 - 13.9));
                            } else {
                                HBbTbm = (float) ((Bb - 15.1) / (16.4 - 15.1));
                            }
                        } else if (Pb == 99.5) {
                            BbTbm = (float) (Bb - 15.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.2) / (15.2 - 14.0));
                            } else {
                                HBbTbm = (float) ((Bb - 15.2) / (16.5 - 15.2));
                            }
                        } else if (Pb == 100.0) {
                            BbTbm = (float) (Bb - 15.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.4) / (15.4 - 14.2));
                            } else {
                                HBbTbm = (float) ((Bb - 15.4) / (16.7 - 15.4));
                            }
                        } else if (Pb == 100.5) {
                            BbTbm = (float) (Bb - 15.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.5) / (15.5 - 14.3));
                            } else {
                                HBbTbm = (float) ((Bb - 15.5) / (16.9 - 15.5));
                            }
                        } else if (Pb == 101.0) {
                            BbTbm = (float) (Bb - 15.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.6) / (15.6 - 14.4));
                            } else {
                                HBbTbm = (float) ((Bb - 15.6) / (17.0 - 15.6));
                            }
                        } else if (Pb == 101.5) {
                            BbTbm = (float) (Bb - 15.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.8) / (15.8 - 14.5));
                            } else {
                                HBbTbm = (float) ((Bb - 15.8) / (17.2 - 15.8));
                            }
                        } else if (Pb == 102.0) {
                            BbTbm = (float) (Bb - 15.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.9) / (15.9 - 14.7));
                            } else {
                                HBbTbm = (float) ((Bb - 15.9) / (17.3 - 15.9));
                            }
                        } else if (Pb == 102.5) {
                            BbTbm = (float) (Bb - 16.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.1) / (16.1 - 14.8));
                            } else {
                                HBbTbm = (float) ((Bb - 16.1) / (17.5 - 16.1));
                            }
                        } else if (Pb == 103.0) {
                            BbTbm = (float) (Bb - 16.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.2) / (16.2 - 14.9));
                            } else {
                                HBbTbm = (float) ((Bb - 16.2) / (17.7 - 16.2));
                            }
                        } else if (Pb == 103.5) {
                            BbTbm = (float) (Bb - 16.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.4) / (16.4 - 15.1));
                            } else {
                                HBbTbm = (float) ((Bb - 16.4) / (17.8 - 16.4));
                            }
                        } else if (Pb == 104.0) {
                            BbTbm = (float) (Bb - 16.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.5) / (16.5 - 15.2));
                            } else {
                                HBbTbm = (float) ((Bb - 16.5) / (18.0 - 16.5));
                            }
                        } else if (Pb == 104.5) {
                            BbTbm = (float) (Bb - 16.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.7) / (16.7 - 15.4));
                            } else {
                                HBbTbm = (float) ((Bb - 16.7) / (18.2 - 16.7));
                            }
                        } else if (Pb == 105.0) {
                            BbTbm = (float) (Bb - 16.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.8) / (16.8 - 15.5));
                            } else {
                                HBbTbm = (float) ((Bb - 16.8) / (18.4 - 16.8));
                            }
                        } else if (Pb == 104.5) {
                            BbTbm = (float) (Bb - 17.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.0) / (17.0 - 15.6));
                            } else {
                                HBbTbm = (float) ((Bb - 17.0) / (18.5 - 17.0));
                            }
                        } else if (Pb == 106.0) {
                            BbTbm = (float) (Bb - 17.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.2) / (17.2 - 15.8));
                            } else {
                                HBbTbm = (float) ((Bb - 17.2) / (18.7 - 17.2));
                            }
                        } else if (Pb == 106.5) {
                            BbTbm = (float) (Bb - 17.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.3) / (17.3 - 15.9));
                            } else {
                                HBbTbm = (float) ((Bb - 17.3) / (18.9 - 17.3));
                            }
                        } else if (Pb == 107.0) {
                            BbTbm = (float) (Bb - 17.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.5) / (17.5 - 16.1));
                            } else {
                                HBbTbm = (float) ((Bb - 17.5) / (19.1 - 17.5));
                            }
                        } else if (Pb == 107.5) {
                            BbTbm = (float) (Bb - 17.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.7) / (17.7 - 16.2));
                            } else {
                                HBbTbm = (float) ((Bb - 17.7) / (19.3 - 17.7));
                            }
                        } else if (Pb == 108.0) {
                            BbTbm = (float) (Bb - 17.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.8) / (17.8 - 16.4));
                            } else {
                                HBbTbm = (float) ((Bb - 17.8) / (19.5 - 17.8));
                            }
                        } else if (Pb == 108.5) {
                            BbTbm = (float) (Bb - 18.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.0) / (18.0 - 16.5));
                            } else {
                                HBbTbm = (float) ((Bb - 18.0) / (19.7 - 18.0));
                            }
                        } else if (Pb == 109.0) {
                            BbTbm = (float) (Bb - 18.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.2) / (18.2 - 16.7));
                            } else {
                                HBbTbm = (float) ((Bb - 18.2) / (19.8 - 18.2));
                            }
                        } else if (Pb == 109.5) {
                            BbTbm = (float) (Bb - 18.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.3) / (18.3 - 16.8));
                            } else {
                                HBbTbm = (float) ((Bb - 18.3) / (20.0 - 18.3));
                            }
                        } else if (Pb == 110.0) {
                            BbTbm = (float) (Bb - 18.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.5) / (18.5 - 17.0));
                            } else {
                                HBbTbm = (float) ((Bb - 18.5) / (20.2 - 18.5));
                            }
                        } else if (Pb == 110.5) {
                            BbTbm = (float) (Bb - 18.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.7) / (18.7 - 17.1));
                            } else {
                                HBbTbm = (float) ((Bb - 18.7) / (20.4 - 18.7));
                            }
                        } else if (Pb == 111.0) {
                            BbTbm = (float) (Bb - 18.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.9) / (18.9 - 17.3));
                            } else {
                                HBbTbm = (float) ((Bb - 18.9) / (20.7 - 18.9));
                            }
                        } else if (Pb == 111.5) {
                            BbTbm = (float) (Bb - 19.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 19.1) / (19.1 - 17.5));
                            } else {
                                HBbTbm = (float) ((Bb - 19.1) / (20.9 - 19.1));
                            }
                        } else if (Pb == 112.0) {
                            BbTbm = (float) (Bb - 19.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 19.2) / (19.2 - 17.6));
                            } else {
                                HBbTbm = (float) ((Bb - 19.2) / (21.1 - 19.2));
                            }
                        } else if (Pb == 112.5) {
                            BbTbm = (float) (Bb - 19.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 19.4) / (19.4 - 17.8));
                            } else {
                                HBbTbm = (float) ((Bb - 19.4) / (21.3 - 19.4));
                            }
                        } else if (Pb == 113.0) {
                            BbTbm = (float) (Bb - 19.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 19.6) / (19.6 - 18.0));
                            } else {
                                HBbTbm = (float) ((Bb - 19.6) / (21.5 - 19.6));
                            }
                        } else if (Pb == 113.5) {
                            BbTbm = (float) (Bb - 19.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 19.8) / (19.8 - 18.1));
                            } else {
                                HBbTbm = (float) ((Bb - 19.8) / (21.7 - 19.8));
                            }
                        } else if (Pb == 114.0) {
                            BbTbm = (float) (Bb - 20.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 20.0) / (20.0 - 18.3));
                            } else {
                                HBbTbm = (float) ((Bb - 20.0) / (21.9 - 20.0));
                            }
                        } else if (Pb == 114.5) {
                            BbTbm = (float) (Bb - 20.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 20.2) / (20.2 - 18.5));
                            } else {
                                HBbTbm = (float) ((Bb - 20.2) / (22.1 - 20.2));
                            }
                        } else if (Pb == 115.0) {
                            BbTbm = (float) (Bb - 20.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 20.4) / (20.4 - 18.6));
                            } else {
                                HBbTbm = (float) ((Bb - 20.4) / (22.4 - 20.4));
                            }
                        } else if (Pb == 115.5) {
                            BbTbm = (float) (Bb - 20.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 20.6) / (20.6 - 18.8));
                            } else {
                                HBbTbm = (float) ((Bb - 20.6) / (22.6 - 20.6));
                            }
                        } else if (Pb == 116.0) {
                            BbTbm = (float) (Bb - 20.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 20.8) / (20.8 - 19.0));
                            } else {
                                HBbTbm = (float) ((Bb - 20.8) / (22.8 - 20.8));
                            }
                        } else if (Pb == 116.5) {
                            BbTbm = (float) (Bb - 21.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 21.0) / (21.0 - 19.2));
                            } else {
                                HBbTbm = (float) ((Bb - 21.0) / (23.0 - 21.0));
                            }
                        } else if (Pb == 117.0) {
                            BbTbm = (float) (Bb - 21.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 21.2) / (21.2 - 19.3));
                            } else {
                                HBbTbm = (float) ((Bb - 21.2) / (23.3 - 21.2));
                            }
                        } else if (Pb == 117.5) {
                            BbTbm = (float) (Bb - 21.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 21.4) / (21.4 - 19.5));
                            } else {
                                HBbTbm = (float) ((Bb - 21.4) / (23.5 - 21.4));
                            }
                        } else if (Pb == 118.0) {
                            BbTbm = (float) (Bb - 21.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 21.6) / (21.6 - 19.7));
                            } else {
                                HBbTbm = (float) ((Bb - 21.6) / (23.7 - 21.6));
                            }
                        } else if (Pb == 118.5) {
                            BbTbm = (float) (Bb - 21.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 21.8) / (21.8 - 19.9));
                            } else {
                                HBbTbm = (float) ((Bb - 21.8) / (23.9 - 21.8));
                            }
                        } else if (Pb == 119.0) {
                            BbTbm = (float) (Bb - 22.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 22.0) / (22.0 - 20.0));
                            } else {
                                HBbTbm = (float) ((Bb - 22.0) / (24.1 - 22.0));
                            }
                        } else if (Pb == 119.5) {
                            BbTbm = (float) (Bb - 22.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 22.2) / (22.2 - 20.2));
                            } else {
                                HBbTbm = (float) ((Bb - 22.2) / (24.4 - 22.2));
                            }
                        } else if (Pb == 120.0) {
                            BbTbm = (float) (Bb - 22.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 22.4) / (22.4 - 20.4));
                            } else {
                                HBbTbm = (float) ((Bb - 22.4) / (24.6 - 22.4));
                            }
                        }
                    } else {
                        HBbTbm = 4;
                    }
                }
            }
            //Data Perempuan
            else if (jeniskelamin.getSelectedItem().toString().equals("Perempuan")) {
                if (posisiukur.getSelectedItem().toString().equals("Terlentang")) {
                    if (umur <= 24) {
                        if (Pb == 45.0) {
                            BbTbm = (float) (Bb - 2.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 2.5) / (2.5 - 2.3));
                            } else {
                                HBbTbm = (float) ((Bb - 2.5) / (2.7 - 2.5));
                            }
                        } else if (Pb == 45.5) {
                            BbTbm = (float) (Bb - 2.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 2.5) / (2.5 - 2.3));
                            } else {
                                HBbTbm = (float) ((Bb - 2.5) / (2.8 - 2.5));
                            }
                        } else if (Pb == 46.0) {
                            BbTbm = (float) (Bb - 2.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 2.6) / (2.6 - 2.4));
                            } else {
                                HBbTbm = (float) ((Bb - 2.6) / (2.9 - 2.6));
                            }
                        } else if (Pb == 46.5) {
                            BbTbm = (float) (Bb - 2.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 2.7) / (2.7 - 2.5));
                            } else {
                                HBbTbm = (float) ((Bb - 2.7) / (3.0 - 2.7));
                            }
                        } else if (Pb == 47.0) {
                            BbTbm = (float) (Bb - 2.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 2.8) / (2.8 - 2.6));
                            } else {
                                HBbTbm = (float) ((Bb - 2.8) / (3.1 - 2.8));
                            }
                        } else if (Pb == 47.5) {
                            BbTbm = (float) (Bb - 2.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 2.9) / (2.9 - 2.6));
                            } else {
                                HBbTbm = (float) ((Bb - 2.9) / (3.2 - 2.9));
                            }
                        } else if (Pb == 48.0) {
                            BbTbm = (float) (Bb - 3.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.0) / (3.0 - 2.7));
                            } else {
                                HBbTbm = (float) ((Bb - 3.0) / (3.3 - 3.0));
                            }
                        } else if (Pb == 48.5) {
                            BbTbm = (float) (Bb - 3.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.1) / (3.1 - 2.8));
                            } else {
                                HBbTbm = (float) ((Bb - 3.1) / (3.4 - 3.1));
                            }
                        } else if (Pb == 49.0) {
                            BbTbm = (float) (Bb - 3.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.2) / (3.2 - 2.9));
                            } else {
                                HBbTbm = (float) ((Bb - 3.2) / (3.5 - 3.2));
                            }
                        } else if (Pb == 49.5) {
                            BbTbm = (float) (Bb - 3.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.3) / (3.3 - 3.0));
                            } else {
                                HBbTbm = (float) ((Bb - 3.3) / (3.6 - 3.3));
                            }
                        } else if (Pb == 50.0) {
                            BbTbm = (float) (Bb - 3.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.4) / (3.4 - 3.1));
                            } else {
                                HBbTbm = (float) ((Bb - 3.4) / (3.7 - 3.4));
                            }
                        } else if (Pb == 50.5) {
                            BbTbm = (float) (Bb - 3.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.5) / (3.5 - 3.2));
                            } else {
                                HBbTbm = (float) ((Bb - 3.5) / (3.8 - 3.5));
                            }
                        } else if (Pb == 51.0) {
                            BbTbm = (float) (Bb - 3.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.6) / (3.6 - 3.3));
                            } else {
                                HBbTbm = (float) ((Bb - 3.6) / (3.9 - 3.6));
                            }
                        } else if (Pb == 51.5) {
                            BbTbm = (float) (Bb - 3.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.7) / (3.7 - 3.4));
                            } else {
                                HBbTbm = (float) ((Bb - 3.6) / (4.0 - 3.7));
                            }
                        } else if (Pb == 52.0) {
                            BbTbm = (float) (Bb - 3.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.8) / (3.8 - 3.5));
                            } else {
                                HBbTbm = (float) ((Bb - 3.8) / (4.2 - 3.8));
                            }
                        } else if (Pb == 52.5) {
                            BbTbm = (float) (Bb - 3.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 3.9) / (3.9 - 3.6));
                            } else {
                                HBbTbm = (float) ((Bb - 3.9) / (4.3 - 3.9));
                            }
                        } else if (Pb == 53.0) {
                            BbTbm = (float) (Bb - 4.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.0) / (4.0 - 3.7));
                            } else {
                                HBbTbm = (float) ((Bb - 4.0) / (4.4 - 4.0));
                            }
                        } else if (Pb == 53.5) {
                            BbTbm = (float) (Bb - 4.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.2) / (4.2 - 3.8));
                            } else {
                                HBbTbm = (float) ((Bb - 4.2) / (4.6 - 4.2));
                            }
                        } else if (Pb == 54.0) {
                            BbTbm = (float) (Bb - 4.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.3) / (4.3 - 3.9));
                            } else {
                                HBbTbm = (float) ((Bb - 4.3) / (4.7 - 4.3));
                            }
                        } else if (Pb == 54.5) {
                            BbTbm = (float) (Bb - 4.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.4) / (4.4 - 4.0));
                            } else {
                                HBbTbm = (float) ((Bb - 4.4) / (4.8 - 4.4));
                            }
                        } else if (Pb == 55.0) {
                            BbTbm = (float) (Bb - 4.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.5) / (4.5 - 4.2));
                            } else {
                                HBbTbm = (float) ((Bb - 4.5) / (5.0 - 4.5));
                            }
                        } else if (Pb == 55.5) {
                            BbTbm = (float) (Bb - 4.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.7) / (4.7 - 4.3));
                            } else {
                                HBbTbm = (float) ((Bb - 4.7) / (5.1 - 4.7));
                            }
                        } else if (Pb == 56.0) {
                            BbTbm = (float) (Bb - 4.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 4.8) / (4.8 - 4.4));
                            } else {
                                HBbTbm = (float) ((Bb - 4.8) / (5.3 - 4.8));
                            }
                        } else if (Pb == 56.5) {
                            BbTbm = (float) (Bb - 5.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.0) / (5.0 - 4.5));
                            } else {
                                HBbTbm = (float) ((Bb - 5.0) / (5.4 - 5.0));
                            }
                        } else if (Pb == 57.0) {
                            BbTbm = (float) (Bb - 5.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.1) / (5.1 - 4.6));
                            } else {
                                HBbTbm = (float) ((Bb - 5.1) / (5.6 - 5.1));
                            }
                        } else if (Pb == 57.5) {
                            BbTbm = (float) (Bb - 5.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.2) / (5.2 - 4.8));
                            } else {
                                HBbTbm = (float) ((Bb - 5.2) / (5.7 - 5.2));
                            }
                        } else if (Pb == 58.0) {
                            BbTbm = (float) (Bb - 5.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.4) / (5.4 - 4.9));
                            } else {
                                HBbTbm = (float) ((Bb - 5.4) / (5.9 - 5.4));
                            }
                        } else if (Pb == 58.5) {
                            BbTbm = (float) (Bb - 5.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.5) / (5.5 - 5.0));
                            } else {
                                HBbTbm = (float) ((Bb - 5.5) / (6.0 - 5.5));
                            }
                        } else if (Pb == 59.0) {
                            BbTbm = (float) (Bb - 5.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.6) / (5.6 - 5.1));
                            } else {
                                HBbTbm = (float) ((Bb - 5.6) / (6.2 - 5.6));
                            }
                        } else if (Pb == 59.5) {
                            BbTbm = (float) (Bb - 5.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.7) / (5.7 - 5.3));
                            } else {
                                HBbTbm = (float) ((Bb - 5.7) / (6.3 - 5.7));
                            }
                        } else if (Pb == 60.0) {
                            BbTbm = (float) (Bb - 5.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 5.9) / (5.9 - 5.4));
                            } else {
                                HBbTbm = (float) ((Bb - 5.9) / (6.4 - 5.9));
                            }
                        } else if (Pb == 60.5) {
                            BbTbm = (float) (Bb - 6.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.0) / (6.0 - 5.5));
                            } else {
                                HBbTbm = (float) ((Bb - 6.0) / (6.6 - 6.0));
                            }
                        } else if (Pb == 61.0) {
                            BbTbm = (float) (Bb - 6.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.1) / (6.1 - 5.6));
                            } else {
                                HBbTbm = (float) ((Bb - 6.1) / (6.7 - 6.1));
                            }
                        } else if (Pb == 61.5) {
                            BbTbm = (float) (Bb - 6.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.3) / (6.3 - 5.7));
                            } else {
                                HBbTbm = (float) ((Bb - 6.3) / (6.9 - 6.3));
                            }
                        } else if (Pb == 62.0) {
                            BbTbm = (float) (Bb - 6.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.4) / (6.4 - 5.8));
                            } else {
                                HBbTbm = (float) ((Bb - 6.4) / (7.0 - 6.4));
                            }
                        } else if (Pb == 62.5) {
                            BbTbm = (float) (Bb - 6.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.5) / (6.5 - 5.9));
                            } else {
                                HBbTbm = (float) ((Bb - 6.5) / (7.1 - 6.5));
                            }
                        } else if (Pb == 63.0) {
                            BbTbm = (float) (Bb - 6.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.6) / (6.6 - 6.0));
                            } else {
                                HBbTbm = (float) ((Bb - 6.6) / (7.3 - 6.6));
                            }
                        } else if (Pb == 63.5) {
                            BbTbm = (float) (Bb - 6.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.7) / (6.7 - 6.2));
                            } else {
                                HBbTbm = (float) ((Bb - 6.7) / (7.4 - 6.7));
                            }
                        } else if (Pb == 64.0) {
                            BbTbm = (float) (Bb - 6.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 6.9) / (6.9 - 6.3));
                            } else {
                                HBbTbm = (float) ((Bb - 6.9) / (7.5 - 6.9));
                            }
                        } else if (Pb == 64.5) {
                            BbTbm = (float) (Bb - 7.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.0) / (7.0 - 6.4));
                            } else {
                                HBbTbm = (float) ((Bb - 7.0) / (7.6 - 7.0));
                            }
                        } else if (Pb == 65.0) {
                            BbTbm = (float) (Bb - 7.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.1) / (7.1 - 6.5));
                            } else {
                                HBbTbm = (float) ((Bb - 7.1) / (7.8 - 7.1));
                            }
                        } else if (Pb == 65.5) {
                            BbTbm = (float) (Bb - 7.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.2) / (7.2 - 6.6));
                            } else {
                                HBbTbm = (float) ((Bb - 7.2) / (7.9 - 7.2));
                            }
                        } else if (Pb == 66.0) {
                            BbTbm = (float) (Bb - 7.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.3) / (7.3 - 6.7));
                            } else {
                                HBbTbm = (float) ((Bb - 7.3) / (8.0 - 7.3));
                            }
                        } else if (Pb == 66.5) {
                            BbTbm = (float) (Bb - 7.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.4) / (7.4 - 6.8));
                            } else {
                                HBbTbm = (float) ((Bb - 7.4) / (8.1 - 7.4));
                            }
                        } else if (Pb == 67.0) {
                            BbTbm = (float) (Bb - 7.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.5) / (7.5 - 6.9));
                            } else {
                                HBbTbm = (float) ((Bb - 7.5) / (8.3 - 7.5));
                            }
                        } else if (Pb == 67.5) {
                            BbTbm = (float) (Bb - 7.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.6) / (7.6 - 7.0));
                            } else {
                                HBbTbm = (float) ((Bb - 7.6) / (8.4 - 7.6));
                            }
                        } else if (Pb == 68.0) {
                            BbTbm = (float) (Bb - 7.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.7) / (7.7 - 7.1));
                            } else {
                                HBbTbm = (float) ((Bb - 7.7) / (8.5 - 7.7));
                            }
                        } else if (Pb == 68.5) {
                            BbTbm = (float) (Bb - 7.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.9) / (7.9 - 7.2));
                            } else {
                                HBbTbm = (float) ((Bb - 7.9) / (8.6 - 7.9));
                            }
                        } else if (Pb == 69.0) {
                            BbTbm = (float) (Bb - 8.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.0) / (8.0 - 7.3));
                            } else {
                                HBbTbm = (float) ((Bb - 8.0) / (8.7 - 8.0));
                            }
                        } else if (Pb == 69.5) {
                            BbTbm = (float) (Bb - 8.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.1) / (8.1 - 7.4));
                            } else {
                                HBbTbm = (float) ((Bb - 8.1) / (8.8 - 8.1));
                            }
                        } else if (Pb == 70.0) {
                            BbTbm = (float) (Bb - 8.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.2) / (8.2 - 7.5));
                            } else {
                                HBbTbm = (float) ((Bb - 8.2) / (9.0 - 8.2));
                            }
                        } else if (Pb == 70.5) {
                            BbTbm = (float) (Bb - 8.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.3) / (8.3 - 7.6));
                            } else {
                                HBbTbm = (float) ((Bb - 8.3) / (9.1 - 8.3));
                            }
                        } else if (Pb == 71.0) {
                            BbTbm = (float) (Bb - 8.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.4) / (8.4 - 7.7));
                            } else {
                                HBbTbm = (float) ((Bb - 8.4) / (9.2 - 8.4));
                            }
                        } else if (Pb == 71.5) {
                            BbTbm = (float) (Bb - 8.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.5) / (8.5 - 7.7));
                            } else {
                                HBbTbm = (float) ((Bb - 8.5) / (9.3 - 8.8));
                            }
                        } else if (Pb == 72.0) {
                            BbTbm = (float) (Bb - 8.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.6) / (8.6 - 7.8));
                            } else {
                                HBbTbm = (float) ((Bb - 8.6) / (9.4 - 8.6));
                            }
                        } else if (Pb == 72.5) {
                            BbTbm = (float) (Bb - 8.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.7) / (8.7 - 7.9));
                            } else {
                                HBbTbm = (float) ((Bb - 8.7) / (9.5 - 8.7));
                            }
                        } else if (Pb == 73.0) {
                            BbTbm = (float) (Bb - 8.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.8) / (8.8 - 8.0));
                            } else {
                                HBbTbm = (float) ((Bb - 8.8) / (9.6 - 8.8));
                            }
                        } else if (Pb == 73.5) {
                            BbTbm = (float) (Bb - 8.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.9) / (8.9 - 8.1));
                            } else {
                                HBbTbm = (float) ((Bb - 8.9) / (9.7 - 8.9));
                            }
                        } else if (Pb == 74.0) {
                            BbTbm = (float) (Bb - 9.);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.0) / (9.0 - 8.2));
                            } else {
                                HBbTbm = (float) ((Bb - 9.0) / (9.8 - 9.0));
                            }
                        } else if (Pb == 74.5) {
                            BbTbm = (float) (Bb - 9.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.1) / (9.1 - 8.3));
                            } else {
                                HBbTbm = (float) ((Bb - 9.1) / (9.9 - 9.1));
                            }
                        } else if (Pb == 75.0) {
                            BbTbm = (float) (Bb - 9.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.1) / (9.1 - 8.4));
                            } else {
                                HBbTbm = (float) ((Bb - 9.1) / (10.0 - 9.1));
                            }
                        } else if (Pb == 75.5) {
                            BbTbm = (float) (Bb - 9.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.2) / (9.2 - 8.5));
                            } else {
                                HBbTbm = (float) ((Bb - 9.2) / (10.1 - 9.2));
                            }
                        } else if (Pb == 76.0) {
                            BbTbm = (float) (Bb - 9.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.3) / (9.3 - 8.5));
                            } else {
                                HBbTbm = (float) ((Bb - 9.7) / (10.2 - 9.3));
                            }
                        } else if (Pb == 76.5) {
                            BbTbm = (float) (Bb - 9.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.4) / (9.4 - 8.6));
                            } else {
                                HBbTbm = (float) ((Bb - 9.4) / (10.3 - 9.4));
                            }
                        } else if (Pb == 77.0) {
                            BbTbm = (float) (Bb - 9.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.5) / (9.5 - 8.7));
                            } else {
                                HBbTbm = (float) ((Bb - 9.5) / (10.4 - 9.5));
                            }
                        } else if (Pb == 77.5) {
                            BbTbm = (float) (Bb - 9.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.6) / (9.6 - 8.8));
                            } else {
                                HBbTbm = (float) ((Bb - 10.0) / (10.5 - 9.6));
                            }
                        } else if (Pb == 78.0) {
                            BbTbm = (float) (Bb - 9.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.7) / (9.7 - 8.9));
                            } else {
                                HBbTbm = (float) ((Bb - 9.7) / (10.6 - 9.7));
                            }
                        } else if (Pb == 78.5) {
                            BbTbm = (float) (Bb - 9.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.8) / (9.8 - 9.0));
                            } else {
                                HBbTbm = (float) ((Bb - 9.8) / (10.7 - 9.8));
                            }
                        } else if (Pb == 79.0) {
                            BbTbm = (float) (Bb - 9.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.9) / (9.9 - 9.1));
                            } else {
                                HBbTbm = (float) ((Bb - 9.9) / (10.8 - 9.9));
                            }
                        } else if (Pb == 79.5) {
                            BbTbm = (float) (Bb - 10.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.0) / (10.0 - 9.1));
                            } else {
                                HBbTbm = (float) ((Bb - 10.0) / (10.9 - 10.0));
                            }
                        } else if (Pb == 80.0) {
                            BbTbm = (float) (Bb - 10.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.1) / (10.1 - 9.2));
                            } else {
                                HBbTbm = (float) ((Bb - 10.1) / (11.0 - 10.1));
                            }
                        } else if (Pb == 80.5) {
                            BbTbm = (float) (Bb - 10.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.2) / (10.2 - 9.3));
                            } else {
                                HBbTbm = (float) ((Bb - 10.2) / (11.2 - 10.2));
                            }
                        } else if (Pb == 81.0) {
                            BbTbm = (float) (Bb - 10.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.3) / (10.3 - 9.4));
                            } else {
                                HBbTbm = (float) ((Bb - 10.6) / (11.3 - 10.3));
                            }
                        } else if (Pb == 81.5) {
                            BbTbm = (float) (Bb - 10.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.4) / (10.4 - 9.5));
                            } else {
                                HBbTbm = (float) ((Bb - 10.4) / (11.4 - 10.4));
                            }
                        } else if (Pb == 82.0) {
                            BbTbm = (float) (Bb - 10.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.5) / (10.5 - 9.6));
                            } else {
                                HBbTbm = (float) ((Bb - 10.5) / (11.5 - 10.5));
                            }
                        } else if (Pb == 82.5) {
                            BbTbm = (float) (Bb - 10.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.6) / (10.6 - 9.7));
                            } else {
                                HBbTbm = (float) ((Bb - 10.6) / (11.6 - 10.6));
                            }
                        } else if (Pb == 83.0) {
                            BbTbm = (float) (Bb - 10.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.7) / (10.7 - 9.8));
                            } else {
                                HBbTbm = (float) ((Bb - 10.7) / (11.8 - 10.7));
                            }
                        } else if (Pb == 83.5) {
                            BbTbm = (float) (Bb - 10.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.9) / (10.9 - 9.9));
                            } else {
                                HBbTbm = (float) ((Bb - 10.9) / (11.9 - 10.9));
                            }
                        } else if (Pb == 84.0) {
                            BbTbm = (float) (Bb - 11.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.0) / (11.0 - 10.1));
                            } else {
                                HBbTbm = (float) ((Bb - 11.0) / (12.0 - 11.0));
                            }
                        } else if (Pb == 84.5) {
                            BbTbm = (float) (Bb - 11.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.1) / (11.1 - 10.2));
                            } else {
                                HBbTbm = (float) ((Bb - 11.1) / (12.1 - 11.1));
                            }
                        } else if (Pb == 85.0) {
                            BbTbm = (float) (Bb - 11.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.2) / (11.2 - 10.3));
                            } else {
                                HBbTbm = (float) ((Bb - 11.2) / (12.3 - 11.2));
                            }
                        } else if (Pb == 85.5) {
                            BbTbm = (float) (Bb - 11.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.3) / (11.3 - 10.4));
                            } else {
                                HBbTbm = (float) ((Bb - 11.3) / (12.4 - 11.3));
                            }
                        } else if (Pb == 86.0) {
                            BbTbm = (float) (Bb - 11.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.5) / (11.5 - 10.5));
                            } else {
                                HBbTbm = (float) ((Bb - 11.5) / (12.6 - 11.5));
                            }
                        } else if (Pb == 86.5) {
                            BbTbm = (float) (Bb - 11.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.6) / (11.6 - 10.6));
                            } else {
                                HBbTbm = (float) ((Bb - 11.6) / (12.7 - 11.6));
                            }
                        } else if (Pb == 87.0) {
                            BbTbm = (float) (Bb - 11.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.7) / (11.7 - 10.7));
                            } else {
                                HBbTbm = (float) ((Bb - 11.7) / (12.8 - 11.7));
                            }
                        } else if (Pb == 87.5) {
                            BbTbm = (float) (Bb - 11.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.8) / (11.8 - 10.9));
                            } else {
                                HBbTbm = (float) ((Bb - 11.8) / (13.0 - 11.8));
                            }
                        } else if (Pb == 88.0) {
                            BbTbm = (float) (Bb - 12.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.0) / (12.0 - 11.0));
                            } else {
                                HBbTbm = (float) ((Bb - 12.0) / (13.1 - 12.0));
                            }
                        } else if (Pb == 88.5) {
                            BbTbm = (float) (Bb - 12.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.1) / (12.1 - 11.1));
                            } else {
                                HBbTbm = (float) ((Bb - 12.1) / (13.2 - 12.1));
                            }
                        } else if (Pb == 89.0) {
                            BbTbm = (float) (Bb - 12.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.2) / (12.2 - 11.2));
                            } else {
                                HBbTbm = (float) ((Bb - 12.2) / (13.4 - 12.2));
                            }
                        } else if (Pb == 89.5) {
                            BbTbm = (float) (Bb - 12.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.3) / (12.3 - 11.3));
                            } else {
                                HBbTbm = (float) ((Bb - 12.3) / (13.5 - 12.3));
                            }
                        } else if (Pb == 90.0) {
                            BbTbm = (float) (Bb - 12.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.5) / (12.5 - 11.4));
                            } else {
                                HBbTbm = (float) ((Bb - 12.5) / (13.7 - 12.5));
                            }
                        } else if (Pb == 90.5) {
                            BbTbm = (float) (Bb - 12.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.6) / (12.6 - 11.5));
                            } else {
                                HBbTbm = (float) ((Bb - 12.6) / (13.8 - 12.6));
                            }
                        } else if (Pb == 91.0) {
                            BbTbm = (float) (Bb - 12.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.7) / (12.7 - 11.7));
                            } else {
                                HBbTbm = (float) ((Bb - 12.7) / (13.9 - 12.7));
                            }
                        } else if (Pb == 91.5) {
                            BbTbm = (float) (Bb - 12.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.8) / (12.8 - 11.8));
                            } else {
                                HBbTbm = (float) ((Bb - 12.8) / (14.1 - 12.8));
                            }
                        } else if (Pb == 92.0) {
                            BbTbm = (float) (Bb - 13.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.0) / (13.0 - 11.9));
                            } else {
                                HBbTbm = (float) ((Bb - 13.0) / (14.2 - 13.0));
                            }
                        } else if (Pb == 92.5) {
                            BbTbm = (float) (Bb - 13.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.1) / (13.1 - 12.0));
                            } else {
                                HBbTbm = (float) ((Bb - 13.1) / (14.3 - 13.1));
                            }
                        } else if (Pb == 93.0) {
                            BbTbm = (float) (Bb - 13.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.2) / (13.2 - 12.1));
                            } else {
                                HBbTbm = (float) ((Bb - 13.2) / (14.5 - 13.2));
                            }
                        } else if (Pb == 93.5) {
                            BbTbm = (float) (Bb - 13.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.3) / (13.3 - 12.2));
                            } else {
                                HBbTbm = (float) ((Bb - 13.3) / (14.6 - 13.3));
                            }
                        } else if (Pb == 94.0) {
                            BbTbm = (float) (Bb - 13.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.5) / (13.5 - 12.3));
                            } else {
                                HBbTbm = (float) ((Bb - 13.5) / (14.7 - 13.5));
                            }
                        } else if (Pb == 94.5) {
                            BbTbm = (float) (Bb - 13.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.6) / (13.6 - 12.4));
                            } else {
                                HBbTbm = (float) ((Bb - 13.6) / (14.9 - 13.6));
                            }
                        } else if (Pb == 95.0) {
                            BbTbm = (float) (Bb - 13.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.7) / (13.7 - 12.6));
                            } else {
                                HBbTbm = (float) ((Bb - 13.7) / (15.0 - 13.));
                            }
                        } else if (Pb == 95.5) {
                            BbTbm = (float) (Bb - 13.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.8) / (13.8 - 12.7));
                            } else {
                                HBbTbm = (float) ((Bb - 14.8) / (15.2 - 13.8));
                            }
                        } else if (Pb == 96.0) {
                            BbTbm = (float) (Bb - 14.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.0) / (14.0 - 12.8));
                            } else {
                                HBbTbm = (float) ((Bb - 14.0) / (15.3 - 14.0));
                            }
                        } else if (Pb == 96.5) {
                            BbTbm = (float) (Bb - 14.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.1) / (14.1 - 12.9));
                            } else {
                                HBbTbm = (float) ((Bb - 14.1) / (15.4 - 14.1));
                            }
                        } else if (Pb == 97.0) {
                            BbTbm = (float) (Bb - 14.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.2) / (14.2 - 13.0));
                            } else {
                                HBbTbm = (float) ((Bb - 14.2) / (15.6 - 14.2));
                            }
                        } else if (Pb == 97.5) {
                            BbTbm = (float) (Bb - 14.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.4) / (14.4 - 13.1));
                            } else {
                                HBbTbm = (float) ((Bb - 14.4) / (15.7 - 14.4));
                            }
                        } else if (Pb == 98.0) {
                            BbTbm = (float) (Bb - 14.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.5) / (14.5 - 13.3));
                            } else {
                                HBbTbm = (float) ((Bb - 14.5) / (15.9 - 14.5));
                            }
                        } else if (Pb == 98.5) {
                            BbTbm = (float) (Bb - 14.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.6) / (14.6 - 13.4));
                            } else {
                                HBbTbm = (float) ((Bb - 14.6) / (16.0 - 14.6));
                            }
                        } else if (Pb == 99.0) {
                            BbTbm = (float) (Bb - 14.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.8) / (14.8 - 13.5));
                            } else {
                                HBbTbm = (float) ((Bb - 14.8) / (16.2 - 14.8));
                            }
                        } else if (Pb == 99.5) {
                            BbTbm = (float) (Bb - 14.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.9) / (14.9 - 13.6));
                            } else {
                                HBbTbm = (float) ((Bb - 14.9) / (16.3 - 14.9));
                            }
                        } else if (Pb == 100.0) {
                            BbTbm = (float) (Bb - 15.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.0) / (15.0 - 13.7));
                            } else {
                                HBbTbm = (float) ((Bb - 15.0) / (16.5 - 15.0));
                            }
                        } else if (Pb == 100.5) {
                            BbTbm = (float) (Bb - 15.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.2) / (15.2 - 13.9));
                            } else {
                                HBbTbm = (float) ((Bb - 15.2) / (16.6 - 15.2));
                            }
                        } else if (Pb == 101.0) {
                            BbTbm = (float) (Bb - 15.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.3) / (15.3 - 14.0));
                            } else {
                                HBbTbm = (float) ((Bb - 15.3) / (16.8 - 15.3));
                            }
                        } else if (Pb == 101.5) {
                            BbTbm = (float) (Bb - 15.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.5) / (15.5 - 14.1));
                            } else {
                                HBbTbm = (float) ((Bb - 15.5) / (17.0 - 15.5));
                            }
                        } else if (Pb == 102.0) {
                            BbTbm = (float) (Bb - 15.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.6) / (15.6 - 14.3));
                            } else {
                                HBbTbm = (float) ((Bb - 15.6) / (17.1 - 15.6));
                            }
                        } else if (Pb == 102.5) {
                            BbTbm = (float) (Bb - 15.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.8) / (15.8 - 14.4));
                            } else {
                                HBbTbm = (float) ((Bb - 15.8) / (17.3 - 15.8));
                            }
                        } else if (Pb == 103.0) {
                            BbTbm = (float) (Bb - 16.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.9) / (15.9 - 14.5));
                            } else {
                                HBbTbm = (float) ((Bb - 15.9) / (17.5 - 15.9));
                            }
                        } else if (Pb == 103.5) {
                            BbTbm = (float) (Bb - 16.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.1) / (16.1 - 14.7));
                            } else {
                                HBbTbm = (float) ((Bb - 16.1) / (17.6 - 16.1));
                            }
                        } else if (Pb == 104.0) {
                            BbTbm = (float) (Bb - 16.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.2) / (16.2 - 14.8));
                            } else {
                                HBbTbm = (float) ((Bb - 16.2) / (17.8 - 16.2));
                            }
                        } else if (Pb == 104.5) {
                            BbTbm = (float) (Bb - 16.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.4) / (16.4 - 15.0));
                            } else {
                                HBbTbm = (float) ((Bb - 16.4) / (18.0 - 16.4));
                            }
                        } else if (Pb == 105.0) {
                            BbTbm = (float) (Bb - 16.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.5) / (16.5 - 15.1));
                            } else {
                                HBbTbm = (float) ((Bb - 16.5) / (18.2 - 16.5));
                            }
                        } else if (Pb == 105.5) {
                            BbTbm = (float) (Bb - 16.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.7) / (16.7 - 15.3));
                            } else {
                                HBbTbm = (float) ((Bb - 16.7) / (18.4 - 16.7));
                            }
                        } else if (Pb == 106.0) {
                            BbTbm = (float) (Bb - 16.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.9) / (16.9 - 15.4));
                            } else {
                                HBbTbm = (float) ((Bb - 16.9) / (18.5 - 16.9));
                            }
                        } else if (Pb == 106.5) {
                            BbTbm = (float) (Bb - 17.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.1) / (17.1 - 15.6));
                            } else {
                                HBbTbm = (float) ((Bb - 17.1) / (18.7 - 17.1));
                            }
                        } else if (Pb == 107.0) {
                            BbTbm = (float) (Bb - 17.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.2) / (17.2 - 15.7));
                            } else {
                                HBbTbm = (float) ((Bb - 17.2) / (18.9 - 17.2));
                            }
                        } else if (Pb == 107.5) {
                            BbTbm = (float) (Bb - 17.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.4) / (17.4 - 15.9));
                            } else {
                                HBbTbm = (float) ((Bb - 17.4) / (19.1 - 17.4));
                            }
                        } else if (Pb == 108.0) {
                            BbTbm = (float) (Bb - 17.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.6) / (17.6 - 16.0));
                            } else {
                                HBbTbm = (float) ((Bb - 17.6) / (19.3 - 17.6));
                            }
                        } else if (Pb == 108.5) {
                            BbTbm = (float) (Bb - 17.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.8) / (17.8 - 16.2));
                            } else {
                                HBbTbm = (float) ((Bb - 17.8) / (19.5 - 17.8));
                            }
                        } else if (Pb == 109.0) {
                            BbTbm = (float) (Bb - 17.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.0) / (18.0 - 16.4));
                            } else {
                                HBbTbm = (float) ((Bb - 18.0) / (19.7 - 18.0));
                            }
                        } else if (Pb == 109.5) {
                            BbTbm = (float) (Bb - 18.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.1) / (18.1 - 16.5));
                            } else {
                                HBbTbm = (float) ((Bb - 18.1) / (20.0 - 18.1));
                            }
                        } else if (Pb == 110.0) {
                            BbTbm = (float) (Bb - 18.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.3) / (18.3 - 16.7));
                            } else {
                                HBbTbm = (float) ((Bb - 18.3) / (20.2 - 18.3));
                            }
                        }
                    }
                } else if (posisiukur.getSelectedItem().toString().equals("Berdiri")) {
                    if (umur >= 24) {
                        if (Pb == 65.0) {
                            BbTbm = (float) (Bb - 7.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.2) / (7.2 - 6.6));
                            } else {
                                HBbTbm = (float) ((Bb - 7.2) / (7.9 - 7.2));
                            }
                        } else if (Pb == 65.5) {
                            BbTbm = (float) (Bb - 7.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.4) / (7.4 - 6.7));
                            } else {
                                HBbTbm = (float) ((Bb - 7.4) / (8.1 - 7.4));
                            }
                        } else if (Pb == 66.0) {
                            BbTbm = (float) (Bb - 7.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.5) / (7.5 - 6.8));
                            } else {
                                HBbTbm = (float) ((Bb - 7.5) / (8.2 - 7.5));
                            }
                        } else if (Pb == 66.5) {
                            BbTbm = (float) (Bb - 7.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.6) / (7.6 - 6.9));
                            } else {
                                HBbTbm = (float) ((Bb - 7.6) / (8.3 - 7.6));
                            }
                        } else if (Pb == 67.0) {
                            BbTbm = (float) (Bb - 7.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.7) / (7.7 - 7.0));
                            } else {
                                HBbTbm = (float) ((Bb - 7.9) / (8.4 - 7.7));
                            }
                        } else if (Pb == 67.5) {
                            BbTbm = (float) (Bb - 7.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.8) / (7.8 - 7.1));
                            } else {
                                HBbTbm = (float) ((Bb - 7.8) / (8.5 - 7.8));
                            }
                        } else if (Pb == 68.0) {
                            BbTbm = (float) (Bb - 7.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 7.9) / (7.9 - 7.2));
                            } else {
                                HBbTbm = (float) ((Bb - 7.9) / (8.7 - 7.9));
                            }
                        } else if (Pb == 68.5) {
                            BbTbm = (float) (Bb - 8.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.0) / (8.0 - 7.3));
                            } else {
                                HBbTbm = (float) ((Bb - 8.0) / (8.8 - 8.0));
                            }
                        } else if (Pb == 69.0) {
                            BbTbm = (float) (Bb - 8.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.1) / (8.1 - 7.4));
                            } else {
                                HBbTbm = (float) ((Bb - 8.1) / (8.9 - 8.1));
                            }
                        } else if (Pb == 69.5) {
                            BbTbm = (float) (Bb - 8.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.2) / (8.2 - 7.5));
                            } else {
                                HBbTbm = (float) ((Bb - 8.2) / (9.0 - 8.2));
                            }
                        } else if (Pb == 70.0) {
                            BbTbm = (float) (Bb - 8.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.3) / (8.3 - 7.6));
                            } else {
                                HBbTbm = (float) ((Bb - 8.3) / (9.1 - 8.3));
                            }
                        } else if (Pb == 70.5) {
                            BbTbm = (float) (Bb - 8.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.4) / (8.4 - 7.7));
                            } else {
                                HBbTbm = (float) ((Bb - 8.4) / (9.2 - 8.4));
                            }
                        } else if (Pb == 71.0) {
                            BbTbm = (float) (Bb - 8.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.5) / (8.5 - 7.8));
                            } else {
                                HBbTbm = (float) ((Bb - 8.5) / (9.3 - 8.5));
                            }
                        } else if (Pb == 71.5) {
                            BbTbm = (float) (Bb - 8.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.6) / (8.6 - 7.9));
                            } else {
                                HBbTbm = (float) ((Bb - 8.6) / (9.4 - 8.6));
                            }
                        } else if (Pb == 72.0) {
                            BbTbm = (float) (Bb - 8.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.7) / (8.7 - 8.0));
                            } else {
                                HBbTbm = (float) ((Bb - 8.7) / (9.5 - 8.7));
                            }
                        } else if (Pb == 72.5) {
                            BbTbm = (float) (Bb - 8.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.8) / (8.8 - 8.1));
                            } else {
                                HBbTbm = (float) ((Bb - 8.8) / (9.7 - 8.8));
                            }
                        } else if (Pb == 73.0) {
                            BbTbm = (float) (Bb - 8.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 8.9) / (8.9 - 8.1));
                            } else {
                                HBbTbm = (float) ((Bb - 8.9) / (9.8 - 8.9));
                            }
                        } else if (Pb == 73.5) {
                            BbTbm = (float) (Bb - 9.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.0) / (9.0 - 8.2));
                            } else {
                                HBbTbm = (float) ((Bb - 9.0) / (9.9 - 9.0));
                            }
                        } else if (Pb == 74.0) {
                            BbTbm = (float) (Bb - 9.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.1) / (9.1 - 8.3));
                            } else {
                                HBbTbm = (float) ((Bb - 9.1) / (10.0 - 9.4));
                            }
                        } else if (Pb == 74.5) {
                            BbTbm = (float) (Bb - 9.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.2) / (9.2 - 8.4));
                            } else {
                                HBbTbm = (float) ((Bb - 9.2) / (10.1 - 9.2));
                            }
                        } else if (Pb == 75.0) {
                            BbTbm = (float) (Bb - 9.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.3) / (9.3 - 8.5));
                            } else {
                                HBbTbm = (float) ((Bb - 9.3) / (10.2 - 9.3));
                            }
                        } else if (Pb == 75.5) {
                            BbTbm = (float) (Bb - 9.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.4) / (9.4 - 8.6));
                            } else {
                                HBbTbm = (float) ((Bb - 9.4) / (10.3 - 9.4));
                            }
                        } else if (Pb == 76.0) {
                            BbTbm = (float) (Bb - 9.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.5) / (9.5 - 8.7));
                            } else {
                                HBbTbm = (float) ((Bb - 9.5) / (10.4 - 9.5));
                            }
                        } else if (Pb == 76.5) {
                            BbTbm = (float) (Bb - 9.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.6) / (9.6 - 8.7));
                            } else {
                                HBbTbm = (float) ((Bb - 9.6) / (10.5 - 9.6));
                            }
                        } else if (Pb == 77.0) {
                            BbTbm = (float) (Bb - 9.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.6) / (9.6 - 8.8));
                            } else {
                                HBbTbm = (float) ((Bb - 9.6) / (10.6 - 9.6));
                            }
                        } else if (Pb == 77.5) {
                            BbTbm = (float) (Bb - 9.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.7) / (9.7 - 8.9));
                            } else {
                                HBbTbm = (float) ((Bb - 9.7) / (10.7 - 9.7));
                            }
                        } else if (Pb == 78.0) {
                            BbTbm = (float) (Bb - 9.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.8) / (9.8 - 9.0));
                            } else {
                                HBbTbm = (float) ((Bb - 9.8) / (10.8 - 9.8));
                            }
                        } else if (Pb == 78.5) {
                            BbTbm = (float) (Bb - 9.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 9.9) / (9.9 - 9.1));
                            } else {
                                HBbTbm = (float) ((Bb - 9.9) / (10.9 - 9.9));
                            }
                        } else if (Pb == 79.0) {
                            BbTbm = (float) (Bb - 10.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.0) / (10.0 - 9.2));
                            } else {
                                HBbTbm = (float) ((Bb - 10.0) / (11.0 - 10.0));
                            }
                        } else if (Pb == 79.5) {
                            BbTbm = (float) (Bb - 10.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.1) / (10.1 - 9.3));
                            } else {
                                HBbTbm = (float) ((Bb - 10.1) / (11.1 - 10.1));
                            }
                        } else if (Pb == 80.0) {
                            BbTbm = (float) (Bb - 10.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.2) / (10.2 - 9.4));
                            } else {
                                HBbTbm = (float) ((Bb - 10.2) / (11.2 - 10.2));
                            }
                        } else if (Pb == 80.5) {
                            BbTbm = (float) (Bb - 10.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.3) / (10.3 - 9.5));
                            } else {
                                HBbTbm = (float) ((Bb - 10.3) / (11.3 - 10.3));
                            }
                        } else if (Pb == 81.0) {
                            BbTbm = (float) (Bb - 10.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.4) / (10.4 - 9.6));
                            } else {
                                HBbTbm = (float) ((Bb - 10.4) / (11.4 - 10.4));
                            }
                        } else if (Pb == 81.5) {
                            BbTbm = (float) (Bb - 10.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.6) / (10.6 - 9.7));
                            } else {
                                HBbTbm = (float) ((Bb - 10.6) / (11.6 - 10.6));
                            }
                        } else if (Pb == 82.0) {
                            BbTbm = (float) (Bb - 10.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.7) / (10.7 - 9.8));
                            } else {
                                HBbTbm = (float) ((Bb - 10.7) / (11.7 - 10.7));
                            }
                        } else if (Pb == 82.5) {
                            BbTbm = (float) (Bb - 10.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.8) / (10.8 - 9.8));
                            } else {
                                HBbTbm = (float) ((Bb - 10.8) / (11.8 - 10.8));
                            }
                        } else if (Pb == 83.0) {
                            BbTbm = (float) (Bb - 10.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 10.9) / (10.9 - 10.0));
                            } else {
                                HBbTbm = (float) ((Bb - 10.9) / (11.9 - 10.9));
                            }
                        } else if (Pb == 83.5) {
                            BbTbm = (float) (Bb - 11.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.0) / (11.0 - 10.1));
                            } else {
                                HBbTbm = (float) ((Bb - 11.0) / (12.1 - 11.0));
                            }
                        } else if (Pb == 84.0) {
                            BbTbm = (float) (Bb - 11.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.1) / (11.1 - 10.2));
                            } else {
                                HBbTbm = (float) ((Bb - 11.1) / (12.2 - 11.1));
                            }
                        } else if (Pb == 84.5) {
                            BbTbm = (float) (Bb - 11.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.3) / (11.3 - 10.3));
                            } else {
                                HBbTbm = (float) ((Bb - 11.3) / (12.3 - 11.3));
                            }
                        } else if (Pb == 85.0) {
                            BbTbm = (float) (Bb - 11.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.4) / (11.4 - 10.4));
                            } else {
                                HBbTbm = (float) ((Bb - 11.4) / (12.5 - 11.4));
                            }
                        } else if (Pb == 85.5) {
                            BbTbm = (float) (Bb - 11.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.5) / (11.5 - 10.6));
                            } else {
                                HBbTbm = (float) ((Bb - 11.5) / (12.6 - 11.5));
                            }
                        } else if (Pb == 86.0) {
                            BbTbm = (float) (Bb - 11.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.6) / (11.6 - 10.7));
                            } else {
                                HBbTbm = (float) ((Bb - 11.6) / (12.7 - 11.6));
                            }
                        } else if (Pb == 86.5) {
                            BbTbm = (float) (Bb - 11.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.8) / (11.8 - 10.8));
                            } else {
                                HBbTbm = (float) ((Bb - 11.8) / (12.9 - 11.8));
                            }
                        } else if (Pb == 87.0) {
                            BbTbm = (float) (Bb - 11.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 11.9) / (11.9 - 10.9));
                            } else {
                                HBbTbm = (float) ((Bb - 11.9) / (13.0 - 11.9));
                            }
                        } else if (Pb == 87.5) {
                            BbTbm = (float) (Bb - 12.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.0) / (12.0 - 11.0));
                            } else {
                                HBbTbm = (float) ((Bb - 12.0) / (13.2 - 12.0));
                            }
                        } else if (Pb == 88.0) {
                            BbTbm = (float) (Bb - 12.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.1) / (12.1 - 11.1));
                            } else {
                                HBbTbm = (float) ((Bb - 12.4) / (13.3 - 12.1));
                            }
                        } else if (Pb == 88.5) {
                            BbTbm = (float) (Bb - 12.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.3) / (12.3 - 11.2));
                            } else {
                                HBbTbm = (float) ((Bb - 12.3) / (13.4 - 12.3));
                            }
                        } else if (Pb == 89.0) {
                            BbTbm = (float) (Bb - 12.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.4) / (12.4 - 11.4));
                            } else {
                                HBbTbm = (float) ((Bb - 12.4) / (13.6 - 12.4));
                            }
                        } else if (Pb == 89.5) {
                            BbTbm = (float) (Bb - 12.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.5) / (12.5 - 11.5));
                            } else {
                                HBbTbm = (float) ((Bb - 12.5) / (13.7 - 12.5));
                            }
                        } else if (Pb == 90.0) {
                            BbTbm = (float) (Bb - 12.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.6) / (12.6 - 11.6));
                            } else {
                                HBbTbm = (float) ((Bb - 12.6) / (13.8 - 12.6));
                            }
                        } else if (Pb == 90.5) {
                            BbTbm = (float) (Bb - 12.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.8) / (12.8 - 11.7));
                            } else {
                                HBbTbm = (float) ((Bb - 12.8) / (14.0 - 12.8));
                            }
                        } else if (Pb == 91.0) {
                            BbTbm = (float) (Bb - 12.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 12.9) / (12.9 - 11.8));
                            } else {
                                HBbTbm = (float) ((Bb - 12.9) / (14.1 - 12.9));
                            }
                        } else if (Pb == 91.5) {
                            BbTbm = (float) (Bb - 13.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.0) / (13.0 - 11.9));
                            } else {
                                HBbTbm = (float) ((Bb - 13.0) / (14.3 - 13.0));
                            }
                        } else if (Pb == 92.0) {
                            BbTbm = (float) (Bb - 13.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.1) / (13.1 - 12.0));
                            } else {
                                HBbTbm = (float) ((Bb - 13.1) / (14.4 - 13.1));
                            }
                        } else if (Pb == 92.5) {
                            BbTbm = (float) (Bb - 13.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.3) / (13.3 - 12.1));
                            } else {
                                HBbTbm = (float) ((Bb - 13.3) / (14.5 - 13.3));
                            }
                        } else if (Pb == 93.0) {
                            BbTbm = (float) (Bb - 13.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.4) / (13.4 - 12.3));
                            } else {
                                HBbTbm = (float) ((Bb - 13.4) / (14.7 - 13.4));
                            }
                        } else if (Pb == 93.5) {
                            BbTbm = (float) (Bb - 13.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.5) / (13.5 - 12.4));
                            } else {
                                HBbTbm = (float) ((Bb - 13.5) / (14.8 - 13.5));
                            }
                        } else if (Pb == 94.0) {
                            BbTbm = (float) (Bb - 13.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.6) / (13.6 - 12.5));
                            } else {
                                HBbTbm = (float) ((Bb - 13.6) / (14.9 - 13.6));
                            }
                        } else if (Pb == 94.5) {
                            BbTbm = (float) (Bb - 13.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.8) / (13.8 - 12.6));
                            } else {
                                HBbTbm = (float) ((Bb - 13.8) / (15.1 - 13.8));
                            }
                        } else if (Pb == 95.0) {
                            BbTbm = (float) (Bb - 13.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 13.9) / (13.9 - 12.7));
                            } else {
                                HBbTbm = (float) ((Bb - 13.9) / (15.2 - 13.9));
                            }
                        } else if (Pb == 95.5) {
                            BbTbm = (float) (Bb - 14.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.0) / (14.0 - 12.8));
                            } else {
                                HBbTbm = (float) ((Bb - 14.0) / (15.4 - 14.0));
                            }
                        } else if (Pb == 96.0) {
                            BbTbm = (float) (Bb - 14.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.1) / (14.1 - 12.9));
                            } else {
                                HBbTbm = (float) ((Bb - 14.1) / (15.5 - 14.1));
                            }
                        } else if (Pb == 96.5) {
                            BbTbm = (float) (Bb - 14.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.3) / (14.3 - 13.1));
                            } else {
                                HBbTbm = (float) ((Bb - 14.3) / (15.6 - 14.3));
                            }
                        } else if (Pb == 97.0) {
                            BbTbm = (float) (Bb - 14.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.4) / (14.4 - 13.2));
                            } else {
                                HBbTbm = (float) ((Bb - 14.4) / (15.8 - 14.4));
                            }
                        } else if (Pb == 97.5) {
                            BbTbm = (float) (Bb - 14.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.5) / (14.5 - 13.3));
                            } else {
                                HBbTbm = (float) ((Bb - 14.5) / (15.9 - 14.5));
                            }
                        } else if (Pb == 98.0) {
                            BbTbm = (float) (Bb - 14.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.7) / (14.7 - 13.4));
                            } else {
                                HBbTbm = (float) ((Bb - 14.7) / (16.1 - 14.7));
                            }
                        } else if (Pb == 98.5) {
                            BbTbm = (float) (Bb - 14.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.8) / (14.8 - 13.5));
                            } else {
                                HBbTbm = (float) ((Bb - 14.8) / (16.2 - 14.8));
                            }
                        } else if (Pb == 99.0) {
                            BbTbm = (float) (Bb - 14.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 14.9) / (14.9 - 13.7));
                            } else {
                                HBbTbm = (float) ((Bb - 14.9) / (16.4 - 14.9));
                            }
                        } else if (Pb == 99.5) {
                            BbTbm = (float) (Bb - 15.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.1) / (15.1 - 13.8));
                            } else {
                                HBbTbm = (float) ((Bb - 15.1) / (16.5 - 15.1));
                            }
                        } else if (Pb == 100.0) {
                            BbTbm = (float) (Bb - 15.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.2) / (15.2 - 13.9));
                            } else {
                                HBbTbm = (float) ((Bb - 15.2) / (16.7 - 15.2));
                            }
                        } else if (Pb == 100.5) {
                            BbTbm = (float) (Bb - 15.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.4) / (15.4 - 14.1));
                            } else {
                                HBbTbm = (float) ((Bb - 15.4) / (16.9 - 15.4));
                            }
                        } else if (Pb == 101.0) {
                            BbTbm = (float) (Bb - 15.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.5) / (15.5 - 14.2));
                            } else {
                                HBbTbm = (float) ((Bb - 15.5) / (17.0 - 15.5));
                            }
                        } else if (Pb == 101.5) {
                            BbTbm = (float) (Bb - 15.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.7) / (15.7 - 14.3));
                            } else {
                                HBbTbm = (float) ((Bb - 15.7) / (17.2 - 15.7));
                            }
                        } else if (Pb == 102.0) {
                            BbTbm = (float) (Bb - 15.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 15.8) / (15.8 - 14.5));
                            } else {
                                HBbTbm = (float) ((Bb - 15.8) / (17.4 - 15.8));
                            }
                        } else if (Pb == 102.5) {
                            BbTbm = (float) (Bb - 16.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.0) / (16.0 - 14.6));
                            } else {
                                HBbTbm = (float) ((Bb - 16.0) / (17.5 - 16.0));
                            }
                        } else if (Pb == 103.0) {
                            BbTbm = (float) (Bb - 16.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.1) / (16.1 - 14.7));
                            } else {
                                HBbTbm = (float) ((Bb - 16.1) / (17.7 - 16.1));
                            }
                        } else if (Pb == 103.5) {
                            BbTbm = (float) (Bb - 16.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.3) / (16.3 - 14.9));
                            } else {
                                HBbTbm = (float) ((Bb - 16.3) / (17.9 - 16.3));
                            }
                        } else if (Pb == 104.0) {
                            BbTbm = (float) (Bb - 16.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.4) / (16.4 - 15.0));
                            } else {
                                HBbTbm = (float) ((Bb - 16.4) / (18.1 - 16.4));
                            }
                        } else if (Pb == 104.5) {
                            BbTbm = (float) (Bb - 16.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.6) / (16.6 - 15.2));
                            } else {
                                HBbTbm = (float) ((Bb - 16.6) / (18.2 - 16.6));
                            }
                        } else if (Pb == 105.0) {
                            BbTbm = (float) (Bb - 16.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.8) / (16.8 - 15.3));
                            } else {
                                HBbTbm = (float) ((Bb - 16.8) / (18.4 - 16.8));
                            }
                        } else if (Pb == 104.5) {
                            BbTbm = (float) (Bb - 16.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 16.9) / (16.9 - 15.5));
                            } else {
                                HBbTbm = (float) ((Bb - 16.9) / (18.6 - 16.9));
                            }
                        } else if (Pb == 106.0) {
                            BbTbm = (float) (Bb - 17.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.1) / (17.1 - 15.6));
                            } else {
                                HBbTbm = (float) ((Bb - 17.1) / (18.8 - 17.1));
                            }
                        } else if (Pb == 106.5) {
                            BbTbm = (float) (Bb - 17.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.3) / (17.3 - 15.8));
                            } else {
                                HBbTbm = (float) ((Bb - 17.3) / (19.0 - 17.3));
                            }
                        } else if (Pb == 107.0) {
                            BbTbm = (float) (Bb - 17.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.5) / (17.5 - 15.9));
                            } else {
                                HBbTbm = (float) ((Bb - 17.5) / (19.2 - 17.5));
                            }
                        } else if (Pb == 107.5) {
                            BbTbm = (float) (Bb - 17.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.7) / (17.7 - 16.1));
                            } else {
                                HBbTbm = (float) ((Bb - 17.7) / (19.4 - 17.7));
                            }
                        } else if (Pb == 108.0) {
                            BbTbm = (float) (Bb - 17.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 17.8) / (17.8 - 16.3));
                            } else {
                                HBbTbm = (float) ((Bb - 17.8) / (19.6 - 17.8));
                            }
                        } else if (Pb == 108.5) {
                            BbTbm = (float) (Bb - 18.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.0) / (18.0 - 16.4));
                            } else {
                                HBbTbm = (float) ((Bb - 18.0) / (19.8 - 18.0));
                            }
                        } else if (Pb == 109.0) {
                            BbTbm = (float) (Bb - 18.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.2) / (18.2 - 16.6));
                            } else {
                                HBbTbm = (float) ((Bb - 18.2) / (20.0 - 18.2));
                            }
                        } else if (Pb == 109.5) {
                            BbTbm = (float) (Bb - 18.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.4) / (18.4 - 16.8));
                            } else {
                                HBbTbm = (float) ((Bb - 18.4) / (20.3 - 18.3));
                            }
                        } else if (Pb == 110.0) {
                            BbTbm = (float) (Bb - 18.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.6) / (18.6 - 17.0));
                            } else {
                                HBbTbm = (float) ((Bb - 18.6) / (20.5 - 18.6));
                            }
                        } else if (Pb == 110.5) {
                            BbTbm = (float) (Bb - 18.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 18.8) / (18.8 - 17.1));
                            } else {
                                HBbTbm = (float) ((Bb - 18.8) / (20.7 - 18.8));
                            }
                        } else if (Pb == 111.0) {
                            BbTbm = (float) (Bb - 19.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 19.0) / (19.0 - 17.3));
                            } else {
                                HBbTbm = (float) ((Bb - 19.0) / (20.9 - 19.0));
                            }
                        } else if (Pb == 111.5) {
                            BbTbm = (float) (Bb - 19.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 19.2) / (19.2 - 17.5));
                            } else {
                                HBbTbm = (float) ((Bb - 19.2) / (21.2 - 19.2));
                            }
                        } else if (Pb == 112.0) {
                            BbTbm = (float) (Bb - 19.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 19.4) / (19.4 - 17.7));
                            } else {
                                HBbTbm = (float) ((Bb - 19.4) / (21.4 - 19.4));
                            }
                        } else if (Pb == 112.5) {
                            BbTbm = (float) (Bb - 19.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 19.6) / (19.6 - 17.9));
                            } else {
                                HBbTbm = (float) ((Bb - 19.6) / (21.6 - 19.6));
                            }
                        } else if (Pb == 113.0) {
                            BbTbm = (float) (Bb - 19.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 19.8) / (19.8 - 18.0));
                            } else {
                                HBbTbm = (float) ((Bb - 19.8) / (21.8 - 19.8));
                            }
                        } else if (Pb == 113.5) {
                            BbTbm = (float) (Bb - 20.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 20.0) / (20.0 - 18.2));
                            } else {
                                HBbTbm = (float) ((Bb - 20.0) / (22.1 - 20.0));
                            }
                        } else if (Pb == 114.0) {
                            BbTbm = (float) (Bb - 20.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 20.2) / (20.2 - 18.4));
                            } else {
                                HBbTbm = (float) ((Bb - 20.2) / (22.3 - 20.2));
                            }
                        } else if (Pb == 114.5) {
                            BbTbm = (float) (Bb - 20.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 20.5) / (20.5 - 18.6));
                            } else {
                                HBbTbm = (float) ((Bb - 20.5) / (22.6 - 20.5));
                            }
                        } else if (Pb == 115.0) {
                            BbTbm = (float) (Bb - 20.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 20.7) / (20.7 - 18.8));
                            } else {
                                HBbTbm = (float) ((Bb - 20.7) / (22.8 - 20.7));
                            }
                        } else if (Pb == 115.5) {
                            BbTbm = (float) (Bb - 20.9);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 20.9) / (20.9 - 19.0));
                            } else {
                                HBbTbm = (float) ((Bb - 20.9) / (23.0 - 20.9));
                            }
                        } else if (Pb == 116.0) {
                            BbTbm = (float) (Bb - 21.1);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 21.1) / (21.1 - 19.2));
                            } else {
                                HBbTbm = (float) ((Bb - 21.1) / (23.3 - 21.1));
                            }
                        } else if (Pb == 116.5) {
                            BbTbm = (float) (Bb - 21.3);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 21.3) / (21.3 - 19.4));
                            } else {
                                HBbTbm = (float) ((Bb - 21.3) / (23.5 - 21.3));
                            }
                        } else if (Pb == 117.0) {
                            BbTbm = (float) (Bb - 21.5);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 21.5) / (21.5 - 19.6));
                            } else {
                                HBbTbm = (float) ((Bb - 21.5) / (23.8 - 21.5));
                            }
                        } else if (Pb == 117.5) {
                            BbTbm = (float) (Bb - 21.7);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 21.7) / (21.7 - 19.8));
                            } else {
                                HBbTbm = (float) ((Bb - 21.7) / (24.0 - 21.47));
                            }
                        } else if (Pb == 118.0) {
                            BbTbm = (float) (Bb - 22.0);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 22.0) / (22.0 - 19.9));
                            } else {
                                HBbTbm = (float) ((Bb - 22.0) / (24.2 - 22.0));
                            }
                        } else if (Pb == 118.5) {
                            BbTbm = (float) (Bb - 22.2);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 22.2) / (22.2 - 20.1));
                            } else {
                                HBbTbm = (float) ((Bb - 22.2) / (24.5 - 22.2));
                            }
                        } else if (Pb == 119.0) {
                            BbTbm = (float) (Bb - 22.4);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 22.4) / (22.4 - 20.3));
                            } else {
                                HBbTbm = (float) ((Bb - 22.4) / (24.7 - 22.4));
                            }
                        } else if (Pb == 119.5) {
                            BbTbm = (float) (Bb - 22.6);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 22.6) / (22.6 - 20.5));
                            } else {
                                HBbTbm = (float) ((Bb - 22.6) / (25.0 - 22.6));
                            }
                        } else if (Pb == 120.0) {
                            BbTbm = (float) (Bb - 22.8);
                            if (BbTbm < 0) {
                                HBbTbm = (float) ((Bb - 22.8) / (22.8 - 20.7));
                            } else {
                                HBbTbm = (float) ((Bb - 22.8) / (25.2 - 22.8));
                            }
                        }
                    }
                }
            }
            if (HBbTbm < -3) {
                vHasilBBTB = "Gizi BURUK";
            } else if (HBbTbm >= -3 && HBbTbm < -2) {
                vHasilBBTB = "GIZI KURANG";
            } else if (HBbTbm >= -2 && HBbTbm <= 1) {
                vHasilBBTB = "Gizi BAIK";
            } else if (HBbTbm > 1 && HBbTbm <= 2) {
                vHasilBBTB = "Beresiko Gizi Lebih";
            } else if (HBbTbm > 2 && HBbTbm <= 3) {
                vHasilBBTB = "Gizi Lebih";
            } else if (HBbTbm > 3) {
                vHasilBBTB = "Obesitas";
            } else {
                vHasilBBTB = "PERHITUNGAN SALAH!";
            }
            statusbbtb.setText("" + vHasilBBTB);

            //Data IMT/U
            imt = (float) (Bb / ((Pb / 100) * (Pb / 100)));

            if (jeniskelamin.getSelectedItem().toString().equals("Laki laki")) {
                if (posisiukur.getSelectedItem().toString().equals("Terlentang")) {
                    switch (umur) {
                        case 0:
                            himt = (float) (imt - 13.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 13.4) / (13.4 - 12.2));
                            } else {
                                imtm = (float) ((imt - 13.4) / (14.8 - 13.4));
                            }
                            break;
                        case 1:
                            himt = (float) (imt - 14.9);
                            if (himt < 0) {
                                imtm = (float) ((imt - 14.9) / (14.9 - 13.6));
                            } else {
                                imtm = (float) ((imt - 14.9) / (16.3 - 13.9));
                            }
                            break;
                        case 2:
                            himt = (float) (imt - 16.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.3) / (16.3 - 15.0));
                            } else {
                                imtm = (float) ((imt - 16.3) / (17.8 - 16.3));
                            }
                            break;
                        case 3:
                            himt = (float) (imt - 16.9);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.9) / (16.9 - 15.5));
                            } else {
                                imtm = (float) ((imt - 16.9) / (18.4 - 16.9));
                            }
                            break;
                        case 4:
                            himt = (float) (imt - 17.2);
                            if (himt < 0) {
                                imtm = (float) ((imt - 17.2) / (17.2 - 15.8));
                            } else {
                                imtm = (float) ((imt - 17.2) / (18.7 - 17.2));
                            }
                            break;
                        case 5:
                            himt = (float) (imt - 17.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 17.3) / (17.3 - 15.9));
                            } else {
                                imtm = (float) ((imt - 17.3) / (18.8 - 17.3));
                            }
                            break;
                        case 6:
                            himt = (float) (imt - 17.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 17.3) / (17.3 - 16.0));
                            } else {
                                imtm = (float) ((imt - 17.3) / (18.8 - 17.3));
                            }
                            break;
                        case 7:
                            himt = (float) (imt - 17.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 17.3) / (17.3 - 16.0));
                            } else {
                                imtm = (float) ((imt - 17.3) / (18.8 - 17.3));
                            }
                            break;
                        case 8:
                            himt = (float) (imt - 17.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 17.3) / (17.3 - 15.9));
                            } else {
                                imtm = (float) ((imt - 17.3) / (18.7 - 17.3));
                            }
                            break;
                        case 9:
                            himt = (float) (imt - 17.2);
                            if (himt < 0) {
                                imtm = (float) ((imt - 17.2) / (17.2 - 15.8));
                            } else {
                                imtm = (float) ((imt - 17.2) / (18.6 - 17.2));
                            }
                            break;
                        case 10:
                            himt = (float) (imt - 17.0);
                            if (himt < 0) {
                                imtm = (float) ((imt - 17.0) / (17.0 - 15.7));
                            } else {
                                imtm = (float) ((imt - 17.0) / (18.5 - 17.0));
                            }
                            break;
                        case 11:
                            himt = (float) (imt - 16.9);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.9) / (16.9 - 15.6));
                            } else {
                                imtm = (float) ((imt - 16.9) / (18.4 - 16.9));
                            }
                            break;
                        case 12:
                            himt = (float) (imt - 16.8);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.8) / (16.8 - 15.5));
                            } else {
                                imtm = (float) ((imt - 16.8) / (18.2 - 16.8));
                            }
                            break;
                        case 13:
                            himt = (float) (imt - 16.7);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.7) / (16.7 - 15.4));
                            } else {
                                imtm = (float) ((imt - 16.7) / (18.1 - 16.7));
                            }
                            break;
                        case 14:
                            himt = (float) (imt - 16.6);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.6) / (16.3 - 15.3));
                            } else {
                                imtm = (float) ((imt - 16.6) / (18.0 - 16.3));
                            }
                            break;
                        case 15:
                            himt = (float) (imt - 16.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.4) / (16.4 - 15.2));
                            } else {
                                imtm = (float) ((imt - 16.4) / (17.8 - 16.4));
                            }
                            break;
                        case 16:
                            himt = (float) (imt - 16.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.3) / (16.3 - 15.1));
                            } else {
                                imtm = (float) ((imt - 16.3) / (17.7 - 16.3));
                            }
                            break;
                        case 17:
                            himt = (float) (imt - 16.2);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.2) / (16.2 - 15.0));
                            } else {
                                imtm = (float) ((imt - 16.2) / (17.6 - 16.2));
                            }
                            break;
                        case 18:
                            himt = (float) (imt - 16.1);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.1) / (16.1 - 14.9));
                            } else {
                                imtm = (float) ((imt - 16.1) / (17.5 - 16.1));
                            }
                            break;
                        case 19:
                            himt = (float) (imt - 16.1);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.1) / (16.1 - 14.9));
                            } else {
                                imtm = (float) ((imt - 16.1) / (17.4 - 16.1));
                            }
                            break;
                        case 20:
                            himt = (float) (imt - 16.0);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.0) / (16.0 - 14.8));
                            } else {
                                imtm = (float) ((imt - 16.0) / (17.3 - 16.0));
                            }
                            break;
                        case 21:
                            himt = (float) (imt - 15.9);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.9) / (15.9 - 14.7));
                            } else {
                                imtm = (float) ((imt - 15.9) / (17.2 - 15.9));
                            }
                            break;
                        case 22:
                            himt = (float) (imt - 15.8);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.8) / (15.8 - 14.7));
                            } else {
                                imtm = (float) ((imt - 15.8) / (17.2 - 15.8));
                            }
                            break;
                        case 23:
                            himt = (float) (imt - 15.8);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.8) / (15.8 - 14.6));
                            } else {
                                imtm = (float) ((imt - 15.8) / (17.1 - 15.8));
                            }
                            break;
                        case 24:
                            himt = (float) (imt - 15.7);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.7) / (15.7 - 14.6));
                            } else {
                                imtm = (float) ((imt - 15.7) / (17.0 - 15.7));
                            }
                            break;
                    }
                } else if (posisiukur.getSelectedItem().equals("Berdiri")) {
                    switch (umur) {
                        case 24:
                            himt = (float) (imt - 16.0);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.0) / (16.0 - 14.8));
                            } else {
                                imtm = (float) ((imt - 16.0) / (17.3 - 16.0));
                            }
                            break;
                        case 25:
                            himt = (float) (imt - 16.0);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.0) / (16.0 - 14.8));
                            } else {
                                imtm = (float) ((imt - 16.0) / (17.3 - 16.0));
                            }
                            break;
                        case 26:
                            himt = (float) (imt - 15.9);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.9) / (15.9 - 14.8));
                            } else {
                                imtm = (float) ((imt - 15.9) / (17.3 - 15.9));
                            }
                            break;
                        case 27:
                            himt = (float) (imt - 15.9);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.9) / (15.9 - 14.7));
                            } else {
                                imtm = (float) ((imt - 15.9) / (17.2 - 15.9));
                            }
                            break;
                        case 28:
                            himt = (float) (imt - 15.9);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.9) / (15.9 - 14.7));
                            } else {
                                imtm = (float) ((imt - 15.9) / (17.2 - 15.9));
                            }
                            break;
                        case 29:
                            himt = (float) (imt - 15.8);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.8) / (15.8 - 14.7));
                            } else {
                                imtm = (float) ((imt - 15.8) / (17.1 - 15.8));
                            }
                            break;
                        case 30:
                            himt = (float) (imt - 15.8);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.8) / (15.8 - 14.6));
                            } else {
                                imtm = (float) ((imt - 15.8) / (17.1 - 15.8));
                            }
                            break;
                        case 31:
                            himt = (float) (imt - 15.8);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.8) / (15.8 - 14.6));
                            } else {
                                imtm = (float) ((imt - 15.8) / (17.1 - 15.8));
                            }
                            break;
                        case 32:
                            himt = (float) (imt - 15.7);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.7) / (15.7 - 14.6));
                            } else {
                                imtm = (float) ((imt - 15.7) / (17.0 - 15.7));
                            }
                            break;
                        case 33:
                            himt = (float) (imt - 15.7);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.7) / (15.7 - 14.5));
                            } else {
                                imtm = (float) ((imt - 15.7) / (17.0 - 15.7));
                            }
                            break;
                        case 34:
                            himt = (float) (imt - 15.6);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.6) / (15.6 - 14.5));
                            } else {
                                imtm = (float) ((imt - 15.6) / (17.0 - 15.6));
                            }
                            break;
                        case 35:
                            himt = (float) (imt - 15.6);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.6) / (15.6 - 14.5));
                            } else {
                                imtm = (float) ((imt - 15.6) / (16.9 - 15.6));
                            }
                            break;
                        case 36:
                            himt = (float) (imt - 15.6);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.6) / (15.6 - 14.4));
                            } else {
                                imtm = (float) ((imt - 15.6) / (16.9 - 15.6));
                            }
                            break;
                        case 37:
                            himt = (float) (imt - 15.6);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.6) / (15.6 - 14.4));
                            } else {
                                imtm = (float) ((imt - 15.6) / (16.9 - 15.6));
                            }
                            break;
                        case 38:
                            himt = (float) (imt - 15.5);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.5) / (15.5 - 14.4));
                            } else {
                                imtm = (float) ((imt - 15.5) / (16.8 - 15.5));
                            }
                            break;
                        case 39:
                            himt = (float) (imt - 15.5);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.5) / (15.5 - 14.3));
                            } else {
                                imtm = (float) ((imt - 15.5) / (16.8 - 15.5));
                            }
                            break;
                        case 40:
                            himt = (float) (imt - 15.5);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.5) / (15.5 - 14.3));
                            } else {
                                imtm = (float) ((imt - 15.5) / (16.8 - 15.5));
                            }
                            break;
                        case 41:
                            himt = (float) (imt - 15.5);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.5) / (15.5 - 14.3));
                            } else {
                                imtm = (float) ((imt - 15.5) / (16.8 - 15.5));
                            }
                            break;
                        case 42:
                            himt = (float) (imt - 15.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.4) / (15.4 - 14.3));
                            } else {
                                imtm = (float) ((imt - 15.4) / (16.8 - 15.4));
                            }
                            break;
                        case 43:
                            himt = (float) (imt - 15.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.4) / (15.4 - 14.2));
                            } else {
                                imtm = (float) ((imt - 15.4) / (16.7 - 15.4));
                            }
                            break;
                        case 44:
                            himt = (float) (imt - 15.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.4) / (15.4 - 14.2));
                            } else {
                                imtm = (float) ((imt - 15.4) / (16.7 - 15.4));
                            }
                            break;
                        case 45:
                            himt = (float) (imt - 15.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.4) / (15.4 - 14.2));
                            } else {
                                imtm = (float) ((imt - 15.4) / (16.7 - 15.4));
                            }
                            break;
                        case 46:
                            himt = (float) (imt - 15.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.4) / (15.4 - 14.2));
                            } else {
                                imtm = (float) ((imt - 15.4) / (16.7 - 15.4));
                            }
                            break;
                        case 47:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.2));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.7 - 15.3));
                            }
                            break;
                        case 48:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.1));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.7 - 15.3));
                            }
                            break;
                        case 49:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.1));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.7 - 15.3));
                            }
                            break;
                        case 50:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.1));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.7 - 15.3));
                            }
                            break;
                        case 51:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.1));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.6 - 15.3));
                            }
                            break;
                        case 52:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.1));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.6 - 15.3));
                            }
                            break;
                        case 53:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.1));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.6 - 15.3));
                            }
                            break;
                        case 54:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.6 - 15.3));
                            }
                            break;
                        case 55:
                            himt = (float) (imt - 15.2);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.2) / (15.2 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.2) / (16.6 - 15.2));
                            }
                            break;
                        case 56:
                            himt = (float) (imt - 15.2);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.2) / (15.2 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.2) / (16.6 - 15.2));
                            }
                            break;
                        case 57:
                            himt = (float) (imt - 15.2);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.2) / (15.2 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.2) / (16.6 - 15.2));
                            }
                            break;
                        case 58:
                            himt = (float) (imt - 15.2);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.2) / (15.2 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.2) / (16.6 - 15.2));
                            }
                            break;
                        case 59:
                            himt = (float) (imt - 15.2);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.2) / (15.2 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.2) / (16.6 - 15.2));
                            }
                            break;
                        case 60:
                            himt = (float) (imt - 15.2);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.2) / (15.2 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.2) / (16.6 - 15.2));
                            }
                            break;
                    }
                }
            } else if (jeniskelamin.getSelectedItem().equals("Perempuan")) {
                if (posisiukur.getSelectedItem().equals("Terlentang")) {
                    switch (umur) {
                        case 0:
                            himt = (float) (imt - 13.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 13.3) / (13.3 - 12.2));
                            } else {
                                imtm = (float) ((imt - 13.3) / (14.6 - 13.3));
                            }
                            break;
                        case 1:
                            himt = (float) (imt - 14.6);
                            if (himt < 0) {
                                imtm = (float) ((imt - 14.6) / (14.6 - 13.2));
                            } else {
                                imtm = (float) ((imt - 14.6) / (16.0 - 13.6));
                            }
                            break;
                        case 2:
                            himt = (float) (imt - 15.8);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.8) / (15.8 - 14.3));
                            } else {
                                imtm = (float) ((imt - 15.8) / (17.3 - 15.8));
                            }
                            break;
                        case 3:
                            himt = (float) (imt - 16.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.4) / (16.4 - 14.9));
                            } else {
                                imtm = (float) ((imt - 16.4) / (17.9 - 16.4));
                            }
                            break;
                        case 4:
                            himt = (float) (imt - 16.7);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.7) / (16.7 - 15.2));
                            } else {
                                imtm = (float) ((imt - 17.2) / (18.3 - 16.7));
                            }
                            break;
                        case 5:
                            himt = (float) (imt - 16.8);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.8) / (16.8 - 15.4));
                            } else {
                                imtm = (float) ((imt - 16.8) / (18.4 - 16.8));
                            }
                            break;
                        case 6:
                            himt = (float) (imt - 16.9);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.9) / (16.9 - 15.5));
                            } else {
                                imtm = (float) ((imt - 16.9) / (18.5 - 16.9));
                            }
                            break;
                        case 7:
                            himt = (float) (imt - 16.9);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.9) / (16.9 - 15.5));
                            } else {
                                imtm = (float) ((imt - 16.9) / (18.5 - 16.9));
                            }
                            break;
                        case 8:
                            himt = (float) (imt - 16.8);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.8) / (16.8 - 15.4));
                            } else {
                                imtm = (float) ((imt - 16.8) / (18.4 - 16.8));
                            }
                            break;
                        case 9:
                            himt = (float) (imt - 16.7);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.7) / (16.7 - 15.3));
                            } else {
                                imtm = (float) ((imt - 16.7) / (18.3 - 16.7));
                            }
                            break;
                        case 10:
                            himt = (float) (imt - 16.6);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.6) / (16.6 - 15.2));
                            } else {
                                imtm = (float) ((imt - 16.6) / (18.2 - 16.6));
                            }
                            break;
                        case 11:
                            himt = (float) (imt - 16.5);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.5) / (16.5 - 15.1));
                            } else {
                                imtm = (float) ((imt - 16.5) / (18.0 - 16.5));
                            }
                            break;
                        case 12:
                            himt = (float) (imt - 16.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.4) / (16.4 - 15.0));
                            } else {
                                imtm = (float) ((imt - 16.4) / (17.9 - 16.4));
                            }
                            break;
                        case 13:
                            himt = (float) (imt - 16.2);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.2) / (16.2 - 14.9));
                            } else {
                                imtm = (float) ((imt - 16.2) / (17.7 - 16.2));
                            }
                            break;
                        case 14:
                            himt = (float) (imt - 16.1);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.1) / (16.1 - 14.8));
                            } else {
                                imtm = (float) ((imt - 16.1) / (17.6 - 16.1));
                            }
                            break;
                        case 15:
                            himt = (float) (imt - 16.0);
                            if (himt < 0) {
                                imtm = (float) ((imt - 16.0) / (16.0 - 14.7));
                            } else {
                                imtm = (float) ((imt - 16.0) / (17.5 - 16.0));
                            }
                            break;
                        case 16:
                            himt = (float) (imt - 15.9);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.9) / (15.9 - 14.6));
                            } else {
                                imtm = (float) ((imt - 15.9) / (17.4 - 15.9));
                            }
                            break;
                        case 17:
                            himt = (float) (imt - 15.8);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.8) / (15.8 - 14.5));
                            } else {
                                imtm = (float) ((imt - 15.8) / (17.3 - 15.8));
                            }
                            break;
                        case 18:
                            himt = (float) (imt - 15.7);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.7) / (15.7 - 14.4));
                            } else {
                                imtm = (float) ((imt - 15.7) / (17.2 - 15.7));
                            }
                            break;
                        case 19:
                            himt = (float) (imt - 15.7);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.7) / (15.7 - 14.4));
                            } else {
                                imtm = (float) ((imt - 15.7) / (17.1 - 15.7));
                            }
                            break;
                        case 20:
                            himt = (float) (imt - 15.6);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.6) / (15.6 - 14.4));
                            } else {
                                imtm = (float) ((imt - 15.6) / (17.0 - 15.7));
                            }
                            break;
                        case 21:
                            himt = (float) (imt - 15.5);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.5) / (15.5 - 14.3));
                            } else {
                                imtm = (float) ((imt - 15.5) / (17.0 - 15.5));
                            }
                            break;
                        case 22:
                            himt = (float) (imt - 15.5);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.5) / (15.5 - 14.2));
                            } else {
                                imtm = (float) ((imt - 15.5) / (17.0 - 15.5));
                            }
                            break;
                        case 23:
                            himt = (float) (imt - 15.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.4) / (15.4 - 14.2));
                            } else {
                                imtm = (float) ((imt - 15.4) / (16.9 - 15.4));
                            }
                            break;
                        case 24:
                            himt = (float) (imt - 15.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.4) / (15.4 - 14.2));
                            } else {
                                imtm = (float) ((imt - 15.4) / (16.8 - 15.4));
                            }
                            break;
                    }
                } else if (posisiukur.getSelectedItem().equals("Berdiri")) {
                    switch (umur) {
                        case 24:
                            himt = (float) (imt - 15.7);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.7) / (15.7 - 14.4));
                            } else {
                                imtm = (float) ((imt - 15.7) / (17.1 - 15.7));
                            }
                            break;
                        case 25:
                            himt = (float) (imt - 15.7);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.7) / (15.7 - 14.4));
                            } else {
                                imtm = (float) ((imt - 15.7) / (17.1 - 15.7));
                            }
                            break;
                        case 26:
                            himt = (float) (imt - 15.6);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.6) / (15.6 - 14.4));
                            } else {
                                imtm = (float) ((imt - 15.6) / (17.0 - 15.6));
                            }
                            break;
                        case 27:
                            himt = (float) (imt - 15.6);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.6) / (15.6 - 14.4));
                            } else {
                                imtm = (float) ((imt - 15.6) / (17.0 - 15.6));
                            }
                            break;
                        case 28:
                            himt = (float) (imt - 15.6);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.6) / (15.6 - 14.3));
                            } else {
                                imtm = (float) ((imt - 15.6) / (17.0 - 15.6));
                            }
                            break;
                        case 29:
                            himt = (float) (imt - 15.6);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.6) / (15.6 - 14.3));
                            } else {
                                imtm = (float) ((imt - 15.6) / (17.0 - 15.6));
                            }
                            break;
                        case 30:
                            himt = (float) (imt - 15.5);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.5) / (15.5 - 14.3));
                            } else {
                                imtm = (float) ((imt - 15.5) / (16.9 - 15.5));
                            }
                            break;
                        case 31:
                            himt = (float) (imt - 15.5);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.5) / (15.5 - 14.3));
                            } else {
                                imtm = (float) ((imt - 15.5) / (16.9 - 15.5));
                            }
                            break;
                        case 32:
                            himt = (float) (imt - 15.5);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.5) / (15.5 - 14.3));
                            } else {
                                imtm = (float) ((imt - 15.5) / (16.9 - 15.5));
                            }
                            break;
                        case 33:
                            himt = (float) (imt - 15.5);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.5) / (15.5 - 14.2));
                            } else {
                                imtm = (float) ((imt - 15.5) / (16.9 - 15.5));
                            }
                            break;
                        case 34:
                            himt = (float) (imt - 15.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.4) / (15.4 - 14.2));
                            } else {
                                imtm = (float) ((imt - 15.4) / (16.8 - 15.4));
                            }
                            break;
                        case 35:
                            himt = (float) (imt - 15.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.4) / (15.4 - 14.2));
                            } else {
                                imtm = (float) ((imt - 15.4) / (16.8 - 15.4));
                            }
                            break;
                        case 36:
                            himt = (float) (imt - 15.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.4) / (15.4 - 14.2));
                            } else {
                                imtm = (float) ((imt - 15.4) / (16.8 - 15.4));
                            }
                            break;
                        case 37:
                            himt = (float) (imt - 15.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.4) / (15.4 - 14.1));
                            } else {
                                imtm = (float) ((imt - 15.4) / (16.8 - 15.4));
                            }
                            break;
                        case 38:
                            himt = (float) (imt - 15.4);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.4) / (15.4 - 14.1));
                            } else {
                                imtm = (float) ((imt - 15.4) / (16.8 - 15.4));
                            }
                            break;
                        case 39:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.1));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 40:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.1));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 41:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.1));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 42:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 43:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 44:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 45:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 46:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 47:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 48:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 14.0));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 49:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 13.9));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 50:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 13.9));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 51:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 13.9));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 52:
                            himt = (float) (imt - 15.2);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.2) / (15.2 - 13.9));
                            } else {
                                imtm = (float) ((imt - 15.2) / (16.8 - 15.2));
                            }
                            break;
                        case 53:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 13.9));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 54:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 13.9));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 55:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 13.9));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 56:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 13.9));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 57:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 13.9));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.9 - 15.3));
                            }
                            break;
                        case 58:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 13.9));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                        case 59:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 13.9));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.6 - 15.3));
                            }
                            break;
                        case 60:
                            himt = (float) (imt - 15.3);
                            if (himt < 0) {
                                imtm = (float) ((imt - 15.3) / (15.3 - 13.9));
                            } else {
                                imtm = (float) ((imt - 15.3) / (16.8 - 15.3));
                            }
                            break;
                    }
                }
            }
            if (imtm < -3) {
                vHasilIMT = "Gizi BURUK";
            } else if (imtm >= -3 && imtm < -2) {
                vHasilIMT = "Gizi KURANG";
            } else if (imtm >= -2 && imtm <= 1) {
                vHasilIMT = "Gizi BAIK";
            } else if (imtm > 1 && imtm <= 2) {
                vHasilIMT = "Beresiko Gizi LEBIH";
            } else if (imtm > 2 && imtm <= 3) {
                vHasilIMT = "Gizi LEBIH";
            } else if (imtm > 3) {
                vHasilIMT = "OBESITAS";
            }
            statusimt.setText("" + vHasilIMT);

        });
        ArrayAdapter<CharSequence> adapterjk = ArrayAdapter.createFromResource(MainActivity.this, R.array.jeniskelamin, android.R.layout.simple_spinner_item);
        adapterjk.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jeniskelamin.setAdapter(adapterjk);

        ArrayAdapter<CharSequence> adapterpu = ArrayAdapter.createFromResource(MainActivity.this, R.array.posisiukur, android.R.layout.simple_spinner_item);
        adapterpu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        posisiukur.setAdapter(adapterpu);

    }

    private void Database() {
        String Nama = editText_Nama.getText().toString().trim();
        String Umur = editText_Umur.getText().toString().trim();
        String BB = editText_BeratBadan.getText().toString().trim();
        String PB = editText_PanjangBadan.getText().toString().trim();
        String JK = jeniskelamin.getSelectedItem().toString().trim();
        String PU = posisiukur.getSelectedItem().toString().trim();
        String statusBb = statusbb.getText().toString().trim();
        String statusPb = statuspb.getText().toString().trim();
        String statusBbTb = statusbbtb.getText().toString().trim();
        String statusImt = statusimt.getText().toString().trim();
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.clm_nama, Nama);
        values.put(DataBaseHelper.clm_umur, Umur);
        values.put(DataBaseHelper.clm_bb, BB);
        values.put(DataBaseHelper.clm_pb, PB);
        values.put(DataBaseHelper.clm_JenisKelamin, JK);
        values.put(DataBaseHelper.clm_PosisiUkur, PU);
        values.put(DataBaseHelper.clm_statusbb, statusBb);
        values.put(DataBaseHelper.clm_statuspb, statusPb);
        values.put(DataBaseHelper.clm_statusbbtb, statusBbTb);
        values.put(DataBaseHelper.clm_statusimt, statusImt);


        if (Nama.equals("") || Umur.equals("") || BB.equals("") || PB.equals("") || JK.equals("") || PU.equals("")) {
            Toast.makeText(MainActivity.this, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT).show();
        } else {
            dbhelper.insertData(values);
            Toast.makeText(MainActivity.this, "Data Berhasil Tersimpan", Toast.LENGTH_SHORT).show();

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
    protected void onDestroy() {
        super.onDestroy();

        if (mHandler != null) {
            mHandler.removeCallbacks(mRunnable);
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan Kembali untuk keluar aplikasi", Toast.LENGTH_SHORT).show();

        mHandler.postDelayed(mRunnable, 2000);

    }

    private void CLEAR() {
        editText_Nama.setText("");
        editText_Umur.setText("");
        editText_BeratBadan.setText("");
        editText_PanjangBadan.setText("");
    }
}