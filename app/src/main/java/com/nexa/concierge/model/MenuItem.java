package com.nexa.concierge.model;

/**
 * Created by glenn on 16/03/15.
 */
public class MenuItem {
    private int id;
    private int parentId;
    private String label;
    private TreeNode<MenuItem> menuTree;

    public void setMenuTree(TreeNode<MenuItem> menuTree) {
        this.menuTree = menuTree;
    }

    public TreeNode<MenuItem> getMenuTree() {
        return menuTree;
    }

    public MenuItem(){}

    public MenuItem(String label, ItemType itemType, ItemStyle style) {
        this.label = label;
        this.itemType = itemType;
        this.style = style;
    }

    public static enum ItemStyle {EMERGENCY, CASUAL, }
    public static enum ItemType{CATEGORY_1,CATEGORY_2,CATEGORY_3,CATEGORY_4,CATEGORY_5,CATEGORY_6,CATEGORY_7, }

    private ItemType itemType;
    private ItemStyle style;

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStyle(ItemStyle style) {
        this.style = style;
    }

    public ItemStyle getStyle(){
        return this.style;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
