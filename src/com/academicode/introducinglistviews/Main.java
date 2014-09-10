package com.academicode.introducinglistviews;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends Activity{

	private ListView listView;
	
	private String names[];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		names = getResources().getStringArray(R.array.names);
		
		listView = (ListView) findViewById(R.id.list_view);
		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Arrays.asList(names)));
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int itemNumber, long arg3) {
				
				Toast.makeText(Main.this, "Item: " + names[itemNumber], Toast.LENGTH_SHORT).show();
			}
		});
	}
}
