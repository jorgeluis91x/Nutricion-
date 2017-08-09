package center.innovus.nutriassist.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.Iterator;


import center.innovus.nutriassist.Fragments.ReportesFragment;
import center.innovus.nutriassist.MainActivity;
import center.innovus.nutriassist.Models.Alimentos;
import center.innovus.nutriassist.Models.Categorias;
import center.innovus.nutriassist.Models.Receta;
import center.innovus.nutriassist.Models.Reporte;
import center.innovus.nutriassist.R;

public class ReporteActivity extends AppCompatActivity {
    MyPagerAdapter adapterViewPager;
    int dummyInt;


    private ArrayList<ReportesFragment> reportesFragments = new ArrayList<ReportesFragment>();


    @Override
    public void onBackPressed() {
        return;
    }
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









    //elmina elementos no validos
        Iterator recetasIterator = recetas.iterator();
        //recorre recetas
        while(recetasIterator.hasNext()){


            Receta receta = (Receta) recetasIterator.next();
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
        recetasIterator = recetas.iterator();
        while(recetasIterator.hasNext()){
            Receta receta = (Receta) recetasIterator.next();
            Iterator categorias = receta.getCategorias().iterator();

            //reccorre categorias
            while(categorias.hasNext()){

                Categorias categoria = (Categorias) categorias.next();
                if(categoria.getAlimentos().size() == 0){
                    categorias.remove();
                }

            }


        }

        recetasIterator = recetas.iterator();
        while(recetasIterator.hasNext()){

            Receta receta = (Receta) recetasIterator.next();

            if(receta.getCategorias().size() == 0){
                recetasIterator.remove();
            }

        }

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpagerreporte);
        adapterViewPager = new MyPagerAdapter(recetas,getSupportFragmentManager(),reportesFragments);
        viewPager.setAdapter(adapterViewPager);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertabreporte);
        viewPagerTab.setViewPager(viewPager);

       // Receta prueba4 = object;
        //ArrayList<Receta> recetas =  (ArrayList<Receta>) getIntent().getSerializableExtra("recetas");
       // ArrayList<Receta> prueba2 = recetas;
        //) prueba2.add(new Receta());

    }

    public ArrayList<Receta> addReceta(ArrayList<Receta> recetas,Receta receta){
        if(receta !=null) recetas.add(receta);
        return recetas;
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 0;
        private ArrayList<ReportesFragment> cm ;
        private ArrayList<Receta> recetas;

        public MyPagerAdapter( ArrayList<Receta> recetas,FragmentManager fragmentManager, ArrayList<ReportesFragment> cm) {
            super(fragmentManager);
            this.cm = cm;
            this.recetas = recetas;
            NUM_ITEMS=recetas.size();

        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {

            ReportesFragment cm1 = ReportesFragment.newInstance(recetas.get(position).getTab(),recetas.get(position));
            this.cm.add(cm1);
            return cm1;


        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return recetas.get(position).getTab();
        }

    }
    public void salir(View v){
        Intent homeIntent = new Intent(getApplicationContext(), MainActivity.class);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(homeIntent);

       /* moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);*/
        /*int pid = android.os.Process.myPid();//=====> use this if you want to kill your activity. But its not a good one to do.
        android.os.Process.killProcess(pid);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);

        /*this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        int pid = android.os.Process.myPid();//=====> use this if you want to kill your activity. But its not a good one to do.
    android.os.Process.killProcess(pid);*/


       // System.exit(0);
      /*  finish();
        System.exit(0);

       /* finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        this.finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        */

    }
}
