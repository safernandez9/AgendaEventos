import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConexionBase {

    // Datos de conexión a la base de datos (localhost)
    static final String HOST = "localhost";
    static final String DATABASE = "AgendaEventos";
    static final String USER = "root";
    static final String PASSWORD = "";
    static final String PORT = "3306";

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