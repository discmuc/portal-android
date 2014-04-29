package org.code2bytes.portal.android;

import org.code2bytes.portal.android.menu.NavbarAdapter;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String[] leftMenuItems;
	private ActionBarDrawerToggle toggle;
	private DrawerLayout layout;
	private ListView leftMenu;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			MainFragment fragment = new MainFragment();
			getFragmentManager()
					.beginTransaction()
					.add(R.id.layout_frame_main, fragment,
							fragment.getClass().getSimpleName()).commit();
		}
		layout = (DrawerLayout) findViewById(R.id.layout_drawer);
		layout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
		leftMenuItems = getResources().getStringArray(R.array.nav_leftmenu);
		leftMenu = (ListView) findViewById(R.id.layout_leftmenu);
		leftMenu.setAdapter(new NavbarAdapter(this, R.layout.navbar_normal,
				leftMenuItems));
		leftMenu.setOnItemClickListener(new ListView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				menuSelect(position);
			}
		});

		toggle = new ActionBarDrawerToggle(this, layout, R.drawable.ic_drawer,
				R.string.app_name, R.string.app_name) {

			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				getActionBar().setTitle(R.string.menu_name);
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				getActionBar().setTitle(R.string.app_name);
			}
		};
		layout.setDrawerListener(toggle);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		toggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		toggle.onConfigurationChanged(newConfig);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (toggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void menuSelect(int position) {
		Toast.makeText(this, leftMenuItems[position], Toast.LENGTH_LONG).show();
		layout.closeDrawer(leftMenu);
	}
}
