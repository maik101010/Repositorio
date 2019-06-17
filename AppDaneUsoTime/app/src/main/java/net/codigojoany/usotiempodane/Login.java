package net.codigojoany.usotiempodane;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class Login extends AppCompatActivity {


    private EditText editusuario, editcontraseña;
    private Button botoningresar;
    private Button botonregistrar;
    private RadioButton NoCerrarSesion;
    private TextView titulo;

    //url de la direccion donde va obtener datos
    private static final String ip = "http://appdaneusotime.webcindario.com/AppDaneUseTime/Login_GETID.php?id=";
    //private static final String iptoken = "http://www.jokapps.com/Token_INSERTandUPDATE.php";


    private VolleyRP volley;
    private RequestQueue mRequest;

    private String EMAIL = "";
    private String PASSWORD = "";


    private Boolean estadoRB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");


        volley = VolleyRP.getInstance(this);
        mRequest = volley.getRequestQueue();
        titulo =(TextView) findViewById(R.id.textView8);
        titulo.setTypeface(typeface);

        editusuario = (EditText) findViewById(R.id.etusuario);
        editusuario.setTypeface(typeface);
        editcontraseña = (EditText) findViewById(R.id.etcontraseña);
        editcontraseña.setTypeface(typeface);

        botoningresar = (Button) findViewById(R.id.btningreso);
        botoningresar.setTypeface(typeface);
        botonregistrar = (Button) findViewById(R.id.btnregistro);
        botonregistrar.setTypeface(typeface);
        NoCerrarSesion = (RadioButton) findViewById(R.id.sesion);
        NoCerrarSesion.setTypeface(typeface);
        estadoRB = NoCerrarSesion.isChecked();//desactivado radio buton







        //para configurar el estado del radioButton
        NoCerrarSesion.setOnClickListener(new View.OnClickListener() {
            //activado radiobuton
            @Override
            public void onClick(View v) {
                if (estadoRB) {
                    NoCerrarSesion.setChecked(false);
                }
                estadoRB = NoCerrarSesion.isChecked();
            }
        });

        botonregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //llamas al activity_condiciones
                Intent pantalla = new Intent(Login.this, Registro.class);
                startActivity(pantalla);

            }
        });
        botoningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //el toLowerCase es para que envie los datos en minusculas y no tenga en cuenta la mayusculas
                Verificarlogin(editusuario.getText().toString().toLowerCase(), editcontraseña.getText().toString().toLowerCase());


            }
        });


    }

    //Para cargar la fuente o letra

    public void Verificarlogin(String correo, String Password) {
        EMAIL = correo;
        PASSWORD = Password;
        //el ip es la direccion en donde contiene el php para loguearse
        SolicitudJSON(ip + EMAIL);

    }

    public void SolicitudJSON(String URL) {
        JsonObjectRequest solicitud = new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject datos) {
                Verificarpassword(datos);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Login.this, "El servicio de internet debe estar activo", Toast.LENGTH_SHORT).show();

            }
        });
        VolleyRP.addToQueue(solicitud, mRequest, this, volley);

    }

    public void Verificarpassword(JSONObject datos) {
        try {

            //"CC" esta contenido en un php y verifica si es el correcto
            String estado = datos.getString("resultado");
            if (estado.equals("CC")) {
                JSONObject jsondatos = new JSONObject(datos.getString("datos"));
                String usuario = jsondatos.getString("correo");
                String contrasena = jsondatos.getString("contrasenia");
                if (usuario.equals(EMAIL) && contrasena.equals(PASSWORD)) {
                    Toast.makeText(this, "Bienvenido(a)", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Login.this, MenuBienvenido.class);
                    startActivity(i);


                } else
                    Toast.makeText(this, "la contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                //transportar a otra actividad
            } else
                Toast.makeText(this, estado, Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
        }
    }


}

