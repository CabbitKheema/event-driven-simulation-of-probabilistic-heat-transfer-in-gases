import java.util.Arrays;

public class MinPQTest {
    public static void main(String[] args) {
        MinPQ<Integer> pq = new MinPQ<>();

        // Test isEmpty()
        assert pq.isEmpty() : "Priority queue should be empty initially";

        // Test insert()
        pq.insert(5);
        pq.insert(3);
        pq.insert(8);
        pq.insert(1);
        pq.insert(2);
        pq.insert(7);
        pq.insert(6);
        pq.insert(4);

        assert !pq.isEmpty() : "Priority queue should not be empty after insertions";

        // Test delMin() (should return elements in ascending order)
        int[] expectedOrder = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] actualOrder = new int[8];
        for (int i = 0; i < 8; i++) {
            actualOrder[i] = pq.delMin();
        }

        assert Arrays.equals(expectedOrder, actualOrder) : "delMin() did not return elements in the correct order";

        // Test isEmpty() after deletions
        assert pq.isEmpty() : "Priority queue should be empty after removing all elements";

        System.out.println("All tests passed (1st cycle)!");

        // Test isEmpty()
        assert pq.isEmpty() : "Priority queue should be empty initially";

        // Test insert()
        pq.insert(4);
        pq.insert(6);
        pq.insert(3);
        pq.insert(5);
        pq.insert(1);
        pq.insert(2);
        pq.insert(8);
        pq.insert(7);

        assert !pq.isEmpty() : "Priority queue should not be empty after insertions";

        // Test delMin() (should return elements in ascending order)
        for (int i = 0; i < 8; i++) {
            actualOrder[i] = pq.delMin();
        }

        assert Arrays.equals(expectedOrder, actualOrder) : "delMin() did not return elements in the correct order";

        // Test isEmpty() after deletions
        assert pq.isEmpty() : "Priority queue should be empty after removing all elements";

        System.out.println("All tests passed (2nd cycle)!");
    }
}
