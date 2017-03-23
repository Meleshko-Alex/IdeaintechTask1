package meleshko.com.ideaintechtask1.ui.activities2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import meleshko.com.ideaintechtask1.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DrawerLayout mNavigationDrawer;
    private NavigationView navigation_view;
    private View header;
    private LinearLayout ll_chat_settings, ll_notifications, ll_invite_friends, ll_remittance_profile;
    private LinearLayout ll_transactions, ll_beneficiaries, ll_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation_view = (NavigationView)findViewById(R.id.navigation_view);
        header = navigation_view.getHeaderView(0);



        setupDrawer();
        setupNavigationViewData();
    }

    private void setupNavigationViewData() {

        ll_chat_settings = (LinearLayout)header.findViewById(R.id.ll_chat_settings);
        ll_chat_settings.setOnClickListener(this);
        ll_notifications = (LinearLayout)header.findViewById(R.id.ll_notifications);
        ll_notifications.setOnClickListener(this);
        ll_invite_friends = (LinearLayout)header.findViewById(R.id.ll_invite_friends);
        ll_invite_friends.setOnClickListener(this);
        ll_remittance_profile = (LinearLayout)header.findViewById(R.id.ll_remittance_profile);
        ll_remittance_profile.setOnClickListener(this);
        ll_transactions = (LinearLayout)header.findViewById(R.id.ll_transactions);
        ll_transactions.setOnClickListener(this);
        ll_beneficiaries = (LinearLayout)header.findViewById(R.id.ll_beneficiaries);
        ll_beneficiaries.setOnClickListener(this);
        ll_help = (LinearLayout)header.findViewById(R.id.ll_help);
        ll_help.setOnClickListener(this);
    }

    private void setupDrawer() {
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                item.setChecked(true);
                mNavigationDrawer.closeDrawer(GravityCompat.START);
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_chat_settings:
                Intent chatIntent = new Intent(this, ChatSettingsActivity.class);
                startActivity(chatIntent);
                break;
            case R.id.ll_notifications:
                break;
            case R.id.ll_invite_friends:
                break;
            case R.id.ll_remittance_profile:
                break;
            case R.id.ll_transactions:
                break;
            case R.id.ll_beneficiaries:
                break;
            case R.id.ll_help:
                Intent intent = new Intent(this, HelpMenuActivity.class);
                startActivity(intent);
                break;
        }
    }
}
