class RandomizedSet {

    private HashMap<Integer, Integer> database;
    private List<Integer> helper;
    private static int ptr;

    public RandomizedSet() {

        this.database = new HashMap<>();
        ptr = 0;
        this.helper = new ArrayList<>();
    }

    public boolean insert(int val) {

        if (database.containsKey(val))
            return false;

        database.put(val, ptr++);
        helper.add(val);
        return true;
    }

    public boolean remove(int val) {

        if (!database.containsKey(val))
            return false;

        int idx = database.get(val);
        helper.set(idx, -1);
        database.remove(val);

        return true;
    }

    public int getRandom() {

        HashSet<Integer> seen = new HashSet<>();
        while (true) {

            int rI = (int) (Math.random() * ptr);

            if (helper.get(rI) != -1)
                return helper.get(rI);

            if (!seen.contains(rI))
                seen.add(rI);

            if (seen.size() == helper.size())
                return -1;
        }
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
