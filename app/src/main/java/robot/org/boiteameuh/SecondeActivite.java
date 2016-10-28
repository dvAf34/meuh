package robot.org.boiteameuh;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.OrientationEventListener;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;

import static android.view.Surface.ROTATION_270;


/**
 * Created by 34011-73-04 on 21/10/2016.
 */

public class SecondeActivite extends Activity {

    private SensorManager mSensorManager1;
    private ShakeEventListener mSensorListener;





    private MediaPlayer mp;
    private Hashtable<String,Integer>ht;
    private Button acc1;
    private Button acc2;
    private Button acc3;
    private Button acc4;

    private TextView tacc1;
    private TextView tacc2;
    private TextView tacc3;
    private TextView tacc4;
    private ArrayList<MediaPlayer> mPlayerList = new ArrayList<MediaPlayer>();


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondeactivite);






        mSensorManager1 = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        acc1 = (Button) findViewById(R.id.boutonAccord1);
        acc2 = (Button) findViewById(R.id.boutonAccord2);
        acc3 = (Button) findViewById(R.id.boutonAccord3);
        acc4 = (Button) findViewById(R.id.boutonAccord4);

         tacc1=(TextView)findViewById((R.id.TextAccord1));
       tacc2=(TextView)findViewById((R.id.TextAccord2));
         tacc3=(TextView)findViewById((R.id.TextAccord3));
         tacc4=(TextView)findViewById((R.id.TextAccord4));

        //ajout des noms des notes mises dans le putExtra de l'activité précédente, dans les boutons

        tacc1.setText(getIntent().getStringExtra("String1"));
        tacc2.setText(getIntent().getStringExtra("String2"));
        tacc3.setText(getIntent().getStringExtra("String3"));
        tacc4.setText(getIntent().getStringExtra("String4"));

//création d'un Hastable qui contient le nom de la note et le fichier mp3 qui lui est associé
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
        ht.put("abis",R.raw.abis);

        //remplissage du tableau mPlayerList qui contient 4 MediaPlayer qui lise les 4 fichiers mp3 associés aux boutons

        mPlayerList.add(MediaPlayer.create(SecondeActivite.this, ht.get(tacc1.getText().toString())));
        mPlayerList.add(MediaPlayer.create(SecondeActivite.this, ht.get(tacc2.getText().toString())));
        mPlayerList.add(MediaPlayer.create(SecondeActivite.this, ht.get(tacc3.getText().toString())));
        mPlayerList.add(MediaPlayer.create(SecondeActivite.this, ht.get(tacc4.getText().toString())));


        //ajout des Listener sur chaque bouton pour que chaqu'un joue le fichier mp3 qui lui est associé quand on appui dessus.
        acc1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                musiqueBouton(tacc1.getText().toString());

            }
        });

        acc2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                musiqueBouton(tacc2.getText().toString());

            }
        });
        acc3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                musiqueBouton(tacc3.getText().toString());

            }
        });
        acc4.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                musiqueBouton(tacc4.getText().toString());
            }
        });

        //déclaration des capteurs que l'on va utiliser pour détecter les secousses et leur nombre via la classe JAVA ShakeEventListener

        mSensorListener = new ShakeEventListener();

        mSensorListener.setOnShakeListener(new ShakeEventListener.OnShakeListener() {


            @Override

            public void onShake(int count) {
				/*
				 * The following method, "handleShakeEvent(count):" is a stub //
				 * method you would use to setup whatever you want done once the
				 * device has been shook.
				 */




                    if (count < 4) {
                        handleShakeEvent(count - 1);

                    } else if (count >=4) {

                        handleShakeEvent(count - 1);
                        mSensorListener.mShakeCount=0;

                    }



            }


        });






        }



    public void handleShakeEvent(int count)
    {
        mPlayerList.get(count).start();
    }




    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager1.registerListener(mSensorListener,
                mSensorManager1.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    protected void onPause() {
        mSensorManager1.unregisterListener(mSensorListener);
        super.onPause();
        //mOrientation.stopListening();
    }
    @Override
    protected void onStop() {
        super.onStop();  // Always call the superclass method first

    }

    public void musiqueBouton(String nombouton){

        mp = MediaPlayer.create(SecondeActivite.this,ht.get(nombouton));
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });



    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen for landscape and portrait
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            for(int i =0; i<mPlayerList.size()-1;i++)
            {

                mPlayerList.get(i).setNextMediaPlayer(mPlayerList.get(i+1));



            }
            mPlayerList.get(0).start();

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            mPlayerList.get(0).stop();
        }
    }




}
