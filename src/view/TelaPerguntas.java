/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Classes.Jogador;
import Classes.Perguntas;
import Classes.Personagem;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

/**
 *
 * @author Lucas
 */
public class TelaPerguntas extends javax.swing.JFrame {

    Jogador j[] = new Jogador[2];
    Personagem p[] = new Personagem[2];
    int contador = 0;

    /**
     * Creates new form TelaPerguntas
     */
    public TelaPerguntas() {
        initComponents();
        try {
            PreencherQuestoes();
        } catch (Exception e) {
        }
        j[0] = Jogador.getInstance();
        j[1] = Jogador.getInstance2();
        p[0] = Personagem.getInstance();
        p[1] = Personagem.getInstance2();
        boolean primero_jogar = j[0].GetPrimeiro();  // Se falso, jogador 2 joga primeiro
        double vida_jogador = p[0].getVida();
        double vida_jogador2 = p[1].getVida();
        txtPontosJ1.setText(String.valueOf(vida_jogador));
        txtPontoJ2.setText(String.valueOf(vida_jogador2));
        if (primero_jogar == true) {
            txtJogador.setText(j[0].getApelido());
        } else {
            txtJogador.setText(j[1].getApelido());
        }

    }

    //Função que lê as questões, do arquivo perguntas.csv e preenche o objeto perguntas
    public void PreencherQuestoes() throws FileNotFoundException, IOException {

        //Pega o diretório do projeto
        String caminho = System.getProperty("user.dir") + "/perguntas.csv";
        LineNumberReader lineCounter = new LineNumberReader(new InputStreamReader(new FileInputStream(caminho)));
        String nextLine = null;

        while ((nextLine = lineCounter.readLine()) != null) {
            if (nextLine == null) {
                break;
            }
            System.out.println(nextLine);
        }
        //Pega o número de linhas, para poder criar o array de perguntas
        int num_perguntas = lineCounter.getLineNumber();

        Perguntas p[] = new Perguntas[num_perguntas];

        FileReader arq = new FileReader(caminho);
        BufferedReader lerArq = new BufferedReader(arq);
        boolean valido = false;

        for (int i = 0; i < num_perguntas; i++) {
            p[i] = new Perguntas();

            /*Criando array para mostrar perguntas,sendo:
            [0] - Enunciado da questão
            [1] - AlternativaA
            [2] - AlternativaB
            [3] - AlternativaC
            [4] - AlternaticaD
            [5] - Resposta*/
            String array[] = new String[5];
            String linha = lerArq.readLine();
            array = linha.split(";");
            p[i].setEnunciado(array[0]);
            p[i].setRespA(array[1]);
            p[i].setRespB(array[2]);
            p[i].setRespC(array[3]);
            p[i].setRespD(array[4]);
            p[i].setSolucao(array[5]);

        }
        txtPergunta.setText(String.valueOf(p[0].getEnunciado()));
        txtEnun1.setText(String.valueOf(p[0].getRespA()));
        txtEnun2.setText(String.valueOf(p[0].getRespB()));
        txtEnun3.setText(String.valueOf(p[0].getRespC()));
        txtEnun4.setText(String.valueOf(p[0].getRespD()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRespostas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPontosJ1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPontoJ2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtJogador = new javax.swing.JLabel();
        txtPersonagem = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPergunta = new javax.swing.JLabel();
        javax.swing.JRadioButton rdResposta1 = new javax.swing.JRadioButton();
        txtEnun1 = new javax.swing.JLabel();
        txtEnun2 = new javax.swing.JLabel();
        txtEnun3 = new javax.swing.JLabel();
        txtEnun4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QuizTime");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Jogador 1:");

        txtPontosJ1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Jogador 2:");

        txtPontoJ2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Vez de ");

        txtJogador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Pergunta:");

        txtPergunta.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        txtPergunta.setAutoscrolls(true);
        txtPergunta.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        txtPergunta.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                txtPerguntaComponentResized(evt);
            }
        });

        rdResposta1.setBackground(new java.awt.Color(255, 255, 255));
        btnRespostas.add(rdResposta1);

        txtEnun2.setText("jLabel5");

        txtEnun3.setText("jLabel6");

        txtEnun4.setText("jLabel7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(txtPersonagem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 603, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPontoJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPontosJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(rdResposta1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEnun2, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEnun1, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEnun3, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEnun4, javax.swing.GroupLayout.PREFERRED_SIZE, 902, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPontosJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPersonagem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPontoJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(txtPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEnun1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rdResposta1)))
                .addGap(34, 34, 34)
                .addComponent(txtEnun2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(txtEnun3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(txtEnun4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/house (1).png"))); // NOI18N
        jMenu1.setText("Início");
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/power.png"))); // NOI18N
        jMenu2.setText("Sair");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPerguntaComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_txtPerguntaComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPerguntaComponentResized

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
            java.util.logging.Logger.getLogger(TelaPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPerguntas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPerguntas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnRespostas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtEnun1;
    private javax.swing.JLabel txtEnun2;
    private javax.swing.JLabel txtEnun3;
    private javax.swing.JLabel txtEnun4;
    private javax.swing.JLabel txtJogador;
    private javax.swing.JLabel txtPergunta;
    private javax.swing.JLabel txtPersonagem;
    private javax.swing.JLabel txtPontoJ2;
    private javax.swing.JLabel txtPontosJ1;
    // End of variables declaration//GEN-END:variables
}
