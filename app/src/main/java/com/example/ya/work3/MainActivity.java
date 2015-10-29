package com.example.ya.work3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Button caculatorButton;
    private EditText weightEditText;
    private CheckBox manCheckBox;
    private  CheckBox womanCheckBox;
    private TextView resultTextView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        caculatorButton=(Button)findViewById(R.id.button);
        weightEditText=(EditText)findViewById(R.id.extractEditText);
        manCheckBox=(CheckBox)findViewById(R.id.checkBox);
        womanCheckBox=(CheckBox)findViewById(R.id.checkBox2);
        resultTextView=(TextView)findViewById(R.id.result);

    }

    @Override
    protected void onStart(){
        super.onStart();;
        registerEvent();


    }
    private  void  registerEvent() {
        caculatorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!weightEditText.getText().toString().trim().equals("")) {
                    if (manCheckBox.isChecked()||womanCheckBox.isChecked()){
                        Double weight = Double.parseDouble(weightEditText.getText().toString());
                        StringBuffer sb = new StringBuffer();
                        sb.append("-------�������----- \n");
                        if (manCheckBox.isChecked()) {
                            sb.append("���Ա�׼���");
                            double result = evaluateHeight(weight, "��");
                            sb.append((int) result + "�����ף�");
                        }
                        if (womanCheckBox.isChecked()) {
                            sb.append("Ů�Ա�׼���");
                            double result = evaluateHeight(weight, "Ů");
                            sb.append((int) result + "�����ף�");
                        }
                        resultTextView.setText(sb.toString());
                    } else {
                        showMessage("��ѡ���Ա�!");
                    }

                }else{
                    showMessage("��ѡ������!");

                }
            }

        });
    }

    private void showMessage(String message) {
        AlertDialog alert=new AlertDialog.Builder(this).create();
        alert.setTitle("ϵͳ��Ϣ");
        alert.setMessage(message);
        alert.setButton("ȷ��", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }

    private double evaluateHeight(Double weight, String sex) {
        double height;
        if (sex == "��") {
            height=170-(62-weight)/0.6;

        }else{
            height=158-(52-weight)/0.5;
        }


        return  height;
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        menu.add(Menu.NONE, 1, Menu.NONE, "�˳�");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case 1:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
