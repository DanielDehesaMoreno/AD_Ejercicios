package es.danieldehesa.ejemplo1;

import java.io.File;

/**
 *
 * @author usuario
 */
public class VerDir2 {

    public static void main(String[] args)
    {
      File directorio = new File(".");
        System.out.println("Ficheros de directorio actual: "+ directorio.getAbsolutePath());
        File[] listaFicheros = directorio.listFiles();
        for (File fichero: listaFicheros)
        {
            System.out.println(fichero.getName());
        }
        
    }
}
