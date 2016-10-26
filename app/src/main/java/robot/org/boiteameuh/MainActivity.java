package robot.org.boiteameuh;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;


import java.util.Hashtable;

import java.util.ArrayList;
import java.util.List;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    EditText accord, tonalite2;
    LayoutInflater inflater1,inflater2;
    View view1, view2;
    TextView nom;
    Intent intenmajeur;
    Switch minmaj;
    Progression alternative, cliche, cliche2, creepy, creepy2, endless, energetic, grungy, memories, rebellious, sad, simple, simple2, wisful;
    Chord c = 	new Chord("c","c", 	"dm", "em", "f", "g", "am", "bdim") ;
    Chord cx = 	new Chord("cx","cx", "dxm", "fm", "fx", "gx", "axm", "cdim") ;
    Chord d = 	new Chord("d","d", 	"em", "fxm", "g", "a", "bm", "cxdim") ;
    Chord dx = 	new Chord("dx","dx", "fm", "gm", "gx", "ax", "cm", "ddim") ;
    Chord e = 	new Chord("e","e", 	"fxm", "gxm", "a", "b", "cxm", "dxdim") ;
    Chord f = 	new Chord("f","f", 	"gm", "am", "ax", "c", "dm", "edim") ;
    Chord fx = 	new Chord("fx","fx", "gxm", "axm", "b", "cx", "dxm", "fdim") ;
    Chord g = 	new Chord("g","g", 	"am", "bm", "c", "d", "em", "fxdim") ;
    Chord gx = 	new Chord("gx","gx", "axm", "cm", "cx", "dx", "fm", "gdim") ;
    Chord a = 	new Chord("a","a", "bm", "cxm", "d", "e", "fxm", "gxdim") ;
    Chord ax = 	new Chord("ax","ax", "cm", "dm", "dx", "f", "gm", "adim") ;
    Chord b = 	new Chord("b","b", "cxm", "dxm", "e", "fx", "gxm", "axdim") ;
    Chord cm = 	new Chord("cm","cm", "ddim", "dx", "fm", "gm", "gx", "ax") ;
    Chord cxm = new Chord("cxm","cxm", "dxdim", "e", "fxm", "gxm", "a", "b") ;
    Chord dm = 	new Chord("dm","dm", "edim", "f", "gm", "am", "ax", "c") ;
    Chord dxm = new Chord("dxm","dxm", "fdim", "fx", "gxm", "axm", "b", "cx") ;
    Chord em = 	new Chord("em","em", "fxdim", "g", "am", "bm", "c", "d") ;
    Chord fm = 	new Chord("fm","fm", "gdim", "gx", "axm", "cm", "cx", "dx") ;
    Chord fxm = new Chord("fxm","fxm", "gxdim", "a", "bm", "cxm", "d", "e") ;
    Chord gm = 	new Chord("gm","gm", "adim", "ax", "cm", "dm", "dx", "f") ;
    Chord gxm = new Chord("gxm","gxm", "axdim", "b", "cxm", "dxm", "e", "fx") ;
    Chord am = 	new Chord("am","am", "bdim", "c", "dm", "em", "f", "g") ;
    Chord axm = new Chord("axm","axm", "cdim", "cx", "dxm", "fm", "fx", "gx") ;
    Chord bm = 	new Chord("bm","bm", "cxdim", "d", "em", "fxm", "g", "a") ;

    Hashtable tonalite = new Hashtable();
    ArrayList<String> tabfinal= new ArrayList<String>();
    Chord choix;
    ArrayList<String> tab;
    int tonechoice;
    int progressionchoice;
    Progression choixP;
    Hashtable progression = new Hashtable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inflater1=LayoutInflater.from(MainActivity.this);
        view1=inflater1.inflate(R.layout.scrollview,null);
        inflater2=LayoutInflater.from(MainActivity.this);
        view2=inflater2.inflate(R.layout.scrollview,null);
        tonalite2=(EditText)findViewById(R.id.texteTonalité);
        nom=(TextView)findViewById(R.id.nom);
        accord = (EditText)findViewById(R.id.texteAccords);
        accord.setText("");
        intenmajeur = new Intent (MainActivity.this,SecondeActivite.class);
        Button accordbu=(Button)findViewById(R.id.boutonAccords);
        Button tonbu=(Button)findViewById(R.id.boutonTonalité);
        List<Progression> acc=generer();
        final AccordAdapter adapter = new AccordAdapter(MainActivity.this,acc);
        List<Tonalite> ton=genererton();

        final TonAdapter adapter2 = new TonAdapter(MainActivity.this,ton);
        // TABLEAU DE PROGRESSIONS D ACCORDS
        progression.put(1, alternative);        progression.put(2, cliche);         progression.put(3, cliche2);
        progression.put(4, creepy);             progression.put(5, creepy2);        progression.put(6, endless);
        progression.put(7, energetic);          progression.put(8, grungy);         progression.put(9, memories);
        progression.put(10, rebellious);        progression.put(11, sad);           progression.put(12, simple);
        progression.put(13, simple2);           progression.put(14, wisful);
        // TABLEAU DES TONALITES
        tonalite.put(1, c);        tonalite.put(2,cx);       tonalite.put(3, d);        tonalite.put(4,dx);
        tonalite.put(5, e);        tonalite.put(6,f);        tonalite.put(7, fx);       tonalite.put(8,g);
        tonalite.put(9, gx);       tonalite.put(10,a);       tonalite.put(11, ax);      tonalite.put(12,b);
        tonalite.put(13, cm);      tonalite.put(14,cxm);     tonalite.put(15, dm);      tonalite.put(16,dxm);
        tonalite.put(17, em);      tonalite.put(18,fm);      tonalite.put(19, fxm);     tonalite.put(20,gm);
        tonalite.put(21,gxm);      tonalite.put(22,am);      tonalite.put(23, axm);     tonalite.put(24,bm);

        accordbu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                AlertDialog.Builder builderSingle = new AlertDialog.Builder(MainActivity.this);
                builderSingle.setTitle("Accords");
                builderSingle.setView(view1);

                builderSingle.setAdapter(adapter,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        accord.setText(adapter.getItem(position).getNomAccord());
                        //intenmajeur.putExtra("String5",adapter.getItem(position).getNomAccord()+"("+position+")");
                        progressionchoice = position+1;
                    }
                });

                builderSingle.show();
                ((ViewGroup)view1.getParent()).removeView(view1);
            }
        });

        tonbu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderSingle = new AlertDialog.Builder(MainActivity.this);
                builderSingle.setTitle("Tonalité");
                builderSingle.setView(view2);

                builderSingle.setAdapter(
                        adapter2,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int position) {
                                tonalite2.setText(adapter2.getItem(position).getNomTon());
                                tonechoice = position+1;
                                //intenmajeur.putExtra("String6",adapter2.getItem(position).getNomTon()+"("+position+")");
                            }
                        });
                builderSingle.show();
                ((ViewGroup)view2.getParent()).removeView(view2);
            }
        });

        ImageButton lecture=(ImageButton)findViewById(R.id.lecture);
        minmaj=(Switch)findViewById((R.id.switch2));
        //acc1=(Button)findViewById(R.id.boutonAccord1);


        lecture.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if (minmaj.isChecked()){
                    choix = (Chord) tonalite.get(tonechoice);
                    tab =remplirtab(choix);

                    choixP = (Progression) progression.get(progressionchoice);

                    tabfinal.add(tab.get(choixP.getPremier()-1));
                    tabfinal.add(tab.get(choixP.getDeuxieme()-1));
                    tabfinal.add(tab.get(choixP.getTroisieme()-1));
                    tabfinal.add(tab.get(choixP.getQuatrieme()-1));

                    intenmajeur.putExtra("String1",tabfinal.get(0).toString());
                    intenmajeur.putExtra("String2",tabfinal.get(1).toString());
                    intenmajeur.putExtra("String3",tabfinal.get(2).toString());
                    intenmajeur.putExtra("String4",tabfinal.get(3).toString());
                }
                else {
                    choix = (Chord) tonalite.get(tonechoice+12);
                    tab =remplirtab(choix);

                    choixP = (Progression) progression.get(progressionchoice);

                    tabfinal.add(tab.get(choixP.getPremier()-1));
                    tabfinal.add(tab.get(choixP.getDeuxieme()-1));
                    tabfinal.add(tab.get(choixP.getTroisieme()-1));
                    tabfinal.add(tab.get(choixP.getQuatrieme()-1));

                    intenmajeur.putExtra("String1",tabfinal.get(0).toString());
                    intenmajeur.putExtra("String2",tabfinal.get(1).toString());
                    intenmajeur.putExtra("String3",tabfinal.get(2).toString());
                    intenmajeur.putExtra("String4",tabfinal.get(3).toString());
                }
                startActivity(intenmajeur);
                onStop();

            }
        });
    }

    protected void onStop() {
        super.onStop();  // Always call the superclass method first
        tabfinal.clear();
    }

    private List<Progression> generer(){

        final List<Progression> acc = new  ArrayList<>();
        acc.add(alternative= 	new Progression("alternative",6,4,1,5));
        acc.add(cliche= 		new Progression("cliche",1,5,6,4));
        acc.add(cliche2= 		new Progression("cliche2",1,6,3,7));
        acc.add(creepy= 		new Progression("creepy",1,6,4,5));
        acc.add(creepy2= 		new Progression("creepy2",1,6,2,6));
        acc.add(endless= 		new Progression("endless",1,6,2,4));
        acc.add(energetic= 		new Progression("energetic",1,3,4,6));
        acc.add(grungy= 		new Progression("grungy",1,4,3,6));
        acc.add(memories= 		new Progression("memories",1,4,1,5));
        acc.add(rebellious= 	new Progression("rebellious",4,1,4,5));
        acc.add(sad= 			new Progression("sad",1,4,5,5));
        acc.add(simple= 		new Progression("simple",1,4,1,4));
        acc.add(simple2= 		new Progression("simple2",1,5,1,5));
        acc.add(wisful=         new Progression("wisful",1,1,4,6));
        return acc;
    }
    private List<Tonalite> genererton(){

        final List<Tonalite> ton = new  ArrayList<>();
        ton.add(new Tonalite("C"));
        ton.add(new Tonalite("C#/Db"));
        ton.add(new Tonalite("D"));
        ton.add(new Tonalite("D#/Eb"));
        ton.add(new Tonalite("E"));
        ton.add(new Tonalite("F"));
        ton.add(new Tonalite("F#/Gb"));
        ton.add(new Tonalite("G"));
        ton.add(new Tonalite("G#/Ab"));
        ton.add(new Tonalite("A"));
        ton.add(new Tonalite("A#/Bb"));
        ton.add(new Tonalite("B"));
        return ton;
    }
    private static ArrayList<String> remplirtab(Chord choix) {

        ArrayList<String> tab = new ArrayList<String>()	;
        tab.add(choix.getI().toString());
        tab.add(choix.getII().toString());
        tab.add(choix.getIII().toString());
        tab.add(choix.getIV().toString());
        tab.add(choix.getV().toString());
        tab.add(choix.getVI().toString());
        tab.add(choix.getVII().toString());
        return tab;
    }
}