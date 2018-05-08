package com.simalee.guangxiu.view.main;


import android.util.Log;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.DataManager;
import com.simalee.guangxiu.data.entity.Version;
import com.simalee.guangxiu.data.model.DataCallback;

/**
 * Created by Lee Sima on 2018/4/24.
 */

public class MainPresenter extends BasePresenter<MainContract.MainView> implements MainContract.IMainPresenter {

    private static final String TAG = "IMainPresenter";

    public MainPresenter(){
        //empty constructor
    }

    @Override
    public void performLogoClick() {
        mView.onLogoClick();
    }

    @Override
    public void performHistoryClick() {
        mView.onHistoryClick();
    }

    @Override
    public void performTechniqueClick() {
        mView.onTechniqueClick();
    }

    @Override
    public void performArtistClick() {
        mView.onArtistClick();
    }

    @Override
    public void performCartoonClick() {
        mView.onCartoonClick();
    }

    @Override
    public void performTeachingClick() {
        mView.onTeachingClick();
    }

    @Override
    public void checkVersion() {

        DataManager.getInstance().getVersionCode(new DataCallback<Version>() {
            @Override
            public void onSuccess(Version data) {
                Log.d(TAG, "onSuccess: " + data);
                mView.showToast("当前版本号:"+data.getVersionCode());
            }

            @Override
            public void onFailure(String msg) {
                mView.showToast("获取最新版本号失败!");
            }

            @Override
            public void onError() {

            }
        });
    }
}
