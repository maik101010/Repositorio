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

public class MenuActividadesCml extends AppCompatActivity {
    private Button botonVolver, btnDormir, btnDespertar, btnLevantar, btnBañar, btnArreglar, btnJardineria,
            btnMascota, btnLavarPlatos, btnPlanchar, btnLimpiarCasa, btnCuidarPersona, btnPrepararAlimentos, btnComer, btnOtra;
    private TextView titulo;
    private EditText txtCantidad;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades_cml);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");

        titulo = (TextView)findViewById(R.id.textView9);
        titulo.setTypeface(typeface);
        botonVolver = (Button) findViewById(R.id.btnVolver);
        botonVolver.setTypeface(typeface);
        btnDormir = (Button) findViewById(R.id.btnDormir);
        btnDormir.setTypeface(typeface);
        btnDespertar = (Button) findViewById(R.id.btnDespertar);
        btnDespertar.setTypeface(typeface);
        btnLevantar = (Button) findViewById(R.id.btnLevantar);
        btnLevantar.setTypeface(typeface);
        btnBañar = (Button) findViewById(R.id.btnBañar);
        btnBañar.setTypeface(typeface);
        btnArreglar = (Button) findViewById(R.id.btnArreglar);
        btnArreglar.setTypeface(typeface);
        btnJardineria = (Button) findViewById(R.id.btnJardineria);
        btnJardineria.setTypeface(typeface);
        btnMascota = (Button) findViewById(R.id.btnMascota);
        btnMascota.setTypeface(typeface);
        btnLavarPlatos = (Button) findViewById(R.id.btnLavarPlatos);
        btnLavarPlatos.setTypeface(typeface);
        btnPlanchar = (Button) findViewById(R.id.btnPlanchar);
        btnPlanchar.setTypeface(typeface);
        btnLimpiarCasa = (Button) findViewById(R.id.btnLimpiarCasa);
        btnLimpiarCasa.setTypeface(typeface);
        btnCuidarPersona = (Button) findViewById(R.id.btnCuidar);
        btnCuidarPersona.setTypeface(typeface);
        btnPrepararAlimentos = (Button) findViewById(R.id.btnPreparAlimentos);
        btnPrepararAlimentos.setTypeface(typeface);

        btnComer = (Button) findViewById(R.id.btnComer);
        btnComer.setTypeface(typeface);
        btnOtra = (Button) findViewById(R.id.btnOtra);
        btnOtra.setTypeface(typeface);

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActividadesCml.this, MenuActividades.class);
                finish();
            }
        });

        btnComer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesCml.this);
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
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesCml.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesCml.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
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

                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                builder.setTitle("¿Cuál?");
                txtCantidad = new EditText(MenuActividadesCml.this);
                builder.setView(txtCantidad);
                //En caso de que sea positivo
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Operamos
                        String enviarCantidad = txtCantidad.getText().toString();


                        if(!enviarCantidad.equals("")){

                            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                            builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                            txtCantidad = new EditText(MenuActividadesCml.this);
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
                                                Toast.makeText(MenuActividadesCml.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                                Intent pantalla = new Intent(MenuActividadesCml.this, HorasActividades.class);
                                                pantalla.putExtra("cantidad", enviarCantidad);
                                                startActivity(pantalla);
                                            } else {
                                                Toast.makeText(MenuActividadesCml.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                            }

                                        } else {
                                            Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                                        }

                                    }catch(NumberFormatException e){
                                        Toast.makeText(MenuActividadesCml.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            //En caso de que sea negativo, no hacemos nada
                            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
                                }
                            });
                    /*Dialog d = builder.create();
                    d.show();*/
                            builder.show();

                        }



                        else {
                            Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }

        });

        btnDormir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesCml.this);
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
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesCml.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesCml.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });


        btnDespertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesCml.this);
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
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesCml.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesCml.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });

        btnLevantar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesCml.this);
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
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesCml.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesCml.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });

        btnBañar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesCml.this);
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
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesCml.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesCml.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });

        btnArreglar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesCml.this);
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
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesCml.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesCml.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });

        btnJardineria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesCml.this);
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
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesCml.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesCml.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });

        btnMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesCml.this);
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
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesCml.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesCml.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });

        btnLavarPlatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesCml.this);
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
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesCml.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesCml.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });

        btnPlanchar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesCml.this);
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
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesCml.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesCml.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });

        btnLimpiarCasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesCml.this);
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
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesCml.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesCml.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });


        //Llamamos a la clase MenuCuidarPersonas
        btnCuidarPersona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pantalla = new Intent(MenuActividadesCml.this, MenuCuidarPersonas.class);
                startActivity(pantalla);
            }

        });

        btnPrepararAlimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesCml.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesCml.this);
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
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesCml.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesCml.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesCml.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesCml.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesCml.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });
    }
}
