package intership.dev.contact;


import android.app.AlertDialog;
import android.app.Fragment;

import android.content.Context;
import android.content.DialogInterface;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;


/**
 * Created by Administrator on 7/22/2015.
 */
public class Custom_Adapter_Contact extends ArrayAdapter<Contacts_Item> {
    private Context context;
    public Custom_Adapter_Contact(Context context, int resource, ArrayList<Contacts_Item> arr) {
        super(context, resource, arr);
        this.context = context;
    }

    private class ViewHolder {
        private TextView tvNameContact;
        private ImageView icContact;
        private Button btnEdit, btnDelete;
        private LinearLayout linearLayout;
    }

    ViewHolder holder;
    Contacts_Item contact_item = null;

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View myView = convertView;
        if (convertView == null) {
            myView = LayoutInflater.from(context).inflate(R.layout.custom_listview_contact, parent, false);
            holder = new ViewHolder();
            holder.tvNameContact = (TextView) myView.findViewById(R.id.tvNameContact);
            holder.icContact = (ImageView) myView.findViewById(R.id.icContact);
            holder.btnEdit = (Button) myView.findViewById(R.id.btnEditContact);
            holder.btnDelete = (Button) myView.findViewById(R.id.btnDeleteContact);
            holder.linearLayout= (LinearLayout) myView.findViewById(R.id.LinerLayoutListview);
            myView.setTag(holder);

        } else {
            holder = (ViewHolder) myView.getTag();
        }
        contact_item = Constant.array_contact.get(position);
        holder.icContact.setImageResource(contact_item.getIc_contact());
        holder.tvNameContact.setText(contact_item.getTvNameContact());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Question ? ");
                builder.setMessage("Bạn Muốn Xóa Liên Hệ Này ?");
                builder.setIcon(R.drawable.ic_home_trangchu);
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Đúng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MyDatabase mydb = new MyDatabase(context);
                        mydb.open();
                        try {
                            if (mydb.delete_Contact(Constant.array_contact.get(position).getTvNameContact())) {

                            } else {
                                Toast.makeText(context, "Delete Contact error....", Toast.LENGTH_SHORT).show();
                            }
                            ;
                        } catch (Exception e) {
                            Toast.makeText(context, "Delete Contact error....", Toast.LENGTH_SHORT).show();
                        }
                        mydb.close();
                        Constant.array_contact.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.create().show();
            }
        });
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Fragment fragment = new Fragment_Contacts();
                    Bundle bd = new Bundle();
                    bd.putInt("ic", Constant.array_contact.get(position).getIc_contact());
                    bd.putString("tv", Constant.array_contact.get(position).getTvNameContact());
                    bd.putString("des", Constant.array_contact.get(position).getDescription());
                bd.putInt("position", position);
                    fragment.setArguments(bd);
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
                    MainActivity.frameLayout.setVisibility(View.VISIBLE);

            }
        });
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,Constant.array_contact.get(position).getDescription()+"", Toast.LENGTH_LONG).show();
            }
        });

        return myView;
    }
}
