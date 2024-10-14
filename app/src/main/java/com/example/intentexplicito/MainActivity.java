package com.example.intentexplicito;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResultado;
    private Button buttonSeleccionar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResultado = findViewById(R.id.textViewResultado);
        buttonSeleccionar = findViewById(R.id.buttonSeleccionar);

        buttonSeleccionar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProvinciaActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            String provincia = data.getStringExtra("provincia_seleccionada");
            textViewResultado.setText(getString(R.string.provincia_seleccionada, provincia));
        }
    }
}
