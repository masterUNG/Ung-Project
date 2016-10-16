package appewtc.masterung.ungtraffic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by masterUNG on 10/16/2016 AD.
 */

public class TrafficAdapter extends BaseAdapter{

    //Explicit
    private Context context;    // ท่อที่ใช้ส่งข้อมูล
    private String[] titleStrings, detailStrings;
    private int[] ints;
    private TextView titleTextView, detailTextView;
    private ImageView imageView;

    public TrafficAdapter(Context context, String[] titleStrings, String[] detailStrings, int[] ints) {
        this.context = context;
        this.titleStrings = titleStrings;
        this.detailStrings = detailStrings;
        this.ints = ints;
    }

    @Override
    public int getCount() {
        return titleStrings.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.traffic_listview, viewGroup, false);

        //Bind Widget
        titleTextView = (TextView) view1.findViewById(R.id.textView2);
        detailTextView = (TextView) view1.findViewById(R.id.textView3);
        imageView = (ImageView) view1.findViewById(R.id.imageView);

        //Show View
        titleTextView.setText(titleStrings[i]);

        //การตัดคำ โดยจะแสดงแค่ 30 ตัวอักษรเท่านั้น แต่ถ้า Detalil น้อยกว่า
        //30 ตัวอักษร ให้ แสดงทั้งหมด

        if (detailStrings[i].length() <= 30) {
            //รายละเอียด น้อยกว่า 30 ตัวอักษร
            detailTextView.setText(detailStrings[i]);
        } else {
            // มากกว่า 30 ตัวอักษร
            detailTextView.setText(detailStrings[i].substring(0, 30) + "...");
        }

        //Change Image
        imageView.setImageResource(ints[i]);


        return view1;
    }
}   // Main Class
