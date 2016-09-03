package center.innovus.nutriassist.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import center.innovus.nutriassist.Models.Alimentos;
import center.innovus.nutriassist.Models.Categorias;
import center.innovus.nutriassist.Models.Receta;
import center.innovus.nutriassist.R;

public class ReporteActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);


      // Alimentos object = getIntent().getExtras().getParcelable("parcel");
        Receta object0 = getIntent().getExtras().getParcelable("parcel0");
        Receta object1 = getIntent().getExtras().getParcelable("parcel1");
        Receta object2 = getIntent().getExtras().getParcelable("parcel2");
        Receta object3 = getIntent().getExtras().getParcelable("parcel3");
        Receta object4 = getIntent().getExtras().getParcelable("parcel4");
        Receta object5 = getIntent().getExtras().getParcelable("parcel5");

        ArrayList<Receta> recetas = new ArrayList<Receta>();
        //agrego recetas q traigo
        addReceta(recetas,object0);
        addReceta(recetas,object1);
        addReceta(recetas,object2);
        addReceta(recetas,object3);
        addReceta(recetas,object4);
        addReceta(recetas,object5);

        addReceta(recetas,object0);






        /*
    //elmina elementos no validos
        Iterator recetas = recetasFinal.iterator();
        //recorre recetas
        while(recetas.hasNext()){


            Receta receta = (Receta) recetas.next();
            Iterator categorias = receta.getCategorias().iterator();

            //reccorre categorias
            while(categorias.hasNext()){

                Categorias categoria = (Categorias) categorias.next();
                Iterator alimentos = categoria.getAlimentos().iterator();

                while(alimentos.hasNext()){
                    Alimentos alimento = (Alimentos) alimentos.next();

                    if(!alimento.getIsSelected()) alimentos.remove();

                }

            }


        }

        //        Iterator recetas = recetasFinal.iterator();
        //recorre recetas para eliminar categorias vacios
        recetas = recetasFinal.iterator();
        while(recetas.hasNext()){
            Receta receta = (Receta) recetas.next();
            Iterator categorias = receta.getCategorias().iterator();

            //reccorre categorias
            while(categorias.hasNext()){

                Categorias categoria = (Categorias) categorias.next();
                if(categoria.getAlimentos().size() == 0){
                    categorias.remove();
                }

            }


        }

        recetas = recetasFinal.iterator();
        while(recetas.hasNext()){

            Receta receta = (Receta) recetas.next();

            if(receta.getCategorias().size() == 0){
                recetas.remove();
            }

        }
*/

       // Receta prueba4 = object;
        //ArrayList<Receta> recetas =  (ArrayList<Receta>) getIntent().getSerializableExtra("recetas");
       // ArrayList<Receta> prueba2 = recetas;
        //) prueba2.add(new Receta());

    }

    public ArrayList<Receta> addReceta(ArrayList<Receta> recetas,Receta receta){
        if(receta !=null) recetas.add(receta);
        return recetas;

    }
}
