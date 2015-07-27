package intership.dev.contact;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 7/24/2015.
 */
public class Add_Contact extends Activity {
    private Gallery galleryicon;
    int listIcon[]={R.drawable.ic_man4,R.drawable.ic_man5
            ,R.drawable.ic_man6,R.drawable.ic_woman1,R.drawable.ic_woman4
            ,R.drawable.ic_woman5,R.drawable.ic_woman6,R.drawable.ic_woman7
            ,R.drawable.ic_woman8,R.drawable.ic_woman9,R.drawable.ic_woman10
            ,R.drawable.ic_man1,R.drawable.ic_man2,R.drawable.ic_man3
            ,R.drawable.ic_woman2,R.drawable.ic_woman3};
    private ImageView imview;
    private EditText edtName,edtDes;
    private Button btnAdd,btnthoat,btnBoqua;
    private int icon=R.drawable.ic_man1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);
        Init();
        imview.setImageResource(listIcon[0]);
        galleryicon.setSpacing(5);
        Gallery_Adapter gAdapter=new Gallery_Adapter(this,listIcon);
        galleryicon.setAdapter(gAdapter);
        galleryicon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                imview.setImageResource(listIcon[position]);
                icon = listIcon[position];

            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtName.getText().length() == 0) {
                    Toast.makeText(Add_Contact.this, "Vui Lòng Nhập Tên", Toast.LENGTH_SHORT).show();
                } else {
                    MyDatabase db = new MyDatabase(Add_Contact.this);
                    db.open();
                    long rs = 0;
                    try {
                        rs = db.Insert_Contacts(icon, edtName.getText().toString(), edtDes.getText().toString());
                    } catch (Exception e) {
                        Toast.makeText(Add_Contact.this, "Lưu Không Thành Công", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (rs == -1) {
                        Toast.makeText(Add_Contact.this, "Thêm Tên Bị Lỗi", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        Toast.makeText(Add_Contact.this, "Thêm Tên Thành Công", Toast.LENGTH_SHORT).show();
                    }
                    db.close();
                    Intent intent = new Intent(Add_Contact.this, MainActivity.class);
                    startActivity(intent);
//                    finish();

                }
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Add_Contact.this);
                builder.setTitle("Question ? ");
                builder.setMessage("Bạn Muốn Thoát Khỏi Ứng Dụng ?");
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
                       finish();

                    }
                });
                builder.create().show();
            }
        });
        btnBoqua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Add_Contact.this, MainActivity.class);
                startActivity(intent);
//                finish();
            }
        });
    }
    public void Init(){
        imview= (ImageView) findViewById(R.id.icContactAdd);
        edtName= (EditText) findViewById(R.id.edtName);
        edtDes= (EditText) findViewById(R.id.edtDescription);
        btnAdd= (Button) findViewById(R.id.btnAdd);
        btnthoat= (Button) findViewById(R.id.btnThoat);
        btnBoqua= (Button) findViewById(R.id.btnBoqua);
        galleryicon= (Gallery) findViewById(R.id.galleryIcon);
    }




}
