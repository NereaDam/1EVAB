package org.example;

/**
 * clse cumpleAgenda
 */
public class CumpleAgenda {

    private String Nombre;
    private int Dia;
    private int Mes;

    /**
     * este metodo es el que guarda el nombre, dia y mes
     * @param nombre
     * @param dia
     * @param mes
     */
    public CumpleAgenda(String nombre, int dia, int mes) {
        this.Nombre = nombre;
        this.Dia = dia;
        this.Mes = mes;
    }

    /**
     * este metodo te devuelve el nombre
     * @return
     */
    public String GetNombre() {
        return Nombre;
    }

    /**
     * este metodo te devuelve el dia
     * @return
     */
    public int GetDia() {
        return Dia;
    }

    /**
     * este metodo te devulve le mes
     * @return
     */

    public int GetMes() {
        return Mes;
    }
}
