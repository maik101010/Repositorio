package net.codigojoany.usotiempodane;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActividades extends AppCompatActivity {

    private Button botonSalud,botonLaboral,botonCLM,botonEstudio,botonEntretenimiento,botonDesplazamiento,botonOtros,botonSalir;
    private TextView titulo;
    private EditText txtCantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");

        titulo = (TextView) findViewById(R.id.textView9);
        titulo.setTypeface(typeface);
        botonSalud = (Button) findViewById(R.id.btnsalud);
        botonSalud.setTypeface(typeface);
        botonCLM = (Button) findViewById(R.id.btnclm);
        botonCLM.setTypeface(typeface);
        botonLaboral = (Button) findViewById(R.id.btnlabor);
        botonLaboral.setTypeface(typeface);
        botonEstudio = (Button) findViewById(R.id.btnestudio);
        botonEstudio.setTypeface(typeface);
        botonEntretenimiento = (Button) findViewById(R.id.btnentretenimiento);
        botonEntretenimiento.setTypeface(typeface);
        botonDesplazamiento = (Button) findViewById(R.id.btndesplazamiento);
        botonDesplazamiento.setTypeface(typeface);
        botonOtros = (Button) findViewById(R.id.btnOtra);
        botonOtros.setTypeface(typeface);
        botonSalir = (Button) findViewById(R.id.btnSalir);
        botonSalir.setTypeface(typeface);

        botonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent i =new Intent(MenuActividades.this, Menu.class);
                 startActivity(i);
            }
        });

        botonSalud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActividades.this, MenuActividadesSalud.class);
                startActivity(i);

            }
        });

        botonCLM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(MenuActividades.this, MenuActividadesCml.class);
                startActivity(pantalla);
            }
        });
        botonLaboral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividades.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividades.this);
                builder.setView(txtCantidad);
                //En caso de que sea positivo
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Operamos
                        int enviarCantidad = Integer.parseInt(txtCantidad.getText().toString());


                        if(enviarCantidad!=0){
                            if (enviarCantidad<5 && enviarCantidad>0) {
                                Toast.makeText(MenuActividades.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                Intent pantalla = new Intent(MenuActividades.this, HorasActividades.class);
                                pantalla.putExtra("cantidad", enviarCantidad);
                                startActivity(pantalla);
                            }else{
                                Toast.makeText(MenuActividades.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MenuActividades.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividades.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
                //Toast.makeText(MenuActividades.this,"Tiempo utilizado en el trabajo",Toast.LENGTH_SHORT).show();
            }
        });
        botonEstudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividades.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividades.this);
                builder.setView(txtCantidad);
                //En caso de que sea positivo
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Operamos
                        int enviarCantidad = Integer.parseInt(txtCantidad.getText().toString());


                        if(enviarCantidad!=0){
                            if (enviarCantidad<5 && enviarCantidad>0) {
                                Toast.makeText(MenuActividades.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                Intent pantalla = new Intent(MenuActividades.this, HorasActividades.class);
                                pantalla.putExtra("cantidad", enviarCantidad);
                                startActivity(pantalla);
                            }else{
                                Toast.makeText(MenuActividades.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MenuActividades.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividades.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });
        botonDesplazamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(MenuActividades.this, MenuActividadesDesplazamiento.class);
                startActivity(pantalla);
            }
        });
        botonOtros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(MenuActividades.this, MenuActividadesOtras.class);
                startActivity(pantalla);



            }
        });

        botonEntretenimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(MenuActividades.this, MenuActividadesEntretenimiento.class);
                startActivity(pantalla);
            }
        });



    }
}
