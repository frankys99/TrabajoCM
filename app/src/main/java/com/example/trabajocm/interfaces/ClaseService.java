package com.example.trabajocm.interfaces;


import com.example.trabajocm.modelos.Clase;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClaseService {




    @GET("/api/v1/clases")
    Call<List<Clase>> getClases();
}
