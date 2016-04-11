/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tespuzzle;
  
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author IRFAN
 */
public class TestPuzzle extends javax.swing.JFrame {
    private JPanel centerPanel;
private JButton button;
private JLabel label;
private Image source;
private Image image;
int[][] pos;
int width, height;
    /**
     * Creates new form TestPuzzle
     */
    public TestPuzzle() {
        initComponents();
        pos = new int[][] {
{0, 1, 2},
{3, 4, 5},
{6, 7, 8},
{9, 10, 11}
};
centerPanel = new JPanel();
centerPanel.setLayout(new GridLayout(4, 4, 0, 0));
//     ImageIcon sid = new ImageIcon(Puzzle.class.getResource(“puzzle.jpg”));
ImageIcon sid = new ImageIcon(tespuzzle.class.getResource(“puzzle.jpg”));
source          = sid.getImage();
width            = sid.getIconWidth();
height           = sid.getIconHeight();
add(Box.createRigidArea(new Dimension(0, 5)), BorderLayout.NORTH);
add(centerPanel, BorderLayout.CENTER);

        for ( int i = 0; i < 4; i++) {
for ( int j = 0; j < 3; j++) {
if ( j == 2 && i == 3) {
label = new JLabel(“”);
centerPanel.add(label);

                } else {
button = new JButton();
button.addActionListener(this);
centerPanel.add(button);
image = createImage(new FilteredImageSource(source.getSource(),
new CropImageFilter(j*width/3, i*height/4,
(width/3)+1, height/4)));
button.setIcon(new ImageIcon(image));
}
}
}
setSize(220, 280);
setTitle(“tes puzzle”);
setResizable(false);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setVisible(true);
}
public static void main(String[] args) {
new tespuzzle();
}

public void actionPerformed(ActionEvent e) {
JButton button = (JButton) e.getSource();
Dimension size = button.getSize();
int labelX = label.getX();
int labelY = label.getY();
int buttonX = button.getX();
int buttonY = button.getY();
int buttonPosX = buttonX / size.width;
int buttonPosY = buttonY / size.height;
int buttonIndex = pos[buttonPosY][buttonPosX];
if (labelX == buttonX && (labelY – buttonY) == size.height ) {
int labelIndex = buttonIndex + 3;
centerPanel.remove(buttonIndex);
centerPanel.add(label, buttonIndex);
centerPanel.add(button,labelIndex);
centerPanel.validate();
}
if (labelX == buttonX && (labelY – buttonY) == -size.height ) {
int labelIndex = buttonIndex – 3;
centerPanel.remove(labelIndex);
centerPanel.add(button,labelIndex);
centerPanel.add(label, buttonIndex);
centerPanel.validate();
}
if (labelY == buttonY && (labelX – buttonX) == size.width ) {
int labelIndex = buttonIndex + 1;
centerPanel.remove(buttonIndex);
centerPanel.add(label, buttonIndex);
centerPanel.add(button,labelIndex);
centerPanel.validate();
}
if (labelY == buttonY && (labelX – buttonX) == -size.width ) {
int labelIndex = buttonIndex – 1;
centerPanel.remove(buttonIndex);
centerPanel.add(label, labelIndex);
centerPanel.add(button,labelIndex);
centerPanel.validate();
}
}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
