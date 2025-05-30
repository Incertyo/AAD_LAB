import java.util.Arrays;

public class JobScheduling {
    static int maxJobs(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]); // Sort by end time
        int count = 0, lastEnd = -1;

        for (int[] job : intervals) {
            if (job[0] >= lastEnd) {
                count++;
                lastEnd = job[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] jobs = {{1, 3}, {2, 5}, {3, 6}, {5, 7}, {4, 9}};
        System.out.println("Max Jobs Scheduled: " + maxJobs(jobs));
    }
}