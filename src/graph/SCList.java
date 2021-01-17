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
public class SCList {
    SCNode head;
    
    SCList(){
        head=null;
    }
    
    public void add(graphNodeAdj vex){
        
            
            SCNode temp=new SCNode(vex);
            temp.next=head;
            head=temp;
        
    }
    public void add(SCNode temp){
        
                        
            temp.next=head;
            head=temp;
        
    }
    public void print(){
        SCNode temp=head;
        System.out.println();
            while(temp!=null){
                SCNode temp2=temp;
                while(temp2!=null){
                                System.out.print(temp2.vertex.Label+"("+temp2.vertex.data+")"+"-->");
                                   temp2=temp2.down;
                }
                System.out.print("X");
                System.out.println();
                temp=temp.next;
            }
            
            
    }
    
    
    
}
