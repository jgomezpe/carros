/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionciudad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Auditor de los eventos generados por el ratón
 *
 * @author Camiku
 */
public class EventoClic implements ActionListener {

    private PanelControles panelControles;
    private Hilo hilo;

    /**
     * Crea un auditor que tramita los eventos generados por la presión del
     * boton del ratón e inicializa la aplicación de forma independiente
     *
     * @param panelControles
     */
    public EventoClic(PanelControles panelControles) {
        this.panelControles = panelControles;
    }

    /**
     * Sobreescribe el método invocado cuando se presiona un boton que es
     * auditado por este objeto
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == panelControles.getjButtonIniciar()) {
            // Crea una nuevo hilo
            hilo = new Hilo(this.panelControles);
            // Desactiva el boton de ejecución
            panelControles.getjButtonIniciar().setEnabled(false);
            // Inicializa la ejecución del hilo
            hilo.start();
        }
    }

}
