package com.example.constraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityLihatData extends AppCompatActivity {
    //Deklarasi variabel dengan jenis data TextView
    TextView tvnama, tvnomor;
    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);

        //Membuat variabel dengan jenis data bundle dan assign value dari variabel tersebut
        //dengan getIntent().getExtras()
        Bundle bundle = getIntent().getExtras();
        //Membuat variabel nama dan assign value dari pesan yang dikirimkan dari activity sebelumnya
        nama = bundle.getString("a");

        tvnama = (TextView) findViewById(R.id.tvNamaKontak);
        tvnomor = (TextView) findViewById(R.id.tvNomorTelepon);

        //Membuatfungsi untuk mengatur textview nama dan nomor telepon berdasarkan pesan yang dikirimkan dari activity sebelumnya
        switch (nama)
        {
            case "Sekar":
                tvnama.setText("Sekar Putri Retno");
                tvnomor.setText("0822xxxxxxxx");
                break;
            case "Yasmina":
                tvnama.setText("Yasmina A.A");
                tvnomor.setText("0853xxxxxxxx");
                break;
            case "Rio" :
                tvnama.setText("Rio A. A");
                tvnomor.setText("0812xxxxxxxx");
                break;
            case "Fadhillah" :
                tvnama.setText("Fadhillah R. S");
                tvnomor.setText("0896xxxxxxxx");
                break;
            case"Arip":
                tvnama.setText("M. Arip");
                tvnomor.setText("0812xxxxxxxx");
                break;
            case "Anisa":
                tvnama.setText("Anisa .N .A");
                tvnomor.setText("0852xxxxxxxx");
                break;
            case "Denise":
                tvnama.setText("Denise N. N");
                tvnomor.setText("0853xxxxxxxx");
                break;
            case "Adellia":
                tvnama.setText("Adelia P. A");
                tvnomor.setText("0812xxxxxxxx");
                break;
            case "Bima":
                tvnama.setText("Bima B. S");
                tvnomor.setText("0896xxxxxxxx");
                break;
            case "Sisilia":
                tvnama.setText("Sisilia I. L");
                tvnomor.setText("0823xxxxxxxx");
                break;
        }
    }
}