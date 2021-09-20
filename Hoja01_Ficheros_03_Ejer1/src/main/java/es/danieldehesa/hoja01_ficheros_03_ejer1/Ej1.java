package es.danieldehesa.hoja01_ficheros_03_ejer1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ej1
{

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Que fichero quieres usar?");
        String fichero = teclado.nextLine();
        System.out.println("¿Que texto quieres añadir al fichero?");
        String texto = teclado.nextLine();
        File f = new File(fichero);
        try
        {
            PrintWriter escritor = new PrintWriter(new FileWriter(fichero));
            escritor.write(texto.substring(0, 1).toLowerCase() + texto.substring(1).toUpperCase());
            escritor.close();
        } catch (FileNotFoundException fn)
        {
            System.out.println("No se encuentra el fichero");
        } catch (IOException io)
        {
            System.out.println("Error de E/S");
        }

    }
}
