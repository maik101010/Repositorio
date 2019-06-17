package net.codigojoany.usotiempodane;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static net.codigojoany.usotiempodane.R.id.btnVolver;
import static net.codigojoany.usotiempodane.R.id.textView;

/**
 * Created by michael on 30/10/2017.
 */

public class MenuBienvenido extends AppCompatActivity {
    Button btnBienvenido;
    private TextView txt2, txt3, txt4, txt5, txt6, txt7,  titulo;
    private Typeface fuenteS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //FUENTES
        String fuente = "font/fuente.ttf";
        this.fuenteS = Typeface.createFromAsset(getAssets(), fuente);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido);

        titulo = (TextView) findViewById(R.id.txtTitulo);
        titulo.setTypeface(fuenteS);


        txt2 = (TextView) findViewById(R.id.txt2);
        txt2.setTypeface(fuenteS);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt3.setTypeface(fuenteS);
        txt4 = (TextView) findViewById(R.id.txt4);
        txt4.setTypeface(fuenteS);
        txt5 = (TextView) findViewById(R.id.txt5);
        txt5.setTypeface(fuenteS);
        txt6 = (TextView) findViewById(R.id.txt6);
        txt6.setTypeface(fuenteS);
        txt7 = (TextView) findViewById(R.id.txt7);
        txt7.setTypeface(fuenteS);


        btnBienvenido = (Button) findViewById(R.id.btnContinuar);
        btnBienvenido.setTypeface(fuenteS);
        btnBienvenido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuBienvenido.this, Menu.class);
                startActivity(i);
                finish();
            }
        });
    }
}
