package com.example.contestantsapp.model;

public class Participant {
    private String nume;
    private String prenume;
    private int scor;

    public Participant(String nume, String prenume, int scor) {
        this.nume = nume;
        this.prenume = prenume;
        this.scor = scor;
    }

    public String getNume() { return nume; }
    public String getPrenume() { return prenume; }
    public int getScor() { return scor; }

    public void setScor(int scor) { this.scor = scor; }

    @Override
    public String toString() {
        return nume + " " + prenume + " - Scor: " + scor;
    }
}
