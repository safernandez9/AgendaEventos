
public class Menus {

    /**
     * Muestra el menú inicial del programa principal con sus opciones
     */
    public static void programaPrincipal(Usuario user) {
        System.out.println("\n****************");
        System.out.println("BIENVENIDO " + user.getNombre());
        System.out.println("****************\n");

        String opcion;
        do {
            System.out.println();
            System.out.println("1. USUARIOS");
            System.out.println("2. EVENTOS");
            System.out.println("3. MI CUENTA");
            System.out.println("0. ATRÁS");

            System.out.println();
            System.out.print("Opción: ");
            opcion = System.console().readLine();
            System.out.println();

            switch (opcion) {
                case "1":
                    menuUsuarios(user);
                    break;
                case "2":
                    menuEventos(user);
                    break;
                case "3":
                    menuCuenta(user);
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
    public static void menuUsuarios(Usuario user) {
        System.out.println("\n****************");
        System.out.println("MENÚ USUARIOS");
        System.out.println("****************\n");

        String opcion;
        do {
            System.out.println();
            System.out.println("1. LISTAR USUARIOS");
            System.out.println("0. ATRÁS");

            System.out.println();
            System.out.print("Opción: ");
            opcion = System.console().readLine();
            System.out.println();

            switch (opcion) {
                case "1":
                    GestionUsuarios.listarUsuarios();
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
    public static void menuEventos(Usuario user) {
        System.out.println("\n****************");
        System.out.println("MENÚ EVENTOS");
        System.out.println("****************\n");

        String opcion;
        do {
            System.out.println();
            System.out.println("1. CREAR EVENTO:");
            System.out.println("2. LISTAR EVENTOS");
            System.out.println("0. ATRÁS");

            System.out.println();
            System.out.print("Opción: ");
            opcion = System.console().readLine();
            System.out.println();

            switch (opcion) {
                case "1":
                    GestionEventos.crearEvento(user.getNombreUsuario());
                    break;
                case "2":
                    GestionEventos.listarEventos();
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
    public static void menuCuenta(Usuario user) {
        System.out.println("\n****************");
        System.out.println("CUENTA DE " + user.getNombre());
        System.out.println("****************\n");

        String opcion;
        do {
            System.out.println();
            System.out.println("1. CAMBIAR CONTRASEÑA");
            System.out.println("2. VER MIS DATOS");
            System.out.println("0. ATRÁS");

            System.out.println();
            System.out.print("Opción: ");
            opcion = System.console().readLine();
            System.out.println();

            switch (opcion) {
                case "1":
                    GestionUsuarios.cambiarContraseña(user);
                    break;
                case "2":
                    GestionUsuarios.listarUsuarioActivo(user.getNombre());
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
