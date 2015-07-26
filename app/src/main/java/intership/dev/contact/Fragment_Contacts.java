package intership.dev.contact;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 7/23/2015.
 */
public class Fragment_Contacts extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final int position;
        View rootview=inflater.inflate(R.layout.fragment_contact,container,false);
//        Toast.makeText(getActivity(),getArguments().getInt("ic")+"",Toast.LENGTH_LONG).show();
        CircleImageView ic= (CircleImageView) rootview.findViewById(R.id.icContactFragment);
        ic.setImageResource(getArguments().getInt("ic"));
        TextView tvName= (TextView) rootview.findViewById(R.id.tvNameContactFragment);
        tvName.setText(getArguments().getString("tv"));
        final EditText edtDes= (EditText) rootview.findViewById(R.id.tvDescription);
        edtDes.setText(getArguments().getString("des"));
        final EditText edtName2= (EditText) rootview.findViewById(R.id.tvNameFragment);
        edtName2.setText(getArguments().getString("tv"));
        Button btnSave= (Button) rootview.findViewById(R.id.btnSave);
        position=getArguments().getInt("position");
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabase mydb = new MyDatabase(getActivity());
                mydb.open();
                try {
                    if (mydb.Update_Contact(Constant.array_contact.get(position).getTvNameContact(),edtName2.getText().toString(),edtDes.getText().toString())) {
                    } else {
                        Toast.makeText(getActivity(), "Update Contact error....", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Update Contact error....", Toast.LENGTH_SHORT).show();
                }
                mydb.close();
                Constant.array_contact.get(position).setTvNameContact(edtName2.getText().toString());
                Constant.array_contact.get(position).setDescription(edtDes.getText().toString());
                MainActivity.adapter_contact.notifyDataSetChanged();
                MainActivity.frameLayout.setVisibility(View.GONE);


                //TODO
            }
        });
        Button btnCancle= (Button) rootview.findViewById(R.id.btnCancle);
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.frameLayout.setVisibility(View.GONE);

            }
        });


        return rootview;
    }
}
