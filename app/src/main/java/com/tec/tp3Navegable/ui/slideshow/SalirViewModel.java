package com.tec.tp3Navegable.ui.slideshow;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SalirViewModel extends ViewModel {

    private final MutableLiveData<String> mTexto;
    private final MutableLiveData<Boolean> confirmarSalida;

    public SalirViewModel() {
        mTexto = new MutableLiveData<>();
        mTexto.setValue("¿Desea salir de la aplicación?");
        confirmarSalida = new MutableLiveData<>();
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
