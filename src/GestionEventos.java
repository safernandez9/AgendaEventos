import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

public class GestionEventos {

    /**
     * Lista los eventos de la base de datos
     */
    public static void listarEventos() {
        Connection conexion = ConexionBase.conectar();

        Statement sentencia;
        try {
            sentencia = conexion.createStatement();

            ResultSet resultado = sentencia.executeQuery("SELECT * FROM eventos");

            while (resultado.next()) {
                // Procesa los datos
                int id = resultado.getInt("idEvento");
                String nombreEvento = resultado.getString("nombre");
                String fechaInicio = resultado.getString("fechaInicio");
                String fechaFin = resultado.getString("fechaFin");
                String creador = resultado.getString("creador");
                String ubicacion = resultado.getString("ubicación");
                String descripcion = resultado.getString("descripción");
                Timestamp createdAt = resultado.getTimestamp("created_at");

                // Procesa los datos
                System.out.println(
                        "ID: " + id + ", Nombre: " + nombreEvento + ", Fecha de inicio: " + fechaInicio
                                + ", Fecha de fin: "
                                + fechaFin + ", Creador: " + creador + ", Ubicación: " + ubicacion + ", Descripción: " + descripcion
                                + ", Creado: " + createdAt);
            }

            resultado.close();
            sentencia.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Crea un nuevo evento
     * Si se crea correctamente devuelve true
     * 
     * @return true si se creó el evento
     */
    public static boolean crearEvento(String creador) {

        Connection conexion = ConexionBase.conectar();
        Statement sentencia;
        try {
            sentencia = conexion.createStatement();

            System.out.print("Nombre del evento: ");
            String nombreEvento = System.console().readLine();

            System.out.print("Fecha y hora de inicio (XX/XX/XXXX XX:XX): ");
            String fechaInicio = System.console().readLine();

            System.out.print("(OPCIONAL) Fecha y hora de fin (XX/XX/XXXX XX:XX): ");
            String fechaFin = System.console().readLine();

            System.out.print("Ubicación: ");
            String ubicacion = System.console().readLine();

            System.out.print("(OPCIONAL) Descripción: ");
            String descripcion = System.console().readLine();

            String sql = "INSERT INTO eventos (nombre, fechaInicio, fechaFin, creador, ubicación, descripción) VALUES ('"
                    + nombreEvento + "', '"
                    + fechaInicio + "',  '" + fechaFin + "', '" + creador + "', '" + ubicacion
                    + "',  '" + descripcion + "')";

            int resultado = sentencia.executeUpdate(sql);
            sentencia.close();
            conexion.close();
            return resultado == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al crear el evento");
            return false;
        }
    }

}
