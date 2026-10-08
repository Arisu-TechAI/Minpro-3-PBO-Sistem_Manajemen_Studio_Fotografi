/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;
import java.util.ArrayList;

/**
 *
 * @author USER
 */


public class Transaksi_Controller {
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();
    private ArrayList<LayananFotografi> daftarPaket = new ArrayList<>();
    private ArrayList<Akun> daftarAkun = new ArrayList<>();
    
    private int counterTransaksi = 1;
    private int counterClient = 1;

    public Transaksi_Controller() {
        // Data Paket Jasa Fotografi
        daftarPaket.add(new PaketReguler("REG-01", "Paket Wisuda Single", 400000, 2));
        daftarPaket.add(new PaketReguler("REG-02", "Paket Family Portrait", 750000, 3));
        daftarPaket.add(new PaketEvent("EVT-01", "Paket Wedding Basic", 3500000, 2));
        daftarPaket.add(new PaketEvent("EVT-02", "Paket Wedding Premium", 7500000, 4));

        // Data User Admin Default
        Admin defaultAdmin = new Admin("ADM-001", "admin");
        ClientVIP sampleClient = new ClientVIP(generateIdClient(), "Arisu", "08121111111111");
        
        daftarAkun.add(defaultAdmin);
        daftarAkun.add(sampleClient);

        // Data Dummy Transaksi Awal
        daftarTransaksi.add(new Transaksi(generateIdTransaksi(), sampleClient, daftarPaket.get(0), "11-01-2026"));
    }

    // Generate ID otomatis
    public String generateIdTransaksi() {
        return String.format("TRX-%03d", counterTransaksi++);
    }

    public String generateIdClient() {
        return String.format("CLN-%03d", counterClient++);
    }

    // Autentifikasi Akun dalam Arraylist
    public Akun cariAkunByUsername(String username) {
        for (Akun a : daftarAkun) {
            if (a.getNama().equalsIgnoreCase(username)) {
                return a;
            }
        }
        return null;
    }

    public Client registrasiKlien(String username, String noTelp, boolean isVip) {
        String idBaru = generateIdClient();
        Client klienBaru;

        if (isVip) {
            klienBaru = new ClientVIP(idBaru, username, noTelp);
        } else {
            klienBaru = new Client(idBaru, username, noTelp);
        }

        daftarAkun.add(klienBaru);
        return klienBaru;
    }

    // Pengelola Katalog Paket
    public ArrayList<LayananFotografi> getDaftarPaket() {
        return daftarPaket;
    }

    public LayananFotografi cariPaket(String kode) {
        for (LayananFotografi p : daftarPaket) {
            if (p.getKodePaket().equalsIgnoreCase(kode)) {
                return p;
            }
        }
        return null;
    }

    // Pengelola Transaksi
    public void tambahTransaksi(Client client, LayananFotografi paket, String tanggal) {
        Transaksi t = new Transaksi(generateIdTransaksi(), client, paket, tanggal);
        daftarTransaksi.add(t);
    }

    public void lihatPesananKlien(String namaKlien) {
        boolean ada = false;
        for (Transaksi t : daftarTransaksi) {
            if (t.getClient().getNama().equalsIgnoreCase(namaKlien)) {
                t.cetakStruk(true);
                ada = true;
            }
        }
        if (!ada) {
            System.out.println(" Belum ada riwayat pesanan atas nama " + namaKlien + ". <<");
        }
    }

    // Fitur Khusus Role Atmin
    public void lihatSemuaPesanan() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi masuk dalam sistem. ");
        } else {
            System.out.println("\n=== DAFTAR TRANSAKSI MASUK ===");
            for (Transaksi t : daftarTransaksi) {
                t.cetakStruk(false);
            }
        }
    }

    public boolean validasiPembayaran(String idTransaksi) {
        for (Transaksi t : daftarTransaksi) {
            if (t.getIdTransaksi().equalsIgnoreCase(idTransaksi)) {
                t.setStatus("Lunas (Divalidasi Atmin)");
                return true;
            }
        }
        return false;
    }

    public void tampilkanStatistik() {
        double totalPendapatan = 0;
        int jumlahVIP = 0;
        int menungguValidasi = 0;

        for (Transaksi t : daftarTransaksi) {
            if (t.getStatus().contains("Lunas")) {
                double harga = t.getPaket().getHarga();
                if (t.getClient() instanceof PotonganHarga) {
                    harga -= ((PotonganHarga) t.getClient()).hitungDiskon(harga);
                }
                totalPendapatan += harga;
            } else {
                menungguValidasi++;
            }

            if (t.getClient() instanceof ClientVIP) {
                jumlahVIP++;
            }
        }

        System.out.println("\n======================================");
        System.out.println("STATISTIK STUDIO FOTOGRAFI");
        System.out.println("======================================");
        System.out.println("Total Akun Terdaftar  : " + daftarAkun.size());
        System.out.println("Total Transaksi Masuk : " + daftarTransaksi.size());
        System.out.println("Menunggu Validasi     : " + menungguValidasi + " transaksi");
        System.out.println("Jumlah Klien VIP      : " + jumlahVIP + " orang");
        System.out.println("Total Pendapatan      : Rp" + totalPendapatan);
        System.out.println("======================================");
    }
}