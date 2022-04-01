package com.example.fact001;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdaptadorClientes extends FirebaseRecyclerAdapter<ModeloCliente,AdaptadorClientes.myViewholder>{


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public AdaptadorClientes(@NonNull FirebaseRecyclerOptions<ModeloCliente> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewholder holder, int position, @NonNull ModeloCliente model) {
        holder.cliApellidos.setText(model.getCliApellidos());
        holder.cliCedula.setText(model.getCliApellidos());
        holder.cliCorreo.setText(model.getCliApellidos());
        holder.cliCorreo.setText(model.getCliApellidos());
        holder.cliDireccion.setText(model.getCliApellidos());
        Glide.with(holder.img.getContext())
                .load(model.getCliImg())
                .placeholder(com.firebase.ui.database.R.drawable.common_google_signin_btn_icon_dark)
                .circleCrop()
                .error(com.google.android.gms.base.R.drawable.common_google_signin_btn_icon_dark_normal)
                .into(holder.img);
        holder.cliNombres.setText(model.getCliApellidos());
        holder.cliTelefono.setText(model.getCliApellidos());
    }

    @NonNull
    @Override
    public myViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clientes,parent,false);
        return new myViewholder(view);
    }

    class myViewholder extends RecyclerView.ViewHolder {
        CircleImageView img;
        TextView cliApellidos, cliCedula, cliCorreo, cliDireccion, cliNombres, cliTelefono;

        public myViewholder(@NonNull View itemView) {
            super(itemView);
            img = (CircleImageView) itemView.findViewById(R.id.imgClientes);
            cliApellidos = (TextView) itemView.findViewById(R.id.tvCliApellidos);
            cliCedula = (TextView) itemView.findViewById(R.id.tvCliCedula);
            cliCorreo = (TextView) itemView.findViewById(R.id.tvCliCorreo);
            cliDireccion = (TextView) itemView.findViewById(R.id.tvCliDireccion);
            cliNombres = (TextView) itemView.findViewById(R.id.tvCliNombres);
            cliTelefono = (TextView) itemView.findViewById(R.id.tvCliTelefono);
        }
    }
}
