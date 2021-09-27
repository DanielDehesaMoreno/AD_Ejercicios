package es.danieldehesa.hoja01_ficheros_04_ejer2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author usuario
 */
public class Ej2
{

    public static void main(String[] args)
    {
        File f = new File("../Hoja01_Ficheros_04_Ejer1/futbolistas.dat");
        File aux = new File("futbolistas_ordenados.dat");
        List<Futbolista> futbol = new ArrayList<Futbolista>();
        leer(f, futbol);
        Collections.sort(futbol);
        escribir(aux, futbol);;

    }
    

    private static void escribir(File aux, List<Futbolista> futbol)
    {
        FileOutputStream fos = null;
        DataOutputStream escritor = null;
        try
        {
            fos = new FileOutputStream(aux);
            escritor = new DataOutputStream(fos);
            for (int i = 0; i < futbol.size(); i++)
            {
                Futbolista fu = futbol.get(i);
                escritor.writeInt(fu.getIdentificador());
                escritor.writeUTF(fu.getAlias());
                escritor.writeUTF(fu.getCodigoEq());
                escritor.writeUTF(fu.getPuesto().name());
                escritor.writeFloat(fu.getAltura());
            }

        } catch (EOFException e)
        {

        } catch (FileNotFoundException fn)
        {
            System.out.println("No se encuentra el fichero");
        } catch (IOException io)
        {
            System.out.println("Error de E/S");
        } finally
        {
            try
            {
                escritor.close();
                fos.close();
            } catch (IOException io)
            {
                System.out.println("Error de E/S");

            }
        }
    }

    private static void leer(File f, List<Futbolista> futbol)
    {
        FileInputStream fis = null;
        DataInputStream lector = null;
        try
        {
            fis = new FileInputStream(f);
            lector = new DataInputStream(fis);
            while (true)
            {
                Futbolista fut = new Futbolista();
                fut.setIdentificador(lector.readInt());
                fut.setAlias(lector.readUTF());
                fut.setCodigoEq(lector.readUTF());
                fut.setPuesto(lector.readUTF());
                fut.setAltura(lector.readFloat());
                futbol.add(fut);
            }
        } catch (EOFException e)
        {

        } catch (FileNotFoundException fn)
        {
            System.out.println("No se encuentra el fichero");
        } catch (IOException io)
        {
            System.out.println("Error de E/S");
        } finally
        {
            try
            {
                lector.close();
                fis.close();
            } catch (IOException io)
            {
                System.out.println("Error de E/S");

            }
        }
    }
}
