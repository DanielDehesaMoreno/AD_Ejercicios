package es.danieldehesa.hoja01_ficheros_05_ejer1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ej1{

     public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        File f = new File("profesores.dat");;
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
                    ;
                    break;

                case 2:
                    
                    break;

                case 3:
                    
                    break;

                case 4:
                    
                    break;

                case 5:
                    ;
                    break;

                default:

                    System.out.println("Solo numeros entre 0 y 5");
            }
        } while (!salir);
    }
     
    public static void escribirProfesor(Profesor profesor,File fichero) throws FileNotFoundException, IOException{
        
        ObjectOutputStream escritor = null;
    }
     
        
    }

