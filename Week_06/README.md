学习笔记

## 学习总结

动态规划，果然是比较难的，是属于那种看、听都能懂，但写代码的时候就头脑空空

现在算是进入中后期了吧，本周的投入时间严重不足，还是先练习好课上老师的例题吧

动态规划关键点

1、最优子结构 opt[n] = best_of(opt[n-1],opt[n-2],...)

2、存储中间状态 opt[i]

3、递推公式（美其名曰：状态转移方程或者DP方程）

Fib:```opt[i] = opt[i-1] + opt[i-2]```

二维路径：```opt[i,j] = opt[i+1][j]+opt[i][j+1]()```

理解关键点
1、不能人肉递归
2、自底向上，自顶向下
3、状态转移方程的分析方法

小结

1、打破自己的思维惯性，形成机器思维

2、理解复杂逻辑的关键

职场的进阶要点，要好好理解

## 刷题记录（Week3）

| 题目 | 刷题 | 备注 |
| :-----| :---- | :---- |
| [62. 不同路径](https://leetcode-cn.com/problems/unique-paths/) | 思维的胜纬很重要  | |
| [64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/) | 明白和写对，差距很大 | | 
| [1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/) | 明白和写对，差距很大，还是要多练 | |
| [1143. 最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence/) | 明白和写对，差距很大，还是要多练 | | 
