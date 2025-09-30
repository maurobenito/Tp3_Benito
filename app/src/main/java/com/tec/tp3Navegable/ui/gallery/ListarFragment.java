package com.tec.tp3Navegable.ui.gallery;

import static com.tec.tp3Navegable.MainActivity.productos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tec.tp3Navegable.databinding.FragmentListarBinding;

public class ListarFragment extends Fragment {

    private FragmentListarBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentListarBinding.inflate(inflater, container, false);

        ProductoAdapter adapter = new ProductoAdapter(productos, getContext(), getLayoutInflater());
        GridLayoutManager glm = new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false);
        binding.rvLista.setLayoutManager(glm);
        binding.rvLista.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}