/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */

// Menerapkan Inheritance dari Client dan Implements Interface PotonganHarga
public final class ClientVIP extends Client implements PotonganHarga {
    // Penggunaan final untuk nilai yang tidak boleh diubah
    private final double PERSENTASE_DISKON = 0.15; // Diskon 15%

    public ClientVIP(String id, String nama, String noTelp) {
        super(id, nama, noTelp);
    }

    @Override
    public void tampilkanPeran() {
        System.out.println("Role: Client (Member Sepuh (VIP)");
    }

    // Mengimplementasikan method dari Interface
    @Override
    public double hitungDiskon(double hargaAwal) {
        return hargaAwal * PERSENTASE_DISKON;
    }
}