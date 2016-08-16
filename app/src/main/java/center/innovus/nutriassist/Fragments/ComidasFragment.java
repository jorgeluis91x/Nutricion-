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
import center.innovus.nutriassist.R;


public class ComidasFragment extends Fragment {

    private int gramsNotAssigned;
    TextView tvLabel;




    // newInstance constructor for creating fragment with arguments
    public static ComidasFragment newInstance(int page, String title) {
        ComidasFragment fragmentFirst = new ComidasFragment();
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

//      title = getArguments().getString("someTitle");

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comidas, container, false);
        tvLabel = (TextView) view.findViewById(R.id.food_grams_not_assigned);
        tvLabel.setText(getString(R.string.food_grams_not_assigned) + " " + gramsNotAssigned + " gr");

        setSpinnerContent( view );

        return view;

    }

    public void setSpinnerContent (View view){

        ArrayList<Alimentos> alimentos =  new ArrayList<Alimentos>();
        alimentos.add(new Alimentos("Azúcar",4,0,0,4,"Azucar.jpg"));
        alimentos.add(new Alimentos("Azúcar",4,0,0,4,"Azucar.jpg"));
        alimentos.add(new Alimentos("Azúcar",4,0,0,4,"Azucar.jpg"));
        alimentos.add(new Alimentos("Azúcar",4,0,0,4,"Azucar.jpg"));

        ArrayList<Categorias> categorias =new ArrayList<Categorias>();
        categorias.add(new Categorias("Azucares",alimentos));
        categorias.add(new Categorias("Prueba",alimentos));
        categorias.add(new Categorias("Prueba2",alimentos));

        ExpandableListView mExpandableList = (ExpandableListView)view.findViewById(R.id.expandableListView);
        final AlimentosExpandibleAdapter mAdaptador= new AlimentosExpandibleAdapter(getActivity(),categorias,R.layout.row_categoria,R.layout.row_productos);
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




}
