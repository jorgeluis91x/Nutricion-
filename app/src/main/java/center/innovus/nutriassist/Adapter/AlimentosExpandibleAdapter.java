package center.innovus.nutriassist.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import center.innovus.nutriassist.MainActivity;
import center.innovus.nutriassist.Models.Alimentos;
import center.innovus.nutriassist.Models.Categorias;

import  center.innovus.nutriassist.R;

/**
 * Created by personal on 14/08/16.
 */
public class AlimentosExpandibleAdapter extends BaseExpandableListAdapter {

    private LayoutInflater inflater;
    private ArrayList<Categorias> mParent;
    private ArrayList<ArrayList<Alimentos>> mHijos; // Alumnos por grupo.
    private int itemLayoutPadre;
    private int itemLayoutHijo;
    private Activity activity;


    public AlimentosExpandibleAdapter(Activity context, ArrayList<Categorias> parent, int itemLayoutPadre, int itemLayoutHijo){
        activity = context;
        mParent = parent;
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
        ViewHolder holder = new ViewHolder();
        holder.childPosition = childPosition;
        holder.groupPosition = groupPosition;

        if (view == null) {
            view = inflater.inflate(itemLayoutHijo, viewGroup,false);
        }

        TextView producto = (TextView) view.findViewById(R.id.list_item_text_child);
        producto.setText(mParent.get(groupPosition).getAlimentos().get(childPosition).getNombre());

        ImageView imgGallery =  (ImageView)  view.findViewById(R.id.imgrewards);


        Picasso.with(view.getContext())
                .load(R.drawable.almojabana)
                .error(R.drawable.almojabana)
                .into(imgGallery);

        TextView descripcion = (TextView) view.findViewById(R.id.descProducto);
        /*descripcion.setText("" + mParent.get(groupPosition).getAlimentos().get(childPosition).getCantidad());
        TextView precio = (TextView) view.findViewById(R.id.txtPrecio);

        //fmt formatea para q no halllan ceros despues de un punto en un numero float

        precio.setText("djdj");*/
        //textView.setText(mParent.get(groupPosition).getArrayChildren().get(childPosition));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  View grupo = getGroupView(groupPosition,true,view,viewGroup);

                for( int  j = 0; j< getChildrenCount(groupPosition); j++){
                    boolean isLastChildd = false;
                    if(j == getChildrenCount(groupPosition)-1) isLastChildd = true;

                    getChildView(groupPosition,j, isLastChildd, null, viewGroup).setSelected(false);

                }
                if (view.isSelected()){
                    view.setSelected(false);

                }else{
                    view.setSelected(true);

                }





               // onCreateDialog(activity);
/*
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                // Get the layout inflater
                LayoutInflater inflater = activity.getLayoutInflater();

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(inflater.inflate(R.layout.dialog_comida, null))
                        // Add action buttons
                        .setPositiveButton("Seleccionar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // sign in the user ...
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //LoginDialogFragment.this.getDialog().cancel();
                            }
                        });
                builder.create().show();

*/


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

        view.setTag(holder);

        //return the entire view
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    public Dialog onCreateDialog(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        // Get the layout inflater
        LayoutInflater inflater = activity.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_comida, null))
                // Add action buttons
                .setPositiveButton("Seleccionar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       //LoginDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    public static class ViewHolder {
        int childPosition;
        int groupPosition;
    }
}
