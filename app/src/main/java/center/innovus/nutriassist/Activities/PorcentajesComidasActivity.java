package center.innovus.nutriassist.Activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import org.w3c.dom.Text;

import center.innovus.nutriassist.R;

public class PorcentajesComidasActivity extends AppCompatActivity {

    private TextView tvProteinInGrams;
    private TextView tvFatInGrams;
    private TextView tvCarbohydratsInGrams;
    private EditText etBreakfastPercentage;
    private EditText etMorningSnackPercentage;
    private EditText etLunchPercentage;
    private EditText etAfternoonSnackPercentage;
    private EditText etDinnerPercentage;
    private EditText etNightSnackPercentage;
    private int[] macronutrientsInGrams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porcentajes_comidas);
        macronutrientsInGrams = getIntent().getExtras().getIntArray("macronutrientsInGramsExtra");


        tvProteinInGrams = (TextView) findViewById(R.id.proteinInGramsTextView);
        tvProteinInGrams.setText(macronutrientsInGrams[0] + "");
        tvFatInGrams = (TextView) findViewById(R.id.fatInGramsTextView);
        tvFatInGrams.setText( macronutrientsInGrams[1] + "");
        tvCarbohydratsInGrams = (TextView) findViewById(R.id.carbohydratesInGramsTextView);
        tvCarbohydratsInGrams.setText(macronutrientsInGrams[2] + "");

    }

    public void assignDailyMealsPercentages(int carbohydratesInGrams){

        etBreakfastPercentage = (EditText) findViewById(R.id.breakfast);
        etMorningSnackPercentage = (EditText) findViewById(R.id.morning_snack);;
        etLunchPercentage = (EditText) findViewById(R.id.lunch);
        etAfternoonSnackPercentage = (EditText) findViewById(R.id.afternoon_snack);
        etDinnerPercentage = (EditText) findViewById(R.id.dinner);
        etNightSnackPercentage = (EditText) findViewById(R.id.night_snack);

        int breakfastCarbsInGrams = Integer.parseInt(etBreakfastPercentage.getText().toString())*carbohydratesInGrams/100;
        int morningSnackCarbsInGrams =  Integer.parseInt(etMorningSnackPercentage.getText().toString())*carbohydratesInGrams/100;
        int lunchCarbsInGrams = Integer.parseInt(etLunchPercentage.getText().toString())*carbohydratesInGrams/100;
        int afternoonSnackCarbsInGrams = Integer.parseInt(etAfternoonSnackPercentage.getText().toString())*carbohydratesInGrams/100;
        int dinnerCarbsInGrams = Integer.parseInt(etDinnerPercentage.getText().toString())*carbohydratesInGrams/100;
        int nightSnackCarbsInGrams = Integer.parseInt(etNightSnackPercentage.getText().toString())*carbohydratesInGrams/100;

        Intent mealsInGramsIntent = new Intent(PorcentajesComidasActivity.this, ComidasTabs.class);
        mealsInGramsIntent.putExtra("mealsInGramsExtra", new int[] {breakfastCarbsInGrams, morningSnackCarbsInGrams, lunchCarbsInGrams, afternoonSnackCarbsInGrams, dinnerCarbsInGrams, nightSnackCarbsInGrams});
        startActivity(mealsInGramsIntent);

    }

    public void continuar(View v){

        etBreakfastPercentage = (EditText) findViewById(R.id.breakfast);
        etMorningSnackPercentage = (EditText) findViewById(R.id.morning_snack);;
        etLunchPercentage = (EditText) findViewById(R.id.lunch);
        etAfternoonSnackPercentage = (EditText) findViewById(R.id.afternoon_snack);
        etDinnerPercentage = (EditText) findViewById(R.id.dinner);
        etNightSnackPercentage = (EditText) findViewById(R.id.night_snack);

        if(etBreakfastPercentage.getText().toString().trim().length() == 0) {
            Snackbar.make(v, R.string.breakfast_missing_toast, Snackbar.LENGTH_LONG).show();
        } else {
            if(etMorningSnackPercentage.getText().toString().trim().length() == 0) {
                Snackbar.make(v, R.string.morning_snack_missing_toast, Snackbar.LENGTH_LONG).show();
            } else {
                if(etLunchPercentage.getText().toString().trim().length() == 0) {
                    Snackbar.make(v, R.string.lunch_missing_toast, Snackbar.LENGTH_LONG).show();
                } else {
                    if(etAfternoonSnackPercentage.getText().toString().trim().length() == 0) {
                        Snackbar.make(v, R.string.afternoon_snack_missing_toast, Snackbar.LENGTH_LONG).show();
                    } else {
                        if(etDinnerPercentage.getText().toString().trim().length() == 0) {
                            Snackbar.make(v, R.string.dinner_missing_toast,Snackbar.LENGTH_LONG).show();
                        } else {
                            if(etNightSnackPercentage.getText().toString().trim().length() == 0) {
                                Snackbar.make(v, R.string.night_snack_missing_toast, Snackbar.LENGTH_LONG).show();
                            } else {
                                int breakfastCarbsPercentage = Integer.parseInt(etBreakfastPercentage.getText().toString());
                                int morningSnackCarbsPercentage = Integer.parseInt(etMorningSnackPercentage.getText().toString());
                                int lunchCarbsPercentage =  Integer.parseInt(etLunchPercentage.getText().toString());
                                int afternoonSnackCarbsPercentage =  Integer.parseInt(etAfternoonSnackPercentage.getText().toString());
                                int dinnerCarbsPercentage =  Integer.parseInt(etDinnerPercentage.getText().toString());
                                int nightSnackCarbsPercentage =  Integer.parseInt(etNightSnackPercentage.getText().toString());
                                int total_porcentajes = breakfastCarbsPercentage + morningSnackCarbsPercentage + lunchCarbsPercentage + afternoonSnackCarbsPercentage + dinnerCarbsPercentage + nightSnackCarbsPercentage;
                                Log.e("Porcentaje total", total_porcentajes + "");

                                if (total_porcentajes > 100){
                                    Log.e("Porcentaje total", "entro a >100");
                                    CharSequence snack = "Sobra " +(total_porcentajes - 100) + "% para el 100%";
                                    Snackbar.make(v, snack, Snackbar.LENGTH_LONG).show();
                                }else if(total_porcentajes < 100){
                                    Log.e("Porcentaje total", "entro a <100");
                                    CharSequence snack = "Falta " +(100 - total_porcentajes) + "% para completar el 100%";
                                    Log.e("Porcentaje total", snack.toString());


                                    Snackbar.make(v, snack, Snackbar.LENGTH_LONG).show();
                                } else {
                                    Log.e("Porcentaje total", "entro a else");
                                    assignDailyMealsPercentages(macronutrientsInGrams[2]);
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
