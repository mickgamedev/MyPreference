package ru.yandex.dunaev.mick.mypreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editText) EditText mEditText;
    @BindView(R.id.checkBoxUp) CheckBox mCheckBoxUp;
    @BindView(R.id.checkBoxMid) CheckBox mCheckBoxMid;
    @BindView(R.id.checkBoxDown) CheckBox mCheckBoxDown;
    @BindView(R.id.radioButtonUp) RadioButton mRadioButtonUp;
    @BindView(R.id.radioButtonMid) RadioButton mRadioButtonMid;
    @BindView(R.id.radioButtonDown) RadioButton mRadioButtonDown;
    @BindView(R.id.switchUp) Switch mSwitchUp;
    @BindView(R.id.switchMid) Switch mSwitchMid;
    @BindView(R.id.switchDown) Switch mSwitchDown;

    private String EDIT_TEXT_ID = "EditText";
    private String CHECK_BOX_UP_ID = "CheckBoxUp";
    private String CHECK_BOX_MID_ID = "CheckBoxMid";
    private String CHECK_BOX_DOWN_ID = "CheckBoxDown";
    private String RADIO_BUTTON_UP_ID = "RadioButtonUp";
    private String RADIO_BUTTON_MID_ID = "RadioButtonMid";
    private String RADIO_BUTTON_DOWN_ID = "RadioButtonDown";
    private String SWITCH_UP_ID = "SwitchUp";
    private String SWITCH_MID_ID = "SwitchMid";
    private String SWITCH_DOWN_ID = "SwitchDown";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonSave)
    public void OnClickSave(View v){
        String editText = mEditText.getText().toString();
        boolean CheckBoxUpState = mCheckBoxUp.isChecked();
        boolean CheckBoxMidState = mCheckBoxMid.isChecked();
        boolean CheckBoxDownState = mCheckBoxDown.isChecked();
        boolean RadioButtonUpState = mRadioButtonUp.isChecked();
        boolean RadioButtonMidState = mRadioButtonMid.isChecked();
        boolean RadioButtonDownState = mRadioButtonDown.isChecked();
        boolean SwitchUpState = mSwitchUp.isChecked();
        boolean SwitchMidState = mSwitchMid.isChecked();
        boolean SwitchDownState = mSwitchDown.isChecked();

        SharedPreferences settings = getSharedPreferences("settings.txt", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        editor.putString(EDIT_TEXT_ID, editText);
        editor.putBoolean(CHECK_BOX_UP_ID, CheckBoxUpState);
        editor.putBoolean(CHECK_BOX_MID_ID, CheckBoxMidState);
        editor.putBoolean(CHECK_BOX_DOWN_ID, CheckBoxDownState);
        editor.putBoolean(RADIO_BUTTON_UP_ID, RadioButtonUpState);
        editor.putBoolean(RADIO_BUTTON_MID_ID, RadioButtonMidState);
        editor.putBoolean(RADIO_BUTTON_DOWN_ID, RadioButtonDownState);
        editor.putBoolean(SWITCH_UP_ID, SwitchUpState);
        editor.putBoolean(SWITCH_MID_ID, SwitchMidState);
        editor.putBoolean(SWITCH_DOWN_ID, SwitchDownState);

        editor.apply();
    }

    @OnClick(R.id.buttonLoad)
    public void OnClickLoad(View v){
        SharedPreferences settings = getSharedPreferences("settings.txt", Context.MODE_PRIVATE);

        String editText = settings.getString(EDIT_TEXT_ID,"");
        boolean CheckBoxUpState = settings.getBoolean(CHECK_BOX_UP_ID, false);
        boolean CheckBoxMidState = settings.getBoolean(CHECK_BOX_MID_ID, false);
        boolean CheckBoxDownState = settings.getBoolean(CHECK_BOX_DOWN_ID, false);
        boolean RadioButtonUpState = settings.getBoolean(RADIO_BUTTON_UP_ID, false);
        boolean RadioButtonMidState = settings.getBoolean(RADIO_BUTTON_MID_ID, false);
        boolean RadioButtonDownState = settings.getBoolean(RADIO_BUTTON_DOWN_ID, false);
        boolean SwitchUpState = settings.getBoolean(SWITCH_UP_ID, false);
        boolean SwitchMidState = settings.getBoolean(SWITCH_MID_ID, false);
        boolean SwitchDownState = settings.getBoolean(SWITCH_DOWN_ID, false);


        mEditText.setText(editText);
        mCheckBoxUp.setChecked(CheckBoxUpState);
        mCheckBoxMid.setChecked(CheckBoxMidState);
        mCheckBoxDown.setChecked(CheckBoxDownState);
        mRadioButtonUp.setChecked(RadioButtonUpState);
        mRadioButtonMid.setChecked(RadioButtonMidState);
        mRadioButtonDown.setChecked(RadioButtonDownState);
        mSwitchUp.setChecked(SwitchUpState);
        mSwitchMid.setChecked(SwitchMidState);
        mSwitchDown.setChecked(SwitchDownState);
    }
}
