package com.simalee.guangxiu.view.cartoon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.SuperKotlin.pictureviewer.ImagePagerActivity;
import com.SuperKotlin.pictureviewer.PictureConfig;
import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.EmbroideryWorkItem;
import com.simalee.guangxiu.utils.UrlUtils;
import com.unistrong.yang.zb_permission.Permission;
import com.unistrong.yang.zb_permission.ZbPermission;
import com.unistrong.yang.zb_permission.ZbPermissionFail;
import com.unistrong.yang.zb_permission.ZbPermissionSuccess;

import java.util.ArrayList;

/**
 * Created by zb.yang on 2018/5/15.
 */

public class EmbroideryContentActivity extends BaseMVPActivity<EmbroideryPresenter> implements EmbroideryContract.EmbroideryView {
    private static final String TAG = "EmbroideryContentActivity";

    private TextView authorNameAndWorkNameTV;
    private ImageView embroideryImageIV;
    private TextView embroideryDescriptionTV;

    private EmbroideryWorkItem embroideryWorkItem;

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
        embroideryImageIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list = new ArrayList<>();
                if(embroideryWorkItem!=null){
                    list.add(UrlUtils.getImageUrl(embroideryWorkItem.getImageUrl()));
                }
                PictureConfig config = new PictureConfig.Builder()
                        .setListData(list)//图片数据List<String> list
                        .setPosition(0)//图片下标（从第position张图片开始浏览）
                        .setDownloadPath("pictureviewer")//图片下载文件夹地址
                        .setIsShowNumber(false)//是否显示数字下标
                        .needDownload(true)//是否支持图片下载
                        .setPlacrHolder(R.mipmap.avatar_default)//占位符图片（图片加载完成前显示的资源图片，来源drawable或者mipmap）
                        .build();
                ZbPermission.with(EmbroideryContentActivity.this)
                        .addRequestCode(100)
                        .permissions(Permission.STORAGE)
                        .request();
                ImagePagerActivity.startActivity(EmbroideryContentActivity.this, config);
            }
        });
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        embroideryWorkItem = bundle.getParcelable(GalleryAdapter.EMBROIDERY_WORK_ITEM_KEY);
        if(embroideryWorkItem!=null){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("大师")
                    .append(embroideryWorkItem.getAuthorName())
                    .append("作品《")
                    .append(embroideryWorkItem.getWorkName())
                    .append("》");
            authorNameAndWorkNameTV.setText(stringBuilder.toString());
            Glide.with(EmbroideryContentActivity.this)
                    .load(UrlUtils.getImageUrl(embroideryWorkItem.getImageUrl()))
                    .placeholder(R.drawable.ic_refresh_white_18dp)
                    .crossFade()
                    .error(R.mipmap.embroidery_default)
                    .into(embroideryImageIV);
            embroideryDescriptionTV.setText(embroideryWorkItem.getWorkDescription());
        }
    }

    @Override
    protected void createPresenter() {
        mPresenter = new EmbroideryPresenter();
        mPresenter.attachView(this);
    }

    @ZbPermissionSuccess(requestCode = 100)
    public void permissionSuccessContact() {

    }

    @ZbPermissionFail(requestCode = 100)
    public void permissionFailContact() {
        Toast.makeText(EmbroideryContentActivity.this, "请求存储权限失败" , Toast.LENGTH_SHORT).show();
    }
}
