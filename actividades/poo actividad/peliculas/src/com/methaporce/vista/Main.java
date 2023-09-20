package com.methaporce.vista;

import com.methaporce.modelo.GestorPelicula;
import com.methaporce.modelo.Pelicula;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de películas
        Pelicula pelicula1 = new Pelicula(1, "Pelicula 1", true);
        Pelicula pelicula2 = new Pelicula(2, "Pelicula 2", false);
        Pelicula pelicula3 = new Pelicula(3, "Pelicula 3", false);

        // Crear el gestor de películas
        GestorPelicula gestorPelicula = new GestorPelicula();
        
        // Agregar las películas al gestor
        gestorPelicula.AgregarPelicula(pelicula1);
        gestorPelicula.AgregarPelicula(pelicula2);
        gestorPelicula.AgregarPelicula(pelicula3);

        // Eliminar una película (por ejemplo, la película con ID 2)
        gestorPelicula.EliminarPelicula(2);

        // Marcar una película como disponible (por ejemplo, la película con ID 1)
        gestorPelicula.MarcarPeliculaComoDisponible(1);

        // Mostrar la lista de películas no disponibles
        System.out.println("Películas no disponibles:");
        for (Pelicula pelicula : gestorPelicula.ObtenerPeliculasNoDisponibles()) {
            System.out.println(pelicula.getNombre());
        }
    }
}