package com.company;

class ListNode {

    public ListNode(Object theElement) {
        this(theElement, null);
    }

    public ListNode(Object theElement, ListNode n) {
        element = theElement;
        next = n;
    }

    public Object element;
    public ListNode next;
}

// ******************PUBLIC OPERATIONS*********************
// void advance( )        --> Переключает указатель на следующий элемент
// boolean isValid( )     --> Существование
// Object retrieve        --> Значение элемента

class LinkedListIterator {

    LinkedListIterator(ListNode theNode) {
        current = theNode;
    }

    public boolean isValid() {
        return current != null;
    }

    public Object retrieve() {
        return isValid() ? current.element : null;
    }

    public void advance() {
        if (isValid())
            current = current.next;
    }

    ListNode current;
}
// ******************PUBLIC OPERATIONS*********************
// boolean isEmpty( )     --> Возвращает true если лист пуст, иначе false
// void makeEmpty( )      --> Удаление всего списка
// LinkedListIterator zeroth( )
//                        --> Возвращает нулевую позицию
// LinkedListIterator first( )
//                        --> Возвращает первую позицию
// void insert( x, p )    --> Вставляет элемент со значением х после элемента р
// void remove( x )       --> Удаляет элемент со значением х
// LinkedListIterator find( x )
//                        --> Возвращает позицию x
// LinkedListIterator findPrevious( x )
//                        --> Возвращает позицию перед x

public class LinkedList {

    private final ListNode header;

    public LinkedList() {
        header = new ListNode(null);
    }

    public boolean isEmpty() {
        return header.next == null;
    }

    public void makeEmpty() {
        header.next = null;
    }

    public LinkedListIterator zeroth() {
        return new LinkedListIterator(header);
    }

    public LinkedListIterator first() {
        return new LinkedListIterator(header.next);
    }

    public void insert(Object x, LinkedListIterator p) {
        if (p != null && p.current != null)
            p.current.next = new ListNode(x, p.current.next);
    }

    public LinkedListIterator find(Object x) {
        ListNode itr = header.next;
        while (itr != null && !itr.element.equals(x))
            itr = itr.next;
        return new LinkedListIterator(itr);
    }

    public LinkedListIterator findPrevious(Object x) {
        ListNode itr = header;
        while (itr.next != null && !itr.next.element.equals(x))
            itr = itr.next;
        return new LinkedListIterator(itr);
    }

    public void remove(Object x) {
        LinkedListIterator p = findPrevious(x);
        if (p.current.next != null)
            p.current.next = p.current.next.next;  // Bypass deleted node
    }

    public static void printList(LinkedList theList) {
        if (theList.isEmpty())
            System.out.print("Empty list");
        else {
            LinkedListIterator itr = theList.first();
            for (; itr.isValid(); itr.advance())
                System.out.print(itr.retrieve() + " ");
        }
        System.out.println();
    }

    public static int listSize(LinkedList theList) {
        LinkedListIterator itr;
        int size = 0;
        for (itr = theList.first(); itr.isValid(); itr.advance())
            size++;
        return size;
    }
}
