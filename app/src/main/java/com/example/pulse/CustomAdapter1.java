package com.example.pulse;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;


public class CustomAdapter1 extends ArrayAdapter<PostBlood> {

    private ArrayList<PostBlood> dataSetName;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtLoc;

        TextView txtLimit;


    }



    public CustomAdapter1(ArrayList<PostBlood> dataSetName, Context context) {
        super(context, R.layout.list_layout1, dataSetName);
        this.dataSetName = dataSetName;
        this.mContext=context;

    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        PostBlood dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_layout1, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.blood);
            viewHolder.txtLoc = (TextView) convertView.findViewById(R.id.hospi);

            viewHolder.txtLimit = (TextView) convertView.findViewById(R.id.urgency1);



            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.blood);
            viewHolder.txtLoc = (TextView) convertView.findViewById(R.id.hospi);

            viewHolder.txtLimit = (TextView) convertView.findViewById(R.id.urgency1);

            result=convertView;
        }

        lastPosition = position;


        //Log.d("CA",dataModel.getName());
        viewHolder.txtName.setText(dataModel.getBlood1());
        viewHolder.txtLoc.setText(dataModel.getHos1());

        viewHolder.txtLimit.setText("URGENCY: "+dataModel.getUrgency1());



        return convertView;
    }


}
