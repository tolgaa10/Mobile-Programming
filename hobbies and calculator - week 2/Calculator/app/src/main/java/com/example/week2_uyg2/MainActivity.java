package com.example.week2_uyg2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CheckBox cbSut, cbSeker, cbKrema, cbTarcin, cbBahsis;
    EditText etSutFiyat, etSekerFiyat, etKremaFiyat, etTarcinFiyat;
    TextView tvToplamFiyat;
    Button btnHesapla;
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

    cbSut = findViewById(R.id.cbSut);
    cbSeker = findViewById(R.id.cbSeker);
    cbKrema = findViewById(R.id.cbKrema);
    cbTarcin = findViewById(R.id.cbTarcin);
    cbBahsis = findViewById(R.id.cbBahsis);

    etSutFiyat = findViewById(R.id.etSutFiyat);
    etSekerFiyat = findViewById(R.id.etSekerFiyat);
    etKremaFiyat = findViewById(R.id.etKremaFiyat);
    etTarcinFiyat = findViewById(R.id.etTarcinFiyat);

    btnHesapla = findViewById(R.id.btnHesapla);

    tvToplamFiyat = findViewById(R.id.tvToplamFiyat);


    btnHesapla.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int toplamtutar = 0;

            if(cbSut.isChecked()){
                String sutfiyat = etSutFiyat.getText().toString();
                toplamtutar += Integer.parseInt(sutfiyat);
            }
            if(cbSeker.isChecked()){
                String sekerfiyat = etSekerFiyat.getText().toString();
                toplamtutar += Integer.parseInt(sekerfiyat);
            }
            if(cbKrema.isChecked()){
                String kremafiyat = etKremaFiyat.getText().toString();
                toplamtutar += Integer.parseInt(kremafiyat);
            }
            if(cbTarcin.isChecked()){
                String tarcınfiyat = etTarcinFiyat.getText().toString();
                toplamtutar += Integer.parseInt(tarcınfiyat);
            }
            if(cbBahsis.isChecked()){
                int bahsis = (int) (toplamtutar * 0.10);
                toplamtutar += bahsis;
            }
            tvToplamFiyat.setText("toplam tutar : "+toplamtutar);
        }
    });
    }
}