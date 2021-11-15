package org.example;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Rio {

    private ArrayList<RioJAXB> rios;

    public ArrayList<RioJAXB> getRios() {
        return rios;
    }
    @XmlElement(name="rio")
    public void setRios(ArrayList<RioJAXB> rios) {
        this.rios = rios;
    }
}

