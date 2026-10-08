/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */

// Merupakan class turunan yang mewarisi class Akun, namun class ini lebih spesifik ke akun pihak klien

public class Client extends Akun {
    protected String noTelp;

    public Client(String id, String nama, String noTelp) {
        super(id, nama);
        this.noTelp = noTelp;
    }

    public String getNoTelp() { return noTelp; }

    @Override
    public void tampilkanPeran() {
        System.out.println("Role: Client (Reguler)");
    }
}