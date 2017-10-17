package io.github.adsuper.toolbardemo;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import static io.github.adsuper.toolbardemo.R.id.toolbar;

/**
 * 使用 actionProvider 完全自定义右侧 menu
 */
public class Toolbar5_Activity extends AppCompatActivity {

    @BindView(toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar5_);
        ButterKnife.bind(this);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationIcon(R.mipmap.back);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//左侧添加一个默认的返回图标
//        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_right_menu5,menu);
        MenuItem item = menu.findItem(R.id.item1);
        MyToolbarActionProvider actionProvider = (MyToolbarActionProvider) MenuItemCompat.getActionProvider(item);
        actionProvider.setText("充值记录");
        actionProvider.setOnRightMenuClickListener(new MyToolbarActionProvider.OnRightMenuClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Toolbar5_Activity.this, "点击", Toast.LENGTH_SHORT).show();

            }
        });
        return super.onCreateOptionsMenu(menu);
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
