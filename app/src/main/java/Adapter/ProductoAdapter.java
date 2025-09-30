package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tec.tp3Navegable.R;
import com.tec.tp3Navegable.modelo.Producto;

import java.util.List;


public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolderProducto> {

    private List<Producto> listaProductos;
    private Context context;
    private LayoutInflater inflater;

    public ProductoAdapter(List<Producto> listaProductos, Context context, LayoutInflater inflater) {
        this.listaProductos = listaProductos;
        this.context = context;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ProductoAdapter.ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.item, parent, false);
        return new ViewHolderProducto(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ProductoAdapter.ViewHolderProducto holder, int position) {

        Producto producto = listaProductos.get(position);
        holder.tvCodigo.setText("Codigo: " + producto.getCodigo());
        holder.tvDescripcion.setText("Descripcion: " + producto.getDescripcion());
        holder.tvPrecio.setText("Precio: $ " + producto.getPrecio());

    }

    @Override
    public int getItemCount() {
        return listaProductos.size();

    }

    public void setProductos(List<Producto> lista) { this.listaProductos = lista; }



    public class ViewHolderProducto extends RecyclerView.ViewHolder {

        TextView tvCodigo, tvDescripcion, tvPrecio;

        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);
            tvCodigo = itemView.findViewById(R.id.tvCodigo);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);;
            tvPrecio = itemView.findViewById(R.id.tvPrecio);

        }

    }
}
