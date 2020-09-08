package test;

import graph.BreadFirstSearch;
import graph.Graph;

public class BfsGraphNo {

    public static void main(String[] args) {
        Graph g = new Graph(13);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,5);
        g.addEdge(0,6);
        g.addEdge(5,3);
        g.addEdge(5,4);
        g.addEdge(3,4);
        g.addEdge(4,6);
        g.addEdge(7,8);
        g.addEdge(9,10);
        g.addEdge(9,11);
        g.addEdge(9,12);
        g.addEdge(11,12);

        BreadFirstSearch bsearch = new BreadFirstSearch(g,0);

        System.out.println("数量：" + bsearch.getCount());
        System.out.println(bsearch.getMarked(8));
        System.out.println(bsearch.getMarked(1));
    }


}
