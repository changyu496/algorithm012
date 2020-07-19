学习笔记
## 学习总结
本周日下午，都是我对一周对学习的总结，希望在9周之后，算法训练营结束后，这个习惯可以保持下来。

本周的内容依然很多，毕竟还是在打基础的阶段

1、 哈希表

这是我们日常工作中用到的最多的一种数据结构了，简单可以理解为，同一个hash函数，将待保存的值映射为数组的一个索引位置，如果两个不同的值映射到同一个位置的话，就称为遇到了"碰撞"，解决问题的方法也分为开链法和闭链法。
视频中提到的是一种比较常用的工业级的方法。当如果碰撞后，就在前一个元素的后面像链表一样加上。那么一个哈希表的高效与否，就取决于hash函数的分散程度。

哈希表的定义和使用都不难理解，而如何在题目中灵活使用，就需要不断的"刻意"练习，下面作业中有专门对HashMap的源码分析。

2、树、二叉树、二叉搜索树

树，可以理解为一种升纬的表现，当一个元素后继元素超过一个，但其前继元素之后一个，继可以被称为树。这里单链表也可以看做是一个棵特殊的树。接着如果树只有两个后继节点（可以称为孩子）。那么就是一棵二叉树。如果一棵二叉树还遵守左子树是大于右子树的话，他就是一棵二叉排序树。当对于一棵二叉排序树进行中序遍历，那么就相当于做了排序输出。


3、堆和二叉堆

堆可以理解为一个接口，堆的性质为某个节点总是不大于或是不小于其父亲节点，根据大小的关系，可以分为大顶堆和小顶堆。而堆是可以有多种实现方式，比较容易实现的是使用完全二叉树进行实现，注意这里是完全二叉树。所以在最终代码实现的时候，可以使用数组进行表示。

在工业级代码中，二叉堆并不是一个非常好的实现，实际刷题过程中，对于Java就可以直接使用PriorityQueue即可。基本上题目中提到最大、最小之类的都可以往堆上去靠


4、图
目前这部分不是整个面试的重点，视频中讲述也相对简单，其中的重点就是是否有环（我自己更愿意理解为除了有多个后继节点，是否有多个前继节点），同时落地表现的是，使用点和边进行。有邻接矩阵和邻接表两种方式（具体选择还要看稀疏程度）
图其实是数据结构中最最复杂的一部分，当时念书的时候也是花了很多时间在上面，包括各种寻路算法什么的，但实际业务中使用几率不高，这里就先总结如此


## 作业：HashMap的理解

HashMap这个类整体的内容比较多，这里重点看一个结构和两个方法。

```
transient Node<K,V>[] table;
```
这个```Node<K,V>```类型的数组，就是最终我们的数据存储的地方，所以说HashMap的底层就是数组。

接着我们看下```Node<K,V>```这个数据结构：

```
    static class Node<K,V> implements Map.Entry<K,V> {
        // hash值，也可以理解为最终的索引位置
        final int hash;
        // Key，对，就是我们使用的那个Key
        final K key;
        // Value，对，就是我们存的那个Value
        V value;
        // 碰撞的时候，指向下一个碰撞元素的"指针"
        Node<K,V> next;

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey()        { return key; }
        public final V getValue()      { return value; }
        public final String toString() { return key + "=" + value; }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
                if (Objects.equals(key, e.getKey()) &&
                    Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
```
这个对象很重要，我们最终存到HashMap里的都是这样的Node对象，所以也能理解为什么HashMap必须用包装类型，而不能用原始类型了。

接着就看两个最重要的方法```getNode()```和```putVal（）```。这里实际我们用的get和put底层调用的就是这两个方法，所以我们看他们就够了

好在方法不长，先直接贴代码吧

```
/**
     * Implements Map.get and related methods
     *
     * @param hash hash for key
     * @param key the key
     * @return the node, or null if none
     */
    final Node<K,V> getNode(int hash, Object key) {
        Node<K,V>[] tab; Node<K,V> first, e; int n; K k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
            (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                if (first instanceof TreeNode)
                    return ((TreeNode<K,V>)first).getTreeNode(hash, key);
                do {
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }

```
1、首先通过 ```tab[(n - 1) & hash])``` 来获取该key所有对的数据节点
2、如果first为null，就直接返回null
3、接着判断first.key是否等于目标值的key，如果相等，就直接返回first节点
4、如果first节点的next为null，也直接返回null，那么就是碰撞了，但还是没有存入过这个值
5、接着判断first节点的类型，如果是树节点，就走红黑树的逻辑，如果是链表节点，就依次遍历后面的链表

