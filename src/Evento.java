//Cambiar Strings por Tipos de Datos mas apropiados
//Añadir y contabilizar asistentes
//Edad Minima

public class Evento {

    private int idEvento;
    private String nombreEvento;
    private String fechaInicioEvento;
    private String fechaFinEvento;
    private String ubicacionEvento;
    private String descripcion;

    public int getIdEvento() {
        return idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getFechaInicioEvento() {
        return fechaInicioEvento;
    }

    public void setFechaInicioEvento(String fechaInicioEvento) {
        this.fechaInicioEvento = fechaInicioEvento;
    }

    public String getFechaFinEvento() {
        return fechaFinEvento;
    }

    public void setFechaFinEvento(String fechaFinEvento) {
        this.fechaFinEvento = fechaFinEvento;
    }

    public String getUbicacionEvento() {
        return ubicacionEvento;
    }

    public void setUbicacionEvento(String ubicacionEvento) {
        this.ubicacionEvento = ubicacionEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
