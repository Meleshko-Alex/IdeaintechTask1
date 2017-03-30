package meleshko.com.ideaintechtask1.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.models.Contact;

public class ContactRecyclerAdapter extends RecyclerView.Adapter<ContactRecyclerAdapter.ViewHolder> {
    private final ArrayList<Contact> mContactsList;
    private final Context mContext;

    public ContactRecyclerAdapter(ArrayList<Contact> contacts, Context context) {
        mContactsList = contacts;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_contact_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactRecyclerAdapter.ViewHolder holder, int position) {
        holder.contactFullName.setText(mContactsList.get(position).getFullName());
    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView contactFullName;

        public ViewHolder(final View itemView) {
            super(itemView);
            contactFullName = (TextView) itemView.findViewById(R.id.recyc_item_contact_name);

        }
    }
}
