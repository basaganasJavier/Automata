/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

/**
 *
 * @author Javier
 */
public class Celula {
    
	public boolean viva;
	private int _x;
	private int _y;
	public Celula(boolean viva , int x, int y) {
		super();
		this.viva = viva;		
		_x=x;
		_y=y;
	}


	public void setViva(boolean Viva) {
		this.viva = Viva;
	}
	
        
	private int CheckVecinas(Celula matriz[][]) {//comprobamos la canitdad de celulas de alrededor y nos deuvelve una cantidad con el total de ellas
        int contador = 0;
        int posicionXToCheck = _x;
        int posicionYToCheck = _y;
        for (int x = 0; x<=2 ; x++){
            if(x==0){
                    posicionXToCheck = _x-1;
                }else if(x==1){
                    posicionXToCheck = _x;
                }else if(x == 2){
                    posicionXToCheck = _x+1;
                }
            for(int y = 0; y<=2 ; y++){
            	
                if(y==0){
                    posicionYToCheck =_y-1;
                }else if(y==1){
                    posicionYToCheck =_y;
                }else if(y==2){
                    posicionYToCheck =_y+1;
                }
                
                if(_x == posicionXToCheck && posicionYToCheck == _y ){ //no comprobar la propia
                    continue;
                }
                if(ValidarPosicion(matriz.length-1, matriz[0].length-1,posicionXToCheck, posicionYToCheck)){ // validar que no esta fuera del rango
                   if(matriz[posicionXToCheck][posicionYToCheck].viva){
                    contador++;
                   }
                }
            }
        }

        return contador;
    }
        //validamos posicion para no salirnos de la matriz
        private boolean ValidarPosicion(int matrizX, int matrizY, int poisitionX, int positionY){
        if(poisitionX < 0  || positionY < 0 || poisitionX > matrizX || positionY > matrizY){
            return false;
        }
        return true;
    }
	
	//reglas aplicadas para que segun condicion se quede en viva o muerta la celula
        public void actualizarValor(Celula matriz[][]) {
		
	int celdasVivas = this.CheckVecinas(matriz);
	if (viva && celdasVivas<2) {
		viva=false;
	} if(viva && (celdasVivas==2 || celdasVivas==3)) {
		viva=true;
	}  if (viva && celdasVivas>3) {
		viva=false;
	}  if (viva==false &&celdasVivas==3) {
		viva=true;
	}
	}

	
	//metodo con el que imprimimos si esta viva una "V" verde y si esta muerta una "M" roja
	public void Pintar() {
		if (viva) {
			System.out.print ("V"); 
		} else {
			System.out.print("M");
		}
		 
	}
	
}
