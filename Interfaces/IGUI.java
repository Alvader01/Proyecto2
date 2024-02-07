package Interfaces;

import Model.Entity.Favourite;

public interface IGUI {
    void muestramenuprincipal();
    void muestrafavoritos(Favourite[] f);
    void muestrafavorito(Favourite f);
    Favourite muestraMenuAnadirFavorito();
    Favourite muestraMenuQuitarFavorito();
    void muestraResultado(String resultado);
    int leeEntero(String msg);
    String leeString(String msg);
    Favourite solicitarFavoritoParaActualizar();
    Favourite solicitarDatosActualizados();
    String solicitarCriterioBusqueda();


}
