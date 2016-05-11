package DummyData;

import com.nexa.concierge.model.MenuItem;
import com.nexa.concierge.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by glenn on 20/03/15.
 */
public class DummyMenuItems {

    public static TreeNode<MenuItem> getMenuItemTree(){
        MenuItem menuItemRoot = new MenuItem();
        menuItemRoot.setLabel("ROOT");
        TreeNode<MenuItem> menuTree = new TreeNode<>(menuItemRoot);

        MenuItem menuItem = new MenuItem();
        menuItem.setLabel("Emergency");
        menuItem.setItemType(MenuItem.ItemType.CATEGORY_1);
        menuItem.setStyle(MenuItem.ItemStyle.EMERGENCY);

        MenuItem mi = new MenuItem("node0", MenuItem.ItemType.CATEGORY_1, MenuItem.ItemStyle.EMERGENCY);
        TreeNode<MenuItem> node0 = menuTree.addChild(mi);
        mi.setMenuTree(node0);

        MenuItem mi2 = new MenuItem("node01", MenuItem.ItemType.CATEGORY_1, MenuItem.ItemStyle.EMERGENCY);
        TreeNode<MenuItem> node01 = node0.addChild(mi2);
        mi2.setMenuTree(node01);

        MenuItem mi3 = new MenuItem("node02", MenuItem.ItemType.CATEGORY_1, MenuItem.ItemStyle.EMERGENCY);
        TreeNode<MenuItem> node02 = node0.addChild(mi3);
        mi3.setMenuTree(node02);

        MenuItem mi4 = new MenuItem("node1", MenuItem.ItemType.CATEGORY_2, MenuItem.ItemStyle.CASUAL);
        TreeNode<MenuItem> node1 = menuTree.addChild(mi4);
        mi4.setMenuTree(node1);

        MenuItem mi5 = new MenuItem("node11", MenuItem.ItemType.CATEGORY_2, MenuItem.ItemStyle.CASUAL);
        TreeNode<MenuItem> node11 = node1.addChild(mi5);
        mi5.setMenuTree(node11);

        MenuItem mi6 = new MenuItem("node2", MenuItem.ItemType.CATEGORY_3, MenuItem.ItemStyle.CASUAL);
        TreeNode<MenuItem> node2 = menuTree.addChild(mi6);
        mi6.setMenuTree(node2);

        MenuItem mi7 = new MenuItem("node21", MenuItem.ItemType.CATEGORY_3, MenuItem.ItemStyle.CASUAL);
        TreeNode<MenuItem> node21 = node2.addChild(mi7);
        mi7.setMenuTree(node21);

        MenuItem mi8 = new MenuItem("node3", MenuItem.ItemType.CATEGORY_4, MenuItem.ItemStyle.CASUAL);
        TreeNode<MenuItem> node3 = node01.addChild(mi8);
        mi8.setMenuTree(node3);

        MenuItem mi9 = new MenuItem("node4", MenuItem.ItemType.CATEGORY_5, MenuItem.ItemStyle.CASUAL);
        TreeNode<MenuItem> node4 = menuTree.addChild(mi9);
        mi9.setMenuTree(node4);

        //test cross linking..
        TreeNode<MenuItem> node5 = node11.addChildNode(node02);
        TreeNode<MenuItem> node02c = node21.addChildNode(node01);
        TreeNode<MenuItem> node01b = node01.addChildNode(node2);

        return menuTree;
    }

    public static List<MenuItem> getMenuItems(){
        List<MenuItem> menuItemList = new ArrayList();

        MenuItem menuItem = new MenuItem();
        menuItem.setLabel("Emergency");
        menuItem.setItemType(MenuItem.ItemType.CATEGORY_1);
        menuItem.setStyle(MenuItem.ItemStyle.EMERGENCY);
        menuItemList.add(menuItem);

        MenuItem menuItem2 = new MenuItem();
        menuItem2.setLabel("Category 2");
        menuItem2.setItemType(MenuItem.ItemType.CATEGORY_2);
        menuItem2.setStyle(MenuItem.ItemStyle.CASUAL);
        menuItemList.add(menuItem2);

        MenuItem menuItem3 = new MenuItem();
        menuItem3.setLabel("Category 3");
        menuItem3.setItemType(MenuItem.ItemType.CATEGORY_3);
        menuItem3.setStyle(MenuItem.ItemStyle.CASUAL);
        menuItemList.add(menuItem3);

        MenuItem menuItem4 = new MenuItem();
        menuItem4.setLabel("Category 4");
        menuItem4.setItemType(MenuItem.ItemType.CATEGORY_4);
        menuItem4.setStyle(MenuItem.ItemStyle.CASUAL);
        menuItemList.add(menuItem4);

        MenuItem menuItem5 = new MenuItem();
        menuItem5.setLabel("Category 5");
        menuItem5.setItemType(MenuItem.ItemType.CATEGORY_5);
        menuItem5.setStyle(MenuItem.ItemStyle.CASUAL);
        menuItemList.add(menuItem5);

        return menuItemList;
    }

}
