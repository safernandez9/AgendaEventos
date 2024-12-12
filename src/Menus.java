
public class Menus {

    /**
     * Muestra el menú inicial del programa principal con sus opciones
     */
    public static void programaPrincipal() {
        System.out.println("\n****************");
        System.out.println("BIENVENIDO");
        System.out.println("****************\n");

        String opcion;
        do {
            System.out.println();
            System.out.println("1. USUARIOS:");
            System.out.println("2. EVENTOS");
            System.out.println("3. MI CUENTA");
            System.out.println("0. ATRÁS");

            System.out.println();
            System.out.print("Opción: ");
            opcion = System.console().readLine();
            System.out.println();

            switch (opcion) {
                case "1":
                    menuUsuarios();
                    break;
                case "2":
                    menuEventos();
                    break;
                case "3":
                    menuCuenta();
                    break;
                case "0":
                    System.out.println("Volviendo atrás...\n");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!opcion.equals("0"));

    }

    
    /**
     * Muetra el menú y las opciones relacionadas con la gestión de los eventos
     */
    public static void menuEventos() {
        System.out.println("\n****************");
        System.out.println("BIENVENIDO");
        System.out.println("****************\n");

        String opcion;
        do {
            System.out.println();
            System.out.println("1. LISTADO DE EVENTOS:");
            System.out.println("2. EVENTOS");
            System.out.println("3. MI CUENTA");
            System.out.println("0. ATRÁS");

            System.out.println();
            System.out.print("Opción: ");
            opcion = System.console().readLine();
            System.out.println();

            switch (opcion) {
                case "1":
                    menuUsuarios();
                    break;
                case "2":
                    menuEventos();
                    break;
                case 3:
                menuCuenta();
                break;
                case "0":
                    System.out.println("Volviendo atrás...\n");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!opcion.equals("0"));

    }


    /**
     * Muetra el menú y las opciones relacionadas con la gestión de los usuarios
     */
    public static void menuUsuarios() {
        System.out.println("\n****************");
        System.out.println("BIENVENIDO");
        System.out.println("****************\n");

        String opcion;
        do {
            System.out.println();
            System.out.println("1. USUARIOS:");
            System.out.println("2. EVENTOS");
            System.out.println("3. MI CUENTA");
            System.out.println("0. ATRÁS");

            System.out.println();
            System.out.print("Opción: ");
            opcion = System.console().readLine();
            System.out.println();

            switch (opcion) {
                case "1":
                    menuUsuarios();
                    break;
                case "2":
                    System.out.println(GestionEventos.crearEvento() ? "Evento creado" : "Error al crear el Evento");
                    break;
                case "0":
                    System.out.println("Volviendo atrás...\n");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!opcion.equals("0"));

    }

    /**
     * Muetra el menú y las opciones relacionadas con la gestión de la cuenta
     * del usuario en línea
     */
    public static void menuCuenta() {
        System.out.println("\n****************");
        System.out.println("BIENVENIDO");
        System.out.println("****************\n");

        String opcion;
        do {
            System.out.println();
            System.out.println("1. USUARIOS:");
            System.out.println("2. EVENTOS");
            System.out.println("3. MI CUENTA");
            System.out.println("0. ATRÁS");

            System.out.println();
            System.out.print("Opción: ");
            opcion = System.console().readLine();
            System.out.println();

            switch (opcion) {
                case "1":
                    menuUsuarios();
                    break;
                case "2":
                    System.out.println(GestionEventos.crearEvento() ? "Evento creado" : "Error al crear el Evento");
                    break;
                case "0":
                    System.out.println("Volviendo atrás...\n");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!opcion.equals("0"));

    }
}
