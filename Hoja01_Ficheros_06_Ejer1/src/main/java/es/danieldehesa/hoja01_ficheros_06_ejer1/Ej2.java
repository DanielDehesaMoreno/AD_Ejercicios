package es.danieldehesa.hoja01_ficheros_06_ejer1;

import static es.danieldehesa.hoja01_ficheros_06_ejer1.Ej1.listarPorAlias;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ej2
{

    private static Scanner teclado = new Scanner(System.in);
    private static Path fichero;

    public static void main(String[] args)
    {
        boolean salir = false;
        int opcion;
        fichero = Paths.get("futbolistas.csv");
        do
        {
            System.out.println("--- MENU ---");
            System.out.println("1. Listar futbolistas");
            System.out.println("2. Añadir futbolista");
            System.out.println("3. Listar futbolista por puesto");
            System.out.println("4. Obtener el futbolista mas alto");
            System.out.println("5. Modificar puesto de futbolista");
            System.out.println("6. Eliminar futbolista");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();
            switch (opcion)
            {
                case 0:
                    System.out.println("CHAO; PESCAO");
                    salir = true;
                    break;
                case 1:
                    listarFutbolistas();
                    break;
                case 2:
                    aniadirFutbolista();
                    break;

                case 3:
                    listarPorPuesto();
                    break;
                case 4:
                    jugadorMasAlto();
                    break;
                case 5:
                    modificarPuesto();
                    break;
                case 6:
                    eliminarFutbolista();
                    break;
                default:

                    System.out.println("Solo numeros entre 0 y 6");
            }
        } while (!salir);
    }

    private static void listarFutbolistas()
    {
        getFutbolistas().stream().forEach(System.out::println);
    }

    private static List<Futbolista> getFutbolistas()
    {
        
        try
        {
            List<Futbolista> futbolistas = Files.lines(fichero)
                    .map(l -> l.split(","))
                    .map(d -> new Futbolista(Integer.parseInt(d[0]),
                    d[1], d[2], d[3],
                    d[4].toUpperCase(),
                    Float.parseFloat(d[5]),
                    LocalDate.parse(d[6]), d[7])
                    ).toList();
            return futbolistas;

        } catch (IOException e)
        {
            System.out.println(e.toString());
        }
        return new ArrayList();
    }

    private static void aniadirFutbolista()
    {
        teclado.nextLine();
        BufferedWriter bw = null;
        int idJugador, anio, mes, dia;
        System.out.println("Introduce la id del jugador: ");
        idJugador = teclado.nextInt();
        System.out.println("Introduce el nombre del jugador: ");
        teclado.nextLine();
        String nombre = teclado.nextLine();
        System.out.println("Introduce los apellidos del jugador: ");
        String apellidos = teclado.nextLine();
        System.out.println("Introduce el alias del jugador: ");
        String alias = teclado.nextLine();
        System.out.println("Introduce el puesto del jugador: ");
        String puesto = teclado.nextLine();
        System.out.println("Introduce su altura: ");
        float altura = teclado.nextFloat();
        System.out.println("--- Introduciremos su fecha de nacimiento campo por campo ---");
        System.out.println("Año: ");
        anio = teclado.nextInt();
        System.out.println("Mes: ");
        mes = teclado.nextInt();
        System.out.println("Dia: ");
        dia = teclado.nextInt();
        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        String codEquipo = fichero.getFileName().toString().toUpperCase();
        Futbolista f = new Futbolista(idJugador, nombre, apellidos, alias, puesto, altura, fechaNacimiento, codEquipo);
        try
        {
            bw = Files.newBufferedWriter(fichero, StandardOpenOption.APPEND);
            bw.write(f.toString());
            bw.newLine();
        } catch (IOException e)
        {
            System.out.println(e.toString());
        } finally
        {
            try
            {
                bw.close();
            } catch (IOException e)
            {
                System.out.println(e.toString());
            }
        }
    }

    public static void listarPorPuesto()
    {
        System.out.println("¿Porque puesto quieres buscar?");
        getFutbolistas()
                .stream()
                .filter(f -> f.getPuesto().equals(teclado.nextLine()))
                .forEach(System.out::println);
    }

    public static void jugadorMasAlto()
    {
        getFutbolistas()
                .stream()
                .sorted(Comparator.comparing(Futbolista::getAltura))
                .limit(1)
                .forEach(System.out::println);
    }

    public static void modificarPuesto()
    {
        List<Futbolista> futbolistas = getFutbolistas();
        System.out.println("Inserta la ID del futbolista a modificar");
        Optional<Futbolista> aux = futbolistas
                .stream()
                .filter(f -> f.getIdJugador() == (teclado.nextInt()))
                .findFirst();
        if (aux.isPresent())
        {
            System.out.println("A que puesto a cambiado: ");
            Futbolista f = aux.get();
            f.setPuesto(teclado.nextLine());
        }
        try
        {
            Files.write(fichero, futbolistas.stream().map(Futbolista::toString).toList());
        } catch (IOException e)
        {
            System.out.println(e.toString());
        }

    }
    
    public static void eliminarFutbolista(){
        List<Futbolista> futbolistas = new ArrayList(getFutbolistas());
        System.out.println("Introduce el ID del jugador a borrar: ");
        int id=teclado.nextInt();
        futbolistas.removeIf(f -> f.getIdJugador() == (id));
        try
        {
            Files.write(fichero, futbolistas.stream().map(Futbolista::toString).toList());
        } catch (IOException e)
        {
            System.out.println(e.toString());
        }
    }

}
