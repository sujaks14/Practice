package test.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Stratos Dev on 6/14/17.
 */
public class FindIfRouteExists {

    static class Node {
        boolean visited;
        String value;
        List<Node> adjacents = new ArrayList<>();
    }


    public static List<Node> populateNodes() {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();
        Node g = new Node();
        Node h = new Node();
        Node m = new Node();

        a.adjacents = new ArrayList<>();
        a.adjacents.add(b);
        a.adjacents.add(h);
        a.adjacents.add(c);

        b.adjacents = new ArrayList<>();
        b.adjacents.add(d);
        b.adjacents.add(e);

        h.adjacents = new ArrayList<>();
        h.adjacents.add(m);

        c.adjacents = new ArrayList<>();
        c.adjacents.add(f);
        c.adjacents.add(g);

        List<Node> nodes = new ArrayList<>();
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        nodes.add(e);
        nodes.add(f);
        nodes.add(g);
        nodes.add(h);
        nodes.add(m);

        return nodes;

    }


    public static boolean routeExist() {


        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();
        Node e = new Node();
        Node f = new Node();
        Node g = new Node();
        Node h = new Node();
        Node m = new Node();

        a.adjacents = new ArrayList<>();
        a.adjacents.add(b);
        a.adjacents.add(h);
        a.adjacents.add(c);

        b.adjacents = new ArrayList<>();
        b.adjacents.add(d);
        b.adjacents.add(e);

        h.adjacents = new ArrayList<>();
        h.adjacents.add(m);

        c.adjacents = new ArrayList<>();
        c.adjacents.add(f);
        c.adjacents.add(g);

        List<Node> nodes = new ArrayList<>();
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        nodes.add(e);
        nodes.add(f);
        nodes.add(g);
        nodes.add(h);
        nodes.add(m);

        LinkedList<Node> queue = new LinkedList<>();
        Node start = a;
        Node end = g;

        queue.add(start);
        while(!queue.isEmpty()) {
            Node curr = queue.removeFirst();
            System.out.println("curr:"+ curr);
            if(!curr.visited) {
                if (curr == end)
                    return true;

                curr.visited = true;

                for (Node n : curr.adjacents) {
                    queue.add(n);
                }
            }
        }
        return false;
        }

    public static void main(String[] args) {
        System.out.println("enters main");
        System.out.println("routeExist->" +routeExist());
        System.out.println("exits main");
    }
}
