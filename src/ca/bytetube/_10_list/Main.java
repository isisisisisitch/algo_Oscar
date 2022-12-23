package ca.bytetube._10_list;


import ca.bytetube._10_list.singly.SingleCircularLinkedList;
import ca.bytetube._10_list.singly.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
//        //int[] arr = {10,20,30,40};
//        ArrayList arrayList = new ArrayList();
//        test3();
//          test4();
        test5();


    }

    public static void test5() {
        SingleCircularLinkedList list = new SingleCircularLinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i + 10);
        }

        list.add(list.size,55);

        System.out.println("end");
    }


    public static void test4() {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i + 10);
        }

        Object remove = list.remove(5);
        int index = list.indexOf(16);
        System.out.println(index);
    }


    public static void test3() {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < 10; i++) {
            list.add(i + 10);
        }

        System.out.println("end");
    }

    public static void test(List list) {
        list.remove(10);
    }

    public static void test2() {
//      LinkedList linkedList = new LinkedList();
//        linkedList.
    }

    public static void test1() {
//       Collection<Integer> collection = new LinkedList<>();
//       ArrayList list = new ArrayList(collection);
//
//       System.out.println("end");
    }
}
