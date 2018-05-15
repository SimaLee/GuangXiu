package com.simalee.guangxiu.view.cartoon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.EmbroideryWorkItem;
import com.simalee.guangxiu.view.technique.EmbroideryActivity;

/**
 * Created by zb.yang on 2018/5/15.
 */

public class EmbroideryContentActivity extends BaseMVPActivity<EmbroideryPresenter> implements EmbroideryContract.EmbroideryView {
    private static final String TAG = "EmbroideryContentActivity";

    private TextView authorNameAndWorkNameTV;
    private ImageView embroideryImageIV;
    private TextView embroideryDescriptionTV;
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_embroidery_content;
    }

    @Override
    protected void initViews() {
        authorNameAndWorkNameTV = (TextView)findViewById(R.id.authorNameAndWorkNameTV);
        embroideryImageIV = (ImageView)findViewById(R.id.embroideryWorkIV);
        embroideryDescriptionTV = (TextView)findViewById(R.id.embroideryDescriptionTV);
    }

    @Override
    protected void initListeners() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        EmbroideryWorkItem embroideryWorkItem = bundle.getParcelable(GalleryAdapter.EMBROIDERY_WORK_ITEM_KEY);
        if(embroideryWorkItem!=null){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("大师")
                    .append(embroideryWorkItem.getAuthorName())
                    .append("作品《")
                    .append(embroideryWorkItem.getWorkName())
                    .append("》");
            authorNameAndWorkNameTV.setText(stringBuilder.toString());
            Glide.with(EmbroideryContentActivity.this)
                    .load(embroideryWorkItem.getImageUrl())
                    .placeholder(R.mipmap.bg_introduction_default)
                    .crossFade()
                    .into(embroideryImageIV);
            embroideryDescriptionTV.setText(embroideryWorkItem.getWorkDescription());
        }
    }

    @Override
    protected void createPresenter() {
        mPresenter = new EmbroideryPresenter();
        mPresenter.attachView(this);
    }
}
