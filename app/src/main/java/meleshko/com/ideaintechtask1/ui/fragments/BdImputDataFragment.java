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
import io.realm.RealmList;
import io.realm.RealmResults;
import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.models.Emails;
import meleshko.com.ideaintechtask1.models.Phones;
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
                if(!et_bd_name.getText().toString().equals("")){
                    mRealm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            int primaryKey = 0;
                            try {
                                RealmResults<User> results = realm.where(User.class).findAll();
                                primaryKey = results.max("userId").intValue() + 1;
                            } catch (NullPointerException e){
                                primaryKey = 1;

                            }finally {
                                User user = mRealm.createObject(User.class, primaryKey);
                                user.setFullName(et_bd_name.getText().toString());
                                user.setAvatar(et_bd_avatar.getText().toString());
                                user.setRole(et_bd_role.getText().toString());

                                RealmList<Emails> emails = new RealmList<>();

                                Emails email1 = realm.createObject(Emails.class);
                                email1.setEmail(et_bd_emails_1.getText().toString());
                                emails.add(email1);
                                Emails email2 = realm.createObject(Emails.class);
                                email2.setEmail(et_bd_emails_2.getText().toString());
                                emails.add(email2);

                                user.setEmails(emails);

                                RealmList<Phones> phones = new RealmList<>();

                                Phones phone1 = realm.createObject(Phones.class);
                                phone1.setPhone(et_bd_phones_1.getText().toString());
                                phones.add(phone1);

                                Phones phone2 = realm.createObject(Phones.class);
                                phone2.setPhone(et_bd_phones_2.getText().toString());
                                phones.add(phone2);

                                user.setPhones(phones);
                            }

                        }
                    });
                }
            }
        });
        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mRealm.close();
    }
}
