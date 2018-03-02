package id.baperan.baper;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListViewQuote extends AppCompatActivity {
    String[] titles = {getString(R.string.ownerQuote1), getString(R.string.ownerQuote2), getString(R.string.ownerQuote3), getString(R.string.ownerQuote4), getString(R.string.ownerQuote5)};
    String[] describes  = new String[]{getString(R.string.quote1), getString(R.string.quote2), getString(R.string.quote3), getString(R.string.quote4), getString(R.string.quote5)};;
    int[] images = {R.drawable.key, R.drawable.padlock, R.drawable.ic_fav, R.drawable.ic_fav};
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_quote);

      try {

          lv = (ListView) findViewById(R.id.listPoto);
          ListAdapter adapter = new classes.ListAdapter(getApplicationContext(), titles, describes, images);
          lv.setAdapter(adapter);

          lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  String value = (String) lv.getItemAtPosition(position);
                  Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT).show();
              }
          });
      }
      catch (Exception e) {
          e.printStackTrace();
          Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
      }



    }

    private void loadDataQuote() {
        for (int i = 0; i <= 5; i++) {
            titles[i] = getString(R.string.ownerQuote1).toString();
            describes[i] = getString(R.string.quote1).toString();
        }
    }




    public void shareToWA() {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_TEXT, "Test");
        share.setPackage("com.whatapp");
        startActivity(share);
    }

}


