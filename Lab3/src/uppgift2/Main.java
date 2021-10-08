package uppgift2;

/**
 *
 * @author Johan Challita
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTree<Integer> testTree = new BinarySearchTree();
        testTree.add(4);
        testTree.add(2);
        testTree.add(34);
        testTree.add(-3);
        testTree.add(34);
        testTree.add(7);
        testTree.add(6);
        testTree.add(1);
        testTree.add(5);
        testTree.add(7);
        testTree.add(3);
        testTree.add(12);
        System.out.println("Root: " + testTree.getRoot());
        //System.out.println("find(-6): " + testTree.find(-6)); returns null
        System.out.println("find(2): " + testTree.find(2));
        System.out.println("find(-3): " + testTree.find(-3));
        System.out.println(testTree.maxRec());
        System.out.println(testTree.maxIt());
        System.out.println(testTree.toString());
        
        System.out.println("-----------------");
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.add("johan");
        bst.add("abbe");
        bst.add("berta");
        bst.add("charlie");
        bst.add("erik");
        bst.add("kalle");
        bst.add("fredrik");
        System.out.println("Root: " + bst.getRoot());
        System.out.println("find(fredrik): " + bst.find("fredrik"));
        System.out.println("highest value Iter: " + bst.maxIt());
        System.out.println("highest value Recur: " + bst.maxRec());
        System.out.println(bst.toString());
    }
    
}
