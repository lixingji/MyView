package com.example.myview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.text.Html;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity implements OnSeekBarChangeListener,OnItemSelectedListener,
OnItemClickListener {

	private AutoCompleteTextView auto;
	private int minWidth=80;
	private ImageView img;
	private TextView tv1,tv2;
	private Matrix matrix=new Matrix();  //3*3矩阵
	private ListView listview;
	private ArrayAdapter<String> adapter;
	private List<String> data; 
	private ImageView imv;
	private int[] resIds=new int[]{
			R.drawable.img1,R.drawable.img2,R.drawable.img3,
			R.drawable.img4,R.drawable.img5,R.drawable.img6,
			R.drawable.img7,R.drawable.img8,R.drawable.img9,
			R.drawable.img10,R.drawable.img11,R.drawable.img12,
			R.drawable.img13,R.drawable.img14,R.drawable.img15,
			R.drawable.img16,R.drawable.img17,R.drawable.img18,
			R.drawable.img19,R.drawable.img20
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button button0=(Button)this.findViewById(R.id.button0);
		MyTextView();//显示下一个页面 
		
	}
	
	public void MyTextView(){
		
		setContentView(R.layout.first);
		TextView tv=(TextView)findViewById(R.id.text);
		tv.setText(Html.fromHtml("<font color=red>大家新年好！" +
				"</font>祝小孩子学习进步，祝大人老人<font color=blue>"+
				"身体健康，天天快乐！</font>"));
	    auto=(AutoCompleteTextView)this.findViewById(R.id.atv);
	    String[] autoStrs=new String[]{
	    		"Google","Google map",
	    		"百度","百度百科","维基百科",
	    		"北京","北京烤鸭","北京天安门"
	    };
	    //从字符组获取匹配字符到适配器，实现下拉
	    ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this,
	    	 android.R.layout.simple_dropdown_item_1line,autoStrs);
	    auto.setAdapter(adapter);
		
	    Button button1=(Button)this.findViewById(R.id.button1);
	    button1.setOnClickListener(new View.OnClickListener() {
	    	public void onClick(View v) { 
	    		MyImageView();//显示下一个页面 
	    	}
	    });
		
	}
	
    public void MyImageView(){
    	
    	setContentView(R.layout.second);
		img=(ImageView)this.findViewById(R.id.img);
		tv1=(TextView)this.findViewById(R.id.tv1);
		tv2=(TextView)this.findViewById(R.id.tv2);
		SeekBar sb1=(SeekBar)this.findViewById(R.id.sb1);
		SeekBar sb2=(SeekBar)this.findViewById(R.id.sb2);
		sb1.setOnSeekBarChangeListener(this);
		sb2.setOnSeekBarChangeListener(this);
		
		DisplayMetrics dm=new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		sb1.setMax(dm.widthPixels-minWidth);
		
		Button button2=(Button)this.findViewById(R.id.button2);
	    button2.setOnClickListener(new View.OnClickListener() {
	    	public void onClick(View v) { 
	    		MyListView();//显示下一个页面 
	    	}
	    });
	}
    
    public void MyListView(){
    	setContentView(R.layout.third);
		data=MyDataSource.getDataSource();
		adapter=new ArrayAdapter<String>(MainActivity.this,
				      android.R.layout.simple_list_item_single_choice,data);
		listview=(ListView)this.findViewById(R.id.listview);
		listview.setChoiceMode(ListView.CHOICE_MODE_SINGLE);//单选模式
		
		listview.setAdapter(adapter);
		listview.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "Click me", 1).show();
				return false;
			}
		});
		
		Button button3=(Button)this.findViewById(R.id.button3);
	    button3.setOnClickListener(new View.OnClickListener() {
	    	public void onClick(View v) { 
	    		MyGridView();//显示下一个页面 
	    	}
	    });
	}
    
    public void MyGridView(){
		
        setContentView(R.layout.fourth);
		
		GridView grv=(GridView)this.findViewById(R.id.grv);
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		
		for(int i=0;i<resIds.length;i++){
			Map<String,Object> img=new HashMap<String,Object>();
			img.put("imageview", resIds[i]);
			list.add(img);
		}
		SimpleAdapter simpleAdapter=new SimpleAdapter(this, 
				list, R.layout.img,
				new String[]{"imageview"}, new int[]{R.id.imv });
		
		//ListAdapter simpleAdapter = null;
		grv.setAdapter(simpleAdapter);
		imv=(ImageView)findViewById(R.id.imv);
		grv.setOnItemClickListener(this);
		grv.setOnItemSelectedListener(this);
		imv.setImageResource(resIds[0]);
		
		Button button4=(Button)this.findViewById(R.id.button4);
	    button4.setOnClickListener(new View.OnClickListener() {
	    	public void onClick(View v) { 
	    		MainView();//显示下一个页面 
	    	}
	    });
	}
    
    public void MainView(){
    	setContentView(R.layout.activity_main);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, 
			int position, long id) {
		// TODO Auto-generated method stub
		imv.setImageResource(resIds[position]);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view,
			int position, long id) {
		// TODO Auto-generated method stub
		imv.setImageResource(resIds[position]);
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		// TODO Auto-generated method stub
		if(seekBar.getId()==R.id.sb1){
			int newWidth=progress+minWidth;
			int newHeight=(int)(newWidth*3/4);
			img.setLayoutParams(new LinearLayout.LayoutParams(newWidth,newHeight));
			tv1.setText("图像宽度："+newWidth+" 图像高度："+newHeight);
		}
			else if(seekBar.getId()==R.id.sb2){
				Bitmap bitmap=((BitmapDrawable) (getResources().getDrawable(R.drawable.phone))).getBitmap();
					
		matrix.setRotate(progress);
		bitmap=Bitmap.createBitmap(bitmap, 0, 0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
		img.setImageBitmap(bitmap);
		tv2.setText(progress+"度");
			}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

}
