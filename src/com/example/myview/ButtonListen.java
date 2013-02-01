package com.example.myview;

//import com.example.imageview.R;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ButtonListen extends Activity implements OnClickListener {

	@Override
	public void onClick(View v) {
		
			
		// TODO Auto-generated method stub
			switch(v.getId()){
		case R.id.button0:
		Jump2TextView();break;
		case R.id.button1:
			Jump2ImageView();break;
		case R.id.button2:
			Jump2ListView();break;
		case R.id.button3:
			Jump2GridView();break;
		case R.id.button4:
			Jump2MainActivityView();break;
		}
		
		}	

	private void Jump2TextView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.first);
		Button button1=(Button)findViewById(R.id.button1);
		button1.setOnClickListener(new ButtonListen());
	}

	private void Jump2ImageView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.second);
		Button button2=(Button)findViewById(R.id.button2);
		button2.setOnClickListener(new ButtonListen());
	}

	private void Jump2GridView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.fourth);
		Button button4=(Button)findViewById(R.id.button4);
		button4.setOnClickListener(new ButtonListen());
	}

	private void Jump2ListView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.third);
		Button button3=(Button)findViewById(R.id.button3);
		button3.setOnClickListener(new ButtonListen());
	}

	private void Jump2MainActivityView() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
		Button button0=(Button)findViewById(R.id.button0);
		button0.setOnClickListener(new ButtonListen());
	}
}
