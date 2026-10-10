import java.util.Arrays;

public class ExamScoreBandCounter {

    // Returns the number of scores in the inclusive range [low, high].
    // The scores array must already be sorted in ascending order.
    public static int countInBand(int[] scores, int low, int high) {
        int firstAtLeastLow = lowerBound(scores, low);
        int firstGreaterThanHigh = upperBound(scores, high);

        return firstGreaterThanHigh - firstAtLeastLow;
    }

    // Finds the first index whose value is >= target.
    private static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    // Finds the first index whose value is > target.
    private static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58));  // Output: 6
        System.out.println(countInBand(scores, 90, 100)); // Output: 0
    }
}

/*
Time Complexity: O(log n) for two binary searches.
Extra Space Complexity: O(1).

Duplicates at the boundaries are handled by finding the first score >= low
and the first score > high. Their index difference gives the inclusive count.
*/
