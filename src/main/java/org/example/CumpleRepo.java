package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * clase cumplerepo para añadir cumpleaños, buscar por nombre, por dia y eliminar por nombre
 */

public class CumpleRepo {

    /**
     * este metodo hace que no se repitn y sean unicos
     */
    private final List<CumpleAgenda> Lista = new ArrayList<>();

    /**
     * este metodo te devuleve la lista
     * @return
     */
    public List<CumpleAgenda> GetLista() {
        return Lista;
    }

    /**
     * este metodo añade cumpleaños
     * @param cumple
     */
    public void AddCumple(CumpleAgenda cumple) {
        Lista.add(cumple);
    }

    /**
     * este metodo busca el cumpleaños por nombre
     * @param nombre
     * @return
     */
    public CumpleAgenda BuscarPorNombre(String nombre) {
        for (CumpleAgenda c : Lista) {
            if (c.GetNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }

    /**
     * este metodo buscael cumpleaños por dia
     * @param dia
     * @return
     */
    public List<CumpleAgenda> BuscarPorDia(int dia) {
        List<CumpleAgenda> resultado = new ArrayList<>();
        for (CumpleAgenda c : Lista) {
            if (c.GetDia() == dia) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    /**
     * este metodo elimina el cumpleaños por el nombre
     * @param nombre
     * @return
     */
    public boolean EliminarPorNombre(String nombre) {
        CumpleAgenda encontrado = BuscarPorNombre(nombre);
        if (encontrado != null) {
            Lista.remove(encontrado);
            return true;
        }
        return false;
    }
}
