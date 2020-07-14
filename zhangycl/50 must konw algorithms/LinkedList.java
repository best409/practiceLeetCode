package com.geekUniversity.base;

/**[1] Tutorials. Data Structures[M]. geeksforgeeks, 2020.
 * @author: zhangycl  by  geeksforgeeks
 * @date: 2020/7/13
 * @description:  Linked List 的标准实现代码
 *                 1. 插入新节点 insert(LinkedList list, int data)
 *                 2. 遍历链表   printList(LinkedList list)
 *                 3. 通过节点值删除  deleteByKey(LinkedList list, int key)
 *                 4. 通过节点索引删除 deleteAtPosition(LinkedList list, int index)
 */
public class LinkedList {

    Node head; //head of list

    //Linked list Node
    //This inner class is made static
    // so that main() can access it
    static class Node {
        int data;
        Node next;

        //Constructor
        Node(int d) {
            data = d;
            next  = null;
        }
    }

    //Method to insert a new node
    public static LinkedList insert(LinkedList list, int data) {
        //Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        //If the Linked List is empty,
        //then make the new node as head
        if (list.head == null) {
            list.head = new_node;
        }else {
            //Else traverse till the last node and insert the new_node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            //Insert the new_node at last node
            last.next = new_node;
        }
        //Return the list by head
        return list;
    }

    //Method to print the LinkedList
    public static void printList(LinkedList list) {

        Node currNode = list.head;

        System.out.println("LinkedList: ");

        //Traverse through the LinkedList
        while (currNode != null) {
            //Print the data at current node
            System.out.println(currNode.data + " ");

            //Go to next node
            currNode = currNode.next;
        }


    }


    //Method to delete a node in the LinkedList by Key
    public static LinkedList deleteByKey(LinkedList list, int key) {
        //Store head node
        Node currNode  = list.head;
        Node prev = null;

        /*
        * CASE 1:
        * If head node itself holds the key to be deleted
        * */
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head

            //Display the message
            System.out.println(key +" found and deleted");

            //Return the updated list
            return list;
        }

        /*
        * CASE 2:
        * If the key is somewhere other than at head
        *
        * Search for the key to be deleted, keep track of the previous node
        * at it is needed to change currNode.next
        * */
        while (currNode != null && currNode.data != key) {
            //If currNode does not hold key continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        //If the key as present, it should be at currNode
        //Therefore the currNode shall not be null
        if (currNode != null) {
            //Since the key is at currNode unlink currNode from linked list
            prev.next = currNode.next;

            //Display the message
            System.out.println(key + " found and deleted");
        }

        /*
        * CASE 3: The key is not present
        *
        * If key was not present in linked list currNode should be null
        * */
        if (currNode == null) {
            //Display the message
            System.out.println(key + " not found");
        }

        //return the list
        return list;

    }


    //Method to delete a node in the LinkedList by position
    public static LinkedList deleteAtPosition(LinkedList list, int index) {
        //Store head node
        Node currNode = list.head;
        Node prev = null;

        /*
        * CASE 1:
        * If index is 0, then head node itself is to be deleted
        *
        * */
        if (index == 0 && currNode != null) {
            list.head = currNode.next; //Changed head

            //Display the message
            System.out.println(index + " position element deleted");

            //Return the upadate list
            return list;
        }

        /*
        * CASE 2: If the index is greater than 0 but less than the size of the counter
        *
        * */
        int counter = 0;

        /*
        *Count for the index to  be delted, keep track of the previous node
        * as it is needed to change currNode.next
         */
        while (currNode != null) {
            if (counter == index) {
                //Since the currNode is the required position unlink currNode form linked list
                prev.next = currNode.next;

                //Dispaly the message
                System.out.println(index + " position element deleted");
                break;
            }else {
                //if current position is not the index continue to next node
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }


        /*
        * If the position element was found, it should be at currNode
        * Therefore the currNode shall not be null
        *
        *CASE 3: The index is greater than the size of the
        * */
        if (currNode == null) {
            //Display the message
            System.out.println(index + " position element not found");
        }

        //reutrn the list
        return list;

    }


    //Driver code
    public static void main(String[] args) {

        //Start with the empty list
        LinkedList list = new LinkedList();

        //***********IINSERTION***********

        //Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        //Print the LinkedList
        printList(list);

        //***********DELETETION BY KEY***********

        /*
        * Delete node with value 1
        * In this case the key is  *at head*
        * */
        deleteByKey(list, 1);

        //Print the LinkedList
        printList(list);

        /*
        * Delete node with value 4
        * in this case the key is present *in the middle*
        * */
        deleteByKey(list, 4);

        //Print the LinkedList
        printList(list);

        /*
        * Delete node with value 10
        * in this case the key is *not present*
        * */
        deleteByKey(list, 10);

        //Print the LinkedList
        printList(list);

        //***********DELETION AT POSITION***********

        /*
        * delete node at position 0 in this case the key is *at head*
        * */
        deleteAtPosition(list, 0);

        //Print the LinkedList
        printList(list);

        /*
        * delete node at position 2
        * In this case the key is present *in the middle*
        * */
        deleteAtPosition(list, 2);

        //Print the LinkedList
        printList(list);

        /*
        * Delete node at position 10
        * In this case the key is *not present*
        * */
        deleteAtPosition(list, 10);

        //Print the LinkedList
        printList(list);

    }

}
