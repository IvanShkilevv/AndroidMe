package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {
    private static final String LOG_TAG = "BodyPartFragment" ;
    private static final String IMAGE_LIST_IDS ="image_ids";
    private static final String IMAGE_LIST_INDEX ="image_index";

    private List<Integer> imageListIDs;
    private Integer imageListIndex;

    public BodyPartFragment (){

    }

    public void setImageListIDs(List<Integer> imageListIDs) {
        this.imageListIDs = imageListIDs;
    }
    public void setImageListIndex(Integer imageID) {
        this.imageListIndex = imageID;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        if (savedInstanceState != null) {
        imageListIDs = savedInstanceState.getIntegerArrayList(IMAGE_LIST_IDS);
        imageListIndex =  savedInstanceState.getInt(IMAGE_LIST_INDEX);
        }

        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView imageView = rootView.findViewById(R.id.body_part_image_view);

        if (imageListIDs != null) {
            imageView.setImageResource(imageListIDs.get(imageListIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (imageListIndex < imageListIDs.size()-1 ) {
                        imageListIndex++;
                    }
                    else {
                        imageListIndex = 0;
                    }
                    imageView.setImageResource(imageListIDs.get(imageListIndex));
                }
            });

        }
        else { Log.v(LOG_TAG, "image List is empty, unable to create fragment"); }

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle currentState) {
        super.onSaveInstanceState(currentState);
        currentState.putIntegerArrayList(IMAGE_LIST_IDS, (ArrayList<Integer>) imageListIDs);
        currentState.putInt(IMAGE_LIST_INDEX, imageListIndex);
    }

}
