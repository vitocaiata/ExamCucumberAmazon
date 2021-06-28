package com.caiata.utils;

import java.util.ArrayList;

public class Modello {

    private String titolo;

    private String prezzo;
    private String img;

    public Modello() {
    }

    public Modello(String titolo, String prezzo, String img) {
        this.titolo = titolo;
        this.prezzo = prezzo;
        this.img = img;
    }

    public Modello(String titolo, String img) {
        this.titolo = titolo;
        this.img = img;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getPrezzo() {
        return prezzo;
    }

    public String getImg() {
        return img;
    }

    /**
     * Metodo per stampare
     * @param listaModello
     */
    public void stampaElementi(ArrayList<Modello> listaModello){
        for(Modello elemento : listaModello){
            System.out.println(elemento.getTitolo());
            System.out.println(elemento.getPrezzo());
            System.out.println(elemento.getImg());
            System.out.println("------------------");
        }
    }
}
