/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package trabalho.ps;

/**
 *
 * @author YuriW
 */
public class janela1 extends javax.swing.JFrame {

    /**
     * Creates new form janela1
     */
    public janela1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        runbutton = new javax.swing.JButton();
        abrirarquivo = new javax.swing.JButton();
        Stepbutton = new javax.swing.JButton();
        regA = new javax.swing.JTextField();
        regX = new javax.swing.JTextField();
        regT = new javax.swing.JTextField();
        regB = new javax.swing.JTextField();
        regS = new javax.swing.JTextField();
        regL = new javax.swing.JTextField();
        regF = new javax.swing.JTextField();
        regPC = new javax.swing.JTextField();
        regSW = new javax.swing.JTextField();
        clearbutton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Endereço", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 90, 220, 270));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 310, 210));

        runbutton.setOpaque(false);
        runbutton.setContentAreaFilled(false);
        runbutton.setBorderPainted(false);

        runbutton.setBorderPainted(false);
        runbutton.setOpaque(false);
        runbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(runbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 510, 220, 40));

        abrirarquivo.setOpaque(false);
        abrirarquivo.setContentAreaFilled(false);
        abrirarquivo.setBorderPainted(false);
        getContentPane().add(abrirarquivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 220, 50));

        Stepbutton.setOpaque(false);
        Stepbutton.setContentAreaFilled(false);
        Stepbutton.setBorderPainted(false);

        Stepbutton.setBorderPainted(false);
        Stepbutton.setOpaque(false);
        Stepbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StepbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(Stepbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 430, 220, 40));

        regA.setEditable(false);
        regA.setForeground(new java.awt.Color(255, 255, 255));
        regA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regAActionPerformed(evt);
            }
        });
        getContentPane().add(regA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 180, -1));

        regX.setEditable(false);
        regX.setForeground(new java.awt.Color(255, 255, 255));
        regX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regXActionPerformed(evt);
            }
        });
        getContentPane().add(regX, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 180, 20));

        regT.setEditable(false);
        regT.setForeground(new java.awt.Color(255, 255, 255));
        regT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regTActionPerformed(evt);
            }
        });
        getContentPane().add(regT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 530, 180, -1));

        regB.setEditable(false);
        regB.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(regB, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 180, -1));

        regS.setEditable(false);
        regS.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(regS, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 180, -1));

        regL.setEditable(false);
        regL.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(regL, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 430, 180, -1));

        regF.setEditable(false);
        regF.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(regF, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 180, -1));

        regPC.setEditable(false);
        regPC.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(regPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 630, 180, -1));

        regSW.setEditable(false);
        regSW.setForeground(new java.awt.Color(255, 255, 255));
        regSW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regSWActionPerformed(evt);
            }
        });
        getContentPane().add(regSW, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 600, 180, -1));

        clearbutton.setOpaque(false);
        clearbutton.setContentAreaFilled(false);
        clearbutton.setBorderPainted(false);
        clearbutton.setBorderPainted(false);
        clearbutton.setOpaque(false);
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(clearbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 580, 220, 50));

        jTextField1.setForeground(new java.awt.Color(255, 102, 51));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 200, 50));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/PS.png"))); // NOI18N
        fundo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1270, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StepbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StepbuttonActionPerformed
        jTextArea1.setText("Adverte-se, para os devidos fins, que a imagem dos docentes, discentes e demais envolvidos no e-AULA encontra-se legalmente protegida pela Lei n");
    }//GEN-LAST:event_StepbuttonActionPerformed

    private void runbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_runbuttonActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
        // TODO add your handling code here:
        //
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void regAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regAActionPerformed

    private void regXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regXActionPerformed

    private void regTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regTActionPerformed

    private void regSWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regSWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regSWActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(janela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(janela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(janela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(janela1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new janela1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Stepbutton;
    private javax.swing.JButton abrirarquivo;
    private javax.swing.JButton clearbutton;
    private javax.swing.JLabel fundo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField regA;
    private javax.swing.JTextField regB;
    private javax.swing.JTextField regF;
    private javax.swing.JTextField regL;
    private javax.swing.JTextField regPC;
    private javax.swing.JTextField regS;
    private javax.swing.JTextField regSW;
    private javax.swing.JTextField regT;
    private javax.swing.JTextField regX;
    private javax.swing.JButton runbutton;
    // End of variables declaration//GEN-END:variables
}
