package meleshko.com.ideaintechtask1.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.realm.Realm;
import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.models.User;
import meleshko.com.ideaintechtask1.ui.adapters.BdListAdapter;

public class BdListFragment extends Fragment {
    private RecyclerView mRecycler;
    private Realm mRealm;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm = Realm.getDefaultInstance();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.list_container_fragment, container, false);

        mRecycler = (RecyclerView) v.findViewById(R.id.recycler_users);

        return v;
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecycler.setAdapter(new BdListAdapter(mRealm.where(User.class).findAll(), getContext()));
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }
}
