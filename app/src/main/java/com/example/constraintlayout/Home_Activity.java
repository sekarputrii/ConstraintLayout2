package com.example.constraintlayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //Deklarasi variabel dengan jenis data listView
    private ListView list;
    //Memanggil class ListViewAdapter dan diinisiasi menjadi variabel adapter
    private ListViewAdapter adapter;
    //Deklarasi array untuk menyimpan nama
    String[] listNama;
    //Memanggil class ClassNama
    public static ArrayList<ClassNama> classNamaArrayList = new ArrayList<ClassNama>();
    //Membuat objek Bundle
    Bundle bundle = new Bundle();
    //Membuat objek intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        //Menyimpan nama didalam array listNama
        listNama = new String[]{"Sekar", "Yasmina", "Rio", "Fadhillah","Arip", "Anisa", "Denise", "Adellia", "Bima", "Sisilia"};
        list = findViewById(R.id.listKontak);
        //Membuat objek dari class ClassNama menjadi arrayList
        classNamaArrayList = new ArrayList<>();
        //Membaca seluruh data pada array listNama
        for (int i = 0; i < listNama.length; i++) {
            //Membuat objek class nama
            ClassNama classNama = new ClassNama(listNama[i]);
            //Binds string ke array
            classNamaArrayList.add(classNama);
        }
        //Membuat objek dari ListViewAdapter
        adapter = new ListViewAdapter(this);
        //Binds adapter ke listView
        list.setAdapter(adapter);
        //Membuat event dari list onClick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Deklarasi variabel nama yang berisi item yang diklik
                String nama = classNamaArrayList.get(position).getNama();
                //Memasukkan value dari variabel nama dengan kunci "a" dan dimasukkan kedalam bundle
                bundle.putString("a", nama.trim());
                //Membuat objek popup menu
                PopupMenu pm = new PopupMenu(getApplicationContext(), view);
                //Membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(Home_Activity.this);
                //Menampilkan popup menu dari layout menu
                pm.inflate(R.menu.popup_menu);
                //Menampilkan popup menu
                pm.show();
            }
        });
    }
    //event yang terjadi ketika mau dipilih
    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(),ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(),"Edit Kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return false;
    }
}