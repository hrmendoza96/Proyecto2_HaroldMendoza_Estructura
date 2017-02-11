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
   Persona root;
   ArrayList<Persona> Children = new ArrayList();
   
   public TNode() {
    }

    public TNode(Persona root) {
        this.root = root;
    }

    public Persona getRoot() {
        return root;
    }

    public void setRoot(Persona root) {
        this.root = root;
    }
   
    public ArrayList<Persona> getChildren() {
        return Children;
    }

    public void setChildren(ArrayList<Persona> Children) {
        this.Children = Children;
    }
    
    public void addChildren(Persona p){
        Children.add(p);
    }

    @Override
    public String toString() {
        return "TreeNode{" + "Children=" + Children + '}';
    }
    
    

    
}
