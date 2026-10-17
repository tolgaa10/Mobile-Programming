package com.example.week2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CheckBox cbkitap ,cbFilm, cbSpor, cbMuzik, cbSeyahat, cbYemek, cbBilgisayar;
    Button btnOnayla;
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

        cbkitap = findViewById(R.id.cbKitap);
        cbFilm  = findViewById(R.id.cbFilm);
        cbSpor = findViewById(R.id.cbSpor);
        cbMuzik = findViewById(R.id.cbMuzik);
        cbSeyahat = findViewById(R.id.cbSeyahat);
        cbYemek = findViewById(R.id.cbYemek);
        cbBilgisayar = findViewById(R.id.cbBilgisayar);
        btnOnayla = findViewById(R.id.btnOnayla);

        btnOnayla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder secilenHobiler = new StringBuilder("Hobiler :" );

                if(cbkitap.isChecked()){
                    secilenHobiler.append("-Kitap okumak");
                }
                if(cbFilm.isChecked()){
                    secilenHobiler.append("-Film izlemek");
                }
                if(cbSpor.isChecked()){
                    secilenHobiler.append("-Spor yapmak");
                }
                if(cbMuzik.isChecked()){
                    secilenHobiler.append("-Müzik dinlemek");
                }
                if(cbSeyahat.isChecked()){
                    secilenHobiler.append("-Seyehat etmek");
                }
                if(cbYemek.isChecked()){
                    secilenHobiler.append("-Yemek yapmak");
                }
                if(cbBilgisayar.isChecked()){
                    secilenHobiler.append("-Bilgisayar oynamak");
                }
                Toast.makeText(MainActivity.this, secilenHobiler.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }
}

