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
public class SCNode {
    graphNodeAdj vertex;
    SCNode next;
    SCNode down;
    
    SCNode(graphNodeAdj vertex){
        this.vertex=vertex;
        next=null;
    }
    
    public void insertDown(SCNode down2){
      SCNode temp = this;
      while (temp.down!=null){
          temp=temp.down;
      }
      temp.down=down2;
    }
}
