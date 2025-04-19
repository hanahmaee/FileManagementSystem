package FMS;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AccountUI extends javax.swing.JFrame {
    private JTable fileTable;
    private JScrollPane tableScrollPane;
    private DefaultTableModel tableModel;

    public AccountUI() {
        initComponents();
        addEventHandlers();

    }
    
private void addEventHandlers() {
    // Navigate to HomepageUI when "Files" is clicked
    File.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            String email = emailField.getText(); // Get the email from the emailField
            new HomepageUI(email).setVisible(true); // Pass the email to HomepageUI
            dispose(); // Close AccountUI
        }
    });

    // Navigate to Login when "Logout" is clicked
    Logout.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            new LogInUI().setVisible(true);
            dispose(); // Close AccountUI
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
        File = new javax.swing.JPanel();
        FilesTxt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Account = new javax.swing.JPanel();
        AccountTxt = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Logout = new javax.swing.JPanel();
        LogoutTxt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        passPanel = new javax.swing.JPanel();
        passTxt = new javax.swing.JLabel();
        passField = new javax.swing.JTextField();
        emailPanel = new javax.swing.JPanel();
        emailTxt = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
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

        File.setBackground(new java.awt.Color(9, 94, 139));

        FilesTxt.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        FilesTxt.setForeground(new java.awt.Color(255, 255, 255));
        FilesTxt.setText("Files");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/components/file.png"))); // NOI18N

        javax.swing.GroupLayout FileLayout = new javax.swing.GroupLayout(File);
        File.setLayout(FileLayout);
        FileLayout.setHorizontalGroup(
            FileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FileLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FilesTxt)
                .addContainerGap(108, Short.MAX_VALUE))
        );
        FileLayout.setVerticalGroup(
            FileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FileLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                    .addComponent(File, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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
                .addComponent(File, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(Account, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 290, 770);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Profile Information");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(340, 120, 310, 48);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Account");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(330, 30, 190, 48);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("See your personal information here");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(330, 80, 300, 25);

        passPanel.setBackground(new java.awt.Color(255, 255, 255));

        passTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        passTxt.setForeground(new java.awt.Color(0, 0, 0));
        passTxt.setText("PASSWORD");

        passField.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout passPanelLayout = new javax.swing.GroupLayout(passPanel);
        passPanel.setLayout(passPanelLayout);
        passPanelLayout.setHorizontalGroup(
            passPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(passPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passTxt)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        passPanelLayout.setVerticalGroup(
            passPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(passTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(passPanel);
        passPanel.setBounds(350, 290, 580, 90);

        emailPanel.setBackground(new java.awt.Color(255, 255, 255));

        emailTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailTxt.setForeground(new java.awt.Color(0, 0, 0));
        emailTxt.setText("EMAIL");

        emailField.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout emailPanelLayout = new javax.swing.GroupLayout(emailPanel);
        emailPanel.setLayout(emailPanelLayout);
        emailPanelLayout.setHorizontalGroup(
            emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailTxt)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        emailPanelLayout.setVerticalGroup(
            emailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(emailTxt)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(emailPanel);
        emailPanel.setBounds(350, 200, 580, 90);

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

    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AccountUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Account;
    private javax.swing.JLabel AccountTxt;
    private javax.swing.JLabel FMS;
    private javax.swing.JPanel File;
    private javax.swing.JLabel FileConnect;
    private javax.swing.JLabel FilesTxt;
    private javax.swing.JPanel Logout;
    private javax.swing.JLabel LogoutTxt;
    private javax.swing.JTextField emailField;
    private javax.swing.JPanel emailPanel;
    private javax.swing.JLabel emailTxt;
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
    private javax.swing.JTextField passField;
    private javax.swing.JPanel passPanel;
    private javax.swing.JLabel passTxt;
    // End of variables declaration//GEN-END:variables
}
