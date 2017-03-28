package meleshko.com.ideaintechtask1.ui.activities2;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.l4digital.fastscroll.FastScrollRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.data.DataManager;
import meleshko.com.ideaintechtask1.models.Country;
import meleshko.com.ideaintechtask1.ui.adapters.CountryCodeRecyclerAdapter;

public class SelectCountryActivity extends BaseActivity {
    private ArrayList<Country> countryList;
    private DataManager mDataManager;

    @BindView(R.id.recycler_country) FastScrollRecyclerView recycler_country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_country);
        ButterKnife.bind(this);
        setTitleActionBar(getString(R.string.select_country));
        mDataManager = DataManager.getInstance();
        countryList = mDataManager.getCountryList();

        recycler_country.setLayoutManager(new LinearLayoutManager(this));
        CountryCodeRecyclerAdapter adapter = new CountryCodeRecyclerAdapter(countryList, this, false);
        recycler_country.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Country> tempList = new ArrayList<>();

                for(Country temp : countryList){
                    if(temp.getName().toLowerCase().contains(newText.toLowerCase())){
                        tempList.add(temp);
                    }
                }
                CountryCodeRecyclerAdapter adapter = new CountryCodeRecyclerAdapter(tempList, SelectCountryActivity.this, true);
                recycler_country.setAdapter(adapter);

                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
