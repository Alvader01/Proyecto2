package Model.Entity;

public class Game extends Favourite {
    private String plataforma;

    public Game(String nombre, String pais, int ano, String plataforma) {
        super(nombre, pais, ano);
        this.plataforma = plataforma;
    }

    public Game() {
        super();
        plataforma="";
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public String toString() {
        return "Plataforma [plataforma=" + plataforma + "]"+super.toString();
    }
    public Game(String nombre, String pais, int ano){
        super(nombre, pais,ano);
    }
}
