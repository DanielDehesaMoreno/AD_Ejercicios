package es.danieldehesa.hoja01_ficheros_02_ejer2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ej2
{

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Que fichero quieres leer?");
        String fichero = teclado.nextLine();
        File fiche = new File(fichero);
        FileInputStream f = null;
        int c;
        try
        {
            f = new FileInputStream(fiche);
            while (f.available() > 0)
            {
                c = f.read();
                if (c != 32)
                {
                    System.out.print((char) c);
                }
            }

        } catch (FileNotFoundException e)
        {
            System.err.println("Fichero no encontrado");
        } catch (IOException e)
        {
            System.err.println(e.toString());
        } finally
        {
            try
            {
                f.close();
            } catch (IOException e)
            {
                System.err.println(e.toString());
            }
        }
    }

}
