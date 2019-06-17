package net.codigojoany.usotiempodane;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class Enviar extends AppCompatActivity {


    private EditText editusuario;
    private Button botoningresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar);



        editusuario = (EditText) findViewById(R.id.txtenviar);

        botoningresar = (Button) findViewById(R.id.button2);


        botoningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Enviar.this, Recibir.class);

                String datos = editusuario.getText().toString();
                i.putExtra("datos", datos);

                startActivity(i);
            }
        });
}
    }

