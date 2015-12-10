package com.tsis.tecnotour;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;


import java.io.Serializable;

public class Myactivity extends ActionBarActivity {

  ListView lista;
    Global globalLista;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle("Tecno-Tour");
        actionBar.setSubtitle("    T sis   ");
        globalLista= (Global) getApplicationContext();

        GridView gridView = (GridView) findViewById(R.id.Menu);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                switch (position) {
                    case 0:
                       //ferrocarril

                        intent.putExtra("Lugar", (Serializable) globalLista.getLugarList().get(0));
                        startActivity(intent);
                        break;
                    case 1:
                        //alacranes
                        intent.putExtra("Lugar", (Serializable) globalLista.getLugarList().get(4));
                        startActivity(intent);
                        break;
                    case 2:
                        //presidi0
                        intent.putExtra("Lugar", (Serializable) globalLista.getLugarList().get(5));
                        startActivity(intent);
                        break;
                    case 3:
                        //jaguey
                        intent.putExtra("Lugar", (Serializable) globalLista.getLugarList().get(3));
                        startActivity(intent);
                        break;
                    case 4:
                        //MChapala
                        intent.putExtra("Lugar", (Serializable) globalLista.getLugarList().get(6));
                        startActivity(intent);
                        break;
                    case 5:
                         //MSAntonio
                        intent.putExtra("Lugar", (Serializable) globalLista.getLugarList().get(8));
                        startActivity(intent);
                        break;
                    case 6:
                        //Cristiania
                        intent.putExtra("Lugar", (Serializable) globalLista.getLugarList().get(1));
                        startActivity(intent);
                        break;
                    case 7:
                       //Tepalo
                        intent.putExtra("Lugar", (Serializable) globalLista.getLugarList().get(2));
                        startActivity(intent);
                        break;
                }

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my_activity, menu);
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
