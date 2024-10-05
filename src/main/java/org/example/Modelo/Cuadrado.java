package org.example.Modelo;

public class Cuadrado {

    public int[] punto1 = new int[2];
    public int[] punto2 = new int[2];
    public int[] punto3 = new int[2];
    public int[] punto4 = new int[2];

    int ladoX;
    int ladoY;

    public Cuadrado() {
    }

    public Cuadrado(int[] punto1, int ladoX, int ladoY) {
        this.punto1 = punto1;
        this.ladoX = ladoX;
        this.ladoY = ladoY;

        this.punto2 = new int[] { punto1[0] + ladoX, punto1[1] };
        this.punto3 = new int[] { punto1[0], punto1[1] + ladoY };
        this.punto4 = new int[] { punto1[0] + ladoX, punto1[1] + ladoY };

    }


    public int[] getPunto1() {
        return punto1;
    }

    public void setPunto1(int[] punto1) {
        this.punto1 = punto1;
    }

    public int[] getPunto2() {
        return punto2;
    }

    public void setPunto2(int[] punto2) {
        this.punto2 = punto2;
    }

    public int[] getPunto3() {
        return punto3;
    }

    public void setPunto3(int[] punto3) {
        this.punto3 = punto3;
    }

    public int[] getPunto4() {
        return punto4;
    }

    public void setPunto4(int[] punto4) {
        this.punto4 = punto4;
    }

    public int getLadoX() {
        return ladoX;
    }

    public void setLadoX(int lado) {
        this.ladoX = lado;
    }

    public int getLadoY() {
        return ladoY;
    }

    public void setLadoY(int ladoY) {
        this.ladoY = ladoY;
    }
}
