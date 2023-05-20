/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sikwaapp;
import config.Koneksi;
import java.awt.Image;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static sikwaapp.Dashboard.btn_laporan;
import static sikwaapp.Dashboard.btn_kas;
import static sikwaapp.Dashboard.btn_tamu;
import static sikwaapp.Dashboard.btn_berita;
import static sikwaapp.Dashboard.btn_iuran;
import static sikwaapp.Dashboard.btn_home;
import static sikwaapp.Dashboard.Icon_Daftar_Akun;
import static sikwaapp.Dashboard.Label_Daftar_Akun;
import static sikwaapp.Dashboard.Label_Role;
import static sikwaapp.Dashboard.Label_Role1;
import static sikwaapp.Dashboard.Label_Role2;
import static sikwaapp.Dashboard.Label_Role3;
import static sikwaapp.Dashboard.Label_Role4;
import static sikwaapp.Dashboard.Label_Role5;
import static sikwaapp.Dashboard.Label_Role6;
import static sikwaapp.Dashboard.btn_tambahpndk;
import static sikwaapp.Dashboard.btn_editpndk;
import static sikwaapp.Dashboard.btn_edittamu;
import static sikwaapp.Dashboard.btn_hapuspndk;
import static sikwaapp.Dashboard.btn_hapustamu;
import static sikwaapp.Dashboard.btn_tambahtamu;

/**
 *
 * @author Ade Arif R
 */
public class login extends javax.swing.JFrame {
    Dashboard a;
    /**
     * Creates new form login1
     */
    public login() {
        initComponents();
        a = new Dashboard();
        a.setVisible(false);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtuser = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtpass = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbuser = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(620, 458));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Log in to SIKWA");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 300, -1));

        jLabel2.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 113, -1, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_users_20px.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 30, 30));

        txtuser.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        txtuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtuserActionPerformed(evt);
            }
        });
        jPanel3.add(txtuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 181, 30));

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 180, -1, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_password_20px.png"))); // NOI18N
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 30, 30));

        txtpass.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        txtpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassActionPerformed(evt);
            }
        });
        jPanel3.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 208, 181, 30));

        jLabel4.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Role");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 247, -1, -1));

        cbuser.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        cbuser.setForeground(new java.awt.Color(0, 51, 51));
        cbuser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Login Sebagai", "Kepala Security", "Security", "RT/RW", "Warga" }));
        cbuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbuserActionPerformed(evt);
            }
        });
        jPanel3.add(cbuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(361, 275, 181, 30));

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Login");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 80, -1));

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Kembali");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Footer 1.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 620, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngwing.com (1).png"))); // NOI18N
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, -1, 330));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new beranda().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String user = txtuser.getText();
        String pass = txtpass.getText();
        String role = cbuser.getSelectedItem().toString();
        try {
            Connection con = Koneksi.koneksiDB();
            Statement st = (Statement) con.createStatement();
            String query = "SELECT * FROM login WHERE user='"+user+"'AND pass='"+pass+"'AND role='"+role+"'";
            ResultSet rs = st.executeQuery(query);
            
            if (rs.next()) {
                //membuat label sesuai login role
                Label_Role.setText(rs.getString(4));
                Label_Role1.setText(rs.getString(4));
                Label_Role2.setText(rs.getString(4));
                Label_Role3.setText(rs.getString(4));
                Label_Role4.setText(rs.getString(4));
                Label_Role5.setText(rs.getString(4));
                Label_Role6.setText(rs.getString(4));               
                // Memeriksa role yang dipilih pada combo box
                if (role.equals("Kepala Security")) {
                    JOptionPane.showMessageDialog(null,"Login Berhasil");
                    a.setVisible(true);
                    btn_home.setEnabled(true);
                    btn_home.setEnabled(true);
                    btn_tamu.setEnabled(true);
                    btn_berita.setEnabled(true);
                    btn_kas.setEnabled(true);
                    btn_iuran.setEnabled(true);
                    btn_laporan.setEnabled(true);                   
                    this.dispose();
                } else if (role.equals("Security")) {
                    JOptionPane.showMessageDialog(null,"Login Berhasil");
                    a.setVisible(true);
                    btn_home.setEnabled(true);
                    btn_home.setEnabled(true);
                    btn_tamu.setEnabled(true);
                    btn_berita.setEnabled(true);
                    btn_kas.setEnabled(true);
                    btn_iuran.setEnabled(true);
                    btn_laporan.setEnabled(true);
                    this.dispose();
                } else if (role.equals("RT/RW")) {
                    JOptionPane.showMessageDialog(null,"Login Berhasil");
                    a.setVisible(true);
                    btn_home.setEnabled(true);
                    btn_home.setEnabled(true);
                    btn_tamu.setEnabled(true);
                    btn_berita.setEnabled(true);
                    btn_kas.setEnabled(true);
                    btn_iuran.setEnabled(true);
                    btn_laporan.setEnabled(false);
                    this.dispose();
                }else if (role.equals("Warga")) {
                    JOptionPane.showMessageDialog(null,"Login Berhasil");
                    a.setVisible(true);
                    btn_home.setEnabled(true);
                    btn_home.setEnabled(true);
                    btn_tamu.setEnabled(true);
                    btn_berita.setEnabled(true);
                    btn_kas.setEnabled(false);
                    btn_iuran.setEnabled(true);
                    btn_laporan.setEnabled(false);
                    Label_Daftar_Akun.setVisible(false);
                    Icon_Daftar_Akun.setVisible(false);
                    btn_tambahpndk.setEnabled(false);
                    btn_editpndk.setEnabled(false);
                    btn_hapuspndk.setEnabled(false);
                    btn_tambahtamu.setEnabled(false);
                    btn_edittamu.setEnabled(false);
                    btn_hapustamu.setEnabled(false);
                    
                    this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username atau password salah");
            }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbuserActionPerformed

    private void txtpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassActionPerformed

    private void txtuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtuserActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbuser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtpass;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
