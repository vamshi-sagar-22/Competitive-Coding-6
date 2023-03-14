import java.util.ArrayList;
import java.util.List;

/*
Beautiful Arrangement
approach: try to find permutations at each level using backtracking, do not proceed if current path is not a beautiful arrangement.
time: O(valid solutions)
space: O(n)
 */
public class Problem1 {
    int count = 0;
    public int countArrangement(int n) {
        recurse(n,new boolean[n], new ArrayList<>());
        return count;
    }


    private void recurse(int n, boolean[] vis, List<Integer> path) {
        if(path.size()==n) {
            count++;
        }

        for(int i=1;i<=n;i++) {
            if(vis[i-1]) continue;
            vis[i-1] = true;
            path.add(i);
            if(check(path)) recurse(n, vis, path);
            vis[i-1] = false;
            path.remove(path.size()-1);
        }
    }

    private boolean check(List<Integer> nums) {
        for(int i=1;i<=nums.size();i++) {
            if(nums.get(i-1)%i==0 || i%nums.get(i-1)==0) continue;
            return false;
        }
        return true;
    }
}
