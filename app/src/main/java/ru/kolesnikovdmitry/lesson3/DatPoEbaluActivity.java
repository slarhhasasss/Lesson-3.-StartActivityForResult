package ru.kolesnikovdmitry.lesson3;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DatPoEbaluActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_po_ebalu);
    }

    public void olClickActivityDatPoEbalu(View view) {
        switch (view.getId()) {
            case R.id.buttonActivityDatPoEbalu:
                finish();
                break;
            default:
                break;
        }
    }
}
