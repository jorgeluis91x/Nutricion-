package center.innovus.nutriassistClient.Fragments;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.Iterator;

import center.innovus.nutriassistClient.Adapter.ReporteExpandibleAdapter;
import center.innovus.nutriassistClient.Models.Alimentos;
import center.innovus.nutriassistClient.Models.Categorias;
import center.innovus.nutriassistClient.Models.Receta;
import center.innovus.nutriassistClient.R;

/**
 * Created by personal on 7/09/16.
 */
public class ReportesFragment extends Fragment {



    private Receta receta;
    private double totalC;
    TextView tvLabel;

    // newInstance constructor for creating fragment with arguments
    public static ReportesFragment newInstance(String title,Receta receta) {
        ReportesFragment  fragmentFirst = new ReportesFragment();
        Bundle args = new Bundle();
        args.putString("someTitle", title);
        args.putParcelable("array",receta);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        receta = getArguments().getParcelable("array");


        Iterator categorias = receta.getCategorias().iterator();

            //reccorre categorias
            while(categorias.hasNext()){

                Categorias categoria = (Categorias) categorias.next();
                Iterator alimentos = categoria.getAlimentos().iterator();

                while(alimentos.hasNext()){
                    Alimentos alimento = (Alimentos) alimentos.next();
                    totalC = totalC + (alimento.getCarbohidratos() * alimento.getPorcionesElegidas());
                }

            }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reporte, container, false);
        return view;


    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        tvLabel = (TextView) view.findViewById(R.id.amountc);
        tvLabel.setText(totalC +" gr");

        setSpinnerContent( view );

    }
    public void setSpinnerContent (View view) {

        ExpandableListView mExpandableList = (ExpandableListView) view.findViewById(R.id.expandableListViewReporte);
        final ReporteExpandibleAdapter mAdaptador = new ReporteExpandibleAdapter(getActivity(), receta, R.layout.row_categoria, R.layout.row_reporte_productos);
        mExpandableList.setAdapter(mAdaptador);

    }




}
