/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.PerguntaDAO;
import model.Jogador;
import model.Perguntas;
import model.Personagem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Jogo;
import model.Respostas;

/**
 *
 * @author Lucas
 */
public class TelaPerguntas extends javax.swing.JFrame {

    Jogador j[] = new Jogador[2];
    Personagem p[] = new Personagem[2];

    /**
     * Creates new form TelaPerguntas
     */
    public TelaPerguntas() {
        initComponents();
        Jogo jogo = new Jogo();
        Jogo.setRodada(1);
        Jogo.setRod_perguntas(0);
        int rodada_p = Jogo.getRod_perguntas();
        ListarQuestoes(rodada_p);

        j[0] = Jogador.getInstance();
        j[1] = Jogador.getInstance2();
        p[0] = Personagem.getInstance();
        p[1] = Personagem.getInstance2();
        boolean JogadorRodada = j[0].GetJogadorRodada();  // Se falso, jogador 2 joga primeiro
        double vida_jogador = p[0].getVida();
        double vida_jogador2 = p[1].getVida();
        int vida1 = (int) vida_jogador;
        int vida2 = (int) vida_jogador2;
        progJ1.setValue(vida1);
        jProgressBar1.setValue(vida2);
        txtNomeJ1.setText(j[0].getApelido());
        txtNomeJ2.setText(j[1].getApelido());
        if (JogadorRodada == true) {
            txtJogador.setText(j[0].getApelido());
        } else {
            txtJogador.setText(j[1].getApelido());
        }
        btnAvancar.setVisible(false);

    }

    public void ListarQuestoes(int rodada) {
        j[0] = Jogador.getInstance();

        //Declarando PerguntaDAO, classe onde está nossas consultas no banco
        PerguntaDAO p = new PerguntaDAO();
        //Array List, para preencher um mesmo objeto, com varios valores
        List<Perguntas> perguntas = new ArrayList<>();
        //Chamando nosso metodo de consulta de PerguntaDAO
        perguntas = p.ListaPerguntas();
        //Preenchendo o label de Pergunta
        txtPergunta.setText(perguntas.get(rodada).getEnunciado());

        int ID_QUESTAO = (perguntas.get(rodada).getID());
        List<Respostas> respostas = p.ListarRespostas(ID_QUESTAO);
        //For para percorrer o vetor de respostas
        for (int i = 0; i < respostas.size(); i++) {
            String alternativa = respostas.get(i).getALTERNATIVA();
            //Switch setando o texto do label de acordo com a alternativa
            switch (alternativa) {
                case "A":
                    txtEnun1.setText(respostas.get(i).getDS_ALTERNATIVA());
                    break;
                case "B":
                    txtEnun2.setText(respostas.get(i).getDS_ALTERNATIVA());
                    break;
                case "C":
                    txtEnun3.setText(respostas.get(i).getDS_ALTERNATIVA());
                    break;
                case "D":
                    txtEnun4.setText(respostas.get(i).getDS_ALTERNATIVA());
                    break;
            }
        }

    }

