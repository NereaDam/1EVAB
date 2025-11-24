package org.example;

import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Nerea De La Torre
 * es un menu para listar, añadir, eliminar... cumpleaños
 *
 */
public class Main {

    public static void main(String[] args) {

        CumpleRepo repo = new CumpleRepo();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            /**
             * este metodo es el metdo de las opciones del menu
             */
            opcionesMenu();

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    /**
                     * este metodo lista
                     */
                    listar(repo.GetLista());
                    break;

                case "2":
                    /**
                     * este metodo busca el cumpleaños por dia
                     */
                    buscarPorDia(sc, repo);
                    break;

                case "3":
                    /**
                     * este metodo busca el cumpleaños por nombre
                     */
                    buscarPorNombre(repo, sc);
                    break;

                case "4":
                    /**
                     * este metodo añade cumpleaños
                     */
                    aniadir(sc, repo);
                    break;

                case "5":
                    /**
                     * este metodo elimina cumpleaños
                     */
                    eliminarNombre(repo, sc);
                    break;

                case "6":
                    salir = true;
                    break;
            }
        }
    }

    /**
     * estees el metodo de las opciones del menu con las constantes añadidas
     */
    private static void opcionesMenu() {
        System.out.println(Constantes.AGENDA);
        System.out.println(Constantes.LISTAR);
        System.out.println(Constantes.BUSCAR_POR_DIA);
        System.out.println(Constantes.BUSCAR_POR_NOMBRE);
        System.out.println(Constantes.ANIADIR);
        System.out.println(Constantes.ELIMINAR);
        System.out.println(Constantes.SALIR);
    }

    /**
     * este metodo elimina cumpleaños añadiendo el nombre
     * @param repo
     * @param sc
     */
    private static void eliminarNombre(CumpleRepo repo, Scanner sc) {
        System.out.print(Constantes.ELIMINAR_NOMBRE);
        repo.EliminarPorNombre(sc.nextLine());
    }

    /**
     * este metodo añade cumpleaños insertando el usuario mes dia y nombre
     * @param sc
     * @param repo
     */
    private static void aniadir(Scanner sc, CumpleRepo repo) {
        System.out.print(Constantes.NOMBRE);
        String nombre = sc.nextLine();
        System.out.print(Constantes.DIA);
        int d = Integer.parseInt(sc.nextLine());
        System.out.print(Constantes.MES);
        int m = Integer.parseInt(sc.nextLine());
        repo.AddCumple(new CumpleAgenda(nombre, d, m));
    }

    /**
     * este metodo hace una lista de cumplaños
     * @param repo
     */
    private static void listar(List<CumpleAgenda> repo) {
        for (CumpleAgenda c : repo) {
            System.out.println(c.GetNombre());
        }
    }

    /**
     * este metodo te busca los cumpleños por el nombre
     * @param sc
     */
    private static void buscarPorNombre(CumpleRepo repo, Scanner sc) {
        System.out.print(Constantes.NOMBRE);
        CumpleAgenda c = repo.BuscarPorNombre(sc.nextLine());
        if (c != null) System.out.println(c.GetNombre());
    }

    /**
     * etse metodo te busca el cumpleaños por dia
     * @param sc
     * @param repo
     */
    private static void buscarPorDia(Scanner sc, CumpleRepo repo) {
        System.out.print(Constantes.DIA);
        int dia = Integer.parseInt(sc.nextLine());
        listar(repo.BuscarPorDia(dia));
    }
}

