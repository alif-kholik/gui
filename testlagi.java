package gui;

public class testlagi {
    
}

for (int i = 0; i < listKonser.size(); i++) {
    // =========================== banner ==========================================
    JLabel img = new JLabel();
    img.setBounds(46 + i * 240, 128, 226, 137);
    img.setIcon(new ImageIcon(new ImageIcon("src/gui/asset/"+listKonser.get(i).fotonya()).getImage().getScaledInstance(226, 137, Image.SCALE_DEFAULT)));
    form.add(img);

    // ================== text banner =======================
    JPanel card = new JPanel();
    card.setBounds(46 + i * 240, 266, 226, 130);
    card.setBackground(new Color(25, 37, 46));
    card.setLayout(null);
    form.add(card);

    // nama Konser
    JLabel textNamaKonser = new JLabel(listKonser.get(i).namaKonser());
    textNamaKonser.setBounds(20, 15, 195, 18);
    textNamaKonser.setFont(new Font("poppins", Font.BOLD, 16));
    textNamaKonser.setForeground(Color.white);
    card.add(textNamaKonser);

    // tanggal Konser
    JLabel textTanggalKonser = new JLabel(listKonser.get(i).tglKonser());
    textTanggalKonser.setBounds(20, 40, 195, 14);
    textTanggalKonser.setFont(new Font("poppins", Font.PLAIN, 12));
    textTanggalKonser.setForeground(Color.gray);
    card.add(textTanggalKonser);

    // Harga Konser
    JLabel labelRp = new JLabel("Rp.");
    labelRp.setBounds(20, 75, 29, 14);
    labelRp.setFont(new Font("poppins", Font.BOLD, 16));
    labelRp.setForeground(Color.white);
    JLabel textHargaKonser = new JLabel(String.valueOf(listKonser.get(i).hargaTiketSilver()));
    textHargaKonser.setBounds(49, 75, 195, 14);
    textHargaKonser.setFont(new Font("poppins", Font.BOLD, 16));
    textHargaKonser.setForeground(Color.white);
    card.add(textHargaKonser);
    card.add(labelRp);

    // Tombol Pilih Ticket
    JButton btnPilihTicket = new JButton("Pilih Ticket");
    btnPilihTicket.setBounds(0, 100, 226, 30);
    btnPilihTicket.setBackground(colorBtn);
    btnPilihTicket.setOpaque(true);
    btnPilihTicket.setBorder(null);
    btnPilihTicket.setForeground(Color.white);
    card.add(btnPilihTicket);
}