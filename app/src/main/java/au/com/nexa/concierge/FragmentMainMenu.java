package au.com.nexa.concierge;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.nexa.concierge.model.MenuItem;
import com.nexa.concierge.model.Ticket;
import com.nexa.concierge.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

import DummyData.DummyMenuItems;

/**
 * Created by glenn on 9/03/15.
 */
public class FragmentMainMenu extends Fragment {

    private menuItemListener listener;
    private ViewGroup linearLayoutForButtons;
    public FragmentMainMenu(){}
    private List<MenuItem> menuItemList = new ArrayList();
    private TreeNode<MenuItem> menuItemTree;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        populateMenuItemList();

        View rootView = inflater.inflate(R.layout.fragment_main_menu, container, false);
        linearLayoutForButtons = (ViewGroup)rootView.findViewById(R.id.ll_buttons);
        removeAllViewsAndAddButtons(inflater);

        return rootView;
    }

    private void removeAllViewsAndAddButtons(LayoutInflater inflater) {
        linearLayoutForButtons.removeAllViews();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.setMargins(0,310,0,0);
        linearLayoutForButtons.setLayoutParams(params);
        createButtonsForMenuListItemsAndAddToLayout(inflater);
    }

    private void createButtonsForMenuListItemsAndAddToLayout(LayoutInflater inflater) {
        final LayoutInflater inflaterNEW = inflater;
        for(MenuItem item: menuItemList) {
            Button newButton = getNewButtonStyle(inflater, item);

            newButton.setText(item.getLabel());
            newButton.setTag(R.id.THIS_NODE, item.getMenuTree());
            newButton.setTag(R.id.MENU_ITEM_CATEGORY, item.getItemType());
            newButton.setTag(R.id.SELECTED_MENUITEM_TEXT_AND_ID, new Pair(item.getLabel(), item.getId()));

            newButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    TreeNode<MenuItem> thisNode = (TreeNode<MenuItem>) v.getTag(R.id.THIS_NODE);
                    if (thisNode != null) {
                        menuItemList = menuItemTree.getChildrenOfNode(thisNode);
                        removeAllViewsAndAddButtons(inflaterNEW);
                    }

                    if (menuItemList.size() == 0) {
                        MenuItem.ItemType itemType = (MenuItem.ItemType) v.getTag(R.id.MENU_ITEM_CATEGORY);
                        Ticket ticket = new Ticket();
                        Pair selectedMenuItemTextAndId = (Pair) v.getTag(R.id.SELECTED_MENUITEM_TEXT_AND_ID);
                        ticket.setSelectedMenuItemTextandId(selectedMenuItemTextAndId);
                        switch (itemType) {
                            case CATEGORY_1:
                                ticket.setSeverity(Ticket.ticketSeverity.CRITICAL);
                                ticket.setTicketNumber("1001");
                                ticket.setEstimateWaitTime("3 minutes");
                                break;
                            case CATEGORY_2:
                                ticket.setSeverity(Ticket.ticketSeverity.HIGH);
                                ticket.setTicketNumber("2001");
                                ticket.setEstimateWaitTime("5 minutes");
                                break;
                            case CATEGORY_3:
                                ticket.setSeverity(Ticket.ticketSeverity.MEDIUM);
                                ticket.setTicketNumber("3001");
                                ticket.setEstimateWaitTime("10 minutes");
                                break;
                            case CATEGORY_4:
                                ticket.setSeverity(Ticket.ticketSeverity.LOW);
                                ticket.setTicketNumber("4001");
                                ticket.setEstimateWaitTime("15 minutes");
                                break;
                            case CATEGORY_5:
                                ticket.setSeverity(Ticket.ticketSeverity.LOW);
                                ticket.setTicketNumber("5001");
                                ticket.setEstimateWaitTime("23 minutes");
                                break;
                        }
                        goToTicket(ticket);
                    }
                }
            });

            int buttonHeight = 130;
            int bottomMargin = 60;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, buttonHeight);
            params.setMargins(0, 0, 0, bottomMargin);
            newButton.setLayoutParams(params);
            linearLayoutForButtons.addView(newButton);
        }
    }

    private Button getNewButtonStyle(LayoutInflater inflater, MenuItem item) {
        Button newButton = (Button)inflater.inflate(R.layout.button_default, null, false);
        switch (item.getStyle()){
            case EMERGENCY:
                if(item.getMenuTree().getChildren().size() == 0){
                    newButton = (Button) inflater.inflate(R.layout.button_emergency_final, null, false);
                }
                else {
                    newButton = (Button) inflater.inflate(R.layout.button_emergency, null, false);
                }
                break;

            case CASUAL:
                if(item.getMenuTree().getChildren().size() == 0){
                newButton = (Button)inflater.inflate(R.layout.button_casual_final, null, false);
                }
                else {
                    newButton = (Button) inflater.inflate(R.layout.button_casual, null, false);
                }
                break;

        }
        return newButton;
    }

    private void populateMenuItemList() {
        menuItemList.clear();
        //menuItemList = DummyMenuItems.getMenuItems();
        menuItemTree = DummyMenuItems.getMenuItemTree();
/*        for(TreeNode node: menuItemTree.getChildren()){
            MenuItem mi = (MenuItem)node.getData();
            menuItemList.add(mi);
        }*/
        menuItemList = menuItemTree.getChildrenOfNode(menuItemTree);
    }



    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        if (activity instanceof menuItemListener) {
            listener = (menuItemListener) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implemenet MyListFragment.OnItemSelectedListener");
        }
    }

    private void goToTicket(Ticket ticket) {
        listener.showTicket(ticket);
    }

    public interface menuItemListener{
        public void showTicket(Ticket ticket);
    }

}

