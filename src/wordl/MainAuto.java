package wordl;

public class MainAuto {

	private static final String[] INTENTOS = {"AIRES","PATATA","MUNDO","MINA","AMEBA","AMIGO"};  //Tenemos nuestra coleccion de palabras como constante.

    public static void main(String[] args) {
    	
    	System.out.println("Bienvenido al Wordle");   
        System.out.println("Vamos a jugar!");
        String objetivo;                            //Declaramos un String con el nombre objetivo que más tarde utilizaremos como la palabra objetivo a buscar.
        int numero = (int)(Math.random()*6);        //Aqui creamos un número aleatorio con Math.random por la longitud de la coleccion INTENTOS.
        objetivo = INTENTOS[numero];				//El objetivo final va a ser un elemento de la lista INTENTOS con ese número aleatorio, cogera una palabra de forma aleatoria gracias al numero que nos indica una posicion al azar.
        Partida p = new Partida(objetivo);          //Creamos una nueva partida con la palabra objetivo a buscar.                                      
        int i = 0;                                  //Aqui creamos una variable que nos servira de contador, para ver los intentos.                                          
        while(!Partida.isTerminada()) {				//Mientras la partida no haya terminado
            Partida.jugar(INTENTOS[i]); 			  //jugaremos con los intentos que iran incrementando con cada ciclo
            i++;									  //incrementamos el contador
        }
        if(Partida.isTerminada()) {                        
            System.out.println("Has ganado, era "+p.getObjetivo());      //Si la partida ha terminado, muestra un mensaje y con el metodo getObjetivo, muestra la palabra que era
            System.out.println("El ordenador necesitó de : "+i+" intentos"); //Imprime el contador
    }

}

}
