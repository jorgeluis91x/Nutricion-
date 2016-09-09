package center.innovus.nutriassist.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import center.innovus.nutriassist.Fragments.ComidasFragment;
import center.innovus.nutriassist.Models.Alimentos;
import center.innovus.nutriassist.Models.Categorias;
import center.innovus.nutriassist.Models.Receta;
import center.innovus.nutriassist.R;

/**
 * Created by personal on 7/09/16.
 */
public class ReporteExpandibleAdapter extends BaseExpandableListAdapter {

    private LayoutInflater inflater;
    private List<Categorias> mParent;
    private ArrayList<ArrayList<Alimentos>> mHijos; // Alumnos por grupo.
    private int itemLayoutPadre;
    private int itemLayoutHijo;
    private Activity activity;

    private Receta receta;


    public ReporteExpandibleAdapter(Activity context, Receta parent, int itemLayoutPadre, int itemLayoutHijo){
        activity = context;
        receta = parent;
        mParent = parent.getCategorias();
        inflater = LayoutInflater.from(context);
        this.itemLayoutHijo = itemLayoutHijo;
        this.itemLayoutPadre = itemLayoutPadre;


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

        if (view == null) {
            view = inflater.inflate(itemLayoutHijo, viewGroup,false);
            childHolder = new ChildHolder();
            childHolder.amountGrams = (TextView) view.findViewById(R.id.amout_grams);
            childHolder.amountPorcion = (TextView) view.findViewById(R.id.amout_porcion);
            childHolder.name = (TextView) view.findViewById(R.id.name_food);
            childHolder.childPosition = childPosition;
            view.setTag(childHolder);


        }else {
            childHolder = (ChildHolder) view.getTag();

        }

        childHolder.name.setText(mParent.get(groupPosition).getAlimentos().get(childPosition).getNombre());
        double cantidadP = mParent.get(groupPosition).getAlimentos().get(childPosition).getPorcionesElegidas();
        if(cantidadP == 1)
            childHolder.amountPorcion.setText("1 Porcion");
        else if (cantidadP == 0.5)
            childHolder.amountPorcion.setText("1/2 Porcion");
        double calculate = mParent.get(groupPosition).getAlimentos().get(childPosition).getCarbohidratos() * mParent.get(groupPosition).getAlimentos().get(childPosition).getPorcionesElegidas();
        childHolder.amountGrams.setText(calculate + " Gr");

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
        TextView amountPorcion;
        TextView amountGrams;
    }
}
