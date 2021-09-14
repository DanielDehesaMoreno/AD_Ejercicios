package es.danieldehesa.hoja01_ficheros_01_ejer3;

import java.io.File;

/**
 *
 * @author usuario
 */
public class Ejer3
{

    public static void main(String[] args)
    {
        File directorio = new File("carpeta");
        if (!directorio.exists())
        {
            if (directorio.mkdir())
            {
                System.out.println("Directorio creado");
            } else
            {
                System.out.println("Error al crear el directorio");
            }
        }
        System.out.println(directorio.getAbsolutePath());
        File fichero1 = new File("carpeta/fichero1.txt");
        File fichero2 = new File("carpeta/fichero2.txt");
        File fichero3 = new File("fichero3.txt");
        boolean renombrar=fichero2.renameTo(fichero3);
        if(renombrar){
            System.out.println("Se ha renombrado correctamente");
        }else{
            System.out.println("No se ha podido renombrar");
        }
    }
}
