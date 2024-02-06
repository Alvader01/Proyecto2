package Model.Repo;

import Interfaces.IRepo;
import Model.Entity.Favourite;

public class Library implements IRepo {
    private Favourite[] favoritos = new Favourite[10];


    @Override
    public Favourite[] muestraFavoritos() {
        return new Favourite[0];
    }

    @Override
    public boolean anadirFavorito(Favourite f) {
        return false;
    }

    @Override
    public Favourite quitarFavorito(String n) {
        return null;
    }

    @Override
    public Favourite buscarFavorito(String n) {
        return null;
    }

    @Override
    public boolean actualizarFavorito(String n, Favourite nuevoFavorito) {
        return false;
    }


}


