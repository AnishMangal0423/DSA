/*
 Qn-

 There are a total of n tasks you have to pick, labeled from 0 to n-1. Some tasks may have prerequisites tasks, for example to pick task 0 you have to first finish tasks 1, which is expressed as a pair: [0, 1]
Given the total number of n tasks and a list of prerequisite pairs of size m. Find a ordering of tasks you should pick to finish all tasks.
Note: There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all tasks, return an empty array. Returning any correct order will give the output as 1, whereas any invalid order will give the output "No Ordering Possible".

Example 1:
Input:
n = 2, m = 1
prerequisites = {{1, 0}}
Output:1
Explanation:
The output 1 denotes that the order is
valid. So, if you have, implemented
your function correctly, then output
would be 1 for all test cases.
One possible order is [0, 1].

Example 2:
Input:
n = 4, m = 4
prerequisites = {{1, 0},
                 {2, 0},
                 {3, 1},
                 {3, 2}}
Output:
1
Explanation:
There are a total of 4 tasks to pick.
To pick task 3 you should have finished
both tasks 1 and 2. Both tasks 1 and 2
should be pick after you finished task 0.
So one correct task order is [0, 1, 2, 3].
Another correct ordering is [0, 2, 1, 3].
Returning any of these order will result in
a Output of 1.


Problem Statement- We have some dependencies and we have to give the order in which task should be done in a way that all tasks can be done in a order..

Approch1- Topological Sort(BFS)-

Intution- FIrst of all we will do that task which is not dependent on anyone or outgoing edges is 0 , so there can two ways to do .. first reverse the graph or find topo for it and reverse the order..

Code-

 */

class Solution {
  public:
    vector<int> findOrder(int n, int m, vector<vector<int>> vec) {
        //code here
        vector<int> adj[n];
        vector<int> indegree(n,0);
        for (int i = 0; i < m; i++) {
            int u = vec[i][0], v = vec[i][1];
            adj[v].push_back(u);
            indegree[u]++;
        }
        
        queue<int> q;
        for (int i = 0; i < n; i++) {
            if (!indegree[i]) q.push(i);
        }
        
        vector<int> ans;
        while (!q.empty()) {
            int node = q.front();
            q.pop();
            ans.push_back(node);
            
            for (auto it : adj[node]) {
                indegree[it]--;
                if (!indegree[it]) q.push(it);
            }
        }
        
        if (ans.size() != n) return {};
        return ans;
    }
};


/*

Errors- 
    1. Instead of using dependiencies use always parent child adj list because it reduces time and many complexities and make soln standard.
*/