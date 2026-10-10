class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> visited = new HashSet<>();
        while (visited.add(n)) {
            n = getNext(n);
        }
        if (visited.contains(1))    return true;
        else return false;
    }

    private int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }
        return sum;
    }
}
