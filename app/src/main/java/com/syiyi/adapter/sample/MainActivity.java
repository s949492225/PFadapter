package com.syiyi.adapter.sample;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.syiyi.adapter.CommonAdapter;
import com.syiyi.adapter.R;
import com.syiyi.adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    @Bind(R.id.mylist)
    ListView mylistview;
    Myadapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        List<Person> personList=new ArrayList<Person>();
        for (int i=0;i<40;i++){
            Person p=new Person(i+"ds",i);
            personList.add(p);
        }
        myadapter=new Myadapter(personList,this);
        mylistview.setAdapter(myadapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Created by songlintao on 15/7/10.
     */
    public static class Myadapter extends CommonAdapter<Person> {





        public Myadapter(List<Person> data,Context context) {
            super(data,context);
        }



        @Override
        public void convert(ViewHolder holder, int position) {

            holder.setText(R.id.name,mData.get(position).getName());
            holder.setText(R.id.birt,mData.get(position).getBirth()+"");
            holder.setImage(R.id.image, R.drawable.palce);

        }

    }
}
