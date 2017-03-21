package meleshko.com.ideaintechtask1.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.ui.fragments.BdImputDataFragment;
import meleshko.com.ideaintechtask1.ui.fragments.BdListFragment;

public class RealmBdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm_bd);

        if(savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.list_container, new BdListFragment())
                    .add(R.id.input_container, new BdImputDataFragment())
                    .commit();
        }
    }
}
