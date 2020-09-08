package test;

import graph.DepthFirstSearch;
import graph.Graph;

public class GraphTestNo {
    public static void main(String[] args) {
        //构建图

        Graph g  = new Graph(13);
        g.addEdge(0,5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,6);
        g.addEdge(5,3);
        g.addEdge(5,4);
        g.addEdge(3,4);
        g.addEdge(7,8);
        g.addEdge(9,10);
        g.addEdge(9,11);
        g.addEdge(9,12);
        g.addEdge(11,12);
        //搜索指定定点连通节点的数量
        DepthFirstSearch search = new DepthFirstSearch(g,0);
        System.out.println("和0节点相连的节点数量: " + search.getCount());
        //判断节点是否连通
        System.out.println("是否和节点6相连: " +  search.getMarked(6));
        System.out.println("是否和节点3相连: " +  search.getMarked(8));  //间接相连

    }
}
