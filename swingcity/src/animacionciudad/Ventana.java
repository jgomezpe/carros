/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionciudad;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JFrame;

/**
 * Clase que crea la ventana donde se colocará el lienzo 
 * para dibujar la ciudad y los componentes de control
 * @author Camiku
 */
public class Ventana extends JFrame {

    /**
     * 
     */
    private static final long serialVersionUID = 2156260375695009897L;

    /**
     * Crea una instacia de la clase Ventana e 
     * inicia la creación de las componentes de control
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
    }

    /**
     * Inicia la creación de las componentes de la ventana de la aplicación
     */
    private void initComponents() {
        // Al cerrar la ventana se finaliza la ejecución del programa
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // Establece el titulo de la ventana
        setTitle("Animación de nuestra Ciudad MinTic-2022 - Final");
        
        // Establece el aspecto de la distribución utilizada
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Crea un panel que sirve de lienzo para el dibujo de la ciudad
        PanelCiudad panelCiudad = new PanelCiudad();
        // Sirve de panel principal de la ventana
        setContentPane(panelCiudad);
        // Adiciona el panel de controles al panel principal
        add(new PanelControles(panelCiudad));
        
        // Adjusta el tamaño de la ventana para que quepan todos los componentes
        pack();
        //setSize(800, 600);
        
        // Permite ubicar la ventana en el centro de la pantalla
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation((screenSize.width - frameSize.width) / 2, 
                (screenSize.height - frameSize.height) / 2);
        
        // Hace que la ventana de la aplicación sea visible
        setVisible(true);
    }

}
