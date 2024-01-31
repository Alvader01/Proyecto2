package Interfaces;

import Model.Entity.Favourite;

public interface IRepo {
    Favourite[] muestraFavoritos();
    boolean anadirFavorito(Favourite f);
    Favourite quitarFavorito(String n);
}
