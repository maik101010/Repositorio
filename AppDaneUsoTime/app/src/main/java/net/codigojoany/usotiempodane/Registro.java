package net.codigojoany.usotiempodane;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static net.codigojoany.usotiempodane.R.layout.activity_registro;


public class Registro extends AppCompatActivity {


    private Spinner spEtnia, spDepartamento, spMunicipio, spDiscapacidad, spLimitacion;
    ArrayAdapter<String> aaDiscapacidad, aaEtnia, aaLimitacion;
    String[] opcDiscapacidad = new String[]{"Física(s)", "Mental(es)", "Intelectual(es)", "Sensorial(es)", "Múltiple", "Otra", "Ninguna"};
    String[] opcLimitacion = new String[]{ "Al moverse o caminar", "Al usar sus brazos o manos", "Al ver, a pesar de usar lentes o gafas", "Al oír, aún con aparatos especiales", "Al hablar", "Entender o aprender", "Relacionarse con los demás por problemas mentales o emocionales",
            "Bañarse, vestirse, alimentarse por sí mismo", "Otra limitación permanente", "Ninguna de las anteriores"};
    String[] opcEtnia = new String[]{"Indígena", "Gitano(a)", "Raizal del archipiélago", "Palenquero(a)", "Negro(a), Mulato(a) (Afrodescendiente)", "Ninguna"};

    private static final String IP_Registrar = "http://appdaneusotime.webcindario.com/AppDaneUseTime/registro_insert.php";
    private String URL_LISTA_Departamento = "http://appdaneusotime.webcindario.com/AppDaneUseTime/obtenerDepartamentos.php";
    private String URL_LISTA_Municipio = "http://appdaneusotime.webcindario.com/AppDaneUseTime/obtenerMunicipio.php?id=";
    String municipio;
    String limitacion;
    String discapacidad;
    String etnia;
    private Button registros;
    private ImageView atras;
    private EditText textNombre;
    private EditText textApellido;
    private EditText textContraseña;
    private EditText textEmail;
    //Para el cuadro de dialogo de la discapacidad
    private EditText txtDialogDis;

    private int dia;
    private int mes;
    private int año;
    private EditText txtFecha;
    private RadioButton rdHombre, rdOtro, rdMujer, rdUrbano, rdRural;
    private ArrayList<Departamento> departamentoList;
    private ArrayList<Municipio> municipioList;
    private TextView textTitulo, txtDiscapacidad, txtlPermanente, txtPertenencia, txtDepartamento, txtMunicipio;

