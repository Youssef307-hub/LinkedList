public class Main {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        list.insertAtFirst('A');
        list.insertAtFirst('B');
        list.insertAtFirst('C');

        list.print();
        list.insertAtLast('D');
        list.insertAtLast('E');
        list.print();

        list.insertAtIndex(2,'Y');
        list.print();

        list.insertAtIndex(0,'H');
        list.print();

        list.insertAtIndex(6, 'X');
        list.print();

       System.out.println(list.empty());
        System.out.println(list.getLength());

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();
        list.removeFirst();

        list.print();
        System.out.println(list.search('X'));

        list.removeAtIndex(3);
        list.print();

        list.remove('D');
        list.print();

        list.insertAtLast('K');
        list.print();
        System.out.println(list.getAtIndex(2));

    }
}