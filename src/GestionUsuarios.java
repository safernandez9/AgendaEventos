import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class GestionUsuarios {


    /**
     * Lista los usuarios de la base de datos
     */
    public static void listarUsuarios() {
        Connection conexion = ConexionBase.conectar();

        Statement sentencia;
        try {
            sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT * FROM usuarios");

            while (resultado.next()) {
                // Procesa los datos
                int id = resultado.getInt("id");
                String user_name = resultado.getString("user_name");
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String primerApellido = resultado.getString("primerApellido");
                String segundoApellido = resultado.getString("segundoApellido");
                Timestamp createdAt = resultado.getTimestamp("created_at");

                // Procesa los datos
                System.out.println(
                        "ID: " + id + ", user_name: " + user_name + ", dni: " + dni + ", Nombre: " + nombre
                                + ", Apellidos: " + primerApellido + " " + segundoApellido + " Creado: " + createdAt);
            }

            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Comprueba si un usuario y contraseña son correctos
     * 
     * @param user_name Usuario
     * @param password  Contraseña
     * @return true si el usuario y contraseña son correctos
     */
    public static boolean loginUsuario(String user_name, String password) {
        boolean loginOk = false;
        Connection conexion = ConexionBase.conectar();

        Statement sentencia;
        try {
            sentencia = conexion.createStatement();

            ResultSet resultado = sentencia
                    .executeQuery("SELECT * FROM usuarios WHERE user_name LIKE '" + user_name + "'");

            if (resultado.next()) {
                // Si existe el usuario valida la contraseña con BCrypt
                byte[] passwordHashed = resultado.getString("password").getBytes(StandardCharsets.UTF_8);
                BCrypt.Result resultStrict = BCrypt.verifyer(BCrypt.Version.VERSION_2Y).verifyStrict(
                        password.getBytes(StandardCharsets.UTF_8),
                        passwordHashed);
                loginOk = resultStrict.verified;
                loginOk = validarHash2Y(password, resultado.getString("password"));
            }

            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginOk;
    }

    /**
     * Cambia la contraseña de un usuario
     * 
     * @param user_name Usuario
     * @param password  Nueva contraseña
     * @return true si se cambió la contraseña
     */
    public static boolean cambiarPassword(String user_name, String password) {
        boolean cambiarPassword = false;
        Connection conexion = ConexionBase.conectar();

        Statement sentencia;
        try {
            sentencia = conexion.createStatement();
            int resultado = sentencia.executeUpdate("UPDATE usuarios SET password='" + generarStringHash2Y(password)
                    + "' WHERE user_name LIKE '" + user_name + "'");

            if (resultado == 1) {
                // Si se cambió la contraseña
                cambiarPassword = true;
            }

            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cambiarPassword;
    }

    /*
     * FUNCIONES BCRYPT: generar hash y validar hash
     */
    /**
     * Valida un hash de BCrypt
     * 
     * @param password Contraseña en texto claro
     * @param hash2y   Hash de BCrypt
     * @return true si la contraseña es correcta
     */
    private static boolean validarHash2Y(String password, String hash2y) {
        return BCrypt.verifyer(BCrypt.Version.VERSION_2Y)
                .verifyStrict(password.getBytes(StandardCharsets.UTF_8),
                        hash2y.getBytes(StandardCharsets.UTF_8)).verified;
    }

    /**
     * Genera un hash de BCrypt
     * 
     * @param password Contraseña en texto claro
     * @return Hash de BCrypt
     */
    private static String generarStringHash2Y(String password) {
        char[] bcryptChars = BCrypt.with(BCrypt.Version.VERSION_2Y).hashToChar(13, password.toCharArray());
        return String.valueOf(bcryptChars);
    }

    /**
     * Inicia sesión de usuario
     * Solicita credenciales de inicio de sesión, y si son correctas devuelve el
     * boolean
     * true
     * 
     * @return falso o verdadero según se haya podido o no iniciar sesión
     */
    public static boolean iniciarSesion() {
        System.out.println("LOGIN DE USUARIO");
        System.out.print("Usuario: ");
        String usuario = System.console().readLine();
        System.out.print("Contraseña: ");
        String password = new String(System.console().readPassword());
        if (loginUsuario(usuario, password)) {
            return true;
        } else {
            System.out.println("Usuario o contraseña incorrectos");
            return false;
        }

    }

    /**
     * Crea un nuevo usuario
     * Solicita credenciales de nuevo usuario, y si se crea correctamente devuelve
     * true
     * 
     * @return true si se creó el usuario
     */
    public static boolean crearUsuario() {

        String password;
        String passwordValidate;

        Connection conexion = ConexionBase.conectar();
        Statement sentencia;

        Usuario user = new Usuario();

        try {
            sentencia = conexion.createStatement();
            System.out.print("Usuario: ");
            user.setNombreUsuario(System.console().readLine());

            do {

                System.out.print("Contraseña: ");
                password = String.valueOf(System.console().readPassword());

                System.out.print("Vuelva a introducir la contraseña: ");
                passwordValidate = new String(System.console().readPassword());

                if (passwordValidate.compareTo(password) != 0) {
                    System.out.println("Las contraseñas no coinciden");
                }

            } while (passwordValidate.compareTo(password) != 0);

            user.setPassword(password);

            System.out.print("DNI: ");
            user.setDni(System.console().readLine());

            System.out.print("Nombre: ");
            user.setNombre(System.console().readLine());

            System.out.print("Primer Apellido: ");
            user.setPrimerApellido(System.console().readLine());

            System.out.print("Segundo Apellido: ");
            user.setSegundoApellido(System.console().readLine());

            System.out.print("Fecha de Nacimiento (XX/XX/XXXX): ");
            user.setFechaNacimiento(System.console().readLine());

            String sql = "INSERT INTO usuarios (user_name, password, dni, nombre, primerApellido, segundoApellido, fechaNacimiento) VALUES ('"
                    + user.getNombreUsuario() + "', '"
                    + generarStringHash2Y(user.getPassword()) + "', '" + user.getDni() + "',  '" + user.getNombre()
                    + "',  '" + user.getPrimerApellido()
                    + "',  '" + user.getSegundoApellido() + "',  '" + user.getFechaNacimiento() + "')";

            int resultado = sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
            return resultado == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al crear el usuario");
            return false;
        }
    }

}
