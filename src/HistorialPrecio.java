/**
 * Clase que almacena el historial de precios de un producto.
 * Permite conocer cuánto costó un producto en una fecha determinada.
 *
 * Autor: Liam
 */
public class HistorialPrecio {

    // Atributos
    private String fecha;
    private double precio;

    /**
     * Constructor por defecto.
     */
    public HistorialPrecio() {
    }

    /**
     *
     * @param fecha Fecha del registro.
     */
    public HistorialPrecio(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Constructor completo.
     *
     * @param fecha Fecha del registro.
     * @param precio Precio registrado.
     */
    public HistorialPrecio(String fecha, double precio) {
        this.fecha = fecha;
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}