这里也是JDK1.8后的一个改善，并不完全是用链表，还会使用红黑树进行提速，具体怎么选择呢，就看下一个方法```putVal```

```
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        Node<K,V>[] tab; Node<K,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<K,V> e; K k;
            if (p.hash == hash &&
                ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else if (p instanceof TreeNode)
                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                            treeifyBin(tab, hash);
                        break;
                    }
                    if (e.hash == hash &&
                        ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                    p = e;
                }
            }
            if (e != null) { // existing mapping for key
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }
```

这里，先看下5个参数的含义
hash，代表存储在table里的索引位置
key，就是存储的key
value，就是存储的value
onlyIfAbsent，如果该值为true，不影响已经存在的值，即不覆盖
evict，如果是false，代表底层的table是一个创建模式（这个含义还没理解）

下面再按照函数走一遍：
1、首先检查下底层table的长度，如果不够就需要扩容
2、如果这个节点再table没有，就直接在该位置上放上去就好，主要```i=(n-1)&hash```这种写法，其实还是蛮奥妙的
3、下面就是逻辑的大头了，如果碰撞了
 3.1 进行值的判断： 判断对于是不是对于相同的key值传进来不同的value，若是如此，将原来的value返回即可；
 3.2 如果当前Node类型为TreeNode，调用 PutTreeVal 方法；
 3.3 如果不是TreeNode，则就是链表，遍历并与输入key做命中碰撞,如果当前Table中不存在当前key，则添加,超过了``TREEIFY_THRESHOLD``则转化为红黑树。默认是链表超过8个，就会转为红黑树；
4、扩容检测处理；

整体说，JDK的源码中，写的还是比较简炼的，也不是那么容易读懂。

## 刷题记录（Week2）

| 题目 | 一刷 | 二刷 |
| :-----| :---- | :---- |
| [242. 有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/) | 2020.7.14 一次AC，代码不够简练 | 2020.7.19 使用了数组代替即可，只针对小写字母，执行速度有变快 | 
| [1. 两数之和](https://leetcode-cn.com/problems/two-sum/description/) | 2020.7.14 使用HashMap完成，做过非常非常多遍了 | 2020.7.19 一遍AC，思路明确后，还需要更熟练 |
| [589. N叉树的前序遍历](https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/) | 2020.7.17 直接利用递归的helper思路 | 2020.7.19 更熟练使用了递归来进行，还需要补上迭代的写法 |
| [49. 字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/) | 2020.7.17 使用HashMap通过了，能想到思路，但还是看了题解 | 2020.7.19 开始还是没有想到好的解法，再看了一遍，主要是得理解HashMap的K和V分别放什么,另外需要注意适当的使用局部变量，可以有效提高执行速度，比如这里的key|
| [94. 二叉树的中序遍历](https://leetcode-cn.com/problems/binary-tree-inorder-traversal/) | 2020.7.12 递归，套路题 | 2020.7.19 递归，套路题|
| [144. 二叉树的前序遍历](https://leetcode-cn.com/problems/binary-tree-preorder-traversal/) | 2020.7.12 递归，套路题 | 2020.7.19 递归，套路题|
| [429. N叉树的层序遍历](https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/) | 2020.7.19 层序遍历，立刻会想到队列，但实际AC代码还是没写出 | |
| [264. 丑数 II](https://leetcode-cn.com/problems/ugly-number-ii/) | 2020.7.19 这道题比我想象的要难，最终还是先利用了TreeSet的数据结构，然后考虑了Long，其他的解法还是不太理解，要再看 | |
| [347. 前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/) | 2020.7.19 这道题初看起来不太难，思路也是能想到用Map和堆，但实际做起来，我的方法还是比较丑，是用了一个数据结构保存的，题解的方法还是想不到 | |

## 成长记录

参考了其他同学的作业，把自己本周的刷题记录写了下来，视频也利用通勤的时间，看了两遍，但还是那种看了能理解，但面对空空的屏幕的时候，有点发懵。
本周工作上的杂事也比较多，投入的时间少于上周，但好在是把所有的作业题都完成了一遍，题目前前后后其实刷了几遍，下周计划除了学的新的部分，还得把第一周的题目一起刷起来

## 期待改进

1、每天做的题目还是少了，这点只能对自己提要求，慢慢开始进入比较难的状态了，要调整好状态，加油！