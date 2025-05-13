package com.cursosalura.starwarsapiswapi.menu;

import com.cursosalura.starwarsapiswapi.modelos.Pelicula;
import com.cursosalura.starwarsapiswapi.servicios.BuscadorDePeliculas;
import com.cursosalura.starwarsapiswapi.servicios.ConversorDePelicula;
import com.cursosalura.starwarsapiswapi.utilidades.GestorDeArchivo;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StarWarsMenu {
    public void ejecutar(Scanner teclado,
                         List<Pelicula> peliculas,
                         BuscadorDePeliculas buscador,
                         ConversorDePelicula conversor,
                         GestorDeArchivo gestorArchivo) {

        boolean continuar = true;

        while (continuar) {
            System.out.print("""
                    \n\033[96m█▬▬▬▬\033[32m===\033[95mMenú Star Wars Films\033[32m===\033[96m▬▬▬▬█
                    █▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬█
                    \t\t\033[32m1 - \033[93mA New Hope
                    \t\t\033[32m2 - \033[93mThe Empire Strikes Back
                    \t\t\033[32m3 - \033[93mReturn of the Jedi
                    \t\t\033[32m4 - \033[93mThe Phantom Menace
                    \t\t\033[32m5 - \033[93mAttack of the Clones
                    \t\t\033[32m6 - \033[93mRevenge of the Sith
                    
                    \t\t\033[32m0 - \033[93mSalir
                    \033[96m█▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬█
                    █▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬█
                    """);
            System.out.println("\n\033[95mSeleccione una película del 1 al 6 (0 para salir):");
            System.out.print("\033[91m►► ");
            int busqueda = teclado.nextInt();

            if (busqueda == 0) {
                continuar = false;
                break;
            }
            if (busqueda < 1 || busqueda > 6) {
                System.out.println("Opción inválida. Debe estar entre 1 y 6 o 0 para salir.");
                continue;
            }

            try {
                String json = buscador.buscarJson(busqueda);
                System.out.println("\033[93m" + json);
                Pelicula miPelicula = conversor.convertirDesdeJson(json);
                System.out.println("\033[96mPelícula ya convertida: " + "\033[33m" +miPelicula);
                peliculas.add(miPelicula);
            } catch (NumberFormatException e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }catch (InputMismatchException e) {
                System.out.println("Error, no ha ingresado un número correcto del menú.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error en la URI, verifique la dirección.");
            } catch (IOException | InterruptedException e) {
                System.out.println("Error al realizar la búsqueda: " + e.getMessage());
            }
        }

        try {
            String jsonFinal = conversor.convertirListaATextoJson(peliculas);
            gestorArchivo.escribir("starwars.json", jsonFinal);
            System.out.println("Finalizó la ejecución del programa!");
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

}
