/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2_haroldmendoza;
import java.util.ArrayList;

/**
 *
 * @author Harold Mendoza
 */
public class TNode {
   TNode root;
   ArrayList<TNode> Children = new ArrayList();
    protected String puesto;
    protected String nombre;
    protected double salario;
   
   public TNode() {
    }

    public TNode(String puesto, String nombre, double salario) {
        this.puesto = puesto;
        this.nombre = nombre;
        this.salario = salario;
    }

    public TNode getRoot() {
        return root;
    }

    public void setRoot(TNode root) {
        this.root = root;
    }
   
    public ArrayList<TNode> getChildren() {
        return Children;
    }
    public TNode getChildrenAt(int p) {
        return Children.get(p);
    }

    public void setChildren(ArrayList<TNode> Children) {
        this.Children = Children;
    }
    
    public void addChildren(TNode p){
        Children.add(p);
    }

    @Override
    public String toString() {
        return  puesto + "," + nombre + "," + salario;
    }
    
    

    
}
