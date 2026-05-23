import java.util.Scanner;
 
public class Ejercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Ingrese la cantidad de espacios del parqueadero: ");
        int cantidadEspacios = sc.nextInt();
        sc.nextLine();

        int[] numeroEspacio = new int[cantidadEspacios];
        String[] tipoPermitido = new String[cantidadEspacios];
        String[] estadoEspacio = new String[cantidadEspacios];

        for (int i = 0; i < cantidadEspacios; i++) {

            System.out.println("\nEspacio #" + (i + 1));

            System.out.print("Número del espacio: ");
            numeroEspacio[i] = sc.nextInt();
            sc.nextLine();

            System.out.print("Tipo permitido (carro/moto): ");
            tipoPermitido[i] = sc.nextLine();

            estadoEspacio[i] = "disponible";
        }

        System.out.print("\nIngrese la cantidad de vehículos que desean ingresar: ");
        int cantidadVehiculos = sc.nextInt();
        sc.nextLine();


        int carrosAsignados = 0;
        int motosAsignadas = 0;
        int noIngresaron = 0;

        for (int i = 0; i < cantidadVehiculos; i++) {

            System.out.println("\nVehículo #" + (i + 1));

            System.out.print("Placa: ");
            String placa = sc.nextLine();

            System.out.print("Tipo de vehículo (carro/moto): ");
            String tipoVehiculo = sc.nextLine();

            System.out.print("Nombre del propietario: ");
            String propietario = sc.nextLine();

            boolean asignado = false;


            for (int j = 0; j < cantidadEspacios; j++) {

                if (estadoEspacio[j].equals("disponible")
                        && tipoPermitido[j].equalsIgnoreCase(tipoVehiculo)) {

                    estadoEspacio[j] = "ocupado";
                    asignado = true;

                    System.out.println("Vehículo asignado al espacio: "
                            + numeroEspacio[j]);

                    if (tipoVehiculo.equalsIgnoreCase("carro")) {
                        carrosAsignados++;
                    } else if (tipoVehiculo.equalsIgnoreCase("moto")) {
                        motosAsignadas++;
                    }

                    break;
                }
            }

            if (!asignado) {
                System.out.println("No se encontró espacio disponible para el vehículo.");
                noIngresaron++;
            }
        }


        System.out.println("\n===== ESTADO FINAL DEL PARQUEADERO =====");

        int espaciosDisponibles = 0;

        for (int i = 0; i < cantidadEspacios; i++) {

            System.out.println("Espacio: " + numeroEspacio[i]
                    + " | Tipo: " + tipoPermitido[i]
                    + " | Estado: " + estadoEspacio[i]);

            if (estadoEspacio[i].equals("disponible")) {
                espaciosDisponibles++;
            }
        }

        System.out.println("\n===== RESUMEN =====");
        System.out.println("Espacios disponibles: " + espaciosDisponibles);
        System.out.println("Carros asignados correctamente: " + carrosAsignados);
        System.out.println("Motos asignadas correctamente: " + motosAsignadas);
        System.out.println("Vehículos que no pudieron ingresar: " + noIngresaron);

        sc.close();
    }
}
```
