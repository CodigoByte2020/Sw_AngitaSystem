package ventanas;

import java.sql.*;
import clases.Conexión;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class GestionarProductos extends javax.swing.JFrame {

    String usuario;
    public static int ID_Producto;
    DefaultTableModel modelo = new DefaultTableModel();

    public GestionarProductos() {
        initComponents();
        usuario = Login.usuario;
        setTitle("Gestionar productos - Sesión de " + usuario);
        setSize(750, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        try {
            Connection conexión = Conexión.Conexión_BD();
            PreparedStatement consulta = conexión.prepareStatement(
                    "select id_producto, nombre_producto, marca, precio, stock, observaciones from productos");
            ResultSet ResultaConsulta = consulta.executeQuery();

            tbProductos = new JTable(modelo);
            spProductos.setViewportView(tbProductos);

            modelo.addColumn("ID");
            modelo.addColumn("NOMBRE");
            modelo.addColumn("MARCA");
            modelo.addColumn("PRECIO");
            modelo.addColumn("STOCK");
            modelo.addColumn("OBSERVACIONES");

            while (ResultaConsulta.next() == true) {

                Object fila[] = new Object[6];

                for (int i = 0; i < 6; i++) {
                    fila[i] = ResultaConsulta.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            conexión.close();

        } catch (SQLException e) {
            System.err.println("ERROR al cargar productos. " + e);
            JOptionPane.showMessageDialog(null, "ERROR al cargar productos, contacte con el administrador");
        }

        //Guardamos la fila de la tabla donde hizo click el usuario
        tbProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int PuntoColumna = 0;
                int PuntoFila = tbProductos.rowAtPoint(e.getPoint());

                if (PuntoFila >= 0) {
                    ID_Producto = (int) tbProductos.getValueAt(PuntoFila, PuntoColumna);
                    InformaciónProductos producto = new InformaciónProductos();
                    producto.setVisible(true);
                }
            }
        });

        ImageIcon ImagenFondo = new ImageIcon("src/images/fondo.jpg");
        Icon IconoFondo = new ImageIcon(ImagenFondo.getImage().getScaledInstance(lblFondo.getWidth(), lblFondo.getHeight(),
                Image.SCALE_DEFAULT));
        lblFondo.setIcon(IconoFondo);
        this.repaint();
    }

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/icono.png"));
        return retValue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spProductos = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        lblTítulo = new javax.swing.JLabel();
        lblFooter = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        spProductos.setViewportView(tbProductos);

        getContentPane().add(spProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 710, 260));

        lblTítulo.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        lblTítulo.setText("Lista de productos");
        getContentPane().add(lblTítulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        lblFooter.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        lblFooter.setText("Desarrollado por CódigoByte © - Gianmarco Contreras Pumamango");
        getContentPane().add(lblFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 360, 20));
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(GestionarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarProductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFooter;
    private javax.swing.JLabel lblTítulo;
    private javax.swing.JScrollPane spProductos;
    private javax.swing.JTable tbProductos;
    // End of variables declaration//GEN-END:variables
}
