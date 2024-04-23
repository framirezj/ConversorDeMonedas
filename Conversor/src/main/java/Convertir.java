import com.google.gson.Gson;
import java.net.http.HttpResponse;

public class Convertir {

    public Moneda aObjectJava(HttpResponse<String> response){

        Gson gson = new Gson();
        Data data = gson.fromJson(response.body(), Data.class);
        return data.conversion_rates();

    }
}
