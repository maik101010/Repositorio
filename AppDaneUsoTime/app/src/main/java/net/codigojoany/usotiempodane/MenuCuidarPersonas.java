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

public class MenuCuidarPersonas extends AppCompatActivity {
    private Button btnNiños, btnDiscapacidad, btnAncianos, btnEnfermos, btnVolver, btnOtro;
    //para la guardar la cantidad de veces
    private EditText txtCantidad;
    private TextView titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personas);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");

        titulo = (TextView) findViewById(R.id.textView9);
        titulo.setTypeface(typeface);
        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setTypeface(typeface);
        btnNiños = (Button) findViewById(R.id.btnNiño);
        btnNiños.setTypeface(typeface);
        btnDiscapacidad = (Button) findViewById(R.id.btnDiscapacidad);
        btnDiscapacidad.setTypeface(typeface);
        btnAncianos = (Button) findViewById(R.id.btnAnciano);
        btnAncianos.setTypeface(typeface);
        btnEnfermos = (Button) findViewById(R.id.btnEnfermo);
        btnEnfermos.setTypeface(typeface);
        btnOtro = (Button) findViewById(R.id.btnOtra);
        btnOtro.setTypeface(typeface);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MenuCuidarPersonas.this, MenuActividadesCml.class);
                finish();

            }
        });

        btnNiños.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuCuidarPersonas.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuCuidarPersonas.this);
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
                                    Toast.makeText(MenuCuidarPersonas.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuCuidarPersonas.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuCuidarPersonas.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuCuidarPersonas.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuCuidarPersonas.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuCuidarPersonas.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();

            }
        });
        btnDiscapacidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuCuidarPersonas.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuCuidarPersonas.this);
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
                                    Toast.makeText(MenuCuidarPersonas.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuCuidarPersonas.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuCuidarPersonas.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuCuidarPersonas.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuCuidarPersonas.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuCuidarPersonas.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });

        btnAncianos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuCuidarPersonas.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuCuidarPersonas.this);
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
                                    Toast.makeText(MenuCuidarPersonas.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuCuidarPersonas.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuCuidarPersonas.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuCuidarPersonas.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuCuidarPersonas.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuCuidarPersonas.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();

            }
        });

        btnEnfermos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MenuCuidarPersonas.this);
                    builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                    txtCantidad = new EditText(MenuCuidarPersonas.this);
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
                                        Toast.makeText(MenuCuidarPersonas.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                        Intent pantalla = new Intent(MenuCuidarPersonas.this, HorasActividades.class);
                                        pantalla.putExtra("cantidad", enviarCantidad);
                                        startActivity(pantalla);
                                    } else {
                                        Toast.makeText(MenuCuidarPersonas.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                    }

                                } else {
                                    Toast.makeText(MenuCuidarPersonas.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                                }

                            }catch(NumberFormatException e){
                                Toast.makeText(MenuCuidarPersonas.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                    //En caso de que sea negativo, no hacemos nada
                    builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MenuCuidarPersonas.this, "Cancelado", Toast.LENGTH_SHORT).show();
                        }
                    });
                    /*Dialog d = builder.create();
                    d.show();*/
                    builder.show();




                }
            });

        btnOtro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MenuCuidarPersonas.this);
                builder.setTitle("¿Cuál?");
                txtCantidad = new EditText(MenuCuidarPersonas.this);
                builder.setView(txtCantidad);
                //En caso de que sea positivo
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Operamos
                        String enviarCantidad = txtCantidad.getText().toString();


                        if(!enviarCantidad.equals("")){

                            AlertDialog.Builder builder = new AlertDialog.Builder(MenuCuidarPersonas.this);
                            builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                            txtCantidad = new EditText(MenuCuidarPersonas.this);
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
                                                Toast.makeText(MenuCuidarPersonas.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                                Intent pantalla = new Intent(MenuCuidarPersonas.this, HorasActividades.class);
                                                pantalla.putExtra("cantidad", enviarCantidad);
                                                startActivity(pantalla);
                                            } else {
                                                Toast.makeText(MenuCuidarPersonas.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                            }

                                        } else {
                                            Toast.makeText(MenuCuidarPersonas.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                                        }

                                    }catch(NumberFormatException e){
                                        Toast.makeText(MenuCuidarPersonas.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            //En caso de que sea negativo, no hacemos nada
                            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MenuCuidarPersonas.this, "Cancelado", Toast.LENGTH_SHORT).show();
                                }
                            });
                    /*Dialog d = builder.create();
                    d.show();*/
                            builder.show();

                        }



                        else {
                            Toast.makeText(MenuCuidarPersonas.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuCuidarPersonas.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();


            }
        });
    }
}
