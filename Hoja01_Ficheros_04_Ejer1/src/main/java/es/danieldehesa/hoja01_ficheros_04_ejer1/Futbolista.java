package es.danieldehesa.hoja01_ficheros_04_ejer1;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Futbolista
{

    private int identificador;
    private String alias;
    private String codigoEq;
    private Puesto puesto;
    private float altura;

    public Futbolista()
    {
    }

    public Futbolista(int identificador, String alias, Puesto puesto, String codigoEq, float altura)
    {
        this.identificador = identificador;
        this.alias = alias;
        this.puesto = puesto;
        this.codigoEq = codigoEq.toUpperCase().substring(0, 3);
        this.altura = altura;
    }

    public int getIdentificador()
    {
        return identificador;
    }

    public void setIdentificador(int identificador)
    {
        this.identificador = identificador;
    }

    public String getAlias()
    {
        return alias;
    }

    public void setAlias(String alias)
    {
        this.alias = alias;
    }

    public String getCodigoEq()
    {
        return codigoEq;
    }

    public void setCodigoEq(String codigoEq)
    {
        this.codigoEq = codigoEq;
    }

    public float getAltura()
    {
        return altura;
    }

    public void setAltura(float altura)
    {
        this.altura = altura;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 41 * hash + this.identificador;
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
        if (this.identificador != other.identificador)
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        String linea = String.format("%3d %-25s %3s %-16s %4.2f", identificador, alias, codigoEq, altura);
        return linea;
    }

}
