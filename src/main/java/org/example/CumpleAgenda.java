package org.example;

public class CumpleAgenda {

    private String Nombre;
    private int Dia;
    private int Mes;

    public CumpleAgenda(String nombre, int dia, int mes) {
        this.Nombre = nombre;
        this.Dia = dia;
        this.Mes = mes;
    }

    public String GetNombre() {
        return Nombre;
    }

    public int GetDia() {
        return Dia;
    }

    public int GetMes() {
        return Mes;
    }
}
