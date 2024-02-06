package Model.Entity;

public class Song extends Favourite{
    private String artista;

    public Song(String nombre, String pais, int ano, String artista) {
        super(nombre, pais, ano);
        this.artista = artista;
    }

    public Song(String artista) {
       artista ="";
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }
    @Override
    public String toString() {
        return "Artista [artista=" + artista + "]"+super.toString();
    }
    public Song(String nombre, String pais, int ano){
        super(nombre, pais,ano);
    }
}
