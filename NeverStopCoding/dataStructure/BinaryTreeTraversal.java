package dataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**  
 * 二叉树的遍历   递归和非递归   思路和实现   
 *  
 * @author 郑元浩 
 * @date 2017年4月8日 下午7:59:04 
 */
public class BinaryTreeTraversal {

	protected Node root;
	
	public BinaryTreeTraversal(Node root) {
		this.root = root;
	}
	
	public Node getRoot(){
		return root;
	}
	
	/* 构造树 */
	public static Node init(){
		Node a = new Node('A');
		Node b = new Node('B', null, a);
		Node c = new Node('C');
		Node d = new Node('D', b, c);
		Node e = new Node('E');
		Node f = new Node('F', e, null);
		Node g = new Node('G', null, f);
		Node h = new Node('H', d, g);
		return h;
	}
	
	/* 访问节点 */
	public static void visit(Node p) {
		System.out.print(p.getKey() + " ");
	}
	
	/* 递归实现前序遍历 */
	public static void preorder(Node p) {
		if (p != null) {
			visit(p);
			preorder(p.getLeft());
			preorder(p.getRight());
		}
	}
	
	/* 递归实现中序遍历 */
	public static void inorder(Node p) {
		if (p != null) {
			inorder(p.getLeft());
			visit(p);
			inorder(p.getRight());
		}
	}
	
	/* 递归实现后序遍历 */
	public static void postorder(Node p) {
		if (p != null) {
			postorder(p.getLeft());
			postorder(p.getRight());
			visit(p);
		}
	}
	
	/**********************************************************************************************/  
    /* 非递归实现前序遍历 */   
	protected static void iterativePreorder(Node p) {
		
		Stack<Node> stack = new Stack<>();
		Node node = p;
		while (node != null || !stack.isEmpty()) {
			// 压入所有的左结点，压入前访问它。左结点压入完后pop访问右结点。对于每个右结点再判断其左结点的情况。注意左是while，又是if
			while (node != null) {
				visit(node);
				stack.push(node);
				node = node.getLeft();
			}
			// pop访问右结点
			if (!stack.isEmpty()) {
				node = stack.pop();
				node = node.getRight();
			}
		}
	}
	
