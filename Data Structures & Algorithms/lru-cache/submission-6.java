//map = “key → 节点”的快速索引 （O1）, 双向链表 = 节点的顺序 （O1）,value 住在节点里。
class LRUCache {
    private static class Node {
        int K, V;
        Node prev, next;
        Node (int K, int V) {
            this.K = K;
            this.V = V;
        }
    }
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail; // dummy sentinels

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key))  return -1;
        Node res = map.get(key);
        removeNode(res);
        insertToHead(res);
        return res.V;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.V = value;
            removeNode(cur);
            insertToHead(cur);
        }else {
            Node newNode = new Node(key, value);
            insertToHead(newNode);
            map.put(key, newNode);
            if (map.size() > capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.K);
            }
        }
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    private void insertToHead(Node node) {
        node.next = head.next;        
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
}
