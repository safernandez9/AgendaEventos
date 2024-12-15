import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConexionBase {

    /*
     * // Datos de conexión a la base de datos de Desarrollo (localhost)
     * static final String HOST = "localhost";
     * static final String DATABASE = "AgendaEventos";
     * static final String USER = "root";
     * static final String PASSWORD = "";
     * static final String PORT = "3306";
     */

    // Datos de conexión a la base de datos (localhost)
    static final String HOST = "oj8g6.h.filess.io";
    static final String DATABASE = "AgendaEventos_personmilk";
    static final String USER = "AgendaEventos_personmilk";
    static final String PASSWORD = "57535228ef2e366daa35a67b22f1ca7c90e0907d";
    static final String PORT = "3305";

   /**
     * Conecta con la base de datos
     * 
     * @return Conexión con la base de datos
     */
    public static Connection conectar() {
        Connection con = null;

        String url = "jdbc:mysql://" + ConexionBase.HOST + ":" + ConexionBase.PORT + "/" + ConexionBase.DATABASE;

        try {
            con = DriverManager.getConnection(url, ConexionBase.USER, ConexionBase.PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error al conectar con la BD.");
        }

        return con;
    }
}