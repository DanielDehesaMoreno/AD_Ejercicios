package es.danieldehesa.hoja01_ficheros_02_ejer1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author usuario
 */
public class Ej1
{

    public static void main(String[] args)
    {
        File fiche = new File("entrada.txt");
        FileInputStream f = null;
        FileOutputStream fo = null;
        int c;
        try
        {
            f = new FileInputStream(fiche);
            fo = new FileOutputStream("salida.txt", true);
            while (f.available() > 0)
            {
                c = f.read();
                fo.write(c);
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
                fo.close();
            } catch (IOException e)
            {
                System.err.println(e.toString());
            }
        }
    }

}
