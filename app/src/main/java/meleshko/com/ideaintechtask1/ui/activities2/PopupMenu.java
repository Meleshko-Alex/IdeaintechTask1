package meleshko.com.ideaintechtask1.ui.activities2;

import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import meleshko.com.ideaintechtask1.R;

public class PopupMenu extends BottomSheetDialogFragment implements View.OnClickListener{
    @BindView(R.id.popup_call_menu_image)ImageView mProfilePhoto;
    @BindView(R.id.popup_call_menu_topup_btn)ImageView mButtonTopUp;
    @BindView(R.id.popup_call_menu_flag)ImageView mImageFlag;
    @BindView(R.id.popup_call_menu_free_call)ImageView mButtonFreeCall;
    @BindView(R.id.popup_call_menu_mobile_call)ImageView mButtonMobileCall;
    @BindView(R.id.popup_call_menu_name)TextView mProfileName;
    @BindView(R.id.popup_call_menu_number)TextView mProfileNamber;
    @BindView(R.id.popup_call_menu_recent_number)TextView mRecentNumber;
    private Unbinder unbinder;

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
        unbinder = ButterKnife.bind(this, view);

        mButtonTopUp.setOnClickListener(this);
        mButtonFreeCall.setOnClickListener(this);
        mButtonMobileCall.setOnClickListener(this);
        return view;
    }

    /*@Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.fragment_bottom_sheet, null);
        dialog.setContentView(contentView);
    }*/

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.popup_call_menu_topup_btn:
                Toast.makeText(getContext(), "AAAAAAAAA", Toast.LENGTH_SHORT).show();
                break;
            case R.id.popup_call_menu_free_call:
                Toast.makeText(getContext(), "BBBBBBBBB", Toast.LENGTH_SHORT).show();
                break;
            case R.id.popup_call_menu_mobile_call:
                Toast.makeText(getContext(), "CCCCCCCCC", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
