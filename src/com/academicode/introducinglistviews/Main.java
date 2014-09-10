package com.academicode.introducinglistviews;

import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * This is the only Activity that comprises our application. 
 * 
 * @author AcademiCode
 */
public class Main extends Activity{

	// This is the ListView that we use to organize and display the data.
	private ListView listView;
	
	// This is the array that holds the raw data we'll display in the ListView.
	private String names[];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// Mandatory super method call.
		super.onCreate(savedInstanceState);
		
		// Set the content view to the Main.xml layout.
		setContentView(R.layout.main);
		
		// Assign the data housed in the names array of the Android resources to the names class variable.
		names = getResources().getStringArray(R.array.names);
		
		// Associate the java class with the XML representation of the View. 
		listView = (ListView) findViewById(R.id.list_view);
		
		// Assign the adapter to the listView that will control the conversion of the raw data to Android TextViews.
		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Arrays.asList(names)));
		
		// Assign a click listener that will react to touch events on the ListView.
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int itemNumber, long arg3) {
				
				// When an item in the list is clicked, send out a Toast with the name contained in that slot in the ListView.
				Toast.makeText(Main.this, "Item: " + names[itemNumber], Toast.LENGTH_SHORT).show();
			}
		});
	}
}
