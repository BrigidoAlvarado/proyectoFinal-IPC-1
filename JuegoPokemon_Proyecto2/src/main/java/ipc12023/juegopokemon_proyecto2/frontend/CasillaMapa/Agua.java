
package ipc12023.juegopokemon_proyecto2.frontend.CasillaMapa;

import ipc12023.juegopokemon_proyecto2.backend.AdminJuego;

public class Agua extends CasillaGenerada{

   private static int MAX_CASILLAS_GENERADAS=12;
   private String PATH_IMAGEN="/casillas/agua.png";
   private JLblCasillaMapa[][] mapa;
   
   public Agua(){
    
    pathImagen = PATH_IMAGEN;
    casillasMax = MAX_CASILLAS_GENERADAS;
    super.agregarImagen();
   }
   
   
    @Override
    public void generarCasilla (JLblCasillaMapa[][] mapa) {
        
        this.mapa = mapa;
    
  // int seguro=0;
      while(casillasMax != casillasGeneradas){
  //       seguro++;
            generarCasilla();
          
            if (casillasEnLasOrillas()) {            
                llenarEnCasillaDisponible();
          }
  //   seguro(seguro);
      }  
    }
    //plan B si no se genera ningun mapa
//   private void seguro(int seguro){
//        if(seguro==200){
//            //1 2 3
//            mapa[1][0]=new Agua();
//            mapa[1][1]=new Agua();
//            mapa[1][2]=new Agua();
//            //4 5
//            mapa[4][0]=new Agua();
//            mapa[5][0]=new Agua();
//            //6 7
//            mapa[8][1]=new Agua();
//            mapa[8][2]=new Agua();
//            //8 9 10
//            mapa[8][5]=new Agua();
//            mapa[7][5]=new Agua();
//            mapa[6][5]=new Agua();
//            //11 12
//            mapa[3][8]=new Agua();
//            mapa[4][8]=new Agua();
//            casillasGeneradas=MAX_CASILLAS_GENERADAS;
//        }
//    }
     
   private void llenarEnCasillaDisponible(){    
       if (i==0) {
           casillaDesponibleLadoSuperior();
       }
       else if (i==8) {
           casillaDesponibleLadoInferior();
       }
       else if(j==0){
           casillaDesponibleLadoIzquierdo();
       }else if (j==8) {
           casillaDesponibleLadoDerecho();
        
       }
   }
   private void generarCasilla(){
       i=AdminJuego.random(0, 8);
       j=AdminJuego.random(0, 8);    
   }
   private void llenarCasilla(int i, int j){
       if(casillasMax != casillasGeneradas){ 
           mapa[i][j]= new Agua();
           casillasGeneradas++;
       }
   }
   private boolean casillasEnLasOrillas(){
           boolean disponible=false;
           if (i==0||i==8) {
           disponible=true;
       }else if (j==0||j==8) {
           disponible=true;
       }
       return disponible;   
   }
   private boolean casillaDisponible(int posicion_i, int posicion_j){
       boolean disponible=true;
       
       if(posicion_i<0||posicion_i>8){
           disponible=false;
       }
       else if(posicion_j<0||posicion_j>8){
           disponible=false;
       }
       else if(mapa[posicion_i][posicion_j] instanceof Agua){
           disponible=false;
       }
       return disponible;
   }
    
