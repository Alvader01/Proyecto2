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
            }while(opcion!=6);
            finalizar();
        }

        @Override
        public void controladorMenuPrincipal(int o) {
            switch (o) {
                case 1:
                    // Listar
                    gui.muestrafavoritos(repo.muestraFavoritos());
                    break;
                case 2:
                    // Buscar
                    String criterioBusqueda = gui.solicitarCriterioBusqueda(); // Solicita al usuario el criterio de búsqueda
                    Favourite resultadoBusqueda = repo.buscarFavorito(criterioBusqueda); // Busca el favorito en el repositorio
                    if (resultadoBusqueda != null) {
                        gui.muestraResultado("Favorito encontrado: " + resultadoBusqueda.toString()); // Muestra el favorito encontrado
                    } else {
                        gui.muestraResultado("No se encontró ningún favorito que coincida con el criterio de búsqueda."); // Mensaje de error si no se encuentra ningún favorito
                    }
                    break;
                case 3:
                    // Insertar
                    Favourite favoritoNuevo = gui.muestraMenuAnadirFavorito();
                    if (repo.anadirFavorito(favoritoNuevo)) {
                        gui.muestraResultado("Favorito añadido");
                    } else {
                        gui.muestraResultado("Error al insertar el favorito");
                    }
                    break;
                case 4:
                    // Actualizar
                    Favourite favoritoActualizar = gui.solicitarFavoritoParaActualizar(); // Solicita al usuario el favorito que desea actualizar
                    Favourite nuevoFavorito = gui.solicitarDatosActualizados(); // Solicita al usuario los nuevos datos para el favorito
                    if (repo.actualizarFavorito(favoritoActualizar.getNombre(), nuevoFavorito)) {
                        gui.muestraResultado("Favorito actualizado correctamente");
                    } else {
                        gui.muestraResultado("Error al actualizar el favorito");
                    }
                    // Implementa la lógica de actualización según tus necesidades
                    // Puedes solicitar información adicional a través de la interfaz gráfica (gui)
                    break;
                case 5:
                    // Borrar
                    Favourite favoritoBorrar = gui.muestraMenuQuitarFavorito();
                    if (repo.quitarFavorito(favoritoBorrar.getNombre()) != null) {
                        gui.muestraResultado("Favorito eliminado");
                    } else {
                        gui.muestraResultado("Error al eliminar");
                    }
                    break;
                case 6:
                    // Salir
                    finalizar();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        @Override
        public void finalizar() {
            System.out.println("Adiós");
        }
    }


