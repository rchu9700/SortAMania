public class Team1SortCompetition extends SortCompetition {
    @Override
    public int challengeOne(int[] arr)
    {
        util.mergeSort(arr);
        return util.findMedian(arr);
    }

    @Override
    public int challengeTwo(String[] arr, String query) {
        return 0;
    }

    @Override
    public int challengeThree(int[] arr) {
        return 0;
    }

    @Override
    public int challengeFour(int[][] arr) {
        return 0;
    }

    @Override
    public int challengeFive(Comparable[] arr, Comparable query) {
        return 0;
    }

    @Override
    public String greeting() {
        return "Hello, we are team 1!";
    }
}
