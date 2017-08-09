package center.innovus.nutriassist;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import center.innovus.nutriassist.Activities.AsignarActivity;
import center.innovus.nutriassist.Activities.ScrollingActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup sexRadioGroup;
    private EditText etAge;
    private EditText etExpectedWeight;
    private EditText etHeight;
    private EditText etActivityFactor;
    private int expectedWeight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void calculate(View v){

        etHeight = (EditText) findViewById(R.id.height);
        etActivityFactor = (EditText) findViewById(R.id.activity_factor);
        etAge = (EditText) findViewById(R.id.age);
        etExpectedWeight = (EditText) findViewById(R.id.expected_weight);

        // These nested if-else ensure that the user inputs all of the patient's data and starts new activity
        if(etAge.getText().toString().trim().length() == 0) {
            Snackbar.make(v, R.string.age_missing_toast, Snackbar.LENGTH_LONG).show();
        } else {
            if(etExpectedWeight.getText().toString().trim().length() == 0) {

                Snackbar.make(v, R.string.expected_weight_missing_toast,Snackbar.LENGTH_LONG).show();
            } else {
                if (etHeight.getText().toString().trim().length() == 0) {
                    Snackbar.make(v, R.string.height_missing_toast, Snackbar.LENGTH_LONG).show();
                } else {
                    if (etActivityFactor.getText().toString().trim().length() == 0){
                        Snackbar.make(v, R.string.activity_factor_missing_toast, Snackbar.LENGTH_LONG).show();
                    } else {
                        int VCT_ComputedValue = computeVCT();
                        Intent computedVCT_Intent = new Intent(this, AsignarActivity.class);
                        computedVCT_Intent.putExtra("VCT_Computed", VCT_ComputedValue);
                        computedVCT_Intent.putExtra("ProteinGrams", Integer.parseInt(etExpectedWeight.getText().toString()));
                        startActivity(computedVCT_Intent);
                    }
                }
            }
        }

    }

    // This method is used to calculate the Total Calorie Value based on the patients data
    public int computeVCT() {

        etHeight = (EditText) findViewById(R.id.height);
        etActivityFactor = (EditText) findViewById(R.id.activity_factor);
        etAge = (EditText) findViewById(R.id.age);
        etExpectedWeight = (EditText) findViewById(R.id.expected_weight);

        float height = Float.parseFloat(etHeight.getText().toString());
        float activityFactor = Float.parseFloat(etActivityFactor.getText().toString());
        float age = Float.parseFloat(etAge.getText().toString());
        expectedWeight = Integer.parseInt(etExpectedWeight.getText().toString());

        sexRadioGroup = (RadioGroup) findViewById(R.id.radioGroupSex);

        if( sexRadioGroup.getCheckedRadioButtonId() == R.id.radioFemale ){
            int VCT = (int) ((9.56*expectedWeight + 1.85*height - 4.68*age + 655.1)*activityFactor);
            return VCT;
        }
        else {
            int VCT = (int) ((13.75*expectedWeight + 5*height - 6.75*age + 66.47)*activityFactor);
            return VCT;
        }
    }


}
