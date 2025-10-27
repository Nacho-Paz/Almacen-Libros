/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ModificarController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.DateTimeException;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ignac
 */
public class VistaModificar extends javax.swing.JFrame {

    private static JMenuItem mnIVolver;

    public VistaModificar() {
        initComponents();
        personalizarComponentes();
    }

    private void personalizarComponentes() {
        this.setSize(500, 400); // Establece el tamaño de la ventana
        this.setDefaultCloseOperation(VistaModificar.EXIT_ON_CLOSE);
        this.setTitle("Modificación de Libro");
        this.setLocationRelativeTo(null);
        menuBarConfig();
        validaciones();
        agregarPlaceholder(txtDia, "Dia");
        agregarPlaceholder(txtMes, "Mes");
        agregarPlaceholder(txtAnio, "Año");
    }

    private void menuBarConfig() {
        mnIVolver = new JMenuItem("Volver");

        //AGREGO EVENTOS
        mnIVolver.addActionListener((ActionEvent e) -> {
            ModificarController.btnVolver();
        });

        //CONFIGURO LA MENUBAR
        menuBar.setPreferredSize(new Dimension(this.getWidth(), 35));
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
        menuBar.setBackground(Color.decode("#3CA79C"));
        menuBar.setBorderPainted(false);

        //CONFIGURO LOS JMENUITEMS
        mnIVolver.setBackground(Color.decode("#3CA79C"));
        mnIVolver.setPreferredSize(new Dimension(48, 35));
        mnIVolver.setForeground(Color.WHITE);

        menuBar.add(mnIVolver);
        animationJMI();
    }

