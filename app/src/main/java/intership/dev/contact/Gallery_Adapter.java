package intership.dev.contact;

import java.util.concurrent.ArrayBlockingQueue;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Gallery_Adapter extends BaseAdapter{
	private Context context;
	private int imageIds[]=null;
	
	public Gallery_Adapter(Context context,int imageIds[]) {
		this.context=context;
		this.imageIds=imageIds;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imageIds.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView iv=new ImageView(context);
		iv.setImageResource(imageIds[position]);
//		set scale cho hinh khoi bi keo dai ra;
		iv.setScaleType(ImageView.ScaleType.FIT_XY);
		
		return iv;
	}

	

}
