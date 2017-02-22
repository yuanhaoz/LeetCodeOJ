/**
 * 排序算法
 * 查找和排序算法是算法的入门知识，其经典思想可以用于很多算法当中。因为其实现代码较短，应用较常见。
 * 所以在面试中经常会问到排序算法及其相关的问题。但万变不离其宗，只要熟悉了思想，灵活运用也不是难事。
 * 一般在面试中最常考的是快速排序和归并排序，并且经常有面试官要求现场写出这两种排序的代码。对这两种排序的代码一定要信手拈来才行。
 * 还有插入排序、冒泡排序、堆排序、基数排序、桶排序等。面试官对于这些排序可能会要求比较各自的优劣、各种算法的思想及其使用场景。
 * 还有要会分析算法的时间和空间复杂度。
 * 通常查找和排序算法的考察是面试的开始，如果这些问题回答不好，估计面试官都没有继续面试下去的兴趣都没了。
 * 所以想开个好头就要把常见的排序算法思想及其特点要熟练掌握，有必要时要熟练写出代码。
 * 
 * 
 * 
 * 　在前面的介绍和分析中我们提到了冒泡排序、选择排序、插入排序三种简单的排序及其变种快速排序、堆排序、希尔排序三种比较高效的排序。
 * 后面我们又分析了基于分治递归思想的归并排序还有计数排序、桶排序、基数排序三种线性排序。
 * 我们可以知道排序算法要么简单有效，要么是利用简单排序的特点加以改进，要么是以空间换取时间在特定情况下的高效排序。
 * 但是这些排序方法都不是固定不变的，需要结合具体的需求和场景来选择甚至组合使用。才能达到高效稳定的目的。没有最好的排序，只有最适合的排序。

　　下面就总结一下排序算法的各自的使用场景和适用场合。

　　1. 从平均时间来看，快速排序是效率最高的，但快速排序在最坏情况下的时间性能不如堆排序和归并排序。而后者相比较的结果是，在n较大时归并排序使用时间较少，但使用辅助空间较多。

　　2. 上面说的简单排序包括除希尔排序之外的所有冒泡排序、插入排序、简单选择排序。
	     其中直接插入排序最简单，但序列基本有序或者n较小时，直接插入排序是好的方法，因此常将它和其他的排序方法，如快速排序、归并排序等结合在一起使用。

　　3. 基数排序的时间复杂度也可以写成O(d*n)。因此它最使用于n值很大而关键字较小的的序列。若关键字也很大，而序列中大多数记录的最高关键字均不同，
	     则亦可先按最高关键字不同，将序列分成若干小的子序列，而后进行直接插入排序。

　　4. 从方法的稳定性来比较，基数排序是稳定的内排方法，所有时间复杂度为O(n^2)的简单排序也是稳定的。但是快速排序、堆排序、希尔排序等时间性能较好的排序方法都是不稳定的。
               稳定性需要根据具体需求选择。

　　5. 上面的算法实现大多数是使用线性存储结构，像插入排序这种算法用链表实现更好，省去了移动元素的时间。具体的存储结构在具体的实现版本中也是不同的。

        附：基于比较排序算法时间下限为O(nlogn)的证明：

　　基于比较排序下限的证明是通过决策树证明的，决策树的高度Ω（nlgn），这样就得出了比较排序的下限。

       首先要引入决策树。 首先决策树是一颗二叉树，每个节点表示元素之间一组可能的排序，它予以京进行的比较相一致，比较的结果是树的边。
       先来说明一些二叉树的性质，令T是深度为d的二叉树，则T最多有2^片树叶。 具有L片树叶的二叉树的深度至少是logL。
       所以，对n个元素排序的决策树必然有n!片树叶（因为n个数有n!种不同的大小关系），所以决策树的深度至少是log(n!)，即至少需要log(n!)次比较。 
       而 log(n!)=logn+log(n-1)+log(n-2)+...+log2+log1 >=logn+log(n-1)+log(n-2)+...+log(n/2) >=(n/2)log(n/2) >=(n/2)logn-n/2 =O(nlogn) 
       所以只用到比较的排序算法最低时间复杂度是O(nlogn)。

 */
/**
 * @author 郑元浩
 *
 */
package sortAlgorithm;