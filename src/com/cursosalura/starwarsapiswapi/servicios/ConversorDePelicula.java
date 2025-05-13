package com.cursosalura.starwarsapiswapi.servicios;

import com.cursosalura.starwarsapiswapi.modelos.Pelicula;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class ConversorDePelicula {
    private final Gson gson;

    public ConversorDePelicula() {
        this.gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();
    }

    public Pelicula convertirDesdeJson(String json) {
        return gson.fromJson(json, Pelicula.class);
    }

    public String convertirListaATextoJson(List<Pelicula> peliculas) {
        return gson.toJson(peliculas);
    }
}
