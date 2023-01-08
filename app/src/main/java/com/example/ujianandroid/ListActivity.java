package com.example.ujianandroid;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView lvNama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lvNama = findViewById(R.id.lvNama);

        ArrayList<String> daftar_nama = getIntent().getStringArrayListExtra("daftar_nama");

        ArrayList<String> filteredList = new ArrayList<>();

        if (daftar_nama != null && !daftar_nama.isEmpty()) {
            for (String nama : daftar_nama) {
                // Mengekstrak angka index dan nama
                String[] parts = nama.split("\\. ");
                int index = Integer.parseInt(parts[0]);
                String name = parts[1];

                // Memeriksa apakah nama memiliki nama depan dan belakang
                String[] nameParts = name.split(" ");
                if (nameParts.length >= 2) {
                    String namaLengkap = nameParts[0] + " " + nameParts[1];
                    filteredList.add(index + ". " + namaLengkap);
                }
            }
        }

        ArrayAdapter<String> ad_nama;
        if (!filteredList.isEmpty()) {
            ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filteredList);
        } else {
            filteredList.add("Data masih kosong");
            ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, filteredList);
        }

        lvNama.setAdapter(ad_nama);
    }
}