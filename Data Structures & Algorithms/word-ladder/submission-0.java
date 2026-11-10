public class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Queue<String> q = new LinkedList<>();
    // set: unvisited valid words
    Set<String> set = new HashSet<>(wordList);
    q.offer(beginWord);
    set.remove(beginWord);
    int ladderLen = 1;
    while (!q.isEmpty()){
      int size = q.size();
      ladderLen++;
      for (int i = 0; i < size; i++){
        String cur = q.poll();
        for (int j = 0; j < cur.length(); j++){
          char[] arr = cur.toCharArray();
          for (char c = 'a'; c <= 'z'; c++){
            if (c == arr[j]){
              continue;
            }
            arr[j] = c;
            String newWord = new String(arr);
            if (set.contains(newWord)){
              if (newWord.equals(endWord)){
                return ladderLen;
              }
              q.offer(newWord);
              set.remove(newWord);
            }
          }
        }
      }
    }
    return 0;
  }
}