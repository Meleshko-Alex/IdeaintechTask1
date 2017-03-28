package meleshko.com.ideaintechtask1.ui.adapters;


import android.content.Context;
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

public class MobileRatesCountryRecycAdapter extends RecyclerView.Adapter<MobileRatesCountryRecycAdapter.ViewHolder>implements FastScroller.SectionIndexer{
    private final ArrayList<Country> mCountry;
    private final Context mContext;

    public MobileRatesCountryRecycAdapter(ArrayList<Country> country, Context context) {
        mCountry = country;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_top_contries, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MobileRatesCountryRecycAdapter.ViewHolder holder, int position) {
        holder.recyc_item_image.setImageDrawable(getRoundImage(mCountry.get(position).getFlagImageRes()));
        holder.recyc_tv_country_name.setText(mCountry.get(position).getName());
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
        RelativeLayout recyc_item_rl;
        ImageView recyc_item_image;
        ImageView recyc_right_img;
        TextView recyc_tv_country_name;

        public ViewHolder(final View itemView) {
            super(itemView);
            recyc_item_rl = (RelativeLayout)itemView.findViewById(R.id.recyc_item_rl);
            recyc_item_image = (ImageView)itemView.findViewById(R.id.recyc_item_image);
            recyc_right_img = (ImageView)itemView.findViewById(R.id.recyc_right_img);
            recyc_tv_country_name = (TextView)itemView.findViewById(R.id.recyc_tv_country_name);

            recyc_item_rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO
                }
            });
        }
    }
}
