/**
 * <p>
 * Copyright: Copyright (c) 2019</p>
 *
 * <h3>License</h3>
 *
 * Copyright (c) 2016 by Jonatan Gomez-Perdomo. <br>
 * All rights reserved. <br>
 *
 * <p>
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <ul>
 * <li> Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * <li> Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * <li> Neither the name of the copyright owners, their employers, nor the names
 * of its contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * </ul>
 * <p>
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 *
 *
 * @author <A HREF="https://dis.unal.edu.co/~jgomezpe/"> Jonatan Gomez-Perdomo
 * </A>
 * (E-mail: <A HREF="mailto:jgomezpe@unal.edu.co">jgomezpe@unal.edu.co</A> )
 * @version 1.0
 */
package ciudad;

import java.util.List;
import vehiculo.Vehiculo;

/**
 * Class representing a city
 *
 * @author jgomez
 *
 */
public class Ciudad {

    /**
     * Set of vehicles in the city
     */
    protected List<Vehiculo> listaVehiculos;
    /**
     * Set of places in the city
     */
    protected List<Sitio> listaSitios;
    /**
     * Map of the city. Used for painting the city
     */
    protected char[][] mapa;

    /**
     * Creates a city with the given vehicles and places
     *
     * @param listaVehiculos
     * @param sitio Set of places in the city
     */
    public Ciudad(List<Vehiculo> listaVehiculos, List<Sitio> listaSitios) {
        this.listaVehiculos = listaVehiculos;
        this.listaSitios = listaSitios;
        mapa = new char[ParametrosDibujo.ALTO][ParametrosDibujo.ANCHO];
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                mapa[i][j] = ' ';
            }
        }
    }

    /**
     * Moves the vehicles in the city. Vehicles moves one square from left to
     * right but can move up or down in a random fashion
     */
    public void mover() {
        if (listaVehiculos != null) {
            for(Vehiculo vehiculo: listaVehiculos){
                int f = Math.random() > 0.5 ? 1 : -1;
                int c = 1;
                vehiculo.mover(f, c);
            }
        }
    }

    public void moverReversa() {
        if (listaVehiculos != null) {
            for(Vehiculo vehiculo: listaVehiculos){
                int f = Math.random() > 0.5 ? 1 : -1;
                int c = -1;
                vehiculo.mover(f, c);
            }
        }
    }

    /**
     * Paints the set of vehicles and places in the map
     */
    public String pintar() {
        String lienzoMapa = "";
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                mapa[i][j] = ' ';
            }
        }

        if (listaSitios != null) {
            for(Sitio sitio: listaSitios){
                sitio.pintar(mapa);
            }
        }
        
        if (listaVehiculos != null) {
            for(Vehiculo vehiculo: listaVehiculos){
                vehiculo.pintar(mapa);  
            }
        }

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                lienzoMapa += mapa[i][j];
            }
            lienzoMapa += "\n";
        }

        return lienzoMapa;
    }
}
