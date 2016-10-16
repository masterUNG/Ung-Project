package appewtc.masterung.ungtraffic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Explicit การประกาศตัวแปร
    private ListView listView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind  Widget
        listView = (ListView) findViewById(R.id.livTraffic);
        button = (Button) findViewById(R.id.button);

        //Button Controller
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Sound Effect
                MediaPlayer mediaPlayer = MediaPlayer.create(getBaseContext(),
                        R.raw.mosquito);
                mediaPlayer.start();

                //Show WebView
                String url = "https://youtu.be/AFmWqLIqDZA";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }   // onClick
        });


        //ListView Controller
        //Get Value from Class
        MyConstant myConstant = new MyConstant();
        int[] ints = myConstant.getInts();

        //Get Value Form xml
        String[] titleStrings = getResources().getStringArray(R.array.title);
        String[] detailStrings = getResources().getStringArray(R.array.detail);

        //Create ListView
        TrafficAdapter trafficAdapter = new TrafficAdapter(MainActivity.this,
                titleStrings, detailStrings, ints);
        listView.setAdapter(trafficAdapter);


    }   // Main Method

}   // Main Class นี่คือ คลาสหลัก

