package net.codigojoany.usotiempodane;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by michael on 28/09/2017.
 */

public class PerfilUsuario extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");

        TextView textTitulo, txtDiscapacidad, txtlPermanente;
        EditText eTNombre, eTApellido, eTContraseña, eTCorreo;
        Button btnregistro;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        textTitulo = (TextView) findViewById(R.id.textView2);
        textTitulo.setTypeface(typeface);
        txtDiscapacidad = (TextView) findViewById(R.id.txtDiscapacidad);
        txtDiscapacidad.setTypeface(typeface);
        txtlPermanente = (TextView) findViewById(R.id.txtlPermanente);
        txtlPermanente.setTypeface(typeface);


        eTNombre = (EditText) findViewById(R.id.eTNombre);
        eTNombre.setTypeface(typeface);
        eTApellido = (EditText) findViewById(R.id.eTApellido);
        eTApellido.setTypeface(typeface);
        eTContraseña = (EditText) findViewById(R.id.eTContraseña);
        eTContraseña.setTypeface(typeface);
        eTCorreo = (EditText) findViewById(R.id.eTCorreo);
        eTCorreo.setTypeface(typeface);


        btnregistro = (Button)findViewById(R.id.btnActualizar);
        btnregistro.setTypeface(typeface);


    }

}

