package meleshko.com.ideaintechtask1.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import meleshko.com.ideaintechtask1.R;

public class WelcomeFragment3 extends Fragment {
    private ImageView mImageView;
    private TextView largeText;
    private TextView smallText;
    private ImageView circle_1, circle_2, circle_3;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.welcome_1_fragment, container, false);

        mImageView = (ImageView)v.findViewById(R.id.welcome_image);
        largeText = (TextView)v.findViewById(R.id.welcome_large);
        smallText = (TextView)v.findViewById(R.id.welcome_small);
        circle_1 = (ImageView)v.findViewById(R.id.welcom_circle_1);
        circle_2 = (ImageView)v.findViewById(R.id.welcom_circle_2);
        circle_3 = (ImageView)v.findViewById(R.id.welcom_circle_3);

        mImageView.setImageResource(R.drawable.onboarding_illustration_3);
        largeText.setText(getString(R.string.welcome_large_3));
        smallText.setText(getString(R.string.welcome_small_3));
        circle_1.setImageResource(R.drawable.ic_pagination);
        circle_2.setImageResource(R.drawable.ic_pagination);
        circle_3.setImageResource(R.drawable.ic_pagination_active);

        return v;
    }
}
