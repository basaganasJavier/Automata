/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class Turno extends Thread {
  	
    
    
    public void run() {
                int x = Integer.parseInt("15");//tamaño del tablero introducido por parametro

		Celula matriz[][] =  inicializar(x);	
		imprimir(matriz);
		System.out.println("----------------------------------------------------------");		
            

		while(true) {			
			actualizar(matriz);
                    try {
                        Thread.sleep((long) (Math.random() * 20000));//para dar una pausa entre turno y turno
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Turno.class.getName()).log(Level.SEVERE, null, ex);
                    }
			imprimir(matriz);	
			System.out.println("----------------------------------------------------------");
		}
			
	
	} 
        //usado para imprimir la matriz por consola
        public  void imprimir(Celula matriz[][]) {
            for (int x=0; x < matriz.length; x++) {
		System.out.print(" | ");
		for (int y=0; y < matriz[x].length; y++) {
                    Celula cell = (Celula)matriz[x][y];
                    cell.Pintar();
                    if (y!=matriz[x].length-1) System.out.print("\t");
                    }
                    System.out.println(" | ");
		}
	}
        
        //metodo en el que inicializamos cada valor de la matriz
	public  Celula[][] inicializar(int size){
		int numero = 0;
		Celula matriz[][] = new Celula[size][size];
		for (int x=0; x < matriz.length; x++) {
			for (int y=0; y < matriz[x].length; y++) {
				numero = (int) (Math.random() * 6) + 1;
				if (numero ==2) {
					matriz[x][y] =  new Celula(false , x , y);

				} else  {
					matriz[x][y] =  new Celula(true , x , y);
				}
			}
		}
		return matriz;
	}
        
        //metodo usado para actualizar los valores de la matriz
	public  void actualizar(Celula matriz[][]) {
		for (int x=0; x < matriz.length; x++) {
			for (int y=0; y < matriz[x].length; y++) {
				Celula cell = (Celula)matriz[x][y];
				cell.actualizarValor(matriz);			    
			}			  
		}
	}
}
