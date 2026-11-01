class WordDictionary {

    class TrieNode {
        Map<Character, TrieNode> childMap = new HashMap<>();
        boolean isEnd;
    }
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (Character c: word.toCharArray()) {
            cur.childMap.putIfAbsent(c, new TrieNode());
            // cur.childMap.put('.', new TrieNode());
            cur = cur.childMap.get(c);
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return dfs (word, 0, root);
        // TrieNode cur = root;
        // for (Character c: word.toCharArray()) {
        //     if (c != '.') {
        //         if (!cur.childMap.containsKey(c))  return false;
        //         cur = cur.childMap.get(c);
        //     }
        //     else {
        //         if (cur.childMap.isEmpty())   return false;
        //         for (Character key: cur.childMap.keySet()) {
        //             cur = cur.childMap.get(key);                   
        //         }
        //     }
        // }
        // return true;
    }
    // dictionary: bcd; bc   dfs(bc, 0, root)
    private boolean dfs (String word, int index, TrieNode node) {
        if (index == word.length())     return node.isEnd;
        // if (node.childMap.isEmpty())    return false;
        Character c = word.charAt(index);
        if (c != '.') {
            if (!node.childMap.containsKey(c))  return false;
            return dfs (word, index + 1, node.childMap.get(c));
        }
        else {
            for (TrieNode child: node.childMap.values()) {
                if (dfs (word, index + 1, child))  return true;
            }
        } 
        return false;
    }
}
