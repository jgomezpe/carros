/**
 * <p>Copyright: Copyright (c) 2019</p>
 *
 * <h3>License</h3>
 *
 * Copyright (c) 2019 by Jonatan Gomez-Perdomo. <br>
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
package vehiculo;

/**
 * Abstract Class representing a Vehicle
 * @author jgomez
 *
 */
public abstract class Vehiculo {
    /**
     * Speed of the Vehicle
     */
    protected double velocidad;
    /**
     * Number of passengers 
     */
    protected int pasajeros;
    
    /**
     * Creates a vehicle with the given number of passengers and speed
     * @param pasajeros Number of passengers
     * @param velocidad Speed of the Vehicle
     */
    public Vehiculo(int pasajeros, double velocidad) {
	this.velocidad = velocidad;
	this.pasajeros = pasajeros;
    }
    
    /**
     * Determines the position of the vehicle at the given time
     * @param tiempo Time 
     * @return Position of the vehicle at the given time
     */
    public int posicion( int tiempo ) {
	return (int)(tiempo*velocidad);
    }
    
    /**
     * Prints a collection of empty spaces (for simulating the position of the vehicle)
     * @param espacios Number of empty spaces to print
     */
    public void espacios(int espacios){
	for( int i=0;i<espacios;i++) System.out.print(' ');
    }
    
    /**
     * Paints the vehicle at the given position
     * @param posicion Position used to print the vehicle
     */
    public abstract void pintar( int posicion ); 
}