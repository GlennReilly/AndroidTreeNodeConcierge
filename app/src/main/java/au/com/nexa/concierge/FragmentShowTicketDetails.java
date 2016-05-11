package au.com.nexa.concierge;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nexa.concierge.model.Ticket;

import org.w3c.dom.Text;

/**
 * Created by glenn on 10/03/15.
 */
public class FragmentShowTicketDetails extends Fragment {
    private Ticket ticket;
    public FragmentShowTicketDetails(){}
    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_show_ticket_details, container, false);
        TextView tvSelectedItem = (TextView) rootView.findViewById(R.id.tvLabelForSelectedItem);
        TextView tvTicketNumber = (TextView)rootView.findViewById(R.id.tvTicketNumber);
        TextView tvEstimatedWaitTime = (TextView)rootView.findViewById(R.id.tvEstimatedWaitTime);

        Pair selectedItemAndId = ticket.getSelectedMenuItemTextandId();

        tvSelectedItem.setText(getString(R.string.selected_item_lead_in) + " " + selectedItemAndId.first.toString());
        tvTicketNumber.setText(ticket.getTicketNumber());
        tvEstimatedWaitTime.setText(ticket.getEstimateWaitTime());
        return rootView;
    }


}
