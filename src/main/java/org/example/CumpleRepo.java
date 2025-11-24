package org.example;

import java.util.ArrayList;
import java.util.List;

public class CumpleRepo {

    private final List<CumpleAgenda> Lista = new ArrayList<>();

    public List<CumpleAgenda> GetLista() {
        return Lista;
    }

    public void AddCumple(CumpleAgenda cumple) {
        Lista.add(cumple);
    }

    public CumpleAgenda BuscarPorNombre(String nombre) {
        for (CumpleAgenda c : Lista) {
            if (c.GetNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    public List<CumpleAgenda> BuscarPorDia(int dia) {
        List<CumpleAgenda> resultado = new ArrayList<>();
        for (CumpleAgenda c : Lista) {
            if (c.GetDia() == dia) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public boolean EliminarPorNombre(String nombre) {
        CumpleAgenda encontrado = BuscarPorNombre(nombre);
        if (encontrado != null) {
            Lista.remove(encontrado);
            return true;
        }
        return false;
    }
}
