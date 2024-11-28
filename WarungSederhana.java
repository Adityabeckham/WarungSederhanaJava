
package com.mycompany.warungsederhana;
import java.util.Scanner;

public class WarungSederhana {


    // Daftar menu item
    static String[] menu = {"Nasi Goreng", "Mie Goreng", "Ayam Penyet", "Es Teh", "Kopi"};
    static int[] harga = {15000, 12000, 25000, 5000, 8000};

    // Method untuk menampilkan menu
    public static void tampilkanMenu() {
        System.out.println("\n------ Daftar Menu Warung Sederhana ------");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i] + " - Rp" + harga[i]);
        }
        System.out.println("----------------------------------------");
    }

    // Method untuk menghitung total harga
    public static int hitungTotal(int[] pesanan) {
        int total = 0;
        for (int i = 0; i < pesanan.length; i++) {
            total += pesanan[i];
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] pesanan = new int[menu.length]; // Array untuk menyimpan jumlah item yang dipesan
        int pilihan, jumlah;
        boolean lanjut = true;

        // Menampilkan menu dan memilih item yang ingin dipesan
        while (lanjut) {
            tampilkanMenu();

            System.out.print("Pilih nomor menu (1-5) atau tekan 0 untuk keluar: ");
            pilihan = scanner.nextInt();

            if (pilihan == 0) {
                lanjut = false;
            } else if (pilihan >= 1 && pilihan <= 5) {
                System.out.print("Masukkan jumlah pesanan " + menu[pilihan - 1] + ": ");
                jumlah = scanner.nextInt();
                pesanan[pilihan - 1] += jumlah; // Menambahkan jumlah pesanan
                System.out.println("Pesanan " + jumlah + " " + menu[pilihan - 1] + " berhasil ditambahkan.\n");
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        // Menampilkan pesanan dan total harga
        System.out.println("\n------ Rincian Pesanan Anda ------");
        int totalHarga = 0;
        for (int i = 0; i < menu.length; i++) {
            if (pesanan[i] > 0) {
                int hargaItem = harga[i] * pesanan[i];
                System.out.println(menu[i] + " x " + pesanan[i] + " - Rp" + hargaItem);
                totalHarga += hargaItem;
            }
        }

        // Menampilkan total dan meminta pembayaran
        System.out.println("------------------------------------");
        System.out.println("Total Harga: Rp" + totalHarga);

        System.out.print("Masukkan jumlah uang untuk membayar: Rp");
        int uangPembayaran = scanner.nextInt();

        if (uangPembayaran >= totalHarga) {
            int kembalian = uangPembayaran - totalHarga;
            System.out.println("Pembayaran berhasil. Kembalian Anda: Rp" + kembalian);
        } else {
            System.out.println("Uang Anda tidak cukup. Pembayaran gagal.");
        }

        scanner.close();
    }
}



   
