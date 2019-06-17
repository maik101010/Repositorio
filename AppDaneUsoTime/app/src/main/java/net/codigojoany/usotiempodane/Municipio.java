package net.codigojoany.usotiempodane;

/**
 * Created by Joany on 22/10/2017.
 */

public class Municipio {
    private int id;
    private String nombre;

    public Municipio(int id, String nombre) {
        this.setId(id);
        this.setNombre(nombre);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
