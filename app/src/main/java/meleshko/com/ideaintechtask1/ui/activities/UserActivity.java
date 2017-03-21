package meleshko.com.ideaintechtask1.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import io.realm.Realm;
import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.models.User;

public class UserActivity extends AppCompatActivity {

    private TextView bd_name, bd_avatar, bd_role;
    private TextView bd_phone_1, bd_phone_2, bd_email_1, bd_email_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        bd_name = (TextView)findViewById(R.id.bd_name);
        bd_avatar = (TextView)findViewById(R.id.bd_avatar);
        bd_role = (TextView)findViewById(R.id.bd_role);
        bd_phone_1 = (TextView)findViewById(R.id.bd_phone_1);
        bd_phone_2 = (TextView)findViewById(R.id.bd_phone_2);
        bd_email_1 = (TextView)findViewById(R.id.bd_email_1);
        bd_email_2 = (TextView)findViewById(R.id.bd_email_2);

        int personId = getIntent().getIntExtra("person_id", 0);
        Realm realm = Realm.getDefaultInstance();

        try {
            User user = realm.where(User.class).equalTo("userId", personId).findFirst();
            bd_name.setText(user.getFullName());
            bd_avatar.setText(user.getAvatar());
            bd_role.setText(user.getRole());
            bd_phone_1.setText((user.getPhones().get(0).getPhone()));
            bd_phone_2.setText((user.getPhones().get(1).getPhone()));
            bd_email_1.setText(user.getEmails().get(0).getEmail());
            bd_email_2.setText(user.getEmails().get(1).getEmail());
        } finally {
            realm.close();
        }
    }
}
