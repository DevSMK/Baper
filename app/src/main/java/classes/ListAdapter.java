package classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import id.baperan.baper.R;

/**
 * Created by Gentong on 25/12/2017.
 */

public class ListAdapter extends ArrayAdapter {
        int[] imgArr;
        String[] titleArr;
        String[] desArr;

        public ListAdapter(Context context, String[] title1, String[] deskrib1, int[] img1) {
            super(context, R.layout.custom_list_view_row, R.id.potoId, title1);
            this.imgArr = img1;
            this.titleArr = title1;
            this.desArr = deskrib1;
        }

        public View getView(int pos, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = inflater.inflate(R.layout.quote_custom_row, parent, false);
            ImageView img = (ImageView) row.findViewById(R.id.pictQuote);
            TextView judul = (TextView) row.findViewById(R.id.txtNameQoute);
            TextView deskrib = (TextView) row.findViewById(R.id.txtQuoteBody);

            img.setImageResource(imgArr[pos]);
            judul.setText(titleArr[pos]);
            deskrib.setText(desArr[pos]);
            return row;
    }
}
