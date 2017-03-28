package meleshko.com.ideaintechtask1.ui.activities2;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.data.DataManager;
import meleshko.com.ideaintechtask1.models.Country;
import meleshko.com.ideaintechtask1.ui.adapters.MobileRatesCountryRecycAdapter;

public class MobileRatesActivity extends BaseActivity {
    private ArrayList<Country> allCountriesList;
    private ArrayList<Country> topCountriesList;
    private DataManager mDataManager;
    @BindView(R.id.recycler_top_countries) RecyclerView recycler_top_countries;
    @BindView(R.id.recycler_all_countries) RecyclerView recycler_all_countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_rates);

        ButterKnife.bind(this);

        setTitleActionBar("Mobile Rates");
        mDataManager = DataManager.getInstance();
        allCountriesList = mDataManager.getCountryList();
        topCountriesList = getTopCountriesList();

        recycler_top_countries.setLayoutManager(new LinearLayoutManager(this));
        MobileRatesCountryRecycAdapter adapterTopCountries = new MobileRatesCountryRecycAdapter(topCountriesList, this);
        recycler_top_countries.setAdapter(adapterTopCountries);

        recycler_all_countries.setLayoutManager(new LinearLayoutManager(this));
        MobileRatesCountryRecycAdapter adapterAllCountries = new MobileRatesCountryRecycAdapter(allCountriesList, this);
        recycler_all_countries.setAdapter(adapterAllCountries);
    }

    // TODO This method must load TopCountriesList from some resourse
    private ArrayList<Country> getTopCountriesList() {
        ArrayList<Country> topCountries = new ArrayList<>();
        topCountries.add(new Country("United Kingdom", "+44", getResources().getIdentifier("gb", "drawable", getPackageName())));
        topCountries.add(new Country("United States", "+1", getResources().getIdentifier("us", "drawable", getPackageName())));
        return topCountries;
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
                ArrayList<Country> tempListAllContries = new ArrayList<>();
                ArrayList<Country> tempListTopContries = new ArrayList<>();

                for(Country temp : allCountriesList){
                    if(temp.getName().toLowerCase().contains(newText.toLowerCase())){
                        tempListAllContries.add(temp);
                    }
                }
                for(Country temp : topCountriesList){
                    if(temp.getName().toLowerCase().contains(newText.toLowerCase())){
                        tempListTopContries.add(temp);
                    }
                }

                MobileRatesCountryRecycAdapter adapterAllContries =
                        new MobileRatesCountryRecycAdapter(tempListAllContries, MobileRatesActivity.this);
                recycler_all_countries.setAdapter(adapterAllContries);

                MobileRatesCountryRecycAdapter adapterTopCOntries =
                        new MobileRatesCountryRecycAdapter(tempListTopContries, MobileRatesActivity.this);
                recycler_top_countries.setAdapter(adapterTopCOntries);

                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
