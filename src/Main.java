import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Libro> listaLibros = new ArrayList<>();
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("------BIBLIOTECA------");
            System.out.println("1. Agregar Libro Digital");
            System.out.println("2. Agregar Libro Impreso");
            System.out.println("3. Buscar libro por título");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Título: ");
                    String tituloD = sc.nextLine();
                    System.out.print("Autor: ");
                    String autorD = sc.nextLine();
                    System.out.print("Precio: ");
                    double precioD = sc.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidadD = sc.nextInt();
                    System.out.print("Peso del archivo (MB): ");
                    double pesoArchivo = sc.nextDouble();
                    boolean disponible = true;

                    LibroDigital ld = new LibroDigital(tituloD, autorD, precioD, cantidadD, pesoArchivo, disponible);
                    listaLibros.add(ld);
                    System.out.println("Libro Digital agregado");
                    break;

                case 2:
                    System.out.print("Título: ");
                    String tituloI = sc.nextLine();
                    System.out.print("Autor: ");
                    String autorI = sc.nextLine();
                    System.out.print("Precio: ");
                    double precioI = sc.nextDouble();
                    System.out.print("Cantidad: ");
                    int cantidadI = sc.nextInt();
                    System.out.print("Peso (gramos): ");
                    double peso = sc.nextDouble();
                    System.out.print("Número de ejemplares: ");
                    int numEjem = sc.nextInt();

                    LibroImpreso li = new LibroImpreso(tituloI, autorI, precioI, cantidadI, peso, numEjem);
                    listaLibros.add(li);
                    System.out.println("Libro Impreso agregado con éxito.");
                    break;

                case 3:
                    System.out.print("Ingrese el título del libro: ");
                    String buscar = sc.nextLine();
                    boolean encontrado = false;

                    for (Libro lib : listaLibros) {
                        if (lib.getTitulo().equalsIgnoreCase(buscar)) {
                            encontrado = true;
                            lib.mostrarLibro();

                            if (lib instanceof LibroDigital) {
                                LibroDigital ldig = (LibroDigital) lib;
                                System.out.println("1. Prestar");
                                System.out.println("2. Devolver");
                                System.out.print("Seleccione: ");
                                int opDig = sc.nextInt();
                                if (opDig == 1) ldig.prestar();
                                else if (opDig == 2) ldig.devolver();

                            } else if (lib instanceof LibroImpreso) {
                                LibroImpreso limp = (LibroImpreso) lib;
                                System.out.println("1. Prestar");
                                System.out.println("2. Devolver");
                                System.out.print("Seleccione: ");
                                int opImp = sc.nextInt();
                                if (opImp == 1) {
                                    System.out.print("Cuántos desea prestar?: ");
                                    int cant = sc.nextInt();
                                    limp.prestar(cant);
                                } else if (opImp == 2) {
                                    System.out.print("Cuántos desea devolver?: ");
                                    int cant = sc.nextInt();
                                    limp.devolver(cant);
                                }
                            }
                        }
                    }
                    if (encontrado) {
                        System.out.println("No se encontró el libro");
                    }
                    break;
                case 4:
                    System.out.println("Gracias");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}