package meleshko.com.ideaintechtask1.ui.activities2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import meleshko.com.ideaintechtask1.R;

public class ProfileActivity extends AppCompatActivity {
    @BindView(R.id.btn_photo)ImageView btn_photo;
    @BindView(R.id.profile_back_img)ImageView profile_back_img;
    @BindView(R.id.et_profile_name)TextView et_profile_name;
    @BindView(R.id.et_email_name)TextView et_email_name;
    @BindView(R.id.et_phone_name)TextView et_phone_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.profile_back_img)
    public void submit(View view) {
        finish();
    }
}
