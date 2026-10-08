/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */

// Sub-Class jenis paket Event jasa Fotografi


public class PaketEvent extends LayananFotografi {
    private int jumlahKru;

    public PaketEvent(String kodePaket, String namaPaket, double harga, int jumlahKru) {
        super(kodePaket, namaPaket, harga);
        this.jumlahKru = jumlahKru;
    }

    // Polymorphism: Method Overriding
    @Override
    public void detailLayanan() {
        System.out.println("Tipe Layanan : Event (Outdoor/On-Site)");
        System.out.println("Jumlah Kru   : " + jumlahKru + " Fotografer/Videografer");
    }
}