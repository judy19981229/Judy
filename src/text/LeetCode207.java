package text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode207 {
    List<List<Integer>>list=new ArrayList<>();
    int visit[];
    boolean isvaild=true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visit=new int[numCourses];
        for (int i=0;i<numCourses;i++){
            list.add(new ArrayList<Integer>());//初始化
        }
        for (int info[]:prerequisites){
            //学info[0]之前要先学info[1],所以info[1]指向info[0],
            //所以在info[1]的ArrayList中存储它指向哪个科目
            list.get(info[1]).add(info[0]);
        }
        for (int i=0;i<numCourses;i++){
            if (visit[i]==0){//如果是未搜索的科目，则深搜
                dfs(i);
            }
        }
        return isvaild;
    }
    public void dfs(int v){
        visit[v]=1;//标记该科目为搜索中
        for (int w:list.get(v)){//遍历该科目指向的学科
            if (visit[w]==0){//如果指向的某一学科未搜索过，则深搜
                dfs(w);
                if (!isvaild){
                    return;
                }
            }
            else if (visit[w]==1){//如果指向的某一学科在搜索中，则有环，标记isVaild
                isvaild=false;
                return;
            }
        }
        visit[v]=2;//因为该科目已经完成深搜，所以标记它的状态未搜索过
    }

}

