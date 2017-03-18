package meleshko.com.ideaintechtask1.ui.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.ui.adapters.ViewPagerFragmentAdapter;
import meleshko.com.ideaintechtask1.ui.fragments.HelpContactFragment;
import meleshko.com.ideaintechtask1.ui.fragments.HelpFaqFragment;
import meleshko.com.ideaintechtask1.ui.fragments.HelpTcsFragment;

public class WelcomActivity extends AppCompatActivity {
    private ViewPager mViewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mViewPager = (ViewPager)findViewById(R.id.viewpager_welcome);
        setupViewPager();

    }

    private void setupViewPager() {
        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new WelcomeFragment1(), "FAQ");
        adapter.addFragment(new WelcomeFragment2(), "CONTACT");
        adapter.addFragment(new WelcomeFragment3(), "T&CS");
        mViewPager.setAdapter(adapter6);
    }
}
