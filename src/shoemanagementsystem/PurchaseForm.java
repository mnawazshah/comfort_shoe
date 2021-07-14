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
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Pos;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.html.ImageView;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleCsvExporterConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import static org.bouncycastle.asn1.iana.IANAObjectIdentifiers.mail;
import static org.eclipse.persistence.config.QueryType.Report;
import static org.eclipse.persistence.config.TargetDatabase.Database;

public class PurchaseForm extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    private TableRowSorter<TableModel> rowSorter;

    public PurchaseForm() {
        initComponents();
        Font font = purchaseLbl.getFont();
        Map attrib = font.getAttributes();
        attrib.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        purchaseLbl.setFont(font.deriveFont(attrib));

        productsTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        productsTable.getTableHeader().setOpaque(false);
        productsTable.getTableHeader().setBackground(new Color(187, 134, 252));
        productsTable.getTableHeader().setForeground(new Color(255, 255, 255));
        productsTable.setRowHeight(25);

        conn = DBConnection.getConnection();

        getAllProducts();
        TableFilter();
    }

    void TableFilter() {
        rowSorter = new TableRowSorter<>(productsTable.getModel());
        productsTable.setRowSorter(rowSorter);

        searchTf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchTf.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchTf.getText();

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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        searchTf = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        mailExcelBtn = new javax.swing.JButton();
        pdfBtn = new javax.swing.JButton();
        mailPDFBtn = new javax.swing.JButton();
        exelBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        purchaseLbl = new javax.swing.JLabel();

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

        jPanel2.setBackground(new java.awt.Color(12, 12, 12));

        jPanel3.setBackground(new java.awt.Color(29, 29, 29));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Purchasing Module");

        jButton8.setBackground(new java.awt.Color(29, 29, 29));
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
                .addGap(368, 368, 368)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchTf, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(searchTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(29, 29, 29));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        productsTable.setBackground(new java.awt.Color(20, 20, 20));
        productsTable.setForeground(new java.awt.Color(255, 255, 255));
        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Code", "Product Name", "Category", "Type", "Company", "Brand", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productsTable.setFocusable(false);
        productsTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        productsTable.setRequestFocusEnabled(false);
        productsTable.setRowHeight(26);
        productsTable.setSelectionBackground(new java.awt.Color(153, 153, 153));
        productsTable.setShowVerticalLines(false);
        productsTable.getTableHeader().setReorderingAllowed(false);
        productsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productsTable);

        mailExcelBtn.setBackground(new java.awt.Color(187, 134, 252));
        mailExcelBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mailExcelBtn.setForeground(new java.awt.Color(255, 255, 255));
        mailExcelBtn.setText("Email Excel file");
        mailExcelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mailExcelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailExcelBtnActionPerformed(evt);
            }
        });

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

        mailPDFBtn.setBackground(new java.awt.Color(187, 134, 252));
        mailPDFBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mailPDFBtn.setForeground(new java.awt.Color(255, 255, 255));
        mailPDFBtn.setText("Email PDF file");
        mailPDFBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mailPDFBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mailPDFBtnActionPerformed(evt);
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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Any product to see available colors and sizes");

        jPanel4.setBackground(new java.awt.Color(29, 29, 29));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Options", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));

        addBtn.setBackground(new java.awt.Color(187, 134, 252));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add Product");
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(187, 134, 252));
        updateBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update Product");
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(187, 134, 252));
        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Delete Product");
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        purchaseLbl.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        purchaseLbl.setForeground(new java.awt.Color(255, 255, 255));
        purchaseLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        purchaseLbl.setText("View Purchase History");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(purchaseLbl))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(317, 317, 317)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(pdfBtn)
                .addGap(91, 91, 91)
                .addComponent(exelBtn)
                .addGap(107, 107, 107)
                .addComponent(mailPDFBtn)
                .addGap(113, 113, 113)
                .addComponent(mailExcelBtn)
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(purchaseLbl)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mailPDFBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mailExcelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
private static JasperReport jreport;

    void reports() {
        try {
//            jreport = (JasperReport) JRLoader.loadObject(new File("C:\\Users\\mnawa\\JaspersoftWorkspace\\projectReports\\StockReports\\stock.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport("C:\\Users\\mnawa\\JaspersoftWorkspace\\projectReports\\StockReports\\stock.jasper", new HashMap(), DBConnection.getConnection());

            JasperViewer jviewer = new JasperViewer(jprint, false);
            jviewer.setVisible(true);

//       JasperPrint jp = JasperFillManager.fillReport("C:\\Users\\mnawa\\JaspersoftWorkspace\\projectReports\\StockReports\\stock.jasper",null,DBConnection.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    File file2;
    private void mailExcelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailExcelBtnActionPerformed
        try {
            file2 = new File(System.getProperty("user.home") + "\\OneDrive\\Desktop\\stock.csv");

            JRCsvExporter exporter = new JRCsvExporter();
            exporter.setExporterInput(new SimpleExporterInput(JasperFillManager.fillReport(locationCSV, null, DBConnection.getConnection())));

            exporter.setExporterOutput(new SimpleWriterExporterOutput(file2));
            SimpleCsvExporterConfiguration configuration = new SimpleCsvExporterConfiguration();
            configuration.setWriteBOM(Boolean.TRUE);
            configuration.setRecordDelimiter("\r\n");
            exporter.setConfiguration(configuration);
            exporter.exportReport();

        } catch (Exception e) {
            e.printStackTrace();

        }

        String to = "mnawazshah49@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "syyedmnawazshah@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("syyedmnawazshah@gmail.com", "ilovepakistan");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("List of all Dealers");

            // Now set the actual message
            Multipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            String msg = "file attached. ";
            messageBodyPart.setText(msg, "utf-8", "html");
            multipart.addBodyPart(messageBodyPart);

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            try {
                attachmentBodyPart.attachFile(file2.getAbsoluteFile(), "application/csv", null);
            } catch (IOException ex) {
                Logger.getLogger(PurchaseForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            multipart.addBodyPart(attachmentBodyPart);
            message.setContent(multipart);
            JOptionPane.showMessageDialog(this, "sending PDF File, It may take time ...", "Sending", JOptionPane.PLAIN_MESSAGE);

            // Send message
            Transport.send(message);
            JOptionPane.showMessageDialog(this, "File sent successfully ...", "Sent", JOptionPane.PLAIN_MESSAGE);

            if (file2.exists()) {
                file2.delete();
            }

        } catch (MessagingException mex) {
            System.out.println(mex);
        }
    }//GEN-LAST:event_mailExcelBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        this.dispose();
        new AddPurchase().setVisible(true);
    }//GEN-LAST:event_addBtnActionPerformed
    String locationPDF = "C:\\Users\\mnawa\\JaspersoftWorkspace\\projectReports\\StockReports\\stockPDF.jasper";
    String locationCSV = "C:\\Users\\mnawa\\JaspersoftWorkspace\\projectReports\\StockReports\\stockCSV.jasper";
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

    private void productsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsTableMouseClicked
        ProductDetailFrame f = new ProductDetailFrame();
        f.setVisible(true);
        f.setLocationRelativeTo(productsTable);

        int row = productsTable.getSelectedRow();
        TableModel model = (DefaultTableModel) productsTable.getModel();
        String code = model.getValueAt(row, 1).toString();
        String category = model.getValueAt(row, 3).toString();

        if (category.equals("Men")) {
            f.pDetailTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{},
                    new String[]{
                        "Color", "40", "41", "42", "43", "44", "45", "46"
                    }
            ));
            f.men = true;
            f.code = code;
            f.setColorAndSize();
        } else if (category.equals("Women")) {
            f.pDetailTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{},
                    new String[]{
                        "Color", "36", "37", "38", "39", "40", "41", "42"
                    }
            ));
            f.women = true;
            f.code = code;
            f.setColorAndSize();

        }


    }//GEN-LAST:event_productsTableMouseClicked
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
    File file;
    private void mailPDFBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mailPDFBtnActionPerformed

        try {
            JasperPrint jprint;

            jprint = JasperFillManager.fillReport(locationPDF, null, DBConnection.getConnection());

            file = new File(System.getProperty("user.home") + "\\OneDrive\\Desktop\\stock.pdf");

            JasperExportManager.exportReportToPdfFile(jprint, file.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();

        }

        String to = "mnawazshah49@gmail.com";

        // Sender's email ID needs to be mentioned
        String from = "syyedmnawazshah@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("syyedmnawazshah@gmail.com", "ilovepakistan");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("List of all Dealers");

            // Now set the actual message
            Multipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            String msg = "file attached. ";
            messageBodyPart.setText(msg, "utf-8", "html");
            multipart.addBodyPart(messageBodyPart);

            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            try {
                attachmentBodyPart.attachFile(file.getAbsolutePath(), "application/pdf", null);
            } catch (IOException ex) {
                Logger.getLogger(PurchaseForm.class.getName()).log(Level.SEVERE, null, ex);
            }
            multipart.addBodyPart(attachmentBodyPart);
            message.setContent(multipart);
            JOptionPane.showMessageDialog(this, "sending PDF File, It may take time ...", "Sending", JOptionPane.PLAIN_MESSAGE);

            // Send message
            Transport.send(message);
            JOptionPane.showMessageDialog(this, "File sent successfully ...", "Sent", JOptionPane.PLAIN_MESSAGE);

            if (file.exists()) {
                file.delete();
            }

        } catch (MessagingException mex) {
            System.out.println(mex);
        }
    }//GEN-LAST:event_mailPDFBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteBtnActionPerformed

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

    void getAllProducts() {
        try {
            st = conn.prepareStatement("select * from stock");
            rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String name = rs.getString(3);
                String category = rs.getString(4);
                String type = rs.getString(5);
                String supplier = rs.getString(6);
                String brand = rs.getString(7);

                int quant = rs.getInt(8);
                int u_price = rs.getInt(9);

                Object[] obj = {id, code, name, category, type, supplier, brand, quant, u_price};
                DefaultTableModel tb = (DefaultTableModel) productsTable.getModel();
                tb.addRow(obj);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void Refresh() {
        DefaultTableModel tb = (DefaultTableModel) productsTable.getModel();
        tb.setRowCount(0);
        getAllProducts();
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Darcula".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PurchaseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton exelBtn;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mailExcelBtn;
    private javax.swing.JButton mailPDFBtn;
    private javax.swing.JButton pdfBtn;
    private javax.swing.JTable productsTable;
    private javax.swing.JLabel purchaseLbl;
    private javax.swing.JTextField searchTf;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
