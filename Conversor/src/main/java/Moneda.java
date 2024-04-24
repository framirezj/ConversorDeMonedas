import com.google.gson.annotations.SerializedName;

public class Moneda {

    //Atributos

    @SerializedName("CLP")
    private double clp;

    @SerializedName("EUR")
    private double eur;


    //Getters

    public double getClp() {
        return clp;
    }

    public double getEur() {
        return eur;
    }

}

