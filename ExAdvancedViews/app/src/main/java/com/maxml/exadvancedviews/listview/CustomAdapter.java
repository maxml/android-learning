package com.maxml.exadvancedviews.listview;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxml.exadvancedviews.R;
import com.maxml.exadvancedviews.entity.ModelObject;

public class CustomAdapter extends ArrayAdapter<ModelObject> {

	private Context context;

	public CustomAdapter(Context context, int resourceId,
			List<ModelObject> items) {
		super(context, resourceId, items);
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		ModelObject model = getItem(position);

		if (convertView == null) {

			LayoutInflater mInflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

			convertView = mInflater.inflate(R.layout.ex_list_item, null);

			holder = new ViewHolder();
			holder.txtDesc = (TextView) convertView.findViewById(R.id.desc);
			holder.txtTitle = (TextView) convertView.findViewById(R.id.title);
			holder.imageView = (ImageView) convertView.findViewById(R.id.icon);

			convertView.setTag(holder);

		} else
			holder = (ViewHolder) convertView.getTag();

		holder.txtDesc.setText(model.getDesc());
		holder.txtTitle.setText(model.getTitle());
		holder.imageView.setImageResource(model.getImageId());

		return convertView;
	}

	/* private view holder class */
	private class ViewHolder {
		ImageView imageView;
		TextView txtTitle;
		TextView txtDesc;
	}

}
