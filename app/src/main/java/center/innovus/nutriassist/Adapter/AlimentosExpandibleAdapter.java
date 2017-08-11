package center.innovus.nutriassist.Adapter;

import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import center.innovus.nutriassist.Activities.ComidasTabs;
import center.innovus.nutriassist.Fragments.ComidasFragment;
import center.innovus.nutriassist.Models.Alimentos;
import center.innovus.nutriassist.Models.Categorias;

import center.innovus.nutriassist.Models.Receta;
import  center.innovus.nutriassist.R;

/**
 * Created by personal on 14/08/16.
 */
public class AlimentosExpandibleAdapter extends BaseExpandableListAdapter {

    private LayoutInflater inflater;
    private List<Categorias> mParent;
    private ArrayList<ArrayList<Alimentos>> mHijos; // Alumnos por grupo.
    private int itemLayoutPadre;
    private int itemLayoutHijo;
    private Activity activity;
    private ComidasTabs comidasTabs;
    private ComidasFragment fragment;
    private Receta receta;



    public AlimentosExpandibleAdapter(Activity context, Receta parent, int itemLayoutPadre, int itemLayoutHijo, ComidasFragment cm){
        activity = context;






        receta = parent;
        mParent = parent.getCategorias();
        inflater = LayoutInflater.from(context);
        this.itemLayoutHijo = itemLayoutHijo;
        this.itemLayoutPadre = itemLayoutPadre;
        this.fragment =cm;


    }


    @Override
    public int getGroupCount() {
        return mParent.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mParent.get(i).getAlimentos().size();
    }

    @Override
    public Object getGroup(int i) {
        return mParent.get(i).getNombre();
    }

