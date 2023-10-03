/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

import controllers.ControllerTent;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.Tent;

/**
 *
 * @author joanp
 */
public class MainView extends javax.swing.JFrame implements ActionListener {

    private JButton[][] tents;
    private final ControllerTent controllerTent;

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
        tents = new JButton[3][6];
        controllerTent = new ControllerTent();
        this.setSize(930, 620);
        this.setResizable(false);
        this.setLocationRelativeTo(this);
        this.setTitle("Carpas");
        this.setResizable(false);
        loadTent();
        validateTent();
    }

    public final void loadTent() {
        int ancho = 120;
        int alto = 120;
        int separado = 20;
        int separado2 = 5;

        int texto = 1;

        int x = 35;
        int y = 35;

        for (int i = 0; i < tents.length; i++) {
            for (int j = 0; j < tents[i].length; j++) {
                tents[i][j] = new JButton();
                tents[i][j].setBounds(x, y, ancho, alto);

                tents[i][j].setBackground(Color.WHITE);
                tents[i][j].setText(String.valueOf("Carpa " + texto));
                texto++;
                tents[i][j].addActionListener(this);
                panelTents.add(tents[i][j]);

                if (j == tents[i].length / 3 - 1 | j == tents[i].length / 1 - 3) {
                    x += ancho + 2 * separado;
                } else {
                    x += ancho + separado2;
                }
            }
            if (i == tents.length / 3 - 1 | i == tents.length / 1 - 2) {
                y += alto + 2 * separado;
            } else {
                y += alto + separado2;
            }
            x = 35;

        }
    }

    public final void validateTent() {
        for (int i = 0; i < tents.length; i++) {
            for (int j = 0; j < tents[i].length; j++) {

                Tent tent = controllerTent.getTent(i, j);
                if (tent.getPadlock().equals(Tent.OPEN)) {
                    tents[i][j].setBackground(Color.WHITE);
                } else if (tent.getPadlock().equals(Tent.CLOSE)) {
                    tents[i][j].setBackground(Color.BLUE);

                }

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

        mainPanel = new javax.swing.JPanel();
        panelTents = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        panelTents.setBackground(new java.awt.Color(255, 255, 255));
        panelTents.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Carpas:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Century Gothic", 1, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        javax.swing.GroupLayout panelTentsLayout = new javax.swing.GroupLayout(panelTents);
        panelTents.setLayout(panelTentsLayout);
        panelTentsLayout.setHorizontalGroup(
            panelTentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 857, Short.MAX_VALUE)
        );
        panelTentsLayout.setVerticalGroup(
            panelTentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelTents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelTents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel panelTents;
    // End of variables declaration//GEN-END:variables
@Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < tents.length; i++) {
            for (int j = 0; j < tents[i].length; j++) {
                if (ae.getSource().equals(tents[i][j])) {
                    Tent tent = controllerTent.getTent(i, j);
                    if (tent.getPadlock().equals(Tent.CLOSE)) {
                        new InternalViewTent(tent).setVisible(true);
                    }

                    if (tent.getPadlock().equals(Tent.OPEN)) {
                        new LoanView(this, tent).setVisible(true);
                    }

                }
            }
        }
    }

}
