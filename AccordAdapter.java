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

public class AccordAdapter extends ArrayAdapter<Progression> {

    public AccordAdapter(Context context, List<Progression> acc){super(context, 0, acc); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if(convertView == null){

            convertView= LayoutInflater.from(getContext()).inflate(R.layout.texte,parent,false);


        }

        AccViewHolder viewHolder = (AccViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder=new AccViewHolder();
            viewHolder.nom=(TextView) convertView.findViewById(R.id.nom);
            convertView.setTag(viewHolder);

        }

        Progression acc=getItem(position);
        viewHolder.nom.setText(acc.getNomAccord());


        return convertView;
    }

    private class  AccViewHolder{

        public TextView nom;

    }

}

