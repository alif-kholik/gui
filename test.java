package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test {
    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public test() {
        frame = new JFrame("Aplikasi Multi-Halaman");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Halaman 1
        JPanel page1 = new JPanel();
        page1.add(new JLabel("Halaman 1"));
        JButton nextPageButton1 = new JButton("Halaman Berikutnya");
        nextPageButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "halaman2");
            }
        });
        page1.add(nextPageButton1);

        // Halaman 2
        JPanel page2 = new JPanel();
        page2.add(new JLabel("Halaman 2"));
        JButton nextPageButton2 = new JButton("Halaman Berikutnya");
        nextPageButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "halaman1");
            }
        });
        page2.add(nextPageButton2);

        // Menambahkan halaman ke panel
        cardPanel.add(page1, "halaman1");
        cardPanel.add(page2, "halaman2");

        frame.add(cardPanel);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new test();
            }
        });
    }
}
