package es.danieldehesa.hoja01_ficheros_05_ejer2;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Alumno implements Serializable
{

    private String nombre;
    private int edad;

    public Alumno()
    {
    }

    public Alumno(String nombre, int edad)
    {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    @Override
    public String toString()
    {
        String linea = String.format("%s %2d %n", nombre, edad);
        return linea;
    }

}
