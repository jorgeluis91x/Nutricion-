package center.innovus.nutriassistClient.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;


import java.util.ArrayList;

import center.innovus.nutriassistClient.Fragments.ComidasFragment;
import center.innovus.nutriassistClient.Models.Receta;
import center.innovus.nutriassistClient.R;

public class ComidasTabs extends AppCompatActivity /* implements ComidasFragment.ComidaSeleccionadaListener*/ {


    MyPagerAdapter adapterViewPager;
    int dummyInt;
    TextView tvLabel;

    private int desayuno;
    public double cantCarbohidratos;
    private String identificacion;
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

        cantCarbohidratos = getIntent().getIntExtra("cantCarbohidratos",0);
        identificacion = getIntent().getStringExtra("identificacion");



      /*  tvLabel = (TextView) this.findViewById(R.id.grams_not_assigned);
        tvLabel.setText(getString(R.string.food_grams_not_assigned) + " " + cantCarbohidratos + " gr");
*/
        desayuno = (int)(cantCarbohidratos *0.20);
        nueves = (int)(cantCarbohidratos * 0.10);
        almuerzo = (int)(cantCarbohidratos *0.30);
        onces = (int)(cantCarbohidratos* 0.10);
        cena = (int)(cantCarbohidratos *0.20);
        refrigerio = (int)(cantCarbohidratos* 0.10);

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
        infoFoodIntent.putExtra("identificacion", identificacion);
        startActivity(infoFoodIntent);
    }



    public void onFragmentInteraction (double gramos,double spinnerAntes, double spinnerDespues){

        double diferencia = spinnerAntes - spinnerDespues;
        cantCarbohidratos = cantCarbohidratos + (diferencia*gramos);
        tvLabel.setText(getString(R.string.food_grams_not_assigned) + " " + cantCarbohidratos + " gr");

    }


}
