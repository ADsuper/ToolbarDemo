package io.github.adsuper.toolbardemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.btn1)
    Button mBtn1;
    @BindView(R.id.btn2)
    Button mBtn2;
    @BindView(R.id.btn3)
    Button mBtn3;
    @BindView(R.id.btn4)
    Button mBtn4;
    @BindView(R.id.btn5)
    Button mBtn5;

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        ButterKnife.bind(this);
        mToolbar.setTitle("ToolbarDemo");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用

    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(mContext,Toolbar1_Activity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(mContext,Toolbar2_Activity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(mContext,Toolbar3_Activity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(mContext,Toolbar4_Activity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(mContext,Toolbar5_Activity.class));
                break;
        }
    }

//    @Override
//    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
//        if (menu.getClass().getSimpleName().equals("MenuBuilder")){
//            try {
//                Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible",Boolean.class);
//                method.setAccessible(true);
//                method.invoke(menu,true);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return super.onPrepareOptionsPanel(view, menu);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_main_right_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }
}
