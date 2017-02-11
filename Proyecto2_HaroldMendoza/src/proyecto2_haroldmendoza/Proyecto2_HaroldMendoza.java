/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_haroldmendoza;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
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
                    //sc.useDelimiter(",");
                    String line;
                    int cont=0;
                    while(sc.hasNextLine()){
                        if(cont==0){
                            try {
                                
                                line = sc.nextLine();
                                
                                Scanner sc2 = new Scanner(line);
                                sc2.useDelimiter(",");
                                while(sc2.hasNext()){
                                   arbol.setRoot(new Persona(sc2.next(),sc2.next(),Double.parseDouble(sc2.next())));
                                   System.out.println(arbol.getRoot().toString());
                                    //System.out.println("Hola");
                                } // fin while 2.1
                              // System.out.println("Hola");
                            } catch (Exception e) {
                            }   
                        }else{
                            try {
                                line = sc.nextLine();
                                Scanner sc2 = new Scanner(line);
                                sc2.useDelimiter("  ");
                                while(sc2.hasNext()){
                                    try {
                                        String line2 = sc2.nextLine();
                                        Scanner sc3 = new Scanner(line2);
                                        sc3.useDelimiter(",");
                                        while(sc3.hasNext()){
                                           arbol.addChildren(new Persona(sc3.next(),sc3.next(),Double.parseDouble(sc3.next())));
                                           System.out.println(arbol.getChildren().get(0).toString());
                                        } // fin del while 3
                                    } catch (Exception e) {
                                    }                             
                                } // fin del while 2.2
                            } catch (Exception e) {
                            }
                            
                        }
                        
                        cont++;
                    } // fin del while 1
                    System.out.println("Arbol Jerarquico Cargado Exitosamente");
                } catch (Exception e) {
                    System.out.println("Arbol Jerarquico No pudo ser cargado");
                } finally{
                    sc.close(); 
                }
                System.out.println();//salto de linea
                
            }  
            if(respuesta==2){ //Ver Jerarquia
                
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
    
}
