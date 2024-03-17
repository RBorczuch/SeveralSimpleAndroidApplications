package pl.radoslawborczuch.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView calculationView;
    private EditText displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculationView = findViewById(R.id.calculationView);
        displayText = findViewById(R.id.editText);

    }

    private void updateText (String strToAdd)
    {
        String oldStr = displayText.getText().toString();
        int cursorPos = displayText.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos); //zapisanie tego co po lewej od kursora do leftStr
        String rightStr = oldStr.substring(cursorPos);  // zapisanie tego co po prwej od kurcora do rightStr



        displayText.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr)); //sklejanie stringa
        displayText.setSelection(cursorPos + strToAdd.length()); //ustawienie kursora maksymalnie po  prawej

        displayText.setShowSoftInputOnFocus(false);
    }
 //metody do obslugi przyciskow
    public void zeroButtonClick(View view){
        updateText(getResources().getString(R.string.zeroText));
    }
    public void oneButtonClick(View view){
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoButtonClick(View view){
        updateText(getResources().getString(R.string.twoText));
    }
    public void threeButtonClick(View view){
        updateText(getResources().getString(R.string.threeText));
    }
    public void fourButtonClick(View view){
        updateText(getResources().getString(R.string.fourText));
    }
    public void fiveButtonClick(View view){
        updateText(getResources().getString(R.string.fiveText));
    }
    public void sixButtonClick(View view){
        updateText(getResources().getString(R.string.sixText));
    }
    public void sevenButtonClick(View view){
        updateText(getResources().getString(R.string.sevenText));
    }
    public void eightButtonClick(View view){
        updateText(getResources().getString(R.string.eightText));
    }
    public void nineButtonClick(View view){
        updateText(getResources().getString(R.string.nineText));
    }



    public void parenthesesOpenButtonClick(View view){
        updateText(getResources().getString(R.string.parenthesesOpenText));
    }
    public void parenthesesCloseButtonClick(View view){
        updateText(getResources().getString(R.string.parenthesesCloseText));
    }

    public void divideButtonClick(View view){
        updateText(getResources().getString(R.string.divideText));
    }
    public void multiplyButtonClick(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }
    public void subtractButtonClick(View view){
        updateText(getResources().getString(R.string.subtractText));
    }
    public void addButtonClick(View view){
        updateText(getResources().getString(R.string.addText));
    }
    public void decimalButtonClick(View view){
        updateText(getResources().getString(R.string.decimalText));
    }


    public void sinButtonClick(View view){
        updateText("sin(");
    }
    public void cosButtonClick(View view){
        updateText("cos(");
    }
    public void tanButtonClick(View view){
        updateText("tan(");
    }
    public void logButtonClick(View view){
        updateText("log10(");
    }
    public void lnButtonClick(View view){
        updateText("ln");
    }
    public void percentButtonClick(View view){
        updateText("%");
    }
    public void piButtonClick(View view){
        updateText(getResources().getString(R.string.piText));
    }

    public void sqrtButtonClick(View view) {
        updateText(getResources().getString(R.string.squareRootText));
    }
    public void xyButtonClick(View view){
        updateText("^(");
    }

    public void x2ButtonClick(View view){
        updateText("^(2)");
    }






    public void clearButtonClick(View view){
        displayText.setText("");
        calculationView.setText("");
    }

    public void backspaceButtonClick(View view){
        int cursorPos = displayText.getSelectionStart();
        int textLen =displayText.getText().length();

        if(cursorPos != 0 && textLen !=0) //jesli jest coc do usuniecia po lewej
        {
            SpannableStringBuilder selection =(SpannableStringBuilder) displayText.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            displayText.setText(selection);
            displayText.setSelection(cursorPos-1);
        }
    }

    public void equalButtonClick(View view){
        String userExp = displayText.getText().toString();

        calculationView.setText(userExp);

        //zamiana znakow na te obslugiwane przez mxparser
        userExp = userExp.replaceAll(getResources().getString(R.string.squareRootText),"sqrt(");
        userExp = userExp.replaceAll(getResources().getString(R.string.piText),"pi");
        userExp = userExp.replaceAll(getResources().getString(R.string.divideText),"/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText),"*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        displayText.setText(result);
        displayText.setSelection(result.length());

    }





}