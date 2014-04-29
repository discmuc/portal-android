package org.code2bytes.portal.android.menu;

import org.code2bytes.portal.android.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NavbarAdapter extends ArrayAdapter<String> {

	private Context context;

	private String[] items;

	public NavbarAdapter(Context context, int resource, String[] items) {
		super(context, resource, items);
		this.context = context;
		this.items = items;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = ((Activity) context).getLayoutInflater();

		View row = inflater.inflate(R.layout.navbar_normal, parent, false);
		TextView label = (TextView) row.findViewById(R.id.label_navbar_normal);
		String labelText = items[position];
		label.setText(labelText);

		if (position == 0) {
			label.setTextSize(18);
			label.setTypeface(Typeface.DEFAULT_BOLD);
		}

		if (position == 1) {
			label.setTextSize(18);
			label.setTypeface(Typeface.DEFAULT_BOLD);
		}

		if (position == 7) {
			label.setTextSize(12);
			label.setCompoundDrawablesWithIntrinsicBounds(
					R.drawable.ic_action_settings, 0, 0, 0);
			label.setBackgroundResource(R.drawable.textlines_first);
		}
		if (position == 8) {
			label.setTextSize(12);
			label.setCompoundDrawablesWithIntrinsicBounds(
					R.drawable.ic_action_web_site, 0, 0, 0);
			label.setBackgroundResource(R.drawable.textlines);
		}
		if (position == 9) {
			label.setTextSize(12);
			label.setCompoundDrawablesWithIntrinsicBounds(
					R.drawable.ic_action_about, 0, 0, 0);
			label.setBackgroundResource(R.drawable.textlines);
		}

		return row;
	}
}
