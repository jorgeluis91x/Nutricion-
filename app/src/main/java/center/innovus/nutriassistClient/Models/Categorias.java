package center.innovus.nutriassistClient.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by personal on 14/08/16.
 */
public class Categorias implements Parcelable{
    private String nombre;
    private List<Alimentos> alimentos = new ArrayList<Alimentos>();

    public Categorias(){
        alimentos = new ArrayList<Alimentos>();

    }

    public Categorias(String nombre,List<Alimentos> alimentos) {
        this.nombre = nombre;
        this.alimentos = alimentos;
    }

    public Categorias(Parcel in) {
        nombre = in.readString();
        in.readTypedList(alimentos,Alimentos.CREATOR);
        //alimentos = in.createTypedArrayList(Alimentos.CREATOR);
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Alimentos> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimentos> alimentos) {
        this.alimentos = alimentos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);
        parcel.writeTypedList(alimentos);


    }

    public static final Creator<Categorias> CREATOR = new Creator<Categorias>() {
        @Override
        public Categorias createFromParcel(Parcel in) {
            return new Categorias(in);
        }

        @Override
        public Categorias[] newArray(int size) {
            return new Categorias[size];
        }
    };
}
