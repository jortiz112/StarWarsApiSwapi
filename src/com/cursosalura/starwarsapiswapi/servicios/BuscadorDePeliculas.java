package com.cursosalura.starwarsapiswapi.servicios;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class BuscadorDePeliculas {
    public String buscarJson(int titulo) throws IOException, InterruptedException{
        var busquedaCodificada = URLEncoder.encode(String.valueOf(titulo), StandardCharsets.UTF_8);
        String direccion = "https://swapi.py4e.com/api/films/" + busquedaCodificada + "/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
