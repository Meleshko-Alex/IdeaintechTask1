package meleshko.com.ideaintechtask1.ui.activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.ui.adapters.ViewPagerFragmentAdapter;
import meleshko.com.ideaintechtask1.ui.fragments.HelpContactFragment;
import meleshko.com.ideaintechtask1.ui.fragments.HelpFaqFragment;
import meleshko.com.ideaintechtask1.ui.fragments.HelpTcsFragment;

public class HelpActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private TabLayout tabs;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        mViewPager = (ViewPager)findViewById(R.id.viewpager);

        setupToolbar();
        setupViewPager();
        setupTabs();
    }

    private void setupViewPager() {
        ViewPagerFragmentAdapter adapter = new ViewPagerFragmentAdapter(getSupportFragmentManager());
        adapter.addFragment(new HelpFaqFragment(), "FAQ");
        adapter.addFragment(new HelpContactFragment(), "CONTACT");
        adapter.addFragment(new HelpTcsFragment(), "T&CS");
        mViewPager.setAdapter(adapter);
    }

    private void setupTabs() {
        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(mViewPager);
        changeTabsFont();
    }

    private void setupToolbar() {
        this.getSupportActionBar().setTitle(R.string.help);
        ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void changeTabsFont() {

        ViewGroup vg = (ViewGroup) tabs.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf"));
                }
            }
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
}
