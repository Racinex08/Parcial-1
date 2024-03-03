import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar producto");
            System.out.println("2. Vender producto");
            System.out.println("3. Mostrar inventario");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    inventario.agregarProducto();
                    break;
                case 2:
                    inventario.venderProducto();
                    break;
                case 3:
                    inventario.mostrarInventario();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}

class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }
}

class Inventario {
    private Map<String, Producto> productos;

    public Inventario() {
        productos = new HashMap<>();
    }

    public void agregarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese la cantidad inicial:");
        int cantidad = scanner.nextInt();
        System.out.println("Ingrese el precio por unidad:");
        double precio = scanner.nextDouble();

        Producto producto = new Producto(nombre, cantidad, precio);
        productos.put(nombre, producto);
    }

    public void venderProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del producto a vender:");
        String nombre = scanner.nextLine();

        if (!productos.containsKey(nombre)) {
            System.out.println("Producto no encontrado.");
            return;
        }

        Producto producto = productos.get(nombre);

        if (producto.getCantidad() == 0) {
            System.out.println("No hay stock disponible para este producto.");
            return;
        }

        producto.setCantidad(producto.getCantidad() - 1);
        System.out.println("Venta realizada con éxito.");
    }

    public void mostrarInventario() {
        System.out.println("Inventario actual:");
        for (Producto producto : productos.values()) {
            System.out.println("Nombre: " + producto.getNombre() + ", Cantidad: " + producto.getCantidad() +
                    ", Precio: $" + producto.getPrecio());
        }
    }
}