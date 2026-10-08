/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */

// Sub-Class Jenis Paket Reguler Jasa Fotografi


public class PaketReguler extends LayananFotografi {
    private int durasiJam;

    public PaketReguler(String kodePaket, String namaPaket, double harga, int durasiJam) {
        super(kodePaket, namaPaket, harga);
        this.durasiJam = durasiJam;
    }

    // Polymorphism untuk Method Overriding
    @Override
    public void detailLayanan() {
        System.out.println("Tipe Layanan : Reguler (Indoor/Studio)");
        System.out.println("Durasi Sesi  : " + durasiJam + " Jam");
    }
}