package meleshko.com.ideaintechtask1.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import meleshko.com.ideaintechtask1.R;

public class BdInfoFragment extends Fragment {
    private TextView bd_name, bd_avatar, bd_role;
    private Spinner bd_phones, bd_emails;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.info_container_fragment, container, false);

        bd_name = (TextView)v.findViewById(R.id.bd_name);
        bd_avatar = (TextView)v.findViewById(R.id.bd_avatar);
        bd_role = (TextView)v.findViewById(R.id.bd_role);
        bd_phones = (Spinner)v.findViewById(R.id.bd_phones);
        bd_emails = (Spinner)v.findViewById(R.id.bd_emails);

        return v;
    }
}
