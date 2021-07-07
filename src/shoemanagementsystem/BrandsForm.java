/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoemanagementsystem;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import static org.apache.poi.hssf.usermodel.HeaderFooter.date;

/**
 *
 * @author mnawa
 */
public class BrandsForm extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    public BrandsForm() {
        initComponents();
        
        getAllBrands();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        searchTf = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        brandsTable = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        pdfBtn = new javax.swing.JButton();
        mailBtn = new javax.swing.JButton();
        exelBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(10, 10, 10));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Brands");

        jButton8.setBackground(new java.awt.Color(10, 10, 10));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_left_25px.png"))); // NOI18N
        jButton8.setToolTipText("Go back to Home");
        jButton8.setBorderPainted(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        searchTf.setText("Search...");
        searchTf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTfMouseClicked(evt);
            }
        });
        searchTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTfFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 407, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(276, 276, 276)
                .addComponent(searchTf, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 70));

        jPanel1.setBackground(new java.awt.Color(18, 18, 18));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        brandsTable.setBackground(new java.awt.Color(20, 20, 20));
        brandsTable.setForeground(new java.awt.Color(255, 255, 255));
        brandsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Brand Name", "Company Name"
            }
        ));
        brandsTable.setFocusable(false);
        brandsTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        brandsTable.setRequestFocusEnabled(false);
        brandsTable.setRowHeight(26);
        brandsTable.setSelectionBackground(new java.awt.Color(153, 153, 153));
        brandsTable.setShowVerticalLines(false);
        brandsTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(brandsTable);

        refreshBtn.setBackground(new java.awt.Color(187, 134, 252));
        refreshBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        refreshBtn.setForeground(new java.awt.Color(255, 255, 255));
        refreshBtn.setText("Refresh");
        refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(18, 18, 18));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Options Available", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteBtn.setBackground(new java.awt.Color(187, 134, 252));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete");
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        jPanel2.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, 30));

        updateBtn.setBackground(new java.awt.Color(187, 134, 252));
        updateBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update");
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel2.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, 30));

        addBtn.setBackground(new java.awt.Color(187, 134, 252));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel2.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 66, 30));

        pdfBtn.setBackground(new java.awt.Color(187, 134, 252));
        pdfBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pdfBtn.setForeground(new java.awt.Color(255, 255, 255));
        pdfBtn.setText("Create PDF");
        pdfBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfBtnActionPerformed(evt);
            }
        });

        mailBtn.setBackground(new java.awt.Color(187, 134, 252));
        mailBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mailBtn.setForeground(new java.awt.Color(255, 255, 255));
        mailBtn.setText("Send Email");
        mailBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailBtnActionPerformed(evt);
            }
        });

        exelBtn.setBackground(new java.awt.Color(187, 134, 252));
        exelBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exelBtn.setForeground(new java.awt.Color(255, 255, 255));
        exelBtn.setText("Create Exel File");
        exelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exelBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LIST OF ALL EMPLOYEES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(pdfBtn)
                        .addGap(78, 78, 78)
                        .addComponent(exelBtn)
                        .addGap(67, 67, 67)
                        .addComponent(mailBtn)
                        .addGap(68, 68, 68)
                        .addComponent(refreshBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1005, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 67, 1050, 670));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
        new MainMenuFrame().setVisible(true);
        MainMenuFrame.setUsername();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void searchTfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTfMouseClicked
        String text = searchTf.getText();
        if (text.equals("Search...")) {
            searchTf.setText("");
        }
    }//GEN-LAST:event_searchTfMouseClicked

    private void searchTfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTfFocusGained
        String text = searchTf.getText();
        if (text.equals("Search...")) {
            searchTf.setText("");
        }
    }//GEN-LAST:event_searchTfFocusGained

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        Refresh();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        this.dispose();
        new DeleteBrand().setVisible(true);
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        this.dispose();
        new UpdateBrand().setVisible(true);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        this.dispose();
        new AddBrand().setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed

    private void pdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfBtnActionPerformed

        try {
            DefaultTableModel model = (DefaultTableModel) brandsTable.getModel();

            JFileChooser filechooser = new JFileChooser();
            filechooser.showSaveDialog(null);

            Document doc = new Document();
            PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(filechooser.getSelectedFile() + ".pdf"));
            doc.open();
            PdfPTable pdfTable = new PdfPTable(model.getColumnCount());
            float[] columnWidths = new float[]{3, 20, 20, 9, 15, 15};
            pdfTable.setWidths(columnWidths);

            Paragraph p1 = new Paragraph("Shoe Hub \nSadar Bazar,Arifwala \nContact#:03182420151");

            //adding table headers
            for (int i = 0; i < model.getColumnCount(); i++) {
                pdfTable.addCell(model.getColumnName(i));

            }

            //extracting data from the JTable and inserting it to PdfPTable
            for (int rows = 0; rows < model.getRowCount() - 1; rows++) {
                for (int cols = 0; cols < model.getColumnCount(); cols++) {
                    pdfTable.addCell(model.getValueAt(rows, cols).toString());

                }
            }
            doc.addHeader("deme", "Shoe Hub \nSadar Bazar,Arifwala \nContact#:03182420151");
            doc.add(pdfTable);
            doc.close();
            JOptionPane.showMessageDialog(this, "PDF File Created successfuly");

        } catch (DocumentException ex) {
            Logger.getLogger(EmployeeForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_pdfBtnActionPerformed

    private void mailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mailBtnActionPerformed

    private void exelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exelBtnActionPerformed

        FileOutputStream fileOut = null;
        try {

            DefaultTableModel model = (DefaultTableModel) brandsTable.getModel();

            JFileChooser filechooser = new JFileChooser();
            filechooser.showSaveDialog(null);
            fileOut = new FileOutputStream(filechooser.getSelectedFile() + ".csv");

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Employees");

            HSSFRow rowhead = sheet.createRow((short) 0);

            for (int i = 0; i < model.getColumnCount(); i++) {
                rowhead.createCell(i).setCellValue(model.getColumnName(i));

            }

            for (int i = 0; i < model.getRowCount(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                for (int j = 0; j < model.getColumnCount(); j++) {
                    row.createCell(j).setCellValue(model.getValueAt(i, j).toString());

                }

            }

            try {
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();
                JOptionPane.showMessageDialog(this, "Excel File Created successfuly");

            } catch (IOException ex) {
                Logger.getLogger(EmployeeForm.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EmployeeForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exelBtnActionPerformed
    public void getAllBrands() {
        try {
            conn = DBConnection.getConnection();

            st = conn.prepareStatement("select * from brands");
            rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String supplier=rs.getString(3);

                Object[] obj = {id, name, supplier};
                DefaultTableModel tb = (DefaultTableModel) brandsTable.getModel();
                tb.addRow(obj);

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    void Refresh() {
        DefaultTableModel tb = (DefaultTableModel) brandsTable.getModel();
        tb.setRowCount(0);
        getAllBrands();
    }

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
            java.util.logging.Logger.getLogger(BrandsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BrandsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BrandsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BrandsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BrandsForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTable brandsTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton exelBtn;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mailBtn;
    private javax.swing.JButton pdfBtn;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JTextField searchTf;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
