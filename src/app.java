import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class app {

    // Lista para guardar multiples personas (ArrayList)
    static ArrayList<Persona> listaPersonas = new ArrayList<>();
    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        // Estructura do-while que mostro el ingeniero en la foto
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Registrar Persona");
            System.out.println("2. Mostrar Personas");
            System.out.println("3. Buscar Persona");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(entrada.nextLine());
            } catch (Exception e) {
                opcion = 0;
            }

            // Mismo switch que hicieron el sabado en la clase
            switch (opcion) {
                case 1:
                    registrarPersona();
                    break;

                case 2:
                    mostrarPersona();
                    break;

                case 3:
                    buscarPersona();
                    break;

                case 4:
                    System.out.println("Presione una tecla para salir...");
                    break;

                default:
                    System.out.println("Ingrese un numero de opcion valido");
            }

        } while (opcion != 4);
    }

    // Opcion 1: Registrar una nueva persona usando tus Setters
    public static void registrarPersona() {
        System.out.println("\n--- REGISTRO DE PERSONA ---");
        Persona p = new Persona();

        System.out.print("Ingrese el nombre completo: ");
        p.setNombreC(entrada.nextLine());

        System.out.print("Anio de nacimiento (ej. 2002): ");
        int anio = Integer.parseInt(entrada.nextLine());
        System.out.print("Mes de nacimiento (1-12): ");
        int mes = Integer.parseInt(entrada.nextLine());
        System.out.print("Dia de nacimiento (1-31): ");
        int dia = Integer.parseInt(entrada.nextLine());
        p.setFechaN(LocalDate.of(anio, mes, dia));

        System.out.print("Ingrese el peso en kg (ej. 70.5): ");
        p.setPeso(Double.parseDouble(entrada.nextLine()));

        System.out.print("Ingrese la altura en metros (ej. 1.70): ");
        p.setAltura(Double.parseDouble(entrada.nextLine()));

        System.out.print("Ingrese la direccion: ");
        p.setDireccion(entrada.nextLine());

        System.out.print("Ingrese el telefono: ");
        p.setTelefono(entrada.nextLine());

        System.out.print("Ingrese el correo electronico: ");
        p.setCorreo(entrada.nextLine());

        // Validamos si es mayor de edad con tu metodo
        if (p.esMayorEdad()) {
            listaPersonas.add(p);
            System.out.println("\n>> Persona registrada exitosamente!");
        } else {
            System.out.println("\n>> Error: La persona debe ser mayor de edad (>= 18 anios) para registrarse.");
        }
    }

    // Opcion 2: Mostrar todas las personas registradas
    public static void mostrarPersona() {
        System.out.println("\n--- LISTA DE PERSONAS REGISTRADAS ---");
        if (listaPersonas.isEmpty()) {
            System.out.println("No hay personas registradas aun.");
        } else {
            for (Persona p : listaPersonas) {
                p.mostrarDatos();
                System.out.println("-----------------------------------");
            }
        }
    }

    // Opcion 3: Buscar una persona por nombre
    public static void buscarPersona() {
        System.out.println("\n--- BUSCAR PERSONA ---");
        System.out.print("Ingrese el nombre a buscar: ");
        String busqueda = entrada.nextLine().toLowerCase();
        boolean encontrado = false;

        for (Persona p : listaPersonas) {
            if (p.getNombreC().toLowerCase().contains(busqueda)) {
                p.mostrarDatos();
                System.out.println("-----------------------------------");
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro ninguna persona con ese nombre.");
        }
    }
}