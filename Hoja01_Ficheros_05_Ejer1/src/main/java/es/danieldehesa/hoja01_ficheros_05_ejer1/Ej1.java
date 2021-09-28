package es.danieldehesa.hoja01_ficheros_05_ejer1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
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
        boolean salir = false;
        int opcion;
        File fichero = new File("profesores.dat");;
        do
        {
            System.out.println("--- MENU ---");
            System.out.println("1. Añadir futbolista");
            System.out.println("2. Listar futbolistas");
            System.out.println("3. Listar futbolistas de equipo");
            System.out.println("4. Buscar futbolista");
            System.out.println("5. Modificar equipo de futbolista");
            System.out.println("5. Modificar datos de futbolista");
            System.out.println("5. Eliminar futbolista");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();
            switch (opcion)
            {
                case 0:

                    System.out.println("CHAO; PESCAO");
                    salir = true;
                    break;

                case 1:
                    Profesor profesor = new Profesor();
                    try
                    {
                        escribirProfesor(profesor, fichero);
                    } catch (FileNotFoundException ex)
                    {
                        System.out.println(ex.toString());
                    } catch (IOException e)
                    {
                        System.out.println(e.toString());
                    }
                    break;

                case 2:
                    System.out.println("Porque localidad vas a filtrar: ");
                    String localidad = teclado.nextLine();
                    try
                    {
                        listarPorLocalidad(localidad, fichero);
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

                    break;

                case 3:
                    try
                    {
                        leerProfesorAntiguedad(fichero);
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
                break;

                case 4:
                    System.out.println("Introduce el numero de registro del profesor: ");
                    int registro = teclado.nextInt();
                    System.out.println("Introduce el nombre del nuevo instituo: ");
                    String instituto = teclado.nextLine();
                    try
                    {
                        traslado(registro, instituto, fichero);
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
                    break;

                case 5:
                    List<Profesor> lista = new ArrayList<Profesor>();
                    System.out.println("Introduce el Instituo que quieres borrar: ");
                    instituto = teclado.nextLine();
                    try
                    {
                        lista = destruirInstituto(instituto, fichero);
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
                    System.out.println("--- LISTA DE PROFESORES ELIMINADOS ---");
                    for (Profesor p : lista)
                    {
                        System.out.println(p.toString());
                    }
                    break;

                default:

                    System.out.println("Solo numeros entre 0 y 5");
            }
        } while (!salir);
    }

    public static void escribirProfesor(Profesor profesor, File fichero) throws FileNotFoundException, IOException
    {

        ObjectOutputStream escritor = null;
        if (fichero.exists())
        {
            escritor = new ObjectOutputStreamSinCabeceras(new FileOutputStream(fichero, true));
        } else
        {
            escritor = new ObjectOutputStream(new FileOutputStream(fichero, true));
        }
        escritor.writeObject(profesor);
        escritor.close();
    }

    public static void listarPorLocalidad(String localidad, File fichero) throws IOException, ClassNotFoundException
    {
        ObjectInputStream lector = null;
        try
        {
            lector = new ObjectInputStream(new FileInputStream(fichero));
            while (true)
            {
                Profesor p = (Profesor) lector.readObject();
                if (p.getInstituto().getLocalidad().equalsIgnoreCase(localidad))
                {
                    System.out.println("Nombre: " + p.getNombre() + " | Instituto: " + p.getInstituto().getNombre() + " | Tiempo Trabajado: " + p.getMesesTrabajados());
                }
            }
        } catch (EOFException e)
        {

        } finally
        {
            lector.close();
        }
    }

    public static void leerProfesorAntiguedad(File fichero) throws IOException, ClassNotFoundException
    {
        ObjectInputStream lector = null;
        LocalDate hoy = LocalDate.now();
        String nombreInstituto = null;
        try
        {
            lector = new ObjectInputStream(new FileInputStream(fichero));
            while (true)
            {
                Profesor p = (Profesor) lector.readObject();
                if (p.getInstituto().getFechaConstruccion().isBefore(hoy))
                {
                    hoy = p.getInstituto().getFechaConstruccion();
                    nombreInstituto = p.getInstituto().getNombre();
                }
            }
        } catch (EOFException e)
        {

        }
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Instituto: " + nombreInstituto + " | Construido el: " + hoy.format(f));
        System.out.println("--- LISTADO DE PROFESORES ---");
        try
        {
            while (true)
            {
                Profesor pro = (Profesor) lector.readObject();
                if (pro.getInstituto().getNombre().equalsIgnoreCase(nombreInstituto))
                {
                    System.out.println(pro.getNombre());
                }
            }
        } catch (EOFException e)
        {

        } finally
        {
            lector.close();
        }

    }

    public static void traslado(int registro, String instituto, File fichero) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        File aux = new File("aux.dat");
        ObjectOutputStream escritor = null;
        ObjectInputStream lector = null;
        if (fichero.exists())
        {
            escritor = new ObjectOutputStreamSinCabeceras(new FileOutputStream(aux, true));
        } else
        {
            escritor = new ObjectOutputStream(new FileOutputStream(fichero, true));
        }
        lector = new ObjectInputStream(new FileInputStream(fichero));
        try
        {
            while (true)
            {
                Profesor p = (Profesor) lector.readObject();
                if (registro == p.getNumeroRegistro())
                {
                    Instituto insti = p.getInstituto();
                    insti.setNombre(instituto);
                    escritor.writeObject(p);
                } else
                {
                    escritor.writeObject(p);
                }
            }
        } catch (EOFException e)
        {

        }
        fichero.delete();
        aux.renameTo(fichero);
        escritor.close();
        lector.close();
    }

    public static List destruirInstituto(String insituto, File fichero) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        File aux = new File("aux.dat");
        ObjectOutputStream escritor = null;
        ObjectInputStream lector = null;
        List<Profesor> lista = new ArrayList<Profesor>();
        if (fichero.exists())
        {
            escritor = new ObjectOutputStreamSinCabeceras(new FileOutputStream(aux, true));
        } else
        {
            escritor = new ObjectOutputStream(new FileOutputStream(fichero, true));
        }
        lector = new ObjectInputStream(new FileInputStream(fichero));
        try
        {
            while (true)
            {
                Profesor p = (Profesor) lector.readObject();
                if (p.getInstituto().getNombre().equalsIgnoreCase(insituto))
                {
                    lista.add(p);
                } else
                {
                    escritor.writeObject(p);
                }
            }
        } catch (EOFException e)
        {

        }
        fichero.delete();
        aux.renameTo(fichero);
        escritor.close();
        lector.close();
        return lista;
    }

}
