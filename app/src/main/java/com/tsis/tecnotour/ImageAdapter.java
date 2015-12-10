package com.tsis.tecnotour;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


/**
 * Created by Luyz on 21/10/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;

    public ImageAdapter(Context c){
        context = c;
    }

    @Override
    public int getCount() {
        return Imagenes.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        ImageView imageView;
        if(convertView == null){
            imageView = new ImageView(context);

            imageView.setLayoutParams(new GridView.LayoutParams(310,260));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }else{
            imageView = (ImageView)convertView;
        }
        imageView.setImageResource(Imagenes[position]);

        return imageView;
    }
    private Integer[] Imagenes = {
            R.drawable.img_antigua_estacion, R.drawable.img_isla_alacranes,
            R.drawable.img_isla_mezcala, R.drawable.img_jaguei,
            R.drawable.img_malecon_chapala, R.drawable.img_malecon_san_antonio,
            R.drawable.img_parque_cristiania, R.drawable.img_tepalo
    };
}
