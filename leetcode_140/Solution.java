/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {

    // another method use heap
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists == null || lists.isEmpty()) return null;
        
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2){
                return l1.val-l2.val;
            }
        };
        
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);
        
        for (ListNode node : lists){
            if(node!=null){
                heap.add(node);
            }
        }
        
        // the meat part
        ListNode root = null, cur = null;
        while(!heap.isEmpty()){
            if(root == null){
                root = heap.poll();
                cur = root;
            } else {
                cur.next = heap.poll();
                cur = cur.next;
            }
            if (cur.next != null) heap.add(cur.next); 
        }
        
        return root;
    }
}