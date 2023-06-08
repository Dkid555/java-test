package com.leet_easy;

//import com.leet_easy.RemoveDupFromLL;

import junit.framework.TestCase;

public class RemoveDupFromLLTest extends TestCase {
    RemoveDupFromLL remove = new RemoveDupFromLL();

    public void testRemoveDuplic() {

        ListNode res = remove.removeDuplic(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3)))));
        for (int x : new int[]{1, 2, 3}
        ) {
            assertEquals(x, res.val);
            res = res.next;
        }

//        assertEquals(new ListNode(1, new ListNode(2, new ListNode(3))), );
    }

    public void testRemoveDuplic2() {
        ListNode res2 = remove.removeDuplic(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(5, new ListNode(5, new ListNode(5, new ListNode(5,
                new ListNode(6, new ListNode(6, new ListNode(7, new ListNode(8,
                        new ListNode(9, new ListNode(10, new ListNode(10,
                                new ListNode(10)))))))))))))))));
        assertEquals("1,2,3,5,6,7,8,9,10", res2.toString().replaceAll(" ", ""));
//        for (int x :new int[]{1,2,3,5,6,7,8,9,10}
//        ) {
//            assertEquals(x, res2.val);
//            res2 = res2.next;
//        }
    }

    public void testRemoveDuplic3() {
        ListNode res3 = remove.removeDuplic(new ListNode(10, new ListNode(10, new ListNode(11, new ListNode(13, new ListNode(14, new ListNode(51)))))));
        assertEquals("10,11,13,14,51", res3.toString().replaceAll(" ", ""));
    }
}