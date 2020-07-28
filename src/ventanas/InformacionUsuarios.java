package ventanas;

import java.sql.*;
import clases.Conexión;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class InformacionUsuarios extends javax.swing.JFrame {

    String usuario, UsuarioConsultado;
    int ID;

    public InformacionUsuarios() {
        initComponents();
        usuario = Login.usuario;
        UsuarioConsultado = GestionarUsuarios.UsuarioConsultado;
        setSize(580, 490);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Información del usuario " + UsuarioConsultado + " - Sesión de " + usuario);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        lblTítulo.setText("Información del usuario " + UsuarioConsultado);

        ImageIcon ImagenFondo = new ImageIcon("src/images/fondo.jpg", "Imagen de fondo");
        Icon LogoFondo = new ImageIcon(ImagenFondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(),
                Image.SCALE_DEFAULT));
        lblFondo.setIcon(LogoFondo);
        this.repaint();

        try {
            Connection conexión = Conexión.Conexión_BD();
            PreparedStatement consulta = conexión.prepareStatement(
                    "select * from usuarios where username = ?");
            consulta.setString(1, UsuarioConsultado);
            ResultSet ResultadoConsulta = consulta.executeQuery();

            //Los valores que encontró el objeto ResultadoConsultado los establecemos en sus respectivos componentes
            if (ResultadoConsulta.next() == true) {
                ID = ResultadoConsulta.getInt(1); //Guardamos el ID para posteriormente actualizar el usuario
                txtNombre.setText(ResultadoConsulta.getString(2));
                txtEmail.setText(ResultadoConsulta.getString(3));
                txtCelular.setText(String.valueOf(ResultadoConsulta.getInt(4)));
                txtUsername.setText(ResultadoConsulta.getString(5));
                cmbPermisosDe.setSelectedItem(ResultadoConsulta.getString(7));
                cmbEstado.setSelectedItem((ResultadoConsulta.getString(8)));
                txtRegistradoPor.setText(ResultadoConsulta.getString(9));
            }
            conexión.close();
        } catch (SQLException e) {
            System.err.println("Error al cargar el usuario " + e);
            JOptionPane.showMessageDialog(null, "ERROR al cargar el usuario, contacte al administrador");
        }
    }

    @Override
    public Image getIconImage() {
        Image IconoSistema = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icono.png"));
        return IconoSistema;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTítulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblCelular = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        lblPermisosDe = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        lblRegistradoPor = new javax.swing.JLabel();
        txtRegistradoPor = new javax.swing.JTextField();
        cmbPermisosDe = new javax.swing.JComboBox<>();
        cmbEstado = new javax.swing.JComboBox<>();
        btnActualizarUsuario = new javax.swing.JButton();
        btnRestaurarPassword = new javax.swing.JButton();
        lblFooter = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTítulo.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        lblTítulo.setText("Información del usuario");
        getContentPane().add(lblTítulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lblNombre.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtNombre.setBackground(new java.awt.Color(102, 153, 255));
        txtNombre.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 180, -1));

        lblEmail.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblEmail.setText("Em@il:");
        getContentPane().add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txtEmail.setBackground(new java.awt.Color(102, 153, 255));
        txtEmail.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 180, -1));

        lblCelular.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblCelular.setText("Celular:");
        getContentPane().add(lblCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        txtCelular.setBackground(new java.awt.Color(102, 153, 255));
        txtCelular.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtCelular.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        getContentPane().add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 180, -1));

        lblPermisosDe.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblPermisosDe.setText("Permisos de:");
        getContentPane().add(lblPermisosDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        lblUsername.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblUsername.setText("Username:");
        getContentPane().add(lblUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, -1, -1));

        txtUsername.setEditable(false);
        txtUsername.setBackground(new java.awt.Color(102, 153, 255));
        txtUsername.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        getContentPane().add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 180, -1));

        lblEstado.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblEstado.setText("Estado:");
        getContentPane().add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, -1, -1));

        lblRegistradoPor.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblRegistradoPor.setText("Registrado por:");
        getContentPane().add(lblRegistradoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, -1, -1));

        txtRegistradoPor.setEditable(false);
        txtRegistradoPor.setBackground(new java.awt.Color(102, 153, 255));
        txtRegistradoPor.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtRegistradoPor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRegistradoPor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 51)));
        getContentPane().add(txtRegistradoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 180, -1));

        cmbPermisosDe.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        cmbPermisosDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Vendedor" }));
        getContentPane().add(cmbPermisosDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 160, -1));

        cmbEstado.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        getContentPane().add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 90, -1));

        btnActualizarUsuario.setBackground(new java.awt.Color(255, 153, 255));
        btnActualizarUsuario.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnActualizarUsuario.setText("Actualizar Usuario");
        btnActualizarUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnActualizarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, 150, 35));

        btnRestaurarPassword.setBackground(new java.awt.Color(255, 153, 255));
        btnRestaurarPassword.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnRestaurarPassword.setText("Restaurar Password");
        btnRestaurarPassword.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRestaurarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestaurarPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btnRestaurarPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 150, 35));

        lblFooter.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        lblFooter.setText("Desarrollado por CódigoByte © - Gianmarco Contreras Pumamango");
        getContentPane().add(lblFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, -1, -1));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarUsuarioActionPerformed
        String nombre, email, celular, username, permisos, estado;
        int validación = 0;

        nombre = txtNombre.getText().trim();
        email = txtEmail.getText().trim();
        celular = txtCelular.getText().trim();
        username = txtUsername.getText().trim();
        permisos = String.valueOf(cmbPermisosDe.getSelectedItem());
        estado = String.valueOf(cmbEstado.getSelectedItem());

        if (nombre.equals("")) {
            txtNombre.setBackground(Color.red);
            validación += 1;
        }
        if (email.equals("")) {
            txtEmail.setBackground(Color.red);
            validación += 1;
        }
        if (celular.equals("")) {
            txtCelular.setBackground(Color.red);
            validación += 1;
        }
        if (username.equals("")) {
            txtUsername.setBackground(Color.red);
            validación += 1;
        }

        if (validación > 0) {
            JOptionPane.showMessageDialog(null, "Por favor llene     todos los campos.");
        } else {
            try {
                Connection conexión = Conexión.Conexión_BD();
                PreparedStatement consulta = conexión.prepareStatement(
                        //Seleccionar campo username desde tabla usuarios dónde campo username sea igual a (?) y no campo id_usuario sea igual a (?)
                        "select username from usuarios where username = ? and not id_usuario = ?");
                consulta.setString(1, username);
                consulta.setInt(2, ID);
                ResultSet ResultadoConsulta = consulta.executeQuery();

                if (ResultadoConsulta.next() == true) {
                    JOptionPane.showMessageDialog(null, "Username no disponible, por favor ingrese otro Username");
                    txtUsername.setText("");
                    conexión.close();
                } else {
                    Connection conexión2 = Conexión.Conexión_BD();
                    PreparedStatement consulta2 = conexión2.prepareStatement(
                            /*Actualizar tabla usuarios establecer campos nombre_usuario = (?), email = (?), celular = (?), 
                            username = (?), tipo_nivel = (?), estatus = (?) dónde id_usuario sea igual a (?)*/
                            "update usuarios set nombre_usuario = ?, email = ?, celular = ?, username = ?, tipo_nivel = ?, estatus = ? "
                            + "where id_usuario = ?");

                    consulta2.setString(1, nombre);
                    consulta2.setString(2, email);
                    consulta2.setString(3, celular);
                    consulta2.setString(4, username);
                    consulta2.setString(5, permisos);
                    consulta2.setString(6, estado);
                    consulta2.setInt(7, ID);
                    consulta2.executeUpdate();
                    conexión2.close();

                    JOptionPane.showMessageDialog(null, "Actualización exitosa");
                }
            } catch (SQLException e) {
                System.err.println("Error al actualizar la información " + e);
                JOptionPane.showMessageDialog(null, "ERROR al actualizar la información, contacte al administrador");
            }
        }
    }//GEN-LAST:event_btnActualizarUsuarioActionPerformed

    private void btnRestaurarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestaurarPasswordActionPerformed
        RestaurarPassword RPass = new RestaurarPassword();
        RPass.setVisible(true);
    }//GEN-LAST:event_btnRestaurarPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(InformacionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InformacionUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InformacionUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarUsuario;
    private javax.swing.JButton btnRestaurarPassword;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbPermisosDe;
    private javax.swing.JLabel lblCelular;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPermisosDe;
    private javax.swing.JLabel lblRegistradoPor;
    private javax.swing.JLabel lblTítulo;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRegistradoPor;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}