package com.simalee.guangxiu.view.technique;

import android.util.Log;

import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.DataManager;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
import com.simalee.guangxiu.data.entity.StitchIntroduction;
import com.simalee.guangxiu.data.entity.ThreadItem;
import com.simalee.guangxiu.data.model.DataCallback;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/7.
 */

public class MaterialPresenter extends BasePresenter<TechniqueContract.MaterialView> implements TechniqueContract.IMaterialPresenter {

    private static final String TAG = "MaterialPresenter";

    public MaterialPresenter() {
    }

    @Override
    public void performPergolaClick() {
        if (isViewAttached()){
            mView.onPergolaClick();
        }
    }

    @Override
    public void performStitchClick() {
        if (isViewAttached()){
            mView.onStitchClick();
        }
    }

    @Override
    public void performThreadClick() {
        if (isViewAttached()){
            mView.onThreadClick();
        }
    }

    @Override
    public void loadPergolaIntroduction() {
        DataManager.getInstance().getPergolaIntroduction(new DataCallback<PergolaIntroduction>() {
            @Override
            public void onSuccess(PergolaIntroduction data) {
                if (isViewAttached()){
                    mView.showPergolaIntroduction(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()){
                    mView.showError();
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()){
                    mView.showError();
                }
            }
        });
    }

    @Override
    public void loadStitchIntroduction() {
        DataManager.getInstance().getStitchIntroduction(new DataCallback<StitchIntroduction>() {
            @Override
            public void onSuccess(StitchIntroduction data) {
                if (isViewAttached()){
                    mView.showStitchIntroduction(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()){
                    mView.showError();
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()){
                    mView.showError();
                }
            }
        });

    }

    @Override
    public void loadThreadList() {
        DataManager.getInstance().getThreadList(new DataCallback<List<ThreadItem>>() {
            @Override
            public void onSuccess(List<ThreadItem> data) {
                Log.d(TAG, "onSuccess: " + data);
                if (isViewAttached()){
                    mView.showThreadList(data);
                }
            }

            @Override
            public void onFailure(String msg) {
                if (isViewAttached()){
                    mView.showError();
                }
            }

            @Override
            public void onError() {
                if (isViewAttached()){
                    mView.showError();
                }
            }
        });
    }
}
