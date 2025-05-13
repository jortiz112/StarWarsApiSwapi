package com.cursosalura.starwarsapiswapi.principal;

import com.cursosalura.starwarsapiswapi.menu.StarWarsMenu;
import com.cursosalura.starwarsapiswapi.modelos.Pelicula;
import com.cursosalura.starwarsapiswapi.servicios.BuscadorDePeliculas;
import com.cursosalura.starwarsapiswapi.servicios.ConversorDePelicula;
import com.cursosalura.starwarsapiswapi.utilidades.GestorDeArchivo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        List<Pelicula> peliculas = new ArrayList<>();

        var buscador = new BuscadorDePeliculas();
        var conversor = new ConversorDePelicula();
        var gestorArchivo = new GestorDeArchivo();
        var procesador = new StarWarsMenu();

        procesador.ejecutar(teclado, peliculas, buscador, conversor, gestorArchivo);
        teclado.close();
    }
}
