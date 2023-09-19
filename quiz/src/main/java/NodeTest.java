public class NodeTest {
    public static void main(String[] args) {
        // 创建链表 l1，表示较大的数 987
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);
        l1.next.next = new ListNode(7);

        // 创建链表 l2，表示较小的数 512
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(2);

        // 调用相减函数
        ListNode result = subtract(l1, l2);

        // 打印结果
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }
        System.out.println("null");
    }


    public static ListNode subtract(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int difference = x - y - carry;
            if (difference < 0) {
                difference += 10;
                carry = 1;
            } else {
                carry = 0;
            }

            current.next = new ListNode(difference);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }
}
