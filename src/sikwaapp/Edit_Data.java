/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sikwaapp;
import config.Koneksi;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ade Arif R
 */
public class Edit_Data extends javax.swing.JFrame {
    ResultSet hasil=null;

    /**
     * Creates new form Edit_Data
     */
    public Edit_Data() {
        initComponents();
        
        //Menambahkan Icon Aplikasi
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
        jPanel3 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextNIK = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextNmPnd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextThnMsk = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonSimpanPndk = new javax.swing.JButton();
        jButtonBatalPndk = new javax.swing.JButton();
        jComboUnit = new javax.swing.JComboBox<>();
        jComboBlok = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Data Penduduk");
        setPreferredSize(new java.awt.Dimension(480, 640));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(460, 680));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setForeground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(187, 226, 232));

        jLabel25.setFont(new java.awt.Font("Palatino Linotype", 1, 25)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 153, 153));
        jLabel25.setText("Edit Data Penduduk");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(124, 124, 124))
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

        jTextNIK.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jTextNIK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNIKKeyTyped(evt);
            }
        });
        jPanel2.add(jTextNIK, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 157, 30));

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, 30));

        jTextNmPnd.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jTextNmPnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNmPndActionPerformed(evt);
            }
        });
        jPanel2.add(jTextNmPnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 157, 30));

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Unit");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, -1, 30));

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Blok");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, 30));

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tahun Masuk");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, 30));

        jTextThnMsk.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jPanel2.add(jTextThnMsk, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 157, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Please-enter-a-title_-001 (1).png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, -1, -1));

        jButtonSimpanPndk.setBackground(new java.awt.Color(0, 153, 0));
        jButtonSimpanPndk.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        jButtonSimpanPndk.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSimpanPndk.setText("SIMPAN");
        jButtonSimpanPndk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanPndkActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonSimpanPndk, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        jButtonBatalPndk.setBackground(new java.awt.Color(153, 0, 0));
        jButtonBatalPndk.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        jButtonBatalPndk.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBatalPndk.setText("BATAL");
        jButtonBatalPndk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBatalPndkActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBatalPndk, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 100, -1));

        jComboUnit.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jComboUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pillih Unit-", "A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3" }));
        jComboUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboUnitActionPerformed(evt);
            }
        });
        jPanel2.add(jComboUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 157, 30));

        jComboBlok.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jComboBlok.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Blok-", "Anggrek", "Mawar", "Tulip", "Teratai", "Edelweiss" }));
        jPanel2.add(jComboBlok, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, 157, 30));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
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

    private void jButtonSimpanPndkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanPndkActionPerformed
        // TODO add your handling code here:
        String nik=jTextNIK.getText();
        String namapnd=jTextNmPnd.getText();
        String unit=jComboUnit.getSelectedItem().toString();
        String blok=jComboBlok.getSelectedItem().toString();
        String tahunmasuk=jTextThnMsk.getText();

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
                dashboard.tampilDataPndk();
                Statement stt=conn.createStatement();
                stt.executeUpdate("UPDATE dft_penduduk SET namapnd='"+namapnd+"', unit='"+unit+"', blok='"+blok+"',"+
                    "tahunmasuk='"+tahunmasuk+"' WHERE nik='"+nik+"'");
                JOptionPane.showMessageDialog(this,"Data berhasil diubah","Success",JOptionPane.INFORMATION_MESSAGE);
                dashboard.tampilDataPndk();
                this.dispose();
            }catch(SQLException e) {
                JOptionPane.showMessageDialog(this,"Ubah data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonSimpanPndkActionPerformed

    private void jButtonBatalPndkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBatalPndkActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonBatalPndkActionPerformed

    private void jTextNIKKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNIKKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNIKKeyTyped

    private void jComboUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboUnitActionPerformed

    private void jTextNmPndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNmPndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNmPndActionPerformed

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
            java.util.logging.Logger.getLogger(Edit_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_Data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBatalPndk;
    private javax.swing.JButton jButtonSimpanPndk;
    public javax.swing.JComboBox<String> jComboBlok;
    public javax.swing.JComboBox<String> jComboUnit;
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
    public javax.swing.JTextField jTextNIK;
    public javax.swing.JTextField jTextNmPnd;
    public javax.swing.JTextField jTextThnMsk;
    // End of variables declaration//GEN-END:variables
}
