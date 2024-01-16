package gui;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.LinkedList;

public class index {

    public static void main(String[] args) {

        // ==================================== deklarasi data konser ===========================
        record Peserta(String namanya, int nomorHp, String email) {}
        record Konser(String namaKonser, String[] penyanyi, String tglKonser,  int jumlahTiketGold, int hargaTiketGold, int jumlahTiketSilver, 
                        int hargaTiketSilver, int jumlahTiketBroze, int hargaTiketBroze, String fotonya) {}
        record Transaksi(String namanya, int nomorHp, String email, String nama_konsernya, int kategori_tiket, int jumlahTiketnya){}

        // ---------- array untuk menyimpan objek peserta dan konser
        LinkedList<Peserta> listPeserta = new LinkedList<>();
        ArrayList<Konser> listKonser = new ArrayList<>();

        // 
        listPeserta.add(new Peserta("andi" , 123,  "p"));
        listPeserta.add(new Peserta("anda" , 234 ,"p"));
        listPeserta.add(new Peserta("andu" , 345 , "l"));

        // Menambahkan objek konser ke Array
        listKonser.add(new Konser("Play Music Festival", new String[]{"si A", "si B"}, "23 januari 2024", 20, 500000, 20, 300000, 20, 200000, "tulus.jpeg"));
        listKonser.add(new Konser("West Java Festival", new String[]{"ana", "ani"}, "11 febuari 2024", 10, 400000, 20, 300000, 20, 200000, "wjf.jpeg"));
        listKonser.add(new Konser("Coolab Fest", new String[]{"Justin bieber"}, "1 januari 2024", 20, 500000, 20, 300000, 20, 200000, "coolab.jpeg"));
        listKonser.add(new Konser("Play Music Banduung", new String[]{"haha", "hihi"}, "23 januari 2024", 20, 500000, 20, 300000, 20, 200000, "pm.jpeg"));
        listKonser.add(new Konser("Bahaya Mantan Terindah", new String[]{"Kahitna","Arsyi","Tiara Andini"}, "11 febuari 2024", 10, 400000, 20, 300000, 20, 200000, "bt.jpeg"));
        listKonser.add(new Konser("Joy Land", new String[]{"Justin bieber"}, "1 januari 2024", 20, 500000, 20, 300000, 20, 200000, "jl.jpeg"));
        listKonser.add(new Konser("Rock In Solo", new String[]{"Penyanyi A", "Penyanyi B"}, "23 januari 2024", 20, 500000, 20, 300000, 20, 200000, "ris.jpeg"));

        // ===================================== deklarasi asset gui ========================
        JLabel judul;
        Color abu = new Color(175, 181, 186);
        Color colorBtn = new Color(37, 50, 61);

        // =================== container open ======================

        // Container Aplikasi
        JFrame form = new JFrame("Aplikasi Ticket Konser");

        // mengatur ukuran container
        form.setPreferredSize(new Dimension(1280, 720));

        // agar di tengah
        form.setLayout(null);

        // membuat exit program berjalan
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // agar posisi container di tengah
        form.setLocationRelativeTo(null);

        // Background
        form.getContentPane().setBackground(new Color(5, 18, 27));

        // =================== container closed ======================

        // =================================================================

        // judul Aplikasi
        judul = new JLabel("Aplikasi Konser");
        judul.setBounds(460, 28, 461, 74);
        judul.setFont(new Font("Cabinet Grotesk", Font.BOLD, 50));
        judul.setForeground(Color.white);
        form.add(judul);

        // ============================================== Konser ==========================
        // =================== card Open ====================
        int kolom = 0;
        int baris = 0;
        
        for (int i = 0; i < listKonser.size(); i++) {
            // =========================== banner ==========================================
            JLabel img = new JLabel();
            img.setBounds(46 + kolom * 240, 128 + baris * 310, 226, 137);
            img.setIcon(new ImageIcon(new ImageIcon("src/gui/asset/"+listKonser.get(i).fotonya()).getImage().getScaledInstance(226, 137, Image.SCALE_DEFAULT)));
            form.add(img);
        
            // ================== text banner =======================
            JPanel card = new JPanel();
            card.setBounds(46 + kolom * 240, 266 + baris * 310, 226, 145);
            card.setBackground(new Color(25, 37, 46));
            card.setLayout(null);
            form.add(card);
        
            // nama Konser
            JLabel textNamaKonser = new JLabel(listKonser.get(i).namaKonser());
            textNamaKonser.setBounds(10, 10, 195, 18);
            textNamaKonser.setFont(new Font("poppins", Font.PLAIN, 16));
            textNamaKonser.setForeground(Color.white);
            card.add(textNamaKonser);
        
            // tanggal Konser
            JLabel textTanggalKonser = new JLabel(listKonser.get(i).tglKonser());
            textTanggalKonser.setBounds(10, 35, 195, 14);
            textTanggalKonser.setFont(new Font("poppins", Font.PLAIN, 12));
            textTanggalKonser.setForeground(Color.gray);
            card.add(textTanggalKonser);
        
            // Tombol Ticket -------- gold
            JButton btnPilihTicketGold = new JButton("Gold");
            btnPilihTicketGold.setBounds(10, 55, 85, 23);
            btnPilihTicketGold.setBackground(colorBtn);
            btnPilihTicketGold.setOpaque(true);
            btnPilihTicketGold.setBorder(null);
            btnPilihTicketGold.setForeground(Color.white);
            card.add(btnPilihTicketGold);

            // Harga Konser
            JLabel labelRpGold = new JLabel("Rp.");
            labelRpGold.setBounds(105, 55, 29, 14);
            labelRpGold.setFont(new Font("poppins", Font.BOLD, 12));
            labelRpGold.setForeground(Color.white);
            JLabel textHargaKonserGold = new JLabel(String.valueOf(listKonser.get(i).hargaTiketSilver()));
            textHargaKonserGold.setBounds(134, 55, 195, 14);
            textHargaKonserGold.setFont(new Font("poppins", Font.BOLD, 12));
            textHargaKonserGold.setForeground(Color.white);
            card.add(textHargaKonserGold);
            card.add(labelRpGold);

             // Tombol Tombol Ticket -------- silver
             JButton btnPilihTicketSilver = new JButton("Silver");
             btnPilihTicketSilver.setBounds(10, 85, 85, 23);
             btnPilihTicketSilver.setBackground(colorBtn);
             btnPilihTicketSilver.setOpaque(true);
             btnPilihTicketSilver.setBorder(null);
             btnPilihTicketSilver.setForeground(Color.white);
             card.add(btnPilihTicketSilver);
 
             // Harga Konser
             JLabel labelRpSilver = new JLabel("Rp.");
             labelRpSilver.setBounds(105, 85, 29, 14);
             labelRpSilver.setFont(new Font("poppins", Font.BOLD, 12));
             labelRpSilver.setForeground(Color.white);
             JLabel textHargaKonserSilver = new JLabel(String.valueOf(listKonser.get(i).hargaTiketSilver()));
             textHargaKonserSilver.setBounds(134, 85, 195, 14);
             textHargaKonserSilver.setFont(new Font("poppins", Font.BOLD, 12));
             textHargaKonserSilver.setForeground(Color.white);
             card.add(textHargaKonserSilver);
             card.add(labelRpSilver);

              // Tombol Ticket -------- Bronze
            JButton btnPilihTicketBronze = new JButton("Bronze");
            btnPilihTicketBronze.setBounds(10, 115, 85, 23);
            btnPilihTicketBronze.setBackground(colorBtn);
            btnPilihTicketBronze.setOpaque(true);
            btnPilihTicketBronze.setBorder(null);
            btnPilihTicketBronze.setForeground(Color.white);
            card.add(btnPilihTicketBronze);

            // Harga Konser
            JLabel labelRpBronze = new JLabel("Rp.");
            labelRpBronze.setBounds(105, 115, 29, 14);
            labelRpBronze.setFont(new Font("poppins", Font.BOLD, 12));
            labelRpBronze.setForeground(Color.white);
            JLabel textHargaKonserBronze = new JLabel(String.valueOf(listKonser.get(i).hargaTiketSilver()));
            textHargaKonserBronze.setBounds(134, 115, 195, 14);
            textHargaKonserBronze.setFont(new Font("poppins", Font.BOLD, 12));
            textHargaKonserBronze.setForeground(Color.white);
            card.add(textHargaKonserBronze);
            card.add(labelRpBronze);

            kolom++;  // Pindah ke kolom berikutnya
            if (kolom == 5) {  // Jika mencapai batas kolom tertentu (misalnya, 3), pindah ke baris berikutnya
                kolom = 0;
                baris++;
             }
        }
        

        // ==================== card Closed ====================


        // ===================== Pembelian Closed ======================
        

        form.pack();
        // agar container tampil
        form.setVisible(true);
    }

}