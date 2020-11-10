package my.atmca2;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.ArrayList; // import the ArrayList class


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Alwin Singh
 */
public class ATMUser extends javax.swing.JFrame {

    private String accpass = "", accnum, notes;
    private double deposit, withdraw;
    final private boolean enabledBtnSound = true;
    ArrayList<String> acctPin = new ArrayList<String>(); // Create an ArrayList object

    /**
     * Creates new form ATMMainGUI
     */
    JFrame jf = new JFrame();
    ATM atmuser = new ATM();
    File ATMWelcome = new File("ATMWelcome.WAV"); //Defines a file
    File ATMButton = new File("ATMButton.WAV"); //Defines a file

    public ATMUser() throws IOException, FileNotFoundException, ClassNotFoundException {
        initComponents();
        if (enabledBtnSound) {
            ATMExitButton.addActionListener(new MyListener());
            ATMExitButton1.addActionListener(new MyListener());
            ATMExitButton2.addActionListener(new MyListener());
            keyPadButtonEnterAccNum.addActionListener(new MyListener());
            keyPadButtonEnter1.addActionListener(new MyListener());
            withdrawButton.addActionListener(new MyListener());
            depositButton.addActionListener(new MyListener());
            statementsButton.addActionListener(new MyListener());
            balanceButton.addActionListener(new MyListener());
            keyPadButton.addActionListener(new MyListener());
            keyPadButton1.addActionListener(new MyListener());
            keyPadButton2.addActionListener(new MyListener());
            keyPadButton3.addActionListener(new MyListener());
            keyPadButton4.addActionListener(new MyListener());
            keyPadButton5.addActionListener(new MyListener());
            keyPadButton6.addActionListener(new MyListener());
            keyPadButton7.addActionListener(new MyListener());
            keyPadButton8.addActionListener(new MyListener());
            keyPadButton9.addActionListener(new MyListener());
            keyPadButton10.addActionListener(new MyListener());
            keyPadButton11.addActionListener(new MyListener());
            keyPadButton12.addActionListener(new MyListener());
            keyPadButton13.addActionListener(new MyListener());
            keyPadButton14.addActionListener(new MyListener());
            keyPadButton15.addActionListener(new MyListener());
            keyPadButton16.addActionListener(new MyListener());
            keyPadButton17.addActionListener(new MyListener());
            keyPadButton18.addActionListener(new MyListener());
        }

        try {
            //create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("CREDC___.ttf")).deriveFont(49f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);
            accountArea.setFont(customFont);
            accountArea1.setFont(customFont);
            withdrawArea.setFont(customFont);
            depositArea.setFont(customFont);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        keyPadButtonEnterAccNum.setBackground(Color.green);
        ATMExitButton.setBackground(Color.red);
        keyPadButtonClear.setBackground(Color.yellow);
        keyPadButtonEnter1.setBackground(Color.green);
        ATMExitButton1.setBackground(Color.red);
        keyPadButtonClear1.setBackground(Color.yellow);
        ATMExitButton2.setBackground(Color.red);

        ATMExitButton.setFocusPainted(false);
        ATMExitButton1.setFocusPainted(false);
        ATMExitButton2.setFocusPainted(false);

        //atmuser.PlaySound(ATMWelcome); //Plays a WAV soundfile
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        atmuser.validateFile();
        jf.setAlwaysOnTop(true);

        notesArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() > '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    notesArea.setEditable(true);
                } else {
                    notesArea.setEditable(false);
                }
            }
        });

        withdrawArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    withdrawArea.setEditable(true);
                } else {
                    withdrawArea.setEditable(false);
                }
            }
        });

        depositArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                String value = withdrawArea.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    depositArea.setEditable(true);
                } else {
                    depositArea.setEditable(false);
                }
            }
        });
    }

    private class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            atmuser.PlayBtnSound(ATMButton);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        withdrawRadioBtnGroup = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        ATMIcon2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        accountArea3 = new javax.swing.JTextArea();
        ATMExitButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        depositArea = new javax.swing.JTextArea();
        depositLabel = new javax.swing.JLabel();
        depositButton = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        withdrawArea = new javax.swing.JTextArea();
        withdrawLabel = new javax.swing.JLabel();
        withdrawButton = new javax.swing.JButton();
        statementsButton = new javax.swing.JButton();
        balanceButton = new javax.swing.JButton();
        radiowithdrawButton1 = new javax.swing.JRadioButton();
        radiowithdrawButton7 = new javax.swing.JRadioButton();
        radiowithdrawButton8 = new javax.swing.JRadioButton();
        radiowithdrawButton9 = new javax.swing.JRadioButton();
        radiowithdrawButton10 = new javax.swing.JRadioButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        notesArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        clearStatementsButton = new javax.swing.JButton();
        withdrawAreaClear = new javax.swing.JButton();
        depositAreaClear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        keyPadButton1 = new javax.swing.JButton();
        ATMIcon1 = new javax.swing.JLabel();
        pinLabel1 = new javax.swing.JLabel();
        keyPadButtonEnter1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        accountArea1 = new javax.swing.JTextArea();
        ATMExitButton1 = new javax.swing.JButton();
        keyPadButtonClear1 = new javax.swing.JButton();
        keyPadButton10 = new javax.swing.JButton();
        keyPadButton11 = new javax.swing.JButton();
        keyPadButton12 = new javax.swing.JButton();
        keyPadButton13 = new javax.swing.JButton();
        keyPadButton14 = new javax.swing.JButton();
        keyPadButton15 = new javax.swing.JButton();
        keyPadButton16 = new javax.swing.JButton();
        keyPadButton17 = new javax.swing.JButton();
        keyPadButton18 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        keyPadButton = new javax.swing.JButton();
        ATMIcon = new javax.swing.JLabel();
        pinLabel = new javax.swing.JLabel();
        keyPadButtonEnterAccNum = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        accountArea = new javax.swing.JTextArea();
        ATMExitButton = new javax.swing.JButton();
        keyPadButtonClear = new javax.swing.JButton();
        keyPadButton2 = new javax.swing.JButton();
        keyPadButton4 = new javax.swing.JButton();
        keyPadButton3 = new javax.swing.JButton();
        keyPadButton5 = new javax.swing.JButton();
        keyPadButton6 = new javax.swing.JButton();
        keyPadButton7 = new javax.swing.JButton();
        keyPadButton8 = new javax.swing.JButton();
        keyPadButton9 = new javax.swing.JButton();
        keyPadButton0 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ATM MACHINE");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 51, 51));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(490, 624));
        setResizable(false);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                formComponentAdded(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(490, 624));

        ATMIcon2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alwin Singh\\Desktop\\atm-logo.png")); // NOI18N

        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        accountArea3.setEditable(false);
        accountArea3.setBackground(new java.awt.Color(102, 102, 102));
        accountArea3.setColumns(20);
        accountArea3.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        accountArea3.setRows(5);
        accountArea3.setAutoscrolls(false);
        accountArea3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        accountArea3.setEnabled(false);
        jScrollPane5.setViewportView(accountArea3);

        ATMExitButton2.setText("REMOVE CARD");
        ATMExitButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATMExitButton2ActionPerformed(evt);
            }
        });

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        depositArea.setBackground(new java.awt.Color(102, 102, 102));
        depositArea.setColumns(20);
        depositArea.setRows(5);
        depositArea.setAutoscrolls(false);
        depositArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        depositArea.setPreferredSize(new java.awt.Dimension(384, 70));
        jScrollPane3.setViewportView(depositArea);

        depositLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        depositLabel.setForeground(new java.awt.Color(204, 204, 204));
        depositLabel.setText("Deposit Cash Amount (S$)");

        depositButton.setText("Deposit");
        depositButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositButtonActionPerformed(evt);
            }
        });

        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        withdrawArea.setBackground(new java.awt.Color(102, 102, 102));
        withdrawArea.setColumns(20);
        withdrawArea.setRows(5);
        withdrawArea.setAutoscrolls(false);
        withdrawArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane8.setViewportView(withdrawArea);

        withdrawLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        withdrawLabel.setForeground(new java.awt.Color(204, 204, 204));
        withdrawLabel.setText("Withdraw Amount");

        withdrawButton.setText("Withdraw");
        withdrawButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawButtonActionPerformed(evt);
            }
        });

        statementsButton.setText("PRINT STATEMENTS");
        statementsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statementsButtonActionPerformed(evt);
            }
        });

        balanceButton.setText("CHECK BALANCE");
        balanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceButtonActionPerformed(evt);
            }
        });

        withdrawRadioBtnGroup.add(radiowithdrawButton1);
        radiowithdrawButton1.setForeground(new java.awt.Color(255, 255, 255));
        radiowithdrawButton1.setText("$100");
        radiowithdrawButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiowithdrawButton1ActionPerformed(evt);
            }
        });

        withdrawRadioBtnGroup.add(radiowithdrawButton7);
        radiowithdrawButton7.setForeground(new java.awt.Color(255, 255, 255));
        radiowithdrawButton7.setText("$200");
        radiowithdrawButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiowithdrawButton7ActionPerformed(evt);
            }
        });

        withdrawRadioBtnGroup.add(radiowithdrawButton8);
        radiowithdrawButton8.setForeground(new java.awt.Color(255, 255, 255));
        radiowithdrawButton8.setText("$300");
        radiowithdrawButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiowithdrawButton8ActionPerformed(evt);
            }
        });

        withdrawRadioBtnGroup.add(radiowithdrawButton9);
        radiowithdrawButton9.setForeground(new java.awt.Color(255, 255, 255));
        radiowithdrawButton9.setText("$500");
        radiowithdrawButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiowithdrawButton9ActionPerformed(evt);
            }
        });

        withdrawRadioBtnGroup.add(radiowithdrawButton10);
        radiowithdrawButton10.setForeground(new java.awt.Color(255, 255, 255));
        radiowithdrawButton10.setText("$1000");
        radiowithdrawButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radiowithdrawButton10ActionPerformed(evt);
            }
        });

        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        notesArea.setBackground(new java.awt.Color(102, 102, 102));
        notesArea.setColumns(20);
        notesArea.setFont(new java.awt.Font("MS Gothic", 1, 40)); // NOI18N
        notesArea.setRows(5);
        notesArea.setText("1");
        notesArea.setAutoscrolls(false);
        notesArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane9.setViewportView(notesArea);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PIECES OF NOTES");

        clearStatementsButton.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        clearStatementsButton.setText("CLEAR STATEMENTS");
        clearStatementsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearStatementsButtonActionPerformed(evt);
            }
        });

        withdrawAreaClear.setText("CLEAR FIELD");
        withdrawAreaClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawAreaClearActionPerformed(evt);
            }
        });

        depositAreaClear.setText("CLEAR FIELD");
        depositAreaClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositAreaClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(depositButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(withdrawLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(withdrawAreaClear, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(withdrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statementsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(radiowithdrawButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(radiowithdrawButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(radiowithdrawButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(balanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(radiowithdrawButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(radiowithdrawButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(ATMExitButton2)
                        .addGap(35, 35, 35)
                        .addComponent(ATMIcon2)
                        .addGap(30, 30, 30)
                        .addComponent(clearStatementsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(depositLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(depositAreaClear, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(888, 888, 888))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(depositLabel))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(clearStatementsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(26, 26, 26)
                                .addComponent(depositAreaClear)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(depositButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(withdrawLabel)
                            .addComponent(withdrawAreaClear))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(withdrawButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radiowithdrawButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radiowithdrawButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radiowithdrawButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radiowithdrawButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radiowithdrawButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statementsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(balanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ATMExitButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ATMIcon2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(388, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(490, 624));

        keyPadButton1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton1.setText("1");
        buttonGroup1.add(keyPadButton1);
        keyPadButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton1ActionPerformed(evt);
            }
        });

        ATMIcon1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alwin Singh\\Desktop\\atm-logo.png")); // NOI18N

        pinLabel1.setForeground(new java.awt.Color(204, 204, 204));
        pinLabel1.setText("Enter your account pin");

        keyPadButtonEnter1.setBackground(new java.awt.Color(51, 255, 0));
        keyPadButtonEnter1.setText("ENTER");
        keyPadButtonEnter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButtonEnter1ActionPerformed(evt);
            }
        });

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        accountArea1.setEditable(false);
        accountArea1.setBackground(new java.awt.Color(102, 102, 102));
        accountArea1.setColumns(20);
        accountArea1.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        accountArea1.setRows(5);
        accountArea1.setAutoscrolls(false);
        accountArea1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane4.setViewportView(accountArea1);

        ATMExitButton1.setBackground(new java.awt.Color(51, 255, 0));
        ATMExitButton1.setText("REMOVE CARD");
        ATMExitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATMExitButton1ActionPerformed(evt);
            }
        });

        keyPadButtonClear1.setBackground(new java.awt.Color(51, 255, 0));
        keyPadButtonClear1.setText("CLEAR");
        keyPadButtonClear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButtonClear1ActionPerformed(evt);
            }
        });

        keyPadButton10.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton10.setText("2");
        keyPadButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton10ActionPerformed(evt);
            }
        });

        keyPadButton11.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton11.setText("4");
        buttonGroup1.add(keyPadButton11);
        keyPadButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton11ActionPerformed(evt);
            }
        });

        keyPadButton12.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton12.setText("3");
        buttonGroup1.add(keyPadButton12);
        keyPadButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton12ActionPerformed(evt);
            }
        });

        keyPadButton13.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton13.setText("5");
        buttonGroup1.add(keyPadButton13);
        keyPadButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton13ActionPerformed(evt);
            }
        });

        keyPadButton14.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton14.setText("6");
        buttonGroup1.add(keyPadButton14);
        keyPadButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton14ActionPerformed(evt);
            }
        });

        keyPadButton15.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton15.setText("7");
        buttonGroup1.add(keyPadButton15);
        keyPadButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton15ActionPerformed(evt);
            }
        });

        keyPadButton16.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton16.setText("8");
        buttonGroup1.add(keyPadButton16);
        keyPadButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton16ActionPerformed(evt);
            }
        });

        keyPadButton17.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton17.setText("9");
        buttonGroup1.add(keyPadButton17);
        keyPadButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton17ActionPerformed(evt);
            }
        });

        keyPadButton18.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton18.setText("0");
        buttonGroup1.add(keyPadButton18);
        keyPadButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pinLabel1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(keyPadButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(keyPadButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addComponent(keyPadButton15, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                .addComponent(keyPadButtonClear1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(63, 63, 63)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(keyPadButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(keyPadButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(keyPadButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(keyPadButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(63, 63, 63)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(keyPadButton17, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addComponent(keyPadButton14, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addComponent(keyPadButtonEnter1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(keyPadButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(ATMExitButton1)
                            .addGap(53, 53, 53)
                            .addComponent(ATMIcon1))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ATMExitButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ATMIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pinLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keyPadButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyPadButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyPadButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keyPadButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyPadButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keyPadButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyPadButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyPadButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(keyPadButton18, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                .addComponent(keyPadButtonClear1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(keyPadButtonEnter1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(keyPadButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(224, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(490, 624));

        keyPadButton.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton.setText("1");
        buttonGroup1.add(keyPadButton);
        keyPadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButtonActionPerformed(evt);
            }
        });

        ATMIcon.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alwin Singh\\Desktop\\atm-logo.png")); // NOI18N

        pinLabel.setForeground(new java.awt.Color(204, 204, 204));
        pinLabel.setText("Enter your account number");

        keyPadButtonEnterAccNum.setBackground(new java.awt.Color(51, 255, 0));
        keyPadButtonEnterAccNum.setText("ENTER");
        keyPadButtonEnterAccNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButtonEnterAccNumActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        accountArea.setEditable(false);
        accountArea.setBackground(new java.awt.Color(102, 102, 102));
        accountArea.setColumns(20);
        accountArea.setFont(new java.awt.Font("Monospaced", 0, 36)); // NOI18N
        accountArea.setRows(5);
        accountArea.setAutoscrolls(false);
        accountArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane2.setViewportView(accountArea);

        ATMExitButton.setBackground(new java.awt.Color(51, 255, 0));
        ATMExitButton.setText("REMOVE CARD");
        ATMExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ATMExitButtonActionPerformed(evt);
            }
        });

        keyPadButtonClear.setBackground(new java.awt.Color(51, 255, 0));
        keyPadButtonClear.setText("CLEAR");
        keyPadButtonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButtonClearActionPerformed(evt);
            }
        });

        keyPadButton2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton2.setText("2");
        keyPadButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton2ActionPerformed(evt);
            }
        });

        keyPadButton4.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton4.setText("4");
        buttonGroup1.add(keyPadButton4);
        keyPadButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton4ActionPerformed(evt);
            }
        });

        keyPadButton3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton3.setText("3");
        buttonGroup1.add(keyPadButton3);
        keyPadButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton3ActionPerformed(evt);
            }
        });

        keyPadButton5.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton5.setText("5");
        buttonGroup1.add(keyPadButton5);
        keyPadButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton5ActionPerformed(evt);
            }
        });

        keyPadButton6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton6.setText("6");
        buttonGroup1.add(keyPadButton6);
        keyPadButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton6ActionPerformed(evt);
            }
        });

        keyPadButton7.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton7.setText("7");
        buttonGroup1.add(keyPadButton7);
        keyPadButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton7ActionPerformed(evt);
            }
        });

        keyPadButton8.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton8.setText("8");
        buttonGroup1.add(keyPadButton8);
        keyPadButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton8ActionPerformed(evt);
            }
        });

        keyPadButton9.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton9.setText("9");
        buttonGroup1.add(keyPadButton9);
        keyPadButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton9ActionPerformed(evt);
            }
        });

        keyPadButton0.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        keyPadButton0.setText("0");
        buttonGroup1.add(keyPadButton0);
        keyPadButton0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keyPadButton0ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pinLabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(keyPadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(keyPadButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addComponent(keyPadButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                .addComponent(keyPadButtonClear, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(63, 63, 63)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(keyPadButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(keyPadButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(keyPadButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(keyPadButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(63, 63, 63)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(keyPadButton9, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addComponent(keyPadButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                    .addComponent(keyPadButtonEnterAccNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(keyPadButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(ATMExitButton)
                            .addGap(53, 53, 53)
                            .addComponent(ATMIcon))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ATMExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ATMIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pinLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keyPadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyPadButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyPadButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keyPadButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyPadButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(keyPadButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyPadButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(keyPadButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(keyPadButton0, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                .addComponent(keyPadButtonClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(keyPadButtonEnterAccNum, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(keyPadButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(224, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 968, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentAdded


    private void keyPadButton0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton0ActionPerformed
        // TODO add your handling code here:
        atmuser.PlayBtnSound(ATMButton);
        accountArea.append("0");
    }//GEN-LAST:event_keyPadButton0ActionPerformed

    private void keyPadButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton9ActionPerformed
        // TODO add your handling code here:
        accountArea.append("9");
    }//GEN-LAST:event_keyPadButton9ActionPerformed

    private void keyPadButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton8ActionPerformed
        // TODO add your handling code here:
        accountArea.append("8");
    }//GEN-LAST:event_keyPadButton8ActionPerformed

    private void keyPadButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton7ActionPerformed
        // TODO add your handling code here:
        accountArea.append("7");
    }//GEN-LAST:event_keyPadButton7ActionPerformed

    private void keyPadButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton6ActionPerformed
        // TODO add your handling code here:
        accountArea.append("6");
    }//GEN-LAST:event_keyPadButton6ActionPerformed

    private void keyPadButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton5ActionPerformed
        // TODO add your handling code here:
        accountArea.append("5");
    }//GEN-LAST:event_keyPadButton5ActionPerformed

    private void keyPadButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton3ActionPerformed
        // TODO add your handling code here:
        accountArea.append("3");
    }//GEN-LAST:event_keyPadButton3ActionPerformed

    private void keyPadButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton4ActionPerformed
        // TODO add your handling code here:
        accountArea.append("4");
    }//GEN-LAST:event_keyPadButton4ActionPerformed

    private void keyPadButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton2ActionPerformed
        // TODO add your handling code here:
        accountArea.append("2");
    }//GEN-LAST:event_keyPadButton2ActionPerformed

    private void keyPadButtonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButtonClearActionPerformed
        // TODO add your handling code here:
        if (accountArea.getText().length() > 0) {
            JOptionPane.showMessageDialog(jf, "Cleared!");
            accountArea.setText(null);
        } else {
            JOptionPane.showMessageDialog(jf, "Nothing to clear!");
            accountArea.setText(null);
        }
    }//GEN-LAST:event_keyPadButtonClearActionPerformed

    private void ATMExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATMExitButtonActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        accountArea.setText("");
        accountArea1.setText("");
        withdrawArea.setText("");
        depositArea.setText("");
        notesArea.setText("1");
        atmuser.ATMExit();
    }//GEN-LAST:event_ATMExitButtonActionPerformed

    private void keyPadButtonEnterAccNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButtonEnterAccNumActionPerformed
        // TODO add your handling code here:
        accnum = accountArea.getText();
        try {
            atmuser.ATMDialogValidateNum(accnum);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jf, "Please re-enter the value, thank you!", "Unable to process!", JOptionPane.OK_OPTION);
        }

        accountArea.setText(null);

        if (atmuser.proceed) {
            jPanel1.setVisible(false);
            jPanel2.setVisible(true);
            jPanel3.setVisible(false);
        }
    }//GEN-LAST:event_keyPadButtonEnterAccNumActionPerformed

    private void keyPadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButtonActionPerformed
        // TODO add your handling code here:
        accountArea.append("1");
    }//GEN-LAST:event_keyPadButtonActionPerformed

    private void keyPadButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton1ActionPerformed
        // TODO add your handling code here:
        accountArea1.append("*");
        acctPin.add("1");
    }//GEN-LAST:event_keyPadButton1ActionPerformed

    private void keyPadButtonEnter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButtonEnter1ActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < acctPin.size(); i++) {
            accpass += acctPin.get(i);
        }

        try {
            atmuser.ATMDialogValidatePin(accpass);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jf, "Please re-enter the value, thank you!", "Unable to process!", JOptionPane.OK_OPTION);
        }

        accountArea1.setText(null);
        accpass = "";
        acctPin.removeAll(acctPin);

        if (atmuser.activatebutton) {
            //atmuser.interestRate();
            jPanel1.setVisible(false);
            jPanel2.setVisible(false);
            jPanel3.setVisible(true);
            atmuser.displayWelcome();
        }
    }//GEN-LAST:event_keyPadButtonEnter1ActionPerformed

    private void ATMExitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATMExitButton1ActionPerformed
        // TODO add your handling code here:
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        accountArea.setText("");
        accountArea1.setText("");
        withdrawArea.setText("");
        depositArea.setText("");
        notesArea.setText("1");
        atmuser.ATMExit();
    }//GEN-LAST:event_ATMExitButton1ActionPerformed

    private void keyPadButtonClear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButtonClear1ActionPerformed
        // TODO add your handling code here:
        if (accountArea1.getText().length() > 0) {
            JOptionPane.showMessageDialog(jf, "Cleared!");
            accountArea1.setText(null);
        } else {
            JOptionPane.showMessageDialog(jf, "Nothing to clear!");
            accountArea1.setText(null);
        }
    }//GEN-LAST:event_keyPadButtonClear1ActionPerformed

    private void keyPadButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton10ActionPerformed
        // TODO add your handling code here:
        accountArea1.append("*");
        acctPin.add("2");
    }//GEN-LAST:event_keyPadButton10ActionPerformed

    private void keyPadButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton11ActionPerformed
        // TODO add your handling code here:
        accountArea1.append("*");
        acctPin.add("4");
    }//GEN-LAST:event_keyPadButton11ActionPerformed

    private void keyPadButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton12ActionPerformed
        // TODO add your handling code here:
        accountArea1.append("*");
        acctPin.add("3");
    }//GEN-LAST:event_keyPadButton12ActionPerformed

    private void keyPadButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton13ActionPerformed
        // TODO add your handling code here:
        accountArea1.append("*");
        acctPin.add("5");
    }//GEN-LAST:event_keyPadButton13ActionPerformed

    private void keyPadButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton14ActionPerformed
        // TODO add your handling code here:
        accountArea1.append("*");
        acctPin.add("6");
    }//GEN-LAST:event_keyPadButton14ActionPerformed

    private void keyPadButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton15ActionPerformed
        // TODO add your handling code here:
        accountArea1.append("*");
        acctPin.add("7");
    }//GEN-LAST:event_keyPadButton15ActionPerformed

    private void keyPadButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton16ActionPerformed
        // TODO add your handling code here:
        accountArea1.append("*");
        acctPin.add("8");
    }//GEN-LAST:event_keyPadButton16ActionPerformed

    private void keyPadButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton17ActionPerformed
        // TODO add your handling code here:
        accountArea1.append("*");
        acctPin.add("9");
    }//GEN-LAST:event_keyPadButton17ActionPerformed

    private void keyPadButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keyPadButton18ActionPerformed
        // TODO add your handling code here:
        accountArea1.append("*");
        acctPin.add("0");
    }//GEN-LAST:event_keyPadButton18ActionPerformed

    private void ATMExitButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ATMExitButton2ActionPerformed
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
        jPanel3.setVisible(false);
        accountArea.setText("");
        accountArea1.setText("");
        withdrawArea.setText("");
        depositArea.setText("");
        notesArea.setText("1");
        atmuser.ATMExit();
    }//GEN-LAST:event_ATMExitButton2ActionPerformed

    private void depositButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositButtonActionPerformed
        // TODO add your handling code here:
        try {
            deposit = Double.valueOf(depositArea.getText());
            atmuser.ATMDeposit(deposit);
            // JOptionPane.showMessageDialog(jf, "You have deposited $" + deposit);
            depositArea.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jf, "Deposit value must be greater than $0");
        }
    }//GEN-LAST:event_depositButtonActionPerformed

    private void withdrawButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawButtonActionPerformed
        // TODO add your handling code here:
        notes = notesArea.getText();
        int intnotes = Integer.parseInt(notes);
        if (intnotes > 10) {
            JOptionPane.showMessageDialog(jf, "Cannot withdraw more than 10 notes");
        } else {
            try {
                withdraw = Double.valueOf(withdrawArea.getText()) * intnotes;
                atmuser.ATMWithdraw(withdraw);
                // JOptionPane.showMessageDialog(jf, "You have withdrawn $" + withdraw);
                withdrawArea.setText("");
                withdrawRadioBtnGroup.clearSelection();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(jf, "Withdraw value must be greater than $0");
            }
        }
    }//GEN-LAST:event_withdrawButtonActionPerformed

    private void statementsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statementsButtonActionPerformed
        // TODO add your handling code here:
        atmuser.callDisplayStatements();
    }//GEN-LAST:event_statementsButtonActionPerformed

    private void balanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceButtonActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(jf, "Your Balance: " + atmuser.checkBalance());
    }//GEN-LAST:event_balanceButtonActionPerformed

    private void radiowithdrawButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiowithdrawButton1ActionPerformed
        // TODO add your handling code here:
        withdrawArea.setText("100");
    }//GEN-LAST:event_radiowithdrawButton1ActionPerformed

    private void radiowithdrawButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiowithdrawButton7ActionPerformed
        // TODO add your handling code here:
        withdrawArea.setText("200");
    }//GEN-LAST:event_radiowithdrawButton7ActionPerformed

    private void radiowithdrawButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiowithdrawButton8ActionPerformed
        // TODO add your handling code here:
        withdrawArea.setText("300");
    }//GEN-LAST:event_radiowithdrawButton8ActionPerformed

    private void radiowithdrawButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiowithdrawButton9ActionPerformed
        // TODO add your handling code here:
        withdrawArea.setText("500");
    }//GEN-LAST:event_radiowithdrawButton9ActionPerformed

    private void radiowithdrawButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radiowithdrawButton10ActionPerformed
        // TODO add your handling code here:
        withdrawArea.setText("1000");
    }//GEN-LAST:event_radiowithdrawButton10ActionPerformed

    private void clearStatementsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearStatementsButtonActionPerformed
        // TODO add your handling code here:
        atmuser.ATMClearTransaction();
    }//GEN-LAST:event_clearStatementsButtonActionPerformed

    private void withdrawAreaClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawAreaClearActionPerformed
        // TODO add your handling code here:
        withdrawArea.setText("");
        withdrawRadioBtnGroup.clearSelection();
    }//GEN-LAST:event_withdrawAreaClearActionPerformed

    private void depositAreaClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositAreaClearActionPerformed
        // TODO add your handling code here:
        depositArea.setText("");
    }//GEN-LAST:event_depositAreaClearActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ATMUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ATMUser().setVisible(true);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(ATMUser.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ATMExitButton;
    private javax.swing.JButton ATMExitButton1;
    private javax.swing.JButton ATMExitButton2;
    private javax.swing.JLabel ATMIcon;
    private javax.swing.JLabel ATMIcon1;
    private javax.swing.JLabel ATMIcon2;
    private javax.swing.JTextArea accountArea;
    private javax.swing.JTextArea accountArea1;
    private javax.swing.JTextArea accountArea3;
    private javax.swing.JButton balanceButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton clearStatementsButton;
    private javax.swing.JTextArea depositArea;
    private javax.swing.JButton depositAreaClear;
    private javax.swing.JButton depositButton;
    private javax.swing.JLabel depositLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton keyPadButton;
    private javax.swing.JButton keyPadButton0;
    private javax.swing.JButton keyPadButton1;
    private javax.swing.JButton keyPadButton10;
    private javax.swing.JButton keyPadButton11;
    private javax.swing.JButton keyPadButton12;
    private javax.swing.JButton keyPadButton13;
    private javax.swing.JButton keyPadButton14;
    private javax.swing.JButton keyPadButton15;
    private javax.swing.JButton keyPadButton16;
    private javax.swing.JButton keyPadButton17;
    private javax.swing.JButton keyPadButton18;
    private javax.swing.JButton keyPadButton2;
    private javax.swing.JButton keyPadButton3;
    private javax.swing.JButton keyPadButton4;
    private javax.swing.JButton keyPadButton5;
    private javax.swing.JButton keyPadButton6;
    private javax.swing.JButton keyPadButton7;
    private javax.swing.JButton keyPadButton8;
    private javax.swing.JButton keyPadButton9;
    private javax.swing.JButton keyPadButtonClear;
    private javax.swing.JButton keyPadButtonClear1;
    private javax.swing.JButton keyPadButtonEnter1;
    private javax.swing.JButton keyPadButtonEnterAccNum;
    private javax.swing.JTextArea notesArea;
    private javax.swing.JLabel pinLabel;
    private javax.swing.JLabel pinLabel1;
    private javax.swing.JRadioButton radiowithdrawButton1;
    private javax.swing.JRadioButton radiowithdrawButton10;
    private javax.swing.JRadioButton radiowithdrawButton7;
    private javax.swing.JRadioButton radiowithdrawButton8;
    private javax.swing.JRadioButton radiowithdrawButton9;
    private javax.swing.JButton statementsButton;
    private javax.swing.JTextArea withdrawArea;
    private javax.swing.JButton withdrawAreaClear;
    private javax.swing.JButton withdrawButton;
    private javax.swing.JLabel withdrawLabel;
    private javax.swing.ButtonGroup withdrawRadioBtnGroup;
    // End of variables declaration//GEN-END:variables
}
