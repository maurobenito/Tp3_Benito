package com.tec.tp3Navegable.ui.gallery;

import static com.tec.tp3Navegable.MainActivity.productos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.tec.tp3Navegable.modelo.Producto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListarViewModel extends AndroidViewModel {

    private MutableLiveData<List<Producto>> mListaMutable;


    public ListarViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<Producto>> getLista() {
        if (mListaMutable == null) {
            mListaMutable = new MutableLiveData<>();
        }
        return mListaMutable;
    }


    public void cargarLista() {
        productos.sort(new Comparator<Producto>() {
            @Override
            public int compare(Producto o1, Producto o2) {

                return o1.getDescripcion().compareTo(o2.getDescripcion());

            }
        });
        mListaMutable.setValue(productos);
    }
}