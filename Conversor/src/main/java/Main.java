import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        String url = "https://v6.exchangerate-api.com/v6/3f53e2483b534f1029da6437/latest/USD";

        //Obtener los datos de la api segun la url
        ObtenerDatos obtenerDatos = new ObtenerDatos();

        //Convertir data json a java object y obtener datos de monedas
        Convertir convertir = new Convertir();
        Moneda moneda = convertir.aObjectJava(obtenerDatos.ObtenerDatosApi(url));

        //MENU Y CALCULO
        Menu.lanzarMenu();

        System.out.println(moneda.getClp());



    }
}
