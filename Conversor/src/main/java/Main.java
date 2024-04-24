import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String url = "https://v6.exchangerate-api.com/v6/3f53e2483b534f1029da6437/latest/USD";

        //Obtener los datos de la api segun la url
        ObtenerDatos obtenerDatos = new ObtenerDatos();

        //Convertir data json a java object y obtener datos de monedas
        Convertir convertir = new Convertir();
        Moneda moneda = convertir.aObjectJava(obtenerDatos.ObtenerDatosApi(url));

        try {
            //Comprobar los datos de la api
            if (moneda == null) {
                throw new NullPointerException();
            }

            //menu y usuario
            int opcion;
            do {

                Menu.lanzarMenu();

                //opción escogida por el usuario
                opcion = Integer.parseInt(scanner.next());

                if (opcion < 5 && opcion > 0) {
                    convertir.convertirMoneda(opcion, scanner, moneda);
                } else if (opcion == 5) {
                    System.out.println("Vuelve pronto!");
                } else {
                    System.out.println("Ingrese una opción válida");
                }

            } while (opcion != 5);

        } catch (NullPointerException e) {
            System.out.println("No se logro obtener los datos de la api");
        } catch (NumberFormatException e) {
            System.out.println("Opción Invalida: " + e.getMessage());
        }

        System.out.println("By: https://www.linkedin.com/in/framirezj2916/");
    }
}
