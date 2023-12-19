package com.kosenhacku2023.santatalk;

//import static com.example.santatalk.Text_Text.generateButton;
import static com.kosenhacku2023.santatalk.Text_Text.updateSecondSpinner;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

public class OnItemSelectListener extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    public static Context conText_main;
    public static View tmpView;
    public static com.kosenhacku2023.santatalk.View _view;

//    public static Mode mode;
    public String Identifier;

    OnItemSelectListener(Context ct, View view, com.kosenhacku2023.santatalk.View _view, String Spinner) {
        setConText(ct);
        Identifier = Spinner;
        this.tmpView = view;
        this._view = _view;
//        this.mode = mode;
    }


    public static void setConText(Context ct) {
        conText_main = ct;
        Log.d("onItemSelectListener", "set_Contest");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//        if(mode.getTranslateMode() == Mode.TRANSLATE_MODE.SJtoSS) {
            //Spinnerで選択された要素に応じてボタンを再生成
            String selectedCategory = Text_Text.Category_spinner.getItemAtPosition(position).toString();
            int pos = Text_Text.Detail_spinner.getCount() - 1;
            Log.d("OnItemSelectListener", "Count " + pos);
            if (pos < position) {
                position = pos;
            }

            String selectedDetail = Text_Text.Detail_spinner.getItemAtPosition(position).toString();

            if (Identifier == "Category") {
                updateSecondSpinner(conText_main, Text_Text.Detail_spinner, selectedCategory);
            } else if (Identifier == "Detail") {
                _view.generateButton(conText_main, tmpView, _view, Text_Text.buttonContainer, selectedDetail);
            }

        }

//    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
