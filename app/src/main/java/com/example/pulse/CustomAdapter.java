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


public class CustomAdapter extends ArrayAdapter<Accidentpost> {

    private ArrayList<Accidentpost> dataSetName;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtLoc;

        TextView txtLimit;


    }



    public CustomAdapter(ArrayList<Accidentpost> dataSetName, Context context) {
        super(context, R.layout.list_layout, dataSetName);
        this.dataSetName = dataSetName;
        this.mContext=context;

    }


    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Accidentpost dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {


            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_layout, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.type);
            viewHolder.txtLoc = (TextView) convertView.findViewById(R.id.loca);

            viewHolder.txtLimit = (TextView) convertView.findViewById(R.id.emer);



            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.type);
            viewHolder.txtLoc = (TextView) convertView.findViewById(R.id.loca);

            viewHolder.txtLimit = (TextView) convertView.findViewById(R.id.emer);

            result=convertView;
        }

        lastPosition = position;


        //Log.d("CA",dataModel.getName());
        viewHolder.txtName.setText(dataModel.getType());
        viewHolder.txtLoc.setText(dataModel.getLocation());

        viewHolder.txtLimit.setText("URGENCY: "+dataModel.getUrgency());



        return convertView;
    }


}
