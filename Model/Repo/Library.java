package Model.Repo;

import Interfaces.IRepo;
import Model.Entity.Favourite;

public class Library implements IRepo {
    private Favourite[] favoritos = new Favourite[10];


    @Override
    public Favourite[] muestraFavoritos() {
        return favoritos;
    }

    @Override
    public boolean anadirFavorito(Favourite favorito) {
        boolean result = false;
        if (favorito != null && hayHueco() && !estaFavorito(favorito)) {
            for (int i = 0; i < favoritos.length && !result; i++) {
                if (favoritos[i] == null) {
                    favoritos[i] = favorito;
                    result = true;
                }
            }
        }
        return result;
    }



    @Override
    public Favourite quitarFavorito(String nombre) {
        for (int i = 0; i < favoritos.length; i++) {
            if (favoritos[i] != null && favoritos[i].getNombre().equals(nombre)) {
                Favourite removedFavourite = favoritos[i];
                favoritos[i] = null;
                rearrangeArray();
                return removedFavourite;
            }
        }
        return null;
    }

    @Override
    public Favourite buscarFavorito(String nombre) {
        for (Favourite f : favoritos) {
            if (f != null && f.getNombre().equals(nombre)) {
                return f;
            }
        }
        return null;
    }

    @Override
    public boolean actualizarFavorito(String nombre, Favourite nuevoFavorito) {
        for (int i = 0; i < favoritos.length; i++) {
            if (favoritos[i] != null && favoritos[i].getNombre().equals(nombre)) {
                favoritos[i] = nuevoFavorito;
                return true;
            }
        }
        return false;
    }

    private boolean hayHueco() {
        for (Favourite favorito : favoritos) {
            if (favorito == null) {
                return true;
            }
        }
        return false;
    }

    private boolean estaFavorito(Favourite favorito) {
        for (Favourite f : favoritos) {
            if (f != null && f.equals(favorito)) {
                return true;
            }
        }
        return false;
    }

    private void rearrangeArray() {
        Favourite[] newArray = new Favourite[favoritos.length];
        int newIndex = 0;
        for (Favourite fav : favoritos) {
            if (fav != null) {
                newArray[newIndex++] = fav;
            }
        }
        favoritos = newArray;
    }
}



