package com.tec.tp3Navegable.ui.slideshow;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SalirViewModel extends AndroidViewModel {

    private  MutableLiveData<String> mTexto;
    private  MutableLiveData<Boolean> confirmarSalida;

    public SalirViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<String> getTexto() {
        return mTexto;
    }

    public LiveData<Boolean> getConfirmarSalida() {
        return confirmarSalida;
    }

    public void solicitarConfirmacion() {
        confirmarSalida.setValue(true);
    }
}
