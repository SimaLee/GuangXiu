package com.simalee.guangxiu.view.vr;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.SuperKotlin.pictureviewer.ImagePagerActivity;
import com.SuperKotlin.pictureviewer.PictureConfig;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.data.entity.LocalEmbroideryWork;
import com.simalee.guangxiu.utils.UrlUtils;
import com.simalee.guangxiu.view.cartoon.EmbroideryContentActivity;
import com.unistrong.yang.zb_permission.Permission;
import com.unistrong.yang.zb_permission.ZbPermission;
import com.unistrong.yang.zb_permission.ZbPermissionFail;
import com.unistrong.yang.zb_permission.ZbPermissionSuccess;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;

/**
 * Created by zb.yang on 2018/5/23.
 */

public class LocalEmbroideryContentActivity extends AppCompatActivity {
    private static final String TAG = "LocalEmbroideryContent";

    private TextView authorNameAndWorkNameTV;
    private ImageView embroideryImageIV;
    private TextView embroideryDescriptionTV;
    private VrPanoramaView vrPanoramaView;

    private LocalEmbroideryWork localEmbroideryWork;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_embroidery_content);

        resloveIntent();
        initView();
        initListener();
    }

    private void resloveIntent(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null) {
            localEmbroideryWork = bundle.getParcelable(LocalEmbroideryWork.TAG);
        }
    }

    private void initView(){
        authorNameAndWorkNameTV = (TextView)findViewById(R.id.authorNameAndWorkNameTV);
        embroideryImageIV = (ImageView)findViewById(R.id.embroideryWorkIV);
        embroideryDescriptionTV = (TextView)findViewById(R.id.embroideryDescriptionTV);
        vrPanoramaView = (VrPanoramaView)findViewById(R.id.vrPanoramaView);

        if(localEmbroideryWork!=null){
            authorNameAndWorkNameTV.setText(localEmbroideryWork.getAuthorName()+"大师作品《"+localEmbroideryWork.getWorkName()+"》");
            Bitmap bitmap = BitmapFactory.decodeFile(localEmbroideryWork.getWorkPath());
            embroideryDescriptionTV.setText(localEmbroideryWork.getWorkDes());
            if(localEmbroideryWork.getType() == LocalEmbroideryWork.PANO_TYPE){
                embroideryImageIV.setVisibility(View.GONE);
                vrPanoramaView.setVisibility(View.VISIBLE);
                VrPanoramaView.Options options = new VrPanoramaView.Options();
                options.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
                vrPanoramaView.loadImageFromBitmap(bitmap,options);
            }else{
                vrPanoramaView.setVisibility(View.GONE);
                embroideryImageIV.setVisibility(View.VISIBLE);
                embroideryImageIV.setImageBitmap(bitmap);
            }
        }
    }

    private void initListener(){

        embroideryImageIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> list = new ArrayList<>();
                if(localEmbroideryWork!=null){
                    list.add(localEmbroideryWork.getWorkPath());
                }
                PictureConfig config = new PictureConfig.Builder()
                        .setListData(list)//图片数据List<String> list
                        .setPosition(0)//图片下标（从第position张图片开始浏览）
                        .setDownloadPath("pictureviewer")//图片下载文件夹地址
                        .setIsShowNumber(false)//是否显示数字下标
                        .needDownload(true)//是否支持图片下载
                        .setPlacrHolder(R.mipmap.avatar_default)//占位符图片（图片加载完成前显示的资源图片，来源drawable或者mipmap）
                        .build();
                ZbPermission.with(LocalEmbroideryContentActivity.this)
                        .addRequestCode(100)
                        .permissions(Permission.STORAGE)
                        .request();
                ImagePagerActivity.startActivity(LocalEmbroideryContentActivity.this, config);
            }
        });


    }

    @ZbPermissionSuccess(requestCode = 100)
    public void permissionSuccessContact() {

    }

    @ZbPermissionFail(requestCode = 100)
    public void permissionFailContact() {
        Toast.makeText(LocalEmbroideryContentActivity.this, "请求存储权限失败" , Toast.LENGTH_SHORT).show();
    }

}


