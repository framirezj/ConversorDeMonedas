import com.google.gson.Gson;

import java.net.http.HttpResponse;
import java.util.Scanner;

public class Convertir {

    //metodo para convertir monedas
    public void convertirMoneda(int opcion, Scanner scanner, Moneda moneda) {
        System.out.println("Ingrese el valor que desea convertir:");
        double cantidad = Double.valueOf(scanner.next());

        switch (opcion) {
            case 1 -> System.out.printf(
                    "El valor equivalente es: %.2f CLP", cantidad * moneda.getClp());
            case 2 -> System.out.printf(
                    "El valor equivalente es: %.2f USD", cantidad / moneda.getClp());
            case 3 -> System.out.printf(
                    "El valor equivalente es: %.2f EUR", cantidad * moneda.getEur());
            case 4 -> System.out.printf(
                    "El valor equivalente es: %.2f USD", cantidad / moneda.getEur());
        }
    }

    //metodo para convertir json a objeto java
    public Moneda aObjectJava(HttpResponse<String> response) {

        Gson gson = new Gson();
        Data data = gson.fromJson(response.body(), Data.class);
        return data.conversion_rates();

    }
}
