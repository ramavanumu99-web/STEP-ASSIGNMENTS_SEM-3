public class SecondBestScore {

    // Returns the second-highest distinct score, or -1 if it does not exist.
    // The array is processed once; it is not sorted.
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] scores1 = {45, 78, 92, 78, 60};
        int[] scores2 = {50, 50, 50};

        System.out.println(secondHighest(scores1)); // Output: 78
        System.out.println(secondHighest(scores2)); // Output: -1
    }
}

/*
Time Complexity: O(n), because every score is checked once.
Extra Space Complexity: O(1), because only two variables are maintained.

Repeated copies of the highest score are ignored for the second-highest result.
If all scores are equal, no second distinct score exists, so -1 is returned.
*/
