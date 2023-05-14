/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sikwaapp;

import config.Koneksi;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Ade Arif R
 */
//public class tampilDataDashboard{
//    public static void main(String[]args){
//    Dashboard objA = new Dashboard();
//    objA.tampilData();
//    }
//}

public class Input_Data extends javax.swing.JFrame {
    
    
    /**
     * Creates new form Input_Data
     */
    public Input_Data() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextNIK = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextNmPnd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboUnit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBlok = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextThnMsk = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonSimpan = new javax.swing.JButton();
        jButtonBatal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(460, 680));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(460, 680));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(187, 226, 232));

        jLabel25.setFont(new java.awt.Font("Palatino Linotype", 1, 25)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 153, 153));
        jLabel25.setText("Tambah Data Penduduk");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(82, 82, 82))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(25, 25, 25))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 479, -1));

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NIK");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, 30));

        jTextNIK.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jPanel2.add(jTextNIK, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 157, 30));

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, 30));

        jTextNmPnd.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jPanel2.add(jTextNmPnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 157, 30));

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Unit");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, 30));

        jComboUnit.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jPanel2.add(jComboUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 157, 30));

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Blok");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, 30));

        jComboBlok.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jComboBlok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBlokActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBlok, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 157, 30));

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tahun Masuk");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, 30));

        jTextThnMsk.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jPanel2.add(jTextThnMsk, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 157, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Please-enter-a-title_-001 (1).png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, -1, -1));

        jButtonSimpan.setBackground(new java.awt.Color(0, 153, 0));
        jButtonSimpan.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        jButtonSimpan.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSimpan.setText("SIMPAN");
        jButtonSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        jButtonBatal.setBackground(new java.awt.Color(153, 0, 0));
        jButtonBatal.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        jButtonBatal.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBatal.setText("BATAL");
        jButtonBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBatalActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBatal, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 100, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanActionPerformed
        // TODO add your handling code here:
        String nik=jTextNIK.getText();
        String namapnd=jTextNmPnd.getText();
//        String unit=jComboUnit.getSelectedItem().toString();
        String unit=jComboUnit.getText();
        String blok=jComboBlok.getText();
//        String blok=jComboBlok.getSelectedItem().toString();
        String tahunmasuk=jTextThnMsk.getText();
        
        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate = TanggalFormat.format(tanggal);
        
        if(nik.isEmpty()) {
            JOptionPane.showMessageDialog(null,"NIK tidak boleh kosong");
            jTextNIK.requestFocus();
        }else if(namapnd.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Nama tidak boleh kosong");
            jTextNmPnd.requestFocus();
        }else if(unit.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Unit tidak boleh kosong");
            jComboUnit.requestFocus();
        }else if(blok.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Blok tidak boleh kosong");
            jComboBlok.requestFocus();
        }
        else if(!(new Scanner(tahunmasuk).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Tahun Masuk harus berisi angka");
            jTextThnMsk.requestFocus();
        }else{
            try{
                Connection conn=(Connection)Koneksi.koneksiDB();
                Dashboard dashboard = new Dashboard();
                dashboard.tampilData();
//                Dashboard tampildata = tampilData;
                Statement stt=conn.createStatement();
                stt.executeUpdate("insert into dft_penduduk(nik,namapnd,blok,unit,tahunmasuk,CreateDate)"+
                        "VALUES('"+nik+"','"+namapnd+"','"+unit+"','"+blok+"','"+tahunmasuk+"','"+CreateDate+"')");
//                BersihData();
//                tampilData();
//                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
                dashboard.tampilData();
                this.dispose();
                
//                new Dashboard().tampilData();
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_jButtonSimpanActionPerformed

    private void jComboBlokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBlokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBlokActionPerformed

    private void jButtonBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBatalActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonBatalActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        Dashboard dashboard = new Dashboard();
//        dashboard.tampilData();
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
            java.util.logging.Logger.getLogger(Input_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Input_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Input_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Input_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Input_Data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBatal;
    private javax.swing.JButton jButtonSimpan;
    private javax.swing.JTextField jComboBlok;
    private javax.swing.JTextField jComboUnit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextNIK;
    private javax.swing.JTextField jTextNmPnd;
    private javax.swing.JTextField jTextThnMsk;
    // End of variables declaration//GEN-END:variables
}