package io.github.adsuper.toolbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import static io.github.adsuper.toolbardemo.R.id.toolbar;

/**
 * 常用的网页形式的 toolbar
 */
public class Toolbar3_Activity extends AppCompatActivity {
    @BindView(R.id.text_toolbar)
    TextView mTextToolbar;
    @BindView(R.id.actionMenuView)
    ActionMenuView mActionMenuView;
    @BindView(toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar2_);
        ButterKnife.bind(this);

        //填充 menu 布局
        getMenuInflater().inflate(R.menu.toolbar_left_menu, mActionMenuView.getMenu());

        MenuItem menuItem = mActionMenuView.getMenu().findItem(R.id.left_text_btn);
        //设置 对应 item 填充布局的点击事件
        menuItem.getActionView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
