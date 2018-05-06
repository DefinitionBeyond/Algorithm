package data_structure.Tree.binarySearchTree;

/**
 * @author liutao
 * @date 2018/5/6  21:57
 */
public class BinarySearchTree<T extends Comparable> {
    private Node<T> root = null;
    private TreeNode treeNode = null;
    private final boolean isKV;

    public BinarySearchTree(boolean isKV) {
        this.isKV = isKV;
    }

    public void insert(int key, T val) {
        if (isKV) {
            insertKV(key, val);
        } else {
            throw new ClassCastException("request V ,Not K and V");
        }
    }

    public void insert(int key) {
        if (!isKV) {
            insertVal(key);
        } else {
            throw new ClassCastException("request k and v ");
        }
    }

    private void insertVal(int key) {
        // 如果是空树，则插入的节点为根节点
        if (treeNode == null) {
            treeNode = new TreeNode(key);
            return;
        }
        TreeNode cur = treeNode;
        TreeNode parent = treeNode;
        boolean isLeftNode = true;
        while (cur != null) {//直到找到该插入的位置
            parent = cur;
            if (key < cur.key) { // 如果小于当前节点的值，往左子树查找
                cur = cur.left;
                isLeftNode = true;
            } else { // 如果大于当前节点的值，往右子树查找
                cur = cur.right;
                isLeftNode = false;
            }
        }
        TreeNode newNode = new TreeNode(key);
        if (isLeftNode) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    private void insertKV(int key, T val) {
        // 如果是空树，则插入的节点为根节点
        if (root == null) {
            root = new Node<T>(key, val);
            return;
        }
        Node cur = root;
        Node parent = root;
        boolean isLeftNode = true;
        while (cur != null) {//直到找到该插入的位置
            parent = cur;
            if (key < cur.key) { // 如果小于当前节点的值，往左子树查找
                cur = cur.left;
                isLeftNode = true;
            } else { // 如果大于当前节点的值，往右子树查找
                cur = cur.right;
                isLeftNode = false;
            }
        }
        Node newNode = new Node(key, val);
        if (isLeftNode) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }


    public void scanPreOrder(BinarySearchTree obj) {
        if (obj.isKV == true) {
            scanPreOrder(root);
        } else {
            scanPreOrder(treeNode);
        }
    }

    private void scanPreOrder(Node<T> parentNode) {
        if (parentNode == null) {
            return;
        }
        scanPreOrder(parentNode.left);
        System.out.print(parentNode.key + ":" + parentNode.val + "  ");
        scanPreOrder(parentNode.right);
    }

    private void scanPreOrder(TreeNode parentNode) {
        if (parentNode == null) {
            return;
        }
        scanPreOrder(parentNode.left);
        System.out.print(parentNode.key + "  ");
        scanPreOrder(parentNode.right);
    }
}
