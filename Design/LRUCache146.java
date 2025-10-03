class LRUCache {

    private LinkedHashMap<Integer, Integer> map;
    private int limit;

    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>(capacity, 0.75f, true);
        this.limit = capacity;
    }

    public int get(int key) {

        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            if (map.size() == limit) {
                Iterator<Integer> it = map.keySet().iterator();

                if (it.hasNext())
                    map.remove(it.next());
            }
            map.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);

 class LRUCache {

    private final LinkedHashMap<Integer,Integer> map;
    private final int limit;

    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<>(capacity,0.75f,true);
        this.limit = capacity;
    }
    
    public int get(int key) {
        
         return map.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key)){
             map.put(key,value);
        }
        else{
            if(map.size() == limit){
                Iterator<Integer> it = map.keySet().iterator();

                if(it.hasNext())
                   map.remove(it.next());
            }
            map.put(key,value);
        }   
    }
}

 */
