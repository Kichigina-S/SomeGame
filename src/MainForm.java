import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {

    public JButton btnKickPlayer  = new JButton("Kick Player");
    public JButton btnHealPlayer  = new JButton("Heal Player");
    public JButton btnKickMonster = new JButton("Kick Monster");
    public JLabel lblPlayer       = new JLabel("");
    public JLabel lblMonster      = new JLabel("");
    public JLabel lblInfoFhight   = new JLabel("");
    public JLabel iconPlayer     = new JLabel("");
    public JLabel iconMonster    = new JLabel("");

    public MainForm(String title, int width, int height) throws Exception {
        super(title);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(width, height);
        super.setLocationRelativeTo(null);
        super.setVisible(true);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 2, 70, 10));

        iconMonster.setIcon(new ImageIcon("images/monster.png"));
        iconMonster.setHorizontalAlignment(SwingConstants.CENTER);

        iconPlayer.setIcon(new ImageIcon("images/player.png"));
        iconPlayer.setHorizontalAlignment(SwingConstants.CENTER);

        lblInfoFhight.setOpaque(true);
        lblInfoFhight.setBackground(Color.gray);

        container.add(btnKickMonster);
        container.add(btnKickPlayer);
        container.add(iconPlayer);
        container.add(iconMonster);
        container.add(lblPlayer);
        container.add(lblMonster);
        container.add(btnHealPlayer);
        container.add(lblInfoFhight);

        Player testPlayer = new Player();
        lblPlayer.setText(testPlayer.printInfo());

        Monster testMonster = new Monster();
        lblMonster.setText(testMonster.printInfo());
        
        btnKickMonster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Пример использования метода Удар, если атакующий - Игрок
                try {
                    lblInfoFhight.setText(testPlayer.kickEssence(testMonster, testPlayer));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                lblPlayer.setText(testPlayer.printInfo());
                lblMonster.setText(testMonster.printInfo());
            }
        }); 
 
         btnKickPlayer.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     lblInfoFhight.setText(testMonster.kickEssence(testPlayer, testMonster));
                 } catch (Exception e1) {
                     e1.printStackTrace();
                 }
                 lblPlayer.setText(testPlayer.printInfo());
                 lblMonster.setText(testMonster.printInfo());
             }
         }); 
 
         btnHealPlayer.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 try {
                     lblInfoFhight.setText(testPlayer.healPlayer(testPlayer));
                 } catch (Exception e1) {
                     e1.printStackTrace();
                 }
                 lblPlayer.setText(testPlayer.printInfo());
             }
         }); 
    }    
}
