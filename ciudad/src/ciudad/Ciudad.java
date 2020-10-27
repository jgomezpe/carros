/**
 * <p>Copyright: Copyright (c) 2019</p>
 *
 * <h3>License</h3>
 *
 * Copyright (c) 2016 by Jonatan Gomez-Perdomo. <br>
 * All rights reserved. <br>
 *
 * <p>Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <ul>
 * <li> Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * <li> Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * <li> Neither the name of the copyright owners, their employers, nor the
 * names of its contributors may be used to endorse or promote products
 * derived from this software without specific prior written permission.
 * </ul>
 * <p>THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNERS OR CONTRIBUTORS BE
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
 * @author <A HREF="https://dis.unal.edu.co/~jgomezpe/"> Jonatan Gomez-Perdomo </A>
 * (E-mail: <A HREF="mailto:jgomezpe@unal.edu.co">jgomezpe@unal.edu.co</A> )
 * @version 1.0
 */
package ciudad;

import vehiculo.Vehiculo;

/**
 * Class representing a city 
 * @author jgomez
 *
 */
public class Ciudad {
    /**
     * Set of vehicles in the city
     */
    protected Vehiculo[] vehiculo;
    /**
     * Set of places in the city
     */
    protected Sitio[] sitio;
    /**
     * Map of the city. Used for painting the city
     */
    protected char[][] mapa;
    
    /**
     * Creates a city with the given vehicles and places
     * @param vehiculo Set of vehicles in the city
     * @param sitio Set of places in the city
     */
    public Ciudad( Vehiculo[] vehiculo, Sitio[] sitio ) {
	this.vehiculo = vehiculo;
	this.sitio = sitio;
	mapa = new char[30][60];
	for( int i=0; i<mapa.length; i++ ) {
	    for( int j=0; j<mapa[i].length; j++ ) {
		mapa[i][j] = ' ';
	    }
	}
    }
    
    /**
     * Moves the vehicles in the city. Vehicles moves one square from left to right
     * but can move up or down in a random fashion 
     */
    public void mover() {
	for( int i=0; i<vehiculo.length; i++ ) {
	    int f = (int)(Math.random()*3) - 1;
	    int c = 1;
	    vehiculo[i].mover(f, c);
	}
    }
    
    /**
     * Paints the set of vehicles and places in the map
     */
    public void pintar() {
	for( int i=0; i<mapa.length; i++ ) {
	    for( int j=0; j<mapa[i].length; j++ ) {
		mapa[i][j] = ' ';
	    }
	}

	for( int i=0; i<sitio.length; i++ ) {
	    sitio[i].pintar(mapa);
	}
	for( int i=0; i<vehiculo.length; i++ ) {
	    vehiculo[i].pintar(mapa);
	}
	
	for( int i=0; i<mapa.length; i++ ) {
	    System.out.println();
	    for( int j=0; j<mapa[i].length; j++ ) {
		System.out.print(mapa[i][j]);
	    }
	}
    }
}
