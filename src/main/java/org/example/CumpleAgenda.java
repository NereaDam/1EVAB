package org.example;

public record CumpleAgenda(String Nombre, int Dia, int Mes) {

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
