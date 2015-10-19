package com.just4you.myfirst;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//
public class MainActivity extends Activity {
    String[] country = {"Россия", "Белоруссия", "Германия", "Польша", "Бельгия", "Нидерланды",
            "Куба", "США", "Турция", "Египет", "Сирия", "Китай", "Южная Корея", "Украина",
            "Таиланд", "Латвия", "Кипр"};
    Integer[] FlagArray = {R.drawable.russia, R.drawable.belarus_, R.drawable.germany,
            R.drawable.poland, R.drawable.belgium, R.drawable.netherlands, R.drawable.cuba,
            R.drawable.usa, R.drawable.turkey, R.drawable.egypt, R.drawable.syria,
            R.drawable.china, R.drawable.south_korea, R.drawable.ukraine, R.drawable.thailand,
            R.drawable.latvia, R.drawable.cyprus};

    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = new MyAdapter(this);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Номер в списке " + (position + 1), Toast.LENGTH_SHORT).show();
            }
        });

    }


    public class MyAdapter extends BaseAdapter {
        private LayoutInflater mLayoutInflater;

        public MyAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return country.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = mLayoutInflater.inflate(R.layout.item, null);
            ImageView image = (ImageView) convertView.findViewById(R.id.ivImg);
            image.setImageResource(FlagArray[position]);
            TextView countryTextView = (TextView) convertView.findViewById(R.id.tvText);
            countryTextView.setText(country[position]);
            return convertView;
        }
    }
}
