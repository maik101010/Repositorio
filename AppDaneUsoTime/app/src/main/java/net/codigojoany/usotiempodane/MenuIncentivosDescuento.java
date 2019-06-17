package net.codigojoany.usotiempodane;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Joany on 21/09/2017.
 */

public class MenuIncentivosDescuento extends AppCompatActivity {

    private Button btnOk;
    private TextView txtTexto, txtTitulo;
    private Typeface fuenteS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //FUENTES
        String fuente = "font/fuente.ttf";
        this.fuenteS = Typeface.createFromAsset(getAssets(), fuente);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incentivos_descuento);

        

        txtTitulo = (TextView) findViewById(R.id.textView);
        txtTitulo.setTypeface(fuenteS);
        
        txtTexto = (TextView) findViewById(R.id.textView3);
        txtTexto.setTypeface(fuenteS);

        btnOk = (Button) findViewById(R.id.btnOk);
        btnOk.setTypeface(fuenteS);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(MenuIncentivosDescuento.this, MenuIncentivos.class);
                startActivity(pantalla);
                finish();
            }
        });


    }


}
