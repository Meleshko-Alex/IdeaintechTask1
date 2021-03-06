package meleshko.com.ideaintechtask1.ui.adapters;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.l4digital.fastscroll.FastScroller;

import java.util.ArrayList;

import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.models.Country;
import meleshko.com.ideaintechtask1.utils.RoundImage;

import static android.app.Activity.RESULT_OK;

public class CountryCodeRecyclerAdapter extends RecyclerView.Adapter<CountryCodeRecyclerAdapter.ViewHolder> implements FastScroller.SectionIndexer{
    private static final String EXTRA_ANSWER_COUNTRY_CODE = "EXTRA_ANSWER_COUNTRY_CODE";
    private final ArrayList<Country> mCountry;
    private final Context mContext;
    private boolean isSearch;

    public CountryCodeRecyclerAdapter(ArrayList<Country> country, Context context, boolean isSearch) {
        mCountry = country;
        mContext = context;
        this.isSearch = isSearch;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_country_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryCodeRecyclerAdapter.ViewHolder holder, int position) {
        if(!isSearch){
            holder.item_big_letter.setText(mCountry.get(position).getFirstLetter());
        }
        holder.item_image.setImageDrawable(getRoundImage(mCountry.get(position).getFlagImageRes()));
        holder.item_country.setText(mCountry.get(position).getName());
        holder.item_country_code.setText(mCountry.get(position).getPhoneCode());

        if(!mCountry.get(position).getFirstLetter().equals("")
                && !mCountry.get(position).getFirstLetter().equals("A")
                && !isSearch){
            RecyclerView.LayoutParams head_params = (RecyclerView.LayoutParams)holder.item_rl.getLayoutParams();

            // перереводим px в dp
            head_params.setMargins(0, (int)(24 * (mContext.getResources().getDisplayMetrics().density)), 0, 0);
            holder.item_rl.setLayoutParams(head_params);
        } else {
            RecyclerView.LayoutParams head_params = (RecyclerView.LayoutParams)holder.item_rl.getLayoutParams();
            head_params.setMargins(0, 0, 0, 0);
            holder.item_rl.setLayoutParams(head_params);
        }
    }

    private Drawable getRoundImage(int flagImageRes) {
        Bitmap bitmap = BitmapFactory.decodeResource(mContext.getResources(), flagImageRes);
        RoundImage roundImage = new RoundImage(bitmap);
        return roundImage;
    }

    @Override
    public int getItemCount() {
        return mCountry.size();
    }

    @Override
    public String getSectionText(int position) {
        return String.valueOf(mCountry.get(position).getName().charAt(0));
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout item_rl;
        TextView item_big_letter;
        ImageView item_image;
        TextView item_country;
        TextView item_country_code;

        public ViewHolder(final View itemView) {
            super(itemView);
            item_rl = (RelativeLayout)itemView.findViewById(R.id.item_rl);
            item_big_letter = (TextView)itemView.findViewById(R.id.item_big_letter);
            item_image = (ImageView)itemView.findViewById(R.id.item_image);
            item_country = (TextView)itemView.findViewById(R.id.item_country);
            item_country_code = (TextView)itemView.findViewById(R.id.item_country_code);

            item_rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent data = new Intent();
                    data.putExtra(EXTRA_ANSWER_COUNTRY_CODE, item_country_code.getText().toString());
                    ((Activity)mContext).setResult(RESULT_OK, data);
                    ((Activity) mContext).finish();
                }
            });
        }
    }
}
