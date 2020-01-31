package com.example.listview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private List<Weather> data ;

    public Adapter(List<Weather> data){
        this.data = data;
    }

    @Override
    public int getCount() { //아이템의 개수 표시
        //return 0;
        return data.size();
    }

    @Override
    public Object getItem(int position) {

        //return null;
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        //return 0;
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { //???? getView????
         ViewHolder holder ;

         if(convertView == null) {
             holder = new ViewHolder();

             convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);

             ImageView image = convertView.findViewById(R.id.weather_image);
             TextView city = convertView.findViewById(R.id.city_text);
             TextView temp = convertView.findViewById(R.id.temp_text);

             holder.image = image;
             holder.city = city;
             holder.temp = temp;

             convertView.setTag(holder);

         }else{
             holder = (ViewHolder) convertView.getTag();
         }

        Weather weather = data.get(position);
        holder.city.setText(weather.getCity());
        holder.temp.setText(weather.getTemp());

        return convertView;
        //return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
    }

    static class ViewHolder {
        ImageView image ;
        TextView city;
        TextView temp;
    }
}
