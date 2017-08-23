package com.example.martdominguez.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private Button botonAdivinar;
    private EditText valorIngresado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        txtResult = (TextView) findViewById(R.id.txtResultado);
        botonAdivinar = (Button) findViewById(R.id.btnApostar);
        valorIngresado = (EditText) findViewById(R.id.numeroApostado);


    }

    private View.OnClickListener btnApostarListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Random r = new Random();
            Integer nroIngresado = Integer.valueOf(valorIngresado.getText().toString());
            Integer nroObtenido = r.nextInt(10);
            if(nroIngresado==nroObtenido){
                txtResult.setText(" GANASTE  con el " +nroIngresado+"!!!");
            }else{
                txtResult.setText(" Perdiset apostaste a " +nroIngresado+" y salio " + nroObtenido+" !!!");
            }
            txtResult.setVisibility(View.VISIBLE);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
