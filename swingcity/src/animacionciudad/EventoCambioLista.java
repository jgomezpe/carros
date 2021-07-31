/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animacionciudad;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Crea un auditor que tramita los eventos generados 
 * por la modificación de la lista de números
 * @author Camiku
 */
public class EventoCambioLista implements ChangeListener, MouseWheelListener {

    private JSpinner jSpinnerDormir;
    private int value;
    private int wheel;

    public EventoCambioLista(JSpinner jSpinner) {
        this.jSpinnerDormir = jSpinner;
    }

    /**
     * Tramita el evento cuando cambia el valor de la lista
     * @param ce
     */
    @Override
    public void stateChanged(ChangeEvent ce) {
        jSpinnerDormir = (JSpinner) ce.getSource();
        try {
            value = (Integer) jSpinnerDormir.getValue();
        } catch (NumberFormatException exception) {
            value = 1;
        }
        if (value < 1) {
            jSpinnerDormir.setValue(Math.abs(value));
        } else {
            jSpinnerDormir.setValue(value);
        }
    }

    /**
     * Tramita el evento cuando se mueve la rueda del raton 
     * @param mwe
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        jSpinnerDormir = (JSpinner) mwe.getSource();
        wheel = mwe.getWheelRotation();
        if (wheel < 0) {
            value = (Integer) jSpinnerDormir.getValue();
            value++;
            jSpinnerDormir.setValue(value);
        } else {
            value = (Integer) jSpinnerDormir.getValue();
            if (value != 1) {
                value--;
            }
            jSpinnerDormir.setValue(value);
        }
    }
}
