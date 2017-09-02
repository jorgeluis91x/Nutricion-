package center.innovus.nutriassistClient.Models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by personal on 24/08/16.
 */
public class Receta implements Parcelable{

    private List<Categorias> categorias = new ArrayList<Categorias>();
    private String tab;

    public Receta(){
        this.categorias = new ArrayList<Categorias>();

    }

    public Receta(Parcel in) {
        tab = in.readString();
        in.readTypedList(categorias,Categorias.CREATOR);
    }


    public List<Categorias> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categorias> categorias) {
        this.categorias = categorias;
    }

    public Receta(List<Categorias> categorias, String tab) {

        this.categorias = categorias;
        this.tab = tab;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.tab);
        parcel.writeTypedList(categorias);

       // parcel.writeArray(this.categorias.toArray());
    }
    public static final Creator<Receta> CREATOR = new Creator<Receta>() {
        @Override
        public Receta createFromParcel(Parcel in) {
            return new Receta(in);
        }

        @Override
        public Receta[] newArray(int size) {
            return new Receta[size];
        }
    };
}
