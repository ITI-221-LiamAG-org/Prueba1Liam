/**
 * Clase abstracta que representa un producto del hogar.
 * Es la clase padre de alimentos y productos de limpieza.
 *
 * Incluye historial de precios como estructura de datos tipo vector.
 */
public abstract class Producto {

    // Atributos
    protected int codigo;
    protected String nombre;
    protected double cantidad;
    protected String unidadMedida;
    protected int tiempoPromedioConsumo;

    // Vector de composición (historial de precios)
    protected HistorialPrecio[] historialPrecios;


    public Producto() {
    }


    public Producto(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }


    public Producto(int codigo, String nombre, double cantidad,
                    String unidadMedida, int tiempoPromedioConsumo,
                    HistorialPrecio[] historialPrecios) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.tiempoPromedioConsumo = tiempoPromedioConsumo;
        this.historialPrecios = historialPrecios;
    }

    // Getters y setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getTiempoPromedioConsumo() {
        return tiempoPromedioConsumo;
    }

    public void setTiempoPromedioConsumo(int tiempoPromedioConsumo) {
        this.tiempoPromedioConsumo = tiempoPromedioConsumo;
    }

    public HistorialPrecio[] getHistorialPrecios() {
        return historialPrecios;
    }

    public void setHistorialPrecios(HistorialPrecio[] historialPrecios) {
        this.historialPrecios = historialPrecios;
    }

    /**
     * Cada tipo de producto lo implementará diferente.
     */
    public abstract void mostrarInfo();
}