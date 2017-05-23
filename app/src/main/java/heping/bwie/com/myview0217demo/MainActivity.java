package heping.bwie.com.myview0217demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
private EditText editText;
    private LayoutInflater mInflater;
    private MyView myView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInflater = LayoutInflater.from(this);
        editText= (EditText) findViewById(R.id.et_input);
        findViewById(R.id.btn_search).setOnClickListener(this);
        myView= (MyView) findViewById(R.id.myview);

    }

    @Override
    public void onClick(View v) {
        String keywords = editText.getText().toString();
        if (!TextUtils.isEmpty(keywords)) {
            TextView textView= (TextView) mInflater.inflate(R.layout.search_label_tv,myView,false);
            textView.setText(keywords);
            myView.addView(textView);
        } else {
            Toast.makeText(MainActivity.this, "请输入搜索内容", Toast.LENGTH_LONG).show();
        }



    }
}
