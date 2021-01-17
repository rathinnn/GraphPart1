/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;
import java.util.ArrayDeque;
/**
 *
 * @author dell
 */
public class GraphAdj  {
    graphNodeAdj[] nodes;
    int numnodes;
    
    String[] forTop=null;
    
   
    
    GraphAdj(int[] mainnodes){
        numnodes=mainnodes.length;
        nodes=new graphNodeAdj[numnodes];
       
        for (int i = 0 ;i<numnodes;i++){
            nodes[i]=new graphNodeAdj(mainnodes[i],i);
        }
    }
    
    GraphAdj(int n){
        numnodes=n;
        nodes=new graphNodeAdj[numnodes];
        for (int i = 0 ;i<numnodes;i++){
            nodes[i]=new graphNodeAdj(i,i);
        }
    }
    
    //Constructor for Topological Sort
    GraphAdj(String[] mainnodes){
        numnodes=mainnodes.length;
        nodes=new graphNodeAdj[numnodes];
       
        for (int i = 0 ;i<numnodes;i++){
            nodes[i]=new graphNodeAdj(i,i);
        }
        forTop=mainnodes;
        
    }
    
   
    
    
   
    public void addDirecEdge(int from,int to){
        nodes[from].add(nodes[to]);
        
    }
    
 
    public void print(){
        for (graphNodeAdj u:nodes){
            u.print();
            System.out.println();
        }
    }


    public graphNodeAdj[] getNodes() {
        return nodes;
    }
    
    
    public boolean BFS(int j){
        ArrayDeque<graphNodeAdj> Q= new ArrayDeque<>();
        for (graphNodeAdj u:nodes){
            u.colour=-1;
            u.distance=-1;
        }
        graphNodeAdj s = nodes[j];
        s.distance=0;
        s.colour=0;
        Q.addFirst(s);
        graphNodeAdj temp = null;
        while(!Q.isEmpty()){
            temp=Q.pollLast();
            System.out.println(temp.Label+"("+temp.data+")"+":d="+temp.distance);
            for (graphNodeAdj v:temp.adjList){
            if(v.colour==-1){
                v.colour=0;
                v.distance=temp.distance+1;
                Q.addFirst(v);
                }
            
            }
            temp.colour=1;
        }
        for (graphNodeAdj u:nodes){
            if(u.colour==-1){
                System.out.println(u.Label+" Not accesible from "+s.Label);
                return false;
            }
        }
        return true;
        
    }
    
    public void DFS(){
        graphNodeAdj.resettime();
        for (graphNodeAdj u:nodes){
            u.colour=-1;
            
        }
        for (graphNodeAdj u:nodes){
            if(u.colour==-1){
                u.dfs();
            }
            
        }
        graphNodeAdj.resettime();
    }
    
    public TopoList TLDFS(String[] names){
        TopoList list = new TopoList();
        graphNodeAdj.resettime();
        for (graphNodeAdj u:nodes){
            u.colour=-1;
            
        }
        for (graphNodeAdj u:nodes){
            if(u.colour==-1){
                u.TLdfs(list, names);
            }
            
        }
        graphNodeAdj.resettime();
     return list;   
    }
    
    public void doDFS(){
        DFS();
        for (graphNodeAdj u:nodes){
            System.out.println(u.Label+"("+u.data+")"+":discovery="+u.discovery+":finish="+u.finish);
            
        }
    }
    
    public TopoList TopSort(){
        if(forTop!=null){
            return TLDFS(forTop);
        }
        else{
            System.out.println("Object not Initialized for Topological Sorting");
            return null;
        }
    }
    
    
    
    public SCList sepSCC(){
        SCList list = this.SCDFS();
        GraphAdj grapht=GraphAdj.getTranspose(this);
        graphNodeAdj[] nodest=grapht.nodes;
        SCNode temp = list.head;
        SCList ret = new SCList();
        
        while(temp!=null){
            
            graphNodeAdj cur = nodest[temp.vertex.Label];
            if(cur.colour==-1){
            ret.add(cur.dfsfortranspose(null));
            
            
            }
            
            temp=temp.next;
        }
        
        
        return ret;
        
    }
    
    
    public SCList SCDFS(){
        
        SCList list = new SCList();
        graphNodeAdj.resettime();
        for (graphNodeAdj u:nodes){
            u.colour=-1;
            
        }
        for (graphNodeAdj u:nodes){
            if(u.colour==-1){
                u.SCdfs(list);
            }
            
        }
        graphNodeAdj.resettime();
     return list;   
    }
    
    
    public static GraphAdj getTranspose(GraphAdj graph){
        int[] mainnodes= new int[graph.nodes.length];
        for (int i = 0;i<mainnodes.length;i++){
            mainnodes[i]=graph.nodes[i].data;
        }
        GraphAdj grapht=new GraphAdj(mainnodes);
        
        
        for (int i = 0;i<mainnodes.length;i++){
            graphNodeAdj temp = graph.nodes[i];
            for (graphNodeAdj v:temp.adjList){
            
                grapht.addDirecEdge(v.Label, i);
                
            
            
            }
        } 
        
        
        
        return grapht;
        
    }
   
}

