/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package trabalho.ps;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import trabalho.ps.Macro.Macro;
import trabalho.ps.Montador.Assembler;

import trabalho.ps.Loader.Loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class janela1 extends javax.swing.JFrame {

    // Atributos de machine
    private static Memory memory = new Memory(2048);

    private static Register register1 = new Register(4, 10, "R1");
    private static Register register2 = new Register(4, 11, "R2");

    private static Register A = new Register(24, 0, "A");
    private static Register X = new Register(24, 1, "X");
    private static Register L = new Register(24, 2, "L");
    private static Register B = new Register(24, 3, "B");
    private static Register S = new Register(24, 4, "S");
    private static Register T = new Register(24, 5, "T");
    private static Register F = new Register(48, 6, "F");
    private static Register PC = new Register(24, 8, "PC");
    private static Register SW = new Register(24, 9, "SW");

    private static Word address = new Word(20);
    private static Word opcode = new Word(8);
    private static Word nixbpe = new Word(6);
    private static Word dataFormMemory = new Word(24);
    private static Word instruction15 = new Word(15);

    public janela1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        runbutton = new javax.swing.JButton();
        abrirarquivo = new javax.swing.JButton();
        loadButton = new javax.swing.JButton();
        macroButton = new javax.swing.JButton();
        montadorButton = new javax.swing.JButton();
        Stepbutton = new javax.swing.JButton();
        regA = new javax.swing.JTextField();
        regX = new javax.swing.JTextField();
        regT = new javax.swing.JTextField();
        regB = new javax.swing.JTextField();
        regS = new javax.swing.JTextField();
        regL = new javax.swing.JTextField();
        regF = new javax.swing.JTextField();
        regPC = new javax.swing.JTextField();
        regSW = new javax.swing.JTextField();
        clearbutton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {0,0},
                {1,0},
                {2,0},
                {3,0},
                {4,0},
                {5,0},
                {6,0},
                {7,0},
                {8,0},
                {9,0},
                {10,0},
                {11,0},
                {12,0},
                {13,0},
                {14,0},
                {15,0},
                {16,0},
                {17,0},
                {18,0},
                {19,0},
                {20,0},
                {21,0},
                {22,0},
                {23,0},
                {24,0},
                {25,0},
                {26,0},
                {27,0},
                {28,0},
                {29,0},
                {30,0},
                {31,0},
                {32,0},
                {33,0},
                {34,0},
                {35,0},
                {36,0},
                {37,0},
                {38,0},
                {39,0},
                {40,0},
                {41,0},
                {42,0},
                {43,0},
                {44,0},
                {45,0},
                {46,0},
                {47,0},
                {48,0},
                {49,0},
                {50,0},
                {51,0},
                {52,0},
                {53,0},
                {54,0},
                {55,0},
                {56,0},
                {57,0},
                {58,0},
                {59,0},
                {60,0},
                {61,0},
                {62,0},
                {63,0},
                {64,0},
                {65,0},
                {66,0},
                {67,0},
                {68,0},
                {69,0},
                {70,0},
                {71,0},
                {72,0},
                {73,0},
                {74,0},
                {75,0},
                {76,0},
                {77,0},
                {78,0},
                {79,0},
                {80,0},
                {81,0},
                {82,0},
                {83,0},
                {84,0},
                {85,0},
                {86,0},
                {87,0},
                {88,0},
                {89,0},
                {90,0},
                {91,0},
                {92,0},
                {93,0},
                {94,0},
                {95,0},
                {96,0},
                {97,0},
                {98,0},
                {99,0}
            },
            new String [] {
                "Endereço", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 80, 310, 580));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 310, 210));

        runbutton.setOpaque(false);
        runbutton.setContentAreaFilled(false);
        runbutton.setBorderPainted(false);

        runbutton.setBorderPainted(false);
        runbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(runbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 530, 340, 50));

        abrirarquivo.setOpaque(false);
        abrirarquivo.setContentAreaFilled(false);
        abrirarquivo.setBorderPainted(false);
        abrirarquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirarquivoActionPerformed(evt);
            }
        });
        getContentPane().add(abrirarquivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 320, 50));

        loadButton.setOpaque(false);
        loadButton.setContentAreaFilled(false);
        loadButton.setBorderPainted(false);

        loadButton.setBorderPainted(false);
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loadButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 320, 50));

        macroButton.setOpaque(false);
        macroButton.setContentAreaFilled(false);
        macroButton.setBorderPainted(false);
        macroButton.setBorderPainted(false);
        macroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                macroButtonActionPerformed(evt);
            }
        });
        getContentPane().add(macroButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 320, 50));

        montadorButton.setOpaque(false);
        montadorButton.setContentAreaFilled(false);
        montadorButton.setBorderPainted(false);
        montadorButton.setBorderPainted(false);
        montadorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                montadorButtonActionPerformed(evt);
            }
        });
        getContentPane().add(montadorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 320, 50));

        Stepbutton.setOpaque(false);
        Stepbutton.setContentAreaFilled(false);
        Stepbutton.setBorderPainted(false);

        Stepbutton.setBorderPainted(false);
        Stepbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StepbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(Stepbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, 320, 40));

        regA.setEditable(false);
        regA.setText("0");
        regA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regAActionPerformed(evt);
            }
        });
        getContentPane().add(regA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, 120, -1));

        regX.setEditable(false);
        regX.setText("0");
        regX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regXActionPerformed(evt);
            }
        });
        getContentPane().add(regX, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 120, 30));

        regT.setEditable(false);
        regT.setText("0");
        regT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regTActionPerformed(evt);
            }
        });
        getContentPane().add(regT, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, 120, -1));

        regB.setEditable(false);
        regB.setText("0");
        getContentPane().add(regB, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 120, -1));

        regS.setEditable(false);
        regS.setText("0");
        getContentPane().add(regS, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 490, 120, -1));

        regL.setEditable(false);
        regL.setText("0");
        getContentPane().add(regL, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 120, -1));

        regF.setEditable(false);
        regF.setText("0");
        getContentPane().add(regF, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 120, -1));

        regPC.setEditable(false);
        regPC.setText("0");
        getContentPane().add(regPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, 120, -1));

        regSW.setEditable(false);
        regSW.setText("0");
        regSW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regSWActionPerformed(evt);
            }
        });
        getContentPane().add(regSW, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 590, 120, -1));

        clearbutton.setOpaque(false);
        clearbutton.setContentAreaFilled(false);
        clearbutton.setBorderPainted(false);
        clearbutton.setBorderPainted(false);
        clearbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(clearbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 600, 340, 60));

        jTextField1.setForeground(new java.awt.Color(255, 102, 51));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 200, 50));

        fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/trabalho/imagens/PS3.png"))); // NOI18N
        fundo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        getContentPane().add(fundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 1270, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void StepbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StepbuttonActionPerformed
        if (!(opcode.convertBinaryToHex()).equals("12")) {
            step();
        } else {
            jTextArea1.append("Finalizando execução de " + jTextField1.getText() + "...\n\n");
        }
    }//GEN-LAST:event_StepbuttonActionPerformed

    private void runbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runbuttonActionPerformed
        run(jTextField1.getText());
    }//GEN-LAST:event_runbuttonActionPerformed

    private void clearbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbuttonActionPerformed
        resetMemory();
        resetRegisters();
        jTextArea1.setText("");
        jTextField1.setText("");
    }//GEN-LAST:event_clearbuttonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void regAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regAActionPerformed

    private void regXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regXActionPerformed

    private void regTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regTActionPerformed

    private void regSWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regSWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regSWActionPerformed

    private void loadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadButtonActionPerformed
        try {
            jTextArea1.append("Carregando instruções de " + jTextField1.getText() + "...\n\n");

            Loader.load("C:/Users/Marce/Documents/PS/assembler.txt", memory, PC.convertBinaryToDecimal());

            // Atualiza memória na interface
            updateMemory();

            jTextArea1.append("Instruções carregadas na memória\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_loadButtonActionPerformed

    private void abrirarquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirarquivoActionPerformed
        JFileChooser JFile1 = new JFileChooser();
        JFile1.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = JFile1.showSaveDialog(null);
        if (JFile1.getSelectedFile() != null) {
            String caminho1;
            File arquivo1 = JFile1.getSelectedFile();
            caminho1 = arquivo1.getPath();
            jTextField1.setText(caminho1);
        }
    }//GEN-LAST:event_abrirarquivoActionPerformed

    private void montadorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_montadorButtonActionPerformed
        try {
            jTextArea1.append("Executando montador para " + jTextField1.getText() + "...\n\n");
            Assembler.assemble("C:/Users/Marce/Documents/PS/macro.txt");
            jTextArea1.append("Arquivo assembler.txt criado.\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_montadorButtonActionPerformed

    private void macroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_macroButtonActionPerformed
        try {
            jTextArea1.append("Processando macros de " + jTextField1.getText() + "...\n\n");
            Macro.proccess(jTextField1.getText());
            jTextArea1.append("Arquivo macro.txt criado.\n\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_macroButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new janela1().setVisible(true);
            }
        });
    }

    public void resetRegisters() {
        A.setBits(0);
        X.setBits(0);
        L.setBits(0);
        B.setBits(0);
        S.setBits(0);
        T.setBits(0);
        F.setBits(0);
        PC.setBits(0);
        SW.setBits(0);

        opcode.setBits(0);
        address.setBits(0);
        nixbpe.setBits(0);

        updateRegisters();

    }

    public void updateRegisters() {
        regA.setText(Integer.toString(A.convertBinaryToDecimal()));
        regX.setText(Integer.toString(X.convertBinaryToDecimal()));
        regL.setText(Integer.toString(L.convertBinaryToDecimal()));
        regB.setText(Integer.toString(B.convertBinaryToDecimal()));
        regS.setText(Integer.toString(S.convertBinaryToDecimal()));
        regT.setText(Integer.toString(T.convertBinaryToDecimal()));
        regF.setText(Integer.toString(F.convertBinaryToDecimal()));
        regPC.setText(Integer.toString(SW.convertBinaryToDecimal()));
        regSW.setText(Integer.toString(PC.convertBinaryToDecimal()));
    }

    public void resetMemory() {
        memory.resetMemory();
        updateMemory();
    }

    public void updateMemory() {
        for (int i = 0; i < 100; i++) {
            jTable1.setValueAt(i, i, 0);
            jTable1.setValueAt(memory.getMemory()[i].convertBinaryToDecimal(), i, 1);
        }
    }

    public void step() {
        Word instruction = nextInstruction();
        if (!opcode.convertBinaryToHex().equals("12")) {
            runOperations(instruction.getFormat());

            // Atualiza registradores na interface
            updateRegisters();
            // Atualiza memória na interface
            updateMemory();
        }
    }

    // Metodos do Machine
    public void run(String filepath) {
        jTextArea1.append("Executando instruções de " + jTextField1.getText() + "...\n\n");

        do {
            step();
        } while (!opcode.convertBinaryToHex().equals("12"));

        jTextArea1.append("Finalizando execução de " + filepath + "...\n\n");
    }

    public static Word nextInstruction() {
        Word instruction = memory.readMemory(PC.convertBinaryToDecimal());

        if (instruction.getFormat() == 1) {
            for (int i = 0; i < 8; i++) {
                opcode.setBitByIndex(i, instruction.getValueByIndex(i));
            }
        } else if (instruction.getFormat() == 2) {
            for (int i = 0; i < 8; i++) {
                opcode.setBitByIndex(i, instruction.getValueByIndex(i));
            }

            getRegisters(instruction);
        } else {
            opcode.setBitByIndex(6, '0');
            opcode.setBitByIndex(7, '0');

            for (int i = 0; i < 6; i++) {
                opcode.setBitByIndex(i, instruction.getValueByIndex(i));
            }

            for (int i = 6, j = 0; i < 12; i++) {
                nixbpe.setBitByIndex(j++, instruction.getValueByIndex(i));
            }

            getAddress(instruction);
        }

        PC.setBits(PC.convertBinaryToDecimal() + instruction.getFormat());

        return instruction;
    }

    public static void getAddress(Word instruction) {
        Word formattedAddress = new Word(instruction.getFormat() == 3 ? 12 : 20);

        if (instruction.getFormat() == 3) {
            for (int i = 12, j = 0; i < 24; i++) {
                formattedAddress.setBitByIndex(j++, instruction.getValueByIndex(i));
            }
        } else {
            for (int i = 12, j = 0; i < 32; i++) {
                formattedAddress.setBitByIndex(j++, instruction.getValueByIndex(i));
            }
        }

        address.setBits(addressMode(formattedAddress.convertBinaryToDecimal()));
    }

    public static int addressMode(int selectedAddress) {
        if (nixbpe.getValueByIndex(0) == '1' && nixbpe.getValueByIndex(1) == '1') { // Direto
            if (nixbpe.getValueByIndex(2) == '1') {
                if (nixbpe.getValueByIndex(3) == '1') {
                    return X.convertBinaryToDecimal() + B.convertBinaryToDecimal() + selectedAddress;
                } else if (nixbpe.getValueByIndex(4) == '1') {
                    return X.convertBinaryToDecimal() + PC.convertBinaryToDecimal() + selectedAddress;
                } else {
                    return X.convertBinaryToDecimal() + selectedAddress;
                }

            } else if (nixbpe.getValueByIndex(3) == '1') {
                return B.convertBinaryToDecimal() + selectedAddress;
            } else if (nixbpe.getValueByIndex(4) == '1') {
                return PC.convertBinaryToDecimal() + selectedAddress;
            } else {
                return selectedAddress;
            }
        } else if (nixbpe.getValueByIndex(0) == '1' && nixbpe.getValueByIndex(1) == '0') { // Indireto
            return memory.readMemory(selectedAddress).convertBinaryToDecimal();
        } else if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') { // Imediato
            return selectedAddress;
        } else if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '0') { // Instrução Simples
            return X.convertBinaryToDecimal() + selectedAddress;
        } else {
            return 0;
        }
    }

    public static void getRegisters(Word instruction) {
        for (int i = 8, j = 0; i < 12; i++) {
            register1.setBitByIndex(j++, instruction.getValueByIndex(i));
        }

        for (int i = 12, j = 0; i < 16; i++) {
            register2.setBitByIndex(j++, instruction.getValueByIndex(i));
        }
    }

    public static Register selectedRegister(Register selectedRegister) {
        switch (selectedRegister.convertBinaryToDecimal()) {
            case 0:
                return A;
            case 1:
                return X;
            case 2:
                return L;
            case 3:
                return B;
            case 4:
                return S;
            case 5:
                return T;
            case 6:
                return F;
            default:
                return null;
        }
    }

    public static void runOperations(int instructionFormat) {
        switch (instructionFormat) {
            case 2:
                switch (opcode.convertBinaryToHex()) {
                    case "90":
                        addr(selectedRegister(register1), selectedRegister(register2));
                        break;

                    case "4":
                        clear(selectedRegister(register1));
                        break;
                    case "a0":
                        compr(selectedRegister(register1), selectedRegister(register2));
                        break;

                    case "9c":
                        divr(selectedRegister(register1), selectedRegister(register2));
                        break;
                    case "98":
                        mulr(selectedRegister(register1), selectedRegister(register2));
                        break;
                    case "ac":
                        rmo(selectedRegister(register1), selectedRegister(register2));
                        break;
                    case "a4":
                        shiftl(selectedRegister(register1), selectedRegister(register2).convertBinaryToDecimal());
                        break;
                    case "a8":
                        shiftr(selectedRegister(register1), selectedRegister(register2).convertBinaryToDecimal());
                        break;
                    case "94":
                        subr(selectedRegister(register1), selectedRegister(register2));
                        break;
                    case "b8":
                        tixr(selectedRegister(register1));
                        break;
                }
            case 3:
            case 4:
                switch (opcode.convertBinaryToHex()) {
                    case "18":                        //case ADD
                        add(address.convertBinaryToDecimal());
                        break;
                    case "40":                         //case AND
                        and(address.convertBinaryToDecimal());
                        break;
                    case "28":                        //case COMP
                        comp(address.convertBinaryToDecimal());
                        break;
                    case "24":                        //case DIV
                        div(address.convertBinaryToDecimal());
                        break;
                    case "3c":                        //case J
                        j(address.convertBinaryToDecimal());
                        break;
                    case "30":                        //case JEQ
                        jeq(address.convertBinaryToDecimal());
                        break;
                    case "34":                        //case JGT
                        jgt(address.convertBinaryToDecimal());
                        break;
                    case "38":                        //case JLT
                        jlt(address.convertBinaryToDecimal());
                        break;
                    case "48":                        //case JSUB
                        jsub(address.convertBinaryToDecimal());
                        break;
                    case "0":                        //case LDA
                        lda(address.convertBinaryToDecimal());
                        break;
                    case "68":                         //case LDB
                        ldb(address.convertBinaryToDecimal());
                        break;
                    case "50":                        //case LDCH
                        ldch(address.convertBinaryToDecimal());
                        break;
                    case "8":                        //case LDL
                        ldl(address.convertBinaryToDecimal());
                        break;
                    case "6c":                        //case LDS
                        lds(address.convertBinaryToDecimal());
                        break;
                    case "74":                        //case LDT
                        ldt(address.convertBinaryToDecimal());
                        break;
                    case "4":                        //case LDX
                        ldx(address.convertBinaryToDecimal());
                        break;
                    case "20":                        //case MUL
                        mul(address.convertBinaryToDecimal());
                        break;
                    case "44":                        //case OR
                        or(address.convertBinaryToDecimal());
                        break;
                    case "4c":                        //case RSUB
                        rsub();
                        break;
                    case "c": // Verificar se é 0c    //case STA
                        sta(address.convertBinaryToDecimal(), instructionFormat);
                        break;
                    case "78":                        //case STB
                        stb(address.convertBinaryToDecimal(), instructionFormat);
                        break;
                    case "54":                        //case STCH
                        stch(address.convertBinaryToDecimal(), instructionFormat);
                        break;
                    case "14":                        //case STL
                        stl(address.convertBinaryToDecimal(), instructionFormat);
                        break;
                    case "7c":                        //case STS
                        sts(address.convertBinaryToDecimal(), instructionFormat);
                        break;
                    case "84":                        //case STT
                        stt(address.convertBinaryToDecimal(), instructionFormat);
                        break;
                    case "10":                        //case STX
                        stx(address.convertBinaryToDecimal(), instructionFormat);
                        break;
                    case "1c":                        //case SUB
                        sub(address.convertBinaryToDecimal());
                        break;
                    case "2c":                        //case TIX
                        tix(address.convertBinaryToDecimal());
                        break;
                }
        }
    }

    // Inicio das operações de 2 bytes
    public static void addr(Register selectedRegister1, Register selectedRegister2) {
        selectedRegister2.setBits(selectedRegister2.convertBinaryToDecimal() + selectedRegister1.convertBinaryToDecimal());
    }

    public static void clear(Register register) {
        register.setBits(0);
    }

    public static void compr(Register selectedRegister1, Register selectedRegister2) {
        if (selectedRegister1.convertBinaryToDecimal() == selectedRegister2.convertBinaryToDecimal()) {
            SW.setBits(1);
        } else if (selectedRegister1.convertBinaryToDecimal() > selectedRegister2.convertBinaryToDecimal()) {
            SW.setBits(2);
        } else {
            SW.setBits(3);
        }
    }

    public static void divr(Register selectedRegister1, Register selectedRegister2) {
        selectedRegister2.setBits(selectedRegister2.convertBinaryToDecimal() / selectedRegister1.convertBinaryToDecimal());
    }

    public static void mulr(Register selectedRegister1, Register selectedRegister2) {
        selectedRegister2.setBits(selectedRegister2.convertBinaryToDecimal() * selectedRegister1.convertBinaryToDecimal());
    }

    public static void rmo(Register selectedRegister1, Register selectedRegister2) {
        selectedRegister2.setBits(selectedRegister1.convertBinaryToDecimal());
    }

    public static void shiftl(Register selectedRegister1, int n) {
        selectedRegister1.setBits(selectedRegister1.convertBinaryToDecimal() << n);
    }

    public static void shiftr(Register selectedRegister1, int n) {
        selectedRegister1.setBits(selectedRegister1.convertBinaryToDecimal() >> n);
    }

    public static void subr(Register selectedRegister1, Register selectedRegister2) {
        selectedRegister2.setBits(selectedRegister2.convertBinaryToDecimal() - selectedRegister1.convertBinaryToDecimal());
    }

    public static void tixr(Register selectedRegister1) {
        compr(selectedRegister(register1), selectedRegister(register2));

        X.setBits(X.convertBinaryToDecimal() + 1);
    }

    // Fim das operações de 2 bytes
    //inicio das operações de 3/4 bytes
    public static void add(int address) {
        //verificar se é endereçamento indireto
        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            A.setBits(A.convertBinaryToDecimal() + address);
        } //caso não for indireto, lê da memória
        else {
            //lê da memória
            Word data_from_memory = memory.readMemory(address, 1);
            A.setBits(A.convertBinaryToDecimal() + data_from_memory.convertBinaryToDecimal());
        }
    }

    public static void and(int address) {
        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            A.setBits(A.convertBinaryToDecimal() & address);
        } else {
            Word data_from_memory = memory.readMemory(address, 3);
            A.setBits(A.convertBinaryToDecimal() & data_from_memory.convertBinaryToDecimal());
        }
    }

    public static void comp(int address) {
        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            if (A.convertBinaryToDecimal() == address) {
                SW.setBits(1);
            } else if (A.convertBinaryToDecimal() > address) {
                SW.setBits(2);
            } else {
                SW.setBits(3);
            }
        } else {
            int data_from_memory = memory.readMemory(address, 3).convertBinaryToDecimal();

            if (A.convertBinaryToDecimal() == data_from_memory) {
                SW.setBits(1);
            } else if (A.convertBinaryToDecimal() > data_from_memory) {
                SW.setBits(2);
            } else {
                SW.setBits(3);
            }
        }
    }

    public static void div(int address) {
        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            A.setBits(A.convertBinaryToDecimal() / address);
        } //caso não for direto, lê da memória
        else {
            Word data = new Word(24);
            //lê da memória
            Word data_from_memory = memory.readMemory(address, 3);
            A.setBits(A.convertBinaryToDecimal() / data_from_memory.convertBinaryToDecimal());
        }

    }

    public static void j(int address) {
        PC.setBits(address);
    }

    public static void jeq(int address) {
        if (SW.convertBinaryToDecimal() == 1) {
            PC.setBits(address);
        }
    }

    public static void jgt(int address) {
        if (SW.convertBinaryToDecimal() == 2) {
            PC.setBits(address);
        }
    }

    public static void jlt(int address) {
        if (SW.convertBinaryToDecimal() == 3) {
            PC.setBits(address);
        }
    }

    public static void jsub(int address) {
        L.setBits(PC.getBits());
        PC.setBits(address);
    }

    public static void lda(int address) {
        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            A.setBits(address);
        } else {
            Word data_from_memory = memory.readMemory(address, 3);
            A.setBits(data_from_memory.convertBinaryToDecimal());
        }
    }

    public static void ldb(int address) {
        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            B.setBits(address);
        } else {
            Word data_from_memory = memory.readMemory(address, 3);
            B.setBits(data_from_memory.convertBinaryToDecimal());
        }
    }

    public static void ldch(int address) {

        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            A.setBits(address);
        } else {
            Word data_from_memory = memory.readMemory(address + 2, 1);
            A.setBits(data_from_memory.convertBinaryToDecimal());
        }
    }

    public static void ldl(int address) {

        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            L.setBits(address);
        } else {
            Word data_from_memory = memory.readMemory(address, 3);
            L.setBits(data_from_memory.convertBinaryToDecimal());
        }
    }

    public static void lds(int address) {

        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            S.setBits(address);
        } else {
            Word data_from_memory = memory.readMemory(address, 3);
            S.setBits(data_from_memory.convertBinaryToDecimal());
        }
    }

    public static void ldt(int address) {

        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            T.setBits(address);
        } else {
            Word data_from_memory = memory.readMemory(address, 3);
            T.setBits(data_from_memory.convertBinaryToDecimal());
        }
    }

    public static void ldx(int address) {

        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            X.setBits(address);
        } else {
            Word data_from_memory = memory.readMemory(address, 3);
            X.setBits(data_from_memory.convertBinaryToDecimal());
        }
    }

    public static void mul(int address) {
        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            A.setBits(A.convertBinaryToDecimal() * address);
        } else {
            Word data_from_memory = memory.readMemory(address, 3);
            A.setBits(A.convertBinaryToDecimal() * data_from_memory.convertBinaryToDecimal());
        }

    }

    public static void or(int address) {
        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            A.setBits(A.convertBinaryToDecimal() | address);
        } else {
            Word data_from_memory = memory.readMemory(address, 3);
            A.setBits(A.convertBinaryToDecimal() | data_from_memory.convertBinaryToDecimal());
        }
    }

    public static void rsub() {
        PC.setBits(L.getBits());
    }

    public static void sta(int address, int instruc_size) {
        memory.memoryWrite(address, instruc_size, A);
    }

    public static void stb(int address, int instruc_size) {
        memory.memoryWrite(address, instruc_size, B);
    }

    public static void stch(int address, int instruc_size) {
        //seria o byte mais à direita (address + 2)? 
        memory.memoryWrite(address + 2, instruc_size, A);
    }

    public static void stl(int address, int instruc_size) {
        memory.memoryWrite(address, instruc_size, L);
    }

    public static void sts(int address, int instruc_size) {
        memory.memoryWrite(address, instruc_size, S);
    }

    public static void stt(int address, int instruc_size) {
        memory.memoryWrite(address, instruc_size, T);
    }

    public static void stx(int address, int instruc_size) {
        memory.memoryWrite(address, instruc_size, X);
    }

    public static void sub(int address) {
        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            A.setBits(A.convertBinaryToDecimal() - address);
        } else {
            //lê da memória
            Word data_from_memory = memory.readMemory(address, 3);
            A.setBits(A.convertBinaryToDecimal() - data_from_memory.convertBinaryToDecimal());
        }
    }

    public static void tix(int address) {
        if (nixbpe.getValueByIndex(0) == '0' && nixbpe.getValueByIndex(1) == '1') {
            if (X.convertBinaryToDecimal() == address) {
                SW.setBits(1);
            } else if (X.convertBinaryToDecimal() > address) {
                SW.setBits(2);
            } else {
                SW.setBits(3);
            }
        } else {
            Word data_from_memory = memory.readMemory(address, 3);
            if (X.convertBinaryToDecimal() == address) {
                SW.setBits(1);
            } else if (X.convertBinaryToDecimal() > address) {
                SW.setBits(2);
            } else {
                SW.setBits(3);
            }
        }
        //deve ser incrementado antes ou depois?
        X.setBits(X.convertBinaryToDecimal() + 1);
    }

    //Fim das operações do tipo 3/4	

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Stepbutton;
    private javax.swing.JButton abrirarquivo;
    private javax.swing.JButton clearbutton;
    private javax.swing.JLabel fundo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton loadButton;
    private javax.swing.JButton macroButton;
    private javax.swing.JButton montadorButton;
    private javax.swing.JTextField regA;
    private javax.swing.JTextField regB;
    private javax.swing.JTextField regF;
    private javax.swing.JTextField regL;
    private javax.swing.JTextField regPC;
    private javax.swing.JTextField regS;
    private javax.swing.JTextField regSW;
    private javax.swing.JTextField regT;
    private javax.swing.JTextField regX;
    private javax.swing.JButton runbutton;
    // End of variables declaration//GEN-END:variables
}
