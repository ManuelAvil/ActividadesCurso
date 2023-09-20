package com.methaporce.modelo;

import java.util.ArrayList;
import java.util.List;

public class GestorPelicula {
    private List<Pelicula> peliculas;

    public GestorPelicula() {
        peliculas = new ArrayList<>();
    }

    public void AgregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
    }

    public void EliminarPelicula(int id) {
        peliculas.removeIf(pelicula -> pelicula.getId() == id);
    }

    public List<Pelicula> ObtenerPeliculas() {
        return peliculas;
    }

    public List<Pelicula> ObtenerPeliculasDisponibles() {
        List<Pelicula> disponibles = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.isDisponible()) {
                disponibles.add(pelicula);
            }
        }
        return disponibles;
    }

    public List<Pelicula> ObtenerPeliculasNoDisponibles() {
        List<Pelicula> noDisponibles = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (!pelicula.isDisponible()) {
                noDisponibles.add(pelicula);
            }
        }
        return noDisponibles;
    }

    public void MarcarPeliculaComoDisponible(int id) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getId() == id) {
                pelicula.setDisponible(true);
            }
        }
    }
}