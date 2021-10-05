package es.danieldehesa.hoja01_ficheros_06_ejer1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 *
 * @author usuario
 */
public class Ej1
{

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        Path fichero = Paths.get("futbolistas.csv");
        do
        {
            System.out.println("--- MENU ---");
            System.out.println("1. Listado de futbolistas");
            System.out.println("2. Listado de futbolistas por equipo");
            System.out.println("3. Busqueda de futbolista");
            System.out.println("4. Creacion de fichero de equipo");
            System.out.println("5. Listado de fichero de equipo");
            System.out.println("5. Mostrar todos los ficheros de equipo");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();
            switch (opcion)
            {
                case 0:
                    System.out.println("CHAO; PESCAO");
                    salir = true;
                    break;
                case 1:
                    listarFutbolistas(fichero);
                    break;
                case 2:
                    listarFutbolistasPorEquipo(fichero, teclado);
                    break;

                case 3:
                    listarPorAlias(fichero, teclado);
                    break;

                case 4:
                    Path equipos = crearFicheroEquipos(fichero, teclado);
                    break;

                case 5:
                    System.out.println("Introduce el nombre del fichero a listar: ");
                    String equ = teclado.nextLine();
                    seleccionarFicheroEquipos(equ);
                    break;

                case 6:
                    listarEquipos();
                    break;
                default:

                    System.out.println("Solo numeros entre 0 y 6");
            }
        } while (!salir);
    }

    private static void listarFutbolistas(Path fichero)
    {
        getFutbolistas(fichero).stream().forEach(System.out::println);
    }

    private static void listarFutbolistasPorEquipo(Path fichero, Scanner teclado)
    {
        System.out.println("¿Porque equipo quieres filtrar?");
        getFutbolistas(fichero)
                .stream()
                .filter(f -> f.getCodEquipo().equals(teclado.nextLine()))
                .forEach(System.out::println);
    }

    private static List<Futbolista> getFutbolistas(Path fichero)
    {
        List<Futbolista> futbolistas = null;
        try
        {

            futbolistas = Files.lines(fichero)
                    .map(l -> l.split(","))
                    .map(d -> new Futbolista(Integer.parseInt(d[0]),
                    d[1], d[2], d[3],
                    d[4].toUpperCase(),
                    Float.parseFloat(d[5]),
                    LocalDate.parse(d[6]), d[7])
                    ).toList();

        } catch (IOException e)
        {
            System.out.println(e.toString());
        }
        return futbolistas;
    }

    public static void listarPorAlias(Path fichero, Scanner teclado)
    {
        System.out.println("¿Porque alias quieres buscar?");
        getFutbolistas(fichero)
                .stream()
                .filter(f -> f.getAlias().equals(teclado.nextLine()))
                .forEach(System.out::println);
    }

    private static Path crearFicheroEquipos(Path fichero, Scanner teclado)
    {
        System.out.println("Que equipo quieres grabar en el fichero: ");
        String eq = teclado.nextLine();
        Path equipos = Paths.get(eq.toUpperCase() + ".csv");
        try
        {
            List<Futbolista> filtrados = getFutbolistas(fichero)
                    .stream()
                    .filter(f -> f.getCodEquipo().equals(eq))
                    .toList();
            BufferedWriter bw = Files.newBufferedWriter(equipos);
            for (Futbolista f : filtrados)
            {
                bw.write(f.toString());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e)
        {
            System.out.println(e.toString());
        }
        return equipos;
    }

    private static Path crearFicheroEquipos2(Path fichero, Scanner teclado)
    {
        System.out.println("Que equipo quieres grabar en el fichero: ");
        String eq = teclado.nextLine();
        Path equipos = Paths.get(eq.toUpperCase() + ".csv");
        try
        {
            Path write = Files.write(equipos, getFutbolistas(fichero)
                    .stream()
                    .filter(f -> f.getCodEquipo().equals(eq)).map(f -> f.toString())
                    .toList());
        } catch (IOException e)
        {
            System.out.println(e.toString());
        }
        return equipos;
    }

    private static void seleccionarFicheroEquipos(String eq)
    {

        Path equip = Paths.get(eq);
        if (Files.exists(equip))
        {
            listarFutbolistas(equip);
        } else
        {
            System.out.println("Ese fichero no existe");
        }
    }

    private static void listarEquipos()
    {
        Path ficheroActual = Paths.get(".");
        for (Path path : ficheroActual)
        {
            if (path.getNameCount() == 3)
            {
                path.forEach(System.out::println);
            }
        }
    }

}
