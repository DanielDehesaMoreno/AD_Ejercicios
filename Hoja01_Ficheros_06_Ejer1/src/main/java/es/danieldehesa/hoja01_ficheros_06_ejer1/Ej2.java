package es.danieldehesa.hoja01_ficheros_06_ejer1;

import static es.danieldehesa.hoja01_ficheros_06_ejer1.Ej1.listarPorAlias;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        Path fichero = Paths.get("futbolistas.csv");
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

}
