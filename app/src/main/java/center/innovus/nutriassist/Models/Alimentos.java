package center.innovus.nutriassist.Models;

/**
 * Created by personal on 14/08/16.
 */
public class Alimentos {
    private String nombre;
    private String imagen;
    private int cantidad;
    private int proteinas;
    private int grasas;
    private int carbohidratos;

    public Alimentos(){

    }
    public Alimentos(String nombre,  int cantidad, int proteinas, int grasas, int carbohidratos,String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.cantidad = cantidad;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.carbohidratos = carbohidratos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    public int getGrasas() {
        return grasas;
    }

    public void setGrasas(int grasas) {
        this.grasas = grasas;
    }

    public int getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(int carbohidratos) {
        this.carbohidratos = carbohidratos;
    }
}
