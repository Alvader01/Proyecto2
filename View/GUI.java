package View;

import Interfaces.IGUI;
import Model.Entity.Favourite;
import Model.Entity.Game;
import Model.Entity.Movie;
import Model.Entity.Song;

import java.util.Scanner;

public class GUI implements IGUI {
    @Override
    public void muestramenuprincipal() {
        System.out.println("Menu principal");
        System.out.println("1. Listar");
        System.out.println("2. Buscar");
        System.out.println("3. Insertar");
        System.out.println("4. Actualizar");
        System.out.println("5. Borrar");
        System.out.println("6. Salir");

    }

    @Override
    public void muestrafavoritos(Favourite[] f) {
        System.out.println("****** Favoritos ******");
        for (Favourite favourite : f) {
            muestrafavorito(favourite);
        }
        System.out.println("**************************");
    }

    @Override
    public void muestrafavorito(Favourite f) {
        if (f != null) {
            System.out.println("****************");
            System.out.println(f);
            System.out.println("****************");
        } else {
            System.out.println("Hueco en la library");
        }
    }


    @Override
    public Favourite muestraMenuAnadirFavorito() {
        Favourite result;
        System.out.println("¿Qué quieres añadir a favoritos?");
        System.out.println("1. Game");
        System.out.println("2. Movie");
        System.out.println("3. Song");
        int opcion = leeEntero("Inserta una opción");

        switch (opcion) {
            case 1:
                result = new Game();
                break;
            case 2:
                result = new Movie();
                break;
            case 3:
                result = new Song();
                break;
            default:
                throw new IllegalArgumentException("Opción no válida");
        }

        result.setNombre(leeString("Inserta el nombre "));
        result.setPais(leeString("Inserta el pais "));
        result.setAno(leeEntero("Inserta el año "));

        if (opcion == 1) {
            ((Game) result).setPlataforma(leeString("Inserta la plataforma del juego"));
        } else if (opcion == 2) {
            ((Movie) result).setMinutos(leeEntero("Inserta los minutos de la película"));
        } else {
            ((Song) result).setArtista(leeString("Inserta el artista de la canción"));
        }

        return result;
    }

    @Override
    public Favourite muestraMenuQuitarFavorito() {
        String nombre = leeString("Inserte el nombre de la bebida que desea quitar");
        Favourite result = new Favourite();
        result.setNombre(nombre);
        return result;
    }

    @Override
    public void muestraResultado(String resultado) {
        System.out.println("****************************");
        System.out.println(resultado);
        System.out.println("****************************");
    }

    @Override
    public int leeEntero(String msg) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(msg+": ");
        return teclado.nextInt();
    }

    @Override
    public String leeString(String msg) {
        Scanner teclado = new Scanner(System.in);
        System.out.println(msg+": ");
        return teclado.nextLine();
    }

    @Override
    public Favourite solicitarFavoritoParaActualizar() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre del favorito que desea actualizar:");
        String nombre = teclado.nextLine();

        System.out.println("Ingrese el país :");
        String pais = teclado.nextLine();

        System.out.println("Ingrese el año :");
        int año = teclado.nextInt();
        teclado.nextLine(); // Consumir la nueva línea después de nextInt

        return new Favourite(nombre, pais, año);
    }

    @Override
    public Favourite solicitarDatosActualizados() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("¿Qué tipo es el favorito?");
        System.out.println("1. Game");
        System.out.println("2. Movie");
        System.out.println("3. Song");
        int opcion = leeEntero("Inserta una opción");

        Favourite result;

        switch (opcion) {
            case 1:
                result = new Game();
                ((Game) result).setPlataforma(leeString("Inserta la nueva plataforma del juego"));
                break;
            case 2:
                result = new Movie();
                ((Movie) result).setMinutos(leeEntero("Inserta los nuevos minutos de la película"));
                break;
            case 3:
                result = new Song();
                ((Song) result).setArtista(leeString("Inserta el nuevo artista de la canción"));
                break;
            default:
                throw new IllegalArgumentException("Opción no válida");
        }

        result.setNombre(leeString("Inserta el nuevo nombre"));
        result.setPais(leeString("Inserta el nuevo país"));
        result.setAno(leeEntero("Inserta el nuevo año"));

        return result;
    }

}

