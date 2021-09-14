package es.danieldehesa.hoja01_ficheros_01_ejer1;

import java.io.File;

/**
 *
 * @author usuario
 */
public class Main
{

    public static void main(String[] args)
    {
        if(args.length>0){
        File directorio = new File(args[0]);
        File[] listaFicheros = directorio.listFiles();
        for (File fichero : listaFicheros)
        {
            System.out.println(fichero.getName());
            System.out.println(fichero.length());
        }
    }
    }
}
