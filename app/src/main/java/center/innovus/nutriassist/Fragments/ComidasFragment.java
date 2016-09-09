package center.innovus.nutriassist.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;

import center.innovus.nutriassist.Adapter.AlimentosExpandibleAdapter;
import center.innovus.nutriassist.Consumir.AlimentosTask;
import center.innovus.nutriassist.Models.Alimentos;
import center.innovus.nutriassist.Models.Categorias;
import center.innovus.nutriassist.Models.Receta;
import center.innovus.nutriassist.R;


public class ComidasFragment extends Fragment {

    private double gramsNotAssigned;
    TextView tvLabel;
    private ArrayList<Alimentos> alimentos;
    private ArrayList<Alimentos> alimentos1;
    private ArrayList<Alimentos> alimentos2;

    private ArrayList<Alimentos> alimentos4;
    private ArrayList<Categorias> categorias;
    private String comida;
    private Receta receta;






    // newInstance constructor for creating fragment with arguments
    public static ComidasFragment newInstance(int page, String title) {
        ComidasFragment  fragmentFirst = new ComidasFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        gramsNotAssigned = getArguments().getInt("someInt", 0);
        comida = getArguments().getString("someTitle");

        alimentos =  new ArrayList<Alimentos>();
        alimentos.add(new Alimentos("Azucar",4,0,0,2,R.drawable.azucar));
        alimentos.add(new Alimentos("Chocolate amargo",20,2,11,5,R.drawable.chocolate));
        alimentos.add(new Alimentos("Miel de abejas",4,0,0,3,R.drawable.miel));
      //  alimentos.add(new Alimentos("Panela",20,0,0,16,R.drawable.panintegral2));

        //
        alimentos1 =  new ArrayList<Alimentos>();
        alimentos1.add(new Alimentos("Banano",48,1,0,9,R.drawable.banano));
        alimentos1.add(new Alimentos("Ciruela",4,0,0,11,R.drawable.ciruela));
        alimentos1.add(new Alimentos("Curuba",4,0,0,12,R.drawable.curuba));
        alimentos1.add(new Alimentos("Durazno",4,0,0,11,R.drawable.durazno));
        alimentos1.add(new Alimentos("Feijoa",4,0,0,12,R.drawable.feijoa));
        alimentos1.add(new Alimentos("Fresa",4,0,0,7,R.drawable.fresa));
        //

        categorias =new ArrayList<Categorias>();
        categorias.add(new Categorias("Azucares",alimentos));

        categorias.add(new Categorias("Frutas",alimentos1));

        alimentos2 =  new ArrayList<Alimentos>();
        alimentos2.add(new Alimentos("Acelga",4,0,0,5,R.drawable.acelga));
        alimentos2.add(new Alimentos("Apio",4,0,0,5,R.drawable.apio));
        alimentos2.add(new Alimentos("Auyama",4,0,0,8,R.drawable.auyama));
        alimentos2.add(new Alimentos("Berenjena",4,0,0,7,R.drawable.berenjena));
        alimentos2.add(new Alimentos("Brocoli",4,0,0,6,R.drawable.brocoli));
        alimentos2.add(new Alimentos("Cebolla cabezona",4,0,0,8,R.drawable.cebollacabezona));
        categorias.add(new Categorias("Verduras",alimentos2));

        alimentos2 =  new ArrayList<Alimentos>();
        alimentos2.add(new Alimentos("Atun",4,0,0,5,R.drawable.atun));
        alimentos2.add(new Alimentos("Camaron",4,0,0,5,R.drawable.camaron));
        alimentos2.add(new Alimentos("Carne de cerdo",4,0,0,8,R.drawable.carnedecerdo));
       // alimentos2.add(new Alimentos("Carne de gallina",4,0,0,7,"carnedegallina.jpg"));
        //alimentos2.add(new Alimentos("Carne de pavo",4,0,0,6,"carnedepavo.jpg"));
        alimentos2.add(new Alimentos("Carne de pollo",4,0,0,8,R.drawable.pollo));
        categorias.add(new Categorias("Carnes",alimentos2));


        ArrayList<Categorias>  categorias2 = categorias;
        receta = new Receta(categorias2,comida);



//      title = getArguments().getString("someTitle");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comidas, container, false);
        return view;


    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        tvLabel = (TextView) view.findViewById(R.id.food_grams_not_assigned);
        tvLabel.setText(getString(R.string.food_grams_not_assigned) + " " + gramsNotAssigned + " gr");

        setSpinnerContent( view );

    }
    public void setSpinnerContent (View view){

        ExpandableListView mExpandableList = (ExpandableListView)view.findViewById(R.id.expandableListView);
        final AlimentosExpandibleAdapter mAdaptador= new AlimentosExpandibleAdapter(getActivity(),receta,R.layout.row_categoria,R.layout.row_productos, this);
        mExpandableList.setAdapter(mAdaptador);

    }

    /*

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<Alimentos> alimentos =  new ArrayList<Alimentos>();
        alimentos.add(new Alimentos("Azúcar",4,0,0,4,"Azucar.jpg"));
        alimentos.add(new Alimentos("Azúcar",4,0,0,4,"Azucar.jpg"));
        alimentos.add(new Alimentos("Azúcar",4,0,0,4,"Azucar.jpg"));
        alimentos.add(new Alimentos("Azúcar",4,0,0,4,"Azucar.jpg"));

        ArrayList<Categorias> categorias =new ArrayList<Categorias>();
        categorias.add(new Categorias("Azucares",alimentos));
        categorias.add(new Categorias("Prueba",alimentos));
        categorias.add(new Categorias("Prueba2",alimentos));

        ExpandableListView mExpandableList = (ExpandableListView)getActivity().findViewById(R.id.expandableListView);
        final AlimentosExpandibleAdapter mAdaptador= new AlimentosExpandibleAdapter(getActivity(),categorias,R.layout.row_categoria,R.layout.row_productos);
        mExpandableList.setAdapter(mAdaptador);

    }
*/

   /* public void setPorcion(int gramos){

        gramsNotAssigned = gramsNotAssigned - gramos;
        tvLabel.setText(getString(R.string.food_grams_not_assigned) + " " + gramsNotAssigned + " gr");


    }
*/
    public void setPorcion(double gramos,double spinnerAntes, double spinnerDespues){

        double diferencia = spinnerAntes - spinnerDespues;
        gramsNotAssigned = gramsNotAssigned + (diferencia*gramos);
        tvLabel.setText(getString(R.string.food_grams_not_assigned) + " " + gramsNotAssigned + " gr");

    }

    public void setReceta(Receta receta){
        this.receta = receta;

    }
    public Receta getReceta(){
        return this.receta;
    }
    /*
    public interface OnGetData {
        // This can be any number of events to be sent to the activity
        public void onRssItemSelected(String link);
    }
    public Arra ponerBusqueda(){
        this.busqueda = busqueda;

        ((EmpresasAdapter) recyclerView.getAdapter()).setFilter(busqueda);
        //Toast.makeText(getActivity(), busqueda, Toast.LENGTH_LONG).show();
    }
*/

}
