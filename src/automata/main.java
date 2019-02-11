package automata;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Javier
 */
public class main {

    /**
     * @param args the command line arguments
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = Integer.parseInt("15");

		Celula matriz[][] =  inicializar(x);	
		boolean turno=true;
		imprimir(matriz);
		System.out.println("---------------------------------------------");
		while(true) {			
			actualizar(matriz);
			imprimir(matriz);	
			System.out.println("---------------------------------------------");
		}




	}
               //usado para imprimir la matriz por consola
	public static void imprimir(Celula matriz[][]) {
		for (int x=0; x < matriz.length; x++) {
			System.out.print("|");
			for (int y=0; y < matriz[x].length; y++) {
				Celula cell = (Celula)matriz[x][y];
				cell.Pintar();
				if (y!=matriz[x].length-1) System.out.print("\t");
			}
			System.out.println("|");
		}
	}
	public static Celula[][] inicializar(int size){//metodo en el cual inicializamos la matriz
		int numero = (int) (Math.random() * 2) + 1;
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

	public static void actualizar(Celula matriz[][]) {//usado para actualizar la matriz
		for (int x=0; x < matriz.length; x++) {
			for (int y=0; y < matriz[x].length; y++) {
				Celula cell = (Celula)matriz[x][y];
				cell.actualizarValor(matriz);			    
			}			  
		}
	}
}