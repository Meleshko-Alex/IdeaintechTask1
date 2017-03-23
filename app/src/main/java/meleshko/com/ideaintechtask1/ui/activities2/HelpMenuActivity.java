package meleshko.com.ideaintechtask1.ui.activities2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import meleshko.com.ideaintechtask1.R;

public class HelpMenuActivity extends BaseActivity implements View.OnClickListener{
    private RelativeLayout help_feedback, help_faq, help_contact, help_terms, help_privacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_menu);

        help_feedback = (RelativeLayout)findViewById(R.id.help_feedback);
        help_feedback.setOnClickListener(this);
        help_faq = (RelativeLayout)findViewById(R.id.help_faq);
        help_faq.setOnClickListener(this);
        help_contact = (RelativeLayout)findViewById(R.id.help_contact);
        help_contact.setOnClickListener(this);
        help_terms = (RelativeLayout)findViewById(R.id.help_terms);
        help_terms.setOnClickListener(this);
        help_privacy = (RelativeLayout)findViewById(R.id.help_privacy);
        help_privacy.setOnClickListener(this);

        setTitleActionBar("Help");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.help_feedback:
                break;
            case R.id.help_faq:
                Intent faqIntent = new Intent(this, FaqActivity.class);
                startActivity(faqIntent);
                break;
            case R.id.help_contact:
                Intent intent = new Intent(this, ContactUsActivity.class);
                startActivity(intent);
                break;
            case R.id.help_terms:
                Intent termsIntent = new Intent(this, TermsAndConditionsActivity.class);
                startActivity(termsIntent);
                break;
            case R.id.help_privacy:
                break;
        }
    }
}
