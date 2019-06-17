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

public class Menu extends AppCompatActivity {

    private Button botonPerfil,botonActividades,botonReportes,botonIncentivos,botonSalir;
    private TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");
        titulo = (TextView) findViewById(R.id.textView);
        titulo.setTypeface(typeface);
        botonPerfil = (Button) findViewById(R.id.btnPerfil);
        botonPerfil.setTypeface(typeface);

        botonActividades = (Button) findViewById(R.id.btnActividades);
        botonActividades.setTypeface(typeface);

        botonReportes = (Button) findViewById(R.id.btnReportes);
        botonReportes.setTypeface(typeface);
        botonIncentivos = (Button) findViewById(R.id.btnIncentivos);
        botonIncentivos.setTypeface(typeface);
        botonSalir = (Button) findViewById(R.id.btnSalir);
        botonSalir.setTypeface(typeface);


        botonPerfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(Menu.this, PerfilUsuario.class);
                startActivity(pantalla);
            }
        });

        botonActividades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(Menu.this, MenuActividades.class);
                startActivity(pantalla);
            }
        });
        botonReportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(Menu.this, MenuReportes.class);
                startActivity(pantalla);
                finish();
            }
        });
        botonIncentivos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(Menu.this, MenuIncentivos.class);
                startActivity(pantalla);
                finish();
            }
        });
        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Login.class);
                startActivity(intent);
            }
        });


    }

}
