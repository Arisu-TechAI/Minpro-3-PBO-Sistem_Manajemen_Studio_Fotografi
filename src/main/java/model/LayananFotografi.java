/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */

// SUPER-CLASS / Abstract Class

// Class yang digunakan untuk menyimpan Jenis dan tipe layanan jasa Fotografi
// Class ini dibuat sebagai Super-Class (kelas Induk), sehingga method-method yang ada disini dapat diwariskan ke Sub-Class lainnya


public abstract class LayananFotografi {
    protected String kodePaket;
    protected String namaPaket;
    protected double harga;

    public LayananFotografi(String kodePaket, String namaPaket, double harga) {
        this.kodePaket = kodePaket;
        this.namaPaket = namaPaket;
        this.harga = harga;
    }

    // Abstract method
    public abstract void detailLayanan();

    // Penggunaan Keyword Final agar format ini tidak bisa di-override oleh subclass
    public final String getInfoDasar() {
        return "[" + kodePaket + "] " + namaPaket + " - Rp" + harga;
    }

    public String getKodePaket() { return kodePaket; }
    public String getNamaPaket() { return namaPaket; }
    public double getHarga() { return harga; }
}