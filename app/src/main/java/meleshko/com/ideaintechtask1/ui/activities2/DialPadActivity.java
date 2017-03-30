package meleshko.com.ideaintechtask1.ui.activities2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.models.Contact;
import meleshko.com.ideaintechtask1.ui.adapters.ContactRecyclerAdapter;

import static meleshko.com.ideaintechtask1.R.id.btn_key_0;


public class DialPadActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{
    @BindView(R.id.imput_line)TextView mInputLine;
    @BindView(btn_key_0)LinearLayout mKey0;
    @BindView(R.id.btn_key_1)LinearLayout mKey1;
    @BindView(R.id.btn_key_2)RelativeLayout mKey2;
    @BindView(R.id.btn_key_3)RelativeLayout mKey3;
    @BindView(R.id.btn_key_4)RelativeLayout mKey4;
    @BindView(R.id.btn_key_5)RelativeLayout mKey5;
    @BindView(R.id.btn_key_6)RelativeLayout mKey6;
    @BindView(R.id.btn_key_7)RelativeLayout mKey7;
    @BindView(R.id.btn_key_8)RelativeLayout mKey8;
    @BindView(R.id.btn_key_9)RelativeLayout mKey9;
    @BindView(R.id.btn_key_dash)LinearLayout mKeyDash;
    @BindView(R.id.btn_key_point)LinearLayout mKeyPoint;
    @BindView(R.id.btn_key_delete)LinearLayout mKeyDelete;
    @BindView(R.id.btn_key_star)RelativeLayout mKeyStar;
    @BindView(R.id.btn_key_leng)FrameLayout mKeyLeng;
    @BindView(R.id.btn_key_ok)LinearLayout mKeyOk;
    @BindView(R.id.call_btn)ImageView mKeyCall;
    @BindView(R.id.recycler_contact)RecyclerView mRecyclerView;
    @BindView(R.id.rl_invis)RelativeLayout mInvisBlock;

    private StringBuilder mBuilderLine;
    private ArrayList<Contact> mContactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial_pad);

        ButterKnife.bind(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(DialPadActivity.this));
        setupOnClick();
        setupOnLongClick();
        //setupSearchListener();
        mContactList = getContactList();
        mBuilderLine = new StringBuilder();
        setCountryCode();
    }

    private void setCountryCode() {
        // TODO Now we setCode +44, but we must get value from ...
        appendChar("+44");
    }

    private ArrayList<Contact> getContactList(){
        // TODO Now we return prepared List , but we must return List from DB
        ArrayList<Contact> preparedList = new ArrayList<>();
        preparedList.add(new Contact("Adam Meers", "+44777555333"));
        preparedList.add(new Contact("Alex Pavlov", "+4788345347"));
        preparedList.add(new Contact("Piter Pen", "+44773345677"));
        return preparedList;
    }

    private void deleteChar() {
        if (mBuilderLine.length() > 0){
            mBuilderLine.deleteCharAt(mBuilderLine.length() - 1);
            mInputLine.setText(mBuilderLine.toString());
            checkEquals();
        }
    }

    private void deleteAllChars() {
        if (mBuilderLine.length() > 0){
            mBuilderLine.delete(0, mBuilderLine.length());
            mInputLine.setText(mBuilderLine.toString());
        }
    }

    private void appendChar(String simvol) {
        mBuilderLine.append(simvol);
        mInputLine.setText(mBuilderLine.toString());
        checkEquals();
    }

    private void checkEquals(){
        ArrayList<Contact> tempList = new ArrayList<>();

        for(Contact temp : mContactList){
            if(temp.getPhoneNumber().toLowerCase().contains(mBuilderLine.toString().toLowerCase())){
                tempList.add(temp);
            }
        }
        ContactRecyclerAdapter adapter = new ContactRecyclerAdapter(tempList, DialPadActivity.this);
        mRecyclerView.setAdapter(adapter);
        if (tempList.size() > 0 && mBuilderLine.length() > 0){
            mRecyclerView.setVisibility(View.VISIBLE);
            mInvisBlock.setVisibility(View.GONE);
        } else {
            mRecyclerView.setVisibility(View.GONE);
            mInvisBlock.setVisibility(View.VISIBLE);
        }
    }

    private void setupOnClick() {
        mKey0.setOnClickListener(this);
        mKey1.setOnClickListener(this);
        mKey2.setOnClickListener(this);
        mKey3.setOnClickListener(this);
        mKey4.setOnClickListener(this);
        mKey5.setOnClickListener(this);
        mKey6.setOnClickListener(this);
        mKey7.setOnClickListener(this);
        mKey8.setOnClickListener(this);
        mKey9.setOnClickListener(this);
        mKeyDelete.setOnClickListener(this);
        mKeyDash.setOnClickListener(this);
        mKeyPoint.setOnClickListener(this);
        mKeyStar.setOnClickListener(this);
        mKeyLeng.setOnClickListener(this);
        mKeyOk.setOnClickListener(this);
        mKeyCall.setOnClickListener(this);
    }

    private void setupOnLongClick() {
        mKey0.setOnLongClickListener(this);
        mKey1.setOnLongClickListener(this);
        mKey2.setOnLongClickListener(this);
        mKey3.setOnLongClickListener(this);
        mKey4.setOnLongClickListener(this);
        mKey5.setOnLongClickListener(this);
        mKey6.setOnLongClickListener(this);
        mKey7.setOnLongClickListener(this);
        mKey8.setOnLongClickListener(this);
        mKey9.setOnLongClickListener(this);
        mKeyStar.setOnLongClickListener(this);
        mKeyLeng.setOnLongClickListener(this);
        mKeyDelete.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_key_0:
                appendChar("0");
                break;
            case R.id.btn_key_1:
                appendChar("1");
                break;
            case R.id.btn_key_2:
                appendChar("2");
                break;
            case R.id.btn_key_3:
                appendChar("3");
                break;
            case R.id.btn_key_4:
                appendChar("4");
                break;
            case R.id.btn_key_5:
                appendChar("5");
                break;
            case R.id.btn_key_6:
                appendChar("6");
                break;
            case R.id.btn_key_7:
                appendChar("7");
                break;
            case R.id.btn_key_8:
                appendChar("8");
                break;
            case R.id.btn_key_9:
                appendChar("9");
                break;
            case R.id.btn_key_dash:
                appendChar("-");
                break;
            case R.id.btn_key_point:
                appendChar(".");
                break;
            case R.id.btn_key_delete:
                deleteChar();
                break;
            case R.id.btn_key_star:
                appendChar("*");
                break;
            case R.id.btn_key_leng:
                break;
            case R.id.btn_key_ok:
                break;
            case R.id.call_btn:
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()){
            case btn_key_0:
                appendChar("+");
                break;
            case R.id.btn_key_2:
                break;
            case R.id.btn_key_3:
                break;
            case R.id.btn_key_4:
                break;
            case R.id.btn_key_5:
                break;
            case R.id.btn_key_6:
                break;
            case R.id.btn_key_7:
                break;
            case R.id.btn_key_8:
                break;
            case R.id.btn_key_9:
                break;
            case R.id.btn_key_star:
                appendChar("#");
                break;
            case R.id.btn_key_leng:
                break;
            case R.id.btn_key_delete:
                deleteAllChars();
                break;
        }
        return false;
    }

}
