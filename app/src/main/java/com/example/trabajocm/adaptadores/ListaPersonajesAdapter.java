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
import com.example.trabajocm.entidades.personaje;

import java.util.ArrayList;

public class ListaPersonajesAdapter extends RecyclerView.Adapter<ListaPersonajesAdapter.PersonajeViewHolder> {

    ArrayList<personaje> listaPersonajes;

    public ListaPersonajesAdapter(ArrayList<personaje> listaPersonajes){
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
        int fuerz=listaPersonajes.get(position).getFuerza();
        int destrez=listaPersonajes.get(position).getDestreza();
        int consti = listaPersonajes.get(position).getConstitucion();
        int inteli = listaPersonajes.get(position).getInteligencia();
        int Sabi = listaPersonajes.get(position).getSabiduria();
        int Caris = listaPersonajes.get(position).getCarisma();

        holder.viewFoto.setImageURI(Uri.parse(listaPersonajes.get(position).getImagen()));


        holder.viewNombre.setText(listaPersonajes.get(position).getNombre());
        holder.viewRaza.setText(listaPersonajes.get(position).getRaza());
        holder.viewClase.setText(listaPersonajes.get(position).getClase());

        if(listaPersonajes.get(position).getRaza().equals("Humano")){
            holder.viewFuerza.setText("" +(fuerz+1));
            holder.viewDestreza.setText("" +(destrez+1));
            holder.viewConstitucion.setText("" +(consti+1));
            holder.viewInteligencia.setText("" +(inteli+1));
            holder.viewSabiduria.setText("" +(Sabi+1));
            holder.viewCarisma.setText("" +(Caris+1));

        }else if(listaPersonajes.get(position).getRaza().equals("Elfo")){
            holder.viewFuerza.setText("" +(fuerz));
            holder.viewDestreza.setText("" +(destrez+2));
            holder.viewConstitucion.setText("" +(consti));
            holder.viewInteligencia.setText("" +(inteli));
            holder.viewSabiduria.setText("" +(Sabi));
            holder.viewCarisma.setText("" +(Caris));
        }else if (listaPersonajes.get(position).getRaza().equals("Dracónido")){
            holder.viewFuerza.setText("" +(fuerz+2));
            holder.viewDestreza.setText("" +(destrez));
            holder.viewConstitucion.setText("" +(consti));
            holder.viewInteligencia.setText("" +(inteli));
            holder.viewSabiduria.setText("" +(Sabi));
            holder.viewCarisma.setText("" +(Caris+1));
        }else if (listaPersonajes.get(position).getRaza().equals("Enano")){
            holder.viewFuerza.setText("" +(fuerz));
            holder.viewDestreza.setText("" +(destrez));
            holder.viewConstitucion.setText("" +(consti+2));
            holder.viewInteligencia.setText("" +(inteli));
            holder.viewSabiduria.setText("" +(Sabi));
            holder.viewCarisma.setText("" +(Caris));
        }else if (listaPersonajes.get(position).getRaza().equals("Gnomo")){
            holder.viewFuerza.setText("" +(fuerz));
            holder.viewDestreza.setText("" +(destrez));
            holder.viewConstitucion.setText("" +(consti));
            holder.viewInteligencia.setText("" +(inteli+2));
            holder.viewSabiduria.setText("" +(Sabi));
            holder.viewCarisma.setText("" +(Caris));
        }else if (listaPersonajes.get(position).getRaza().equals("Medio elfo")){
            holder.viewFuerza.setText("" +(fuerz));
            holder.viewDestreza.setText("" +(destrez));
            holder.viewConstitucion.setText("" +(consti));
            holder.viewInteligencia.setText("" +(inteli));
            holder.viewSabiduria.setText("" +(Sabi));
            holder.viewCarisma.setText("" +(Caris+2));
        }else if (listaPersonajes.get(position).getRaza().equals("Medio orco")){
            holder.viewFuerza.setText("" +(fuerz+2));
            holder.viewDestreza.setText("" +(destrez));
            holder.viewConstitucion.setText("" +(consti+1));
            holder.viewInteligencia.setText("" +(inteli));
            holder.viewSabiduria.setText("" +(Sabi));
            holder.viewCarisma.setText("" +(Caris));
        }else if (listaPersonajes.get(position).getRaza().equals("Mediano")){
            holder.viewFuerza.setText("" +(fuerz));
            holder.viewDestreza.setText("" +(destrez+2));
            holder.viewConstitucion.setText("" +(consti));
            holder.viewInteligencia.setText("" +(inteli));
            holder.viewSabiduria.setText("" +(Sabi));
            holder.viewCarisma.setText("" +(Caris));
        }else if (listaPersonajes.get(position).getRaza().equals("Tiefling")){
            holder.viewFuerza.setText("" +(fuerz));
            holder.viewDestreza.setText("" +(destrez));
            holder.viewConstitucion.setText("" +(consti));
            holder.viewInteligencia.setText("" +(inteli+1));
            holder.viewSabiduria.setText("" +(Sabi));
            holder.viewCarisma.setText("" +(Caris+2));
        }else{
            holder.viewFuerza.setText("" +(fuerz));
            holder.viewDestreza.setText("" +(destrez));
            holder.viewConstitucion.setText("" +(consti));
            holder.viewInteligencia.setText("" +(inteli));
            holder.viewSabiduria.setText("" +(Sabi));
            holder.viewCarisma.setText("" +(Caris));
        }

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
