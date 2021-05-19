package com.example.trabajocm.interfaces;

import com.example.trabajocm.modelos.Clase;
import com.example.trabajocm.modelos.Raza;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/api/v1/clases")
    Call<List<Clase>> getClases();

    @GET("api/v1/razas")
    Call<List<Raza>> getRazas();
}
