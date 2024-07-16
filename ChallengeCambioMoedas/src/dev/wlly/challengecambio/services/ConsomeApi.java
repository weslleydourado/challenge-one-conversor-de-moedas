package dev.wlly.challengecambio.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConsomeApi {
    private final String API_KEY;

    public ConsomeApi(String apiKey) {
        this.API_KEY = apiKey;
    }

    public double capturarTaxaDeCambio(String paisOrigem, String paisDestino) {
        try {
            String urlApi = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/" + paisOrigem + "/" + paisDestino;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(urlApi))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
            return jsonResponse.get("conversion_rate").getAsDouble();
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível encontrar este câmbio.");
        }
    }
}
