package com.tec.tp3Navegable.ui.gallery;

import static com.tec.tp3Navegable.MainActivity.productos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tec.tp3Navegable.databinding.FragmentListarBinding;

import java.util.ArrayList;

public class ListarFragment extends Fragment {

    private FragmentListarBinding binding;
    private ListarViewModel vm;
    private ProductoAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentListarBinding.inflate(inflater, container, false);


        vm = new ViewModelProvider(this).get(ListarViewModel.class);


        adapter = new ProductoAdapter(new ArrayList<>(), getContext(), getLayoutInflater());
        GridLayoutManager glm = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        binding.rvLista.setLayoutManager(glm);
        binding.rvLista.setAdapter(adapter);


        vm.getLista().observe(getViewLifecycleOwner(), productos -> {
            adapter.setProductos(productos);
            adapter.notifyDataSetChanged();
        });


        vm.cargarLista();

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
