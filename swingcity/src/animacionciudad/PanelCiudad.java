/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionciudad;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import ciudad.ParametrosDibujo;
import javax.swing.JScrollPane;

/**
 * Panel utilizado para dibujar la ciudad
 * @author Camiku
 */
public class PanelCiudad extends JPanel {
    
    /**
     * 
     */
    private static final long serialVersionUID = 5124107106423985003L;

    // Define un área de texto
    protected JTextArea jTextArea = null;
    
    // Define un panel de desplazamiento
    protected JScrollPane jScrollPane = null;

    /**
     * Crea un panel que servirá de lienzo para dibujar la ciudad
     */
    public PanelCiudad() {
        initComponents();
    }

    /**
     * Inicia la creación de las componentes del lienzo
     */
    private void initComponents() {
        // Crea un área de texto y establece al alto y ancho
        jTextArea = new JTextArea(ParametrosDibujo.ALTO, ParametrosDibujo.ANCHO);

        // Crea una instancia de la clase Font
        Font font = new Font("Monospaced", Font.BOLD, 10);

        // Establece la fuente que se va a utilizar en el área de texto
        jTextArea.setFont(font);

        // Crea un panel de desplazamiento, en el cual las barras 
        // de dezplazmiento apareceran si son necesarias
        jScrollPane = new JScrollPane(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        // Adiciona el área de texto a la ventana 
        // gráfica del panel de dezplazamiento
        jScrollPane.getViewport().add(jTextArea);

        // Adiciona el panel de dezplazamiento al panel que 
        // sirve de lienzo de dibujo de la ciudad
        add(jScrollPane);
    }

    /**
     * Retorna el área de texto
     * @return jTextArea
     */
    public JTextArea getjTextArea() {
        return jTextArea;
    }

    /**
     * Establece una nueva área de texto 
     * @param jTextArea
     */
    public void setjTextArea(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

}
