package robot.org.boiteameuh;

/**
 * Created by 34011-73-04 on 24/10/2016.
 */
public class Chord {

    String I, II, III, IV, V, VI, VII,nomTon;

    public Chord(String nom,String i, String iI, String iII, String iV, String v, String vI, String vII) {
        super();
        this.nomTon=nom;
        I = i;
        II = iI;
        III = iII;
        IV = iV;
        V = v;
        VI = vI;
        VII = vII;
    }


    public String getNomTon() {
        return nomTon;
    }

    public void setNomTon(String nomTon) {
        this.nomTon = nomTon;
    }

    public String getI() {
        return I;
    }

    public String getII() {
        return II;
    }

    public String getIII() {
        return III;
    }

    public String getIV() {
        return IV;
    }

    public String getV() {
        return V;
    }

    public String getVI() {
        return VI;
    }

    public String getVII() {
        return VII;
    }

    public void setI(String i) {
        I = i;
    }

    public void setII(String iI) {
        II = iI;
    }

    public void setIII(String iII) {
        III = iII;
    }

    public void setIV(String iV) {
        IV = iV;
    }

    public void setV(String v) {
        V = v;
    }

    public void setVI(String vI) {
        VI = vI;
    }

    public void setVII(String vII) {
        VII = vII;
    }

    @Override
    public String toString() {
        return "I=" + I + ", II=" + II + ", III=" + III + ", IV=" + IV + ", V=" + V + ", VI=" + VI + ", VII="
                + VII;
    }
}