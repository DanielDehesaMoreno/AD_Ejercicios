package es.danieldehesa.hoja01_ficheros_05_ejer1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author usuario
 */
public class Instituto implements Serializable
{

    private String nombre;
    private LocalDate fechaConstruccion;
    private String localidad;

    public Instituto()
    {
    }

    public Instituto(String nombre, LocalDate fechaConstruccion, String localidad)
    {
        this.nombre = nombre;
        this.fechaConstruccion = fechaConstruccion;
        this.localidad = localidad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public LocalDate getFechaConstruccion()
    {
        return fechaConstruccion;
    }

    public void setFechaConstruccion(LocalDate fechaConstruccion)
    {
        this.fechaConstruccion = fechaConstruccion;
    }

    public String getLocalidad()
    {
        return localidad;
    }

    public void setLocalidad(String localidad)
    {
        this.localidad = localidad;
    }

    @Override
    public String toString()
    {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String linea = String.format("%-25s %s %-15s %n", nombre, fechaConstruccion.format(f), localidad);
        return linea;
    }

}