    private void AvancarRodada(boolean TrocarJogadorRodada) {
        // Se jogador da rodada for true, troca jogador
        if (TrocarJogadorRodada == true) {

            if (j[0].GetJogadorRodada() == true) {
                j[0].setJogadorRodada(false);
                j[1].setJogadorRodada(true);
                txtJogador.setText(j[1].getApelido());
            } else {
                j[0].setJogadorRodada(true);
                j[1].setJogadorRodada(false);
                txtJogador.setText(j[0].getApelido());
            }
        }
        //Vai avançar as rodadas dos jogo
        int rodada = Jogo.getRodada();
        rodada = rodada + 1;
        int rodada_p = rodada - 1;
        Jogo.setRodada(rodada);
        Jogo.setRod_perguntas(rodada_p);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRespostas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        txtNomeJ1 = new javax.swing.JLabel();
        txtNomeJ2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtJogador = new javax.swing.JLabel();
        txtPersonagem = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtEnun2 = new javax.swing.JLabel();
        txtEnun3 = new javax.swing.JLabel();
        txtEnun4 = new javax.swing.JLabel();
        btnResponder = new javax.swing.JButton();
        btnAvancar = new javax.swing.JButton();
        rdResposta1 = new javax.swing.JRadioButton();
        rdResposta2 = new javax.swing.JRadioButton();
        rdResposta3 = new javax.swing.JRadioButton();
        rdResposta4 = new javax.swing.JRadioButton();
        txtEnun1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPergunta = new javax.swing.JTextArea();
        progJ1 = new javax.swing.JProgressBar();
        jProgressBar1 = new javax.swing.JProgressBar();
        btnDesistir = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QuizTime");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtNomeJ1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtNomeJ1.setText("Jogador 1:");

        txtNomeJ2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtNomeJ2.setText("Jogador 2:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Vez de ");

        txtJogador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Pergunta:");

        txtEnun2.setText("jLabel5");

        txtEnun3.setText("jLabel6");

        txtEnun4.setText("jLabel7");

        btnResponder.setBackground(new java.awt.Color(0, 255, 102));
        btnResponder.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnResponder.setText("Responder");
        btnResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResponderActionPerformed(evt);
            }
        });

        btnAvancar.setBackground(new java.awt.Color(51, 153, 255));
        btnAvancar.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnAvancar.setText("Avançar");
        btnAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarActionPerformed(evt);
            }
        });

        btnRespostas.add(rdResposta1);

        btnRespostas.add(rdResposta2);

        btnRespostas.add(rdResposta3);

        btnRespostas.add(rdResposta4);

        txtEnun1.setText("jLabel5");

        txtPergunta.setEditable(false);
        txtPergunta.setColumns(20);
        txtPergunta.setLineWrap(true);
        txtPergunta.setRows(5);
        txtPergunta.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtPergunta);

        progJ1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        progJ1.setToolTipText("");
        progJ1.setStringPainted(true);

        jProgressBar1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jProgressBar1.setStringPainted(true);

        btnDesistir.setBackground(java.awt.Color.red);
        btnDesistir.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnDesistir.setText("Desistir");
        btnDesistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesistirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdResposta4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEnun4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rdResposta3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEnun3, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rdResposta1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEnun1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 73, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdResposta2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEnun2, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnResponder, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(btnAvancar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDesistir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(txtPersonagem)
                        .addGap(382, 382, 382)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomeJ2)
                            .addComponent(txtNomeJ1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(progJ1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPersonagem))
                        .addGap(91, 91, 91))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNomeJ1)
                                .addGap(9, 9, 9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(progJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomeJ2))
                        .addGap(57, 57, 57)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(rdResposta1)
                                .addGap(46, 46, 46))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtEnun1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(rdResposta2)
                                .addGap(71, 71, 71)
                                .addComponent(rdResposta3)
                                .addGap(52, 52, 52)
                                .addComponent(rdResposta4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtEnun2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(txtEnun3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEnun4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(btnResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnDesistir, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setName(""); // NOI18N

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btnAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarActionPerformed

        btnResponder.setEnabled(true);
        btnAvancar.setVisible(false);
        p[0] = Personagem.getInstance();//Buscando informações do jogador 1
        j[0] = Jogador.getInstance();
        p[1] = Personagem.getInstance2(); //Buscando informações do jogador 2
        j[1] = Jogador.getInstance2();
        int rodada = Jogo.getRod_perguntas();
        double vida_jogador = p[0].getVida();
        double vida_jogador2 = p[1].getVida();
        int vida1 = (int) vida_jogador;
        int vida2 = (int) vida_jogador2;
        progJ1.setValue(vida1);
        jProgressBar1.setValue(vida2);
        ListarQuestoes(rodada);
        btnResponder.setVisible(true);
    }//GEN-LAST:event_btnAvancarActionPerformed

    private void btnResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponderActionPerformed
        int confimar = JOptionPane.showConfirmDialog(null, "Você tem certeza da resposta ?", "Confirmar resposta", JOptionPane.INFORMATION_MESSAGE);
        if (confimar == JOptionPane.YES_OPTION) {
            btnResponder.setEnabled(false);
            btnAvancar.setVisible(true);
            p[0] = Personagem.getInstance();//Buscando informações do jogador 1
            j[0] = Jogador.getInstance();
            p[1] = Personagem.getInstance2(); //Buscando informações do jogador 2
            j[1] = Jogador.getInstance2();
            int rodada_p = Jogo.getRod_perguntas();
            int rodada = Jogo.getRodada();

            //Declarando PerguntaDAO, classe onde está nossas consultas no banco
            PerguntaDAO pe = new PerguntaDAO();
            //Array List, para preencher um mesmo objeto, com varios valores
            List<Perguntas> perguntas = new ArrayList<>();
            //Chamando nosso metodo de consulta de PerguntaDAO
            perguntas = pe.ListaPerguntas();

            String alternativa = "";

            String resposta = (perguntas.get(rodada_p).getSolucao());
            //Verifica qual alternativa o jogador selecionou
            if (rdResposta1.isSelected()) {
                alternativa = "A";
            } else if (rdResposta2.isSelected()) {
                alternativa = "B";
            } else if (rdResposta3.isSelected()) {
                alternativa = "C";
            } else {
                alternativa = "D";
            }

            //Validação da resposta e aplicação da recompensa ou punição
            if (alternativa.equals(resposta)) { // Acertou!
                JOptionPane.showMessageDialog(null, "Parabéns,você acertou!!", "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                if (j[0].GetJogadorRodada() == true) {
                    double recompensa = j[0].getRecompensa();
                    if (recompensa == 0) {
                        recompensa = 10;
                    }
                    recompensa = recompensa + (0.5 * rodada);
                    j[0].setRecompensa(recompensa);
                    AvancarRodada(false);
                } else {
                    double recompensa = j[1].getRecompensa();
                    if (recompensa == 0) {
                        recompensa = 10;
                    }
                    recompensa = recompensa + (0.5 * rodada);
                    j[1].setRecompensa(recompensa);
                    AvancarRodada(false);

                }
            } else {
                JOptionPane.showMessageDialog(null, "Você errou! \n A resposta certa é a :" + resposta, "Vishhh", JOptionPane.ERROR_MESSAGE);
                if (j[0].GetJogadorRodada() == true) { // Verifica se o jogador ativo é o jogador 1
                    double recompensa = j[0].getRecompensa();
                    double vida = p[0].getVida();
                    vida = vida - (0.5 * rodada);
                    AvancarRodada(true);// A porcentagem de vida perdida aumenta a cada rodada
                    p[0].setVida(vida); // Setando nova vida do personagem
                    if (vida <= 0) {
                        if (recompensa >= 0) {
                            int continuar = JOptionPane.showConfirmDialog(null, "Sua vida chegou ao fim, deseja trocar suas moedas em vida?Você possui: " + recompensa + ", A cada 50 moedas,você restaura 10 de vida.\n Deseja restaurar sua vida total ?");
                            if (continuar == JOptionPane.YES_OPTION) {
                                vida = j[0].ComprarVida(recompensa); // Chamando metodo criado na classe jogador
                                p[0].setVida(vida); // Setando nova vida do personagem
                                //Chamar proxíma pergunta
                                AvancarRodada(true);

                            } else {
                                TelaFinal tf = new TelaFinal();
                                tf.setVisible(true);
                                dispose();
                            }
                        } else {
                            TelaFinal tf = new TelaFinal();
                            tf.setVisible(true);
                            dispose();
                        }
                    }
                } else {

                    double vida = p[1].getVida();
                    double recompensa = j[1].getRecompensa();
                    vida = vida - (0.5 * rodada);  // A porcentagem de vida perdida aumenta a cada rodada
                    p[1].setVida(vida);
                    AvancarRodada(true);
                    if (vida <= 0) {
                        if (recompensa >= 0) {
                            int continuar = JOptionPane.showConfirmDialog(null, "Sua vida chegou ao fim, deseja trocar suas moedas em vida?Você possui: " + recompensa + ", A cada 50 moedas,você restaura 10 de vida.\n Deseja restaurar sua vida total ?");
                            if (continuar == JOptionPane.YES_OPTION) {
                                vida = j[1].ComprarVida(recompensa); // Chamando metodo criado na classe jogador
                                p[1].setVida(vida); // Setando nova vida do personagem
                                AvancarRodada(true);
                            } else {
                                TelaFinal tf = new TelaFinal();
                                tf.setVisible(true);
                                dispose();
                            }
                        }
                    } else {
                        TelaFinal tf = new TelaFinal();
                        tf.setVisible(true);
                        dispose();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnResponderActionPerformed

    private void btnDesistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesistirActionPerformed
        int desistir = JOptionPane.showConfirmDialog(null, "Você tem certeza que quer desistir ?", "Sair do jogo", JOptionPane.ERROR_MESSAGE);
        if (desistir == JOptionPane.YES_OPTION) {
            if (j[0].GetJogadorRodada() == true) {
                j[0].setVencedor(false);
                j[1].setVencedor(true);
            } else {
                j[0].setVencedor(true);
                j[1].setVencedor(false);
            }
            TelaFinal tf = new TelaFinal();
            tf.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnDesistirActionPerformed

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
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnDesistir;
    private javax.swing.JButton btnResponder;
    private javax.swing.ButtonGroup btnRespostas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JProgressBar progJ1;
    private javax.swing.JRadioButton rdResposta1;
    private javax.swing.JRadioButton rdResposta2;
    private javax.swing.JRadioButton rdResposta3;
    private javax.swing.JRadioButton rdResposta4;
    private javax.swing.JLabel txtEnun1;
    private javax.swing.JLabel txtEnun2;
    private javax.swing.JLabel txtEnun3;
    private javax.swing.JLabel txtEnun4;
    private javax.swing.JLabel txtJogador;
    private javax.swing.JLabel txtNomeJ1;
    private javax.swing.JLabel txtNomeJ2;
    private javax.swing.JTextArea txtPergunta;
    private javax.swing.JLabel txtPersonagem;
    // End of variables declaration//GEN-END:variables
}
