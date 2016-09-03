package center.innovus.nutriassist.Models;

/**
 * Created by personal on 25/08/16.
 */
public class Reporte {
    private static Reporte instance = new Reporte();

    private Reporte(){}
    public static Reporte getInstance(){
        return instance;

    }
    public Receta receta = new Receta();
}
