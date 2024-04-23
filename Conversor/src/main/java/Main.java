import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

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


        //HASTA AQUI YA TENGO LOS DATOS DE USD EN FORMATO STRING

        JsonElement jsonElement = JsonParser.parseString(response.body());

        JsonObject jsonObject = jsonElement.getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Moneda moneda = gson.fromJson(jsonObject.get("conversion_rates"), Moneda.class);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Dolar a CLP");

        double dolar = 50;

        double result = moneda.getClp()*dolar;

        System.out.printf("la conversion de dolar a clp es: %.2f", result);

        System.out.println("CLP A USD");
        double peso = 90_000;
        double resultUSD = peso/moneda.getClp();
        System.out.printf("la conversion de clp a dolar es: %.2f", resultUSD);

    }
}
