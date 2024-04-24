public class Menu {

    public static void lanzarMenu(){

        String menu = """
               \s
                $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
                Bienvenid@s al Conversor de Moneda
               \s
                1) Dólar (USD) =>> Peso Chileno (CLP)
                2) Peso Chileno (CLP) =>> Dólar (USD)
                3) Dólar (USD) =>> Euro (EUR)
                4) Euro (EUR) =>> Dólar (USD)
                5) Salir
               \s
                Elija una opción válida
                ------------------------------------
               \s""";
        System.out.println(menu);
    }
}
