package uppgift3;

import java.util.Iterator;

/**
 *
 * @author Johan Challita
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList();
        for(int i = 0; i < 4; i++){
            list.add("e" + i);
        }
        System.out.println(list);
        Iterator<String> it = list.iterator();
        it.next();
        it.next();
        it.remove();
        //it.next();
      //  it.remove();
        System.out.println(list);

    }
}
