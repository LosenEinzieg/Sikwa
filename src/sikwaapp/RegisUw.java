/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sikwaapp;
import config.Koneksi;
import java.awt.Image;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.ImageIcon;

/**
 *
 * @author Ade Arif R
 */
public class RegisUw extends javax.swing.JFrame {

    /**
     * Creates new form RegisUw
     */
    public RegisUw() {
        initComponents();
        
        Image icon = new ImageIcon(this.getClass().getResource("/img/icon.png")).getImage();
        this.setIconImage(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboroled = new javax.swing.JComboBox<>();
        labelcek = new javax.swing.JLabel();
        jPuw2 = new javax.swing.JPasswordField();
        jPuw = new javax.swing.JPasswordField();
        jTextduw = new javax.swing.JTextField();
        jTextdun = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Daftar Akun Baru");

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(680, 480));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setPreferredSize(new java.awt.Dimension(620, 458));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Registrasi Akun Warga");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 280, -1));

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NIK atau ID");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 100, -1));

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Username");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 110, -1));

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 152, -1));

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Konfirmasi Password");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 160, -1));

        jLabel7.setFont(new java.awt.Font("Palatino Linotype", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Sebagai");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 152, -1));

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setFont(new java.awt.Font("Palatino Linotype", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Daftar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setFont(new java.awt.Font("Palatino Linotype", 1, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Kembali");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, -1, -1));

        jComboroled.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jComboroled.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Daftar Sebagai", "Warga", "Security" }));
        jComboroled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboroledActionPerformed(evt);
            }
        });
        jPanel2.add(jComboroled, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, -1, -1));

        labelcek.setFont(new java.awt.Font("Palatino Linotype", 1, 12)); // NOI18N
        labelcek.setForeground(new java.awt.Color(255, 255, 255));
        labelcek.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelcek.setText("Cek");
        jPanel2.add(labelcek, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 80, 30));

        jPuw2.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jPuw2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPuw2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPuw2KeyReleased(evt);
            }
        });
        jPanel2.add(jPuw2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 129, -1));

        jPuw.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jPanel2.add(jPuw, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 129, -1));

        jTextduw.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jPanel2.add(jTextduw, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 129, -1));

        jTextdun.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jTextdun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextdunActionPerformed(evt);
            }
        });
        jPanel2.add(jTextdun, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 128, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BG_Register.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Footer.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 620, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String nikuw = jTextdun.getText();
        String userduw = jTextduw.getText();
        String passduw = jPuw.getText();
        String passduw2= jPuw2.getText();
        String roled = jComboroled.getSelectedItem().toString();
        String cekid = null;

        try {
            Connection Connect = Koneksi.koneksiDB();
            Statement st = (Statement) Connect.createStatement();
            String query = "SELECT * FROM login WHERE id='"+nikuw+"'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                cekid=rs.getString("id");
            }
            rs.close();
            rs.close();
        }catch (SQLException e){
            System.out.println("Error");
        }
        if(cekid!=null) {
            String pesan = "ID Sudah Terdaftar!";
            JOptionPane.showMessageDialog(null,pesan,"Kesalahan",
                JOptionPane.INFORMATION_MESSAGE);
        }if (!passduw.equals(passduw2)){
            String pesan2 = "Password Tidak Cocok";
            JOptionPane.showMessageDialog(null, pesan2,"Kesalahan",JOptionPane.INFORMATION_MESSAGE);
        }else {
            try {
                Connection Connect = Koneksi.koneksiDB();
                String query = "Insert INTO login VALUES ('"+jTextdun.getText()+"','"+jTextduw.getText()+"','"+jPuw.getText()+"','"+jComboroled.getSelectedItem().toString()+"')";
                PreparedStatement ps = (PreparedStatement) Connect.prepareStatement(query);
                ps.executeUpdate(query);

                String pesan3 = "Akun Berhasil Terdaftar";
                JOptionPane.showMessageDialog(null, pesan3,"Berhasil",JOptionPane.INFORMATION_MESSAGE);
                dispose();
                new login().show();
            }catch (SQLException e) {

            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboroledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboroledActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboroledActionPerformed

    private void jPuw2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPuw2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPuw2KeyPressed

    private void jPuw2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPuw2KeyReleased
        // TODO add your handling code here:
        String registerPassword = new String (jPuw.getPassword());
        String retypePassword = new String (jPuw2.getPassword());

        if (registerPassword.equals(retypePassword)) {
            labelcek.setText("Pass Cccok");
        }else if (!registerPassword.equals(retypePassword)) {
            labelcek.setText("Tidak Cocok");
        }
    }//GEN-LAST:event_jPuw2KeyReleased

    private void jTextdunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextdunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextdunActionPerformed

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
            java.util.logging.Logger.getLogger(RegisUw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisUw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisUw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisUw.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisUw().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboroled;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPuw;
    private javax.swing.JPasswordField jPuw2;
    private javax.swing.JTextField jTextdun;
    private javax.swing.JTextField jTextduw;
    private javax.swing.JLabel labelcek;
    // End of variables declaration//GEN-END:variables
}
