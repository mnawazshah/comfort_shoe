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
import java.awt.Color;
import java.awt.Font;
import java.io.File;
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
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.export.SimpleCsvExporterConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author mnawa
 */
public class DealerForm extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    public DealerForm() {
        initComponents();
        dealersTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        dealersTable.getTableHeader().setOpaque(false);
        dealersTable.getTableHeader().setBackground(new Color(187, 134, 252));
        dealersTable.getTableHeader().setForeground(new Color(255, 255, 255));
        dealersTable.setRowHeight(25);

        getDealers();
        TableFilter();
    }
    private TableRowSorter<TableModel> rowSorter;

    void TableFilter() {
        rowSorter = new TableRowSorter<>(dealersTable.getModel());
        dealersTable.setRowSorter(rowSorter);

        searchTf2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchTf2.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchTf2.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dealersTable = new javax.swing.JTable();
        refreshBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        deleteBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        pdfBtn = new javax.swing.JButton();
        mailBtn = new javax.swing.JButton();
        exelBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        searchTf2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(18, 18, 18));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);

        dealersTable.setBackground(new java.awt.Color(20, 20, 20));
        dealersTable.setForeground(new java.awt.Color(255, 255, 255));
        dealersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Employee Name", "Email", "Contact#", "Address", "CNIC", "Account#"
            }
        ));
        dealersTable.setFocusable(false);
        dealersTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        dealersTable.setRequestFocusEnabled(false);
        dealersTable.setRowHeight(26);
        dealersTable.setSelectionBackground(new java.awt.Color(153, 153, 153));
        dealersTable.setShowVerticalLines(false);
        dealersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(dealersTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 930, 379));

        refreshBtn.setBackground(new java.awt.Color(187, 134, 252));
        refreshBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        refreshBtn.setForeground(new java.awt.Color(255, 255, 255));
        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_synchronize_25px.png"))); // NOI18N
        refreshBtn.setText("Refresh");
        refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });
        jPanel1.add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 640, -1, 30));

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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 317, 90));

        pdfBtn.setBackground(new java.awt.Color(187, 134, 252));
        pdfBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pdfBtn.setForeground(new java.awt.Color(255, 255, 255));
        pdfBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_pdf_25px.png"))); // NOI18N
        pdfBtn.setText("Create PDF");
        pdfBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfBtnActionPerformed(evt);
            }
        });
        jPanel1.add(pdfBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 640, -1, 30));

        mailBtn.setBackground(new java.awt.Color(187, 134, 252));
        mailBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mailBtn.setForeground(new java.awt.Color(255, 255, 255));
        mailBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_gmail_25px.png"))); // NOI18N
        mailBtn.setText("Send Email");
        mailBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(mailBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 640, -1, 30));

        exelBtn.setBackground(new java.awt.Color(187, 134, 252));
        exelBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exelBtn.setForeground(new java.awt.Color(255, 255, 255));
        exelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_microsoft_excel_2019_25px.png"))); // NOI18N
        exelBtn.setText("Create Exel File");
        exelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exelBtnActionPerformed(evt);
            }
        });
        jPanel1.add(exelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 640, -1, 30));

        jLabel2.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LIST OF ALL EMPLOYEES");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 194, 160, 20));

        jPanel3.setBackground(new java.awt.Color(10, 10, 10));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Dealers");

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

        searchTf2.setText("Search...");
        searchTf2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTf2MouseClicked(evt);
            }
        });
        searchTf2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTf2FocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(252, 252, 252)
                .addComponent(searchTf2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(searchTf2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 701, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(969, 701));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        Refresh();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        this.dispose();
        new DeleteDealer().setVisible(true);
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        this.dispose();
        new UpdateDealer().setVisible(true);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        this.dispose();
        new AddDealer().setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed
    String date;
    String locationPDF = "C:\\Users\\mnawa\\JaspersoftWorkspace\\projectReports\\DealerReports\\dealerPDF.jasper";
    private void pdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfBtnActionPerformed

        try {
            JasperPrint jprint;

            jprint = JasperFillManager.fillReport(locationPDF, null, DBConnection.getConnection());

            JFileChooser chooser = new JFileChooser();
            chooser.showSaveDialog(null);
            File f = chooser.getSelectedFile();
            if (f != null) {

                JasperExportManager.exportReportToPdfFile(jprint, f.getAbsolutePath() + ".pdf");
                JOptionPane.showMessageDialog(null, "PDF file generated", "PDF", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }//GEN-LAST:event_pdfBtnActionPerformed
    String locationCSV = "C:\\Users\\mnawa\\JaspersoftWorkspace\\projectReports\\DealerReports\\dealerCSV.jasper";
    private void exelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exelBtnActionPerformed
        try {

            JRCsvExporter exporter = new JRCsvExporter();
            exporter.setExporterInput(new SimpleExporterInput(JasperFillManager.fillReport(locationCSV, null, DBConnection.getConnection())));
            JFileChooser chooser = new JFileChooser();
            chooser.showSaveDialog(null);
            File f = chooser.getSelectedFile();
            if (f != null) {
                exporter.setExporterOutput(new SimpleWriterExporterOutput(new File(f.getAbsolutePath()) + ".csv"));
                SimpleCsvExporterConfiguration configuration = new SimpleCsvExporterConfiguration();
                configuration.setWriteBOM(Boolean.TRUE);
                configuration.setRecordDelimiter("\r\n");
                exporter.setConfiguration(configuration);
                exporter.exportReport();

                JOptionPane.showMessageDialog(null, "CSV file generated", "CSV", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }

    }//GEN-LAST:event_exelBtnActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
        new MainMenuFrame().setVisible(true);
        MainMenuFrame.setUsername();
    }//GEN-LAST:event_jButton8ActionPerformed
    int xMouse;
    int yMouse;
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void searchTf2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTf2MouseClicked
        String text = searchTf2.getText();
        if (text.equals("Search...")) {
            searchTf2.setText("");
        }
    }//GEN-LAST:event_searchTf2MouseClicked

    private void searchTf2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTf2FocusGained
        String text = searchTf2.getText();
        if (text.equals("Search...")) {
            searchTf2.setText("");
        }
    }//GEN-LAST:event_searchTf2FocusGained

    public void getDealers() {
        try {
            conn = DBConnection.getConnection();
            String view = "select * from supplier_contact_details";
            st = conn.prepareStatement(view);
            rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String employee = rs.getString(3);
                String email = rs.getString(4);
                String contact = rs.getString(5);
                String address = rs.getString(6);
                String cnic = rs.getString(7);
                String account = rs.getString(8);

                Object[] obj = {id, name, employee, email, contact, address, cnic, account};
                DefaultTableModel tb = (DefaultTableModel) dealersTable.getModel();
                tb.addRow(obj);

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    void Refresh() {
        DefaultTableModel tb = (DefaultTableModel) dealersTable.getModel();
        tb.setRowCount(0);
        getDealers();
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
            java.util.logging.Logger.getLogger(DealerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DealerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DealerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DealerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DealerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTable dealersTable;
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
    private javax.swing.JTextField searchTf2;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
