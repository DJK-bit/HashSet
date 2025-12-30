/**
 * Implementation of a Hashset includes adding, deleting vals to the set.
 */
public class MyHashSet {

    ListNode[] bucket;

    MyHashSet (int capacity) {
        bucket = new ListNode[capacity];
    }

    /**
    * Hash returns the needed index for the hashset.
    */
    public int hash (int val) {
        int index = Math.abs(val) % bucket.length;
        return index;
    }

    /**
    * Contains returns true or false for containing a value.
    */
    public boolean contains (int val) {
        int index = hash(val);

        ListNode current = bucket[index];

        while (current != null) {
            if (current.data == val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
    * The method add, adds a value to the bucket.
    */
    public void add (int val) {
        int index = hash(val);

        ListNode current = bucket[index];

        while (current != null) {
            if (current.data == val) {
                return;
            }
            current = current.next;
        }

        ListNode newHead = new ListNode(val);
        newHead.next = bucket[index];
        bucket[index] = newHead;
    }
    /**
    * The method remove, removes a value from the bucket.
    */
    public void remove (int val) {
        int index = hash(val);

        ListNode current = bucket[index];

        if (current == null) {
            return;
        }

        if (current.data == val) {
            bucket[index] = current.next;
            return;
        }

        while (current.next != null) {
            if (current.next.data == val) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

}
