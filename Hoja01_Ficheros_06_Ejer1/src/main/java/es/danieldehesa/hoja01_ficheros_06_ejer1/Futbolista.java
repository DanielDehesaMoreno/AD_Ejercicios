package es.danieldehesa.hoja01_ficheros_06_ejer1;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author usuario
 */
public class Futbolista implements Serializable
{
    
    private int idJugador;
    private String nombre;
    private String apellidos;
    private String alias;
    private String puesto;
    private float altura;
    private LocalDate fechaNacimiento;
    private String codEquipo;
    
    public Futbolista()
    {
    }
    
    public Futbolista(int idJugador, String nombre, String apellidos, String alias, String puesto, float altura, LocalDate fechaNacimiento, String codEquipo)
    {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.alias = alias;
        this.puesto = puesto;
        this.altura = altura;
        this.fechaNacimiento = fechaNacimiento;
        this.codEquipo = codEquipo.toUpperCase().substring(0, 3);;
    }
    
    public int getIdJugador()
    {
        return idJugador;
    }
    
    public void setIdJugador(int idJugador)
    {
        this.idJugador = idJugador;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getApellidos()
    {
        return apellidos;
    }
    
    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }
    
    public String getAlias()
    {
        return alias;
    }
    
    public void setAlias(String alias)
    {
        this.alias = alias;
    }
    
    public String getPuesto()
    {
        return puesto;
    }
    
    public void setPuesto(String puesto)
    {
        this.puesto = puesto;
    }
    
    public float getAltura()
    {
        return altura;
    }
    
    public void setAltura(float altura)
    {
        this.altura = altura;
    }
    
    public LocalDate getFechaNacimiento()
    {
        return fechaNacimiento;
    }
    
    public void setFechaNacimiento(LocalDate fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public String getCodEquipo()
    {
        return codEquipo;
    }
    
    public void setCodEquipo(String codEquipo)
    {
        this.codEquipo = codEquipo;
    }
    
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 41 * hash + this.idJugador;
        return hash;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Futbolista other = (Futbolista) obj;
        if (this.idJugador != other.idJugador)
            return false;
        return true;
    }
    
    @Override
    public String toString()
    {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return idJugador + "," + nombre + "," + apellidos + "," + alias + "," + puesto + "," + altura + "," + fechaNacimiento.format(f) + "," + codEquipo;
    }
    
}
