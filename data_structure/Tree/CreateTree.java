package data_structure.Tree;

import java.util.ArrayList;
import java.util.List;

public class CreateTree {
    public List<TreeNode<Integer>> listnode = null;
    public Integer[] list;

    public CreateTree(Integer[] list) {
        this.list = list;
    }

    public void createTree() {
        listnode = new ArrayList<TreeNode<Integer>>();
        for (int i = 0; i < list.length; i++) {
            TreeNode<Integer> temp = new TreeNode<>(list[i]);
            listnode.add(temp);
        }
        for (int parentIndex = 0; parentIndex < list.length / 2 - 1; parentIndex++) {
            //父节点
            TreeNode<Integer> parentNode = listnode.get(parentIndex);
            //左节点
            parentNode.left = listnode.get(parentIndex * 2 + 1);
            //右节点
            parentNode.right = listnode.get(parentIndex * 2 + 2);

            int lastParentIndex = list.length / 2 - 1;
            TreeNode<Integer> lastParentNode = listnode.get(lastParentIndex);
            lastParentNode.left = listnode.get(lastParentIndex * 2 + 1);
            //总节点数为基数，最后一个父节点才有右孩子
            if (list.length % 2 == 1) {
                lastParentNode.right = listnode.get(lastParentIndex * 2 + 2);
            }
        }
    }
}
