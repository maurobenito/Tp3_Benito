package com.tec.tp3Navegable.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tec.tp3Navegable.databinding.FragmentCargarBinding;

public class CargarFragment extends Fragment {

    private FragmentCargarBinding binding;
    private CargarViewModel mv;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentCargarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mv = new ViewModelProvider(this).get(CargarViewModel.class);


        mv.getmMensaje().observe(getViewLifecycleOwner(), mensaje -> {
            Toast.makeText(getContext(), mensaje, Toast.LENGTH_SHORT).show();
            mv.getLimpiarCampos().observe(getViewLifecycleOwner(), unused -> {
                binding.etCodigo.setText("");
                binding.etDescripcion.setText("");
                binding.etPrecio.setText("");
            });

        });

        binding.btAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(), "Guardando...", Toast.LENGTH_SHORT).show();
                String codigo = binding.etCodigo.getText().toString();
                String descripcion = binding.etDescripcion.getText().toString();
                String precio = binding.etPrecio.getText().toString();
                mv.guardarProducto(codigo, descripcion, precio);
            }
        });

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}