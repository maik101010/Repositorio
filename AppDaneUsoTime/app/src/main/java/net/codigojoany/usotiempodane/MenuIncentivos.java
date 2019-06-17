package net.codigojoany.usotiempodane;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Joany on 21/09/2017.
 */

public class MenuIncentivos extends AppCompatActivity {

    private Button btnDescuento,btnReportes,btnVolver;
    private TextView titulo,txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incentivos);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");

        titulo = (TextView)findViewById(R.id.textView);
        titulo.setTypeface(typeface);
        txtInfo = (TextView)findViewById(R.id.txtInfo);
        txtInfo.setTypeface(typeface);
        btnReportes = (Button) findViewById(R.id.btnReportes);
        btnReportes.setTypeface(typeface);
        btnDescuento = (Button) findViewById(R.id.btnDescuento);
        btnDescuento.setTypeface(typeface);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setTypeface(typeface);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(MenuIncentivos.this, Menu.class);
                startActivity(pantalla);
            }
        });

        btnDescuento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(MenuIncentivos.this, MenuIncentivosDescuento.class);
                startActivity(pantalla);
            }
        });
        btnReportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(MenuIncentivos.this, MenuIncentivosReportes.class);
                startActivity(pantalla);
            }
        });

    }


}
