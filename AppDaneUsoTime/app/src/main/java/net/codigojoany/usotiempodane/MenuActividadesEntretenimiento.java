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
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by michael on 24/10/2017.
 */

public class MenuActividadesEntretenimiento extends AppCompatActivity {
    private Button botonVolver, btnMuseo, btnTv, btnMusica, btnDeporte,
            btnCompras, btnInternet, btnTelefono, btnBares, btnDescansar, btnReligion, btnOtra;
    private TextView titulo;
    private EditText txtCantidad;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entretenimiento);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");

        titulo = (TextView) findViewById(R.id.textView9);
        titulo.setTypeface(typeface);
        botonVolver = (Button) findViewById(R.id.btnVolver);
        botonVolver.setTypeface(typeface);
        btnMuseo = (Button) findViewById(R.id.btnMuseo);
        btnMuseo.setTypeface(typeface);
        btnMusica = (Button) findViewById(R.id.btnMusica);
        btnMusica.setTypeface(typeface);
        btnDeporte = (Button) findViewById(R.id.btnDeporte);
        btnDeporte.setTypeface(typeface);
        btnCompras = (Button) findViewById(R.id.btnCompras);
        btnCompras.setTypeface(typeface);
        btnInternet = (Button) findViewById(R.id.btnInternet);
        btnInternet.setTypeface(typeface);
        btnTelefono = (Button) findViewById(R.id.btnTelefono);
        btnTelefono.setTypeface(typeface);
        btnBares = (Button) findViewById(R.id.btnBares);
        btnBares.setTypeface(typeface);
        btnDescansar = (Button) findViewById(R.id.btnDescansar);
        btnDescansar.setTypeface(typeface);
        btnReligion = (Button) findViewById(R.id.btnReligion);
        btnReligion.setTypeface(typeface);
        btnOtra = (Button) findViewById(R.id.btnOtra);
        btnOtra.setTypeface(typeface);

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActividadesEntretenimiento.this, MenuActividades.class);
                finish();
            }
        });



        btnMuseo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesEntretenimiento.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesEntretenimiento.this);
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
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesEntretenimiento.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesEntretenimiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesEntretenimiento.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesEntretenimiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });

        btnMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesEntretenimiento.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesEntretenimiento.this);
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
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesEntretenimiento.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesEntretenimiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesEntretenimiento.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesEntretenimiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });
        btnDeporte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesEntretenimiento.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesEntretenimiento.this);
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
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesEntretenimiento.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesEntretenimiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesEntretenimiento.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesEntretenimiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });
        btnCompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesEntretenimiento.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesEntretenimiento.this);
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
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesEntretenimiento.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesEntretenimiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesEntretenimiento.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesEntretenimiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });
        btnInternet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesEntretenimiento.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesEntretenimiento.this);
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
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesEntretenimiento.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesEntretenimiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesEntretenimiento.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesEntretenimiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });
        btnTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesEntretenimiento.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesEntretenimiento.this);
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
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesEntretenimiento.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesEntretenimiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesEntretenimiento.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesEntretenimiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });
        btnBares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesEntretenimiento.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesEntretenimiento.this);
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
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesEntretenimiento.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesEntretenimiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesEntretenimiento.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesEntretenimiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });
        btnDescansar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesEntretenimiento.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesEntretenimiento.this);
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
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesEntretenimiento.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesEntretenimiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesEntretenimiento.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesEntretenimiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });


        btnReligion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesEntretenimiento.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesEntretenimiento.this);
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
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesEntretenimiento.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesEntretenimiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesEntretenimiento.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesEntretenimiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
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
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesEntretenimiento.this);
                builder.setTitle("¿Cuál?");
                txtCantidad = new EditText(MenuActividadesEntretenimiento.this);
                builder.setView(txtCantidad);
                //En caso de que sea positivo
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Operamos
                        String enviarCantidad = txtCantidad.getText().toString();


                        if(!enviarCantidad.equals("")){

                            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesEntretenimiento.this);
                            builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                            txtCantidad = new EditText(MenuActividadesEntretenimiento.this);
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
                                                Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                                Intent pantalla = new Intent(MenuActividadesEntretenimiento.this, HorasActividades.class);
                                                pantalla.putExtra("cantidad", enviarCantidad);
                                                startActivity(pantalla);
                                            } else {
                                                Toast.makeText(MenuActividadesEntretenimiento.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                            }

                                        } else {
                                            Toast.makeText(MenuActividadesEntretenimiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                                        }

                                    }catch(NumberFormatException e){
                                        Toast.makeText(MenuActividadesEntretenimiento.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            //En caso de que sea negativo, no hacemos nada
                            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MenuActividadesEntretenimiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
                                }
                            });
                    /*Dialog d = builder.create();
                    d.show();*/
                            builder.show();

                        }



                        else {
                            Toast.makeText(MenuActividadesEntretenimiento.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesEntretenimiento.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();

            }
        });


    }
}
