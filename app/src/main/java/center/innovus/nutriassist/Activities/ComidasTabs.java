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
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import center.innovus.nutriassist.Fragments.ComidasFragment;
import center.innovus.nutriassist.MainActivity;
import center.innovus.nutriassist.Models.Alimentos;
import center.innovus.nutriassist.Models.Categorias;
import center.innovus.nutriassist.Models.Receta;
import center.innovus.nutriassist.R;

public class ComidasTabs extends AppCompatActivity {


    MyPagerAdapter adapterViewPager;
    int dummyInt;

    private int desayuno;
    private int nueves;
    private int almuerzo;
    private int onces;
    private int cena;
    private int refrigerio;
    private ArrayList<ComidasFragment> comidasFragments = new ArrayList<ComidasFragment>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comidas_tabs);

        final int cantCarbohidratos = getIntent().getIntExtra("cantCarbohidratos",0);

        desayuno = cantCarbohidratos;
        nueves = cantCarbohidratos;
        almuerzo = cantCarbohidratos;
        onces = cantCarbohidratos;
        cena = cantCarbohidratos;
        refrigerio = cantCarbohidratos;

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapterViewPager = new MyPagerAdapter(desayuno,nueves,almuerzo,onces,cena,refrigerio,getSupportFragmentManager(),comidasFragments);
        viewPager.setAdapter(adapterViewPager);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 6;
        private int desayuno, nueves, almuerzo, onces, cena, refrigerio;
        private ArrayList<ComidasFragment> cm ;

        public MyPagerAdapter(int desayuno,int nueves,int almuerzo, int onces, int cena, int refrigerio,FragmentManager fragmentManager, ArrayList<ComidasFragment> cm) {
            super(fragmentManager);
            this.desayuno = desayuno;
            this.almuerzo =almuerzo;
            this.cena = cena;
            this.nueves = nueves;
            this.refrigerio = refrigerio;
            this.onces = onces;
            this.cm = cm;

        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    ComidasFragment cm1 = ComidasFragment.newInstance(desayuno, "Desayuno");
                    this.cm.add(cm1);
                    return cm1;
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    ComidasFragment cm2 = ComidasFragment.newInstance(nueves, "Nueves");
                    this.cm.add(cm2);
                    return cm2;
                case 2: // Fragment # 1 - This will show SecondFragment
                    ComidasFragment cm3 = ComidasFragment.newInstance(almuerzo, "Almuerzo");
                    this.cm.add(cm3);
                    return cm3;

                case 3: // Fragment # 1 - This will show SecondFragment
                    ComidasFragment cm4 = ComidasFragment.newInstance(onces, "Onces");
                    this.cm.add(cm4);
                    return cm4;

                case 4: // Fragment # 1 - This will show SecondFragment
                    ComidasFragment cm5 = ComidasFragment.newInstance(cena, "Cena");
                    this.cm.add(cm5);
                    return cm5;

                case 5: // Fragment # 1 - This will show SecondFragment
                    ComidasFragment cm6 = ComidasFragment.newInstance(refrigerio, "Refrigerio");
                    this.cm.add(cm6);
                    return cm6;
                   // return ComidasFragment.newInstance(refrigerio, "Refrigerio");
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            switch(position){
                case 0: // Fragment # 0 - This will show FirstFragment
                    //return "DESAYUNO";
                    return "DESAYUNO";
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return "NUEVES";
                case 2: // Fragment # 1 - This will show SecondFragment
                    return "ALMUERZO";
                case 3: // Fragment # 0 - This will show FirstFragment
                    return "ONCES";
                case 4: // Fragment # 0 - This will show FirstFragment
                    return "CENA";
                case 5: // Fragment # 0 - This will show FirstFragment
                    return "REFRIGERIO";
                default:
                    return null;
            }
        }

    }
    @Override
    protected  void  onResume(){
        super.onResume();
        ArrayList<Receta> recetasFinal = new ArrayList<Receta>();
        for (int i =0;i<comidasFragments.size(); i++){
            recetasFinal.add(comidasFragments.get(i).getReceta());
        }
    }



    public void reporteOnClick(View v){
        ArrayList<Receta> recetasFinal = new ArrayList<Receta>();
     //   ArrayList<Receta> pruena = recetasFinal;

        for (int i =0;i<comidasFragments.size(); i++){
            Receta recetaPrueba  = comidasFragments.get(i).getReceta();
            recetasFinal.add(recetaPrueba);
           // pruena.add(comidasFragments.get(i).getReceta());
        }
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
        Intent infoFoodIntent = new Intent(ComidasTabs.this, ReporteActivity.class);
        //infoFoodIntent.putExtra("parcel0",receta);
        //infoFoodIntent.putExtra("parcel2",prueba.get(0));

        for (int i =0;i<recetasFinal.size(); i++){
            String parce = "parcel"+i;
            infoFoodIntent.putExtra(parce,recetasFinal.get(i));
           // recetasFinal.add(comidasFragments.get(i).getReceta());
        }
        //infoFoodIntent.putParcelableArrayListExtra("recetas",recetasFinal);

        infoFoodIntent.putExtra("dummyIntExtra", dummyInt);
        startActivity(infoFoodIntent);
    }

}
