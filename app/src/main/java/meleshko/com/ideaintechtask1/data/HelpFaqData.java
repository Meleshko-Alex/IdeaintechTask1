package meleshko.com.ideaintechtask1.data;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import meleshko.com.ideaintechtask1.R;
import meleshko.com.ideaintechtask1.models.FaqModel;

public class HelpFaqData {
    private static HelpFaqData hfd;
    private static List<FaqModel> mFaqModelList = new ArrayList<>();

    public HelpFaqData(Context context) {

        mFaqModelList.add(new FaqModel(context.getString(R.string.help_faq_question_1), context.getString(R.string.help_faq_answer_1)));
        mFaqModelList.add(new FaqModel(context.getString(R.string.help_faq_question_2), context.getString(R.string.help_faq_answer_2)));
        mFaqModelList.add(new FaqModel(context.getString(R.string.help_faq_question_3), context.getString(R.string.help_faq_answer_3)));
        mFaqModelList.add(new FaqModel(context.getString(R.string.help_faq_question_4), context.getString(R.string.help_faq_answer_4)));
        mFaqModelList.add(new FaqModel(context.getString(R.string.help_faq_question_5), context.getString(R.string.help_faq_answer_5)));
        mFaqModelList.add(new FaqModel(context.getString(R.string.help_faq_question_6), context.getString(R.string.help_faq_answer_6)));
        mFaqModelList.add(new FaqModel(context.getString(R.string.help_faq_question_7), context.getString(R.string.help_faq_answer_7)));
        mFaqModelList.add(new FaqModel(context.getString(R.string.help_faq_question_8), context.getString(R.string.help_faq_answer_8)));
        mFaqModelList.add(new FaqModel(context.getString(R.string.help_faq_question_9), context.getString(R.string.help_faq_answer_9)));
    }

    public static List<FaqModel> getHelpFaqDataList(Context context){
        if(hfd == null){
            hfd = new HelpFaqData(context);
        }
        return mFaqModelList;
    }

}
