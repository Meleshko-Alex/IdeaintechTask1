package meleshko.com.ideaintechtask1.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;
import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.models.User;

public class BdImputDataFragment extends Fragment {
    private Realm mRealm;
    private Button btn_new_user;
    private EditText et_bd_name, et_bd_avatar, et_bd_role;
    private EditText et_bd_phones_1, et_bd_phones_2;
    private EditText et_bd_emails_1, et_bd_emails_2;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRealm = Realm.getDefaultInstance();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.input_container_fragment, container, false);
        et_bd_name = (EditText)v.findViewById(R.id.et_bd_name);
        et_bd_avatar = (EditText)v.findViewById(R.id.et_bd_avatar);
        et_bd_role = (EditText)v.findViewById(R.id.et_bd_role);
        et_bd_phones_1 = (EditText)v.findViewById(R.id.et_bd_phones_1);
        et_bd_phones_2 = (EditText)v.findViewById(R.id.et_bd_phones_2);
        et_bd_emails_1 = (EditText)v.findViewById(R.id.et_bd_emails_1);
        et_bd_emails_2 = (EditText)v.findViewById(R.id.et_bd_emails_2);

        btn_new_user = (Button)v.findViewById(R.id.btn_new_user);
        btn_new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRealm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        User user = mRealm.createObject(User.class);
                        user.setFullName(et_bd_name.getText().toString());
                        user.setAvatar(et_bd_avatar.getText().toString());
                        user.setRole(et_bd_role.getText().toString());
                    }
                });
            }
        });
        return v;
    }
}
