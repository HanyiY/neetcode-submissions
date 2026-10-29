class TimeMap {
    Map<String, List<Pair>> timeMap;

    private class Pair {
        String value;
        int timestamp;
        Pair (int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) {
            return "";
        }
        List<Pair> cur = timeMap.get(key);
        int left = 0, right = cur.size() - 1;
        // find largest timestamp <= timestamp
        // 2 3 find 2
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (cur.get(mid).timestamp <= timestamp) {
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        if (cur.get(right).timestamp <= timestamp)    return cur.get(right).value;
        if (cur.get(left).timestamp <= timestamp)    return cur.get(left).value;
        return "";
    }
}