   private boolean lugarDisponibleVerticalmenteHaciaAbajo(){
      int contador=0;
       boolean disponible=false;
       if(casillaDisponible(i, j)){contador++;}else{contador--;}
       if(casillaDisponible(i-1, j)){contador++;}else{contador--;}
       if(casillaDisponible(i+1, j)){contador++;}else{contador--;}
       if(casillaDisponible(i+2, j)){contador++;}else{contador--;} 
       if(casillaDisponible(i+3, j)){contador++;}else{contador--;}
       if (contador==5) {
           disponible=true;
       }
       return disponible;
   }
   private boolean lugarDisponibleVerticalmenteHaciaArriba(int i,int j){
       int contador=0;
       boolean disponible=false;
       if(casillaDisponible(i, j)){contador++;}else{contador--;}
       if(casillaDisponible(i+1, j)){contador++;}else{contador--;}
       if(casillaDisponible(i-1, j)){contador++;}else{contador--;}
       if(casillaDisponible(i-2, j)){contador++;}else{contador--;}
       if(casillaDisponible(i-3, j)){contador++;}else{contador--;}
       if (contador==5) {
           disponible=true;
       }
       return disponible;
   }
   private boolean lugarDisponibleHorizontalmenteHaciaLaIzquierda(){
       int contador=0;
       boolean disponible=false;
       if(casillaDisponible(i, j)){contador++;}else{contador--;}
       if(casillaDisponible(i, j+1)){contador++;}else{contador--;}
       if(casillaDisponible(i, j-1)){contador++;}else{contador--;}
       if(casillaDisponible(i, j-2)){contador++;}else{contador--;} 
       if(casillaDisponible(i, j-3)){contador++;}else{contador--;}
       if (contador==5) {
           disponible=true;
       }
       return disponible;
   }
   private boolean lugarDisponibleHorizontalmenteHaciaLaDerecha(){
       
       int contador=0;
       boolean disponible=false;
       if(casillaDisponible(i, j)){contador++;}else{contador--;}
       if(casillaDisponible(i, j-1)){contador++;}else{contador--;}
       if(casillaDisponible(i, j+1)){contador++;}else{contador--;}
       if(casillaDisponible(i, j+2)){contador++;}else{contador--;}
       if(casillaDisponible(i, j+3)){contador++;}else{contador--;}
       if (contador==5) {
           disponible=true;         
       }
       return disponible;
   }
   
   private boolean lugarDisponibleHaciaAbajoDesdeArriba(){
      int contador=0;
       boolean disponible=false;
       if(casillaDisponible(i, j)){contador++;}else{contador--;}
       if(casillaDisponible(i+1, j)){contador++;}else{contador--;}
       if(casillaDisponible(i+2, j)){contador++;}else{contador--;} 
       if(casillaDisponible(i+3, j)){contador++;}else{contador--;}
       //
       if(casillaDisponible(i, j-1)){contador++;}else{contador--;}
       if(casillaDisponible(i+1, j-1)){contador++;}else{contador--;}
       if(casillaDisponible(i+2, j-1)){contador++;}else{contador--;} 
       if(casillaDisponible(i+3, j-1)){contador++;}else{contador--;}
       //
       if(casillaDisponible(i, j+1)){contador++;}else{contador--;}
       if(casillaDisponible(i+1, j+1)){contador++;}else{contador--;}
       if(casillaDisponible(i+2, j+1)){contador++;}else{contador--;} 
       if(casillaDisponible(i+3, j+1)){contador++;}else{contador--;}
       if (contador==12) {
           disponible=true;
       }
       return disponible;
   }
   private boolean lugarDisponibleHaciaArribaDesdeAbajo(){
       
       int contador=0;
       boolean disponible=false;
       if(casillaDisponible(i, j)){contador++;}else{contador--;}
       if(casillaDisponible(i, j-1)){contador++;}else{contador--;}
       if(casillaDisponible(i, j+1)){contador++;}else{contador--;}
       if(casillaDisponible(i-1, j)){contador++;}else{contador--;}
       if(casillaDisponible(i-2, j)){contador++;}else{contador--;}
       if(casillaDisponible(i-3, j)){contador++;}else{contador--;}
       if (contador==6) {
           disponible=true;
       }
       return disponible;
   }
   private boolean lugarDisponibleHaciaLaIzquierdaDesdeDerecha(){
       int contador=0;
       boolean disponible=false;
       if(casillaDisponible(i, j)){contador++;}else{contador--;}
       if(casillaDisponible(i-1, j)){contador++;}else{contador--;}
       if(casillaDisponible(i+1, j)){contador++;}else{contador--;}
       if(casillaDisponible(i, j-1)){contador++;}else{contador--;}
       if(casillaDisponible(i, j-2)){contador++;}else{contador--;} 
       if(casillaDisponible(i, j-3)){contador++;}else{contador--;}
       if (contador==6) {
           disponible=true;
       }
       return disponible;
   }
   private boolean lugarDisponibleHaciaLaDerechaDeseIzquierda(){
       int contador=0;
       boolean disponible=false;
       if(casillaDisponible(i, j)){contador++;}else{contador--;}
       if(casillaDisponible(i-1, j)){contador++;}else{contador--;}
       if(casillaDisponible(i+1, j)){contador++;}else{contador--;}
       if(casillaDisponible(i, j+1)){contador++;}else{contador--;}
       if(casillaDisponible(i, j+2)){contador++;}else{contador--;}
       if(casillaDisponible(i, j+3)){contador++;}else{contador--;}
       if (contador==6) {
           disponible=true;
       }
       return disponible;
   }
   
