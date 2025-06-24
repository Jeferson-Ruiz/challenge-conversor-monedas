import java.util.Scanner;
import models.Moneda;

public class Principal {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        ConsultarApiMonedas consultarMonedas = new ConsultarApiMonedas();

        String monedaOrigen = "";
        String monedaDestino = "";


        System.out.println("\nBienvenido al sistema conversor de monedas\n");

        while (true) {
            System.out.println("Ingrese la moneda que desea consultar:");

            System.out.println("""
                    1. Dolar USD a Peso Colombia COP
                    2. Peso Colombiano COP a Dolar USD
                    3. Dolar USD a Peso Argentino ARS
                    4. Peso Argentino ARS a Dolar USD
                    5. Dolar USD a Peso Chileno CLP
                    6. Peso Chileno CLP Dolar USD
                    7. Dolar USD a Real Brasileño BRL
                    8. Real Brasileño BRL a Dolar USD
                    9. Otra
                    10. Salir
                    """);
            int opcionUser = scanner.nextInt();

            if (opcionUser == 10) {
                System.out.println("Fin del programa");
                break;
            }

            System.out.println("\nIngrese el monto a convertir:");
            double cantidad = scanner.nextDouble();

            switch (opcionUser) {
                case 1 -> { monedaOrigen = "USD"; monedaDestino = "COP";}
                case 2 -> { monedaOrigen = "COP"; monedaDestino = "USD";}
                case 3 -> { monedaOrigen = "USD"; monedaDestino = "ARS";}
                case 4 -> { monedaOrigen = "ARS"; monedaDestino = "USD";}
                case 5 -> { monedaOrigen = "USD"; monedaDestino = "CLP";}
                case 6 -> { monedaOrigen = "CLP"; monedaDestino = "USD";}
                case 7 -> { monedaOrigen = "USD"; monedaDestino = "BRL";}
                case 8 -> { monedaOrigen = "BRL"; monedaDestino = "USD";}

                case 9 -> { monedaOrigen = "USD"; monedaDestino = "COP";
                    scanner.nextLine();

                    System.out.println("Ingrese la moneda de origen \"Utilizar Codigo ISO\"");
                    monedaOrigen = scanner.nextLine().toUpperCase();

                    System.out.println("Ingrese la moneda de destino \"Utilizar Codigo ISO\"");
                    monedaDestino = scanner.nextLine().toUpperCase();

                }
            }
                Moneda moneda = consultarMonedas.convertirMoneda(monedaOrigen, monedaDestino,String.valueOf(cantidad));
                System.out.println("\n------------------------------------------------------");
                System.out.println("Resultado: " +cantidad +" "+ monedaOrigen +" equivalen a " + moneda.conversion_result() + " " + moneda.target_code());
                System.out.println("-------------------------------------------------------");
       
        }
        scanner.close();

    }
}
