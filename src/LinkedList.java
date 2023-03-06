public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    LinkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Method checks whether the list is empty or not
     * @return Boolean value of empty or not
     */
    public boolean empty(){
        return this.head == null;
    }

    /**
     * Method returns the length of the List
     * @return Integer value of list length
     */
    public int getLength(){
        return this.length;
    }

    /**
     * Method to insert items at the first of the list
     * @param element Takes the required item to be pushed to the list of any data type
     */
    public void insertAtFirst(T element){
        Node<T> newNode = new Node<>();
        newNode.setItem(element);
        if(empty()){
            newNode.setNext(null);
            this.head = this.tail = newNode;
        }else {
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.length++;
    }

    /**
     * Method to insert items at the end of the list
     * @param element Takes the required item to be appended to the list of any data type
     */
    public void insertAtLast(T element){
        Node<T> newNode = new Node<>();
        newNode.setItem(element);
        newNode.setNext(null);
        if(empty()){
            this.head = this.tail = newNode;
        }else {
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.length++;
    }

    /**
     * Method to insert item at a certain position in the list
     * @param position Integer value of the position where to insert the item
     * @param element The item to be inserted of any data type
     */
    public void insertAtIndex(int position, T element){
        if(position < 0 || position > this.length){
            System.out.println("Out Of Range!");
        }else if(position == 0) {
            insertAtFirst(element);
        }
        else if (position == this.length) {
            insertAtLast(element);
        }else {
            Node<T> newNode = new Node<>();
            Node currentNode = this.head;
            newNode.setItem(element);
            for (int i = 1 ; i < position ; i++){
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
            this.length++;
        }
    }

    /**
     * Method to print all the list items
     */
    public void print(){
        if(empty()){
            System.out.println("List is Empty!");
        }else{
            Node currentNode = this.head;
            System.out.print("[ ");
            while(currentNode != null){
                if(currentNode != this.tail)
                    System.out.print(currentNode.getItem() + ", ");
                else
                    System.out.print(currentNode.getItem());

                currentNode = currentNode.getNext();
            }
            System.out.println(" ]");
        }
    }

    /**
     * Method returns the item value at certain index
     * @param position Integer value of the item index
     * @return The item value at the given index of any data type
     */
    public T getAtIndex(int position){
        if(empty()) {
            System.out.println("List is Empty!");
            return null;
        } else if (position < 0 || position > (this.length-1) ) {
            System.out.println("Out Of Range!");
            return null;
        }else if(position == 0) {
            return this.head.getItem();
        } else if (position == this.length-1) {
            return this.tail.getItem();
        }else {
            Node<T> currentNode = this.head;
            for (int i = 0 ; i < position ; i++)
                currentNode = currentNode.getNext();

            return currentNode.getItem();
        }
    }

    /**
     * Method removes the first item from the list
     */
    public void removeFirst(){
        if(empty()){
            System.out.println("List is Empty!");
        } else if (this.length == 1) {
            this.head = null;
            this.length--;
        } else {
            this.head = this.head.getNext();
            this.length--;
        }
    }

    /**
     * Method removes the last item from the list
     */
    public void removeLast(){
        if(empty()){
            System.out.println("List is Empty!");
        } else if (this.length == 1) {
            this.head = null;
            this.length--;
        } else {
            Node currentNode = this.head;
            while (currentNode.getNext() != this.tail){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
            this.tail = currentNode;
            this.length--;
        }
    }

    /**
     * Method removes an item from the list from a certain position
     * @param position Integer value of the position where to remove item from the list
     */
    public void removeAtIndex(int position){
        if(empty()) {
            System.out.println("List is Empty!");
        } else if (position < 0 || position > (this.length-1) ) {
            System.out.println("Out Of Range!");
        }else if(position == 0) {
            removeFirst();
        } else if (position == this.length-1) {
            removeLast();
        }else {
            Node currentNode = this.head;
            for (int i = 1 ; i < position ; i++){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(currentNode.getNext().getNext());
            this.length--;
        }
    }

    /**
     * Method removes a certain value from the list
     * @param element The item to be removed from the list of any data type
     */
    public void remove(T element){
        if(empty()) {
            System.out.println("List is Empty!");
        } else if (this.tail.getItem().equals(element)) {
            removeLast();
        } else if (this.head.getItem().equals(element)) {
            removeFirst();
        } else {
            Node previousNode = this.head;
            Node currentNode = this.head.getNext();
            while (currentNode != null){
                if(currentNode.getItem().equals(element)){
                    previousNode.setNext(currentNode.getNext());
                    this.length--;
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
            if(currentNode == null){
                System.out.println("Element not found!");
            }
        }
    }

    /**
     * Method searches for a certain item in the list if the item is not found it returns -1
     * @param element The item to be searched for of any data type
     * @return Integer value of the index of the item that we are searching for
     */
    public int search(T element){
        if(empty()) {
            return -1;
        } else if (this.tail.getItem().equals(element)) {
            return this.length-1;
        } else if (this.head.getItem().equals(element)) {
            return 0;
        } else {
            int index = 1;
            Node currentNode = this.head.getNext();
            while (currentNode != null) {
                if (currentNode.getItem().equals(element)) {
                    return index;
                }
                index++;
                currentNode = currentNode.getNext();
            }
            return -1;
        }
    }

}
