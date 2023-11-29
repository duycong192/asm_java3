
package view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Students;
import service.QuanLyDiem_Service;
import service.QuanLySinhVien_Service;

/**
 *
 * @author admin
 */
public class QuanLySinhVien extends javax.swing.JFrame {

    /**
     * Creates new form QuanLySinhVien
     */
    List<Students> listStudents = new ArrayList<>();
    QuanLySinhVien_Service qlsv = new QuanLySinhVien_Service();
    int index = -1;
    byte[] imageData;

    public QuanLySinhVien() {
        initComponents();
        addIcon();
        listStudents = qlsv.getAll();
        fillToTable(listStudents);
    }

    private void addIcon() {

        btnNew.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icon/new-file-icon.png"))));
        btnSave.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icon/icon_save.png"))));
        btnDelete.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icon/delete-file-icon.png"))));
        btnUpdate.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(getClass().getResource("/icon/icons8-update-32.png")).getScaledInstance(16, 16, Image.SCALE_SMOOTH)));

    }

    private void fillToTable(List<Students> listSV) {
        DefaultTableModel dtm = (DefaultTableModel) tblSinhVien.getModel();
        dtm.setRowCount(0);
        for (Students sv : listSV) {
            dtm.addRow(new Object[]{sv.getMaSV(), sv.getHoTen(), sv.getEmail(), sv.getSoDT(), sv.getGioTinh(), sv.getDiaChi(), sv.getHinh()});

        }
    }

    private Students readFrom() {
        String maSV = txtMaSV.getText().trim();
        String hoTen = txtHoTen.getText().trim();
        String email = txtEmail.getText().trim();
        String soDT = txtSoDT.getText().trim();;

        int gioiTinh = (rdoNam.isSelected()) ? 1 : 0;
        String diaChi = txtareaDiaChi.getText().trim();
        byte[] hinh = imageData;
        if (maSV.equals("") || hoTen.equals("") || email.equals("") || soDT.equals("") || diaChi.equals("")) {
            JOptionPane.showMessageDialog(this, "không được để trống");
            return null;
        }
        try {
            soDT = txtSoDT.getText().trim();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "số điện thoại phải là số  nhỏ hơn 12 số");
            return null;
        }

        return new Students(maSV, hoTen, email, soDT, gioiTinh, diaChi, hinh);
    }

    private void showDetail(int index) {
        txtMaSV.setText(tblSinhVien.getValueAt(index, 0).toString());
        txtHoTen.setText(tblSinhVien.getValueAt(index, 1).toString());
        txtEmail.setText(tblSinhVien.getValueAt(index, 2).toString());
        txtSoDT.setText(tblSinhVien.getValueAt(index, 3).toString());
        if (tblSinhVien.getValueAt(index, 4).equals(1)) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtareaDiaChi.setText(tblSinhVien.getValueAt(index, 5).toString());

        byte[] img = (byte[]) tblSinhVien.getValueAt(index, 6);
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(img);
            BufferedImage image = ImageIO.read(bais);
            //thay đổi kích thước từ một ảnh
            Image hinhSua = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);

            ImageIcon icon = new ImageIcon(hinhSua);

            btnAnh.setText("");
            btnAnh.setIcon(icon);
        } catch (Exception e) {
            btnAnh.setText("ảnh lỗi");
            btnAnh.setIcon(null);
        }

