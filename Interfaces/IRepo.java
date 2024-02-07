package Interfaces;

import Model.Entity.Favourite;

public interface IRepo {
    Favourite[] muestraFavoritos();
    boolean anadirFavorito(Favourite favorito);
    Favourite quitarFavorito(String nombre);
    Favourite buscarFavorito(String nombre);
    boolean actualizarFavorito(String nombre, Favourite nuevoFavorito);
}
