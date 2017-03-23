package meleshko.com.ideaintechtask1.ui.activities2;

import android.os.Bundle;

import meleshko.com.ideaintechtask1.R;

public class TermsAndConditionsActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_tcs_fragment);

        setTitleActionBar("Terms and Conditions");
    }
}
