package com.nexa.concierge.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by glenn on 20/03/15.
 */
public class TreeNode<T> {

    private T data;
    private TreeNode<T> parent;
    private List<TreeNode<T>> children;

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<TreeNode<T>>();
    }

    public TreeNode<T> addChild(T child) {
        TreeNode<T> childNode = new TreeNode<T>(child);
        childNode.parent = this;
        this.children.add(childNode);
        return childNode;
    }

    public TreeNode<T> addChildNode(TreeNode<T> childNode){
        this.children.add(childNode);
        return childNode;
    }

    public List<T> getChildrenOfNode(TreeNode<T> thisNode){
        List<T> nodeChildList = new ArrayList<>();
        for(TreeNode node: thisNode.getChildren()){
            T item = (T)node.getData();
            nodeChildList.add(item);
        }
        return nodeChildList;
    }

    // other features ...

}
