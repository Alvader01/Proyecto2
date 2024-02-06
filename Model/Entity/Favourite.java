package Model.Entity;

import java.util.Objects;

public class Favourite {
    protected String nombre;
    protected String pais;
    protected int ano;

    public Favourite(String nombre, String pais, int ano) {
        this.nombre = nombre;
        this.pais = pais;
        this.ano = ano;
    }
    public Favourite() {
        this("","",0);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Favourite{" +
                "nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", año=" + ano +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favourite favourite = (Favourite) o;
        return ano == favourite.ano && Objects.equals(nombre, favourite.nombre) && Objects.equals(pais, favourite.pais);
    }

}
