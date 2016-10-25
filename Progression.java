package robot.org.boiteameuh;

/**
 * Created by 34011-73-04 on 24/10/2016.
 */

public class Progression {
    Integer premier, deuxieme, troisieme, quatrieme;
    String nomAccord;

    public Progression(String nomAccord,Integer premier, Integer deuxieme, Integer troisieme, Integer quatrieme) {
        super();
        this.nomAccord = nomAccord;
        this.premier = premier;
        this.deuxieme = deuxieme;
        this.troisieme = troisieme;
        this.quatrieme = quatrieme;
    }

    public String getNomAccord() {
        return nomAccord;
    }

    public void setNomAccord(String nomAccord) {
        this.nomAccord = nomAccord;
    }

    public Integer getPremier() {
        return premier;
    }

    public Integer getDeuxieme() {
        return deuxieme;
    }

    public Integer getTroisieme() {
        return troisieme;
    }

    public Integer getQuatrieme() {
        return quatrieme;
    }

    public void setPremier(Integer premier) {
        this.premier = premier;
    }

    public void setDeuxieme(Integer deuxieme) {
        this.deuxieme = deuxieme;
    }

    public void setTroisieme(Integer troisieme) {
        this.troisieme = troisieme;
    }

    public void setQuatrieme(Integer quatrieme) {
        this.quatrieme = quatrieme;
    }

    @Override
    public String toString() {
        return "Progression [premier=" + premier + ", deuxieme=" + deuxieme + ", troisieme=" + troisieme
                + ", quatrieme=" + quatrieme + "]";
    }


}
