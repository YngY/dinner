package com.sky.dining.widget;



import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.sky.dining.R;


/**
 * 自定义Dialog
 * 
 * @author Home
 *
 */
public class MyDialog extends Dialog implements View.OnClickListener {
	private DialogClickListener listener;
	Context context;
	private TextView tv_restinfo_pop_tel_content;
	private TextView dialog_textViewID;
	private TextView dialog_textViewID1;
	private String leftBtnText;
	private String rightBtnText;
	private String content;

	public MyDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	/**
	 * 
	 * @param context
	 * @param theme
	 * @param content
	 *            内容
	 * @param leftBtnText
	 *            左
	 * @param rightBtnText
	 *            右
	 * @param listener
	 *            监听
	 */
	public MyDialog(Context context, int theme, String content, String leftBtnText, String rightBtnText,
			DialogClickListener listener) {
		super(context, theme);
		this.context = context;
		this.content = content;
		this.leftBtnText = leftBtnText;
		this.rightBtnText = rightBtnText;
		this.listener = listener;
	}

	public void setTextSize(int size) {
		dialog_textViewID.setTextSize(size);
		dialog_textViewID1.setTextSize(size);
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.toast_dialog);
		tv_restinfo_pop_tel_content = (TextView) findViewById(R.id.tv_restinfo_pop_tel_content);
		dialog_textViewID1 = (TextView) findViewById(R.id.dialog_textViewID1);
		dialog_textViewID = (TextView) findViewById(R.id.dialog_textViewID);
		dialog_textViewID.setOnClickListener(this);
		dialog_textViewID1.setOnClickListener(this);
		initView();
		initDialog(context);
	}

	/**
	 * 初始化
	 * 
	 * @param context
	 */
	private void initDialog(Context context) {
		setCanceledOnTouchOutside(false);
		setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
					return true;
				} else {
					return false;
				}
			}
		});
		WindowManager windowManager = this.getWindow().getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		WindowManager.LayoutParams lp = this.getWindow().getAttributes();
		lp.width = (int) (display.getWidth() / 6 * 5); // 属性设置
		this.getWindow().setAttributes(lp);
	}

	private void initView() {
		tv_restinfo_pop_tel_content.setText(content);

		dialog_textViewID.setText(leftBtnText);

		dialog_textViewID1.setText(rightBtnText);

	}

	public interface DialogClickListener {
		void onLeftBtnClick(Dialog dialog);

		void onRightBtnClick(Dialog dialog);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.dialog_textViewID:
			listener.onLeftBtnClick(this);
			break;
		case R.id.dialog_textViewID1:
			listener.onRightBtnClick(this);
			break;
		default:
			break;
		}
	}
}