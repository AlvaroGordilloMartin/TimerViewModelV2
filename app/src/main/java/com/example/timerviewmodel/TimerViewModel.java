package com.example.timerviewmodel;

import android.os.SystemClock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class TimerViewModel extends ViewModel {
    //Esta clase contiene un dato que va a ser observable
    //Que contiene la logica de negocio
    //Esta vinculada al ciclo de vida de un componenete LifeCicleOwner

    MutableLiveData<Long> elapsedTime = new MutableLiveData<>();
    final static int ONE_SECOND = 1000;
    long initialTime;

    public TimerViewModel() {
        initialTime = SystemClock.elapsedRealtime();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                long newTime = (SystemClock.elapsedRealtime()-initialTime)/1000;
                elapsedTime.postValue(newTime);
            }
        },ONE_SECOND,ONE_SECOND);
    }

    public LiveData<Long> getLiveData() {

        return elapsedTime;
    }
}
