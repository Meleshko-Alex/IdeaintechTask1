package meleshko.com.ideaintechtask1.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SimpleExpandableListAdapter;

import java.util.List;
import java.util.Map;

import meleshko.com.ideaintechtask1.R;


public class FaqExpandableListAdapter extends SimpleExpandableListAdapter {
    private Context mContext;

    public FaqExpandableListAdapter(Context context, List<? extends Map<String, ?>> groupData, int groupLayout, String[] groupFrom, int[] groupTo, List<? extends List<? extends Map<String, ?>>> childData, int childLayout, String[] childFrom, int[] childTo) {
        super(context, groupData, groupLayout, groupFrom, groupTo, childData, childLayout, childFrom, childTo);
        mContext = context;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fag_quation_item, null);
        }

        ImageView image = (ImageView)convertView.findViewById(R.id.help_faq_image);
        RelativeLayout rl = (RelativeLayout)convertView.findViewById(R.id.faq_rel_layout);

        View v = super.getGroupView(groupPosition, isExpanded, convertView, parent);

        if (isExpanded) {
            image.setImageResource(R.drawable.ic_expand_less_black_24dp);
            rl.setBackgroundResource(R.color.white);
        } else {
            image.setImageResource(R.drawable.ic_expand_more_black_24dp);
            rl.setBackgroundResource(R.color.pale_blue);
        }
        return v;
    }
}
