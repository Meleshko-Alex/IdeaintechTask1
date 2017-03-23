package meleshko.com.ideaintechtask1.ui.activities2;

import android.os.Bundle;
import android.widget.EditText;

import meleshko.com.ideaintechtask1.R;

public class ContactUsActivity extends BaseActivity {
    private EditText et_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        setTitleActionBar("Contact us");

        et_message = (EditText)findViewById(R.id.et_message);
    }
}
