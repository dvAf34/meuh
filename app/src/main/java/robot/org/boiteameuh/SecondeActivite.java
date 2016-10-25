package robot.org.boiteameuh;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Timer;

/**
 * Created by 34011-73-04 on 21/10/2016.
 */

public class SecondeActivite extends Activity{

    MediaPlayer mp;
    ArrayList<Integer> playlist;
    Hashtable<String,Integer>ht;

    Button acc1;
    Button acc2;
    Button acc3;
    Button acc4;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondeactivite);





       acc1 = (Button) findViewById(R.id.boutonAccord1);
        acc2 = (Button) findViewById(R.id.boutonAccord2);
        acc3 = (Button) findViewById(R.id.boutonAccord3);
         acc4 = (Button) findViewById(R.id.boutonAccord4);
       // EditText info=(EditText)findViewById(R.id.DTC);


        acc1.setText(getIntent().getStringExtra("String1"));
        acc2.setText(getIntent().getStringExtra("String2"));
        acc3.setText(getIntent().getStringExtra("String3"));
        acc4.setText(getIntent().getStringExtra("String4"));

        //info.setText(getIntent().getStringExtra("String5")+" "+getIntent().getStringExtra("String6")+" "+getIntent().getStringExtra("String7"));



        playlist = new ArrayList<>();

      ht=new Hashtable<>();


        ht.put("a",R.raw.a);
        ht.put("adim",R.raw.adim);
        ht.put("am",R.raw.am);
        ht.put("ax",R.raw.ax);
        ht.put("axdim",R.raw.axdim);
        ht.put("axm",R.raw.axm);
        ht.put("b",R.raw.b);
        ht.put("bdim",R.raw.bdim);
        ht.put("bm",R.raw.bm);
        ht.put("c",R.raw.c);
        ht.put("cdim",R.raw.cdim);
        ht.put("cm",R.raw.cm);
        ht.put("cx",R.raw.cx);
        ht.put("cxdim",R.raw.cxdim);
        ht.put("cxm",R.raw.cxm);
        ht.put("d",R.raw.d);
        ht.put("ddim",R.raw.ddim);
        ht.put("dm",R.raw.dm);
        ht.put("dx",R.raw.dx);
        ht.put("dxdim",R.raw.dxdim);
        ht.put("dxm",R.raw.dxm);
        ht.put("e",R.raw.e);
        ht.put("edim",R.raw.edim);
        ht.put("em",R.raw.em);
        ht.put("f",R.raw.f);
        ht.put("fdim",R.raw.fdim);
        ht.put("fm",R.raw.fm);
        ht.put("fx",R.raw.fx);
        ht.put("fxdim",R.raw.fxdim);
        ht.put("fxm",R.raw.fxm);
        ht.put("g",R.raw.g);
        ht.put("gdim",R.raw.gdim);
        ht.put("gm",R.raw.gm);
        ht.put("gx",R.raw.gx);
        ht.put("gxdim",R.raw.gxdim);
        ht.put("gxm",R.raw.gxm);







      acc1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


               //playlist.add(ht.get(getIntent().getStringExtra("String1")));

                mp = MediaPlayer.create(SecondeActivite.this,ht.get(acc1.getText().toString()));
               mp.start();
           }
        });

        acc2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                //playlist.add(ht.get(getIntent().getStringExtra("String1")));

                mp = MediaPlayer.create(SecondeActivite.this,ht.get(acc2.getText().toString()));
                mp.start();
            }
        });
        acc3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                //playlist.add(ht.get(getIntent().getStringExtra("String1")));

                mp = MediaPlayer.create(SecondeActivite.this,ht.get(acc3.getText().toString()));
                mp.start();
            }
        });
        acc4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {


                //playlist.add(ht.get(getIntent().getStringExtra("String1")));

                mp = MediaPlayer.create(SecondeActivite.this,ht.get(acc4.getText().toString()));
                mp.start();
            }
        });





    }

}
