package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CumpleRepo repo = new CumpleRepo();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            opcionesMenu();

            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    listar(repo.GetLista());
                    break;

                case "2":
                    buscarPorDia(sc, repo);
                    break;

                case "3":
                    buscarPorNombre(repo, sc);
                    break;

                case "4":
                    aniadir(sc, repo);
                    break;

                case "5":
                    eliminarNombre(repo, sc);
                    break;

                case "6":
                    salir = true;
                    break;
            }
        }
    }

    private static void opcionesMenu() {
        System.out.println(Constantes.AGENDA);
        System.out.println(Constantes.LISTAR);
        System.out.println(Constantes.BUSCAR_POR_DIA);
        System.out.println(Constantes.BUSCAR_POR_NOMBRE);
        System.out.println(Constantes.ANIADIR);
        System.out.println(Constantes.ELIMINAR);
        System.out.println(Constantes.SALIR);
    }

    private static void eliminarNombre(CumpleRepo repo, Scanner sc) {
        System.out.print(Constantes.ELIMINAR_NOMBRE);
        repo.EliminarPorNombre(sc.nextLine());
    }

    private static void aniadir(Scanner sc, CumpleRepo repo) {
        System.out.print(Constantes.NOMBRE);
        String nombre = sc.nextLine();
        System.out.print(Constantes.DIA);
        int d = Integer.parseInt(sc.nextLine());
        System.out.print(Constantes.MES);
        int m = Integer.parseInt(sc.nextLine());
        repo.AddCumple(new CumpleAgenda(nombre, d, m));
    }

    private static void listar(List<CumpleAgenda> repo) {
        for (CumpleAgenda c : repo) {
            System.out.println(c.GetNombre());
        }
    }

    private static void buscarPorNombre(CumpleRepo repo, Scanner sc) {
        System.out.print(Constantes.NOMBRE);
        CumpleAgenda c = repo.BuscarPorNombre(sc.nextLine());
        if (c != null) System.out.println(c.GetNombre());
    }

    private static void buscarPorDia(Scanner sc, CumpleRepo repo) {
        System.out.print(Constantes.DIA);
        int dia = Integer.parseInt(sc.nextLine());
        listar(repo.BuscarPorDia(dia));
    }
}
