package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CumpleRepo repo = new CumpleRepo();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== AGENDA ===");
            System.out.println("1. Listar");
            System.out.println("2. Buscar por día");
            System.out.println("3. Buscar por nombre");
            System.out.println("4. Añadir");
            System.out.println("5. Eliminar");
            System.out.println("6. Salir");

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

    private static void eliminarNombre(CumpleRepo repo, Scanner sc) {
        System.out.print("Eliminar nombre: ");
        repo.EliminarPorNombre(sc.nextLine());
    }

    private static void aniadir(Scanner sc, CumpleRepo repo) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Día: ");
        int d = Integer.parseInt(sc.nextLine());
        System.out.print("Mes: ");
        int m = Integer.parseInt(sc.nextLine());
        repo.AddCumple(new CumpleAgenda(nombre, d, m));
    }

    private static void listar(List<CumpleAgenda> repo) {
        for (CumpleAgenda c : repo) {
            System.out.println(c.GetNombre());
        }
    }

    private static void buscarPorNombre(CumpleRepo repo, Scanner sc) {
        System.out.print("Nombre: ");
        CumpleAgenda c = repo.BuscarPorNombre(sc.nextLine());
        if (c != null) System.out.println(c.GetNombre());
    }

    private static void buscarPorDia(Scanner sc, CumpleRepo repo) {
        System.out.print("Día: ");
        int dia = Integer.parseInt(sc.nextLine());
        listar(repo.BuscarPorDia(dia));
    }
}
