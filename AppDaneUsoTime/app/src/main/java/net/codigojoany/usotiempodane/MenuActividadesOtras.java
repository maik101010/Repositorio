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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by michael on 24/10/2017.
 */

public class MenuActividadesOtras extends AppCompatActivity {
    private Button botonVolver, btnFacturas, btnCarro, btnComunitaria, btnBelleza, btnHogares, btnOtra;
    private EditText txtCantidad;
    private TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otros);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/fuente.ttf");

        titulo = (TextView)findViewById(R.id.textView9);
        titulo.setTypeface(typeface);
        botonVolver = (Button) findViewById(R.id.btnVolver);
        botonVolver.setTypeface(typeface);
        btnFacturas= (Button) findViewById(R.id.btnFacturas);
        btnFacturas.setTypeface(typeface);
        btnCarro= (Button) findViewById(R.id.btnCarro);
        btnCarro.setTypeface(typeface);
        btnComunitaria= (Button) findViewById(R.id.btnComunitarias);
        btnComunitaria.setTypeface(typeface);
        btnBelleza= (Button) findViewById(R.id.btnBelleza);
        btnBelleza.setTypeface(typeface);
        btnHogares= (Button) findViewById(R.id.btnHogares);
        btnHogares.setTypeface(typeface);
        btnOtra= (Button) findViewById(R.id.btnOtra);
        btnOtra.setTypeface(typeface);


        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActividadesOtras.this, MenuActividades.class);
                finish();
            }
        });

        btnFacturas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesOtras.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesOtras.this);
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
                                    Toast.makeText(MenuActividadesOtras.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesOtras.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesOtras.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesOtras.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesOtras.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesOtras.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });

        btnCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesOtras.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesOtras.this);
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
                                    Toast.makeText(MenuActividadesOtras.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesOtras.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesOtras.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesOtras.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesOtras.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesOtras.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });
        btnComunitaria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesOtras.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesOtras.this);
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
                                    Toast.makeText(MenuActividadesOtras.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesOtras.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesOtras.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesOtras.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesOtras.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesOtras.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });
        btnBelleza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesOtras.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesOtras.this);
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
                                    Toast.makeText(MenuActividadesOtras.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesOtras.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesOtras.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesOtras.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesOtras.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesOtras.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });
        btnHogares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesOtras.this);
                builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                txtCantidad = new EditText(MenuActividadesOtras.this);
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
                                    Toast.makeText(MenuActividadesOtras.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                    Intent pantalla = new Intent(MenuActividadesOtras.this, HorasActividades.class);
                                    pantalla.putExtra("cantidad", enviarCantidad);
                                    startActivity(pantalla);
                                } else {
                                    Toast.makeText(MenuActividadesOtras.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                }

                            } else {
                                Toast.makeText(MenuActividadesOtras.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                            }

                        }catch(NumberFormatException e){
                            Toast.makeText(MenuActividadesOtras.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesOtras.this, "Cancelado", Toast.LENGTH_SHORT).show();
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

                AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesOtras.this);
                builder.setTitle("¿Cuál?");
                txtCantidad = new EditText(MenuActividadesOtras.this);
                builder.setView(txtCantidad);
                //En caso de que sea positivo
                builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Operamos
                        String enviarCantidad = txtCantidad.getText().toString();


                        if(!enviarCantidad.equals("")){

                            AlertDialog.Builder builder = new AlertDialog.Builder(MenuActividadesOtras.this);
                            builder.setTitle("¿Cuántas veces repitió esta actividad durante el día?");
                            txtCantidad = new EditText(MenuActividadesOtras.this);
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
                                                Toast.makeText(MenuActividadesOtras.this, "La cantidad de veces es " + enviarCantidad, Toast.LENGTH_SHORT).show();
                                                Intent pantalla = new Intent(MenuActividadesOtras.this, HorasActividades.class);
                                                pantalla.putExtra("cantidad", enviarCantidad);
                                                startActivity(pantalla);
                                            } else {
                                                Toast.makeText(MenuActividadesOtras.this, "La cantidad digitada no es valida", Toast.LENGTH_SHORT).show();
                                            }

                                        } else {
                                            Toast.makeText(MenuActividadesOtras.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                                        }

                                    }catch(NumberFormatException e){
                                        Toast.makeText(MenuActividadesOtras.this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            //En caso de que sea negativo, no hacemos nada
                            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(MenuActividadesOtras.this, "Cancelado", Toast.LENGTH_SHORT).show();
                                }
                            });
                    /*Dialog d = builder.create();
                    d.show();*/
                            builder.show();

                        }



                        else {
                            Toast.makeText(MenuActividadesOtras.this, "No se ha guardado nada", Toast.LENGTH_SHORT).show();
                        }

                    }
                });
                //En caso de que sea negativo, no hacemos nada
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MenuActividadesOtras.this, "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                });
                    /*Dialog d = builder.create();
                    d.show();*/
                builder.show();
            }
        });



    }
}
