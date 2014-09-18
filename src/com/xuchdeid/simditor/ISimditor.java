package com.xuchdeid.simditor;

import org.json.JSONObject;

import android.view.ViewGroup;

public interface ISimditor {
	public void showSimditorToolbar(ViewGroup mLayout, JSONObject config);
	public void hideSimditorToolbar();
	public void updateSimditorButton(JSONObject config);
	public void doSimditorCommand(String command);
}
