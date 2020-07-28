package ventanas;

import java.sql.*;
import clases.Conexión;
import com.itextpdf.text.BaseColor;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Vendedor extends javax.swing.JFrame {

    String usuario, NombreUsuario;
    int SesiónUsuario;

    public Vendedor() {
        initComponents();
        usuario = Login.usuario;
        SesiónUsuario = Administrador.SesiónUsuario;

        setTitle("Vendedor - Sesión de " + usuario);
        setSize(500, 450);
        setResizable(false);
        setLocationRelativeTo(null);

        if (SesiónUsuario == 1) {
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        } else {
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        ImageIcon ImagenFondo = new ImageIcon("src/images/fondo.jpg", "Imagen de fondo");
        Icon LogoFondo = new ImageIcon(ImagenFondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(),
                Image.SCALE_DEFAULT));
        lblFondo.setIcon(LogoFondo);
        this.repaint();

        try {
            Connection conexión = Conexión.Conexión_BD();
            PreparedStatement consulta = conexión.prepareStatement(
                    "select nombre_usuario from usuarios where username = ?");
            consulta.setString(1, usuario);
            ResultSet ResultadoConsulta = consulta.executeQuery();

            if (ResultadoConsulta.next() == true) {
                NombreUsuario = ResultadoConsulta.getString("nombre_usuario");
                lblNombreUsuario.setText("Bienvenido(a) " + NombreUsuario);
            }

            conexión.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR al consultar nombre del vendedor, contacte con el administrador.");
            System.err.println("ERROR, al consultar nombre del vendedor " + e);
        }
    }

    @Override
    public Image getIconImage() {
        Image Icono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icono.png"));
        return Icono;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreUsuario = new javax.swing.JLabel();
        btnRegistrarClientes = new javax.swing.JButton();
        btnGestionarClientes = new javax.swing.JButton();
        btnRegistrarProducto = new javax.swing.JButton();
        btnImprimirClientes = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblFooter = new javax.swing.JLabel();
        btnRegistrarVenta = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnGestionarProducto = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreUsuario.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lblNombreUsuario.setForeground(new java.awt.Color(0, 102, 255));
        lblNombreUsuario.setText("jLabel1");
        getContentPane().add(lblNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 450, 30));

        btnRegistrarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icono_cliente.png"))); // NOI18N
        btnRegistrarClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnRegistrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 100, 100));

        btnGestionarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icono_gestionarclientes.png"))); // NOI18N
        btnGestionarClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnGestionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 100, 100));

        btnRegistrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icono_producto.png"))); // NOI18N
        btnRegistrarProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnRegistrarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 100, 100));

        btnImprimirClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icono_pdf.png"))); // NOI18N
        btnImprimirClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnImprimirClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirClientesActionPerformed(evt);
            }
        });
        getContentPane().add(btnImprimirClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 100, 100));

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel3.setText("Gestionar Clientes");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel4.setText("Registrar Clientes");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 170, 100, 20));

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel5.setText("Imprimir Clientes");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(375, 320, -1, -1));

        jLabel6.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel6.setText("Registrar Venta");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        lblFooter.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        lblFooter.setText("Desarrollado por CódigoByte © - Gianmarco Contreras Pumamango");
        getContentPane().add(lblFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 350, 20));

        btnRegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icono_venta.png"))); // NOI18N
        btnRegistrarVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, 100, 100));

        jLabel7.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel7.setText("Registrar Productos");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel8.setText("Gestionar Productos");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, -1, -1));

        btnGestionarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icono_gestionarproductos.png"))); // NOI18N
        btnGestionarProducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnGestionarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarProductoActionPerformed(evt);
            }
        });
        getContentPane().add(btnGestionarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 100, 100));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarClientesActionPerformed
        RegistrarClientes cliente = new RegistrarClientes();
        cliente.setVisible(true);
    }//GEN-LAST:event_btnRegistrarClientesActionPerformed

    private void btnGestionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarClientesActionPerformed
        GestionarClientes cliente = new GestionarClientes();
        cliente.setVisible(true);
    }//GEN-LAST:event_btnGestionarClientesActionPerformed

    private void btnRegistrarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProductoActionPerformed
        RegistrarProductos producto = new RegistrarProductos();
        producto.setVisible(true);
    }//GEN-LAST:event_btnRegistrarProductoActionPerformed

    private void btnImprimirClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirClientesActionPerformed

        Document documento = new Document();

        try {

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ListaClientes.pdf"));

            String url = "src/images/BannerPDF.jpg";
            com.itextpdf.text.Image cabezera = com.itextpdf.text.Image.getInstance(url);
            cabezera.scaleToFit(650, 1000);
            cabezera.setAlignment(Chunk.ALIGN_CENTER);

            Paragraph párrafo = new Paragraph();
            párrafo.setAlignment(Paragraph.ALIGN_CENTER);
            párrafo.setFont(FontFactory.getFont("Cambria", 18, Font.BOLD, BaseColor.RED));
            párrafo.add("LISTA DE CLIENTES \n \n");

            documento.open();
            documento.add(cabezera);
            documento.add(párrafo);

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("ID CLIENTE");
            tabla.addCell("NOMBRE");
            tabla.addCell("CELULAR");
            tabla.addCell("DIRECCIÓN");
            tabla.addCell("DEUDA");

            try {

                Connection conexión = Conexión.Conexión_BD();
                PreparedStatement consulta = conexión.prepareStatement("select * from clientes");
                ResultSet ResultadoConsulta = consulta.executeQuery();

                if (ResultadoConsulta.next() == true) {

                    do {

                        tabla.addCell(ResultadoConsulta.getString(1));
                        tabla.addCell(ResultadoConsulta.getString(2));
                        tabla.addCell(ResultadoConsulta.getString(4));
                        tabla.addCell(ResultadoConsulta.getString(5));
                        tabla.addCell(ResultadoConsulta.getString(7));

                    } while (ResultadoConsulta.next() == true);

                    documento.add(tabla);
                }
                
                conexión.close();

            } catch (SQLException e) {
                System.err.println("ERROR al generar la lista de clientes. " + e);
                JOptionPane.showMessageDialog(null, "ERROR al generar la lista de clientes, "
                        + "contacte con el administrador");
            }

            documento.close();
            JOptionPane.showMessageDialog(null, "Archivo ListaClientes.pdf generado correctamente");

        } catch (DocumentException | HeadlessException | IOException e) {
            System.err.println("ERROR al generar el archivo ListaClientes.pdf o al cargar la imágen. " + e);
            JOptionPane.showMessageDialog(null, "ERROR al generar el archivo ListaClientes.pdf, "
                    + "contacte con el administrador");
        }
    }//GEN-LAST:event_btnImprimirClientesActionPerformed

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed
        RegistrarVentas venta = new RegistrarVentas();
        venta.setVisible(true);
    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    private void btnGestionarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarProductoActionPerformed
        GestionarProductos producto = new GestionarProductos();
        producto.setVisible(true);
    }//GEN-LAST:event_btnGestionarProductoActionPerformed

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
            java.util.logging.Logger.getLogger(Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGestionarClientes;
    private javax.swing.JButton btnGestionarProducto;
    private javax.swing.JButton btnImprimirClientes;
    private javax.swing.JButton btnRegistrarClientes;
    private javax.swing.JButton btnRegistrarProducto;
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
