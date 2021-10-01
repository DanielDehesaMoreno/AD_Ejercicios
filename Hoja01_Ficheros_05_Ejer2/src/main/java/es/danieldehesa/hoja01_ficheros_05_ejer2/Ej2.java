package es.danieldehesa.hoja01_ficheros_05_ejer2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
        File fichero = new File("equipos.dat");;

        try
        {
            Equipo equipo = new Equipo();
            System.out.println("Introduce el nombre del equipo: ");
            equipo.setNombre(teclado.nextLine());
            System.out.println("Cuantos alumnos hay en el equipo: ");
            equipo.setNumAlumnos(teclado.nextInt());
            System.out.println("Introduce los puntos del equipo (entre 0 y 100)");
            equipo.setPuntos(teclado.nextFloat());
            Alumno[] alumnos = new Alumno[equipo.getNumAlumnos()];
            equipo.setAlumnos(alumnos);
            System.out.println(equipo.getAlumnos().length);
            for (int i = 0; i < equipo.getNumAlumnos(); i++)
            {
                teclado.nextLine();
                alumnos[i] = new Alumno();
                System.out.println("Introduce el nombre del alumno: ");
                alumnos[i].setNombre(teclado.nextLine());
                System.out.println("Introduce su edad: ");
                alumnos[i].setEdad(teclado.nextInt());

            }
            escribirEquipo(equipo, fichero);
            leerFichero(fichero);
        } catch (FileNotFoundException f)
        {
            System.out.println(f.toString());
        } catch (IOException e)
        {
            System.out.println(e.toString());
        } catch (ClassNotFoundException c)
        {
            System.out.println(c.toString());
        }

    }

    public static void escribirEquipo(Equipo equipo, File fichero) throws FileNotFoundException, IOException
    {

        ObjectOutputStream escritor = null;
        if (fichero.exists())
        {
            escritor = new ObjectOutputStreamSinCabeceras(new FileOutputStream(fichero, true));
        } else
        {
            escritor = new ObjectOutputStream(new FileOutputStream(fichero, true));
        }
        escritor.writeObject(equipo);
        escritor.close();
    }

    public static void leerFichero(File fichero) throws IOException, ClassNotFoundException
    {
        ObjectInputStream lector = null;

        lector = new ObjectInputStream(new FileInputStream(fichero));
        Equipo equipo = (Equipo) lector.readObject();
        System.out.println(equipo.toString());
        lector.close();

    }
}
