package es.danieldehesa.hoja01_ficheros_03_ejer3;

import java.io.BufferedReader;
import java.io.File;
import java.util.LinkedList;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ej3
{

    public static void main(String[] args)
    {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        File f = new File("personas.txt");
        int c;
        do
        {
            System.out.println("--- MENU ---");
            System.out.println("1. Añadir persona");
            System.out.println("2. Buscar persona");
            System.out.println("3. Buscar nombre");
            System.out.println("4. Apellidos comienzan por");
            System.out.println("5. Eliminar persona");
            System.out.println("0. Salir");
            opcion = teclado.nextInt();
            switch (opcion)
            {

                case 1:
                    try
                    {
                        System.out.println("Escribe la persona que deseas añadir (APELLIDO, NOMBRE):");
                        String persona = teclado.nextLine().toUpperCase();
                        PrintWriter escritor = new PrintWriter(f);
                        escritor.write(persona);
                        escritor.close();
                } catch (FileNotFoundException fn)
                {
                    System.out.println("No se encuentra el fichero");
                } catch (IOException io)
                {
                    System.out.println("Error de E/S");
                }
                break;

                case 2:
                    try
                    {
                        String linea;
                        boolean encontrado = false;
                        System.out.println("Escribe la persona que deseas buscar (APELLIDO, NOMBRE):");
                        String persona = teclado.nextLine().toUpperCase();
                        BufferedReader lector = new BufferedReader(new FileReader(f));
                        while ((linea = lector.readLine()) != null)
                        {
                            if (linea.equalsIgnoreCase(persona))
                            {
                                encontrado = true;
                            }
                        }
                        if (encontrado)
                        {
                            System.out.println("Tu persona esta en nuestro fichero.");
                        } else
                        {
                            System.out.println("Tu persona no esta en nuestro fichero.");
                        }
                        lector.close();

                } catch (FileNotFoundException fn)
                {
                    System.out.println("No se encuentra el fichero");
                } catch (IOException io)
                {
                    System.out.println("Error de E/S");
                }
                break;

                case 3:
                        try
                    {

                        String linea;
                        boolean encontrado = false;
                        System.out.println("Escribe el nombre de la persona que deseas buscar:");
                        String nombre = teclado.nextLine().toUpperCase();
                        BufferedReader lector = new BufferedReader(new FileReader(f));
                        while ((linea = lector.readLine()) != null)
                        {
                            String[] elementos = linea.split(",");
                            if (elementos[1].toUpperCase().equalsIgnoreCase(nombre))
                            {
                                encontrado = true;
                            }
                        }
                        if (encontrado)
                        {
                            System.out.println("Tu persona esta en nuestro fichero.");
                        } else
                        {
                            System.out.println("Tu persona no esta en nuestro fichero.");
                        }
                        lector.close();

                } catch (FileNotFoundException fn)
                {
                    System.out.println("No se encuentra el fichero");
                } catch (IOException io)
                {
                    System.out.println("Error de E/S");
                }
                break;
                case 4:

                try
                    {

                        String linea;
                        LinkedList lista = new LinkedList();
                        System.out.println("Escribe el apellido de la persona que deseas buscar:");
                        String apellido = teclado.nextLine().toUpperCase();
                        int corte = apellido.length();
                        BufferedReader lector = new BufferedReader(new FileReader(f));
                        while ((linea = lector.readLine()) != null)
                        {
                            String[] elementos = linea.split(",");
                            if (elementos[0].substring(0, corte).equalsIgnoreCase(apellido))
                            {
                                lista.add(linea);
                            }
                        }
                        Iterator<String> it = lista.iterator();
                        while (it.hasNext())
                        {
                            System.out.println(it.next());
                        }
                        lector.close();
                } catch (FileNotFoundException fn)
                {
                    System.out.println("No se encuentra el fichero");
                } catch (IOException io)
                {
                    System.out.println("Error de E/S");
                }
                break;

                case 5:
                    try
                    {
                        boolean encontrado = false;
                        String linea;
                        File aux = new File("auxiliar.txt");
                        System.out.println("Escribe la persona que deseas añadir (APELLIDO, NOMBRE):");
                        String persona = teclado.nextLine().toUpperCase();
                        BufferedReader lector = new BufferedReader(new FileReader(f));
                        PrintWriter escritor = new PrintWriter(aux);
                        while ((linea = lector.readLine()) != null)
                        {
                            if (!linea.equalsIgnoreCase(persona))
                            {
                                escritor.write(linea);
                            }
                        }
                        aux.renameTo(f);
                        f.delete();
                        lector.close();
                        escritor.close();
                } catch (FileNotFoundException fn)
                {
                    System.out.println("No se encuentra el fichero");
                } catch (IOException io)
                {
                    System.out.println("Error de E/S");
                }

                break;

                case 0:

                    System.out.println("CHAO; PESCAO");
                    salir = true;
                    break;

                default:

                    System.out.println("Solo numeros entre 0 y 5");

            }
        } while (!salir);
    }
}
