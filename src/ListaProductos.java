import java.util.ArrayList;

public class ListaProductos {

    private NodoProducto cabeza;

    public ListaProductos() {
        this.cabeza = null;
    }

    // INSERTAR
    public void insertar(Producto producto) {
        NodoProducto nuevo = new NodoProducto(producto);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoProducto actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    // BUSCAR POR CÓDIGO (UNO SOLO)
    public Producto buscarCodigo(int codigo) {
        NodoProducto actual = cabeza;

        while (actual != null) {
            if (actual.dato.getCodigo() == codigo) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    // BUSCAR POR 2 CRITERIOS
    public ArrayList<Producto> buscarPorCriterios(String unidad, String nombre) {

        ArrayList<Producto> lista = new ArrayList<>();
        NodoProducto actual = cabeza;

        while (actual != null) {

            if (actual.dato.getUnidadMedida().equalsIgnoreCase(unidad)
                    && actual.dato.getNombre().equalsIgnoreCase(nombre)) {

                lista.add(actual.dato);
            }

            actual = actual.siguiente;
        }

        return lista;
    }

    // MOSTRAR TODO
    public void mostrar() {
        NodoProducto actual = cabeza;

        while (actual != null) {
            actual.dato.mostrarInfo();
            System.out.println("-------------------");
            actual = actual.siguiente;
        }
    }
}
