/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author USER
 */

// Keyword Final agar class admin tidak dapat diturunkan lagi
public final class Admin extends Akun {
    public Admin(String id, String nama) {
        super(id, nama);
    }

    @Override
    public void tampilkanPeran() {
        System.out.println("Role: Atmin Studio");
    }
}
