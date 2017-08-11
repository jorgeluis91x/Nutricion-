package center.innovus.nutriassist.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import center.innovus.nutriassist.R;

public class PromedioActivity extends AppCompatActivity {

    TextView tvNumero;
    TextView tvFecha;
    TextView tvCarbohidratos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promedio);

        tvNumero = (TextView) this.findViewById(R.id.tbodyNumero);
        tvFecha = (TextView) this.findViewById(R.id.tbodyFecha);
        tvCarbohidratos = (TextView) this.findViewById(R.id.tbodyCarbohidratos);
    }
}