//        byte[] img = (byte[]) tblSinhVien.getValueAt(index, 6);
//        try {
//            ByteArrayInputStream bais = new ByteArrayInputStream(img);
//            BufferedImage originalImage = ImageIO.read(bais);
//
//            // Kích thước mới
//            int newWidth = 150;
//            int newHeight = 150;
//
//            // Thay đổi kích thước hình ảnh
//            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
//
//            // Tạo BufferedImage mới từ hình ảnh đã thay đổi kích thước
//            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
//            Graphics2D graphics = resizedImage.createGraphics();
//            graphics.drawImage(scaledImage, 0, 0, null);
//            graphics.dispose();
//
//            // Tạo ImageIcon từ BufferedImage đã thay đổi kích thước
//            ImageIcon icon = new ImageIcon(scaledImage);
//
//            btnAnh.setText("");
//            btnAnh.setIcon(icon);
//        } catch (Exception e) {
//            btnAnh.setText("ảnh lỗi");
//            btnAnh.setIcon(null);
//        }
    }

    private void xoaFrom() {
        txtHoTen.setText("");
        txtMaSV.setText("");
        txtEmail.setText("");
        txtSoDT.setText("");
        txtareaDiaChi.setText("");
        rdoNam.setSelected(true);
        btnAnh.setText("thêm ảnh");
        btnAnh.setIcon(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpGioiTinh = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSinhVien = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSV = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSoDT = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtareaDiaChi = new javax.swing.JTextArea();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnAnh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Họ Tên", "Email", "Số ĐT", "Giới tính", "Địa Chỉ", "Hình"
            }
        ));
        tblSinhVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSinhVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSinhVien);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Quản Lý Sinh Viên");

        jLabel2.setText("Họ tên: ");

        jLabel3.setText("MaSV");

        jLabel4.setText("Số DT: ");

        jLabel5.setText("Email: ");

        jLabel6.setText("Giới tính: ");

        jLabel7.setText("Địa chỉ: ");

        grpGioiTinh.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        grpGioiTinh.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });

        txtareaDiaChi.setColumns(20);
        txtareaDiaChi.setRows(5);
        jScrollPane2.setViewportView(txtareaDiaChi);

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAnh.setText("Ảnh");
        btnAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHoTen)
                                    .addComponent(txtMaSV)
                                    .addComponent(txtEmail)
                                    .addComponent(txtSoDT))
                                .addGap(41, 41, 41))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNew, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnNew)
                            .addComponent(btnSave))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnUpdate))))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void btnAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnhActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser dlg = new JFileChooser();
            dlg.showOpenDialog(null);
            File file = dlg.getSelectedFile();
            Image img = ImageIO.read(file);
            imageData = Files.readAllBytes(Path.of(dlg.getSelectedFile().getAbsolutePath()));
            String strHinhAnh = file.getName();
            ImageIcon icon = new ImageIcon(img);
            btnAnh.setText("");
            btnAnh.setIcon(icon);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnAnhActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (index < 0) {
            if (readFrom() == null) {
                return;
            }
            if (qlsv.insertSV(readFrom()) > 0) {

                JOptionPane.showMessageDialog(this, "thêm thành công");
                fillToTable(qlsv.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "thêm thất bại, mã sinh viên đã tồn tại");
            }
            index = 0;
        } else {
            if (qlsv.upadateSV(readFrom()) > 0) {
                JOptionPane.showMessageDialog(this, "lưu thành công");
                fillToTable(qlsv.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "lưu thất bại");
            }
        }


    }//GEN-LAST:event_btnSaveActionPerformed

    private void tblSinhVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSinhVienMouseClicked
        // TODO add your handling code here:
        index = tblSinhVien.getSelectedRow();
        if (index >= 0) {
            showDetail(index);
        }
    }//GEN-LAST:event_tblSinhVienMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        index = -1;
        xoaFrom();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        index = tblSinhVien.getSelectedRow();

        if (index >= 0) {
            if (readFrom() == null) {
                return;
            }
            if (qlsv.upadateSV(readFrom()) > 0) {
                JOptionPane.showMessageDialog(this, "sửa thành công");
                fillToTable(qlsv.getAll());
            } else {

                JOptionPane.showMessageDialog(this, "sủa thất bại, mã sv ko tồn tại");
            }
        } else {
            JOptionPane.showMessageDialog(this, "chưa chọn dòng");
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        index = tblSinhVien.getSelectedRow();

        if (index >= 0) {
            String ma = (String) tblSinhVien.getValueAt(index, 0);
            if (qlsv.deleteSV(ma) > 0) {
                JOptionPane.showMessageDialog(this, "xóa thành công sv" + ma);
                fillToTable(qlsv.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "xóa thất bại, ko tìm thấy mã sv");
            }
        } else {
            JOptionPane.showMessageDialog(this, "chưa chọn dòng cần xóa");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySinhVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnh;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup grpGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblSinhVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaSV;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextArea txtareaDiaChi;
    // End of variables declaration//GEN-END:variables
}
