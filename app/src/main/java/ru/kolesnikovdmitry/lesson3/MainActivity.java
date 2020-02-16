package ru.kolesnikovdmitry.lesson3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static final private int CHOOSE_CHIEF = 0;
    String LOH_TO_TI  = "А ЛОх ТО - ";
    String WHO_LOH_TO = "КТО ЛОХ?";
    String ACTIVITY_DAT_PO_EBALU = "ru.kolesnikovdmitry.lesson3.DatPoEbaluActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickActivityMain(View view) {
        switch (view.getId()) {
            case R.id.buttonMakeChoiceMainActivity:
                Intent questionIntent = new Intent(MainActivity.this, ChoiceActivity.class);
                startActivityForResult(questionIntent, CHOOSE_CHIEF);
                break;
            case R.id.buttonDatPoEbaluMainActivity:
                startActivity(new Intent(ACTIVITY_DAT_PO_EBALU));
                break;
            default:
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView mTextViewActivityMainResult = findViewById(R.id.textViewWhoLoh); //Заменяем текст в нашей первоначальной TextView
        switch (requestCode) {
            case CHOOSE_CHIEF:
                if(resultCode == RESULT_OK) {
                    assert data != null;
                    String textFromChoiceActivity = data.getStringExtra(ChoiceActivity.THIEF);
                    mTextViewActivityMainResult.setText(String.format("%s%s", LOH_TO_TI, textFromChoiceActivity));
                }
                else {
                    mTextViewActivityMainResult.setText(WHO_LOH_TO);
                }
                break;
            default:
                break;
        }
    }
}
