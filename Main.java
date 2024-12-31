import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ConsultaApiMoneda cambiar = new ConsultaApiMoneda();

        String menuOpciones = """
                +----------------------------------------------+
                Sea bienvenido(a) al Conversor de Divisas =] \n
                Escribe solo las iniciales de las divisas*
                1) Dólar =>>           [USD]
                2) Peso Argentino =>>  [ARS]
                3) Real Brasileño =>>  [BRL]
                4) Peso Colombiano =>> [COP] 
                5) Escribe Salir para terminar
                Elija una opción valida:
                +----------------------------------------------+
                """;
        while (true) {
            System.out.println(menuOpciones);
            try {
                System.out.println("Ingresa la moneda base (UDS)");
                var base_code = in.nextLine();
                System.out.println("Ingresa la moneda destino (COP)");
                var target_code = in.nextLine();

                System.out.println("Ingresa el valor cambiar:");
                var valor = Double.valueOf(in.nextLine());

                Moneda moneda = cambiar.convertirDivisa(base_code, target_code, valor);
                System.out.println(moneda);
                System.out.println(moneda.base_code() + moneda.target_code() + moneda.conversion_rate());

                System.out.println("Dígita 1 para continuar o escribe salir para terminar");
                if (in.nextLine().equalsIgnoreCase("salir")) {
                    break;
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Finished Program...");
    }
}
