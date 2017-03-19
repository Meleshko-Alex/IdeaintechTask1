package meleshko.com.ideaintechtask1.ui.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.ui.adapters.ViewPagerFragmentAdapter;
import meleshko.com.ideaintechtask1.ui.fragments.WelcomeFragment1;
import meleshko.com.ideaintechtask1.ui.fragments.WelcomeFragment2;
import meleshko.com.ideaintechtask1.ui.fragments.WelcomeFragment3;

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
        adapter.addFragment(new WelcomeFragment1(), "");
        adapter.addFragment(new WelcomeFragment2(), "");
        adapter.addFragment(new WelcomeFragment3(), "");
        mViewPager.setAdapter(adapter);
    }
}
