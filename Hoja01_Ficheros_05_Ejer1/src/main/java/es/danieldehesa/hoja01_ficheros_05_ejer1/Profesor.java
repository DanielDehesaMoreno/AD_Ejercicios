package es.danieldehesa.hoja01_ficheros_05_ejer1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author usuario
 */
public class Profesor implements Serializable
{

    private int numeroRegistro;
    private String nombre;
    private LocalDate fechaIngreso;
    private Instituto instituto;

    public Profesor()
    {
    }

    public Profesor(int numeroRegistro, String nombre, LocalDate fechaIngreso, Instituto instituto)
    {
        this.numeroRegistro = numeroRegistro;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
        this.instituto = instituto;
    }

    public int getNumeroRegistro()
    {
        return numeroRegistro;
    }

    public void setNumeroRegistro(int numeroRegistro)
    {
        this.numeroRegistro = numeroRegistro;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public LocalDate getFechaIngreso()
    {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso)
    {
        this.fechaIngreso = fechaIngreso;
    }

    public Instituto getInstituto()
    {
        return instituto;
    }

    public void setInstituto(Instituto instituto)
    {
        this.instituto = instituto;
    }

    @Override
    public String toString()
    {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String linea = String.format("%4d %-25s %s %n", numeroRegistro, nombre, fechaIngreso.format(f));
        return linea + this.instituto.toString();
    }

}
