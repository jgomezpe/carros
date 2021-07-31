/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionciudad;

import ciudad.ParametrosDibujo;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Panel utilizado para ubicar los controles de dibujo
 * @author Camiku
 */
public class PanelControles extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 3116611926032812478L;
    // Área de texto para dibujar la ciudad
    private JTextArea jTextArea;
    // Etiqueta del campo de texto de la carga
    private JLabel jLabelCarga;
    // Etiqueta de la lista de cadenas del control del tiempo
    private JLabel jLabelDormir;
    // Campo de texto del valor de la carga de los furgones
    private JTextField jTextFieldCarga;
    // Boton usado para iniciar la animación
    private JButton jButtonIniciar;
    // Lista de números del control del tiempo
    private JSpinner jSpinnerDormir;
    // Boton de chequeo para establecer si aparecen los carros de carga
    private JCheckBox jCheckBoxVehiculosCarga;
    // Componente que agrupa un conjunto de botones de opción para 
    // que actuen sincronizados (i.e. que sólo uno pueda ser seleccionado) 
    private ButtonGroup buttonGroupDireccion;
    // Botón de la opción de la dirección hacia adelante
    private JRadioButton jRadioButtonAdelante;

    /**
     * Crea un panel que servirá para ubicar los controles de dibujo
     * @param panelCiudad
     */
    public PanelControles(PanelCiudad panelCiudad) {
        this.jTextArea = panelCiudad.getjTextArea();
        initComponents();
    }

    /**
     * Inicia la creación de las componentes de control de dibujo
     */
    private void initComponents() {
        // Establece el gestor de organización en forma de retícula de tamaño 10x1
        setLayout(new GridLayout(16,1));
        
        jButtonIniciar = new JButton("Iniciar animación");
        // Adiciona el botón a éste panel
        add(jButtonIniciar);

        jLabelCarga = new JLabel("Carga del Furgon: ");
        add(jLabelCarga);

        jTextFieldCarga = new JTextField(ParametrosDibujo.CONTENIDO_CARGA);
        add(jTextFieldCarga);

        jLabelDormir = new JLabel("Lapso de dormir: ");
        add(jLabelDormir);

        jSpinnerDormir = new JSpinner();
        // Establece el valor por defecto de la lista de números
        jSpinnerDormir.setValue(ParametrosDibujo.PAUSA_MILISEGUNDOS);
        add(jSpinnerDormir);

        
        jCheckBoxVehiculosCarga = new JCheckBox("Carga");
        // El boton de chequeo aparecerá seleccionado
        jCheckBoxVehiculosCarga.setSelected(true);
        add(jCheckBoxVehiculosCarga);
        
        jRadioButtonAdelante = new JRadioButton("Adelante");
        // El boton de opción aparecerá seleccionado
        jRadioButtonAdelante.setSelected(true);
        add(jRadioButtonAdelante);
        
        buttonGroupDireccion = new ButtonGroup();
        // Adiciona el boton de opción a un grupo de botones
        buttonGroupDireccion.add(jRadioButtonAdelante);

        // Crea un auditor que tramitará los eventos generados por el boton
        EventoClic eventoClic = new EventoClic(this);

        // Establece como auditor al objeto eventoClic cuando se presiona el boton
        jButtonIniciar.addActionListener(eventoClic);
        
        /* Crea un auditor que tramitará los eventos generados por la 
        lista de números del control del tiempo**/
        EventoCambioLista eventoCambioLista = new EventoCambioLista(jSpinnerDormir);
        
        // Establece como auditor al objeto eventoCambioLista cuando se 
        // gira la rueda del ratón
        jSpinnerDormir.addMouseWheelListener(eventoCambioLista);
        // Establece como auditor al objeto eventoCambioLista cuando se 
        // modifica la lista de números
        jSpinnerDormir.addChangeListener(eventoCambioLista);

    }

    public JTextArea getjTextArea() {
        return jTextArea;
    }

    public JTextField getjTextFieldCarga() {
        return jTextFieldCarga;
    }

    public JButton getjButtonIniciar() {
        return jButtonIniciar;
    }

    public JSpinner getjSpinnerDormir() {
        return jSpinnerDormir;
    }

    public JCheckBox getjCheckBoxVehiculosCarga() {
        return jCheckBoxVehiculosCarga;
    }

    public JRadioButton getjRadioButtonAdelante() {
        return jRadioButtonAdelante;
    }

}
