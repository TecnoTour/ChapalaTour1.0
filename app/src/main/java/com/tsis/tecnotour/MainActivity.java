package com.tsis.tecnotour;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
private Lugar lugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        Intent i = getIntent();
        lugar = (Lugar) i.getSerializableExtra("Lugar");

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle("Tecno-Tour");
        actionBar.setSubtitle(" "+lugar.getNombre()+" ");

        actionBar.setDisplayHomeAsUpEnabled(true);


        /**MODO TABS EN ACTIONBAR**/
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        /**CREAR TABS**/

        View view = LayoutInflater.from(this).inflate(R.layout.tabs, null);

        ImageView imageInfo = (ImageView) view.findViewById(R.id.imageTab);
        imageInfo.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_informacion1));
        TextView textInfo = (TextView) view.findViewById(R.id.textTab);

        textInfo.setText("Informacion");

        ActionBar.Tab tab = actionBar.newTab().setCustomView(view).setTabListener(new TabsListener(this, "Informacion", informacion.class, lugar)  );
        actionBar.addTab(tab);


         view = LayoutInflater.from(this).inflate(R.layout.tabs, null);

        ImageView imageInfo1 = (ImageView) view.findViewById(R.id.imageTab);
        imageInfo1.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_actividades1));
        TextView textInfo1 = (TextView) view.findViewById(R.id.textTab);
        textInfo1.setText("Actividades");

        ActionBar.Tab tab1 = actionBar.newTab().setCustomView(view).setTabListener(new TabsListener(this, "Actividades", actividades.class, lugar));
        actionBar.addTab(tab1);


        view = LayoutInflater.from(this).inflate(R.layout.tabs, null);
        ImageView imageInfo2 = (ImageView) view.findViewById(R.id.imageTab);
        imageInfo2.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_galeria1));
        TextView textInfo2 = (TextView) view.findViewById(R.id.textTab);
        textInfo2.setText("Galeria");

        ActionBar.Tab tab2 = actionBar.newTab().setCustomView(view).setTabListener(new TabsListener(this, "Galeria", galeria.class, lugar));
        actionBar.addTab(tab2);

        view = LayoutInflater.from(this).inflate(R.layout.tabs, null);
        ImageView imageInfo3 = (ImageView) view.findViewById(R.id.imageTab);
        imageInfo3.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_localizacion1));
        TextView textInfo3 = (TextView) view.findViewById(R.id.textTab);
        textInfo3.setText("Localizacion");

        ActionBar.Tab tab3 = actionBar.newTab().setCustomView(view).setTabListener(new TabsListener(this, "Localizacion", localizacion.class,lugar));
        actionBar.addTab(tab3);

    }

    public class TabsListener implements ActionBar.TabListener {

        private Fragment fragment;
        private final String tag;
        private Bundle parametro= new Bundle();

        public TabsListener(Activity activity, String tag, Class cls, Lugar  lugar) {
          parametro.putSerializable("lugar",lugar);
            this.tag = tag;
            fragment = Fragment.instantiate(activity, cls.getName());

            fragment.setArguments(parametro);
        }

        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(android.R.id.content, fragment, tag);
        }

        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }

        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }
    }
}
