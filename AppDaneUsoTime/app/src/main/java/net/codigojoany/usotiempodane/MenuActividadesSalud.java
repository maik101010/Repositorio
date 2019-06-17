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

/**
 * Created by michael on 24/10/2017.
 */

public class MenuActividadesSalud extends AppCompatActivity {
    private Button botonVolver, botonDiligencia, botonReclamarMedicamento,botonTerapias, btnOtra;
    //para la guardar la cantidad de veces
    private EditText txtCantidad;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actitivades_salud);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");

        titulo = (TextView)findViewById(R.id.textView9);
        titulo.setTypeface(typeface);

        botonVolver = (Button) findViewById(R.id.btnVolver);
        botonVolver.setTypeface(typeface);
        botonDiligencia = (Button) findViewById(R.id.btnDiligencia);
        botonDiligencia.setTypeface(typeface);
        botonReclamarMedicamento = (Button) findViewById(R.id.btnReclamarMedicamentos);
        botonReclamarMedicamento.setTypeface(typeface);
        botonTerapias = (Button) findViewById(R.id.btnTerapias);
        botonTerapias.setTypeface(typeface);
        btnOtra = (Button) findViewById(R.id.btnOtra);
        btnOtra.setTypeface(typeface);

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MenuActividadesSalud.this, MenuActividades.class);
                finish();

            }
        });

/*        botonDiligencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MenuActividadesSalud.this, HorasActividades.class);
                startActivity(i);

            }
        });*/
        botonReclamarMedicamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesSalud.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesSalud.this);
                builder.setView(txtCantidad);
                //En caso de que sea positivo
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Operamos
                        try

                        {
                            int enviarCantidad = Integer.parseInt(txtCantidad.getText().toString());

                            if (enviarCantidad != 0) {
                                if (enviarCantidad < 5 && enviarCantidad > 0) {
                                    Toast.makeText(MenuActividadesSalud.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesSalud.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesSalud.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesSalud.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesSalud.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesSalud.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();

            }
        });
        botonTerapias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesSalud.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesSalud.this);
                builder.setView(txtCantidad);
                //En caso de que sea positivo
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Operamos
                        try

                        {
                            int enviarCantidad = Integer.parseInt(txtCantidad.getText().toString());

                            if (enviarCantidad != 0) {
                                if (enviarCantidad < 5 && enviarCantidad > 0) {
                                    Toast.makeText(MenuActividadesSalud.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesSalud.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesSalud.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesSalud.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesSalud.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesSalud.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });

        btnOtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesSalud.this);
                builder.setTitle("¿Cuál?");
                txtCantidad = new EditText(MenuActividadesSalud.this);
                builder.setView(txtCantidad);
                //En caso de que sea positivo
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Operamos
                        String enviarCantidad = txtCantidad.getText().toString();


                        if(!enviarCantidad.equals("")){

                            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesSalud.this);
                            builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                            txtCantidad = new EditText(MenuActividadesSalud.this);
                            builder.setView(txtCantidad);
                            //En caso de que sea positivo
                            builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {



                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Operamos
                                    try

                                    {
                                        int enviarCantidad = Integer.parseInt(txtCantidad.getText().toString());

                                        if (enviarCantidad != 0) {
                                            if (enviarCantidad < 5 && enviarCantidad > 0) {
                                                Toast.makeText(MenuActividadesSalud.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                                Intent pantalla = new Intent(MenuActividadesSalud.this, HorasActividades.class);
                                                pantalla.putExtra("cantidad", enviarCantidad);
                                                startActivity(pantalla);
                                            } else {
                                                Toast.makeText(MenuActividadesSalud.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                            }

                                        } else {
                                            Toast.makeText(MenuActividadesSalud.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                                        }

                                    }catch(NumberFormatException e){
                                        Toast.makeText(MenuActividadesSalud.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            //En caso de que sea negativo, no hacemos nada
                            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MenuActividadesSalud.this, "Cancelado", Toast.LENGTH_SHORT).show();
                                }
                            });
                    /*Dialog d = builder.create();
                    d.show();*/
                            builder.show();

                        }



                        else {
                            Toast.makeText(MenuActividadesSalud.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesSalud.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }


        });

        botonDiligencia.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesSalud.this);
                    builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                    txtCantidad = new EditText(MenuActividadesSalud.this);
                    builder.setView(txtCantidad);
                    //En caso de que sea positivo
                    builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Operamos
                            try

                            {
                                int enviarCantidad = Integer.parseInt(txtCantidad.getText().toString());

                                if (enviarCantidad != 0) {
                                    if (enviarCantidad < 5 && enviarCantidad > 0) {
                                        Toast.makeText(MenuActividadesSalud.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                        Intent pantalla = new Intent(MenuActividadesSalud.this, HorasActividades.class);
                                        pantalla.putExtra("cantidad", enviarCantidad);
                                        startActivity(pantalla);
                                    } else {
                                        Toast.makeText(MenuActividadesSalud.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                    }

                                } else {
                                    Toast.makeText(MenuActividadesSalud.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                                }

                            }catch(NumberFormatException e){
                                Toast.makeText(MenuActividadesSalud.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                    //En caso de que sea negativo, no hacemos nada
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MenuActividadesSalud.this, "Cancelado", Toast.LENGTH_SHORT).show();
                        }
                    });
                    /*Dialog d = builder.create();
                    d.show();*/
                    builder.show();




                }
            });
    }
}
