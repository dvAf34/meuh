package robot.org.boiteameuh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 34011-73-04 on 20/10/2016.
 */

public class TonAdapter extends ArrayAdapter<Tonalite>{
    public TonAdapter(Context context, List<Tonalite> ton){super(context,0, ton); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){

            convertView= LayoutInflater.from(getContext()).inflate(R.layout.texte,parent,false);


        }

        TonViewHolder viewHolder = (TonViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder=new TonViewHolder();
            viewHolder.nom=(TextView) convertView.findViewById(R.id.nom);
            convertView.setTag(viewHolder);

        }

        Tonalite ton=getItem(position);
        viewHolder.nom.setText(ton.getNomTon());


        return convertView;
    }

    private class  TonViewHolder{

        public TextView nom;

    }


}
