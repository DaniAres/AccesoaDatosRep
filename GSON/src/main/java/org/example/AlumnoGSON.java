package org.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AlumnoGSON {
    @Expose(serialize = true, deserialize = true)
    private int id;

    @SerializedName("nombre")
    @Expose
    private String nombre;
    @Expose
    private int edad;

    @Override

    public String toString() {
        return "AlumnoGSON{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
