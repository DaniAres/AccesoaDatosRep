package org.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoleadorGSON {
    @Expose(serialize = true, deserialize = true)

    @SerializedName("jugador")
    private String jugador;
    @Expose
    private int goles;
    @Expose
    private int partidos;


    @Override
    public String toString() {
        return "GoleadorGSON{" +
                "jugador='" + jugador + '\'' +
                ", goles=" + goles +
                ", partidos=" + partidos +
                '}';
    }
}
