public class LibroImpreso extends Libro {

    private double peso; // en gramos
    private int numeroEjemplares;

    public LibroImpreso(String titulo, String autor, double precio, int cantidad, double peso, int numeroEjemplares) {
        super(titulo, autor, precio, cantidad);
        this.peso = peso;
        this.numeroEjemplares = numeroEjemplares;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public void prestar(int cantidad) {
        if (cantidad > getNumeroEjemplares()) {
            System.out.println("No se pueden prestar más libros de los que hay disponibles.");
        } else if (cantidad <= 0) {
            System.out.println("Cantidad invalida para el prestamo.");
        } else {
            numeroEjemplares -= cantidad;
            System.out.println("Se prestaron " + cantidad + " libro(s) correctamente.");
        }
    }

    public void devolver(int cantidad) {
        if (cantidad > 2) {
            System.out.println("No se pueden devolver mas de dos libros a la vez");
        } else {
            numeroEjemplares += cantidad;
            System.out.println("Libro(s) devuelto(s) correctamente.");
        }
    }

    @Override
    public void mostrarLibro() {
        super.mostrarLibro();
        System.out.println("Peso fisico: " + peso + " gramos");
        System.out.println("Ejemplares en stock: " + numeroEjemplares);
    }
}

