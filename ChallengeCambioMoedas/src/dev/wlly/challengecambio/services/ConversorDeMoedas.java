package dev.wlly.challengecambio.services;

import java.util.Scanner;

public class ConversorDeMoedas {
    private final ConsomeApi consomeApi;

    public ConversorDeMoedas(String apiKey) {
        this.consomeApi = new ConsomeApi(apiKey);
    }

    public void converterMoeda(String paisOrigem, String paisDestino) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Informe o valor em " + paisOrigem + ": ");
            double valor = Double.parseDouble(sc.nextLine());

            double taxa = consomeApi.capturarTaxaDeCambio(paisOrigem, paisDestino);
            double resultado = valor * taxa;
            System.out.println("Valor em " + paisDestino + ": " + resultado + "\n");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
