package com.cursosalura.starwarsapiswapi.utilidades;

import java.io.FileWriter;
import java.io.IOException;

public class GestorDeArchivo {
    public void escribir(String nombreArchivo, String contenido) throws IOException {
        FileWriter escritura = new FileWriter(nombreArchivo);
        escritura.write(contenido);
        escritura.close();
    }
}
