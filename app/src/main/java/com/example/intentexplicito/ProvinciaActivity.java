package com.example.intentexplicito;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProvinciaActivity extends AppCompatActivity {

    private RadioGroup radioGroupProvincias;
    private Button buttonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provincia);

        radioGroupProvincias = findViewById(R.id.radioGroupProvincias);
        buttonEnviar = findViewById(R.id.buttonEnviar);

        buttonEnviar.setOnClickListener(v -> {
            int selectedId = radioGroupProvincias.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton radioButtonSeleccionado = findViewById(selectedId);
                String provincia = radioButtonSeleccionado.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("provincia_seleccionada", provincia);
                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                Toast.makeText(this, R.string.error_seleccion, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
