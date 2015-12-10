package com.tsis.tecnotour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Daniel on 06/10/15.
 */
public class LugarAdapter extends ArrayAdapter<Lugar> {

 private List<Lugar> objetos;
    private LayoutInflater inflater;
    private int id;

    public LugarAdapter(Context context, int resource, List<Lugar> objects) {
        super(context, resource, objects);
        this.objetos=objects;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public View getView(int pos,View view,ViewGroup viewgrup){
        ViewHolder viewholder = new ViewHolder();
        if(view==null){
         view = inflater.inflate(R.layout.list_single,null);
          assert view!=null;
            viewholder.imagen= (ImageView) view.findViewById(R.id.id_imagen);
            viewholder.texto= (TextView) view.findViewById(R.id.single_post_tv_id);
            view.setTag(viewholder);
        }else{
            viewholder= (ViewHolder) view.getTag();
        }

        viewholder.texto.setText(objetos.get(pos).getNombre());
        switch(objetos.get(pos).getNombre()){
            case "malecon chapala":
                id=getContext().getResources().getIdentifier("ic_malecon_chapala","mipmap",getContext().getPackageName());
                break;
            case "estacion ferrocarril":

        }

        viewholder.imagen.setImageResource(id);
    return view;
    }

    class ViewHolder{
    ImageView imagen;
    TextView texto;

}
}
