package intership.dev.contact;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private ListView lvContact;
    private Contacts_Item contacts_item;
    public static FrameLayout frameLayout;
    public static FragmentManager fragmentManager;
    public static Custom_Adapter_Contact adapter_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentActionbar();
        Constant.array_contact.add(new Contacts_Item(R.drawable.ic_nu, "Chimse", ""));
        Constant.array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1, "Dinang", ""));
        Constant.array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1,"Ai Ia",""));
        Constant.array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1,"O Dau",""));
        Constant.array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1, " Ma Thui",""));
        Constant.array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1, "Gom Rua",""));
        Constant.array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1,"Dinang",""));
        Constant.array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1, "Dinang",""));
        Constant.array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1,"Dinang",""));
        adapter_contact=new Custom_Adapter_Contact(MainActivity.this,R.layout.custom_listview_contact, Constant.array_contact);
        lvContact=(ListView)findViewById(R.id.lvContact);
        lvContact.setAdapter(adapter_contact);
        frameLayout= (FrameLayout) findViewById(R.id.frame_container);
        fragmentManager=getFragmentManager();
        Fragment fragment=new Fragment_Contacts();
        Bundle bd=new Bundle();
        bd.putInt("ic", Constant.array_contact.get(0).getIc_contact());
        bd.putString("tv", Constant.array_contact.get(0).getTvNameContact());
        bd.putString("des", Constant.array_contact.get(0).getDescription());
        bd.putInt("position", 0);
        fragment.setArguments(bd);
        MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit();


    }





    public void parentActionbar() {
        ActionBar parent_Actionbar = getActionBar();
        parent_Actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        parent_Actionbar.setDisplayShowTitleEnabled(false);
        parent_Actionbar.setDisplayShowHomeEnabled(false);
        parent_Actionbar.setCustomView(R.layout.item_contact_actionbar);
        ImageView imvback = (ImageView) parent_Actionbar.getCustomView().findViewById(R.id.imvBack);
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        parent_Actionbar.setDisplayShowCustomEnabled(true);
        parent_Actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
    }


}
