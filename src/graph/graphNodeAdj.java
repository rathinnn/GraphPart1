/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.ArrayList;

/**
 *
 * @author dell
 */
public class graphNodeAdj  {
    int data;
    int Label;
    //ArrayList<graphNode> adjList;
    int colour;
    int distance;
    int discovery;
    int finish;
    ArrayList<graphNodeAdj> adjList;
    ArrayList<Edge> Edges;
    static int time=0;
    
    graphNodeAdj(int data,int label){
        
        this.data=data;
        this.Label=label;
        
        
        //white is -1 grey is 0 black is 1
        colour=-1;
        distance=0;
        discovery=0;
        finish=0;
        adjList=new ArrayList<>();
        
        
    }
    
    
    
    public void add(graphNodeAdj node){
        adjList.add(node);
        
    }
    
    public void add(graphNodeAdj node,int weight){
        adjList.add(node);
        Edges.add(new Edge(weight));
        
    }
    
    
   
    public void print(){
        System.out.print(Label+"("+data+")"+": ");
        for (graphNodeAdj u : adjList){
            System.out.print(u.Label+"("+u.data+")"+"-->");
        }
        System.out.print("X");
    }
    
    public static void resettime(){
        time=0;
    }
    
    public void dfs(){
        time=time+1;
        discovery=time;
        colour=0;
        for (graphNodeAdj v:adjList){
            if(v.colour==-1){
                
                v.dfs();
                
                }
            
            
            }
            colour=1;
            time=time+1;
            finish=time;
    }
    
    public void TLdfs(TopoList list,String[] names ){
        time=time+1;
        discovery=time;
        colour=0;
        for (graphNodeAdj v:adjList){
            if(v.colour==-1){
                
                v.TLdfs(list,names);
                
                }
            
            
            }
            colour=1;
            time=time+1;
            finish=time;
            list.add(names[Label]);
    }
    
    
    public void SCdfs(SCList list){
        time=time+1;
        discovery=time;
        colour=0;
        for (graphNodeAdj v:adjList){
            if(v.colour==-1){
                
                v.SCdfs(list);
                
                }
            
            
            }
            colour=1;
            time=time+1;
            finish=time;
            list.add(this);
    }
    
    
    public SCNode dfsfortranspose(SCNode node){
        time=time+1;
        discovery=time;
        colour=0;
        for (graphNodeAdj v:adjList){
            if(v.colour==-1){
                
                node=v.dfsfortranspose(node);
                
                }
            
            
            }
            colour=1;
            time=time+1;
            finish=time;
            if(node==null){
                node = new SCNode(this);
            }
            else{
                
            
            node.insertDown(new SCNode(this));
            }
            
            return node;
            
            }
    
    
}
