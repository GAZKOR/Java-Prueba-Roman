package wordl;

import java.util.Scanner; //importamos Scanner para más adelante poder recoger el dato como nuestra respuesta de intento.

public class Main {

	private static final String[] INTENTOS = {"AIRES","PATATA","MUNDO","MINA","AMEBA","AMIGO"};

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);  //Creamos el Scanner.
    
        System.out.println("Bienvenido al Wordle");
        System.out.println("Vamos a jugar!"+"\n");
        String objetivo;   
        int numero = (int)(Math.random()*6); //El objetivo aleatorio va a ser el mismo, nosotros no lo tocaremos.
        objetivo = INTENTOS[numero];
        Partida p = new Partida(objetivo);                                                
        int i = 0;     
        
        while(!Partida.isTerminada()) {
        	System.out.println("Intente Adivinar"); //Metemos un mensaje para dar a entender al jugador de que intente con una palabra.
        	String intentoNuestro = sc.nextLine();  //Recogemos esos datos con el scaner utilizando el nextLine para tipo String.
            Partida.jugar(intentoNuestro);   //Y jugamos con esa palabra.
            i++;
        }
        if(Partida.isTerminada()) {                        
            System.out.println("Has ganado, era "+p.getObjetivo()); 
            System.out.println("Con el contador a: "+i);

    }

}

} 
