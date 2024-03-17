package pl.rb.przelicznikmiar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Button_Przelicz_handler(View view) {
        TextView   in_number    = findViewById( R.id.number_input );
        RadioGroup rbg   = findViewById( R.id.rButtonGroup );
        TextView   out_number   = findViewById( R.id.number_output );
        TextView   out_units = findViewById( R.id.out_units );



        double input =  Double.parseDouble( in_number.getText().toString());
        double output = 0;


        switch( rbg.getCheckedRadioButtonId() ){
            case R.id.rButton_mm:
                output = (double)(1000 * input);
                out_units.setText("mm");
                break;
            case R.id.rButton_cm:
                output = (double)(100 * input);
                out_units.setText("cm");
                break;
            case R.id.rButton_dm:
                output = (double)(10 * input);
                out_units.setText("dm");
                break;
            case R.id.rButton_km:
                output = (double)(input / 1000);
                out_units.setText("km");
                break;
            case R.id.rButton_mi:
                output = (double)(input / 1609.34);
                out_units.setText("mi");
                break;
            case R.id.rButton_in:
                output = (double)(input * 39.3701);
                out_units.setText("in");
                break;

            default:
                out_units.setText(" ");
                out_number.setText( "Error");
        }


            out_number.setText( String.format("%s", output) );



        try  {
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {

        }
    }
}