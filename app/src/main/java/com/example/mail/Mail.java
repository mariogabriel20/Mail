package com.example.mail;

public class Mail {
    private int ID;
    private String nombre;
    private String asunto;

    public Mail(int ID, String nombre, String asunto) {
        this.ID = ID;
        this.nombre = nombre;
        this.asunto = asunto;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public int getID() {
        return ID;
    }
    public String getNombre() {
        return nombre;
    }
    public String getAsunto() {
        return asunto;
    }
}
