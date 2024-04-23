import com.google.gson.annotations.SerializedName;

public class Moneda {

    //Atributos
    @SerializedName("USD")
    private double usd;

    @SerializedName("CLP")
    private double clp;

    @SerializedName("EUR")
    private double eur;


    //Getters
    public double getUsd() {
        return usd;
    }

    public double getClp() {
        return clp;
    }

    public double getEur() {
        return eur;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public void setClp(double clp) {
        this.clp = clp;
    }

    public void setEur(double eur) {
        this.eur = eur;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "usd=" + usd +
                ", clp=" + clp +
                ", eur=" + eur +
                '}';
    }
}

