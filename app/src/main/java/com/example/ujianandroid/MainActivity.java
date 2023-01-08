package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText edNamaDepan;
    private EditText edNamaBelakang;
    private Button btnSimpan;
    private ListView lvNama;
    private ArrayList<String> daftar_nama = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNamaDepan = findViewById(R.id.edNamaDepan);
        edNamaBelakang = findViewById(R.id.edNamaBelakang);
        btnSimpan = findViewById(R.id.btnSimpan);

        lvNama = findViewById(R.id.lvNama);

        Intent intent_list = new Intent(MainActivity.this, ListActivity.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isian_nama_depan = edNamaDepan.getText().toString().trim();
                String isian_nama_belakang = edNamaBelakang.getText().toString().trim();

                if (isian_nama_depan.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Isian masih kosong", Toast.LENGTH_SHORT).show();
                } else {
                    String nama_lengkap = isian_nama_depan + " " + isian_nama_belakang;
                    daftar_nama.clear();
                    for (int i = 1; i <= 20; i++) {
                        if (i % 2 != 0) { // Memeriksa bilangan ganjil
                            daftar_nama.add(i + ". " + nama_lengkap);
                        }
                    }
                    intent_list.putStringArrayListExtra("daftar_nama", daftar_nama);
                    startActivity(intent_list);
                }
            }
        });
    }
}