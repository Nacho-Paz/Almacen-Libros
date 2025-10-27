/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.PrincipalController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

/**
 *
 * @author ignac
 */
public class VistaPrincipal extends javax.swing.JFrame {

    private JMenuItem mnIAgregar;
    private JMenuItem mnIListar;

    public VistaPrincipal() {
        initComponents();
        personalizarComponentes();
    }

    private void personalizarComponentes() {
        this.setSize(500, 400); // Establece el tamaño de la ventana
        this.setDefaultCloseOperation(VistaPrincipal.EXIT_ON_CLOSE);
        this.setTitle("Almacén de Biblioteca");
        this.setLocationRelativeTo(null);
        menuBarConfig();

    }

    //Instancio la configuración de la menubar desde el codigo ya que es mejor.
    //y utilizo JMenuItem que es lo mejor.
    private void menuBarConfig() {
        mnIAgregar = new JMenuItem("Agregar Libro");
        mnIListar = new JMenuItem("Listar Libros");

        //DE ESTA MANERA SE CENTRA
//        mnIAgregar = new CenteredMenuItem("Agregar Libro");
//        mnIListar = new CenteredMenuItem("Listar Libros");
        //AGREGO EVENTOS
        mnIAgregar.addActionListener((ActionEvent e) -> {
            PrincipalController.btnAgregar();
        });

        mnIListar.addActionListener((ActionEvent e) -> {
            PrincipalController.btnListar();
        });

        //CONFIGURO LA MENUBAR
        menuBar.setPreferredSize(new Dimension(this.getWidth(), 35));
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        menuBar.setBackground(Color.decode("#3CA79C"));
        menuBar.setBorderPainted(false);

        //CONFIGURO LOS JMENUITEMS
        mnIAgregar.setBackground(Color.decode("#3CA79C"));
        mnIAgregar.setPreferredSize(new Dimension(90, 35));
        mnIAgregar.setForeground(Color.WHITE);

        mnIListar.setBackground(Color.decode("#3CA79C"));
        mnIListar.setPreferredSize(new Dimension(85, 35));
        mnIListar.setForeground(Color.WHITE);

        menuBar.add(mnIAgregar);
        menuBar.add(mnIListar);

        animationJMI();

    }

    private void animationJMI() {
        // Efecto al pasar el mouse sobre los JMenuItems (cambio de color)
        mnIAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mnIAgregar.setBackground(Color.decode("#078275")); // Color al pasar el mouse
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mnIAgregar.setBackground(Color.decode("#3CA79C")); // Color por defecto
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnIAgregar.setBackground(Color.decode("#2b544f")); // Color al click
            }
        });

        mnIListar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mnIListar.setBackground(Color.decode("#078275")); // Color al pasar el mouse
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mnIListar.setBackground(Color.decode("#3CA79C")); // Color por defecto
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnIListar.setBackground(Color.decode("#2b544f")); // Color al click
            }
        });
    }

    /*// Clase personalizada de JMenuItem para centrar el texto (DE ESTA MANERA SI SE CENTRA)
    static class CenteredMenuItem extends JMenuItem {

        public CenteredMenuItem(String text) {
            super();
            // Crear un JLabel con el texto
            JLabel label = new JLabel(text, SwingConstants.CENTER);
            label.setForeground(Color.WHITE);
            label.setOpaque(false); // Para que el fondo sea invisible
//            label.setBackground(getBackground()); // Usar el mismo color de fondo que el JMenuItem
            setLayout(new BorderLayout());
            add(label, BorderLayout.CENTER); // Agregar el JLabel al JMenuItem
        }
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 3, 28)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Programa: Almacén de Biblioteca.");

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Comprende el CRUD: ");

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Crear libros, listarlos, modificarlos ");

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("y eliminarlos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables
}
