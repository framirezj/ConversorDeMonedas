import com.google.gson.Gson;

import java.net.http.HttpResponse;
import java.util.Scanner;

public class Convertir {

    //metodo para convertir monedas segun la cantidad ingresada
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
            default -> System.out.println("Opción invalida");
        }
    }

    //metodo para convertir json a objeto java
    public Moneda aObjectJava(HttpResponse<String> response) {

        //Instancia de la Biblioteca GSON
        Gson gson = new Gson();
        //convierto a JSON segun la estructura de la clase Data
        Data data = gson.fromJson(response.body(), Data.class);
        //devuelvo objeto que contiene los valores de las divisas, segun las que especifique en la clase Moneda
        return data.conversion_rates();

    }
}

