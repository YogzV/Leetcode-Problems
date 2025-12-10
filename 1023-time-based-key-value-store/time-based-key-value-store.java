class TimeMap {

    Map<String,List<Pair<String,Integer>>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap.putIfAbsent(key,new ArrayList<>());
        timeMap.get(key).add(new Pair<>(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        int start = 0;
        List<Pair<String,Integer>> arr = timeMap.getOrDefault(key,new ArrayList<>());
        int end = arr.size()-1;
    
        int mid;
        int ind = -1;
        while(start <= end)
        {
            mid = (start+end)/2;
            if(arr.get(mid).getValue() == timestamp)
            {
                ind = mid;
                break;
            }else if(arr.get(mid).getValue() < timestamp){
                ind = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        if(ind == -1) return "";
        return arr.get(ind).getKey();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */