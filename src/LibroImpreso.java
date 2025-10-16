public class LibroImpreso extends Libro {

    private double peso;
    private int numeroEjemplares;

    public LibroImpreso(String codigo, String titulo, String autor, double precio, int cantidad, double peso, int numeroEjemplares) {
        super(codigo, titulo, autor, precio, cantidad);
        this.peso = peso;
        this.numeroEjemplares = numeroEjemplares;
    }

    public void prestar(int cant) {
        if (cant <= 0) {
            System.out.println("Cantidad invalida");
        } else if (cant > numeroEjemplares) {
            System.out.println("No hay suficientes ejemplares");
        } else {
            numeroEjemplares -= cant;
            System.out.println("Se prestaron " + cant + " ejemplares.");
        }
    }

    public void devolver(int cant) {
        if (cant > 2) {
            System.out.println("No se pueden devolver dos libros a la vez");
        } else {
            numeroEjemplares += cant;
            System.out.println("Se devolvieron " + cant + " ejemplares.");
        }
    }

    @Override
    public void mostrarLibro() {
        super.mostrarLibro();
        System.out.println("Peso: " + peso + " g");
        System.out.println("Ejemplares: " + numeroEjemplares);
    }
}