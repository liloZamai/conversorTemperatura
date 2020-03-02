package com.example.conversortemperatura.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.conversortemperatura.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_valor;
    private Button btn_conv_faren_cels;
    private Button btn_conv_cels_faren;
    private TextView tv_convertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_valor = findViewById(R.id.et_valor);
        btn_conv_faren_cels = findViewById(R.id.btn_farenheit_para_celsius);
        btn_conv_cels_faren = findViewById(R.id.btn_celsius_para_farenheit);
        tv_convertido = findViewById(R.id.tv_convertido);

        btn_conv_faren_cels.setOnClickListener(this);
        btn_conv_cels_faren.setOnClickListener(this);
    }

    private void convFarenToCels(Double temp) {
        try {
            Double convertido = (temp-32)/1.8;
            tv_convertido.setText(String.format("%.2f ºC", convertido));
        }catch (NumberFormatException e) {
            Toast.makeText(this, "Não foi possível converter", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Aconteceu algo inesperado", Toast.LENGTH_SHORT).show();
        }
    }

    private void convCelsToFaren(Double temp) {
        try {
            Double convertido = 1.8 * temp + 32;
            tv_convertido.setText(String.format("%.2f ºC", convertido));
        }catch (NumberFormatException e) {
            Toast.makeText(this, "Não foi possível converter", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Aconteceu algo inesperado", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btn_conv_faren_cels) {
            convFarenToCels(Double.valueOf(et_valor.getText().toString()));
        } else if (v == btn_conv_cels_faren) {
            convCelsToFaren(Double.valueOf(et_valor.getText().toString()));
        }
    }
}
