package center.innovus.nutriassist.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by personal on 14/08/16.
 */
public class Alimentos implements Parcelable {
    private String nombre;
    private int imagen;
    private int cantidad;
    private int proteinas;
    private int grasas;
    private double porcionesElegidas;
    private String pe;
    private int carbohidratos;
    private boolean isSelected;

    public Alimentos(){

    }
    public Alimentos(String nombre,  int cantidad, int proteinas, int grasas, int carbohidratos,int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.cantidad = cantidad;
        this.proteinas = proteinas;
        this.grasas = grasas;
        this.carbohidratos = carbohidratos;
        this.isSelected = false;
        this.porcionesElegidas = 0;
        this.pe = new String("0");

    }

    protected Alimentos(Parcel in) {
        nombre = in.readString();
        imagen = in.readInt();
        pe = in.readString();
        cantidad = in.readInt();
        proteinas = in.readInt();
        grasas = in.readInt();
        carbohidratos = in.readInt();
        porcionesElegidas = in.readDouble();
        isSelected = in.readByte() != 0;



    }

    public static final Creator<Alimentos> CREATOR = new Creator<Alimentos>() {
        @Override
        public Alimentos createFromParcel(Parcel in) {
            return new Alimentos(in);
        }

        @Override
        public Alimentos[] newArray(int size) {
            return new Alimentos[size];
        }
    };

    public double getPorcionesElegidas() {
        return porcionesElegidas;
    }

    public void setPorcionesElegidas(double porcionesElegidas) {
        this.porcionesElegidas = porcionesElegidas;
        this.pe= String.valueOf(porcionesElegidas);
        if(porcionesElegidas == 0) this.isSelected = false;
        else this.isSelected = true;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }




    public void changeSelected(){
        this.isSelected = !this.isSelected;
    }
    public boolean getIsSelected(){
        return this.isSelected;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
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


    public String getPe() {
        return pe;
    }

    public void setPe(String pe) {
        this.pe = pe;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.nombre);
        parcel.writeInt(this.imagen);
        parcel.writeString(this.pe);
        parcel.writeInt(this.cantidad);
        parcel.writeInt(this.proteinas);
        parcel.writeInt(this.grasas);
        parcel.writeInt(this.carbohidratos);
        parcel.writeDouble(this.porcionesElegidas);

        parcel.writeByte((byte) (isSelected?  1 : 0));

    }
}
