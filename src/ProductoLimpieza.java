public class ProductoLimpieza extends Producto {

    private String categoriaLimpieza;

    public ProductoLimpieza() {
        super();
    }

    public ProductoLimpieza(int codigo, String nombre, double cantidad, String unidadMedida,
                            int tiempoPromedioConsumo, HistorialPrecio[] historialPrecios,
                            String categoriaLimpieza) {
        super(codigo, nombre, cantidad, unidadMedida, tiempoPromedioConsumo, historialPrecios);
        this.categoriaLimpieza = categoriaLimpieza;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("=== PRODUCTO LIMPIEZA ===");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cantidad: " + getCantidad());
        System.out.println("Unidad: " + getUnidadMedida());
        System.out.println("Tiempo consumo: " + getTiempoPromedioConsumo());
        System.out.println("Categoría limpieza: " + categoriaLimpieza);

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

    public String getCategoriaLimpieza() {
        return categoriaLimpieza;
    }

    public void setCategoriaLimpieza(String categoriaLimpieza) {
        this.categoriaLimpieza = categoriaLimpieza;
    }
}