    private VolleyRP volley;
    private RequestQueue mRequest;
    private JsonObjectRequest solicitud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_registro);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");

        textTitulo = (TextView) findViewById(R.id.textView2);
        textTitulo.setTypeface(typeface);
        txtDiscapacidad = (TextView) findViewById(R.id.txtDiscapacidad);
        txtDiscapacidad.setTypeface(typeface);
        txtlPermanente = (TextView) findViewById(R.id.txtlPermanente);
        txtlPermanente.setTypeface(typeface);
        txtPertenencia = (TextView) findViewById(R.id.txtPertenencia);
        txtPertenencia.setTypeface(typeface);
        txtDepartamento= (TextView) findViewById(R.id.txtDepartamento);
        txtDepartamento.setTypeface(typeface);
        txtMunicipio = (TextView) findViewById(R.id.txtMunicipio);
        txtMunicipio.setTypeface(typeface);


        textNombre = (EditText) findViewById(R.id.eTNombre);
        textNombre.setTypeface(typeface);
        textApellido = (EditText) findViewById(R.id.eTApellido);
        textApellido.setTypeface(typeface);
        textContraseña = (EditText) findViewById(R.id.eTContraseña);
        textContraseña.setTypeface(typeface);
        textEmail = (EditText) findViewById(R.id.eTCorreo);
        textEmail.setTypeface(typeface);

        spEtnia = (Spinner) findViewById(R.id.spEtnia);
        spMunicipio = (Spinner) findViewById(R.id.spMunicipio);
        spDepartamento = (Spinner) findViewById(R.id.spDepartamento);
        spDiscapacidad = (Spinner) findViewById(R.id.spDiscapacidad);
        spLimitacion = (Spinner) findViewById(R.id.spLimitacion);

        txtFecha = (EditText) findViewById(R.id.eTFecha);
        txtFecha.setTypeface(typeface);

        volley = VolleyRP.getInstance(this);
        mRequest = volley.getRequestQueue();

        aaEtnia = new ArrayAdapter<String>(this, R.layout.spinner_item, opcEtnia);

        aaDiscapacidad = new ArrayAdapter<String>(this, R.layout.spinner_item, opcDiscapacidad);
        aaLimitacion = new ArrayAdapter<String>(this, R.layout.spinner_item, opcLimitacion);

        departamentoList = new ArrayList<Departamento>();
        municipioList = new ArrayList<Municipio>();

        spEtnia.setAdapter(aaEtnia);
        spEtnia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                etnia = String.valueOf(position + 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spDiscapacidad.setAdapter(aaDiscapacidad);
        spDiscapacidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                discapacidad = String.valueOf(position + 1);
                if(position==5) {
                    //Arranca el Cuadro de dialogo para agregar otra actividad
                    AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                    builder.setTitle("¿Cuál?");
                    txtDialogDis = new EditText(Registro.this);
                    builder.setView(txtDialogDis);
                    //En caso de que sea positivo
                    builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Operamos
                            String txtOtro = txtDialogDis.getText().toString();
                            if(!txtOtro.equals("")){
                                Toast.makeText(Registro.this, "La discapacidad "+txtOtro + " ha sido guardada", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(Registro.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                    //En caso de que sea negativo, no hacemos nada
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Registro.this, "Cancelado", Toast.LENGTH_SHORT).show();
                        }
                    });
                    /*Dialog d = builder.create();
                    d.show();*/
                    builder.show();


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spLimitacion.setAdapter(aaLimitacion);
        spLimitacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                limitacion = String.valueOf(position + 1);
                if(position==8) {
                    //Arranca el Cuadro de dialogo para agregar otra actividad
                    AlertDialog.Builder builder = new AlertDialog.Builder(Registro.this);
                    builder.setTitle("¿Cuál?");
                    txtDialogDis = new EditText(Registro.this);
                    builder.setView(txtDialogDis);
                    //En caso de que sea positivo
                    builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Operamos
                            String txtOtro = txtDialogDis.getText().toString();
                            if(!txtOtro.equals("")){
                                Toast.makeText(Registro.this, "La limitación "+txtOtro + " ha sido guardada", Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(Registro.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                    //En caso de que sea negativo, no hacemos nada
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(Registro.this, "Cancelado", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.show();


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        new getDepartamento().execute();

        spDepartamento.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                new getMunicipio(position + 1).execute();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spMunicipio.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                municipio = String.valueOf(position + 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        atras = (ImageView) findViewById(R.id.iVAtras);
        rdHombre = (RadioButton) findViewById(R.id.rBHombre);
        rdHombre.setTypeface(typeface);
        rdMujer = (RadioButton) findViewById(R.id.rBMujer);
        rdMujer.setTypeface(typeface);
        rdOtro = (RadioButton) findViewById(R.id.rBOtro);
        rdOtro.setTypeface(typeface);

        rdRural = (RadioButton) findViewById(R.id.rbRural);

        rdRural.setTypeface(typeface);
        rdUrbano = (RadioButton) findViewById(R.id.rbUrbano);
        rdUrbano.setTypeface(typeface);

        Calendar c = Calendar.getInstance();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH);
        año = c.get(Calendar.YEAR);
        mes = mes + 1;
        txtFecha.setText(dia + "/" + mes + "/" + año);

        txtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dp = new DatePickerDialog(Registro.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        txtFecha.setText(dayOfMonth + "/" + month + "/" + year);
                    }
                }, año, mes, dia);
                dp.show();
            }
        });
        registros = (Button) findViewById(R.id.btnregistro);
        registros.setTypeface(typeface);
        ejecutarBoton();

        rdHombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdMujer.setChecked(false);
                rdOtro.setChecked(false);
            }
        });
        rdMujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdHombre.setChecked(false);
                rdOtro.setChecked(false);
            }
        });
        rdOtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdMujer.setChecked(false);
                rdHombre.setChecked(false);
            }
        });

        rdUrbano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdRural.setChecked(false);
            }
        });

        rdRural.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdUrbano.setChecked(false);

            }
        });

        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(Registro.this, Login.class);
                startActivity(pantalla);
                finish();
            }
        });
    }

    private void populateSpinner() {
        List<String> lables = new ArrayList<String>();

        for (int i = 0; i < departamentoList.size(); i++) {
            lables.add(departamentoList.get(i).getNombreDepartamento());
        }
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spDepartamento.setAdapter(spinnerAdapter);


    }

    private class getDepartamento extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... arg0) {
            ServiceHandler jsonParser = new ServiceHandler();
            String json = jsonParser.makeServiceCall(URL_LISTA_Departamento, ServiceHandler.GET);
            Log.e("Response: ", "> " + json);

            if (json != null) {
                try {
                    JSONObject jsonObj = new JSONObject(json);
                    if (jsonObj != null) {

                        JSONArray departamento = jsonObj.getJSONArray("departamento");

                        for (int i = 0; i < departamento.length(); i++) {
                            JSONObject catObj = (JSONObject) departamento.get(i);
                            Departamento cat = new Departamento(catObj.getInt("id_departamento"),
                                    catObj.getString("nombre_departamento"));
                            departamentoList.add(cat);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("JSON Data", "¿No ha recibido ningún dato desde el servidor!");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            populateSpinner();
        }
    }

    private void populateSpinnerMunicipio() {
        List<String> lables = new ArrayList<String>();

        for (int i = 0; i < municipioList.size(); i++) {
            lables.add(municipioList.get(i).getNombre());
        }
        ArrayAdapter<String> spinnerAdapterMunicipio = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);
        spinnerAdapterMunicipio
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMunicipio.setAdapter(spinnerAdapterMunicipio);
    }

    public class getMunicipio extends AsyncTask<Void, Void, Void> {
        int localDepartamento;

        public getMunicipio(int localDepartamento) {
            this.localDepartamento = localDepartamento;
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            ServiceHandler jsonParser = new ServiceHandler();
            String json = jsonParser.makeServiceCall(URL_LISTA_Municipio + localDepartamento, ServiceHandler.GET);
            Log.e("Response: ", "> " + json);
            municipioList.clear();
            if (json != null) {
                try {
                    JSONObject jsonObj = new JSONObject(json);
                    if (jsonObj != null) {
                        JSONArray municipio = jsonObj
                                .getJSONArray("municipio");

                        for (int i = 0; i < municipio.length(); i++) {
                            JSONObject catObj = (JSONObject) municipio.get(i);
                            Municipio cat = new Municipio(catObj.getInt("id_municipio"),
                                    catObj.getString("nombre_municipio"));
                            municipioList.add(cat);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("JSON Data", "¿No ha recibido ningún dato desde el servidor!");
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            populateSpinnerMunicipio();
        }
    }

    private void ejecutarBoton() {
        registros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String genero = "";
                if (rdHombre.isChecked()) genero = "hombre";
                else if (rdMujer.isChecked()) genero = "mujer";
                else genero = "intrasexual";
                registrarWebService(getStringET(textNombre).trim(),
                        getStringET(textContraseña).trim(),
                        getStringET(textApellido).trim(),
                        getStringET(textEmail).trim(), getStringET(txtFecha).trim(),
                        genero, municipio, etnia, discapacidad, limitacion);
            }
        });
    }

    private void registrarWebService(String nombres, String contrasena, String apellidos,
                                     String email, String fechanacimiento, String genero,
                                     String municipio, String etnia, String discapacidad,
                                     String limitacion) {
//condicional para que no pasen datos vacios
        if (!nombres.isEmpty() && !contrasena.isEmpty() && !apellidos.isEmpty()
                && !email.isEmpty() && !fechanacimiento.isEmpty()) {

            //llenar los parametros del array del php
            HashMap<String, String> hashMapToken = new HashMap<>();
            hashMapToken.put("nombre", nombres);
            hashMapToken.put("apellido", apellidos);
            hashMapToken.put("correo", email);
            hashMapToken.put("fecha_nacimiento", fechanacimiento);
            hashMapToken.put("sexo", genero);
            hashMapToken.put("contrasenia", contrasena);
            hashMapToken.put("limitacion_id_limitacion", limitacion);
            hashMapToken.put("etnia_id_etnia", etnia);
            hashMapToken.put("nombre_municipio", municipio);

            hashMapToken.put("discapacidad_id_discapacidad", discapacidad);

            //solicitud que envia el metodo post al php para el registro
            solicitud = new JsonObjectRequest(Request.Method.POST, IP_Registrar, new JSONObject(hashMapToken)
                    , new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject datos) {
                    try {

                        String estado = datos.getString("resultado");
                        if (estado.equalsIgnoreCase("El usuario se registro correctamente")) {
                            Toast.makeText(Registro.this, estado, Toast.LENGTH_SHORT).show();
                            Toast.makeText(Registro.this, "Su usuario de acceso será "+textEmail.getText().toString(), Toast.LENGTH_SHORT).show();
                            Intent pantalla = new Intent(Registro.this, Login.class);
                            startActivity(pantalla);
                            finish();
                        } else {
                            Toast.makeText(Registro.this, estado, Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        Toast.makeText(Registro.this, "No se pudo registrar", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Registro.this, "error en envio de datos", Toast.LENGTH_SHORT).show();
                }
            });
            VolleyRP.addToQueue(solicitud, mRequest, this, volley);
            solicitud = null;
        } else {
            Toast.makeText(this, "Debe llenar todos los datos", Toast.LENGTH_SHORT).show();
        }
    }

    private String getStringET(EditText e) {
        return e.getText().toString();
    }

    //Para cargar la fuente o letra
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
