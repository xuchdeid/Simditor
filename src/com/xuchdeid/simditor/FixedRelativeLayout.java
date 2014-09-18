package com.xuchdeid.simditor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.RelativeLayout;

public class FixedRelativeLayout extends RelativeLayout {

	private OnIMEStateListener mOnIMEStateListener;

	public interface OnIMEStateListener {
		public void onOpen();
		public void onClose();
	}

	public FixedRelativeLayout(Context context) {
		super(context);
	}

	public FixedRelativeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public FixedRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void setOnIMEStateListener(OnIMEStateListener mOnIMEStateListener) {
		this.mOnIMEStateListener = mOnIMEStateListener;
	}

	@Override  
	public boolean dispatchKeyEventPreIme(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK &&
				event.getAction() == KeyEvent.ACTION_UP) {
			if (mOnIMEStateListener != null) {
				mOnIMEStateListener.onClose();
			}
		}
		return super.dispatchKeyEventPreIme(event);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		if (mOnIMEStateListener != null && oldh != 0 && h < oldh) {
			mOnIMEStateListener.onOpen();
		}
	}
}
