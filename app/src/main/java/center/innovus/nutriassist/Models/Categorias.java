package center.innovus.nutriassist.Models;

import java.util.ArrayList;

/**
 * Created by personal on 14/08/16.
 */
public class Categorias {
    private String nombre;
    private ArrayList<Alimentos> alimentos;

    public Categorias(){

    }

    public Categorias(String nombre, ArrayList<Alimentos> alimentos) {
        this.nombre = nombre;
        this.alimentos = alimentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Alimentos> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(ArrayList<Alimentos> alimentos) {
        this.alimentos = alimentos;
    }
}
