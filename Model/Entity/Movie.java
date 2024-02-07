package Model.Entity;

public class Movie extends Favourite {
    private int minutos;

    public Movie(String nombre, String pais, int ano, int minutos) {
        super(nombre, pais, ano);
        this.minutos = minutos;
    }

    public Movie() {
        super();
        minutos = 0;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    @Override
    public String toString() {
        return "Pelicula [minutos=" + minutos + "]"+super.toString();
    }
    public Movie(String nombre, String pais, int ano){
        super(nombre, pais,ano);
    }
}
