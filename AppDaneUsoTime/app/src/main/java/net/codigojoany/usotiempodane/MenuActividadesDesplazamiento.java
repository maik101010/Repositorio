package net.codigojoany.usotiempodane;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by michael on 24/10/2017.
 */

public class MenuActividadesDesplazamiento extends AppCompatActivity {
    private Button botonVolver, btnSiguiente;
    private RadioButton rdcasa, rdtrabajo, rduni, rdunitrabajo, rdunicasa, rdcasacentro, rdtrabajocentro,  rdotro ;
    private EditText txtCantidad;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desplazamiento);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");

        titulo = (TextView)findViewById(R.id.textView9);
        titulo.setTypeface(typeface);
        botonVolver = (Button) findViewById(R.id.btnVolver);
        botonVolver.setTypeface(typeface);
        btnSiguiente= (Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setTypeface(typeface);
        rdcasa = (RadioButton) findViewById(R.id.rdcasa);
        rdcasa.setTypeface(typeface);
        rdtrabajo = (RadioButton) findViewById(R.id.rdtrabajo);
        rdtrabajo.setTypeface(typeface);
        rduni = (RadioButton) findViewById(R.id.rduni);
        rduni.setTypeface(typeface);
        rdunitrabajo = (RadioButton) findViewById(R.id.rdunitrabajo);
        rdunitrabajo.setTypeface(typeface);
        rdunicasa = (RadioButton) findViewById(R.id.rdunicasa);
        rdunicasa.setTypeface(typeface);
        rdcasacentro = (RadioButton) findViewById(R.id.rdcasacentro);
        rdcasacentro.setTypeface(typeface);
        rdtrabajocentro = (RadioButton) findViewById(R.id.rdtrabajocentro);
        rdtrabajocentro.setTypeface(typeface);
        rdotro = (RadioButton) findViewById(R.id.rdotro);
        rdotro.setTypeface(typeface);

        rdcasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdtrabajo.setChecked(false);
                rduni.setChecked(false);
                rdunitrabajo.setChecked(false);
                rdunicasa.setChecked(false);
                rdcasacentro.setChecked(false);
                rdtrabajocentro.setChecked(false);
                rdotro.setChecked(false);

            }
        });

        rdtrabajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdcasa.setChecked(false);
                rduni.setChecked(false);
                rdunitrabajo.setChecked(false);
                rdunicasa.setChecked(false);
                rdcasacentro.setChecked(false);
                rdtrabajocentro.setChecked(false);
                rdotro.setChecked(false);

            }
        });

        rduni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdcasa.setChecked(false);
                rdtrabajo.setChecked(false);
                rdunitrabajo.setChecked(false);
                rdunicasa.setChecked(false);
                rdcasacentro.setChecked(false);
                rdtrabajocentro.setChecked(false);
                rdotro.setChecked(false);

            }
        });

        rdunitrabajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdcasa.setChecked(false);
                rdtrabajo.setChecked(false);
                rduni.setChecked(false);
                rdunicasa.setChecked(false);
                rdcasacentro.setChecked(false);
                rdtrabajocentro.setChecked(false);
               rdotro.setChecked(false);

            }
        });


        rdunicasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdcasa.setChecked(false);
                rdtrabajo.setChecked(false);
                rduni.setChecked(false);
                rdunitrabajo.setChecked(false);
                rdcasacentro.setChecked(false);
                rdtrabajocentro.setChecked(false);
                rdotro.setChecked(false);

            }
        });

        rdcasacentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdcasa.setChecked(false);
                rdtrabajo.setChecked(false);
                rduni.setChecked(false);
                rdunitrabajo.setChecked(false);
               rdunicasa.setChecked(false);
                rdtrabajocentro.setChecked(false);
                rdotro.setChecked(false);

            }
        });

        rdtrabajocentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdcasa.setChecked(false);
                rdtrabajo.setChecked(false);
                rduni.setChecked(false);
                rdunitrabajo.setChecked(false);
                rdunicasa.setChecked(false);
                rdcasacentro.setChecked(false);
                rdotro.setChecked(false);

            }
        });


        rdotro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rdcasa.setChecked(false);
                rdtrabajo.setChecked(false);
                rduni.setChecked(false);
                rdunitrabajo.setChecked(false);
                rdunicasa.setChecked(false);
                rdcasacentro.setChecked(false);
                rdtrabajocentro.setChecked(false);

            }
        });

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActividadesDesplazamiento.this, MenuActividades.class);
                finish();
            }
        });




            btnSiguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean var = validarRadio();
                    if (var) {
                        if (rdotro.isChecked()){

                            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesDesplazamiento.this);
                            builder.setTitle("¿Cuál?");
                            txtCantidad = new EditText(MenuActividadesDesplazamiento.this);
                            builder.setView(txtCantidad);
                            //En caso de que sea positivo
                            builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Operamos
                                    String enviarCantidad = txtCantidad.getText().toString();
                                    if(!enviarCantidad.equals("")){

                                        AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesDesplazamiento.this);
                                        builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                                        txtCantidad = new EditText(MenuActividadesDesplazamiento.this);
                                        builder.setView(txtCantidad);
                                        //En caso de que sea positivo
                                        builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                try

                                                {
                                                    int enviarCantidad = Integer.parseInt(txtCantidad.getText().toString());

                                                    if (enviarCantidad != 0) {
                                                        if (enviarCantidad < 5 && enviarCantidad > 0) {
                                                            Toast.makeText(MenuActividadesDesplazamiento.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                                            Intent pantalla = new Intent(MenuActividadesDesplazamiento.this, HorasActividades.class);
                                                            pantalla.putExtra("cantidad", enviarCantidad);
                                                            startActivity(pantalla);
                                                        } else {
                                                            Toast.makeText(MenuActividadesDesplazamiento.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                                        }

                                                    } else {
                                                        Toast.makeText(MenuActividadesDesplazamiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                                                    }

                                                }catch(NumberFormatException e){
                                                    Toast.makeText(MenuActividadesDesplazamiento.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                                                }

                                            }
                                        });
                                        //En caso de que sea negativo, no hacemos nada
                                        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                Toast.makeText(MenuActividadesDesplazamiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                    /*Dialog d = builder.create();
                    d.show();*/
                                        builder.show();

                                    }


                                    else {
                                        Toast.makeText(MenuActividadesDesplazamiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });
                            //En caso de que sea negativo, no hacemos nada
                            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MenuActividadesDesplazamiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
                                }
                            });
                    /*Dialog d = builder.create();
                    d.show();*/
                            builder.show();
                        }else {

                            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesDesplazamiento.this);
                            builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                            txtCantidad = new EditText(MenuActividadesDesplazamiento.this);
                            builder.setView(txtCantidad);
                            //En caso de que sea positivo
                            builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    try

                                    {
                                        int enviarCantidad = Integer.parseInt(txtCantidad.getText().toString());

                                        if (enviarCantidad != 0) {
                                            if (enviarCantidad < 5 && enviarCantidad > 0) {
                                                Toast.makeText(MenuActividadesDesplazamiento.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                                Intent pantalla = new Intent(MenuActividadesDesplazamiento.this, HorasActividades.class);
                                                pantalla.putExtra("cantidad", enviarCantidad);
                                                startActivity(pantalla);
                                            } else {
                                                Toast.makeText(MenuActividadesDesplazamiento.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                            }

                                        } else {
                                            Toast.makeText(MenuActividadesDesplazamiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                                        }

                                    }catch(NumberFormatException e){
                                        Toast.makeText(MenuActividadesDesplazamiento.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                                    }


                                }
                            });
                            //En caso de que sea negativo, no hacemos nada
                            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MenuActividadesDesplazamiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
                                }
                            });
                    /*Dialog d = builder.create();
                    d.show();*/
                            builder.show();
                        }
                    }else{
                        Toast.makeText(MenuActividadesDesplazamiento.this, "Selecciona una actividad", Toast.LENGTH_SHORT).show();
                    }

                }
            });




    }

    private boolean validarRadio(){
        int cont = 0;
        if(rdcasa.isChecked() || rdtrabajo.isChecked()||rduni.isChecked() || rdunitrabajo.isChecked() || rdunicasa.isChecked() || rdcasacentro.isChecked()
                || rdtrabajocentro.isChecked() || rdotro.isChecked()){

            return true;


        }else{
            return false;
        }

    }
}