    @Override
    public Object getChild(int i, int i1) {
        return mParent.get(i).getAlimentos().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {
        ViewHolder holder = new ViewHolder();
        //   holder.groupPosition = groupPosition;

        if (view == null) {
            view = inflater.inflate(itemLayoutPadre, viewGroup,false);

        }

        TextView textView = (TextView) view.findViewById(R.id.list_item_text_view);
        textView.setText(getGroup(groupPosition).toString());



        view.setTag(holder);

        //return the entire view
        return view;

    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, final boolean isLastChild, View view, final ViewGroup viewGroup) {
        final ChildHolder childHolder;
        /*holder.childPosition = childPosition;
        holder.groupPosition = groupPosition;
*/
        if (view == null) {
            view = inflater.inflate(itemLayoutHijo, viewGroup,false);
            childHolder = new ChildHolder();
            childHolder.descProducto = (TextView) view.findViewById(R.id.descProducto);
            childHolder.spinner = (TextView) view.findViewById(R.id.porcion);
            childHolder.name = (TextView) view.findViewById(R.id.list_item_text_child);
            childHolder.childPosition = childPosition;
            childHolder.linearLayout = (LinearLayout) view.findViewById(R.id.linearselector);
            childHolder.isSelected = mParent.get(groupPosition).getAlimentos().get(childPosition).getIsSelected();
            childHolder.imageView = (ImageView)  view.findViewById(R.id.imgrewards);
            view.setTag(childHolder);

            //view.setSelected(mParent.get(groupPosition).getAlimentos().get(childPosition).getIsSelected());


        }else {
            childHolder = (ChildHolder) view.getTag();

        }

        childHolder.name.setText(mParent.get(groupPosition).getAlimentos().get(childPosition).getNombre());
        childHolder.descProducto.setText(mParent.get(groupPosition).getAlimentos().get(childPosition).getCarbohidratos() + " gramos de CHO por porcion");
        if(mParent.get(groupPosition).getAlimentos().get(childPosition).getIsSelected())childHolder.linearLayout.setBackgroundResource(R.color.colorPrimaryDark);
        else childHolder.linearLayout.setBackgroundResource(R.color.fondo);
        if(mParent.get(groupPosition).getAlimentos().get(childPosition).getPorcionesElegidas()==1)childHolder.spinner.setText("1 Porcion");
        else if (mParent.get(groupPosition).getAlimentos().get(childPosition).getPorcionesElegidas()==0.5)childHolder.spinner.setText("1/2 Porcion");
        else childHolder.spinner.setText("");


        Picasso.with(view.getContext())
                .load(mParent.get(groupPosition).getAlimentos().get(childPosition).getImagen())
                .error(R.drawable.aceite)
                .into(childHolder.imageView);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( final View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                // Get the layout inflater
                LayoutInflater inflater = activity.getLayoutInflater();


                View viewDialogo = inflater.inflate(R.layout.dialog_comida, null);

                final Spinner spinnerCarnes = (Spinner) viewDialogo.findViewById( R.id.spinnerPorciones );
                final ImageView imageDialogo  = (ImageView) viewDialogo.findViewById(R.id.imageDialogo);

                Picasso.with(view.getContext())
                        .load(mParent.get(groupPosition).getAlimentos().get(childPosition).getImagen())
                        .error(R.drawable.aceite)
                        .into(imageDialogo);


                ArrayAdapter<CharSequence> adapterCarnes = ArrayAdapter.createFromResource(
                        viewDialogo.getContext(), R.array.Porciones, R.layout.dropdown_item);
                spinnerCarnes.setAdapter( adapterCarnes );

                double cantPorcionesArreglo = mParent.get(groupPosition).getAlimentos().get(childPosition).getPorcionesElegidas();
                if(cantPorcionesArreglo == 0) spinnerCarnes.setSelection(0);
                else if(cantPorcionesArreglo == 0.5) spinnerCarnes.setSelection(1);
                else spinnerCarnes.setSelection(2);




                TextView tvCalorias= (TextView) viewDialogo.findViewById(R.id.calorias_dialogo);
                TextView tvName= (TextView) viewDialogo.findViewById(R.id.name_dialogo);
                tvName.setText(mParent.get(groupPosition).getAlimentos().get(childPosition).getNombre());
                tvCalorias.setText(mParent.get(groupPosition).getAlimentos().get(childPosition).getCarbohidratos() + " Gramos de CHO por porcion");



                builder.setView(viewDialogo)


                        // Add action buttons
                        .setPositiveButton("Seleccionar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                               // view.setSelected(!view.isSelected());
                                mParent.get(groupPosition).getAlimentos().get(childPosition).changeSelected();


                                view.setSelected(mParent.get(groupPosition).getAlimentos().get(childPosition).getIsSelected());
                                ChildHolder chi = (ChildHolder) view.getTag();

                                String elementoSpinner = spinnerCarnes.getSelectedItem().toString();
                                double elegidoSpinner = 0;
                                if(elementoSpinner.equals("1 Porcion")) {
                                    elegidoSpinner = 1;
                                    chi.linearLayout.setBackgroundResource(R.color.colorPrimaryDark);
                                }else if (elementoSpinner.equals("1/2 Porcion")) {
                                    elegidoSpinner = 0.5;
                                    chi.linearLayout.setBackgroundResource(R.color.colorPrimaryDark);
                                }else{
                                    chi.linearLayout.setBackgroundResource(R.color.fondo);
                                    elementoSpinner = "";

                                }

                                fragment.sentGramos(mParent.get(groupPosition).getAlimentos().get(childPosition).getCarbohidratos(),mParent.get(groupPosition).getAlimentos().get(childPosition).getPorcionesElegidas(),elegidoSpinner);
                                fragment.setReceta(receta);
                                mParent.get(groupPosition).getAlimentos().get(childPosition).setPorcionesElegidas(elegidoSpinner);
                                chi.spinner.setText(elementoSpinner);
                                view.setTag(chi);



                                // sign in the user ...
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //LoginDialogFragment.this.getDialog().cancel();
                            }
                        });
                builder.create().show();




               /* Intent i = new Intent (view.getContext(), MainActivity.class);

                //pasar variables a la otra actividad
                i.putExtra("nombre",  mParent.get(groupPosition).getArrayChildren().get(childPosition).getNombreProducto() );
                i.putExtra("descripcion",  mParent.get(groupPosition).getArrayChildren().get(childPosition).getDescripcionProducto() );
                i.putExtra("precio", mParent.get(groupPosition).getArrayChildren().get(childPosition).getPrecioProducto().toString() );
                i.putExtra("websafeKeyProducto",  mParent.get(groupPosition).getArrayChildren().get(childPosition).getWebsafeKey() );



                // i.putExtra("nombre", propiedades.getNombre());
                view.getContext().startActivity(i);

                // Intent i = new Inten*/

                 //Toast.makeText(view.getContext(), mParent.get(groupPosition).getAlimentos().get(childPosition).getNombre() , Toast.LENGTH_SHORT).show();
            }
        });

        //view.setTag(holder);

        //return the entire view
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public Receta getReceta(){
        return receta;
    }



    public static class ViewHolder {
       // int childPosition;
        int groupPosition;
    }
    public static class ChildHolder{
        int childPosition;
        TextView name;
        boolean isSelected;
        LinearLayout linearLayout;
        TextView spinner;
        TextView descProducto;
        ImageView imageView;
    }
}
