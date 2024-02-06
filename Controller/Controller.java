package Controller;


import Interfaces.IController;
import Interfaces.IGUI;
import Interfaces.IRepo;
import Model.Entity.Favourite;
import Model.Repo.Library;
import View.GUI;

public class Controller implements IController {
        IGUI gui = (IGUI) new GUI();
        IRepo repo= new Library();

        @Override
        public void empezar() {
            int opcion;
            do {
                gui.muestramenuprincipal();
                opcion = gui.leeEntero("Elige una opción");
                controladorMenuPrincipal(opcion);
            }while(opcion!=4);
            finalizar();
        }

        @Override
        public void controladorMenuPrincipal(int o) {
            switch (o) {
                case 1:
                    gui.muestrafavoritos(repo.muestraFavoritos());
                    break;
                case 2:
                    Favourite f = gui.muestraMenuAnadirFavorito();
                    if (repo.anadirFavorito(f)) {
                        gui.muestraResultado("Favorito añadido");
                    } else {
                        gui.muestraResultado("Error al insertar el favorito");
                    }
                    break;
                case 3:
                    Favourite f2=gui.muestraMenuQuitarFavorito();
                    if(repo.quitarFavorito(f2.getNombre())!=null){
                        gui.muestraResultado("Favorito eliminado");
                    }else{
                        gui.muestraResultado("Error al eliminar");
                    }
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        }

        @Override
        public void finalizar() {
            System.out.println("Adiós");
        }
    }


