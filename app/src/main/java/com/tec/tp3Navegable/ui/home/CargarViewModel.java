package com.tec.tp3Navegable.ui.home;

import static com.tec.tp3Navegable.MainActivity.productos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tec.tp3Navegable.modelo.Producto;

public class CargarViewModel extends AndroidViewModel {

    private  MutableLiveData<String> mMensaje;
    private MutableLiveData<Boolean> limpiarCampos;

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getmMensaje() {
        if (mMensaje==null) {
            mMensaje=new MutableLiveData<>();

        }
            return mMensaje;

    }

    public LiveData<Boolean> getLimpiarCampos() {
        if (limpiarCampos==null) {
            limpiarCampos=new MutableLiveData<>();

        }


        return limpiarCampos;
    }

    public void guardarProducto(String codigo, String descripcion, String precio) {
        if (codigo.isEmpty() || descripcion.isEmpty() || precio.isEmpty()) {
            mMensaje.setValue("Debe completar todos los campos");
            return;
        }

        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                mMensaje.setValue("Codigo repetido");
                return;
            }
        }

        Producto producto = new Producto(codigo, descripcion, Float.parseFloat(precio));
        productos.add(producto);
        mMensaje.setValue("Producto guardado");
        limpiarCampos.setValue(true);
    }

}








