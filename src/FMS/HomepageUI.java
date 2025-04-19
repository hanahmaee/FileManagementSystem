package FMS;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class HomepageUI extends javax.swing.JFrame {
    private JTable fileTable;
    private JScrollPane tableScrollPane;
    private DefaultTableModel tableModel;
    private TableRowSorter<DefaultTableModel> rowSorter;
    private static String loggedInEmail;
    private static String loggedInPassword;


public HomepageUI(String email, String password) {
    this.loggedInEmail = email;
    this.loggedInPassword = password;
        initComponents();
        loadUserFile();
    
    Logout.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            new LogInUI().setVisible(true);
            dispose(); // Close HomepageUI
        }
    });
    
    FilePanel.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
    new HomepageUI(loggedInEmail, loggedInPassword).setVisible(true); // ✅ Now with password
        dispose(); // Close the current HomepageUI to refresh the view
        }
    });

    Account.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            new AccountUI(loggedInEmail, loggedInPassword).setVisible(true);
            dispose(); // Close HomepageUI
        }
    });

    fileTables.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = fileTables.rowAtPoint(e.getPoint());
        int column = fileTables.columnAtPoint(e.getPoint());

        if (column == 3) { // "Action" column
            String actionValue = fileTables.getValueAt(row, column).toString();
            if ("Delete".equalsIgnoreCase(actionValue)) {
                int confirm = javax.swing.JOptionPane.showConfirmDialog(
                    HomepageUI.this,
                    "Do you want to delete this file?",
                    "Confirm Delete",
                    javax.swing.JOptionPane.YES_NO_OPTION
                );

                if (confirm == javax.swing.JOptionPane.YES_OPTION) {
                    String fileName = fileTables.getValueAt(row, 0).toString(); // Get file name from column 0
                    DefaultTableModel model = (DefaultTableModel) fileTables.getModel();

                    // Delete from database
                    try (Connection conn = DBConnection.getConnection()) {
                        String sql = "DELETE FROM file WHERE file_name = ? AND email = ?";
                        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                            stmt.setString(1, fileName);
                            stmt.setString(2, loggedInEmail);

                            int affectedRows = stmt.executeUpdate();

                            if (affectedRows > 0) {
                                model.removeRow(row); // Only remove from UI if deletion in DB was successful
                                javax.swing.JOptionPane.showMessageDialog(
                                    HomepageUI.this,
                                    "File deleted successfully.",
                                    "Success",
                                    javax.swing.JOptionPane.INFORMATION_MESSAGE
                                );
                            } else {
                                javax.swing.JOptionPane.showMessageDialog(
                                    HomepageUI.this,
                                    "File not found or failed to delete.",
                                    "Error",
                                    javax.swing.JOptionPane.ERROR_MESSAGE
                                );
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        javax.swing.JOptionPane.showMessageDialog(
                            HomepageUI.this,
                            "Database error occurred while deleting file.",
                            "Error",
                            javax.swing.JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            }
        }
    }
});

    }
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        FileConnect = new javax.swing.JLabel();
        FMS = new javax.swing.JLabel();
        FilePanel = new javax.swing.JPanel();
        FilesTxt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Account = new javax.swing.JPanel();
        AccountTxt = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Logout = new javax.swing.JPanel();
        LogoutTxt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        NewFile = new javax.swing.JButton();
        filePane = new javax.swing.JScrollPane();
        fileTables = new javax.swing.JTable();
        searchPanel = new javax.swing.JPanel();
        searchTxtField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(9, 94, 139));
        jPanel2.setMinimumSize(new java.awt.Dimension(300, 500));

        FileConnect.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        FileConnect.setForeground(new java.awt.Color(255, 255, 255));
        FileConnect.setText("FileConnect");

        FMS.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        FMS.setForeground(new java.awt.Color(255, 255, 255));
        FMS.setText("FILE MANAGEMENT");

        FilePanel.setBackground(new java.awt.Color(9, 94, 139));

        FilesTxt.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        FilesTxt.setForeground(new java.awt.Color(255, 255, 255));
        FilesTxt.setText("Files");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/components/file.png"))); // NOI18N

        javax.swing.GroupLayout FilePanelLayout = new javax.swing.GroupLayout(FilePanel);
        FilePanel.setLayout(FilePanelLayout);
        FilePanelLayout.setHorizontalGroup(
            FilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilePanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FilesTxt)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        FilePanelLayout.setVerticalGroup(
            FilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(FilesTxt))
                .addContainerGap())
        );

        Account.setBackground(new java.awt.Color(9, 94, 139));

        AccountTxt.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        AccountTxt.setForeground(new java.awt.Color(255, 255, 255));
        AccountTxt.setText("Account");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/components/account.png"))); // NOI18N

        javax.swing.GroupLayout AccountLayout = new javax.swing.GroupLayout(Account);
        Account.setLayout(AccountLayout);
        AccountLayout.setHorizontalGroup(
            AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccountLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AccountTxt)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        AccountLayout.setVerticalGroup(
            AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AccountLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(AccountTxt))
                .addContainerGap())
        );

        Logout.setBackground(new java.awt.Color(9, 94, 139));

        LogoutTxt.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        LogoutTxt.setForeground(new java.awt.Color(255, 255, 255));
        LogoutTxt.setText("Logout");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/components/logout.png"))); // NOI18N

        javax.swing.GroupLayout LogoutLayout = new javax.swing.GroupLayout(Logout);
        Logout.setLayout(LogoutLayout);
        LogoutLayout.setHorizontalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LogoutTxt)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        LogoutLayout.setVerticalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogoutLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(LogoutTxt))
                .addContainerGap())
        );

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/components/logosmall.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(FMS))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(FileConnect))
                                    .addComponent(FilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(FileConnect)
                        .addGap(68, 68, 68)
                        .addComponent(FMS)))
                .addGap(54, 54, 54)
                .addComponent(FilePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(Account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 290, 770);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Dashboard");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(330, 70, 190, 48);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Manage your different files here!");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(330, 120, 300, 25);

        NewFile.setBackground(new java.awt.Color(9, 94, 139));
        NewFile.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NewFile.setForeground(new java.awt.Color(255, 255, 255));
        NewFile.setText("+ New");
        NewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewFileActionPerformed(evt);
            }
        });
        jPanel1.add(NewFile);
        NewFile.setBounds(870, 110, 90, 30);

        fileTables.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "File Name", "File Size", "File Type", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        fileTables.setRowHeight(50);
        filePane.setViewportView(fileTables);

        jPanel1.add(filePane);
        filePane.setBounds(330, 170, 670, 480);

        searchPanel.setBackground(new java.awt.Color(255, 255, 255));

        searchTxtField.setBackground(new java.awt.Color(255, 255, 255));
        searchTxtField.setForeground(new java.awt.Color(0, 0, 0));
        searchTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxtFieldFieldActionPerformed(evt);
            }
        });

        searchBtn.setBackground(new java.awt.Color(9, 94, 139));
        searchBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(searchTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(searchPanel);
        searchPanel.setBounds(310, 20, 690, 50);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/components/fms.png"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 1030, 770);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchTxtFieldFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtFieldFieldActionPerformed
        searchBtn.doClick(); // Simulate button click
    }//GEN-LAST:event_searchTxtFieldFieldActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        String searchText = searchTxtField.getText().trim();

        if (searchText.length() == 0) {
            rowSorter.setRowFilter(null); // Show all rows
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText, 0)); // Filter by file name (column 0)
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void NewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewFileActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setMultiSelectionEnabled(true); // Allow selecting multiple files
    int option = fileChooser.showOpenDialog(this);

    if (option == JFileChooser.APPROVE_OPTION) {
        File[] selectedFiles = fileChooser.getSelectedFiles();
        DefaultTableModel model = (DefaultTableModel) fileTables.getModel();
        String email = loggedInEmail;
        
        try (Connection conn = DBConnection.getConnection()){
            for (File file : selectedFiles) {
                String fileName = file.getName();
                long fileSize = file.length();
                String fileType = getFileExtension(file);
                String action = "Delete"; // You can update this to a button later if needed

                String sql = "INSERT INTO file (file_name, file_size, file_type, email) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql)){
                    stmt.setString(1, fileName);
                    stmt.setLong(2, fileSize);
                    stmt.setString(3, fileType);
                    stmt.setString(4, email);
                    stmt.executeUpdate();
                } catch (SQLException e){
                    e.printStackTrace();
                    javax.swing.JOptionPane.showMessageDialog(this, "Failed to save file to database.", "File Failed", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
                
                model.addRow(new Object[]{fileName, readableFileSize(fileSize), fileType, action});
        }
            if (rowSorter == null) {
            tableModel = (DefaultTableModel) fileTables.getModel();
            rowSorter = new TableRowSorter<>(tableModel);
            fileTables.setRowSorter(rowSorter);
            }
        } catch (SQLException e){
            e.printStackTrace();
            }
        }
    }//GEN-LAST:event_NewFileActionPerformed
    private String getFileExtension(File file) {
        String name = file.getName();
        int lastIndex = name.lastIndexOf('.');
        if (lastIndex > 0 && lastIndex < name.length() - 1) {
            return name.substring(lastIndex + 1).toUpperCase();
        }
        return "Unknown";
    }

    private String readableFileSize(long size) {
        if (size <= 0) return "0";
        final String[] units = new String[]{"B", "KB", "MB", "GB", "TB"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
        return String.format("%.1f %s", size / Math.pow(1024, digitGroups), units[digitGroups]);
    }
    
    private void loadUserFile(){
    DefaultTableModel model = (DefaultTableModel) fileTables.getModel();
    model.setRowCount(0);
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement("SELECT file_name, file_size, file_type FROM file WHERE email = ?")) {

        stmt.setString(1, loggedInEmail);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            String fileName = rs.getString("file_name");
            long fileSize = rs.getLong("file_size");
            String fileType = rs.getString("file_type");
            String action = "Delete"; // Placeholder action

            model.addRow(new Object[]{fileName, readableFileSize(fileSize), fileType, action});
        }

        if (rowSorter == null) {
            tableModel = model;
            rowSorter = new TableRowSorter<>(tableModel);
            fileTables.setRowSorter(rowSorter);
        }

    } catch (SQLException e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Failed to load files from the database.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
    }
}


        public static void main(String args[]) {

            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                new HomepageUI(loggedInEmail, loggedInPassword).setVisible(true);
                }
            });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Account;
    private javax.swing.JLabel AccountTxt;
    private javax.swing.JLabel FMS;
    private javax.swing.JLabel FileConnect;
    private javax.swing.JPanel FilePanel;
    private javax.swing.JLabel FilesTxt;
    private javax.swing.JPanel Logout;
    private javax.swing.JLabel LogoutTxt;
    private javax.swing.JButton NewFile;
    private javax.swing.JScrollPane filePane;
    private javax.swing.JTable fileTables;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton searchBtn;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTxtField;
    // End of variables declaration//GEN-END:variables

}