    private void animationJMI() {
        // Efecto al pasar el mouse sobre los JMenuItems (cambio de color)
        mnIVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mnIVolver.setBackground(Color.decode("#078275")); // Color al pasar el mouse
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mnIVolver.setBackground(Color.decode("#3CA79C")); // Color por defecto
            }

            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnIVolver.setBackground(Color.decode("#2b544f")); // Color al click
            }
        });
    }

    private void agregarPlaceholder(JTextField campo, String txt) {
        campo.setText(txt);
        campo.setForeground(Color.GRAY);

        campo.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (campo.getText().equals(txt)) {
                    campo.setText("");
                    campo.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (campo.getText().isEmpty()) {
                    campo.setText(txt);
                    campo.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void validaciones() {
        //Validacion de Nombre que permite letras y numeros
        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();

                // Permitir teclas de control: SHIFT, BLOQ MAYÚS, BACKSPACE y DELETE
                if (e.getKeyCode() == KeyEvent.VK_SHIFT || e.getKeyCode() == KeyEvent.VK_CAPS_LOCK
                        || e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    return;
                }

                if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                    e.consume();
                    msgAdvertencia("Este campo solo permite letras y números.");
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (txtNombre.getText().length() >= 49) {
                    e.consume(); // Bloquear entrada si se supera la longitud máxima
                    msgAdvertencia("Este campo solo permite hasta " + 50 + " caracteres.");
                }
            }

        });

        //Validacion de Autor que permite letras unicamente
        txtAutor.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();

                if (e.getKeyCode() == KeyEvent.VK_SHIFT || e.getKeyCode() == KeyEvent.VK_CAPS_LOCK
                        || e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    return;
                }

                if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    e.consume();
                    msgAdvertencia("Este campo solo permite letras.");
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (txtAutor.getText().length() >= 49) {
                    e.consume(); // Bloquear entrada si se supera la longitud máxima
                    msgAdvertencia("Este campo solo permite hasta " + 50 + " caracteres.");
                }
            }
        });

        //Validacion de Editorial que permite letras unicamente
        txtEditorial.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();

                if (e.getKeyCode() == KeyEvent.VK_SHIFT || e.getKeyCode() == KeyEvent.VK_CAPS_LOCK
                        || e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    return;
                }

                if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                    e.consume();
                    msgAdvertencia("Este campo solo permite letras.");
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (txtEditorial.getText().length() >= 49) {
                    e.consume(); // Bloquear entrada si se supera la longitud máxima
                    msgAdvertencia("Este campo solo permite hasta " + 50 + " caracteres.");
                }
            }
        });

        //Validacion de ISBN que permite números y espacios
        txtISBN.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();

                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    return;
                }

                if (!Character.isDigit(c) && e.getKeyCode() != KeyEvent.VK_SPACE) {
                    e.consume();
                    msgAdvertencia("Este campo solo permite letras.");
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (txtISBN.getText().length() >= 25) {
                    e.consume(); // Bloquear entrada si se supera la longitud máxima
                    msgAdvertencia("Este campo solo permite hasta " + 25 + " caracteres.");
                }
            }
        });

        //Validacion de Dia que permite números unicamente
        txtDia.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();

                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    return;
                }

                if (!Character.isDigit(c)) {
                    e.consume();
                    msgAdvertencia("Este campo solo permite letras.");
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (txtDia.getText().length() >= 2) {
                    e.consume(); // Bloquear entrada si se supera la longitud máxima
                    msgAdvertencia("Este campo solo permite hasta " + 2 + " caracteres.");
                }
            }
        });

        //Validacion de Mes que permite números unicamente
        txtMes.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();

                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    return;
                }

                if (!Character.isDigit(c)) {
                    e.consume();
                    msgAdvertencia("Este campo solo permite letras.");
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (txtMes.getText().length() >= 2) {
                    e.consume(); // Bloquear entrada si se supera la longitud máxima
                    msgAdvertencia("Este campo solo permite hasta " + 2 + " caracteres.");
                }
            }
        });

        //Validacion de Anio que permite números unicamente
        txtAnio.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char c = e.getKeyChar();

                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE || e.getKeyCode() == KeyEvent.VK_DELETE) {
                    return;
                }

                if (!Character.isDigit(c)) {
                    e.consume();
                    msgAdvertencia("Este campo solo permite letras.");
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
                if (txtAnio.getText().length() >= 4) {
                    e.consume(); // Bloquear entrada si se supera la longitud máxima
                    msgAdvertencia("Este campo solo permite hasta " + 4 + " caracteres.");
                }
            }
        });
    }

    private void msgAdvertencia(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Ingreso incorrecto", JOptionPane.WARNING_MESSAGE);
    }

    private int validacionVacio() {
        //inputNombre validar
        String data = txtNombre.getText().trim(); //El.trim elemina espacios al final e inicio
        int validador = 0;
        if (data.isEmpty()) {
            //Ventana emergente
            JOptionPane.showMessageDialog(this, "El campo 'Nombre' no puede estar vacio", "Error de Validacion", JOptionPane.WARNING_MESSAGE);
        } else {
            //txtAutor validar
            data = txtAutor.getText().trim();
            if (data.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El campo 'Autor' no puede estar vacio", "Error de Validacion", JOptionPane.WARNING_MESSAGE);
            } else {
                //txtEditorial validar
                data = txtEditorial.getText().trim();
                if (data.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "El campo 'Editorial' no puede estar vacio", "Error de Validacion", JOptionPane.WARNING_MESSAGE);
                } else {
                    //txtISBN validar
                    data = txtISBN.getText().trim();
                    if (data.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "El campo 'ISBN' no puede estar vacio", "Error de Validacion", JOptionPane.WARNING_MESSAGE);
                    } else {
                        //txtDia validar
                        data = txtDia.getText().trim();
                        if (data.isEmpty()) {
                            JOptionPane.showMessageDialog(this, "El campo 'Dia' no puede estar vacio", "Error de Validacion", JOptionPane.WARNING_MESSAGE);
                        } else {
                            //txtMes validar
                            data = txtMes.getText().trim();
                            if (data.isEmpty()) {
                                JOptionPane.showMessageDialog(this, "El campo 'Mes' no puede estar vacio", "Error de Validacion", JOptionPane.WARNING_MESSAGE);
                            } else {
                                //txtAnio validar
                                data = txtAnio.getText().trim();
                                if (data.isEmpty()) {
                                    JOptionPane.showMessageDialog(this, "El campo 'Año' no puede estar vacio", "Error de Validacion", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    validador = 1;
                                }
                            }
                        }
                    }
                }

            }

        }
        return validador;
    }

    private boolean validarFecha() {
        try {
            String dias = txtDia.getText();
            String mess = txtMes.getText();
            String anios = txtAnio.getText();

            //Ocurre que la validación ejecuta el placeholder, con este codigo evito que los tenga en cuenta
            if (dias.equalsIgnoreCase("Dia") || dias.isEmpty()
                    || mess.equalsIgnoreCase("Mes") || mess.isEmpty()
                    || anios.equalsIgnoreCase("Año") || anios.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Debes ingresar una fecha válida.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }

            int dia = Integer.parseInt(dias);
            int mes = Integer.parseInt(mess);
            int anio = Integer.parseInt(anios);

            // Validar rango de mes (1-12) y día
            if (mes < 1 || mes > 12) {
                msgAdvertencia("Mes inválido. Debe estar entre 1 y 12");
                return false;
            }
            if (dia < 1 || dia > 31) {
                msgAdvertencia("Día inválido. Debe estar entre 1 y 31");
                return false;
            }

            // Crear un objeto LocalDate para validar la fecha
            LocalDate fecha = LocalDate.of(anio, mes, dia);
            LocalDate fechaActual = LocalDate.now();

            // Verificar si la fecha ingresada es futura
            if (fecha.isAfter(fechaActual)) {
                msgAdvertencia("No puedes ingresar una fecha futura.");
                return false;
            }

            return true; // Fecha válida

        } catch (DateTimeException e) {
            msgAdvertencia("Fecha inválida. Verifique el día, mes y año.");
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtAutor = new javax.swing.JTextField();
        txtEditorial = new javax.swing.JTextField();
        txtISBN = new javax.swing.JTextField();
        comboxGenero = new javax.swing.JComboBox<>();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        jLabel1.setText("Edición de Libro");

        jLabel2.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel3.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        jLabel3.setText("Autor:");

        jLabel4.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        jLabel4.setText("Editorial:");

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        jLabel5.setText("ISBN:");

        jLabel6.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        jLabel6.setText("Género:");

        jLabel7.setFont(new java.awt.Font("Leelawadee UI", 0, 12)); // NOI18N
        jLabel7.setText("Fecha de Publicación:");

        comboxGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romantico", "Terror", "Ciencia Ficcion", "Realista", "Ciencias", "Biografia", "Politica", "Tecnologia" }));

        txtDia.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtMes.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtAnio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnModificar.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(txtAutor)
                                    .addComponent(txtEditorial)
                                    .addComponent(txtISBN)
                                    .addComponent(comboxGenero, 0, 325, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(27, 27, 27)
                                .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
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

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (validacionVacio() != 1) {
            JOptionPane.showMessageDialog(this, "No puede dejar espacios en vacío", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!validarFecha()) {
            JOptionPane.showMessageDialog(this, "La fecha ingresada no es válida", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "¡Datos modificados correctamente!", "Exito", JOptionPane.INFORMATION_MESSAGE);
            ModificarController.ocultar();
            ModificarController.modificarLibro();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    public JComboBox<String> getComboxGenero() {
        return comboxGenero;
    }

    public void setComboxGenero(JComboBox<String> comboxGenero) {
        this.comboxGenero = comboxGenero;
    }

    public JTextField getTxtAnio() {
        return txtAnio;
    }

    public void setTxtAnio(JTextField txtAnio) {
        this.txtAnio = txtAnio;
    }

    public JTextField getTxtAutor() {
        return txtAutor;
    }

    public void setTxtAutor(JTextField txtAutor) {
        this.txtAutor = txtAutor;
    }

    public JTextField getTxtDia() {
        return txtDia;
    }

    public void setTxtDia(JTextField txtDia) {
        this.txtDia = txtDia;
    }

    public JTextField getTxtEditorial() {
        return txtEditorial;
    }

    public void setTxtEditorial(JTextField txtEditorial) {
        this.txtEditorial = txtEditorial;
    }

    public JTextField getTxtISBN() {
        return txtISBN;
    }

    public void setTxtISBN(JTextField txtISBN) {
        this.txtISBN = txtISBN;
    }

    public JTextField getTxtMes() {
        return txtMes;
    }

    public void setTxtMes(JTextField txtMes) {
        this.txtMes = txtMes;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> comboxGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
