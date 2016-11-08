package com.yukang.searchfiledemo;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private EditText etKeyWord;
	private Button btnSearch;
	private TextView tvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		etKeyWord = (EditText) findViewById(R.id.etKeyWord);
		btnSearch = (Button) findViewById(R.id.btnSearch);
		tvResult = (TextView) findViewById(R.id.tvResult);
		btnSearch.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		File[] files = new File(Environment.getExternalStorageDirectory().getPath()).listFiles();
		String result = "";
		String keyword = etKeyWord.getText().toString().trim();
		if (!keyword.equals("")) {
			for (File f : files) {
				if (f.getName().indexOf(keyword) >= 0)
					result += f.getPath() + "\n";
			}
			if (result.equals(""))
				tvResult.setText("找不到文件！");
			else
				tvResult.setText(result);
		}

	}
}
