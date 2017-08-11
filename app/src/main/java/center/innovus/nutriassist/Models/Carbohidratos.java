package center.innovus.nutriassist.Models;

/**
 * Created by personal on 10/08/17.
 */

public class Carbohidratos {
    String identificacion;
    double carbohidratos;
    String fecha;

    public Carbohidratos(String identificacion, double carbohidratos, String fecha) {
        this.identificacion = identificacion;
        this.carbohidratos = carbohidratos;
    }

    public Carbohidratos(String identificacion, double carbohidratos) {
        this.identificacion = identificacion;
        this.carbohidratos = carbohidratos;
    }

    public Carbohidratos() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }



    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }
}
