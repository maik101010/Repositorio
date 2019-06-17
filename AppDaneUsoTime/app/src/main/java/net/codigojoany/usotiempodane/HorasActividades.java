package net.codigojoany.usotiempodane;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
/**
 * Created by michael on 29/10/2017.
 */

public class HorasActividades extends AppCompatActivity {

    private EditText edHorai, edHoraf;
    TextView titulo;
    private Button btnHorai, btnHoraf, btnGuardar, btnVolver;
    private int hora, minutos;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horas);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");

        titulo = (TextView) findViewById(R.id.textView9);
        titulo.setTypeface(typeface);
        edHorai = (EditText)findViewById(R.id.etHorai);
        edHorai.setTypeface(typeface);
        edHoraf = (EditText)findViewById(R.id.etHoraf);
        edHoraf.setTypeface(typeface);

        btnHorai = (Button) findViewById(R.id.btnHorai);
        btnHorai.setTypeface(typeface);
        btnHoraf = (Button) findViewById(R.id.btnHoraf);
        btnHoraf.setTypeface(typeface);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnGuardar.setTypeface(typeface);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setTypeface(typeface);



        btnHorai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar c = Calendar.getInstance();
                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(HorasActividades.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if (minute<10) {
                            edHorai.setText(hourOfDay + ":0" + minute);
                        }
                        else{
                            edHorai.setText(hourOfDay +":"+ minute);
                        }

                        }
                },hora,minutos,false);
                timePickerDialog.show();

            }
        });

        btnHoraf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();

                hora = c.get(Calendar.HOUR_OF_DAY);
                minutos = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(HorasActividades.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        if(minute<10){
                            edHoraf.setText(hourOfDay+":0"+minute);
                        }
                        else{
                            edHoraf.setText(hourOfDay+":"+minute);
                        }

                    }
                },hora,minutos,false);
                timePickerDialog.show();
            }
        });


        //Recibimos la cantidad de veces digitadas por el usuario
        /*Intent recibir = getIntent();
        String datos = recibir.getStringExtra("datos");
        int var = Integer.parseInt(datos);*/

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String horai, horaf;
                horai = edHorai.getText().toString();
                horaf = edHoraf.getText().toString();

                //Intent recibir = getIntent();
                //int cantidad = Integer.parseInt(recibir.getStringExtra("cantidad"));
                //Regresamos al menú actividades
                if(horai.equals("") || horaf.equals("")){
                    Toast.makeText(HorasActividades.this, "Debes seleccionar las horas", Toast.LENGTH_SHORT).show();
                }else {
                    Intent i = new Intent(HorasActividades.this, MenuActividades.class);
                    Toast.makeText(HorasActividades.this, "Horas guardadas", Toast.LENGTH_SHORT).show();
                    startActivity(i);
                }


            }
        });

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HorasActividades.this, MenuActividades.class);
                startActivity(i);



            }
        });
    }

}
