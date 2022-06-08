package wordl;

public class Partida {

    private static final String[] INTENTOS = {"AIRES","PATATA","MUNDO","MINA","AMEBA","AMIGO"};


    private static String objetivo;          	 //Declaramos un String que será el objetivo.
    private static char[] letrasConGuiones ;	 //Declaramos una array de char 
   
    public Partida(String objetivo) {		  //Creamos la partida con el String objetivo a buscar.
        this.objetivo = objetivo; 			  //Le decimos que este objetivo es igual al objetivo de arriba.
        letrasConGuiones = new char[objetivo.length()];  //Creamos guiones con la longitud de la palabra objetivo.
    }

    public static void jugar(String palabraElegida) {  //Creamos metodo jugar con su palabraElegida como la que nosotros o la maquina proporcione como intento.

        String palabra = ""; 		//Inicializamos String palabra en vacio.
        boolean noCoincide = true;	//Cremos un boolean noCoincide y lo inicializamos en true. 
        boolean mismaPos = false;	//Creamos un boolean mismaPos y lo incializamos en false. Nos indicara si la letra a comparar esta en la misma posición o no.
        boolean distintaPos = false;	//creamos un boolean distintaPos y lo inicializamos en false.
        
        for(int i=0; i<palabraElegida.length(); i++) {  //Recorremos la palabra elegida, su longitud.
            for(int j=0; j<objetivo.length(); j++) {	//Y por cada letra de la palabra elegida recorremos la palabra objetivo(sus letras).
                if(objetivo.charAt(j)==palabraElegida.charAt(i) && i==j) {   //Si la letra de ese entonces de  la palabra objetivo es igual a la letra de ese entonces de la palabra elegida y i es igual a j..         	
                	letrasConGuiones[j] = objetivo.charAt(i); //letras con guiones de esa posicion j se sustituira por la letra i de la palabra objetivo de ese entonces.
                	noCoincide = false; //inicializamos el boolean en noCoincide en false, porque si coincide.
                	mismaPos = true;	//inicializamos el boolean en mismaPos en true porque si es la misma posición.
                }
                else if(objetivo.charAt(j)==palabraElegida.charAt(i) && i!=j) {      //En cambio si la letra de la palabra objetivo es igual a la letra de la palabra elegida de pero no coincide su posición..        	
                	noCoincide = false;  //inicializamos en false el boolean de noCoincide
                	distintaPos = true;	 // y inicializamos en true el boolean distintaPos porque no son iguales las posiciones de las letras.
                }
            }
            if (mismaPos == true) {  //si es misma posición nos pìntara la letra entre llaves
            	palabra = palabra +"[" + palabraElegida.charAt(i) + "]";  
            }
            else if(distintaPos == true) {     //si es distinta posicion nos pintara la letra entre parentesis
            	palabra = palabra +"(" + palabraElegida.charAt(i) + ")";
            }
            else {		//si no, el String palabra será igual a palabra + la letra de ese entonces de la i de la palabra elegida.
            	palabra = palabra + palabraElegida.charAt(i);
            }
            mismaPos = false;  //ponemos el boolean de misma posicion en false
            distintaPos = false;  //y distinta posición tambien.
        }
        for(int i = 0; i < letrasConGuiones.length;i++ ) { //recorremos los guiones hechos antes, su longitud.
        	if (objetivo.charAt(i) == letrasConGuiones[i]) {  //y si la letra del objetivo de ese entonces es igual a letras con guiones de la posicion i
        		System.out.print(letrasConGuiones[i]+ " ");  //imprime un system out con letras con guiones de esa posición i
        	}
        	else {
        		System.out.print("_" + " "); 
        	}
    	}
        System.out.print("\n");
        if(noCoincide == true) {  //si no coincide la palabra, osea, no tiene ninguna letra igual, muestra un mensaje de "ERROR".
        	System.out.print("ERROR:");
        }
        
        System.out.print(palabra);  //imprime la palabra
        System.out.print("\n" + "\n");
    }

    public static boolean isTerminada() {   //metodo que indica si la partida ha sido terminada de tipo booleano
    	boolean fin = false;  //inicializamos fin en false
    	boolean igual = true;   //inicializamos igual en true
    	for(int i = 0; i < letrasConGuiones.length && igual;i++ ) { //recoremos las letras con guiones, su longitud y si es igual
    		if(letrasConGuiones[i] != objetivo.charAt(i)) { //si letras con guiones de esa posicion no es igual al objetivo, cambia el igual a false.
    			igual = false;
    		}
    	}
    	if(igual == true) {  //si es igual fin se cambia a true
    		fin = true;  
    	}
        return fin; //si es asi, la partida habría terminado
    }


    public String getObjetivo() { //metodo tipico de get para que nos devuelva el objetivo.
        return objetivo;
    }


}
