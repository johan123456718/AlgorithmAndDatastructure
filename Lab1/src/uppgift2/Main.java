package uppgift2;

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
        /*SingleLinkedList<Object> list = new SingleLinkedList();
        System.out.println("-----------ADD CHECK STRINGs-------------");
        list.add("lol");
        list.add(0,"hej"); //1
        list.add(1,"då"); //2
        list.add(2, "shululul"); //3
        list.add(3,"wwwww"); // 4
        list.add(0, "hehehe"); //0
        System.out.println(list);
        System.out.println("------------------------");
        
        System.out.println("-----------GET-------------");
        System.out.println("get(0): " + list.get(0));
        System.out.println("get(1): " + list.get(1));
        System.out.println("get(2): " + list.get(2));
        System.out.println("get(3): " + list.get(3));
        System.out.println("get(4): " + list.get(4));
        System.out.println("get(5): " + list.get(5));
        System.out.println(list);
        System.out.println("------------------------");
        
        // hehehe (borta när list.remove(0)) => hej (0)=> shulululu(2) => wwww(3) i det här fallet
        System.out.println("-----------REMOVE-------------");
        list.remove(0); //Removes "hehehe"
        list.remove(2); //Removes "shuulululu"
        list.remove(3); ///Remove "wwwww"
        System.out.println(list);
        System.out.println("getHeadAfter: " + list.getHead());
        System.out.println("getTailAfter: " + list.getTail());
        System.out.println("------------------------");
        
        System.out.println("-----------LIST-------------");
        System.out.println(list);
        System.out.println("Size: " + list.getSize());
        System.out.println("------------------------");
        
        System.out.println("ITERATOR");
        Iterator<Object> iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        
        System.out.println("-----------CLEAR-------------");
        list.clear();
        System.out.println(list);
        System.out.println("------------------------");
        
        System.out.println("---------------------------------------");
        
        System.out.println("-----------ADD CHECK Ints-------------");
        list = new SingleLinkedList();
        list.add(3);
        list.add(0,5); //1
        list.add(1,8); //2
        list.add(2, 1); //3
        list.add(3,9); // 4
        list.add(0, 2); //0
        System.out.println(list);
        System.out.println("------------------------");
        
        
        System.out.println("-----------GET-------------");
        System.out.println("get(0): " + list.get(0));
        System.out.println("get(1): " + list.get(1));
        System.out.println("get(2): " + list.get(2));
        System.out.println("get(3): " + list.get(3));
        System.out.println("get(4): " + list.get(4));
        System.out.println("get(5): " + list.get(5));
        System.out.println(list);
        System.out.println("------------------------");
        
        
        // hehehe (borta när list.remove(0)) => hej (0)=> shulululu(2) => wwww(3) i det här fallet
        System.out.println("-----------REMOVE-------------");
        list.remove(0); //Removes "hehehe"
        list.remove(2); //Removes "shuulululu"
        list.remove(3); ///Remove "wwwww"
        System.out.println(list);
        System.out.println("getHeadAfter: " + list.getHead());
        System.out.println("getTailAfter: " + list.getTail());
        System.out.println("------------------------");
        
        System.out.println("-----------LIST-------------");
        System.out.println(list);
        System.out.println("Size: " + list.getSize());
        System.out.println("------------------------");
        
        System.out.println("ITERATOR");
        iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        
        System.out.println("-----------CLEAR-------------");
        list.clear();
        System.out.println(list);
        System.out.println("------------------------");
        
        System.out.println("-----------ADD CHECK STRING COMBINED WITH INTS-------------");
        list = new SingleLinkedList();
        list.add(3);
        list.add(0,"t"); //1
        list.add(1,"o"); //2
        list.add(2, "tomte"); //3
        list.add(3,"lollipop"); // 4
        list.add(0, 2); //0
        list.add(0, 8); //0
        list.add(0, 0); //0
        System.out.println(list);
        System.out.println("------------------------");
        
        
        System.out.println("-----------GET-------------");
        System.out.println("get(0): " + list.get(0));
        System.out.println("get(1): " + list.get(1));
        System.out.println("get(2): " + list.get(2));
        System.out.println("get(3): " + list.get(3));
        System.out.println("get(4): " + list.get(4));
        System.out.println("get(5): " + list.get(5));
        System.out.println(list);
        System.out.println("------------------------");
        
        
        // hehehe (borta när list.remove(0)) => hej (0)=> shulululu(2) => wwww(3) i det här fallet
        System.out.println("-----------REMOVE-------------");
        list.remove(0); //Removes "hehehe"
        list.remove(2); //Removes "shuulululu"
        list.remove(3); ///Remove "wwwww"
        System.out.println(list);
        System.out.println("getHeadAfter: " + list.getHead());
        System.out.println("getTailAfter: " + list.getTail());
        System.out.println("------------------------");
        
        System.out.println("-----------LIST-------------");
        System.out.println(list);
        System.out.println("Size: " + list.getSize());
        System.out.println("------------------------");
        
        System.out.println("ITERATOR");
        iter = list.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
        
        System.out.println("-----------CLEAR-------------");
        list.clear();
        System.out.println(list);
        System.out.println("------------------------");*/

 /* for(int i= 0; i<4; i++){
            list.add("e" + i);
        }
        list.remove(3);
        list.add(0, "först");
        list.add("sist");
         System.out.println(list);*/
 
 
 
 
 /*for (int i = 0; i < 10; i++) {
            test.add(i + 1);
        }
        System.out.println(test);
        test.add(0, 0);
        System.out.println(test);
        System.out.println(test.getData(10) + ". Size: " + test.getSize());
        test.remove(10);
        System.out.println(test + " Size: " + test.getSize());
        test.remove(8);
        System.out.println(test + " Size: " + test.getSize());
        test.remove(0);
        System.out.println(test + " Size: " + test.getSize());*/
 
        SingleLinkedList<String> l = new SingleLinkedList();
        for(int i = 0; i < 4; i++){
            l.add("e" + i);
        }
        l.remove(3);
        l.add(0,"först");
        l.add("sist");
        System.out.println(l);
    }

}
