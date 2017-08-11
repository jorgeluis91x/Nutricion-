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


    public ComidaSeleccionadaListener mCallback;

    // Container Activity must implement this interface
    public interface ComidaSeleccionadaListener {
       // public void OnComidaSeleccionada(int position);
        public void onFragmentInteraction(double gramos,double spinnerAntes, double spinnerDespues);

       // public void setPorcion(double gramos,double spinnerAntes, double spinnerDespues);
    }

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

        alimentos.add(new Alimentos("Chocolate con azucar",20,1,3,5,R.drawable.chocolate));

        alimentos.add(new Alimentos("Miel de abejas",4,0,0,3,R.drawable.miel));

        alimentos.add(new Alimentos("Panela",20,0,0,16,R.drawable.panela));

        categorias =new ArrayList<Categorias>();
        categorias.add(new Categorias("Azucares",alimentos));

        alimentos =  new ArrayList<Alimentos>();
        alimentos.add(new Alimentos("Atun" ,56,9,11,1,R.drawable.atun));
        alimentos.add(new Alimentos("Camaron",138,32,1,0,R.drawable.camaron));
        alimentos.add(new Alimentos("Carne de cerdo",81,16,10,2,R.drawable.carnedecerdo));
       // alimentos.add(new Alimentos("Carne de gallina",50,9,13,0,R.drawable.pollo));
        alimentos.add(new Alimentos("Carne de pavo",84,17,7,0,R.drawable.pollo));
        alimentos.add(new Alimentos("Carne de pollo",84,15,13,0,R.drawable.pollo));
        alimentos.add(new Alimentos("Carne de res",100,22,7,0,R.drawable.carnederes));
        alimentos.add(new Alimentos("Carne molida",100,19,8,0,R.drawable.carnemolida));
        alimentos.add(new Alimentos("Chunchullo de res",68,7,13,0,R.drawable.chunchullo));
        alimentos.add(new Alimentos("Higado de Res",110,29,6,6,R.drawable.higadoderes));
        alimentos.add(new Alimentos("Huevo de gallina",50,6,6,0,R.drawable.huevo));
        alimentos.add(new Alimentos("Menudencias de pollo",95,19,7,2,R.drawable.menudenciasdepollo));
        alimentos.add(new Alimentos("Pajarilla de res",136,26,4,0,R.drawable.pajarilla));
        alimentos.add(new Alimentos("Pescado de mar",150,31,2,0,R.drawable.pescado));
        alimentos.add(new Alimentos("Pescado de rÌo",148,26,4,0,R.drawable.pescado));
        alimentos.add(new Alimentos("Sardinas ",69,12,10,1,R.drawable.sardinas));


        categorias.add(new Categorias("Carnes",alimentos));
        alimentos =  new ArrayList<Alimentos>();
        alimentos.add(new Alimentos("Arroz integral",40,3,0,31,R.drawable.arrozintegral));
        alimentos.add(new Alimentos("Avena",40,4,2,28,R.drawable.avena));
        alimentos.add(new Alimentos("Cebada perlada",40,3,0,31,R.drawable.cebadaperlada));
        alimentos.add(new Alimentos("Cuchuco de cebada",40,3,0,32,R.drawable.cuchucodecebada));
        alimentos.add(new Alimentos("Cuchuco de Maiz",40,5,0,30,R.drawable.cuchucodemaiz));
        alimentos.add(new Alimentos("Harina de maíz amarillo",42,4,2,31,R.drawable.harinademaiz));
        alimentos.add(new Alimentos("Pasta",40,5,0,31,R.drawable.pasta));
        categorias.add(new Categorias("Cereal",alimentos));


        alimentos =  new ArrayList<Alimentos>();
        alimentos.add(new Alimentos("Almojábana" ,48,6,6,15,R.drawable.almojabana));
        alimentos.add(new Alimentos("Arepa de maíz amarillo",100,7,1,29,R.drawable.arepa));
        alimentos.add(new Alimentos("Corn Flakes",38,3,0,32,R.drawable.cornflakes));
        alimentos.add(new Alimentos("Galleta de soda" ,32,3,2,25,R.drawable.galletasdesoda));
        alimentos.add(new Alimentos("Pan de yuca",40,6,5,18,R.drawable.pandeyuca));
        alimentos.add(new Alimentos("Pan francés" ,42,4,0,25,R.drawable.panfrances));
        alimentos.add(new Alimentos("Pan integral",56,4,1,30,R.drawable.panintegral));
        alimentos.add(new Alimentos("Pan mogolla",46,3,1,30,R.drawable.mogolla));
        alimentos.add(new Alimentos("Ponqué",40,2,8,18,R.drawable.ponque));
        alimentos.add(new Alimentos("Tostadas o calados",36,4,1,28,R.drawable.calado));
        categorias.add(new Categorias("Derivados de cereal",alimentos));

        alimentos =  new ArrayList<Alimentos>();
        alimentos.add(new Alimentos("Banano",48,1,0,9,R.drawable.banano));
        alimentos.add(new Alimentos("Ciruela" ,100,1,0,11,R.drawable.ciruela));
        alimentos.add(new Alimentos("Curuba" ,160,1,0,12,R.drawable.curuba));
        alimentos.add(new Alimentos("Durazno",83,1,0,11,R.drawable.durazno));
        alimentos.add(new Alimentos("Feijoa",100,1,0,12,R.drawable.feijoa));
        alimentos.add(new Alimentos("Fresa",160,1,0,7,R.drawable.fresa));
        alimentos.add(new Alimentos("Granadilla",87,2,2,9,R.drawable.granadilla));
        alimentos.add(new Alimentos("Guanábana",77,1,0,10,R.drawable.guanabana));
        alimentos.add(new Alimentos("Guayaba" ,111,1,0,11,R.drawable.guayabarosada));
        alimentos.add(new Alimentos("Lulo",174,1,0,10,R.drawable.lulo));
        alimentos.add(new Alimentos("Mandarina" ,105,1,0,10,R.drawable.mandarina));
        alimentos.add(new Alimentos("Mango" ,69,0,0,11,R.drawable.mango));
        alimentos.add(new Alimentos("Manzana",70,0,0,12,R.drawable.manzana));
        alimentos.add(new Alimentos("Maracuyá",82,1,0,10,R.drawable.maracuya));
        alimentos.add(new Alimentos("Mora",150,1,0,10,R.drawable.mora));
        alimentos.add(new Alimentos("Naranja" ,100,1,0,12,R.drawable.naranja));
        alimentos.add(new Alimentos("Papaya" ,133,1,0,12,R.drawable.papaya));
        alimentos.add(new Alimentos("Pera",110,0,0,12,R.drawable.pera));
        alimentos.add(new Alimentos("Piña",78,0,0,11,R.drawable.pina));
        alimentos.add(new Alimentos("Pitahaya" ,80,0,0,11,R.drawable.pitahaya));
        alimentos.add(new Alimentos("Tomate de árbol" ,100,2,0,12,R.drawable.tomatedearbol));
        alimentos.add(new Alimentos("Uchuva",82,1,0,10,R.drawable.uchuva));
        alimentos.add(new Alimentos("Uva ",120,1,0,10,R.drawable.uva));
        categorias.add(new Categorias("Frutas",alimentos));

        alimentos =  new ArrayList<Alimentos>();
        alimentos.add(new Alimentos("Aceite vegetal",5,0,5,0,R.drawable.aceite));
        alimentos.add(new Alimentos("Mantequilla" ,6,0,5,0,R.drawable.mantequillaymargarina));
        categorias.add(new Categorias("Grasas",alimentos));

        alimentos =  new ArrayList<Alimentos>();
        alimentos.add(new Alimentos("Cuajada",40,6,8,2,R.drawable.cuajada));
        alimentos.add(new Alimentos("Kumis" ,100,4,2,13,R.drawable.kumis2));
        alimentos.add(new Alimentos("Leche entera",240,8,7,8,R.drawable.leche));
        alimentos.add(new Alimentos("Queso Campesino",40,7,7,2,R.drawable.quesocampesino));
        alimentos.add(new Alimentos("Queso Doblecrema",40,9,9,1,R.drawable.quesomozarella));
        alimentos.add(new Alimentos("Yogurt",100,3,3,15,R.drawable.yogurt));
        categorias.add(new Categorias("Lacteos",alimentos));

        alimentos =  new ArrayList<Alimentos>();
        alimentos.add(new Alimentos("Arveja Verde Seca" ,30,2,0,5,R.drawable.arvejas));
        alimentos.add(new Alimentos("Frijol" ,30,3,0,8,R.drawable.frijol));
        alimentos.add(new Alimentos("Garbanzo" ,30,2,0,3,R.drawable.garbanzos));
        alimentos.add(new Alimentos("Lenteja",30,2,0,2,R.drawable.lentejas));
        categorias.add(new Categorias("Leguiminosas",alimentos));

        alimentos =  new ArrayList<Alimentos>();
        alimentos.add(new Alimentos("Papa común, con cáscara",130,2,0,26,R.drawable.papacomun));
        alimentos.add(new Alimentos("Papa criolla, con cáscara",130,3,0,28,R.drawable.papacriolla));
        alimentos.add(new Alimentos("Plátano colí",110,2,0,33,R.drawable.platanocoli));
        alimentos.add(new Alimentos("Plátano hartón maduro",80,1,0,30,R.drawable.platanomaduro));
        alimentos.add(new Alimentos("Plátano hartón verde",80,1,0,31,R.drawable.platanoverde));
        alimentos.add(new Alimentos("Yuca ",80,1,0,30,R.drawable.yuca));
        categorias.add(new Categorias("Tuberculos, raices y platanos",alimentos));

        alimentos =  new ArrayList<Alimentos>();
        alimentos.add(new Alimentos("Acelga",100,2,0,4,R.drawable.acelga));
        alimentos.add(new Alimentos("Apio",100,1,0,5,R.drawable.apio));
        alimentos.add(new Alimentos("Auyama",90,1,0,8,R.drawable.auyama));
        alimentos.add(new Alimentos("Berenjena",100,1,0,7,R.drawable.berenjena));
        alimentos.add(new Alimentos("Brócoli",100,4,0,6,R.drawable.brocoli));
        alimentos.add(new Alimentos("Cebolla cabezona",100,1,0,8,R.drawable.cebollacabezona));
        alimentos.add(new Alimentos("Champiñón",100,4,1,3,R.drawable.champinones));
        alimentos.add(new Alimentos("Coliflor",120,2,0,6,R.drawable.coliflor));
        alimentos.add(new Alimentos("Espinaca" ,100,3,0,2,R.drawable.espinaca));
        alimentos.add(new Alimentos("Habichuela",100,2,0,2,R.drawable.habichuela));
        alimentos.add(new Alimentos("Lechuga" ,100,1,0,3,R.drawable.lechuga));
        alimentos.add(new Alimentos("Pepino de rellenar",100,1,1,3,R.drawable.pepinoguiso));
        alimentos.add(new Alimentos("Rábano" ,100,1,0,4,R.drawable.rabano));
        alimentos.add(new Alimentos("Tomate",120,1,0,4,R.drawable.tomate));
        alimentos.add(new Alimentos("Zanahoria",90,1,0,9,R.drawable.zanahoria));
        categorias.add(new Categorias("Verduras",alimentos));


        ArrayList<Categorias>  categorias2 = categorias;
        receta = new Receta(categorias2,comida);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (ComidaSeleccionadaListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
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

        setSpinnerContent( view );

    }
    public void setSpinnerContent (View view){

        ExpandableListView mExpandableList = (ExpandableListView)view.findViewById(R.id.expandableListView);
        final AlimentosExpandibleAdapter mAdaptador= new AlimentosExpandibleAdapter(getActivity(),receta,R.layout.row_categoria,R.layout.row_productos, this);
        mExpandableList.setAdapter(mAdaptador);

    }

     public void sentGramos(double gramos,double spinnerAntes, double spinnerDespues){
         mCallback.onFragmentInteraction(gramos,spinnerAntes,spinnerDespues);
     }

    public void setReceta(Receta receta){
        this.receta = receta;

    }
    public Receta getReceta(){
        return this.receta;
    }


}
