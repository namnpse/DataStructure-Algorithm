package com.leetcode.dsajava.sort.interview;

class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    // WRITE BUBBLESORT METHOD HERE //
    //                              //
    //                              //
    //                              //
    //                              //
    //////////////////////////////////

    private void swap(Node a, Node b) {
        int t = a.value;
        a.value = b.value;
        b.value = t;
    }

    public void bubbleSort() {
        if(length < 2) return;
        Node i = head;
        while (i != null) {
            Node j = i.next;
            while(j != null) {
                if(j.value < i.value) {
                    swap(j, i);
                }
                j = j.next;
            }
            i = i.next;
        }
        printList();
    }

    // WRITE SELECTIONSORT METHOD HERE //
    //                                 //
    //                                 //
    //                                 //
    //                                 //
    /////////////////////////////////////

    public void selectionSort() {
        if(length < 2) return;
        Node i = head;
        while (i != null) {
            Node minNode = i;
            Node j = i.next;
            while(j != null) {
                if(j.value < minNode.value) {
                    minNode = j;
                }
                j = j.next;
            }
            if(minNode != i) {
                swap(minNode, i);
            }
            i = i.next;
        }
        printList();
    }

    // WRITE INSERTIONSORT METHOD HERE //
    //                                 //
    //                                 //
    //                                 //
    //                                 //
    /////////////////////////////////////

    public void insertionSort() {
        // If the list has less than 2 elements, it is already sorted
        if (length < 2) {
            return;
        }

        // Start with a sorted list containing only the first element
        Node sortedListHead = head;

        // Start with the second element in the unsorted list
        Node unsortedListHead = head.next;

        // Mark the end of the sorted list
        sortedListHead.next = null;

        // Iterate over the unsorted list
        while (unsortedListHead != null) {

            // Take the first element in the unsorted list
            Node current = unsortedListHead;

            // Move to the next element in the unsorted list
            unsortedListHead = unsortedListHead.next;

            // If the current element is smaller than the first element of the sorted list
            if (current.value < sortedListHead.value) {
                // Insert the current element at the beginning of the sorted list
                current.next = sortedListHead;
                // Update the sorted list head
                sortedListHead = current;
            } else {
                // Start at the beginning of the sorted list
                Node searchPointer = sortedListHead;

                // Search for the correct insertion point
                while (searchPointer.next != null && current.value > searchPointer.next.value) {
                    // Move to the next element in the sorted list
                    searchPointer = searchPointer.next;
                }

                // Insert the current element after searchPointer
                current.next = searchPointer.next;
                searchPointer.next = current;
            }
        }

        // Update the head of the sorted list
        head = sortedListHead;

        // Update the tail of the sorted list
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        tail = temp;
        printList();
    }

    public void merge(LinkedList otherList) {
        if(otherList.head == null) return;
        LinkedList l1 = null;
        if(head != null) {
            l1 = new LinkedList(head.value);
            Node t1 = head.next;
            while (t1 != null) {
                l1.append(t1.value);
                t1 = t1.next;
            }
        }
        makeEmpty();
        Node i = l1.head;
        Node j = otherList.head;
        while (i != null && j != null) {
            if(i.value < j.value) {
                append(i.value);
                i = i.next;
            }else {
                append(j.value);
                j = j.next;
            }
        }
        while(i != null) {
            append(i.value);
            i = i.next;
        }
        while(j != null) {
            append(j.value);
            j = j.next;
        }
    }
}
