package net.codigojoany.usotiempodane;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class Recibir extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomar);
        Intent recibir = getIntent();
        String datos = recibir.getStringExtra("datos");
        Toast.makeText(this, "Los datos son " + datos, Toast.LENGTH_SHORT).show();
    }


}

