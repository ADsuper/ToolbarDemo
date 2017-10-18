package io.github.adsuper.toolbardemo;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.adsuper.toolbardemo.utils.StatusBarUtil;

public class CollapsingToolbarLayout_1_Activity extends AppCompatActivity {

    @BindView(R.id.imageview)
    ImageView mImageview;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbarlayout)
    AppBarLayout mAppbarlayout;
    @BindView(R.id.toolbarTitle)
    TextView mToolbarTitle;
    @BindView(R.id.collapsing)
    CollapsingToolbarLayout mCollapsing;

    private static final String TAG = "CollapsingToolbarLayout";
    @BindView(R.id.text1)
    TextView mText1;
//    @BindView(R.id.view)
//    View mView;
    @BindView(R.id.text2)
    TextView mText2;
//    @BindView(R.id.linearlayout_toolbar_bottom)
//    LinearLayout mLinearlayoutToolbarBottom;
    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar_layout_1_);
        ButterKnife.bind(this);

        StatusBarUtil.transparencyBar(this);

        mToolbar.setTitle("");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Glide.with(this).load(R.mipmap.tianlong).into(mImageview);
        //滑动监听
        mAppbarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                float max = appBarLayout.getTotalScrollRange();
                float alpha = Math.abs(verticalOffset) / max;

                mToolbarTitle.setAlpha(alpha);
            }
        });

        initRecyclerViewData();
        initRcyclerView();

    }

    private void initRcyclerView() {

        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(manager);
        MyRecyclerViewAdapter myRecyclerAdapter = new MyRecyclerViewAdapter();
        mRecyclerview.setAdapter(myRecyclerAdapter);
    }

    private List<String> listData;

    /**
     * 初始化 RecyclerView 的数据
     */
    private void initRecyclerViewData() {
        listData = new ArrayList<>();
        int m = 0;
        for (int i = 0; i < 100; i++) {
            listData.add("知识星球" +i);
            m++;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_right_menu6, menu);
        return super.onCreateOptionsMenu(menu);
    }


    private class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>{

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
            ViewHolder viewHolder = new ViewHolder(inflate);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.mTextView.setText(listData.get(position));
        }

        @Override
        public int getItemCount() {
            return listData.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView mTextView;
            public ViewHolder(View itemView) {
                super(itemView);
                mTextView = itemView.findViewById(R.id.textview);
            }
        }
    }



}
