package com.xuchdeid.simditor;

import org.json.JSONObject;

import com.xuchdeid.simditor.FixedRelativeLayout.OnIMEStateListener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class EditActivity extends Activity implements OnIMEStateListener {
	private static final String TAG = "EditActivity";
	private EditText mEditText;
	private ISimditor mSimditor;
	private JSONObject config;
	private FixedRelativeLayout mRoot;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		mRoot = (FixedRelativeLayout) findViewById(R.id.root);
		mRoot.setOnIMEStateListener(this);
		mEditText = (EditText) findViewById(R.id.edit);

		// init simditor toolbar config
		// use R.raw.config
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClose() {
		Log.d(TAG, "onClose");
		if (mSimditor != null) {
			mSimditor.hideSimditorToolbar();
		}
	}

	@Override
	public void onOpen() {
		Log.d(TAG, "onOpen");
		if (mSimditor != null) {
			mSimditor.showSimditorToolbar(mRoot, config);
		}
	}
}
