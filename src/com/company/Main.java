package com.company;

public class Main {

    public static void main(String[] args) {
        LinkedList theList = new LinkedList();
        LinkedListIterator theItr;
        int i;
        theItr = theList.zeroth();
        LinkedList.printList(theList);
        for (i = 0; i < 10; i++) {
            theList.insert(i, theItr);
            LinkedList.printList(theList);
            theItr.advance();
        }
        System.out.println("Size was: " + LinkedList.listSize(theList));
        for (i = 0; i < 10; i += 2)
            theList.remove(i);
        theList.remove(3);
        for (i = 0; i < 10; i++)
            if ((i % 2 == 0) == (theList.find(i).isValid()))
                System.out.println("Find fails!");
        System.out.println("Finished deletions");
        LinkedList.printList(theList);
    }
}

