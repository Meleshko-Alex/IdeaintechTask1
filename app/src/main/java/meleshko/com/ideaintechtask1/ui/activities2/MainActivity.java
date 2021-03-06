package meleshko.com.ideaintechtask1.ui.activities2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import meleshko.com.ideaintechtask1.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private BottomSheetBehavior mBottomSheetBehavior;
    private DrawerLayout mNavigationDrawer;
    private NavigationView navigation_view;
    private View header;
    private LinearLayout ll_chat_settings, ll_notifications, ll_invite_friends, ll_remittance_profile;
    private LinearLayout ll_transactions, ll_beneficiaries, ll_help;
    private final int REQUEST_COUTRY = 777;
    private ImageView iv_profile;

    @BindView(R.id.btn_select_country)Button btn_select_country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setupPopupMenu();

        mNavigationDrawer = (DrawerLayout)findViewById(R.id.navigation_drawer);
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

        iv_profile = (ImageView)header.findViewById(R.id.iv_profile);
        iv_profile.setOnClickListener(this);
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

    private void setupPopupMenu(){
        View bottomSheet = findViewById(R.id.bottom_sheet);
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        mBottomSheetBehavior.setPeekHeight(0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_chat_settings:
                Intent chatIntent = new Intent(this, ChatSettingsActivity.class);
                startActivity(chatIntent);
                break;
            case R.id.ll_notifications:
                Intent intentMobileRates = new Intent(this, MobileRatesActivity.class);
                startActivity(intentMobileRates);
                break;
            case R.id.ll_invite_friends:
                Intent intentDialPad = new Intent(this, DialPadActivity.class);
                startActivity(intentDialPad);
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
            case R.id.iv_profile:
                Intent intentProfile = new Intent(this, ProfileActivity.class);
                startActivity(intentProfile);
                break;
        }
    }

    @OnClick(R.id.btn_select_country)
    public void submit(View view) {
        /*Intent intent = new Intent(this, SelectCountryActivity.class);
        startActivityForResult(intent, REQUEST_COUTRY);*/
        showPopupMenu();
    }

    private void showPopupMenu() {
        BottomSheetDialogFragment popupMenu = new PopupMenu();
        popupMenu.show(getSupportFragmentManager(), "Bottom Sheet Dialog Fragment");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (data != null){
                btn_select_country.setText(data.getStringExtra("EXTRA_ANSWER_COUNTRY_CODE"));
            }
        }
    }
}
