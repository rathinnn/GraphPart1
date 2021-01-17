/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

/**
 *
 * @author dell
 */
public class TopoNode {
    
    String Label;
    TopoNode next;
    
    TopoNode(String Label){
        this.Label=Label;
        next=null;
    }
    
}
