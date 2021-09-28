package es.danieldehesa.hoja01_ficheros_05_ejer2;

import java.io.Serializable;

/**
 *
 * @author usuario
 */
public class Equipo implements Serializable
{

    private String nombre;
    private int numAlumnos;
    private float puntos;
    private Alumno[] alumnos;

    public Equipo()
    {
    }

    public Equipo(String nombre, int numAlumnos, float puntos, Alumno[] alumnos)
    {
        this.nombre = nombre;
        this.numAlumnos = numAlumnos;
        this.puntos = puntos;
        this.alumnos = alumnos;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getNumAlumnos()
    {
        return numAlumnos;
    }

    public void setNumAlumnos(int numAlumnos)
    {
        this.numAlumnos = numAlumnos;
    }

    public float getPuntos()
    {
        return puntos;
    }

    public void setPuntos(float puntos)
    {
        this.puntos = puntos;
    }

    public Alumno[] getAlumnos()
    {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos)
    {
        this.alumnos = alumnos;
    }

    @Override
    public String toString()
    {
        String linea = String.format("%-25s %2d %3s %3.2f %n", nombre, numAlumnos, puntos);
        if(alumnos.length>0){
        for (int i = 0; i < alumnos.length; i++)
        {
            linea = linea + alumnos[i].toString();
        }
        }
        return linea;
    }


    
    
}
