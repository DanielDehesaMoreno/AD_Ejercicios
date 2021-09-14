package es.danieldehesa.hoja01_ficheros_01_ejer2;

import java.io.File;

/**
 *
 * @author usuario
 */
public class Ejer2
{

    public static void main(String[] args)
    {
        File directorio = new File(".");
        File[] listaFicheros = directorio.listFiles();
        System.out.println("Nombre: "+listaFicheros[0].getName());
        System.out.println("Ruta relativa: "+listaFicheros[0].getPath());
        System.out.println("Ruta Absoluta"+listaFicheros[0].getAbsolutePath());
        if(listaFicheros[0].canWrite()){
            System.out.println("Se puede escribir");
        }else{
            System.out.println("No se puede escribir");
        }
        if(listaFicheros[0].canRead()){
            System.out.println("Se puede leer");
        }else{
            System.out.println("No se puede leer");
        }
        
    }
}
