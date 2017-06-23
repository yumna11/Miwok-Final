package com.signaturecontrol.usman.asma_ul_husna;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProphetsFragment extends Fragment {


    public ProphetsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Hazrat Adam A.S.","حضرت آدم علیہ السلام"));
        words.add(new Word("Hazrat Idris A.S.","حضرت ادریس علیہ السلام"));
        words.add(new Word("Hazrat Nuh A.S.","حضرت نوح علیہ السلام"));
        words.add(new Word("Hazrat Hud A.S.","حضرت ھود علیہ السلام"));
        words.add(new Word("Hazrat Soleh A.S.","حضرت صالح علیہ السلام"));
        words.add(new Word("Hazrat Ibrahim A.S.","حضرت ابراہیم علیہ السلام"));
        words.add(new Word("Hazrat Luth A.S.","حضرت لوط علیہ السلام"));
        words.add(new Word("Hazrat Isma'il A.S. ","حضرت اسماعیل علیہ السلام"));
        words.add(new Word("Hazrat Ishaq A.S.","إحضرت اسحاق علیہ السلام"));
        words.add(new Word("Hazrat Ya'qub A.S.","حضرت یعقوب علیہ السلام "));
        words.add(new Word("Hazrat Yusuf A.S.","حضرت يوسف علیہ السلام"));
        words.add(new Word("Hazrat Ayyub A.S.","حضرت أيوب علیہ السلام"));
        words.add(new Word("Hazrat Syuaib A.S.","حضرت شعيب علیہ السلام"));
        words.add(new Word("Hazrat Musa A.S.","حضرت موسى علیہ السلام"));
        words.add(new Word("Hazrat Harun A.S.","حضرت هارون علیہ السلام"));
        words.add(new Word("Hazrat Zulkifli A.S.","حضرت ذو الكفل علیہ السلام"));
        words.add(new Word("Hazrat Daud A.S.","حضرت داؤد علیہ السلام"));
        words.add(new Word("Hazrat Sulaiman A.S.","حضرت سليمان علیہ السلام"));
        words.add(new Word("Hazrat IIyas A.S.","حضرت إلياس علیہ السلام"));
        words.add(new Word("Hazrat IIyasa' A.S.","حضرت اليسع علیہ السلام"));
        words.add(new Word("Hazrat Yunus A.S.","حضرت يونس علیہ السلام"));
        words.add(new Word("Hazrat Zakaria A.S.","حضرت زكريا علیہ السلام"));
        words.add(new Word("Hazrat Yahya A.S."," حضرت يحيى علیہ السلام"));
        words.add(new Word("Hazrat Isa A.S.","حضرت عيسی علیہ السلام"));
        words.add(new Word("Hazrat Muhammad S.A.W.","حضرت محمد صلی الله علیہ وسلم"));
        WordAdapter list = new WordAdapter(getActivity(),R.layout.list_item_view,words);
        listView.setAdapter(list);
        return rootView;


    }

}
