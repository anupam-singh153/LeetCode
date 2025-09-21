import java.util.*;

class ProductOfNumbers {
    private List<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1); // base case
    }

    public void add(int num) {
        if (num == 0) {
            prefix.clear();
            prefix.add(1); // reset after zero
        } else {
            int last = prefix.get(prefix.size() - 1);
            prefix.add(last * num);
        }
    }

    public int getProduct(int k) {
        int size = prefix.size();
        if (k >= size)
            return 0; // zero included in window
        int last = prefix.get(size - 1);
        int prev = prefix.get(size - 1 - k);
        return last / prev;
    }
}
