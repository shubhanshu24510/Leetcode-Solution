import java.util.*;
public class Contest384Solution1 {
    public List<List<Integer>> modifiedMatrix(List<List<Integer>> arr) {
        int rows = arr.size();
        int cols = arr.get(0).size();

        List<Integer> maxInColumn = new ArrayList<>(Collections.nCopies(cols, Integer.MIN_VALUE));
        for (int j = 0; j < cols; ++j) {
            for (int i = 0; i < rows; ++i) {
                if (arr.get(i).get(j) > maxInColumn.get(j)) {
                    maxInColumn.set(j, arr.get(i).get(j));
                }
            }
        }

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (arr.get(i).get(j) == -1) {
                    arr.get(i).set(j, maxInColumn.get(j));
                }
            }
        }

        return arr;
    }
}
