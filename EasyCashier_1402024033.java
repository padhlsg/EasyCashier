// Muhammad Fadhil Swarigading   
// 1402024033

// Tugas 18
import java.util.*;

public class EasyCashier_1402024033 {
    public static void main(String[] args) {
        // Membuat scanner untuk input
        Scanner isi = new Scanner(System.in);

        // Header aplikasi
        System.out.println("========================================");
        System.out.println("-------- Program EasyCashier -----------");
        System.out.println("----- Muhammad Fadhil Swarigading / 1402024033 -----------");

        // Deklarasi array menu dan harganya
        String[] makanWarung = {"Nasi Putih", "Sate Padang", "Ayam Bakar Rendang", "Soto Padang", "Nasi Kapau", "Dendeng Balado"};
        int[] hargaMakan = {12000, 44000, 31000, 27000, 45000, 31000};
        int maxMenu = makanWarung.length; // Jumlah menu

        // Variabel utama
        boolean jalanGak = true; // Kontrol loop utama
        int pilihMenu; // Pilihan menu pengguna
        int nomorPesanan = 0; // Nomor menu yang dipesan
        int jumlahPesanan = 0; // Jumlah pesanan
        int totalPesanan = 0; // Total item dalam keranjang
        int totalHarga = 0; // Total harga seluruh pesanan
        int uangBayar = 0; // Jumlah uang yang dibayarkan
        int uangKembalian = 0; // Uang kembalian

        // Array untuk menyimpan pesanan
        String[] pesanMakan = new String[100];
        int[] hargaPesan = new int[100];

        // Loop utama aplikasi
        while (jalanGak) {
            // Menu utama
            System.out.println("1. Lihat Daftar Menu\n" +
                               "2. Tambah Menu\n" +
                               "3. Tambah Pesanan Menu\n" +
                               "4. Lihat Keranjang\n" +
                               "5. Bayar\n" +
                               "6. Keluar");
            System.out.print("Pilih Sistem Menu: ");
            pilihMenu = isi.nextInt();
            isi.nextLine(); // Membersihkan buffer newline

            // Menu 1: Lihat Daftar Menu
            if (pilihMenu == 1) {
                System.out.println("================= Lihat Daftar Menu =========================");
                System.out.println("No.     Nama Makanan                Harga");
                for (int j = 0; j < maxMenu; j++) {
                    String output = (j + 1) + ".      " + makanWarung[j];
                    while (output.length() < 35) {
                        output += " ";
                    }
                    output += hargaMakan[j];
                    System.out.println(output);
                }
                System.out.println("============================================================");
                System.out.print("Ingin kembali ke menu awal? (Y/T): ");
                String ulang = isi.nextLine();
                if (ulang.equalsIgnoreCase("T")) {
                    System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa!");
                    jalanGak = false;
                }else if(ulang.equalsIgnoreCase("Y")){
                   jalanGak = true;
                }else{
                    System.out.println("Maaf input yang anda masukan salah!");
                }
            }

            // Menu 2: Tambah Menu Baru
            if (pilihMenu == 2) {
                System.out.println("=============== Tambah Menu Baru =================");
                System.out.print("Masukkan nama menu baru: ");
                String namaMenuBaru = isi.nextLine();
                System.out.print("Masukkan harga menu baru: ");
                int hargaMenuBaru = isi.nextInt();
                isi.nextLine(); // Membersihkan buffer newline

                if (hargaMenuBaru == 0) {
                    System.out.println("\nMenu gagal ditambahkan");
                    System.out.println("============================================================");
                    System.out.print("Ingin kembali ke menu awal? (Y/T): ");
                } else {
                    // Buat array baru dengan ukuran lebih besar
                    String[] tempMakanWarung = new String[maxMenu + 1];
                    int[] tempHargaMakan = new int[maxMenu + 1];

                    // Salin elemen lama ke array baru
                    for (int j = 0; j < maxMenu; j++) {
                        tempMakanWarung[j] = makanWarung[j];
                        tempHargaMakan[j] = hargaMakan[j];
                    }

                    // Tambahkan menu baru
                    tempMakanWarung[maxMenu] = namaMenuBaru;
                    tempHargaMakan[maxMenu] = hargaMenuBaru;

                    makanWarung = tempMakanWarung;
                    hargaMakan = tempHargaMakan;
                    maxMenu++;

                    System.out.println("\nMenu berhasil ditambahkan!");
                    System.out.println("============================================================");
                    System.out.print("Ingin kembali ke menu awal? (Y/T): ");
                }
                String ulang = isi.nextLine();
                if (ulang.equalsIgnoreCase("T")) {
                    System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa!");
                    jalanGak = false;
                }else if(ulang.equalsIgnoreCase("Y")){
                    jalanGak = true;
                }else{
                    System.out.println("Maaf input yang anda masukan salah!");
                }

                System.out.println("============================================================");
            }

            // Menu 3: Tambah Pesanan Menu
            if (pilihMenu == 3) {
                System.out.println("================= Tambah Pesanan =========================");
                for (int i = 0; i < maxMenu; i++) {
                    System.out.println((i + 1) + ". " + makanWarung[i] + " - Rp" + hargaMakan[i]);
                }
                System.out.print("Pilih nomor menu yang ingin dipesan: ");
                nomorPesanan = isi.nextInt();
                isi.nextLine();

                // Validasi pilihan menu
                if (nomorPesanan > 0 && nomorPesanan <= maxMenu) {
                    System.out.print("Masukkan jumlah pesanan: ");
                    jumlahPesanan = isi.nextInt();
                    isi.nextLine(); // Membersihkan buffer

                    // Jika jumlah pesanan 0, tampilkan pesan kesalahan
                    if (jumlahPesanan == 0) {
                        System.out.println("Jumlah pesanan harus lebih dari nol!");
                        System.out.println("============================================================");
                        System.out.print("Ingin kembali ke menu awal? (Y/T): ");
                    } else {
                        pesanMakan[totalPesanan] = makanWarung[nomorPesanan - 1];
                        hargaPesan[totalPesanan] = hargaMakan[nomorPesanan - 1];
                        totalHarga += hargaMakan[nomorPesanan - 1] * jumlahPesanan;
                        totalPesanan++;
                        System.out.println("Pesanan berhasil ditambahkan!");
                        System.out.println("============================================================");
                        System.out.print("Ingin kembali ke menu awal? (Y/T): ");
                    }
                } else {
                    System.out.println("Menu tidak tersedia.");
                    System.out.println("============================================================");
                    System.out.print("Ingin kembali ke menu awal? (Y/T): ");
                }
                String ulang = isi.nextLine();
                if (ulang.equalsIgnoreCase("T")) {
                    System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa!");
                    jalanGak = false;
                }else if(ulang.equalsIgnoreCase("Y")){
                    jalanGak = true;
                }else{
                    System.out.println("Maaf input yang anda masukan salah!");
                }
            }

            // Menu 4: Lihat Keranjang
            if (pilihMenu == 4) {
                System.out.println("================= Lihat Keranjang =========================");
                if (totalPesanan == 0) {
                    System.out.println("Keranjang kosong !");
                    System.out.println("============================================================");
                    System.out.print("Ingin kembali ke menu awal? (Y/T): ");
                } else {
                    System.out.println("No.  Nama Makanan                Harga        Jumlah");
                    for (int i = 0; i < totalPesanan; i++) {
                        String output = (i + 1) + ".   " + pesanMakan[i];
                        while (output.length() < 35) {
                            output += " ";
                        }
                        output += "Rp" + hargaPesan[i] + "         " + (totalHarga / hargaPesan[i]) + "x";
                        System.out.println(output);
                    }
                    System.out.println("============================================================");
                    System.out.println("Total Harga: Rp" + totalHarga);
                    System.out.println("============================================================");
                    System.out.print("Ingin kembali ke menu awal? (Y/T): ");
                }
                String ulang = isi.nextLine();
                if (ulang.equalsIgnoreCase("T")) {
                    System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa!");
                    jalanGak = false;
                } else if (ulang.equalsIgnoreCase("Y")) {
                    jalanGak = true;
                } else {
                    System.out.println("Maaf input yang anda masukan salah!");
                }
            }

            // Menu 5: Bayar
            if (pilihMenu == 5) {
                System.out.println("================= Bayar =========================");
                if (totalPesanan == 0) {
                    System.out.println("Keranjang kosong tidak ada yang harus dibayar!");
                    System.out.println("===============================================");
                    System.out.print("Ingin kembali ke menu awal? (Y/T): ");
                } else {
                    System.out.println("Total yang harus dibayar: " + totalHarga);
                    System.out.print("Masukan jumlah uang : Rp");
                    uangBayar = isi.nextInt();

                    // Cek pembayaran
                    if (uangBayar > totalHarga) {
                        uangKembalian = uangBayar - totalHarga;
                        System.out.println("Pembayaran berhasil! Kembalian: Rp" + uangKembalian);
                        totalPesanan = 0;
                        totalHarga = 0;
                        System.out.println("Keranjang telah dikosongkan!");
                        System.out.println("===============================================");
                        System.out.print("Ingin kembali ke menu awal? (Y/T): ");
                    } else if (uangBayar == totalHarga) {
                        System.out.println("Pembayaran berhasil! Uang Pas");
                        totalPesanan = 0;
                        totalHarga = 0;
                        System.out.println("Keranjang telah dikosongkan!");
                        System.out.println("===============================================");
                        System.out.print("Ingin kembali ke menu awal? (Y/T): ");
                    } else {
                        System.out.println("Uang kurang ambil di atm dulu!");
                        System.out.println("===============================================");
                        System.out.print("Ingin kembali ke menu awal? (Y/T): ");
                    }
                }
                String ulang = isi.nextLine();
                if (ulang.equalsIgnoreCase("T")) {
                    System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa!");
                    jalanGak = false;
                } else if (ulang.equalsIgnoreCase("Y")) {
                    jalanGak = true;
                } else {
                    System.out.println("Maaf input yang anda masukan salah!");
                }
            }

            // Menu 6: Keluar
            if (pilihMenu == 6) {
                System.out.println("Terima kasih telah menggunakan program ini. Sampai jumpa!");
                jalanGak = false;
            }
        }
    }
}
