package es.danieldehesa.hoja01_ficheros_01_ejer4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 *
 * @author DanielDehesa
 */
public class menu
{

    public static void main(String[] args)
    {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        String ruta = "";
        File direc = null;
        do
        {
            System.out.println("--- MENU ---");
            System.out.println("1. Comprobar si es un directorio");
            System.out.println("2. Obtener los ficheros del directorio");
            System.out.println("3. Obtener el tamaño del fichero");
            System.out.println("4. Obtener la ruta del directorio actual");
            System.out.println("5. Eliminar un fichero");
            System.out.println("6. Mover un fichero");
            System.out.println("7. Renombrar un fichero");
            System.out.println("0. Salir");
            opcion = sn.nextInt();
            switch (opcion)
            {

                case 1:
                    sn.nextLine();
                    System.out.println("Introduce la ruta del directorio:");
                    ruta = sn.nextLine();
                    direc = new File(ruta);
                    if (!direc.exists())
                    {
                        if (direc.isDirectory())
                        {
                            System.out.println("Existe y es un directorio.");
                        } else
                        {
                            System.out.println("Existe pero no es un directorio.");
                        }
                    } else
                    {
                        System.out.println("No existe.");
                    }
                    break;

                case 2:
                    sn.nextLine();
                    System.out.println("Introduce la ruta del directorio:");
                    ruta = sn.nextLine();
                    direc = new File(ruta);
                    File[] listaFicheros = direc.listFiles();
                    for (int i = 0; i < listaFicheros.length; i++)
                    {
                        if (listaFicheros[i].isFile())
                        {
                            System.out.println(listaFicheros[i] + " - F");
                        } else
                        {
                            System.out.println(listaFicheros[i] + " - D");
                        }
                    }
                    break;
                case 3:
                    sn.nextLine();
                    System.out.println("Introduce la ruta del directorio y el nombre del fichero:");
                    ruta = sn.nextLine();
                    direc = new File(ruta);
                    if (direc.exists())
                    {

                        System.out.println("ocupa " + direc.length() + " bytes");
                    }
                    break;
                case 4:
                    direc = new File(".");
                    System.out.println("La ruta del fichero actual es " + direc.getAbsolutePath());
                    break;
                case 5:
                    sn.nextLine();
                    System.out.println("Introduce la ruta del directorio y el nombre del fichero:");
                    ruta = sn.nextLine();
                    direc = new File(ruta);

                    if (direc.exists())
                    {
                        if (direc.delete())
                        {
                            System.out.println("Fichero borrado");
                        } else
                        {
                            System.out.println("No se pudo borrar el fichero");
                        }

                    } else
                    {
                        System.out.println("No existe");
                    }
                    break;
                case 6:
                    sn.nextLine();
                    System.out.println("Introduce la ruta del directorio y el nombre del fichero:");
                    ruta = sn.nextLine();
                    direc = new File(ruta);
                    if (direc.exists())
                    {
                        System.out.println("¿Ruta de destino?");
                        String destino = sn.nextLine();
                        File desti = new File(destino);

                        try
                        {
                            Files.copy(Paths.get(direc.getAbsolutePath()), Paths.get(desti.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException ioe)
                        {
                            ioe.printStackTrace();
                        }
                    } else
                    {
                        System.out.println("No existe.");
                    }
                    break;
                case 7:
                    sn.nextLine();
                    System.out.println("Introduce la ruta del directorio y el nombre del fichero:");
                    ruta = sn.nextLine();
                    direc = new File(ruta);
                    System.out.println("¿Como debe llamarse?");
                    String nuevo=sn.nextLine();
                    File rename=new File(nuevo);
                    direc.renameTo(rename);
                    break;
                case 0:
                    System.out.println("CHAO; PESCAO");
                    salir=true;
                    break;
                default:
                    System.out.println("Solo numeros entre 0 y 7");
            }
        } while (!salir);
    }
}
