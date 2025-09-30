package com.tec.tp3Navegable.ui.gallery;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tec.tp3Navegable.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class ListarViewModel extends AndroidViewModel {

    private  MutableLiveData<List<Producto>> mListaMutable;


    public ListarViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<Producto>> getLista(){
        if(mListaMutable == null){
            mListaMutable = new MutableLiveData<>();
        }
        return mListaMutable;
    }


    public void cargarLista(){
        ArrayList<Producto> lista = new ArrayList<>();

    }
}