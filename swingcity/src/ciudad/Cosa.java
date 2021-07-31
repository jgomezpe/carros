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

/**
 * Class representing any thing can be in a city 
 * @author jgomez
 *
 */
public class Cosa {
    /**
     * Position of the thing on the city
     */
    protected Posicion posicion;
    /**
     * Image of the thing
     */
    protected String[] imagen;
    
    /**
     * Creates a thing at the given position
     * @param posicion Position that will occupy the thing
     */
    public Cosa( Posicion posicion ) {
	this.posicion = posicion;
    }
    
    /**
     * Gets the position of the thing
     * @return Position of the thing
     */
    public Posicion posicion() { return posicion; }
    
    /**
     * Paints the thing in the city map
     * @param mapa City map
     */
    public void pintar( char[][] mapa ) {
	for( int i=0; i<imagen.length; i++) {
	    for( int j=0; j<imagen[i].length(); j++) {
		int f = (this.posicion.fila+i+mapa.length) % mapa.length;
		int c = (this.posicion.columna+j+mapa[i].length) % mapa[i].length; 
		mapa[f][c] = imagen[i].charAt(j);
	    }
	}
    }
}
