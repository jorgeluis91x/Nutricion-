package center.innovus.nutriassist.Activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItem;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;


import center.innovus.nutriassist.Fragments.ComidasFragment;
import center.innovus.nutriassist.MainActivity;
import center.innovus.nutriassist.R;

public class ComidasTabs extends AppCompatActivity {


    MyPagerAdapter adapterViewPager;
    int dummyInt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comidas_tabs);


       /* FragmentPagerItems pages = new FragmentPagerItems(this);
        pages.add(FragmentPagerItem.of("desayuno", ComidasFragment.class));
        pages.add(FragmentPagerItem.of("almuerzo", ComidasFragment.class));
        pages.add(FragmentPagerItem.of("pedo", ComidasFragment.class));*/

     /*   FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), pages);

/*
        //agrega  los fragmentos a las tabs
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(FragmentPagerItem.of("Desayuno",ComidasFragment.class, ComidasFragment.arguments("param:page1")))
                .add(FragmentPagerItem.of("Almuerzo",ComidasFragment.class, ComidasFragment.arguments("param:page2")))
                .add(FragmentPagerItem.of("Cena",ComidasFragment.class, ComidasFragment.arguments("param:page3")))
                .add(FragmentPagerItem.of("Desayuno",ComidasFragment.class, ComidasFragment.arguments("param:page4")))
              /*  .add("Desayuno", ComidasFragment.class)
                .add("Nueves", ComidasFragment.class)
                .add("Almuerzo", ComidasFragment.class)
                .add("Onces", ComidasFragment.class)
                .add("Cena", ComidasFragment.class)
                .add("Ref. Noct", ComidasFragment.class)


                //.add("Galeria", GalleryFragment.class)
                .create());*/

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);
        /*
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);*/



        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
        /*
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {
                //Toast.makeText(ChooseFood.this,
                //          "Selected page position: " + position, Toast.LENGTH_SHORT).show();
            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });*/
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 6;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
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
                    return ComidasFragment.newInstance(100, "Desayuno");
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return ComidasFragment.newInstance(1, "Nueves");
                case 2: // Fragment # 1 - This will show SecondFragment
                    return ComidasFragment.newInstance(2, "Almuerzo");
                case 3: // Fragment # 1 - This will show SecondFragment
                    return ComidasFragment.newInstance(3, "Onces");
                case 4: // Fragment # 1 - This will show SecondFragment
                    return ComidasFragment.newInstance(4, "Cena");
                case 5: // Fragment # 1 - This will show SecondFragment
                    return ComidasFragment.newInstance(5, "Refrigerio");
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

    public void infoFoodMethod(){
        Intent infoFoodIntent = new Intent(ComidasTabs.this, MainActivity.class);
        infoFoodIntent.putExtra("dummyIntExtra", dummyInt);
        startActivity(infoFoodIntent);
    }

}
