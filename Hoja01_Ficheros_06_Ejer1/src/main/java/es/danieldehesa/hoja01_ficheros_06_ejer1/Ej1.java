package es.danieldehesa.hoja01_ficheros_06_ejer1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
                    try
                    {
                        if (Files.exists(fichero))
                        {
                            Stream<String> lineas = Files.lines(fichero);
                            lineas.forEach(System.out::println);
                        }else{
                            System.out.println("No existe el fichero");
                        }
                } catch (IOException e)
                {
                    System.out.println(e.toString());
                }

                break;
                case 2:
                    
                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;
                default:

                    System.out.println("Solo numeros entre 0 y 6");
            }
        } while (!salir);
    }

}
