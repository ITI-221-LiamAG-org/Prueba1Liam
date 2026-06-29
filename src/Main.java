import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ListaProductos lista = new ListaProductos();

        // =========================
        // 1. CARGA INICIAL (5 nodos)
        // =========================

        HistorialPrecio[] h1 = {
                new HistorialPrecio("2024", 1200),
                new HistorialPrecio("2025", 1300)
        };

        HistorialPrecio[] h2 = {
                new HistorialPrecio("2024", 500),
                new HistorialPrecio("2025", 550)
        };

        HistorialPrecio[] h3 = {
                new HistorialPrecio("2024", 2000),
                new HistorialPrecio("2025", 2100)
        };

        lista.insertar(new Alimento(1, "Arroz", 10, "kg", 15, h1, "Granos"));
        lista.insertar(new Alimento(2, "Frijoles", 5, "kg", 20, h2, "Granos"));
        lista.insertar(new ProductoLimpieza(3, "Jabón", 3, "unidades", 10, h3, "Baño"));

        lista.insertar(new Alimento(4, "Atún", 8, "latas", 25, h2, "Enlatados"));
        lista.insertar(new ProductoLimpieza(5, "Detergente", 2, "litros", 12, h1, "Ropa"));

        // =========================
        // 2. MENÚ PRINCIPAL
        // =========================

        int opcion;

        do {
            System.out.println("\n===== SISTEMA DE INVENTARIO =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Buscar por código");
            System.out.println("3. Buscar por 2 criterios");
            System.out.println("4. Mostrar todos");
            System.out.println("5. Ver historial de precios");
            System.out.println("6. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                // =========================
                // 1. REGISTRO MANUAL
                // =========================
                case 1 -> {

                    System.out.println("Tipo (1=Alimento, 2=Limpieza): ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Cantidad: ");
                    double cantidad = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Unidad medida: ");
                    String unidad = sc.nextLine();

                    System.out.print("Tiempo consumo: ");
                    int tiempo = sc.nextInt();
                    sc.nextLine();

                    HistorialPrecio[] historial = new HistorialPrecio[5];

                    historial[0] = new HistorialPrecio("2026", 1000);

                    if (tipo == 1) {
                        System.out.print("Clasificación: ");
                        String clasificacion = sc.nextLine();

                        lista.insertar(new Alimento(
                                codigo, nombre, cantidad, unidad, tiempo, historial, clasificacion
                        ));
                    } else {

                        System.out.print("Categoría limpieza: ");
                        String cat = sc.nextLine();

                        lista.insertar(new ProductoLimpieza(
                                codigo, nombre, cantidad, unidad, tiempo, historial, cat
                        ));
                    }

                    System.out.println("✔ Producto registrado");
                }

                // =========================
                // 2. BUSCAR POR CÓDIGO
                // =========================
                case 2 -> {

                    System.out.print("Ingrese código: ");
                    int codigo = sc.nextInt();

                    Producto p = lista.buscarCodigo(codigo);

                    if (p != null) {
                        p.mostrarInfo();
                    } else {
                        System.out.println("No encontrado");
                    }
                }

                // =========================
                // 3. BUSCAR POR 2 CRITERIOS
                // =========================
                case 3 -> {

                    System.out.print("Unidad medida: ");
                    String unidad = sc.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();

                    var resultados = lista.buscarPorCriterios(unidad, nombre);

                    if (resultados.isEmpty()) {
                        System.out.println("No hay resultados");
                    } else {
                        for (Producto p : resultados) {
                            p.mostrarInfo();
                            System.out.println("----------------");
                        }
                    }
                }

                // =========================
                // 4. MOSTRAR TODO
                // =========================
                case 4 -> lista.mostrar();

                // =========================
                // 5. HISTORIAL PRECIOS
                // =========================
                case 5 -> {

                    System.out.print("Ingrese código producto: ");
                    int codigo = sc.nextInt();

                    Producto p = lista.buscarCodigo(codigo);

                    if (p != null) {

                        HistorialPrecio[] h = p.getHistorialPrecios();

                        System.out.println("Historial de precios:");

                        for (int i = 0; i < h.length; i++) {
                            if (h[i] != null) {
                                System.out.println(h[i].getFecha() + " - " + h[i].getPrecio());
                            }
                        }

                    } else {
                        System.out.println("Producto no encontrado");
                    }
                }

                case 6 -> System.out.println("Saliendo...");

                default -> System.out.println("Opción inválida");
            }

        } while (opcion != 6);

        sc.close();
    }
}
