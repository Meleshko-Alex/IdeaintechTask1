package meleshko.com.ideaintechtask1.ui.activities2;

import android.app.Dialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;

import meleshko.com.ideaintechtask1.R;

public class PopupMenu extends BottomSheetDialogFragment {

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.fragment_bottom_sheet, null);
        dialog.setContentView(contentView);
    }
}