	/* 非递归实现中序遍历 */
	protected static void iterativeInorder(Node p) {
		Stack<Node> stack = new Stack<>();
		Node node = p;
		while (node != null || !stack.isEmpty()) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
			if (!stack.isEmpty()) {
				node = stack.pop();
				visit(node); // 该位置不同，必须是等到弹出最左边的节点才可以访问
				node = node.getRight();
			}
		}
	}
	
	/* 非递归实现后序遍历 ---单栈法*/
	protected static void iterativePostorder(Node p) {
		Stack<Node> stack = new Stack<Node>();
		Node node = p, prev = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.size() > 0) {
				Node temp = stack.peek().getRight();
				if (temp == null || temp == prev) { // 当前节点无右子或者右子已经输出
					node = stack.pop();
					visit(node);
					prev = node; // 记录上一个已输出节点
					node = null;
				} else { // 使当前结点为右子结点
					node = temp;
				}
			}
		}
	}
	
	/* 非递归实现后序遍历 */
	protected static void iterativePostorder2(Node p) {
		Node q = p;
		Stack<Node> stack = new Stack<Node>();
		while (p != null) {
			// 左子树入栈
			for (; p.getLeft() != null; p = p.getLeft()) {
				stack.push(p);
			}
			// 当前节点无右子或者右子已经输出
			while (p != null && (p.getRight() == null || p.getRight() == q)) {
				visit(p);
				q = p; // 记录上一个已输出节点
				if (stack.empty()) {
					return;
				}
				p = stack.pop();
			}
			// 处理右子
			stack.push(p);
			p = p.getRight();
		}
	}
	
	/* 非递归实现后序遍历---双栈法 */
	protected static void iterativePostorder3(Node p) {
		Stack<Node> lStack = new Stack<Node>(); // 左子树
		Stack<Node> rStack = new Stack<Node>(); // 右子树
		Node node = p, right;
		do {
			while (node != null) {
				right = node.getRight();
				lStack.push(node);
				rStack.push(right);
				node = node.getLeft();
			}
			node = lStack.pop();
			right = rStack.pop();
			if (right == null) {
				visit(node);
			} else {
				lStack.push(node);
				rStack.push(null);
			}
			node = right;
		} while (lStack.size() > 0 || rStack.size() > 0);
	}
	
	/* 非递归实现后序遍历 ---双栈法*/
	protected static void iterativePostorder4(Node p) {
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> temp = new Stack<Node>();
		Node node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				temp.push(node);
				stack.push(node);
				node = node.getRight();
			}
			if (stack.size() > 0) {
				node = stack.pop();
				node = node.getLeft();
			}
		}
		while (temp.size() > 0) { // 把插入序列都插入到了temp。
			node = temp.pop();
			visit(node);
		}
	}
	
	
	
	/* 非递归实现前序遍历---方法2 */
	protected static void iterativePreorder2(Node p) {
		Stack<Node> stack = new Stack<>();
		if (p != null) {
			stack.push(p);
			while (!stack.empty()) {
				p = stack.pop(); // 弹出栈顶元素
				visit(p);
				if (p.getRight() != null) {
					stack.push(p.getRight());
				}
				if (p.getLeft() != null) { // left后面压入，方便先访问左子树节点
					stack.push(p.getLeft());
				}
			}
		}
	}
	
	/* 层次遍历 --- 队列 */
	protected static void levelOrder(Node p) {
		Queue<Node> queue = new LinkedList<Node>(); // 队列
		Node node = p;
		queue.offer(node); // 根节点入队
		while (!queue.isEmpty()) { // 队列不为空循环
			// 对头元素出队
			node = queue.poll();
			// 访问该元素
			visit(node);
			// 左子树不为空，将左子树入队
			if (node.getLeft() != null) {
				queue.offer(node.getLeft());
			}
			// 右子树不为空，将右子树入队
			if (node.getRight() != null) {
				queue.offer(node.getRight());
			}
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeTraversal tree = new BinaryTreeTraversal(init());
		System.out.print(" 递归遍历 \n");
		System.out.print(" Pre-Order:");
		preorder(tree.getRoot());
		
		System.out.print(" \n In-Order:");
		inorder(tree.getRoot());
		
		System.out.print(" \n Post-Order:");
		postorder(tree.getRoot());
		
		System.out.print(" \n非递归遍历");  
        System.out.print(" \n Pre-Order:");    
        iterativePreorder(tree.getRoot());    
          
        System.out.print("\n Pre-Order2:");    
        iterativePreorder2(tree.getRoot());    
           
        System.out.print(" \n In-Order:");    
        iterativeInorder(tree.getRoot());  
          
        System.out.print("\n Post-Order:");    
        iterativePostorder(tree.getRoot());    
         
        System.out.print("\n Post-Order2:");    
        iterativePostorder2(tree.getRoot());    
           
        System.out.print("\n Post-Order3:");    
        iterativePostorder3(tree.getRoot());    
           
        System.out.print("\n Post-Order4:");    
        iterativePostorder4(tree.getRoot());   
        
        System.out.print(" \n层次遍历");  
        System.out.print(" \n Level-Order:");    
        levelOrder(tree.getRoot()); 
        
	}

}

/**
 * 二叉树结点定义：左右子树和该结点值
 */
class Node {
	private char key;
	private Node left, right;
	
	public Node(char key) {
		this(key, null, null);
	}
	
	public Node(char key, Node left, Node right) {
		this.key = key;
		this.left = left;
		this.right = right;
	}

	public char getKey() {
		return key;
	}

	public void setKey(char key) {
		this.key = key;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	
	
}
