public class MySorts2 {
    public static void mergesort(IList<Integer> list) {
        if (list.size() <= 1) return;
        
        IList<Integer> sorted = mergesortHelper(list);
        for (int i = 0; i < sorted.size(); i++) {
            list.set(i, sorted.get(i));
        }
    }

    private static IList<Integer> mergesortHelper(IList<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }

        IList<Integer> left = getLeftHalf(list);
        IList<Integer> right = getRightHalf(list);

        left = mergesortHelper(left);
        right = mergesortHelper(right);

        return merge(left, right);
    }

    private static IList<Integer> getLeftHalf(IList<Integer> list) {
        IList<Integer> left = new MyArrayList<>();
        int mid = list.size() / 2;
        
        for (int i = 0; i < mid; i++) {
            left.add(list.get(i));
        }
        return left;
    }

    private static IList<Integer> getRightHalf(IList<Integer> list) {
        IList<Integer> right = new MyArrayList<>();
        int mid = list.size() / 2;
        
        for (int i = mid; i < list.size(); i++) {
            right.add(list.get(i));
        }
        return right;
    }

    private static IList<Integer> merge(IList<Integer> left, IList<Integer> right) {
        IList<Integer> merged = new MyArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                merged.add(left.get(leftIndex));
                leftIndex++;
            } else {
                merged.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex < left.size()) {
            merged.add(left.get(leftIndex));
            leftIndex++;
        }

        while (rightIndex < right.size()) {
            merged.add(right.get(rightIndex));
            rightIndex++;
        }

        return merged;
    }
}
