package net.codigojoany.usotiempodane;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.IdRes;
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
import android.widget.RadioGroup;
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
import static net.codigojoany.usotiempodane.R.layout.activity_reportes;


public class MenuReportes extends AppCompatActivity {



    private Spinner spActividades, spFrecuencia;
    private Button btnSiguiente, btnVolver;
    ArrayAdapter<String> aaActividades, aaFrecuencia;
    String[] opcActividades = new String[]{"De cuidado personal, limpieza y mantenimiento del hogar", "De salud",
            "Laborales", "De estudio", "De entretenimiento", "De desplazamiento", "Otras actividades"};
    String[] opcFrecuencia = new String[]{"Diaria", "Semana", "Mensual"};
    private TextView titulo, txtFrecuencia, txtActividad;
    private EditText txtHorarios,txtCantidad;
    private EditText txtTiempoAcumulado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportes);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");
        titulo = (TextView)findViewById(R.id.textView2);
        titulo.setTypeface(typeface);

        txtTiempoAcumulado = (EditText) findViewById(R.id.etTiempo);
        txtTiempoAcumulado.setTypeface(typeface);
        txtHorarios = (EditText) findViewById(R.id.etHorario);
        txtHorarios.setTypeface(typeface);


        txtFrecuencia = (TextView)findViewById(R.id.txtFrecuencia);
        txtFrecuencia.setTypeface(typeface);

        txtActividad = (TextView)findViewById(R.id.txtActividad);
        txtActividad.setTypeface(typeface);



        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setTypeface(typeface);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setTypeface(typeface);

        spActividades = (Spinner) findViewById(R.id.spActividades);

        spFrecuencia = (Spinner) findViewById(R.id.spFrecuencia);

        //cargamos nuestra configuración del item
        aaActividades = new ArrayAdapter<String>(this, R.layout.spinner_item, opcActividades);

        aaFrecuencia = new ArrayAdapter<String>(this, R.layout.spinner_item, opcFrecuencia);

        //departamentoList = new ArrayList<Departamento>();
        //municipioList = new ArrayList<Municipio>();

        spActividades.setAdapter(aaActividades);
        spActividades.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1){
                    txtTiempoAcumulado.setText("24:00 horas");
                    String actividad = spActividades.getSelectedItem().toString();
                    txtHorarios.setText(actividad + " 24 horas");
                }
                if (position==2) {
                    txtTiempoAcumulado.setText("18:00 horas");
                    String actividad = spActividades.getSelectedItem().toString();
                    txtHorarios.setText(actividad + " 18 horas");
                }
                if (position==3) {
                    txtTiempoAcumulado.setText("18:00 horas");
                    String actividad = spActividades.getSelectedItem().toString();
                    txtHorarios.setText(actividad + " 14 horas");
                }
                if (position==4) {
                    txtTiempoAcumulado.setText("18:00 horas");
                    String actividad = spActividades.getSelectedItem().toString();
                    txtHorarios.setText(actividad + " 16 horas");
                }
                if (position==5) {
                    txtTiempoAcumulado.setText("18:00 horas");
                    String actividad = spActividades.getSelectedItem().toString();
                    txtHorarios.setText(actividad + " 10 horas");
                }
                if (position==6) {
                    txtTiempoAcumulado.setText("18:00 horas");
                    String actividad = spActividades.getSelectedItem().toString();
                    txtHorarios.setText(actividad + " 10 horas");
                }
                if (position==7) {
                    txtTiempoAcumulado.setText("18:00 horas");
                    String actividad = spActividades.getSelectedItem().toString();
                    txtHorarios.setText(actividad + " 16 horas");
                }
                if (position==8) {
                    txtTiempoAcumulado.setText("18:00 horas");
                    String actividad = spActividades.getSelectedItem().toString();
                    txtHorarios.setText(actividad + " 14 horas");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spFrecuencia.setAdapter(aaFrecuencia);
        spFrecuencia.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuReportes.this, Menu.class);
                startActivity(i);
            }
        });


           btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   final String array[] = new String[3];
                    array[0] = "1. Tabla";
                    array[1] = "2. Gráfico";
                    array[2] = "3. Tabla y gráfico";
                    AlertDialog.Builder builder = new AlertDialog.Builder(MenuReportes.this);
                    builder.setTitle("Seleccionar el tipo de reporte:")

                            .setItems(array, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {

                                    if (which == 0) {
                                       Toast.makeText(MenuReportes.this, "Seleccionó Tabla", Toast.LENGTH_SHORT).show();
                                        Intent pantalla = new Intent(MenuReportes.this, Menu.class);
                                        startActivity(pantalla);
                                        finish();
                                    }
                                    if (which == 1) {
                                        Toast.makeText(MenuReportes.this, "Seleccionó Gráfico", Toast.LENGTH_SHORT).show();
                                        Intent pantalla = new Intent(MenuReportes.this, Menu.class);
                                        startActivity(pantalla);
                                        finish();

                                    }
                                    if (which == 2) {
                                          Toast.makeText(MenuReportes.this, "Seleccionó los dos", Toast.LENGTH_SHORT).show();
                                            Intent pantalla = new Intent(MenuReportes.this, Menu.class);
                                            startActivity(pantalla);
                                            finish();

                                    }

                                }
                            });
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MenuReportes.this, "Cancelado", Toast.LENGTH_SHORT).show();
                        }
                    });

                    builder.show();


            }

        });
    }

}
