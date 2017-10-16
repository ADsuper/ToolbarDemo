package io.github.adsuper.toolbardemo;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * 作者：luoshen/rsf411613593@gmail.com
 * 时间：2017年10月16日
 * 说明：自定义toolbar 右侧 menu 样式
 */

public class MyToolbarActionProvider extends ActionProvider {

    private Context mContext;
    private String text;
    private OnRightMenuClickListener onRightMenuClickListener;

    public MyToolbarActionProvider(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public View onCreateActionView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.toolbar_right_menu5_style, null);
        TextView textview = view.findViewById(R.id.text_right_menu);
        if (textview != null) {
            textview.setText(text); // animate
        }
        if (view != null) {

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getContext();
                    onRightMenuClickListener.onClick(view);
                }
            });
        }

        return view;
    }

    public void setText(String text) {
        this.text = text;
    }

    public interface OnRightMenuClickListener {
        void onClick(View view);
    }

    public void setOnRightMenuClickListener(OnRightMenuClickListener onRightMenuClickListener) {
        this.onRightMenuClickListener = onRightMenuClickListener;
    }
}
