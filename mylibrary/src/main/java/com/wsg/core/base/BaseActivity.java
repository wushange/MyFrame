package com.wsg.core.base;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lxj.xpopup.XPopup;
import com.lxj.xpopup.core.BasePopupView;

/**
 * @author wushange
 * @description:
 * @date :2021/04/21 0021 下午 1:51
 * @email 309646776@qq.com
 */
public abstract class BaseActivity extends AppCompatActivity {

    private Context context;
    private BasePopupView basePopupView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }

    public void showLoading(){
        showLoading("操作中...");
    }
    public void showLoading(String string) {
        if (basePopupView != null) {
            basePopupView.dismiss();
        }
        basePopupView = new XPopup.Builder(this)
                .dismissOnTouchOutside(false)
                .dismissOnBackPressed(false)
                .asLoading(string)
                .show();

    }

    public void dismissDialog() {
        if (basePopupView != null) {
            basePopupView.dismiss();
        }
    }

    public Context getContext() {
        return context;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
