package com.sky.dining.util;



import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import android.widget.TextView;

import com.sky.dining.R;


public class Tools {
	
	public static Boolean isShowing=false;
	
	

	private static ProgressDialog progressDialog;

	/**
	 * ͳһdialog
	 * 
	 * @param activity
	 */
	public static void showProgressDialog(Activity activity, String msg) {
		if (progressDialog == null) {
			progressDialog = new ProgressDialog(activity);
			progressDialog.show();

			View view=View.inflate(activity, R.layout.dialog_porgress,null);
			//progressDialog.setMessage(msg);
			TextView tv= (TextView) view.findViewById(R.id.tv_dialog);
			tv.setText(msg);
			progressDialog.getWindow().setContentView(view);
			view.measure(0,0);

			progressDialog.getWindow().setLayout(activity.getResources().getDisplayMetrics().widthPixels/2,view.getMeasuredHeight());

			progressDialog.setCanceledOnTouchOutside(false);
			isShowing=true;

		}
	}

	public static void closeProgressDialog() {
		if (progressDialog != null) {
			progressDialog.cancel();
			isShowing=false;
			progressDialog = null;
			System.gc();
			
		}
	}

}
