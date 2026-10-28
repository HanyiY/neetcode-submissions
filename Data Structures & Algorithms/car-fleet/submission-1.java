class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        double prevTime = 0;
        for (int[] car: cars) {
            double time = (double) (target - car[0]) / car[1];
            //没追上前车
            if (time > prevTime) {
                prevTime = time;
                fleets++;
            }else{ // 追上
                //还是prevtime，因为被拖累了，同一批车流，没有产生新的车流
            } 
        }

        return fleets;
    }
}
