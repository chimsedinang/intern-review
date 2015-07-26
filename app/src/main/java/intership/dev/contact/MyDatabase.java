package intership.dev.contact;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase {
	String DATABASE_NAM="contacts";
	private static Context context;
	private  SQLiteDatabase db;
	private DBHelper dbHepler;
public MyDatabase(Context context) {
	MyDatabase.context=context;
	}

public MyDatabase open() throws SQLException{
	dbHepler=new DBHelper(context);
	db=dbHepler.getWritableDatabase();
	return this;
}
public void close(){
	dbHepler.close();
}
//	Class DB Helper
public class DBHelper extends SQLiteOpenHelper{

	public DBHelper(Context context) {
		super(context, DATABASE_NAM, null, 1);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		try{
		db.execSQL("CREATE  TABLE CONTACTS (icon INTEGER ,name VARCHAR(100), description VARCHAR(20));");
	}catch(Exception e){
		
	}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
//		db.execSQL("DROP TABLE IF EXISTS MANAGER ;");
//		db.execSQL("DROP TABLE IF EXISTS CATAGORY ;");
//		db.execSQL("DROP TABLE IF EXISTS ACCOUNT ;");
//		onCreate(db);
	}
}
	public long Insert_Contacts(int icon,String name,String des ){
		ContentValues cv=new ContentValues();
		cv.put("icon", icon );
		cv.put("name", name);
		cv.put("description",des);
		long rs=0;
		try{
			rs=db.insert("CONTACTS", null, cv);
		}catch(Exception e){
		}
		return rs;
	}
public Cursor getAllContact(){
	Cursor cur=null;
	try {
		cur=db.rawQuery("SELECT * FROM CONTACTS ORDER BY name ASC ;", null);
	} catch (Exception e) {
	}
	return cur;
}

public boolean delete_Contact(String Name){
	try {
		db.execSQL("DELETE FROM CONTACTS WHERE name ='"+Name+"';");
	} catch (Exception e) {
		return false;
	}return true;
}
public boolean Update_Contact(String oldName,String newName,String newDes){
	try {
		db.execSQL("UPDATE CONTACTS SET name ='"+newName.trim()+"',description='"+newDes+"'WHERE name='"+oldName+"';");
	} catch (Exception e) {
		return false;
	}
	return true;
}



}
