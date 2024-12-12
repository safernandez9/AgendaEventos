
public class AgendaEventos {

    public static void main(String[] args) {

        String opcion;

        System.out.println("\n*******************");
        System.out.println("Bienvenido a AgendaEventos");
        System.out.println("*******************\n");

        do {
            System.out.println();
            System.out.println("1. INICIAR SESIÓN:");
            System.out.println("2. CREACIÓN DE USUARIO");
            System.out.println("0. SALIR");

            System.out.println();
            System.out.print("Opción: ");
            opcion = System.console().readLine();
            System.out.println();

            switch (opcion) {
                case "1":
                    if (GestionUsuarios.iniciarSesion()) {
                        Menus.programaPrincipal();
                    }
                    break;
                case "2":
                    if (GestionUsuarios.crearUsuario()) {
                        System.out.println("Usuario creado");
                        Menus.programaPrincipal();
                    } else {
                        System.out.println("Error al crear usuario");
                    }
                    break;
                case "0":
                    System.out.println("Hasta pronto...\n");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (!opcion.equals("0"));

    }

}
