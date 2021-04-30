package com.example.trabajocm.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajocm.R;
import com.example.trabajocm.Resumen_Personaje;
import com.example.trabajocm.entidades.Personaje;

import java.util.ArrayList;

public class ListaPersonajesAdapter extends RecyclerView.Adapter<ListaPersonajesAdapter.PersonajeViewHolder> {

    ArrayList<Personaje> listaPersonajes;

    public ListaPersonajesAdapter(ArrayList<Personaje> listaPersonajes){
        this.listaPersonajes = listaPersonajes;
    }

    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_items_personajes, null, false);
        return new PersonajeViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {

        holder.viewFoto.setImageURI(Uri.parse(listaPersonajes.get(position).getImagen()));


        holder.viewNombre.setText(listaPersonajes.get(position).getNombre());
        holder.viewRaza.setText(listaPersonajes.get(position).getRaza());
        holder.viewClase.setText(listaPersonajes.get(position).getClase());

        holder.viewFuerza.setText("" +listaPersonajes.get(position).getFuerza());
        holder.viewDestreza.setText("" +listaPersonajes.get(position).getDestreza());
        holder.viewConstitucion.setText("" +listaPersonajes.get(position).getConstitucion());
        holder.viewInteligencia.setText("" +listaPersonajes.get(position).getInteligencia());
        holder.viewSabiduria.setText("" +listaPersonajes.get(position).getSabiduria());
        holder.viewCarisma.setText("" +listaPersonajes.get(position).getCarisma());

    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public class PersonajeViewHolder extends RecyclerView.ViewHolder {

        ImageView viewFoto;
        TextView viewNombre, viewClase, viewRaza;
        EditText viewFuerza;
        EditText viewDestreza;
        EditText viewConstitucion;
        EditText viewInteligencia;
        EditText viewSabiduria;
        EditText viewCarisma;

        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);

            viewFoto = itemView.findViewById(R.id.imageView3);
            viewNombre = itemView.findViewById(R.id.Nombre);
            viewRaza = itemView.findViewById(R.id.raza);
            viewClase = itemView.findViewById(R.id.clase);



            viewFuerza = (EditText)itemView.findViewById(R.id.fuerza);
            viewDestreza = (EditText)itemView.findViewById(R.id.destreza);
            viewConstitucion = (EditText)itemView.findViewById(R.id.constitucion);
            viewInteligencia = (EditText)itemView.findViewById(R.id.inteligencia);
            viewSabiduria = (EditText)itemView.findViewById(R.id.sabiduria);
            viewCarisma = (EditText)itemView.findViewById(R.id.carisma);


            viewDestreza.setInputType(InputType.TYPE_NULL);
            viewConstitucion.setInputType(InputType.TYPE_NULL);
            viewInteligencia.setInputType(InputType.TYPE_NULL);
            viewSabiduria.setInputType(InputType.TYPE_NULL);
            viewCarisma.setInputType(InputType.TYPE_NULL);
            viewFuerza.setInputType(InputType.TYPE_NULL);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    Context context = view.getContext();
                    Intent intent = new Intent(context, Resumen_Personaje.class);
                    intent.putExtra("ID", listaPersonajes.get(getAdapterPosition()).getId());
                    context.startActivity(intent);

                }
            });


        }
    }
}
