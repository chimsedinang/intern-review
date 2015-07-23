package intership.dev.contact;

import android.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    public ListView lvContact;
    public Contacts_Item contacts_item;
    public ArrayList<Contacts_Item> array_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentActionbar();
        array_contact=new ArrayList<Contacts_Item>();
        array_contact.add(new Contacts_Item(R.drawable.ic_nu,"Chimse"));
        array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1,"Dinang"));
        array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1,"Ai Ia"));
        array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1,"O Dau"));
        array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1, " Ma Thui"));
        array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1, "Gom Rua"));
        array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1,"Dinang"));
        array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1, "Dinang"));
        array_contact.add(new Contacts_Item(R.drawable.ic_recipe_to_try_1,"Dinang"));
        Custom_Adapter_Contact adapter_contact=new Custom_Adapter_Contact(MainActivity.this,R.layout.custom_listview_contact,array_contact);
        lvContact=(ListView)findViewById(R.id.lvContact);
        lvContact.setAdapter(adapter_contact);

    }





    public void parentActionbar() {
        ActionBar parent_Actionbar = getActionBar();
        parent_Actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        parent_Actionbar.setDisplayShowTitleEnabled(false);
        parent_Actionbar.setDisplayShowHomeEnabled(false);
        parent_Actionbar.setHomeButtonEnabled(false);
        parent_Actionbar.setCustomView(R.layout.item_contact_actionbar);
        ImageView imvback = (ImageView) parent_Actionbar.getCustomView().findViewById(R.id.imvBack);
        imvback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //TODO code
            }
        });
//        parent_Actionbar.setDisplayShowCustomEnabled(true);
        parent_Actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
