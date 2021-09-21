package es.danieldehesa.hoja01_ficheros_03_ejer4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author usuario
 */
public class Ej4
{

    public static void main(String[] args)
    {
        File f = new File("alumnos.txt");
        String linea;
        try
        {
            BufferedReader lector = new BufferedReader(new FileReader(f));
            while ((linea = lector.readLine()) != null)
            {
                String[] elementos = linea.split("-");
                int edad = Integer.parseInt(elementos[1].trim());
                if (edad > 20)
                {
                    System.out.println(elementos[0].trim() + " tiene " + edad + " años.");
                }
            }
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
