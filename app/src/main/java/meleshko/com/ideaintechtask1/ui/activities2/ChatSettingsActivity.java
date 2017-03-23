package meleshko.com.ideaintechtask1.ui.activities2;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Switch;

import meleshko.com.ideaintechtask1.R;

public class ChatSettingsActivity extends BaseActivity implements View.OnClickListener{
    private RelativeLayout chat_block, chat_wallpaper, chat_backup;
    private RelativeLayout chat_archive, chat_clear_all, chat_delete_all;
    private Switch chat_settinga_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_settings);

        setTitleActionBar("Chat settings");

        chat_block = (RelativeLayout)findViewById(R.id.chat_block);
        chat_block.setOnClickListener(this);
        chat_wallpaper = (RelativeLayout)findViewById(R.id.chat_wallpaper);
        chat_wallpaper.setOnClickListener(this);
        chat_backup = (RelativeLayout)findViewById(R.id.chat_backup);
        chat_backup.setOnClickListener(this);
        chat_archive = (RelativeLayout)findViewById(R.id.chat_archive);
        chat_archive.setOnClickListener(this);
        chat_clear_all = (RelativeLayout)findViewById(R.id.chat_clear_all);
        chat_clear_all.setOnClickListener(this);
        chat_delete_all = (RelativeLayout)findViewById(R.id.chat_delete_all);
        chat_delete_all.setOnClickListener(this);
        chat_settinga_switch = (Switch)findViewById(R.id.chat_settinga_switch);
        chat_settinga_switch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chat_block:
                break;
            case R.id.chat_wallpaper:
                break;
            case R.id.chat_backup:
                break;
            case R.id.chat_archive:
                break;
            case R.id.chat_clear_all:
                break;
            case R.id.chat_delete_all:
                break;
            case R.id.chat_settinga_switch:
                break;
        }
    }
}
