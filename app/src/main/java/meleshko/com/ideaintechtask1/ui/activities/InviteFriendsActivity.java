package meleshko.com.ideaintechtask1.ui.activities;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import meleshko.com.ideaintechtask1.R;

public class InviteFriendsActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView btn_invite_sms, btn_invite_email, btn_invite_skype;
    private ImageView btn_invite_email_copy, btn_invite_wechat, btn_invite_snapchat;
    private ImageView btn_invite_telegram, btn_invite_link, btn_invite_share;
    private String inviteText = "We invite you in talkremit";

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
                inviteByApp();
                break;
            case R.id.btn_invite_email:
                inviteByEmail();
                break;
            case R.id.btn_invite_skype:
                if(!openApp("com.skype.raider")) createDialog();
                break;
            case R.id.btn_invite_email_copy:
                if(!openApp("com.facebook.orca")) createDialog();
                break;
            case R.id.btn_invite_wechat:
                if(!openApp("com.tencent.mm")) createDialog();
                break;
            case R.id.btn_invite_snapchat:
                if(!openApp("com.snapchat.android")) createDialog();
                break;
            case R.id.btn_invite_telegram:
                if(!openApp("org.telegram.messenger")) createDialog();
                break;
            case R.id.btn_invite_link:
                copyLink();
                break;
            case R.id.btn_invite_share:
                inviteByApp();
                break;
        }
    }

    private void copyLink() {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("", inviteText);
        clipboard.setPrimaryClip(clip);
    }

    private void inviteByApp() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, inviteText);
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, "Send invite"));
    }

    private void inviteByEmail() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, inviteText);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private void createDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(InviteFriendsActivity.this);
        builder.setTitle("Sorry, You haven't this app!")
                .setMessage("Do you want install?")
                .setCancelable(false)
                .setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        builder.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                             public void onClick(DialogInterface dialog, int id) {
                                 dialog.cancel();
                             }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public boolean openApp(String packageName) {
        PackageManager manager = this.getPackageManager();
        Intent i = manager.getLaunchIntentForPackage(packageName);
        if (i == null) {
            return false;
        }
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        i.putExtra(Intent.EXTRA_TEXT, inviteText);
        i.setType("text/plain");
        i.setAction(Intent.ACTION_SEND);
        this.startActivity(i);
        return true;
    }
}
