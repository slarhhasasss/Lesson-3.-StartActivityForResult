package ru.kolesnikovdmitry.lesson3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ChoiceActivity extends AppCompatActivity {


    public final static String THIEF = "ru.kolesnikovdmitry.lesson3.THIEF";  //это наш ключ для Extras чтобы отправлять данные через интент
    String DIMA  = "ДИМАААААА";
    String ALINA = "АЛИИИНАААА";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);
    }

    public void onClickActivityChoice(View view) {
        Intent ansIntent = new Intent();
        switch (view.getId()) {
            case R.id.radioButtonDimaActivityChoice:
                ansIntent.putExtra(THIEF, DIMA);      //если выбрали эту кнопку, то кладем в интент в ключ THIEF переменную DIMA
                setResult(RESULT_OK, ansIntent);      //дальше отправляем этот результат с кодом RESULT_OK = -1 (значит все ок) и собственно сам интент
                finish();
                break;
            case R.id.radioButtonAlinaActivityChoice:
                ansIntent.putExtra(THIEF, ALINA);  //АНалогично
                setResult(RESULT_OK, ansIntent);
                finish();
                break;
            case R.id.buttonAnswerActivityChoice:  //эта кнопка берет твой вариант
                EditText mEditTextAns = findViewById(R.id.editTextYourVariantActivityChoice);
                String ANSWER         = "Ничего не ввели!";
                if(mEditTextAns.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), ANSWER, Toast.LENGTH_LONG).show(); //если ничего не вввели, то показывает уведомление, что ничего не ввели
                }
                else {
                    ansIntent.putExtra(THIEF, mEditTextAns.getText().toString());  //если ввели, то отправляет в интент то, что ввели
                    setResult(RESULT_OK, ansIntent);  //опять передаем значение с кодом RESULT_OK  и с нашим интентом, передаем результат
                    finish();
                }
                break;
        }
    }
}
