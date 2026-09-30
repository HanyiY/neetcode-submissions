class Solution {
    // public int leastInterval(char[] tasks, int n) {
    //     int res = 0;
    //     char[] taskNum = new char[26];
    //     int numOfTasksRemain = tasks.length;
    //     PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(taskNum[b], taskNum[a]));
    //     for (char task: tasks){
    //         taskNum[task - 'A']++;
    //     }
    //     Map<Character, Integer> coolDownMap = new HashMap<>();
    //     while (numOfTasksRemain > 0) {
    //         for (coolDownMap.get())
    //         // there is doable task
    //         if (maxHeap.size() > 0) {
    //             char action = maxHeap.poll();
    //             coolDownMap.put(action, 0);
    //             taskNum[action]--;
    //             numOfTasksRemain--;
    //         }
    //         // idle cycle
    //         else {

    //         }
            
    //     }

    // } 错了


     // 最多的task先做，然后第二，三。。。顶上，如果冷却好了回到最多的顶上
        //  A A A A B B B C C D n = 2
        //  A B C D A B C A B i A
        //  A B C A B C A B D A  MIN!
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (char t : tasks) cnt[t - 'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : cnt) if (c > 0) maxHeap.offer(c);

        Queue<int[]> cooldown = new ArrayDeque<>(); // {remainingCount, readyTime}
        int time = 0;
        // 还有任务要做
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {    
            // TODO 1: 队首冷却好了吗？好了就放回 maxHeap
            if (!cooldown.isEmpty() && cooldown.peek()[1] <= time) {
                maxHeap.offer(cooldown.poll()[0]);
            }
            // TODO 2: 堆非空 → poll 一个 c，做一次
            //         如果 c-1 > 0，放进 cooldown，readyTime = ?
            if (!maxHeap.isEmpty()) {
                int curCount = maxHeap.poll();
                if (curCount - 1 > 0) {
                    cooldown.offer(new int[]{curCount - 1, time + n + 1});
                }
            }
            // 堆为空 → 什么都不用做，time++ 本身就是 idle
            time++;
        }
        return time;
    }
    

}
