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
 * Class representing a position in the city map 
 * @author jgomez
 *
 */
public class Posicion {
    /**
     * Row of the position
     */
    public int fila;
    /**
     * Column of the position
     */
    public int columna;
    
    private int nuevaFila;
    
    private int nuevaColumna;
    
    public Posicion() {
	this.fila = (int) (Math.random() * ParametrosDibujo.ALTO) + 1;
	this.columna = (int) (Math.random() * ParametrosDibujo.ANCHO) + 1;
    }
    
    /**
     * Creates a position using the given row and column
     * @param fila Row of the position
     * @param columna Column of the position
     */
    public Posicion( int fila, int columna ) {
	this.fila = fila;
	this.columna = columna;
    }
    
    /**
     * Changes the position in the amount provided
     * @param cambio_fila Change in row
     * @param cambio_columna Change in column
     */
    public void cambiar( int cambio_fila, int cambio_columna ) { 
        nuevaFila = this.fila  + cambio_fila;
        this.fila = nuevaFila < 0 ? 
                ParametrosDibujo.ALTO + cambio_fila: 
                nuevaFila;
        nuevaColumna = this.columna + cambio_columna;
	this.columna = nuevaColumna < 0 ? 
                ParametrosDibujo.ANCHO + cambio_columna : 
                nuevaColumna;
    }
}