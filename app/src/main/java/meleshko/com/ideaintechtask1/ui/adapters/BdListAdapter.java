package meleshko.com.ideaintechtask1.ui.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.models.User;
import meleshko.com.ideaintechtask1.ui.activities.UserActivity;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class BdListAdapter extends RecyclerView.Adapter<BdListAdapter.ViewHolder> implements RealmChangeListener{

    private final RealmResults<User> mUsers;
    private final Context mContext;

    public BdListAdapter(RealmResults<User> users, Context context) {
        mUsers = users;
        mContext = context;
        mUsers.addChangeListener(this);
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_from_bd_item, parent, false);
        return new ViewHolder((TextView) view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mUserName.setText(mUsers.get(position).getFullName());
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    @Override
    public void onChange(Object element) {
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mUserName;


        public ViewHolder(final TextView textView) {
            super(textView);
            mUserName = textView;

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, UserActivity.class);
                    intent.putExtra("person_id", mUsers.get(getAdapterPosition()).getUserId());
                    mContext.startActivity(intent.addFlags(FLAG_ACTIVITY_NEW_TASK));
                }
            });
        }
    }
}
