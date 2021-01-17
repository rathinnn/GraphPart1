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
public class TopoList {
    TopoNode head;
    
    TopoList(){
        head=null;
    }
    
    public void add(String nex){
        
            
            TopoNode temp=new TopoNode(nex);
            temp.next=head;
            head=temp;
        
    }
    
    public void print(){
        TopoNode temp=head;
        System.out.println();
            while(temp!=null){
                System.out.print(temp.Label+"-->");
                temp=temp.next;
            }
            System.out.print("X");
            System.out.println();
       
    }
}
