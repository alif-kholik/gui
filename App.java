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
        listKonser.add(new Konser("Play Music Festival", "23 januari 2024", 20, 500000,
                20, 300000, 20, 200000, "tulus.jpeg"));
        listKonser.add(new Konser("West Java Festival", "11 febuari 2024", 10, 400000,
                20, 300000, 20, 200000, "wjf.jpeg"));
        listKonser.add(new Konser("Coolab Fest", "1 januari 2024", 20, 500000, 20,
                300000, 20, 200000, "coolab.jpeg"));
        listKonser.add(new Konser("Play Music Banduung", "23 januari 2024", 20, 500000,
                20, 300000, 20, 200000, "pm.jpeg"));
        listKonser.add(new Konser("Bahaya Mantan Terindah",
                "11 febuari 2024", 10, 400000, 20, 300000, 20, 200000, "bt.jpeg"));

        // ===============================================================
        // Deklarasi
        JLabel judul, Rp;
        JPanel shop;
        Color abu = new Color(175, 181, 186);
        Color colorBtn = new Color(37, 50, 61);
        Color biru = new Color(0, 151, 255);

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

        // judul Aplikasi
        judul = new JLabel("Aplikasi Konser");
        judul.setBounds(460, 28, 461, 74);
        judul.setFont(new Font("Cabinet Grotesk", Font.BOLD, 50));
        judul.setForeground(Color.white);
        form.add(judul);

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
            JPanel card = new JPanel();
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
            textHargaKonserGold.setBounds(134, 55, 195, 14);
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
        JLabel lblNama, lblEmail, lblWA, h1, h2, lblJudul, lblTgl, lblPrice, lblJumlah, RpTotal;
        JTextField formNama, formEmail, formWA, formJudul, formTgl, formPrice, formTotal, jumlah;
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

        // ====================== Form Beli Ticket ==========================
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

        // Label Harga
        lblPrice = new JLabel("Harga");
        lblPrice.setBounds(489, 165, 100, 23);
        lblPrice.setFont(new Font("poppins", Font.BOLD, 16));
        lblPrice.setForeground(Color.white);
        shop.add(lblPrice);

        // form Harga
        formPrice = new JTextField();
        formPrice.setBounds(652, 165, 240, 28);
        formPrice.setBackground(colorBtn);
        formPrice.setBorder(null);
        formPrice.setFont(new Font("poppins", Font.PLAIN, 16));
        formPrice.setForeground(Color.white);
        formPrice.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        shop.add(formPrice);

        // Label Jumlah
        lblPrice = new JLabel("Jumlah");
        lblPrice.setBounds(489, 210, 100, 23);
        lblPrice.setFont(new Font("poppins", Font.BOLD, 16));
        lblPrice.setForeground(Color.white);
        shop.add(lblPrice);

        // ===================== form Total ============================
        // Form TOTAL
        RpTotal = new JLabel("Rp.");
        RpTotal.setBounds(957, 215, 29, 14);
        RpTotal.setFont(new Font("poppins", Font.BOLD, 16));
        RpTotal.setForeground(Color.white);
        shop.add(RpTotal);

        formTotal = new JTextField();
        formTotal.setBounds(998, 205, 148, 28);
        formTotal.setFont(new Font("poppins", Font.PLAIN, 16));
        formTotal.setForeground(Color.white);
        formTotal.setBorder(null);
        formTotal.setBackground(colorBtn);
        formTotal.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        shop.add(formTotal);
        // ===================== form Total ============================

        // Jumlah
        jumlah = new JTextField();
        jumlah.setBounds(652, 205, 240, 28);
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
                        double intPrice = Double.parseDouble(formPrice.getText());
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
        btnBeli.setBounds(957, 85, 190, 48);
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
                int hargatotal = intPrice * intJumlah;
                String jmlhTotal = String.valueOf(hargatotal);
                formTotal.setText(jmlhTotal);
                formTotal.setEnabled(false);
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
                } else {
                    // ======================= simpan transaksi =======================
                    Riwayat_transaksi.add(new Transaksi(formNama.getText(), Integer.valueOf(formWA.getText()),
                            formEmail.getText(), formJudul.getText(), 1, intJumlah, hargatotal));

                    JOptionPane.showMessageDialog(form,
                            "Berhasil Membeli Ticket!!" + "\n" +
                                    "Ticket akan dikirimkan melalui email : "
                                    + formEmail.getText()
                                    + "\n" + "Terima Kasih");
                    formJudul.setText("");
                    formTgl.setText("");
                    formPrice.setText("");
                    formNama.setText("");
                    formEmail.setText("");
                    formWA.setText("");
                    formTotal.setText("");
                    jumlah.setText("");
                    formJudul.setEnabled(true);
                    formTgl.setEnabled(true);
                    formPrice.setEnabled(true);
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
        lblJumlah.setBounds(957, 180, 102, 14);
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
                    formPrice.setText(String.valueOf(listKonser.get(index).hargaTiketGold()));
                    formJudul.setEnabled(false);
                    formTgl.setEnabled(false);
                    formPrice.setEnabled(false);
                }
            });
            btnPilihTicketArraySilver[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    formJudul.setText(listKonser.get(index).namaKonser());
                    formTgl.setText(listKonser.get(index).tglKonser());
                    formPrice.setText(String.valueOf(listKonser.get(index).hargaTiketSilver()));
                    formJudul.setEnabled(false);
                    formTgl.setEnabled(false);
                    formPrice.setEnabled(false);
                }
            });
            btnPilihTicketArrayBronze[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    formJudul.setText(listKonser.get(index).namaKonser());
                    formTgl.setText(listKonser.get(index).tglKonser());
                    formPrice.setText(String.valueOf(listKonser.get(index).hargaTiketBroze()));
                    formJudul.setEnabled(false);
                    formTgl.setEnabled(false);
                    formPrice.setEnabled(false);
                }
            });
        }

        form.pack();
        // agar container tampil
        form.setVisible(true);
    }

}