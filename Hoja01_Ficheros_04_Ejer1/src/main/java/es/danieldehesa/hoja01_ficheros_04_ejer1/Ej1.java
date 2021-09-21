package es.danieldehesa.hoja01_ficheros_04_ejer1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
        File f = new File("futbolistas.dat");
        FileInputStream fis = null;
        DataInputStream lector = null;
        FileOutputStream fos = null;
        DataOutputStream escritor = null;
        int c;
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

                    System.out.println("Introduce el identificador: ");
                    int identificador = teclado.nextInt();
                    System.out.println("Introduce el alias del jugador: ");
                    String alias = teclado.nextLine();
                    System.out.println("Introduce el codigo de su Equipo (3 caracteres): ");
                    String codigoEq = teclado.nextLine();
                    System.out.println("Introduce el puesto del jugador:");
                    Puesto posicion = Puesto.valueOf(teclado.nextLine().toUpperCase());
                    System.out.println("Introduce la altura: ");
                    float altura = teclado.nextFloat();
                    Futbolista fut = new Futbolista(identificador, alias, posicion, codigoEq, altura);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 6:

                    break;

                case 7:

                    break;

                default:

                    System.out.println("Solo numeros entre 0 y 7");
            }
        } while (!salir);
    }
}
