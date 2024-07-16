package dev.wlly.challengecambio.main;

import dev.wlly.challengecambio.model.MenuDoUsuario;
import dev.wlly.challengecambio.services.ConversorDeMoedas;

import java.util.Scanner;

public class Principal {
    private static final String API_KEY = "e7e7645b79536f2d968465c8";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConversorDeMoedas conversor = new ConversorDeMoedas(API_KEY);
        MenuDoUsuario menu = new MenuDoUsuario(conversor);

        try {
            while (true) {
                menu.exibirMenu();
                int opcode = Integer.parseInt(sc.nextLine());
                if (opcode == 0) {
                    System.out.println("Até logo.");
                    return;
                }
                menu.escolherOpcao(opcode);
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
