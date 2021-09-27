package es.danieldehesa.hoja01_ficheros_04_ejer1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
        File f = new File("futbolistas.dat");;
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
                    aniadir(f, teclado);
                    break;

                case 2:
                    listar(f);
                    break;

                case 3:
                    System.out.println("Introduce el codigo del equipo:");
                    String eq = teclado.nextLine().toUpperCase().substring(0, 3);
                    listarPorEq(f, eq);
                    break;

                case 4:
                    System.out.println("Introduce la ID del jugador a buscar: ");
                    int id = teclado.nextInt();
                    listarID(f, id);
                    break;

                case 5:
                    System.out.println("Introduce la ID del jugador a buscar: ");
                    int ide = teclado.nextInt();
                    modificarEq(f, ide, teclado);
                    break;

                case 6:
                    System.out.println("Introduce la ID del jugador a modificar: ");
                    int ident = teclado.nextInt();
                    modificarTodo(f, ident, teclado);
                    break;

                case 7:
                    System.out.println("Introduce la ID del jugador a eliminar: ");
                    int iden = teclado.nextInt();
                    eliminar(f, iden);
                    break;

                default:

                    System.out.println("Solo numeros entre 0 y 7");
            }
        } while (!salir);
    }

    private static void listar(File f)
    {
        FileInputStream fis = null;
        DataInputStream lector = null;
        try
        {
            fis = new FileInputStream(f);
            lector = new DataInputStream(fis);
            while (true)
            {
                Futbolista fut = leerFutbolista(lector);
                System.out.println(fut);
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

    private static Futbolista leerFutbolista(DataInputStream lector) throws IOException
    {
        Futbolista fut = new Futbolista();
        fut.setIdentificador(lector.readInt());
        fut.setAlias(lector.readUTF());
        fut.setCodigoEq(lector.readUTF());
        fut.setPuesto(lector.readUTF());
        fut.setAltura(lector.readFloat());
        return fut;
    }

    private static void modificarTodo(File f, int id, Scanner teclado)
    {
        File aux = new File("aux.dat");
        FileInputStream fis = null;
        DataInputStream lector = null;
        FileOutputStream fos = null;
        DataOutputStream escritor = null;
        try
        {
            fis = new FileInputStream(f);
            lector = new DataInputStream(fis);
            fos = new FileOutputStream(aux);
            escritor = new DataOutputStream(fos);
            while (true)
            {
                Futbolista fut = new Futbolista();
                fut.setIdentificador(lector.readInt());
                fut.setAlias(lector.readUTF());
                fut.setCodigoEq(lector.readUTF());
                String puesto = lector.readUTF();
                fut.setPuesto(puesto);
                fut.setAltura(lector.readFloat());
                if (id != fut.getIdentificador())
                {
                    escritor.writeInt(fut.getIdentificador());
                    escritor.writeUTF(fut.getAlias());
                    escritor.writeUTF(fut.getCodigoEq());
                    escritor.writeUTF(puesto);
                    escritor.writeFloat(fut.getAltura());
                } else
                {
                    System.out.println("Introduce el identificador nuevo :");
                    String ide = teclado.nextLine();
                    if (ide.isEmpty())
                    {
                        escritor.writeInt(fut.getIdentificador());
                    } else
                    {
                        int identificador = Integer.parseInt(ide);
                        escritor.writeInt(identificador);
                    }
                    System.out.println("Introduce el alias :");
                    String al = teclado.nextLine();
                    if (al.isEmpty())
                    {
                        escritor.writeUTF(fut.getAlias());
                    } else
                    {
                        escritor.writeUTF(al);
                    }
                    System.out.println("Introduce el codigo de equipo :");
                    String cod = teclado.nextLine();
                    if (cod.isEmpty())
                    {
                        escritor.writeUTF(fut.getCodigoEq());
                    } else
                    {
                        escritor.writeUTF(cod);;
                    }
                    System.out.println("Introduce el puesto :");
                    String pu = teclado.nextLine();
                    if (pu.isEmpty())
                    {
                        escritor.writeUTF(puesto);
                    } else
                    {
                        escritor.writeUTF(pu);
                    }
                    System.out.println("Introduce la altura :");
                    String alt = teclado.nextLine();
                    if (alt.isEmpty())
                    {
                        escritor.writeInt(fut.getIdentificador());
                    } else
                    {
                        float altura = Float.parseFloat(alt);
                        escritor.writeFloat(fut.getAltura());
                    }
                }

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
                lector.close();
                fis.close();
            } catch (IOException io)
            {
                System.out.println("Error de E/S");

            }
            aux.renameTo(f);
            f.delete();
        }
    }

    private static void eliminar(File f, int id)
    {
        File aux = new File("aux.dat");
        FileInputStream fis = null;
        DataInputStream lector = null;
        FileOutputStream fos = null;
        DataOutputStream escritor = null;
        try
        {
            fis = new FileInputStream(f);
            lector = new DataInputStream(fis);
            fos = new FileOutputStream(aux);
            escritor = new DataOutputStream(fos);
            while (true)
            {
                Futbolista fut = new Futbolista();
                fut.setIdentificador(lector.readInt());
                fut.setAlias(lector.readUTF());
                fut.setCodigoEq(lector.readUTF());
                String puesto = lector.readUTF();
                fut.setPuesto(puesto);
                fut.setAltura(lector.readFloat());
                if (id != fut.getIdentificador())
                {
                    escritor.writeInt(fut.getIdentificador());
                    escritor.writeUTF(fut.getAlias());
                    escritor.writeUTF(fut.getCodigoEq());
                    escritor.writeUTF(puesto);
                    escritor.writeFloat(fut.getAltura());
                }

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
                lector.close();
                fis.close();
            } catch (IOException io)
            {
                System.out.println("Error de E/S");

            }
            aux.renameTo(f);
            f.delete();
        }
    }

    private static void modificarEq(File f, int id, Scanner teclado)
    {
        File aux = new File("aux.dat");
        FileInputStream fis = null;
        DataInputStream lector = null;
        FileOutputStream fos = null;
        DataOutputStream escritor = null;
        try
        {
            fis = new FileInputStream(f);
            lector = new DataInputStream(fis);
            fos = new FileOutputStream(aux);
            escritor = new DataOutputStream(fos);
            while (true)
            {
                Futbolista fut = new Futbolista();
                fut.setIdentificador(lector.readInt());
                fut.setAlias(lector.readUTF());
                fut.setCodigoEq(lector.readUTF());
                String puesto = lector.readUTF();
                fut.setPuesto(puesto);
                fut.setAltura(lector.readFloat());
                if (id == fut.getIdentificador())
                {
                    System.out.println(fut);
                    System.out.println("Introduce el nuevo codigo de equipo:");
                    String code = teclado.nextLine().toUpperCase().substring(0, 3);
                    escritor.writeInt(fut.getIdentificador());
                    escritor.writeUTF(fut.getAlias());
                    escritor.writeUTF(code);
                    escritor.writeUTF(puesto);
                    escritor.writeFloat(fut.getAltura());
                } else
                {
                    escritor.writeInt(fut.getIdentificador());
                    escritor.writeUTF(fut.getAlias());
                    escritor.writeUTF(fut.getCodigoEq());
                    escritor.writeUTF(puesto);
                    escritor.writeFloat(fut.getAltura());
                }

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
                lector.close();
                fis.close();
            } catch (IOException io)
            {
                System.out.println("Error de E/S");

            }
            aux.renameTo(f);
            f.delete();
        }
    }

    private static void listarPorEq(File f, String s)
    {
        FileInputStream fis = null;
        DataInputStream lector = null;
        int contador = 0;
        try
        {
            fis = new FileInputStream(f);
            lector = new DataInputStream(fis);
            while (true)
            {

                Futbolista fut = leerFutbolista(lector);
                if (s.equals(fut.getCodigoEq()))
                {

                    System.out.println(fut);
                    contador++;
                }
            }

        } catch (EOFException e)
        {
            if (contador == 0)
            {
                System.out.println("No hay jugadores en ese equipo");
            }
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

    private static void listarID(File f, int i)
    {
        boolean existe = false;
        FileInputStream fis = null;
        DataInputStream lector = null;

        try
        {
            fis = new FileInputStream(f);
            lector = new DataInputStream(fis);
            while (!existe)
            {

                Futbolista fut = leerFutbolista(lector);
                if (i == fut.getIdentificador())
                {
                    System.out.println(fut);
                    existe = true;

                } else
                {
                    System.out.println("No existe elfutbolista");
                }
                {

                }
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

    private static boolean listarPorID(File f, int i)
    {
        boolean existe = false;
        FileInputStream fis = null;
        DataInputStream lector = null;

        try
        {
            fis = new FileInputStream(f);
            lector = new DataInputStream(fis);
            while (!existe)
            {

                Futbolista fut = leerFutbolista(lector);
                if (i == fut.getIdentificador())
                {
                    existe = true;

                }
                {

                    System.out.println(fut);

                }
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
        return existe;
    }

    private static void aniadir(File f, Scanner teclado)
    {
        FileOutputStream fos = null;
        DataOutputStream escritor = null;    
        boolean existe;
        try
        {
            fos = new FileOutputStream(f);
            escritor = new DataOutputStream(fos);
            System.out.println("Introduce el identificador: ");
            int identificador = teclado.nextInt();
            existe = listarPorID(f, identificador);
            if (existe)
            {
                System.out.println("El futbolista ya existe");
            } else
            {
                teclado.nextLine();
                System.out.println("Introduce el alias del jugador: ");
                String alias = teclado.nextLine();
                System.out.println("Introduce el codigo de su Equipo (3 caracteres): ");
                String codigoEq = teclado.nextLine();
                System.out.println("Introduce el puesto del jugador:");
                String pu = teclado.nextLine().toUpperCase();
                Puesto posicion = Puesto.valueOf(pu);
                System.out.println("Introduce la altura: ");
                float altura = teclado.nextFloat();
                Futbolista fut = new Futbolista(identificador, alias, codigoEq, posicion, altura);
                escritor.writeInt(identificador);
                escritor.writeUTF(alias);
                escritor.writeUTF(codigoEq);
                escritor.writeUTF(pu);
                escritor.writeFloat(altura);
            }
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
}
