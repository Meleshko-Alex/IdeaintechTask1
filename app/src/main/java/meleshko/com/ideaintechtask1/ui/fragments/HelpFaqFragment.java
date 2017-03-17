package meleshko.com.ideaintechtask1.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.data.HelpFaqData;
import meleshko.com.ideaintechtask1.models.FaqModel;
import meleshko.com.ideaintechtask1.ui.adapters.FaqExpandableListAdapter;

public class HelpFaqFragment extends Fragment {
    private ExpandableListView exListView;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View  v = inflater.inflate(R.layout.help_faq_fragment, container, false);
        exListView = (ExpandableListView)v.findViewById(R.id.exListView);
        setupExListViewData();

        return v;
    }

    private void setupExListViewData() {
        List<FaqModel> faqList;
        ArrayList<Map<String, String>> groupDataList = new ArrayList<>();
        faqList = HelpFaqData.getHelpFaqDataList(getContext());

        Map<String, String> map;
        for (FaqModel question : faqList){
            map = new HashMap<>();
            map.put("question", question.getQuation());
            groupDataList.add(map);
        }

        String groupFrom[] = new String[] {"question"};
        int groupTo[] = new int[] { R.id.faq_quation };
        ArrayList<ArrayList<Map<String, String>>> сhildDataList = new ArrayList<>();

        for (int i = 0; i < faqList.size(); i++){
            ArrayList<Map<String, String>> сhildDataItemList = new ArrayList<>();
            map = new HashMap<>();
            map.put("answer", faqList.get(i).getAnswer());
            сhildDataItemList.add(map);
            сhildDataList.add(сhildDataItemList);
        }

        String childFrom[] = new String[] {"answer"};
        int childTo[] = new int[] { R.id.faq_answer };

        FaqExpandableListAdapter adapter = new FaqExpandableListAdapter(
                getContext(), groupDataList,
                R.layout.fag_quation_item, groupFrom,
                groupTo, сhildDataList, R.layout.faq_answer_item,
                childFrom, childTo);

        exListView.setAdapter(adapter);
        //exListView.setIndicatorBounds(10, 20);
    }
}