   private void llenarVerticalmenteHaciaAbajo(){
       llenarCasilla(i, j);
       llenarCasilla(i+1, j);
       if (AdminJuego.probabilidad(50)) {
           llenarCasilla(i+2, j);
       }   
   }
   private void llenarVerticalmenteHaciaArriba(){
       llenarCasilla(i, j);
       llenarCasilla(i-1, j);
       if (AdminJuego.probabilidad(50)) {
           llenarCasilla(i-2, j);
       }   
   }
   private void llenarHorizontalmenteHaciaLaDerecha(){
       llenarCasilla(i, j);
       llenarCasilla(i, j+1);
       if (AdminJuego.probabilidad(50)) {
           llenarCasilla(i, j+2);
       }   
   }
   private void llenarHorizontalmenteHaciaLaIzquierda(){
       llenarCasilla(i, j);
       llenarCasilla(i, j-1);
       if (AdminJuego.probabilidad(50)) {
           llenarCasilla(i, j-2);
       }   
   }
   
   private void casillaDesponibleLadoSuperior(){
               
           if (lugarDisponibleHorizontalmenteHaciaLaDerecha()) { 
               
                llenarHorizontalmenteHaciaLaDerecha();
           }
            else if (lugarDisponibleHorizontalmenteHaciaLaIzquierda()) {
               llenarHorizontalmenteHaciaLaIzquierda();
              }
            else if (lugarDisponibleHaciaAbajoDesdeArriba()) {
                    llenarVerticalmenteHaciaAbajo();
            }
   }
   private void casillaDesponibleLadoInferior(){
           if (lugarDisponibleHorizontalmenteHaciaLaDerecha()) {
               llenarHorizontalmenteHaciaLaDerecha();
               
           }
            else if (lugarDisponibleHorizontalmenteHaciaLaIzquierda()) {
               llenarHorizontalmenteHaciaLaIzquierda();
              }
            else if (lugarDisponibleHaciaArribaDesdeAbajo()) {
                llenarVerticalmenteHaciaArriba();
       }
   }
   private void casillaDesponibleLadoIzquierdo(){
           if (lugarDisponibleVerticalmenteHaciaArriba(i,j)) {
           llenarVerticalmenteHaciaArriba();
       }else if (lugarDisponibleVerticalmenteHaciaAbajo()) {
           llenarVerticalmenteHaciaAbajo();
       }else if (lugarDisponibleHaciaLaDerechaDeseIzquierda()) {
           llenarHorizontalmenteHaciaLaDerecha();
       }
   }
   private void casillaDesponibleLadoDerecho(){
           if (lugarDisponibleVerticalmenteHaciaArriba(i,j)) {
           llenarVerticalmenteHaciaArriba();
       }else if (lugarDisponibleVerticalmenteHaciaAbajo()) {
           llenarVerticalmenteHaciaAbajo();
       }else if (lugarDisponibleHaciaLaIzquierdaDesdeDerecha()) {
           llenarHorizontalmenteHaciaLaIzquierda();
       }
   }
    
}
