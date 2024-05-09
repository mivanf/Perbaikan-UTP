import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        //Do your magic here...
        Scanner input = new Scanner(System.in); // Memanggil Scanner agar bisa memasukkan input
        System.out.print("Selamat datang di Pemesanan Tiket!"); // Menampilkan output Selamat datang di Pemesanan Tiket!
        System.out.print("\nMasukkan nama pemesan: "); // Menampilkan output Masukkan nama pemesan: pada baris baru
        String nama = input.nextLine(); // variable nama dengan nilai sesuai input dari pengguna
        System.out.print("Pilih jenis tiket:"); // Menampilkan output 
        System.out.print("\n1. CAT 8\n2. CAT 1\n3. FESTIVAL\n4. VIP\n5. UNLIMITED EXPERIENCE\nMasukkan pilihan: "); // Output pilihan jenis tiket untuk dipilih pengguna
        int jenisTiket = input.nextInt(); // Variable jenisTiket dengan nilai sesuai dari input pengguna

        TiketKonser tiket = null; // Variable tiket dengan tipe data TiketKonser dengan nilai awal null
        switch (jenisTiket) { // Akan menjalankan case sesuai dengan inout pada jenisTiket
            case 1:
                tiket = new CAT8(); // Membuat objek tiket untuk CAT8 dalam variable tiket
                break; // Agar program berhenti disini dan tidak menjankan switch case dibawahnya
            case 2:
                tiket = new CAT1(); // Membuat objek tiket untuk CAT1 dalam variable tiket
                break; // Agar program berhenti disini dan tidak menjankan switch case dibawahnya
            case 3:
                tiket = new FESTIVAL(); // Membuat objek tiket untuk FESTIVAL dalam variable tiket
                break; // Agar program berhenti disini dan tidak menjankan switch case dibawahnya
            case 4:
                tiket = new VIP(); // Membuat objek tiket untuk VIP dalam variable tiket
                break; // Agar program berhenti disini dan tidak menjankan switch case dibawahnya
            case 5:
                tiket = new VVIP(); // Membuat objek tiket untuk VVIP dalam variable tiket
                break; // Agar program berhenti disini dan tidak menjankan switch case dibawahnya
            default: // Akan berjalan jika input diluar pilihan 1-5
                System.out.println("Input tidak valid!"); // Memberikan output Input tidak valid!
                break; // Agar program berhenti disini dan tidak menjankan switch case dibawahnya
        }

        String kodeBooking = generateKodeBooking(); // Variable kodeBooking dengan tipe data String, lalu memanggil method generateKodeBooking() untuk mendapatkan kodeBooking
        String date = getCurrentDate(); // Variable date dengan tipe data String, lalu memanggil method getCurrentDate() untuk mendapatkan date

        System.out.println("\n----- Detail Pemesanan -----");// Menampilkan output ----- Detail Pemesanan -----
        System.out.println("Nama Pemesan: " + nama);// Menampilkan output detail nama pemesan
        System.out.println("Kode Booking: " + kodeBooking);// Menampilkan output detail kode booking
        System.out.println("Tanggal pemesanan: " + date);// Menampilkan output detail tanggal pemesanan
        System.out.println("Tiket yang dipesan: " + tiket.getJenisTiket());// Menampilkan output detail jenis tiket yang dipilih
        System.out.println("Total harga: " + formatHarga(tiket.getHarga()) + " USD");// Menampilkan output harga tiket dengan akhiran USD
        input.close();
    }

    /*
     * Jangan ubah isi method dibawah ini, nama method boleh diubah
     * Method ini dipanggil untuk mendapatkan kode pesanan atau kode booking
     * Panggil method ini untuk kelengkapan mencetak output nota pesanan
     */
    public static String generateKodeBooking() {
        StringBuilder sb = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        int length = 8;

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * characters.length());
            sb.append(characters.charAt(index));
        }

        return sb.toString();
    }

    /*
     * Jangan ubah isi method dibawah ini, nama method boleh diubah
     * Method ini dipanggil untuk mendapatkan waktu terkini
     * Panggil method ini untuk kelengkapan mencetak output nota pesanan
     */
    public static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }

    public static String formatHarga(double harga) { // Method untuk mendapatkan format dari total harga menjadi 0.0E0
        DecimalFormat decimalFormat = new DecimalFormat("0.0E0"); // Objek untuk menentukan bentuk output menjadi 0.0E0
        return decimalFormat.format(harga); // Mengembalikan hasil dari konversi ke 0.0E0
    }
}