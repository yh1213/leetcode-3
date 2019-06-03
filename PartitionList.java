/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes
 * greater than or equal to x.
 *
 * <p>You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * <p>For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 */
public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode start = new ListNode(0);
    start.next = head;
    ListNode slow = start;
    while (slow.next != null) {
      if (slow.next.val < x) {
        slow = slow.next;
      } else {
        break;
      }
    }
    ListNode fast = slow;
    while (fast.next != null) {
      if (fast.next.val >= x) {
        fast = fast.next;
      } else {
        ListNode target = fast.next;
        fast.next = target.next;
        target.next = slow.next;
        slow.next = target;
        slow = slow.next;
      }
    }
    return start.next;
  }
}
