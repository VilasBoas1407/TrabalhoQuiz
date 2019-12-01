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
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import model.Respostas;

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
            ListarQuestoes();
        } catch (Exception e) {
        }
        j[0] = Jogador.getInstance();
        j[1] = Jogador.getInstance2();
        p[0] = Personagem.getInstance();
        p[1] = Personagem.getInstance2();
        boolean JogadorRodada = j[0].GetJogadorRodada();  // Se falso, jogador 2 joga primeiro
        double vida_jogador = p[0].getVida();
        double vida_jogador2 = p[1].getVida();
        txtPontosJ1.setText(String.valueOf(vida_jogador));
        txtPontoJ2.setText(String.valueOf(vida_jogador2));
        if (JogadorRodada == true) {
            txtJogador.setText(j[0].getApelido());
        } else {
            txtJogador.setText(j[1].getApelido());
        }
        btnAvancar.setVisible(false);

    }

    public void ListarQuestoes() {
        j[0] = Jogador.getInstance();
        //Nosso contador de rodada, usamos para percorrer o vetor de perguntas
        int rodada = j[0].getRodada();
        rodada = rodada - 1;
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
        txtEnun2 = new javax.swing.JLabel();
        txtEnun3 = new javax.swing.JLabel();
        txtEnun4 = new javax.swing.JLabel();
        btnResponder = new javax.swing.JButton();
        btnAvancar = new javax.swing.JButton();
        rdResposta1 = new javax.swing.JRadioButton();
        rdResposta2 = new javax.swing.JRadioButton();
        rdResposta3 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        txtEnun1 = new javax.swing.JLabel();
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

        btnRespostas.add(rdResposta1);

        btnRespostas.add(rdResposta2);

        btnRespostas.add(rdResposta3);

        btnRespostas.add(jRadioButton1);

        txtEnun1.setText("jLabel5");

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
                        .addComponent(txtPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(861, 861, 861)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPontoJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jRadioButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtEnun4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(rdResposta3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtEnun3, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(rdResposta1)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(txtEnun1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdResposta2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEnun2, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnResponder, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(btnAvancar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(84, 84, 84)
                                        .addComponent(txtPersonagem))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(662, 662, 662)
                                        .addComponent(jLabel1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPontosJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 35, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPontosJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPersonagem))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPontoJ2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPergunta, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txtEnun1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(rdResposta1)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdResposta2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(rdResposta3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jRadioButton1)
                                        .addGap(92, 92, 92))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(txtEnun3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtEnun4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEnun2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205))))
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

    private void btnResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResponderActionPerformed
        int confimar = JOptionPane.showConfirmDialog(null, "Você tem certeza da resposta ?", "Confirmar resposta", JOptionPane.INFORMATION_MESSAGE);
        if (confimar == JOptionPane.YES_OPTION) {
            btnResponder.setEnabled(false);
            btnAvancar.setVisible(true);
            p[0] = Personagem.getInstance();//Buscando informações do jogador 1
            j[0] = Jogador.getInstance();
            p[1] = Personagem.getInstance2(); //Buscando informações do jogador 2
            j[1] = Jogador.getInstance2();
            int rodada = 0;
            // Gambiarra 
            if (rodada != 0) {
                if (j[0].GetJogadorRodada() == true) {
                    rodada = j[0].getRodada();
                } else {
                    rodada = j[1].getRodada();
                }
            }

            //Declarando PerguntaDAO, classe onde está nossas consultas no banco
            PerguntaDAO pe = new PerguntaDAO();
            //Array List, para preencher um mesmo objeto, com varios valores
            List<Perguntas> perguntas = new ArrayList<>();
            //Chamando nosso metodo de consulta de PerguntaDAO
            perguntas = pe.ListaPerguntas();

            String alternativa = "";

            String resposta = (perguntas.get(rodada).getSolucao());
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
            if (alternativa.equals(resposta)) {
                JOptionPane.showMessageDialog(null, "Parabéns,você acertou!!", "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                if (j[0].GetJogadorRodada() == true) {
                    double recompensa = j[0].getRecompensa();
                    if (recompensa == 0) {
                        recompensa = 10;
                    }
                    recompensa = recompensa + (0.5 * rodada);
                    j[0].setRecompensa(recompensa);
                    rodada += 1;
                    j[0].setRodada(rodada);
                    j[1].setRodada(rodada);
                } else {
                    double recompensa = j[1].getRecompensa();
                    if (recompensa == 0) {
                        recompensa = 10;
                    }
                    recompensa = recompensa + (0.5 * rodada);
                    j[1].setRecompensa(recompensa);
                    rodada += 1;
                    j[0].setRodada(rodada);
                    j[1].setRodada(rodada);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Você errou !", "Vishhh", JOptionPane.ERROR_MESSAGE);
                if (j[0].GetJogadorRodada() == true) { // Verifica se o jogador ativo é o jogador 1

                    double recompensa = j[0].getRecompensa();
                    double vida = p[0].getVida();
                    vida = vida - (0.5 * rodada); // A porcentagem de vida perdida aumenta a cada rodada
                    JLabel txtPontosJ1 = new JLabel();
                    txtPontosJ1.setText(String.valueOf(vida));
                    if (vida <= 0) {
                        int continuar = JOptionPane.showConfirmDialog(null, "Sua vida chegou ao fim, deseja trocar suas moedas em vida?Você possui: " + recompensa + ", A cada 50 moedas,você restaura 10 de vida.\n Deseja restaurar sua vida total ?");
                        if (continuar == JOptionPane.YES_OPTION) {
                            vida = j[0].ComprarVida(recompensa); // Chamando metodo criado na classe jogador
                            p[0].setVida(vida); // Setando nova vida do personagem
                            j[0].setJogadorRodada(false); // Setando Jogador 2 como proxímo a 
                            j[1].setJogadorRodada(true);
                            //Chamar proxíma pergunta

                        } else {
                            // Fim de GAME
                            //Redirecionar para tela de Resultados
                        }
                    }
                } else {

                    double vida = p[1].getVida();
                    double recompensa = j[1].getRecompensa();
                    vida = vida - (0.5 * rodada);  // A porcentagem de vida perdida aumenta a cada rodada
                    JLabel txtPontoJ2 = new JLabel();
                    txtPontoJ2.setText(String.valueOf(vida));;
                    if (vida <= 0) {
                        int continuar = JOptionPane.showConfirmDialog(null, "Sua vida chegou ao fim, deseja trocar suas moedas em vida?Você possui: " + recompensa + ", A cada 50 moedas,você restaura 10 de vida.\n Deseja restaurar sua vida total ?");
                        if (continuar == JOptionPane.YES_OPTION) {
                            vida = j[1].ComprarVida(recompensa); // Chamando metodo criado na classe jogador
                            p[1].setVida(vida); // Setando nova vida do personagem
                            j[1].setJogadorRodada(false); // Setando Jogador 1 como proxímo a jogar
                            j[0].setJogadorRodada(true);
                        } else {
                            //Fim de GAME
                            //Redirecionar para tela de Resultados
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnResponderActionPerformed

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
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnResponder;
    private javax.swing.ButtonGroup btnRespostas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton rdResposta1;
    private javax.swing.JRadioButton rdResposta2;
    private javax.swing.JRadioButton rdResposta3;
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
