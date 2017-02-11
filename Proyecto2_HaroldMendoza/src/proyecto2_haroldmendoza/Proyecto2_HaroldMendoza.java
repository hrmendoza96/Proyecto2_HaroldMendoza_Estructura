/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_haroldmendoza;


import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Harold Mendoza
 */
public class Proyecto2_HaroldMendoza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        TNode arbol= new TNode();
        int respuesta;
        File archivo = new File("./Jerarquia.txt");
        do {
            menu();
            respuesta = scan.nextInt();   
            if(respuesta==1){ //Cargar Arbol
                Scanner sc = null; 
                try { 
                    sc = new Scanner(archivo); 
                    String line;
                    int cont=0; //Contador para ingresar la raiz de todo el arbol la primera vez que se inicie el programa
                    while(sc.hasNextLine()){
                        if(cont==0){
                            try { 
                                line = sc.nextLine();   
                                Scanner sc2 = new Scanner(line);
                                sc2.useDelimiter(",");
                                while(sc2.hasNext()){
                                   arbol.setRoot(new TNode(sc2.next(),sc2.next(),Double.parseDouble(sc2.next())));
                                } // fin while 2.1
                            } catch (Exception e) {
                            }   
                        }else{
                            try {
                                int contador=0;//contar cantidad de *tabs*
                                line = sc.nextLine();
                                    for (int i = 0; i < line.length(); i++) {
                                       // System.out.println("Char "+i+")"+line.charAt(i));
                                        if(line.charAt(i)=='\t'){   
                                            contador++;
                                        }
                                    }
                               // System.out.println("Contador: "+contador);
                                Scanner sc3 = new Scanner(line);
                                sc3.useDelimiter(",");
                                while(sc3.hasNext()){ //crea los hijos de las roots
                                    if(contador==1){ //root principal
                                       String puesto=sc3.next();
                                       puesto= puesto.substring(contador); //Ignora los espacios en blanco de la primera palabra
                                       arbol.addChildren(new TNode(puesto,sc3.next(),Double.parseDouble(sc3.next())));
                                    }else{
                                        String puesto=sc3.next();//subhijos
                                        puesto = puesto.substring(contador); //Ignora los espacios en blanco de la primera palabra
                                        TNode hijo = new TNode(puesto,sc3.next(),Double.parseDouble(sc3.next())); 
                                        TNode padre = profundidad(arbol.getChildrenAt(arbol.getChildren().size()-1)); //se obtiene el ultimo nodo  
                                        padre.addChildren(hijo);
                                    }
                                    
                                    
                                   
                                } // fin del while 3
                            } catch (Exception e) {
                            }                             
                        } // fin del if else
                        cont++;
                    } // fin del while 1
                    System.out.println();//salto de linea
                    System.out.println("Arbol Jerarquico Cargado Exitosamente");
                } catch (Exception e) {
                    System.out.println("Arbol Jerarquico No pudo ser cargado");
                } finally{
                    sc.close(); 
                }
                System.out.println();//salto de linea
                
            }  
            if(respuesta==2){ //Ver Jerarquia
                try {
                    System.out.println(arbol.getRoot().toString());//se imprime root
                    for (TNode temp : arbol.getChildren()) { //Imprimir hijos de root   
                        String aux="\t"+ImprimirTree(temp,1); //se manda el padre para obtener hijo, y se manda la profundidad inicial que es de 1
                        System.out.println(aux);
                    }//fin fore
                    
                } catch (Exception e) {
                    System.out.println("");
                    System.out.println("Arbol vacio. Porfavor Presionar Opcion 1 para llenar.");
                    System.out.println("");
                }
               
                
                
                
                
            }
            if(respuesta==3){ //Salir
                System.out.println("Hasta Pronto!");
            }
        } while (respuesta!=3);
        
        
        
    }
    
    public static void menu(){
        System.out.println("Bienvenido al Arbol de Jerarquia de Empresas");
        System.out.println("1) Cargar arbol");
        System.out.println("2) Ver Jerarquia del Arbol");
        System.out.println("3) Salir");
        System.out.print("Ingrese su respuesta: ");
    }
    
    public static TNode profundidad(TNode padre){ //metodo recursivo para encontrrar el padre del ultimo nodo
       if(padre.getChildren().isEmpty()){
           return padre;
       }else{
           return profundidad(padre.getChildrenAt(padre.getChildren().size()-1));
       }
        
    }
    /**
     * 
     * @param padre
     * @param profundidad
     * @return El hijo del nodo padre enviado
     */
    public static TNode ImprimirTree(TNode padre,int profundidad){ 
       if(padre.getChildren().isEmpty()){
           //System.out.println("\t"+padre.toString());
           return padre;
       }else{
           System.out.println("\t"+padre.toString());
           for (int i = 0; i < profundidad; i++) { //for para hacer los tabs de profundidad
               System.out.print("\t");
           }
           return ImprimirTree(padre.getChildrenAt(padre.getChildren().size()-1),profundidad+1);
           //System.out.print("\t"+aux);
           //System.out.print("\t");
           //ImprimirTree(padre.getChildrenAt(padre.getChildren().size()-1));
           
       }
        
        
    }
}
