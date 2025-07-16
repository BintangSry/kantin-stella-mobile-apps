package com.str.kantinstella;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cart extends AppCompatActivity {

    TextView checkoutBtn;
    ImageView tambah_cola, kurang_cola, tambah_nasgor, kurang_nasgor, tambah_burger, kurang_burger;
    TextView jumlah_cola, jumlah_nasgor, jumlah_burger;

    int cola = 1;
    int nasgor = 1;
    int burger = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.cart);

        checkoutBtn = findViewById(R.id.checkout);

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Pindah ke halaman StructActivity
                Intent intent = new Intent(cart.this, struct.class);
                startActivity(intent);
            }
        });

        // Tambahkan event listener untuk tombol tambah dan kurang
        tambah_cola = findViewById(R.id.tambah_cola);
        kurang_cola = findViewById(R.id.kurang_cola);
        jumlah_cola = findViewById(R.id.jumlah_cola);

        tambah_burger = findViewById(R.id.tambah_burger);
        kurang_burger = findViewById(R.id.kurang_burger);
        jumlah_burger = findViewById(R.id.jumlah_burger);

        tambah_nasgor = findViewById(R.id.tambah_nasgor);
        kurang_nasgor = findViewById(R.id.kurang_nasgor);
        jumlah_nasgor = findViewById(R.id.jumlah_nasgor);

        jumlah_cola.setText(String.valueOf(cola));
        jumlah_burger.setText(String.valueOf(burger));
        jumlah_nasgor.setText(String.valueOf(nasgor));

        tambah_cola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cola++;
                jumlah_cola.setText(String.valueOf(cola));
            }
        });
        kurang_cola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cola > 1) {
                    cola--;
                    jumlah_cola.setText(String.valueOf(cola));
                }
            }
        });
        tambah_burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                burger++;
                jumlah_burger.setText(String.valueOf(burger));
                }
        });
        kurang_burger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (burger > 1) {
                    burger--;
                    jumlah_burger.setText(String.valueOf(burger));
                }
            }
        });
        tambah_nasgor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nasgor++;
                jumlah_nasgor.setText(String.valueOf(nasgor));
            }
        });
        kurang_nasgor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nasgor > 1) {
                    nasgor--;
                    jumlah_nasgor.setText(String.valueOf(nasgor));
                }
            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}