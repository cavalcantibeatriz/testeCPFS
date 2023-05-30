package jar.bytebite;

import com.github.britooo.looca.api.core.Looca;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.dao.EmptyResultDataAccessException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author 55119
 */
public class Login extends javax.swing.JFrame {

    Conexao conexao = new Conexao();
//    ConexaoMySQL ConexaoMySQL = new ConexaoMySQL();
    JdbcTemplate con = conexao.getConnection();
//    JdbcTemplate conMySQL = ConexaoMySQL.getConnectionMySQL();
    Captura captura = new Captura();
    Componente comp = new Componente();
    LogGeral logGeral = new LogGeral();

    /**
     * Creates new form Login
     */
    private static Logger logger = Logger.getLogger(Login.class.getName());

    public static void logFormatacao() throws IOException {
        Looca looca = new Looca();
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dataFormatada = dateFormat.format(date);
        String sistemaOperacional = looca.getSistema().getSistemaOperacional();

        if (sistemaOperacional.equalsIgnoreCase("windows")) {
            Path path = Paths.get("C:/Logs-ByteBite/Login/");
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            FileHandler fileHandler = new FileHandler(String.format("C:/Logs-ByteBite/Login/%s.txt", dataFormatada));
            fileHandler.setFormatter(new Formatter() {
                private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd >> HH:mm:ss");

                public String format(LogRecord record) {

                    StringBuilder builder = new StringBuilder();
                    builder.append(dateFormat.format(new Date())).append(" ");
                    builder.append(record.getLevel()).append(": ");
                    builder.append(record.getMessage()).append(" (");
                    builder.append(record.getSourceClassName()).append(".");
                    builder.append(record.getSourceMethodName()).append(")");
                    builder.append(System.lineSeparator());
                    return builder.toString();
                }
            }
            );
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        }

        if (sistemaOperacional.equalsIgnoreCase("Ubuntu")) {
            Path path = Paths.get("/home/ubuntu/Desktop/LogsByteBite/Login/");
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            FileHandler fileHandler = new FileHandler(String.format("/home/ubuntu/Desktop/LogsByteBite/Login/%s.txt", dataFormatada));
            fileHandler.setFormatter(new Formatter() {
                private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd >> HH:mm:ss");

                public String format(LogRecord record) {

                    StringBuilder builder = new StringBuilder();
                    builder.append(dateFormat.format(new Date())).append(" ");
                    builder.append(record.getLevel()).append(": ");
                    builder.append(record.getMessage()).append(" (");
                    builder.append(record.getSourceClassName()).append(".");
                    builder.append(record.getSourceMethodName()).append(")");
                    builder.append(System.lineSeparator());
                    return builder.toString();
                }
            }
            );
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
        }

    }

    public Login() {
        initComponents();
        getContentPane().setBackground(Color.gray);
    }

    public Boolean selectLogin(String id, String senha) throws IOException {
        try {
            Map<String, Object> registro = con.queryForMap(
                    "select * from maquina where idMaquina = ? and senha = ?", id, senha);
            System.out.println("Login realizado com sucesso.");
            logGeral.genereteLoginSucesso();
            logGeral.genereteInfos();
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    public void nextScreen() {
        PosLogin tela = new PosLogin();
        this.setVisible(false);
        tela.setVisible(true);
        tela.especificacoes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        lblErro = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();

        jLabel4.setBackground(new java.awt.Color(51, 0, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/LogoRed.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setText("Email: ");

        jLabel3.setText("Senha: ");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lblErro.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblErro.setForeground(new java.awt.Color(255, 0, 51));

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(54, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErro, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(lblErro)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String id = jTextField1.getText();
        String senha = jPasswordField1.getText();
        try {
            //        String senha = jTextField2.getText();
            if (selectLogin(id, senha)) {
                nextScreen();
                captura.mostrarInfoSistema();
                comp.inserirComponente();
                if (comp.consultarConfig(id) < 3) {
                    comp.inserirConfiguracao(id);
                }
                new Timer().scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        Date dataHoraAtual = new Date();
                        String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
                        String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
                        captura.inserirNoBanco(id, senha, data, hora);
                        captura.inserirNoBancoMySQL(id, senha, data, hora);
                    }
                }, 0, 10000);

            } else {
                lblErro.setText("Credenciais incorretas.");
                logGeral.genereteErroLogin();

            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {

        logFormatacao();
        Captura.logFormatacao();
        Componente.logFormatacao();
        Alerta.logFormatacao();


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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblErro;
    // End of variables declaration//GEN-END:variables
}
