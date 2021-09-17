package es.danieldehesa.hoja01_ficheros_02_ejer3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ej3
{
    public static void main(String[] args)
    {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        File f = null;
        FileInputStream fi = null;
        FileOutputStream fo = null;
        int c;
        do
        {
            System.out.println("--- MENU ---");
            System.out.println("1. Crear fichero numeros.dat");
            System.out.println("2. Añadir numero a numeros.dat");
            System.out.println("3. Listar numeros de numeros.dat");
            System.out.println("4. Listar numeros de numeros.dat en hexadecimal");
            System.out.println("5. Buscar numero en numeros.dat");
            System.out.println("0. Salir");
            opcion = sn.nextInt();
            switch (opcion)
            {

                case 1:
                    if (!f.exists())
                    {
                        f = new File("numeros.dat");
                    } else
                    {
                        System.out.println("El fichero ya fue creado");
                    }

                    break;

                case 2:
                    try
                    {
                        fo = new FileOutputStream("numeros.dat", true);
                        System.out.println("¿Que numero quieres añadir?");
                        int num = sn.nextInt();
                        fo.write(num);
                } catch (IOException e)
                {
                    System.err.println(e.toString());
                } finally
                {
                    try
                    {
                        fo.close();
                    } catch (IOException e)
                    {
                        System.err.println(e.toString());
                    }
                }
                break;

                case 3:
                    if (f.exists())
                    {
                        try
                        {
                            fi = new FileInputStream(f);
                            while (fi.available() > 0)
                            {
                                c = fi.read();
                                System.out.println(c);
                            }
                            System.out.println(10);

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
                                fi.close();
                            } catch (IOException e)
                            {
                                System.err.println(e.toString());
                            }
                        }
                    } else
                    {
                        System.out.println("No existe el fichero");
                    }
                    break;

                case 4:
                    if (f.exists())
                    {
                        try
                        {
                            fi = new FileInputStream(f);
                            while (fi.available() > 0)
                            {
                                c = fi.read();
                                String in = Integer.toHexString(c);
                                System.out.println(in);
                            }
                            System.out.println(10);

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
                                fi.close();
                            } catch (IOException e)
                            {
                                System.err.println(e.toString());
                            }
                        }
                    } else
                    {
                        System.out.println("No existe el fichero");
                    }

                    break;

                case 5:
                    System.out.println("¿Que numero quieres buscar?");
                    int n = sn.nextInt();
                    int i = 1;
                    boolean encontrado = false;
                    try
                    {
                        fi = new FileInputStream(f);
                        while (fi.available() > 0)
                        {
                            c = fi.read();
                            if (n == c)
                            {
                                System.out.println("Esta en la posicion " + i);
                                encontrado = true;
                            }
                            i++;

                        }
                        if (!encontrado)
                        {
                            System.out.println("No se encontro tu número");
                        }
                        System.out.println(10);

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
                            fi.close();
                        } catch (IOException e)
                        {
                            System.err.println(e.toString());
                        }
                    }
                    break;

                case 0:

                    System.out.println("CHAO; PESCAO");
                    salir = true;
                    break;

                default:

                    System.out.println("Solo numeros entre 0 y 7'5");

            }
        } while (!salir);
    }
}
