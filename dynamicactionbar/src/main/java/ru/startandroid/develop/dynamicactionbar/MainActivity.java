package ru.startandroid.develop.dynamicactionbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    final int MENU_ID = 1;

    CheckBox chbAddDell;
    CheckBox chbVisible;

    Fragment frag1,
             frag2,
             frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        chbAddDell = findViewById(R.id.chbAddDel);
        chbVisible = findViewById(R.id.chbVisible);

        frag = frag1 = new MyFrag1();
        frag2 = new MyFrag2();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        menu.setGroupVisible(R.id.groupVsbl, chbVisible.isChecked());
        if(chbAddDell.isChecked()) {
            menu.add(0, MENU_ID, 0, R.string.menu_item1)
                    .setIcon(android.R.drawable.ic_delete)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        } else {
            menu.removeItem(MENU_ID);
        }
        return true;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.chbAddDel:
            case R.id.chbVisible:
                invalidateOptionsMenu(); /// перерисовка меню / ActionBar
                break;
            case R.id.btnFrag:
                frag = (frag == frag1) ? frag2 : frag1;
                getSupportFragmentManager().beginTransaction().replace(R.id.cont, frag).commit();
                break;
            default:
                break;
        }
    }
}