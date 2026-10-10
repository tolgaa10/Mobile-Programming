package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView toplamCorba = findViewById(R.id.txttoplamcorba);
        TextView toplamyemek = findViewById(R.id.txttoplamyemek);
        TextView toplamtatli = findViewById(R.id.txttoplamtatli);

        EditText corbaAdet = findViewById(R.id.etCorbaAdet);
        EditText yemekAdet = findViewById(R.id.etYemekAdet);
        EditText tatliAdet = findViewById(R.id.etTatliAdet);

        TextView tvToplamYemek = findViewById(R.id.tvToplamYemekSonuc);
        TextView tvToplamBahsis = findViewById(R.id.tvToplamBahsisSonuc);
        TextView tvToplamHesap = findViewById(R.id.tvToplamHesapSonuc);

        Button BtnHesapla = findViewById(R.id.btnHesapla);

        BtnHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int corbasayısı = 0;
                int yemeksayısı = 0;
                int tatlisayısı = 0;

                String sCorba = corbaAdet.getText().toString();
                if (!sCorba.isEmpty()) {
                    corbasayısı = Integer.parseInt(sCorba);
                }
                String syemek = yemekAdet.getText().toString();
                if (!sCorba.isEmpty()) {
                    yemeksayısı= Integer.parseInt(sCorba);
                }
                String statlı = tatliAdet.getText().toString();
                if (!sCorba.isEmpty()) {
                    tatlisayısı= Integer.parseInt(sCorba);
                }

                double corbatutar = corbasayısı * 100;
                double yemektutar = yemeksayısı * 200;
                double tatlitutar = tatlisayısı * 150;

                toplamCorba.setText("Toplam Fiyat: "+corbatutar+" TL");
                toplamyemek.setText("Toplam Fiyat: "+yemektutar+" TL");
                toplamtatli.setText("Toplam Fiyat: "+tatlitutar+" TL");

                double genelToplamYemek = corbatutar + yemektutar + tatlitutar;
                double bahsisMiktari = genelToplamYemek * 0.05;
                double odenecekHesap = genelToplamYemek + bahsisMiktari;

                tvToplamYemek.setText(genelToplamYemek + "TL");
                tvToplamHesap.setText(odenecekHesap + " TL");
                tvToplamBahsis.setText(bahsisMiktari+ " TL");

            }
        });
    }
}