package ch4;

import utils.Graph.Digraph;
import utils.LinkedList.LinkedListUtils;
import utils.LinkedList.SinglyNode;

import java.util.*;

/**
 * List of Depths:
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
 *
 * Use BFS
 */
public class qns3 {

    private static Digraph initTree1() {
        Digraph tree1 = new Digraph(5);
        tree1.addEdge("1", "2");
        tree1.addEdge("2", "3");
        tree1.addEdge("3", "4");
        tree1.addEdge("3", "5");
        return tree1;
    }

    private static Digraph initTree2() {
        Digraph tree2 = new Digraph(8);
        tree2.addEdge("1", "2");
        tree2.addEdge("1", "3");
        tree2.addEdge("2", "4");
        tree2.addEdge("3", "5");
        tree2.addEdge("3", "6");
        tree2.addEdge("4", "7");
        tree2.addEdge("4", "8");
        return tree2;
    }

    private static ArrayList<LinkedList<String>> linkNodes(String root, Digraph tree){
        ArrayList<LinkedList<String>> ans = new ArrayList<LinkedList<String>>();
        HashSet<String> visited = new HashSet<>();
        LinkedHashMap<String, Integer> level = new LinkedHashMap<>();
        Queue<String> queue = new LinkedList<String>();
        int currLevel = 0;
        queue.add(root);
        level.put(root, 0);

        //TODO: Debug BFS implementation
        while(!queue.isEmpty()){
            String currNode = queue.poll();
            visited.add(currNode);
            currLevel = level.get(currNode)+1;
            if(tree.adj(currNode)!=null) {
                for (String neighbour : tree.adj(currNode)) {
                    if (!visited.contains(neighbour)) {
                        visited.add(neighbour);
                        queue.add(neighbour);
                        level.put(neighbour, currLevel);
                    }
                }
            }
        }

        //currLevel represents the no. of linked lists we have
        Set set = level.entrySet();
        Iterator iter = set.iterator();

        Map.Entry temp = null;
        for(int i=0; i<currLevel; i++) {
            LinkedList<String> myLinkedList = new LinkedList<>();
            if(temp!=null){
                myLinkedList.add((String)temp.getKey());
            }
            while (iter.hasNext()) {     //to keep the order
                Map.Entry data = (Map.Entry) iter.next();
                if(data.getValue().equals(i)) {
                    System.out.print(data.getKey() + ": ");
                    myLinkedList.add((String)data.getKey());
                }
                else {
                    temp = data;
                    break;
                }
            }
            ans.add(myLinkedList);
        }
        return ans;

    }

    public static void run() {
        Digraph tree1 = initTree1();
        Digraph tree2 = initTree2();
        ArrayList<LinkedList<String>> linkedLists1 = linkNodes("1", tree1);

        System.out.println(Arrays.toString(linkedLists1.toArray()));

        ArrayList<LinkedList<String>> linkedLists2 = linkNodes("1", tree2);
        System.out.println(Arrays.toString(linkedLists2.toArray()));
    }
}
