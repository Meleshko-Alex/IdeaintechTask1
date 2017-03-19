package meleshko.com.ideaintechtask1.ui.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import meleshko.com.ideaintechtask1.R;

public class InviteFriendsActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView btn_invite_sms, btn_invite_email, btn_invite_skype;
    private ImageView btn_invite_email_copy, btn_invite_wechat, btn_invite_snapchat;
    private ImageView btn_invite_telegram, btn_invite_link, btn_invite_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);

        btn_invite_sms = (ImageView)findViewById(R.id.btn_invite_sms);
        btn_invite_email = (ImageView)findViewById(R.id.btn_invite_email);
        btn_invite_skype = (ImageView)findViewById(R.id.btn_invite_skype);
        btn_invite_email_copy = (ImageView)findViewById(R.id.btn_invite_email_copy);
        btn_invite_wechat = (ImageView)findViewById(R.id.btn_invite_wechat);
        btn_invite_snapchat = (ImageView)findViewById(R.id.btn_invite_snapchat);
        btn_invite_telegram = (ImageView)findViewById(R.id.btn_invite_telegram);
        btn_invite_link = (ImageView)findViewById(R.id.btn_invite_link);
        btn_invite_share = (ImageView)findViewById(R.id.btn_invite_share);

        btn_invite_sms.setOnClickListener(this);
        btn_invite_email.setOnClickListener(this);
        btn_invite_skype.setOnClickListener(this);
        btn_invite_email_copy.setOnClickListener(this);
        btn_invite_wechat.setOnClickListener(this);
        btn_invite_snapchat.setOnClickListener(this);
        btn_invite_telegram.setOnClickListener(this);
        btn_invite_link.setOnClickListener(this);
        btn_invite_share.setOnClickListener(this);

        setupToolbar();
    }

    private void setupToolbar() {
        this.getSupportActionBar().setTitle(R.string.invite_fr);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_invite_sms:

                break;
            case R.id.btn_invite_email:

                break;
            case R.id.btn_invite_skype:

                break;
            case R.id.btn_invite_email_copy:

                break;
            case R.id.btn_invite_wechat:

                break;
            case R.id.btn_invite_snapchat:

                break;
            case R.id.btn_invite_telegram:

                break;
            case R.id.btn_invite_link:

                break;
            case R.id.btn_invite_share:

                break;
        }
    }
}
