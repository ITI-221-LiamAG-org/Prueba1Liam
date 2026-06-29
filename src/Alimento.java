public class Alimento extends Producto {

    private String clasificacion;

    public Alimento() {
        super();
    }

    public Alimento(int codigo, String nombre, double cantidad, String unidadMedida,
                    int tiempoPromedioConsumo, HistorialPrecio[] historialPrecios,
                    String clasificacion) {
        super(codigo, nombre, cantidad, unidadMedida, tiempoPromedioConsumo, historialPrecios);
        this.clasificacion = clasificacion;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("=== ALIMENTO ===");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cantidad: " + getCantidad());
        System.out.println("Unidad: " + getUnidadMedida());
        System.out.println("Tiempo consumo: " + getTiempoPromedioConsumo());
        System.out.println("Clasificación: " + clasificacion);

        System.out.println("Historial precios:");
        HistorialPrecio[] h = getHistorialPrecios();

        if (h != null) {
            for (int i = 0; i < h.length; i++) {
                if (h[i] != null) {
                    System.out.println("- " + h[i].getFecha() + " : " + h[i].getPrecio());
                }
            }
        }
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
