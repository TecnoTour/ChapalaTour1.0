package com.tsis.tecnotour;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    private ProgressDialog pDialog;

    // Creating JSON Parser object
    JSONParser jParser = new JSONParser();

    ArrayList<HashMap<String, String>> lugarList;
    Global globalLista;


    List<Lugar> lugarLista = new ArrayList<Lugar>();


    // url to get all products list
   // private static String url_all_lugares ="http://tsisbd.pe.hu/test/get_all_lugares2.php";
    private static String url_all_lugares ="http://t-sis.pe.hu/DATABASE/TecnoTour.php";
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_PRODUCTS = "Lugar";
    private static final String TAG_ID = "id";
    private static final String TAG_NOMBRE = "nombre";
    private static final String TAG_LATITUD = "latitud";
    private static final String TAG_LONGITUD = "longitud";
    private static final String TAG_INFOGENERAL = "infogeneral";
    private static final String TAG_ACTIVIDADES = "actividades";
    private static final String TAG_LINKIMAGEN = "linkimagen";

    // products JSONArray
    JSONArray products = null;

    ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        globalLista= (Global) getApplicationContext();
        // Cargar los productos en el Background Thread
        new LoadAllProducts().execute();
        lista = (ListView) findViewById(R.id.listAllProducts);
        TimerTask timerTask= new TimerTask() {
            @Override
            public void run() {


            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask,5000);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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

    class LoadAllProducts extends AsyncTask<String, String, String> {

        /**
         * Antes de empezar el background thread Show Progress Dialog
         * */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(getApplicationContext(), "Cargando porfavor espere", Toast.LENGTH_SHORT).show();
        }

        /**
         * obteniendo todos los productos
         * */
        protected String doInBackground(String... args) {
            Lugar lugar;
            JSONObject c;
            // Building Parameters
            List params = new ArrayList();
            // getting JSON string from URL
            JSONObject json=jParser.makeHttpRequest(url_all_lugares,"GET",params);


            // Check your log cat for JSON reponse
            Log.d("All Products: ", json.toString());

            try {
                // Checking for SUCCESS TAG
                int success = json.getInt(TAG_SUCCESS);

                if (success == 1) {
                    // products found
                    // Getting Array of Products
                    products = json.getJSONArray(TAG_PRODUCTS);

                    // looping through All Products

                    for (int i = 0; i < products.length(); i++) {
                        c = products.getJSONObject(i);
                        // Storing each json item in variable
                        lugar = new Lugar(Integer.parseInt(c.getString(TAG_ID)),
                                c.getString(TAG_NOMBRE),c.getString(TAG_LINKIMAGEN),Float.parseFloat(c.getString(TAG_LATITUD)),Float.parseFloat(c.getString(TAG_LONGITUD)),c.getString(TAG_INFOGENERAL),c.getString(TAG_ACTIVIDADES));

                        lugarLista.add(lugar);

                    }

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * **/
        protected void onPostExecute(String file_url) {
            // dismiss the dialog after getting all products

            // updating UI from Background Thread
            runOnUiThread(new Runnable() {
                public void run() {
                    /**
                     * Updating parsed JSON data into ListView
                     * */
                    globalLista.setLugarList(lugarLista);

                    Intent intentMenu = new Intent(getApplicationContext(),Myactivity.class);
                    startActivity(intentMenu);
                    finish();

                }
            });
        }
    }
}
