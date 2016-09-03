package center.innovus.nutriassist.Consumir;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ExpandableListView;

import java.util.ArrayList;

import center.innovus.nutriassist.Adapter.AlimentosExpandibleAdapter;
import center.innovus.nutriassist.Models.Alimentos;
import center.innovus.nutriassist.Models.Categorias;
import center.innovus.nutriassist.R;

/**
 * Created by personal on 14/08/16.
 */
public class AlimentosTask extends AsyncTask<Void, Void, ArrayList<Categorias>> {
    private Activity activity;

    public AlimentosTask(Activity activity) {
        super();
        this.activity = activity;

    }


    @Override
    protected ArrayList<Categorias> doInBackground(Void... params) {

        ArrayList<Alimentos> alimentos =  new ArrayList<Alimentos>();
        alimentos.add(new Alimentos("Azúcar",4,0,0,4,"Azucar.jpg"));
        alimentos.add(new Alimentos("Azúcar",4,0,0,4,"Azucar.jpg"));
        alimentos.add(new Alimentos("Azúcar",4,0,0,4,"Azucar.jpg"));
        alimentos.add(new Alimentos("Azúcar",4,0,0,4,"Azucar.jpg"));

        ArrayList<Categorias> categorias =new ArrayList<Categorias>();
        categorias.add(new Categorias("Azucares",alimentos));
        categorias.add(new Categorias("Prueba",alimentos));
        categorias.add(new Categorias("Prueba2",alimentos));



        return categorias;
    }

}
