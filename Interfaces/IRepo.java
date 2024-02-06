package Interfaces;

import Model.Entity.Favourite;

public interface IRepo {
    Favourite[] muestraFavoritos();
    boolean anadirFavorito(Favourite f);
    Favourite quitarFavorito(String n);
    Favourite buscarFavorito(String n);
    boolean actualizarFavorito(String n, Favourite nuevoFavorito);
}
