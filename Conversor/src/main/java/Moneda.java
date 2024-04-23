import com.google.gson.annotations.SerializedName;

public class Moneda {

    @SerializedName("USD")
    private double usd;

    @SerializedName("CLP")
    private double clp;

    @SerializedName("EUR")
    private double eur;

    public double getUsd() {
        return usd;
    }

    public double getClp() {
        return clp;
    }

    public double getEur() {
        return eur;
    }
}
