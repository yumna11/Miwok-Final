package com.signaturecontrol.usman.asma_ul_husna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Usman on 3/13/2017.
 */
public class WordAdapter extends ArrayAdapter<Word> {



    public WordAdapter(Context context, int resource, List<Word> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_view, parent, false);
        }
        Word currentWord = getItem(position);
        TextView engTrans = (TextView) listItemView.findViewById(R.id.eng_trans);
        engTrans.setText(currentWord.getEnglishTranslation());
        TextView urduTrans = (TextView) listItemView.findViewById(R.id.urdu_trans);
        urduTrans.setText(currentWord.getUrduTranslation());
        TextView arabic = (TextView) listItemView.findViewById(R.id.arabic);
        ImageView playIcon = (ImageView) listItemView.findViewById(R.id.play);
        if (currentWord.getArabic() != null)
        {
            arabic.setVisibility(View.VISIBLE);
            arabic.setText(currentWord.getArabic());
            playIcon.setVisibility(View.VISIBLE);
            playIcon.setImageResource(R.drawable.ic_play_circle_filled_white_24dp);
        }
        else
        {
            arabic.setVisibility(View.GONE);
            playIcon.setVisibility(View.GONE);
        }
    return listItemView;

    }
}
