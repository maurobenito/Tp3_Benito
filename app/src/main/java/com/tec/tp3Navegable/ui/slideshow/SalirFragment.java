package com.tec.tp3Navegable.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.tec.tp3Navegable.databinding.FragmentSalirBinding;

public class SalirFragment extends Fragment {

    private FragmentSalirBinding binding;
    private SalirViewModel vm;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        vm = new ViewModelProvider(this).get(SalirViewModel.class);
        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        vm.getTexto().observe(getViewLifecycleOwner(), texto -> {
            binding.textSlideshow.setText(texto);
        });

        vm.getConfirmarSalida().observe(getViewLifecycleOwner(), confirmar -> {
            if (confirmar != null && confirmar) {
                new android.app.AlertDialog.Builder(getContext())
                        .setTitle("Confirmación")
                        .setMessage("¿Estás seguro de que quiere salir de TP3?")
                        .setPositiveButton("Sí", (dialog, which) -> {
                            requireActivity().finish(); // o Navigation.navigateUp()
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });

        binding.btSalir.setOnClickListener(v -> {
            vm.solicitarConfirmacion();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
