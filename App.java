package gui;

/**
 * ---> belum
 * simpan kategori tiket ketransaksi
 * stack tiket
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class App {

    public static void main(String[] args) {

        // ==================================== deklarasi data konser
        // ===========================
        record Peserta(String namanya, int nomorHp, String email) {
        }
        record Konser(String namaKonser, String tglKonser, int jumlahTiketGold, int hargaTiketGold,
                int jumlahTiketSilver,
                int hargaTiketSilver, int jumlahTiketBroze, int hargaTiketBroze, String fotonya) {
        }
        record Transaksi(String namanya, int nomorHp, String email, String nama_konsernya, int kategori_tiket,
                int jumlahTiketnya, int totalharga) {
        }

        // ---------- array untuk menyimpan objek peserta dan konser
        LinkedList<Peserta> listPeserta = new LinkedList<>();
        ArrayList<Konser> listKonser = new ArrayList<>();

        // ----------- riwayat transaksi
        Queue<Transaksi> Riwayat_transaksi = new LinkedList<>();

        // Menambahkan objek konser ke Array
        listKonser.add(new Konser("Play Music Festival", "23 januari 2024", 13, 500000,
                17, 300000, 1, 200000, "tulus.jpeg"));
        listKonser.add(new Konser("West Java Festival", "11 febuari 2024", 10, 400000,
                20, 300000, 22, 200000, "wjf.jpeg"));
        listKonser.add(new Konser("Coolab Fest", "1 januari 2024", 7, 500000, 18,
                300000, 27, 200000, "coolab.jpeg"));
        listKonser.add(new Konser("Play Music Banduung", "23 januari 2024", 19, 500000,
                33, 300000, 32, 200000, "pm.jpeg"));
        listKonser.add(new Konser("Bahaya Mantan Terindah",
                "11 febuari 2024", 15, 400000, 25, 300000, 30, 200000, "bt.jpeg"));

        // ============================ tiket
        ArrayList<ArrayList<Stack<Integer>>> listTiketParaKonser = new ArrayList<>();
        for (int i = 0; i < listKonser.size(); i++) {
            listTiketParaKonser.add(new ArrayList<>());
            listTiketParaKonser.get(i).add(new Stack<>());
            for (int n = 1; n <= listKonser.get(i).jumlahTiketGold(); n++) {
                listTiketParaKonser.get(i).get(0).push(n);
            }
            listTiketParaKonser.get(i).add(new Stack<>());
            for (int n = 1; n <= listKonser.get(i).jumlahTiketSilver(); n++) {
                listTiketParaKonser.get(i).get(1).push(n);
            }
            listTiketParaKonser.get(i).add(new Stack<>());
            for (int n = 1; n <= listKonser.get(i).jumlahTiketBroze(); n++) {
                listTiketParaKonser.get(i).get(2).push(n);
            }
        }

        // ===============================================================
        // Deklarasi
        JLabel judul, Rp;
        JPanel shop;
        Color abu = new Color(175, 181, 186);
        Color colorBtn = new Color(37, 50, 61);
        Color biru = new Color(0, 151, 255);
        JPanel card;

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

        // ============================= Cari konser hanya bermodalkan nama konser
        // ============
        // ----------- membuat input cari konser
        JTextField inputCariKonser = new JTextField();
        inputCariKonser.setBounds(410, 28, 400, 40);
        inputCariKonser.setBackground(colorBtn);
        inputCariKonser.setBorder(null);
        inputCariKonser.setFont(new Font("poppins", Font.PLAIN, 16));
        inputCariKonser.setForeground(Color.white);
        inputCariKonser.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        form.add(inputCariKonser);
        // ------------- membuat tombol cari konser
        JButton btnCariKonser = new JButton("Cari Konser");
        btnCariKonser.setBounds(810, 28, 100, 40);
        btnCariKonser.setBackground(biru);
        btnCariKonser.setOpaque(true);
        btnCariKonser.setBorder(null);
        btnCariKonser.setForeground(Color.white);
        btnCariKonser.setFont(new Font("poppins", Font.PLAIN, 16));
        btnCariKonser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        // --------------- action cari konser
        btnCariKonser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean konserDitemukan = false;
                if (inputCariKonser.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(form, "Form Cari konser Belum Terisi Kosong", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    // mencari indeks konser hanya bermodalkan nama konser
                    for (int i = 0; i < listKonser.size(); i++) {
                        if (listKonser.get(i).namaKonser().equals(inputCariKonser.getText())) {
                            konserDitemukan = true;
                            System.out.println(listKonser.get(i));
                            JOptionPane.showMessageDialog(form, listKonser.get(i));
                            break; // Keluar dari loop setelah menemukan konser
                        }
                    }
                    // jika konser tidak ditemukan
                    if (!konserDitemukan) {
                        System.out.println("Konser tidak ditemukan");
                        JOptionPane.showMessageDialog(form, "Konser Tidak Ditemukan");
                    }
                    inputCariKonser.setText("");
                }
            }

        });
        form.add(btnCariKonser);

        // =================================================== card konser
        // ======================================================
        JButton[] btnPilihTicketArrayGold = new JButton[listKonser.size()];
        JButton[] btnPilihTicketArraySilver = new JButton[listKonser.size()];
        JButton[] btnPilihTicketArrayBronze = new JButton[listKonser.size()];
        for (int i = 0; i < listKonser.size(); i++) {
            // =========================== banner ==========================================
            JLabel img = new JLabel();
            img.setBounds(46 + i * 240, 128, 226, 137);
            img.setIcon(new ImageIcon(new ImageIcon(listKonser.get(i).fotonya()).getImage()
                    .getScaledInstance(226, 137, Image.SCALE_DEFAULT)));
            form.add(img);

            // ================== text banner =======================
            card = new JPanel();
            card.setBounds(46 + i * 240, 266, 226, 145);
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
            btnPilihTicketArrayGold[i] = new JButton("Gold");
            btnPilihTicketArrayGold[i].setBounds(10, 55, 85, 23);
            btnPilihTicketArrayGold[i].setBackground(colorBtn);
            btnPilihTicketArrayGold[i].setOpaque(true);
            btnPilihTicketArrayGold[i].setBorder(null);
            btnPilihTicketArrayGold[i].setForeground(Color.white);
            btnPilihTicketArrayGold[i].setFocusable(false);
            btnPilihTicketArrayGold[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            card.add(btnPilihTicketArrayGold[i]);

            // Harga Konser
            JLabel labelRpGold = new JLabel("Rp.");
            labelRpGold.setBounds(105, 55, 29, 14);
            labelRpGold.setFont(new Font("poppins", Font.BOLD, 12));
            labelRpGold.setForeground(Color.white);
            JLabel textHargaKonserGold = new JLabel(String.valueOf(listKonser.get(i).hargaTiketGold()));
            textHargaKonserGold.setBounds(134, 55, 60, 14);
            textHargaKonserGold.setFont(new Font("poppins", Font.BOLD, 12));
            textHargaKonserGold.setForeground(Color.white);
            card.add(textHargaKonserGold);
            card.add(labelRpGold);

            // Tombol Tombol Ticket -------- silver
            btnPilihTicketArraySilver[i] = new JButton("Silver");
            btnPilihTicketArraySilver[i].setBounds(10, 85, 85, 23);
            btnPilihTicketArraySilver[i].setBackground(colorBtn);
            btnPilihTicketArraySilver[i].setOpaque(true);
            btnPilihTicketArraySilver[i].setBorder(null);
            btnPilihTicketArraySilver[i].setForeground(Color.white);
            btnPilihTicketArraySilver[i].setFocusable(false);
            btnPilihTicketArraySilver[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            card.add(btnPilihTicketArraySilver[i]);

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
            btnPilihTicketArrayBronze[i] = new JButton("Bronze");
            btnPilihTicketArrayBronze[i].setBounds(10, 115, 85, 23);
            btnPilihTicketArrayBronze[i].setBackground(colorBtn);
            btnPilihTicketArrayBronze[i].setOpaque(true);
            btnPilihTicketArrayBronze[i].setBorder(null);
            btnPilihTicketArrayBronze[i].setForeground(Color.white);
            btnPilihTicketArrayBronze[i].setFocusable(false);
            btnPilihTicketArrayBronze[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            card.add(btnPilihTicketArrayBronze[i]);

            // Harga Konser
            JLabel labelRpBronze = new JLabel("Rp.");
            labelRpBronze.setBounds(105, 115, 29, 14);
            labelRpBronze.setFont(new Font("poppins", Font.BOLD, 12));
            labelRpBronze.setForeground(Color.white);
            JLabel textHargaKonserBronze = new JLabel(String.valueOf(listKonser.get(i).hargaTiketBroze()));
            textHargaKonserBronze.setBounds(134, 115, 195, 14);
            textHargaKonserBronze.setFont(new Font("poppins", Font.BOLD, 12));
            textHargaKonserBronze.setForeground(Color.white);
            card.add(textHargaKonserBronze);
            card.add(labelRpBronze);
        }

        // ==================== card Closed ====================

        // ===================== Pembelian Open ======================

        // ===================== Container Pembelian ======================
        shop = new JPanel();
        shop.setBounds(46, 425, 1188, 255);
        shop.setBackground(new Color(25, 37, 46));
        shop.setLayout(null);
        form.add(shop);

        // ============================================================= Data Peserta
        // ==============================================
        // deklarasi
        JLabel lblNama, lblEmail, lblWA, h1, h2, lblJudul, lblTgl, lblPrice, lblJumlah, RpTotal, lblKuotaTiketTersedia;
        JTextField formNama, formEmail, formWA, formJudul, formTgl, kategoritiketyangdipilih, formPrice, formTotal,
                jumlah, kuotaTikettersedia;
        JButton send, btnBeli;
        JLabel iyah = new JLabel();
        iyah.setText("iyah");

        // Judul pembeli
        h1 = new JLabel("Isi Data Pembeli");
        h1.setBounds(38, 27, 359, 29);
        h1.setFont(new Font("Cabinet Grotesk", Font.BOLD, 28));
        h1.setForeground(Color.white);
        shop.add(h1);

        // Judul beli ticket
        h2 = new JLabel("Beli Ticket");
        h2.setBounds(489, 27, 359, 29);
        h2.setFont(new Font("Cabinet Grotesk", Font.BOLD, 28));
        h2.setForeground(Color.white);
        shop.add(h2);

        // Form Pembeli
        // Label Nama
        lblNama = new JLabel("Nama");
        lblNama.setBounds(38, 85, 52, 23);
        lblNama.setFont(new Font("poppins", Font.BOLD, 16));
        lblNama.setForeground(Color.white);
        shop.add(lblNama);

        // form Nama
        formNama = new JTextField();
        formNama.setBounds(160, 85, 240, 28);
        formNama.setBackground(colorBtn);
        formNama.setBorder(null);
        formNama.setFont(new Font("poppins", Font.PLAIN, 16));
        formNama.setForeground(Color.white);
        formNama.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        shop.add(formNama);

        // Label Email
        lblEmail = new JLabel("Email");
        lblEmail.setBounds(38, 125, 52, 23);
        lblEmail.setFont(new Font("poppins", Font.BOLD, 16));
        lblEmail.setForeground(Color.white);
        shop.add(lblEmail);

        // form Email
        formEmail = new JTextField();
        formEmail.setBounds(160, 125, 240, 28);
        formEmail.setBackground(colorBtn);
        formEmail.setBorder(null);
        formEmail.setFont(new Font("poppins", Font.PLAIN, 16));
        formEmail.setForeground(Color.white);
        formEmail.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        shop.add(formEmail);

        // Label WA
        lblWA = new JLabel("No WA");
        lblWA.setBounds(38, 165, 100, 23);
        lblWA.setFont(new Font("poppins", Font.BOLD, 16));
        lblWA.setForeground(Color.white);
        shop.add(lblWA);

        // form WA
        formWA = new JTextField();
        formWA.setBounds(160, 165, 240, 28);
        formWA.setBackground(colorBtn);
        formWA.setBorder(null);
        formWA.setFont(new Font("poppins", Font.PLAIN, 16));
        formWA.setForeground(Color.white);
        formWA.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        shop.add(formWA);

        // Send Data
        send = new JButton("Save");
        send.setBounds(300, 205, 100, 28);
        send.setBackground(biru);
        send.setOpaque(true);
        send.setBorder(null);
        send.setForeground(Color.white);
        send.setFont(new Font("poppins", Font.PLAIN, 16));
        send.setCursor(new Cursor(Cursor.HAND_CURSOR));

        send.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (formNama.getText().isEmpty() && formEmail.getText().isEmpty() && formWA.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(form, "Form Masih Kosong", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                } else if (formNama.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(form, "Form Nama Belum Terisi", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                } else if (formEmail.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(form, "Form Email Belum Terisi", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                } else if (formWA.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(form, "Form No WA Belum Terisi", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    // simpan ke ricord
                    listPeserta.add(
                            new Peserta(formNama.getText(), Integer.valueOf(formWA.getText()), formEmail.getText()));
                    JOptionPane.showMessageDialog(form, "Data Berhasil Tersimpan");
                    iyah.setText("tidak");
                    formNama.setEnabled(false);
                    formEmail.setEnabled(false);
                    formWA.setEnabled(false);
                }
            }

        });
        shop.add(send);

        // =========================================================== Form Beli Ticket
        // ==========================
        // Label Judul Konser
        lblJudul = new JLabel("Judul Konser");
        lblJudul.setBounds(489, 85, 200, 23);
        lblJudul.setFont(new Font("poppins", Font.BOLD, 16));
        lblJudul.setForeground(Color.white);
        shop.add(lblJudul);

        // form Judul Konser
        formJudul = new JTextField();
        formJudul.setBounds(652, 85, 240, 28);
        formJudul.setBackground(colorBtn);
        formJudul.setBorder(null);
        formJudul.setFont(new Font("poppins", Font.PLAIN, 16));
        formJudul.setForeground(Color.white);
        formJudul.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        shop.add(formJudul);

        // Label Tanggal Konser
        lblTgl = new JLabel("Tanggal");
        lblTgl.setBounds(489, 125, 100, 23);
        lblTgl.setFont(new Font("poppins", Font.BOLD, 16));
        lblTgl.setForeground(Color.white);
        shop.add(lblTgl);

        // form Tanggal Konser
        formTgl = new JTextField();
        formTgl.setBounds(652, 125, 240, 28);
        formTgl.setBackground(colorBtn);
        formTgl.setBorder(null);
        formTgl.setFont(new Font("poppins", Font.PLAIN, 16));
        formTgl.setForeground(Color.white);
        formTgl.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        shop.add(formTgl);

        // Label kategori dan Harga tiket
        lblPrice = new JLabel("Ticket");
        lblPrice.setBounds(489, 165, 138, 23);
        lblPrice.setFont(new Font("poppins", Font.BOLD, 16));
        lblPrice.setForeground(Color.white);
        shop.add(lblPrice);
        // form kategori
        kategoritiketyangdipilih = new JTextField();
        kategoritiketyangdipilih.setBounds(652, 165, 118, 28);
        kategoritiketyangdipilih.setBackground(colorBtn);
        kategoritiketyangdipilih.setBorder(null);
        kategoritiketyangdipilih.setFont(new Font("poppins", Font.PLAIN, 16));
        kategoritiketyangdipilih.setForeground(Color.white);
        kategoritiketyangdipilih.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        shop.add(kategoritiketyangdipilih);
        // form Harga
        formPrice = new JTextField();
        formPrice.setBounds(774, 165, 118, 28);
        formPrice.setBackground(colorBtn);
        formPrice.setBorder(null);
        formPrice.setFont(new Font("poppins", Font.PLAIN, 16));
        formPrice.setForeground(Color.white);
        formPrice.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        shop.add(formPrice);
        // Label kuotaTikettersedia
        lblKuotaTiketTersedia = new JLabel("Kuota");
        lblKuotaTiketTersedia.setBounds(489, 210, 100, 23);
        lblKuotaTiketTersedia.setFont(new Font("poppins", Font.BOLD, 16));
        lblKuotaTiketTersedia.setForeground(Color.white);
        shop.add(lblKuotaTiketTersedia);
        // kuotaTikettersedia
        kuotaTikettersedia = new JTextField();
        kuotaTikettersedia.setBounds(652, 205, 240, 28);
        kuotaTikettersedia.setFont(new Font("poppins", Font.PLAIN, 16));
        kuotaTikettersedia.setForeground(Color.white);
        kuotaTikettersedia.setBorder(null);
        kuotaTikettersedia.setBackground(colorBtn);
        kuotaTikettersedia.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        shop.add(kuotaTikettersedia);

        // Label Jumlah
        lblPrice = new JLabel("Jumlah");
        lblPrice.setBounds(957, 85, 100, 23);
        lblPrice.setFont(new Font("poppins", Font.BOLD, 16));
        lblPrice.setForeground(Color.white);
        shop.add(lblPrice);

        // ===================== form Total ============================
        // Form TOTAL
        RpTotal = new JLabel("Rp.");
        RpTotal.setBounds(957, 145, 29, 20);
        RpTotal.setFont(new Font("poppins", Font.BOLD, 16));
        RpTotal.setForeground(Color.white);
        shop.add(RpTotal);

        formTotal = new JTextField();
        formTotal.setBounds(998, 145, 148, 28);
        formTotal.setFont(new Font("poppins", Font.PLAIN, 16));
        formTotal.setForeground(Color.white);
        formTotal.setBorder(null);
        formTotal.setBackground(colorBtn);
        formTotal.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        shop.add(formTotal);
        // ===================== form Total ============================

        // Jumlah
        jumlah = new JTextField();
        jumlah.setBounds(1020, 85, 120, 28);
        jumlah.setFont(new Font("poppins", Font.PLAIN, 16));
        jumlah.setForeground(Color.white);
        jumlah.setBorder(null);
        jumlah.setBackground(colorBtn);
        jumlah.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        shop.add(jumlah);

        jumlah.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    int intJumlah = Integer.parseInt(jumlah.getText());

                    if (intJumlah > 5) {
                        JOptionPane.showMessageDialog(form, "Tidak Bisa Membeli Lebih dari 5", "Alert",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        int intPrice = Integer.parseInt(formPrice.getText());
                        String jmlhTotal = String.valueOf(intPrice * intJumlah);
                        formTotal.setText(jmlhTotal);
                        formTotal.setEnabled(false);
                    }
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

        });

        // ===================== Tombol Beli dan Total =====================
        // Tombol Beli
        btnBeli = new JButton("Beli Ticket");
        btnBeli.setBounds(957, 185, 190, 48);
        btnBeli.setBackground(biru);
        btnBeli.setOpaque(true);
        btnBeli.setBorder(null);
        btnBeli.setForeground(Color.white);
        btnBeli.setFont(new Font("poppins", Font.PLAIN, 20));
        btnBeli.setCursor(new Cursor(Cursor.HAND_CURSOR));
        shop.add(btnBeli);

        btnBeli.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int intJumlah = Integer.parseInt(jumlah.getText());
                int intPrice = Integer.parseInt(formPrice.getText());
                int intkategoritiket = 0;
                if (kategoritiketyangdipilih.getText().equals("Gold"))
                    intkategoritiket = 0;
                if (kategoritiketyangdipilih.getText().equals("Silver"))
                    intkategoritiket = 1;
                if (kategoritiketyangdipilih.getText().equals("Bronze"))
                    intkategoritiket = 2;
                int indexkonserygdipilih = 0;

                int hargatotal = intPrice * intJumlah;
                String jmlhTotal = String.valueOf(hargatotal);
                formTotal.setText(jmlhTotal);
                formTotal.setEnabled(false);
                // mencari indeks konser hanya bermodalkan nama konser
                for (int i = 0; i < listKonser.size(); i++) {
                    if (listKonser.get(i).namaKonser().equals(formJudul.getText())) {
                        indexkonserygdipilih = i; // Mengembalikan indeks jika nama konser cocok
                    }
                }
                if (formJudul.getText().isEmpty() && formTgl.getText().isEmpty() && formPrice.getText().isEmpty()
                        && jumlah.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(form, "Belum Memilih Ticket", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                } else if (formNama.getText().isEmpty() && formEmail.getText().isEmpty()
                        && formWA.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(form, "Data Pembeli Belum Terisi", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                } else if (formNama.isEnabled() == true) {
                    JOptionPane.showMessageDialog(form, "Data Pembeli Belum Tersimpan", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                } else if (Integer.parseInt(jumlah.getText()) > listTiketParaKonser.get(indexkonserygdipilih)
                        .get(intkategoritiket).size()) {
                    JOptionPane.showMessageDialog(form, "Kuota Tiket kurang / tidak tersedia", "Alert",
                            JOptionPane.WARNING_MESSAGE);
                } else {

                    // ==== tiket
                    // pop sebanyak tiket yang dibeli
                    for (int i = 0; i < intJumlah; i++) {
                        listTiketParaKonser.get(indexkonserygdipilih).get(intkategoritiket).pop();
                    }
                    // ======================= simpan transaksi =======================
                    Riwayat_transaksi.add(new Transaksi(formNama.getText(), Integer.valueOf(formWA.getText()),
                            formEmail.getText(), formJudul.getText(), intkategoritiket, intJumlah, hargatotal));
                    // ----
                    JOptionPane.showMessageDialog(form,
                            "Berhasil Membeli Ticket!!" + "\n" +
                                    "Ticket akan dikirimkan melalui email : "
                                    + formEmail.getText()
                                    + "\n" + "Terima Kasih");
                    formJudul.setText("");
                    formTgl.setText("");
                    formPrice.setText("");
                    kategoritiketyangdipilih.setText("");
                    formNama.setText("");
                    formEmail.setText("");
                    formWA.setText("");
                    formTotal.setText("");
                    kuotaTikettersedia.setText("");
                    jumlah.setText("");
                    formJudul.setEnabled(true);
                    formTgl.setEnabled(true);
                    formPrice.setEnabled(true);
                    kategoritiketyangdipilih.setEnabled(true);
                    formNama.setEnabled(true);
                    formEmail.setEnabled(true);
                    formWA.setEnabled(true);
                    formTotal.setEnabled(true);
                    System.out.println(Riwayat_transaksi);

                }

            }
        });

        // Total
        lblJumlah = new JLabel("Total :");
        lblJumlah.setBounds(957, 130, 102, 14);
        lblJumlah.setFont(new Font("poppins", Font.PLAIN, 12));
        lblJumlah.setForeground(Color.white);
        shop.add(lblJumlah);

        // ===================== Pembelian Closed ======================

        // =============================================== action tombol pilih tiket
        // Function Button Pilih Tikcet
        for (int i = 0; i < listKonser.size(); i++) {
            int index = i;
            btnPilihTicketArrayGold[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    formJudul.setText(listKonser.get(index).namaKonser());
                    formTgl.setText(listKonser.get(index).tglKonser());
                    kategoritiketyangdipilih.setText("Gold");
                    formPrice.setText(String.valueOf(listKonser.get(index).hargaTiketGold()));
                    kuotaTikettersedia.setText(String.valueOf(listTiketParaKonser.get(index).get(0).size()));
                    formJudul.setEnabled(false);
                    formTgl.setEnabled(false);
                    formPrice.setEnabled(false);
                    kuotaTikettersedia.setEnabled(false);
                }
            });
            btnPilihTicketArraySilver[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    formJudul.setText(listKonser.get(index).namaKonser());
                    formTgl.setText(listKonser.get(index).tglKonser());
                    kategoritiketyangdipilih.setText("Silver");
                    formPrice.setText(String.valueOf(listKonser.get(index).hargaTiketSilver()));
                    kuotaTikettersedia.setText(String.valueOf(listTiketParaKonser.get(index).get(1).size()));
                    formJudul.setEnabled(false);
                    formTgl.setEnabled(false);
                    formPrice.setEnabled(false);
                    kuotaTikettersedia.setEnabled(false);
                }
            });
            btnPilihTicketArrayBronze[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    formJudul.setText(listKonser.get(index).namaKonser());
                    formTgl.setText(listKonser.get(index).tglKonser());
                    kategoritiketyangdipilih.setText("Bronze");
                    formPrice.setText(String.valueOf(listKonser.get(index).hargaTiketBroze()));
                    kuotaTikettersedia.setText(String.valueOf(listTiketParaKonser.get(index).get(2).size()));
                    formJudul.setEnabled(false);
                    formTgl.setEnabled(false);
                    formPrice.setEnabled(false);
                    kuotaTikettersedia.setEnabled(false);
                }
            });
        }

        form.pack();
        // agar container tampil
        form.setVisible(true);
    }

}