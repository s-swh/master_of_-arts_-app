package com.wd.master_of_arts_app.fragment.releasefragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wd.master_of_arts_app.R;
import com.wd.master_of_arts_app.base.App;
import com.wd.master_of_arts_app.base.BaseFragment;
import com.wd.master_of_arts_app.base.BasePreantert;

/**
 * @author 时文豪
 * @description: 文字介绍
 * @date :2020/12/5 10:02
 */
public class Written_Words extends BaseFragment {

    public EditText et;
    public int num = 500;
    public TextView ettv;

    @Override
    protected int getLayoutId() {
        return R.layout.written_words;
    }

    @Override
    protected BasePreantert initPreantert() {
        return null;
    }

    @Override
    protected void initView(View inflate) {
        et = inflate.findViewById(R.id.et_ettv);
        ettv = inflate.findViewById(R.id.tt_tv);
        String string = ettv.getText().toString();

    }

    @Override
    protected void initData() {


        this.et.addTextChangedListener(new TextWatcher() {
        private CharSequence wordNum;//记录输入的字数
        private int selectionStart;
        private int selectionEnd;
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            wordNum= charSequence;//实时记录输入的字数
            String string = et.getText().toString();

            SharedPreferences et = App.getContext().getSharedPreferences("et", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = et.edit();
            edit.putString("striasdasdasng",string);
            edit.commit();
        }

        @Override
        public void afterTextChanged(Editable editable) {
            int number = num - editable.length();
            //TextView显示剩余字数
            ettv.setText("" + number);
            selectionStart= Written_Words.this.et.getSelectionStart();
            selectionEnd = Written_Words.this.et.getSelectionEnd();
            if (wordNum.length() > num) {
                //删除多余输入的字（不会显示出来）
                editable.delete(selectionStart - 1, selectionEnd);
                int tempSelection = selectionEnd;
                ettv.setText(editable);
                Written_Words.this.et.setSelection(tempSelection);//设置光标在最后
            }

        }
    });
    }
}
