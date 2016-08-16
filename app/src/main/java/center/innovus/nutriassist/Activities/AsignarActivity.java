package center.innovus.nutriassist.Activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import center.innovus.nutriassist.R;

public class AsignarActivity extends AppCompatActivity {

    private TextView tvComputedVCT;
    private TextView tvNotAssignedPercentage;

    private EditText etFatPercentage;
    private EditText etCarbohydratePercentage;
    private EditText etProteinPercentage;

    private int VCT_Computed;
    private int proteinInGrams;
    private int fatInGrams;
    private int carbohydratesInGrams;
    private int fatPercentage;
    private int CarbohydratePercentage;
    private int proteinPercentage;


   // private int[] VCT_ComputedValueAndProteinPercentage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignar);
        etCarbohydratePercentage = (EditText) findViewById(R.id.carbohydrates);
        etProteinPercentage = (EditText) findViewById(R.id.protein_percentage);
        etFatPercentage = (EditText) findViewById(R.id.fat);
        VCT_Computed = getIntent().getExtras().getInt("VCT_Computed");
        tvComputedVCT = (TextView) findViewById(R.id.result_VCT);
        tvComputedVCT.setText(String.valueOf(VCT_Computed + ""));
        tvNotAssignedPercentage = (TextView) findViewById(R.id.tvNotAssignedPercentage);
        tvNotAssignedPercentage.setText(String.valueOf(100));

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                editTextChange();

            }
        };


        etFatPercentage.addTextChangedListener(textWatcher);
        etCarbohydratePercentage.addTextChangedListener(textWatcher);
        etProteinPercentage.addTextChangedListener(textWatcher);




    }

    public void assignMacroNutrientsPercentages(int VCT_ComputedValue){

        proteinInGrams =  Integer.parseInt(etProteinPercentage.getText().toString())*VCT_ComputedValue/400; //getIntent().getExtras().getInt("ProteinInGramsExtra");
        fatInGrams =  Integer.parseInt(etFatPercentage.getText().toString())*VCT_ComputedValue/900;
        carbohydratesInGrams =  Integer.parseInt(etCarbohydratePercentage.getText().toString())*VCT_ComputedValue/400;
        Intent carbohydratesInGramsIntent = new Intent(AsignarActivity.this, PorcentajesComidasActivity.class);
        carbohydratesInGramsIntent.putExtra("macronutrientsInGramsExtra", new int[] {proteinInGrams, fatInGrams, carbohydratesInGrams});
        startActivity(carbohydratesInGramsIntent);
    }
    public void btnAssignar(View v){

        if(etFatPercentage.getText().toString().trim().length() == 0) {
            Snackbar.make(v, R.string.fat_missing_toast, Snackbar.LENGTH_LONG).show();
        } else {
            if(etCarbohydratePercentage.getText().toString().trim().length() == 0) {
                Snackbar.make(v, R.string.carbohydrates_missing_toast, Snackbar.LENGTH_LONG).show();
            } else {
                if(etProteinPercentage.getText().toString().trim().length() == 0){
                    Snackbar.make(v, R.string.protein_missing_toast, Snackbar.LENGTH_LONG).show();

                }else{
                    fatPercentage = Integer.parseInt(etFatPercentage.getText().toString());
                    CarbohydratePercentage = Integer.parseInt(etCarbohydratePercentage.getText().toString());

                    if (fatPercentage + CarbohydratePercentage + proteinPercentage != 100) {
                        Snackbar.make(v, R.string.not_hundred_percent_toast, Snackbar.LENGTH_LONG).show();
                    } else {
                        assignMacroNutrientsPercentages(VCT_Computed);
                    }

                }

            }
        }

    }

    public void editTextChange(){
        if(etFatPercentage.getText().toString().trim().length() == 0){
            fatPercentage = 0;
        }else{
            fatPercentage = Integer.parseInt(etFatPercentage.getText().toString());
        }
        if(etProteinPercentage.getText().toString().trim().length() == 0){
            proteinPercentage = 0;
        }else{
            proteinPercentage = Integer.parseInt(etProteinPercentage.getText().toString());
        }
        if(etCarbohydratePercentage.getText().toString().trim().length() == 0){
            CarbohydratePercentage = 0;
        }else {
            CarbohydratePercentage = Integer.parseInt(etCarbohydratePercentage.getText().toString());
        }
        tvNotAssignedPercentage.setText("" + (100-(fatPercentage + proteinPercentage + CarbohydratePercentage)));


    }

}
