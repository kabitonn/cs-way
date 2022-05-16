package com.vika.way.pre.algorithm.nowcoder.swordoffer;

import com.vika.way.pre.algorithm.nowcoder.datastructure.RandomListNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RandomListNodeClone {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        return clone(pHead, map);
    }

    public RandomListNode clone(RandomListNode p, Map<RandomListNode, RandomListNode> map) {
        if (p == null) {
            return null;
        }
        if (map.containsKey(p)) {
            return map.get(p);
        }
        RandomListNode node = new RandomListNode(p.label);
        map.put(p, node);
        node.next = clone(p.next, map);
        node.random = clone(p.random, map);
        return node;
    }

    public RandomListNode Clone1(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = pHead;
        map.put(p, new RandomListNode(p.label));
        while (p != null) {
            if (p.next != null) {
                if (!map.containsKey(p.next)) {
                    map.put(p.next, new RandomListNode(p.next.label));
                }
                map.get(p).next = map.get(p.next);
            }
            if (p.random != null) {
                if (!map.containsKey(p.random)) {
                    map.put(p.random, new RandomListNode(p.random.label));
                }
                map.get(p).random = map.get(p.random);
            }
            p = p.next;
        }
        return map.get(pHead);
    }

    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = pHead;
        while (p != null) {
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }
        p = pHead;
        while (p != null) {
            if (p.next != null) {
                map.get(p).next = map.get(p.next);
            }
            if (p.random != null) {
                map.get(p).random = map.get(p.random);
            }
            p = p.next;
        }
        return map.get(pHead);
    }

    public RandomListNode Clone3(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode l1 = pHead;
        RandomListNode l2;
        while (l1 != null) {
            l2 = new RandomListNode(l1.label);
            l2.next = l1.next;
            l1.next = l2;
            l1 = l2.next;
        }
        l1 = pHead;
        while (l1 != null) {
            l2 = l1.next;
            l2.random = l1.random != null ? l1.random.next : null;
            l1 = l2.next;
        }
        RandomListNode newHead = pHead.next;
        l1 = pHead;
        while (l1 != null) {
            l2 = l1.next;
            l1.next = l2.next;
            l2.next = l2.next != null ? l2.next.next : null;
            l1 = l1.next;
        }
        return newHead;
    }

    public RandomListNode Clone4(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode l1 = pHead;
        RandomListNode l2;
        while (l1 != null) {
            l2 = new RandomListNode(l1.label);
            l2.next = l1.random;
            l1.random = l2;
            l1 = l1.next;
        }
        l1 = pHead;
        while (l1 != null) {
            l2 = l1.random;
            l2.random = l2.next != null ? l2.next.random : null;
            l1 = l1.next;
        }
        RandomListNode newHead = pHead.random;
        l1 = pHead;
        while (l1 != null) {
            l2 = l1.random;
            l1.random = l2.next;
            l2.next = l1.next != null ? l1.next.random : null;
            l1 = l1.next;
        }
        return newHead;
    }

    /**
     * 不能最后恢复random，恢复random是无序的，会出现先置空导致random更新错误
     * @param pHead
     * @return
     */
    public RandomListNode Clone5(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode l1 = pHead;
        RandomListNode l2;
        while (l1 != null) {
            l2 = new RandomListNode(l1.label);
            l2.random = l1.random;
            l1.random = l2;
            l1 = l1.next;
        }
        l1 = pHead;
        while (l1 != null) {
            l2 = l1.random;
            l2.next = l1.next != null ? l1.next.random : null;
            l1 = l1.next;
        }
        RandomListNode newHead = pHead.random;
        l1 = pHead;
        while (l1 != null) {
            l2 = l1.random;
            l1.random = l2.random;
            l2.random = l2.random != null ? l2.random.random : null;
            l1 = l1.next;
        }
        return newHead;
    }

    @Test
    public void test() {
        RandomListNode[] listNodes = new RandomListNode[5];
        listNodes[0] = new RandomListNode(7);
        listNodes[1] = new RandomListNode(13);
        listNodes[2] = new RandomListNode(11);
        listNodes[3] = new RandomListNode(10);
        listNodes[4] = new RandomListNode(1);
        for (int i = 0; i < 4; i++) {
            listNodes[i].next = listNodes[i + 1];
        }
        listNodes[1].random = listNodes[0];
        listNodes[2].random = listNodes[4];
        listNodes[3].random = listNodes[2];
        listNodes[4].random = listNodes[0];
        RandomListNode node = Clone5(listNodes[0]);
        while (node != null) {
            System.out.println(node);
            System.out.println(node.label);
            System.out.println(node.random);
            System.out.println("******");
            node = node.next;
        }
    }

}
