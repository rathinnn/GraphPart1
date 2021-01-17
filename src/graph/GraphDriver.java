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
public class GraphDriver {
    public static void main(String[] args){
        
        //Graph Vertices are printed in the the folloeing Format: Label(Data)
        int[] mainnodes=new int[]{4,3,1,7,8};
        GraphAdj g = new GraphAdj(mainnodes);
        
        g.addDirecEdge(0,1);
        g.addDirecEdge(0,2);
        g.addDirecEdge(1,4);
        g.addDirecEdge(2,1);
        g.addDirecEdge(2,4);
        g.addDirecEdge(3,0);
        g.addDirecEdge(3,2);
        g.addDirecEdge(3,4);
        
        System.out.println("Adjacency List");
        g.print();
        
        System.out.println();
        
        
        GraphMat g2 = new GraphMat(mainnodes);
        
        g2.addDirecEdge(0,1);
        g2.addDirecEdge(0,2);
        g2.addDirecEdge(1,4);
        g2.addDirecEdge(2,1);
        g2.addDirecEdge(2,4);
        g2.addDirecEdge(3,0);
        g2.addDirecEdge(3,2);
        g2.addDirecEdge(3,4);
        
        System.out.println("Adjacency Matrix");
        g2.print();
        
        
        System.out.println();
        
        
        GraphAdj g3 = new GraphAdj(mainnodes);
        
        g3.addDirecEdge(0,1);
        g3.addDirecEdge(0,2);
        g3.addDirecEdge(1,4);
        g3.addDirecEdge(2,1);
        g3.addDirecEdge(2,4);
        g3.addDirecEdge(3,0);
        g3.addDirecEdge(3,2);
        g3.addDirecEdge(3,4);
        
        System.out.println();
        System.out.println("BFS");
        System.out.println(g3.BFS(0));
        System.out.println();
        
        
        GraphAdj g4 = new GraphAdj(6);
        
        g4.addDirecEdge(0,1);
        g4.addDirecEdge(0,3);
        g4.addDirecEdge(1,4);
        g4.addDirecEdge(2,4);
        g4.addDirecEdge(2,5);
        g4.addDirecEdge(3,1);
        g4.addDirecEdge(4,3);
        g4.addDirecEdge(5,5);
        
        System.out.println("DFS");
        g4.doDFS();
        
       
        //Toological Sort
        
        String[] names=new String[]{"Foundation","Walls","Plumbing","Windows","Roofs","Decoration"};
         GraphAdj g5 = new GraphAdj(names);
         
        g5.addDirecEdge(0,1);
        g5.addDirecEdge(1,2);
        g5.addDirecEdge(1,3);
        g5.addDirecEdge(1,4);
        g5.addDirecEdge(2,5);
        g5.addDirecEdge(3,5);
        g5.addDirecEdge(4,5);
        
         TopoList sorted = g5.TopSort();
         System.out.println();
         System.out.println("Topographical Sort");
         sorted.print();
         

        
        
       
        
        GraphAdj g6 = new GraphAdj(8);
        g6.addDirecEdge(0,1);
        g6.addDirecEdge(1,2);
        g6.addDirecEdge(1,4);
        g6.addDirecEdge(1,5);
        g6.addDirecEdge(2,3);
        g6.addDirecEdge(2,6);
        g6.addDirecEdge(3,2);
        g6.addDirecEdge(3,7);
        g6.addDirecEdge(4,0);
        g6.addDirecEdge(4,5);
        g6.addDirecEdge(5,6);
        g6.addDirecEdge(6,5);
        g6.addDirecEdge(6,7);
        g6.addDirecEdge(7,7);
        
        System.out.println();
        System.out.println("SCC");
        
        SCList res=g6.sepSCC();
        res.print();
        
        
        
    }
}
