package com.example.timerviewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    TimerViewModel timerViewModel;
    TextView tvTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTimer = findViewById(R.id.tvTimer);

        //En la siguiente linea establezco que el viewmodelque hemos creado depende del ciclo de vida de la activity
        timerViewModel = ViewModelProviders.of(this).get(TimerViewModel.class);

        Observer<Long> observer = aLong -> {
            //Se intrpduce el codigo que quiero actualizar de la UI
            tvTimer.setText(getString(R.string.tvTimer)+" "+aLong);
        };
        timerViewModel.getLiveData().observe(this,observer);
    }
}