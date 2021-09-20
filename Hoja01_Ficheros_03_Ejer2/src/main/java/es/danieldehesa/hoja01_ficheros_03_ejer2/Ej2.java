package es.danieldehesa.hoja01_ficheros_03_ejer2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        File f = new File("texto.txt");
        int i, contador = 0;
        try
        {
            System.out.println("¿Que letra quieres buscar?");
            char c = teclado.next().charAt(0);
            Character.toLowerCase(c);
            FileReader lector = new FileReader(f);
            while ((i = lector.read()) != -1)
            {
                Character.toLowerCase((char) i);
                if (c == (char) i)
                {
                    contador++;
                }
            }
            System.out.println("Tu letra aparece " + contador + " veces en el ");
            lector.close();
        } catch (FileNotFoundException fn)
        {
            System.out.println("No se encuentra el fichero");
        } catch (IOException io)
        {
            System.out.println("Error de E/S");
        }

    }
}
