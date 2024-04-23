import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        //Direccion de solicitud a la API
        URI direccionApi = URI.create("https://v6.exchangerate-api.com/v6/3f53e2483b534f1029da6437/latest/USD");

        //Crear el cliente http
        HttpClient client = HttpClient.newHttpClient();

        //Crear el httpRequest
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccionApi)
                .build();

        //Crear el HttpResponse
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //Convertir data json a java object
        Gson gson = new Gson();
        Data data = gson.fromJson(response.body(), Data.class);

        //obtener el valor de clp chile
        double clp = data.conversion_rates().getClp();

        //MENU Y CALCULO
        String menu = """
                
                $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                Bienvenid@s al Conversor de Moneda
                
                1)Dólar (USD) =>> Peso Chileno (CLP)
                2)Peso Chileno (CLP) =>> Dólar (USD)
                3)Euro (EUR) =>> Peso Chileno (CLP)
                4)Peso Chileno (CLP) =>> Euro (EUR)
                """;

        System.out.println(menu);






    }
}
