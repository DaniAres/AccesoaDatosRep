package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Mascotas {

    private ArrayList<MascotaJAXB> mascotas;

    public void setMascotas(ArrayList<MascotaJAXB> mascotas) {
        this.mascotas = mascotas;
    }
    @XmlElement(name="mascota")
    public ArrayList<MascotaJAXB> getMascotas(){
        return this.mascotas;
    }
}
