import java.util.*;

public class JobSequencing {

// Before sorting jobInfo define it in class obj
    static class Job {
        // blueprint
        int deadline;
        int profit;
        int id;         //0(A), 1(B), 2(C) , 3(D)

        // constructor
        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String args[]) {
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

    // make arraylist of job
        ArrayList<Job> jobs = new ArrayList<>();

    // store data in this array
        for(int i=0 ; i<jobsInfo.length ; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }
    
    // des order of profit using lambda function
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit-obj1.profit);
    
    // Store sequence
        ArrayList<Integer> seq = new ArrayList<>();

    // Comparison
        int time = 0;
       for(int i=0 ; i<jobs.size() ; i++) {
            Job curr = jobs.get(i);
            if(curr.deadline > time) {      // we can do job
                seq.add(curr.id);
                time++;
            }
       }

    // Print seq 
        System.out.println("max jobs = " + seq.size());
        for(int i=0 ; i<seq.size() ; i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();
    }
}