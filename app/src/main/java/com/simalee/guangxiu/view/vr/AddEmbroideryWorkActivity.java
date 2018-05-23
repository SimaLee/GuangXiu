package com.simalee.guangxiu.view.vr;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.DataManager;
import com.simalee.guangxiu.data.entity.LocalEmbroideryWork;
import com.unistrong.yang.zb_permission.Permission;
import com.unistrong.yang.zb_permission.ZbPermission;
import com.unistrong.yang.zb_permission.ZbPermissionFail;
import com.unistrong.yang.zb_permission.ZbPermissionSuccess;

/**
 * Created by zb.yang on 2018/5/22.
 */

public class AddEmbroideryWorkActivity extends BaseMVPActivity<AddEmbroideryWorkPresenter> implements AddEmbroideryWorkContract.AddEmbroideryWorkView {
    private static final String TAG = "AddEmbroideryWork";
    public static final String KEY = "type";


    private final int IMAGE_REQUEST_CODE = 11;

    private final int STROAGE_PER_REQUEST_CODE = 21;

    private int type = 1;

    private ImageView cancleIv;
    private ImageView saveIv;
    private EditText authorNameEt;
    private TextView authorNameTipsTv;
    private EditText workNameEt;
    private TextView workNameTipsTv;
    private EditText workDesEt;
    private TextView workDesTipsTv;
    private ImageView addPicture;
    private ImageView photoIv;
    private VrPanoramaView vrPanoramaView;

    private String workPath = "";
    private String workName = "";
    private String authorName = "";
    private String workDes = "";


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
        return R.layout.activity_add_embroidery_work;
    }

    @Override
    protected void initViews() {
        cancleIv = (ImageView)findViewById(R.id.cancleIv);
        saveIv = (ImageView)findViewById(R.id.saveEmbroideryIv);
        authorNameEt = (EditText)findViewById(R.id.workAuthorEt);
        authorNameTipsTv = (TextView)findViewById(R.id.tv_tips);
        workNameEt = (EditText)findViewById(R.id.workNameEt);
        workNameTipsTv = (TextView)findViewById(R.id.tv_tips_2);
        workDesTipsTv = (TextView)findViewById(R.id.tv_content_tips);
        workDesEt = (EditText) findViewById(R.id.workDesEt);
        addPicture = (ImageView)findViewById(R.id.addPictureIv);
        photoIv = (ImageView)findViewById(R.id.photoIv);
        vrPanoramaView = (VrPanoramaView)findViewById(R.id.vrPanoramaView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null) {
            type = bundle.getInt(AddEmbroideryWorkActivity.KEY);
            Log.i(TAG,"type = "+type);
        }


    }

    @Override
    protected void initListeners() {
        cancleIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        authorNameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                authorNameTipsTv.setText(s.toString().trim().length()+"/15");
            }
        });

        workNameEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                workNameTipsTv.setText(s.toString().trim().length()+"/15");
            }
        });

        workDesEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                workDesTipsTv.setText(s.toString().trim().length()+"/300");
            }
        });

        addPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZbPermission.with(AddEmbroideryWorkActivity.this)
                        .permissions(Permission.STORAGE)
                        .addRequestCode(STROAGE_PER_REQUEST_CODE)
                        .request();
            }
        });

        saveIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authorName = authorNameEt.getText().toString().trim();
                workName = workNameEt.getText().toString().trim();
                workDes = workDesEt.getText().toString().trim();

                if(TextUtils.isEmpty(authorName) || TextUtils.isEmpty(workName)
                        || TextUtils.isEmpty(workDes) || TextUtils.isEmpty(workPath)){
                    Toast.makeText(AddEmbroideryWorkActivity.this,"请填补完整所有数据",Toast.LENGTH_SHORT).show();
                    return;
                }

                LocalEmbroideryWork localEmbroideryWork = new LocalEmbroideryWork();
                localEmbroideryWork.setType(type);
                localEmbroideryWork.setAuthorName(authorName);
                localEmbroideryWork.setWorkName(workName);
                localEmbroideryWork.setWorkDes(workDes);
                localEmbroideryWork.setWorkPath(workPath);

                if (DataManager.getInstance().saveLocalEmbroideryWork(localEmbroideryWork)){
                    Toast.makeText(AddEmbroideryWorkActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddEmbroideryWorkActivity.this,MyLocalWorksActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(AddEmbroideryWorkActivity.this,"保存失败",Toast.LENGTH_SHORT).show();
                }

            }
        });

        photoIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        photoIv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(photoIv.getVisibility() == View.VISIBLE){
                    photoIv.setVisibility(View.GONE);
                    addPicture.setVisibility(View.VISIBLE);
                    workPath = "";
                }
                return false;
            }
        });

        vrPanoramaView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(vrPanoramaView.getVisibility() == View.VISIBLE){
                    vrPanoramaView.setVisibility(View.GONE);
                    addPicture.setVisibility(View.VISIBLE);
                    workPath = "";
                }
                return false;
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void createPresenter() {
        mPresenter = new AddEmbroideryWorkPresenter();
        mPresenter.attachView(this);
    }

    public static void HideKeyboard(View v)
    {
        InputMethodManager imm = ( InputMethodManager ) v.getContext( ).getSystemService( Context.INPUT_METHOD_SERVICE );
        if ( imm.isActive( ) ) {
            imm.hideSoftInputFromWindow( v.getApplicationWindowToken( ) , 0 );

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        HideKeyboard(authorNameEt);
        HideKeyboard(workNameEt);
        HideKeyboard(workDesEt);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        //在相册里面选择好相片之后调回到现在的这个activity中
        switch (requestCode) {
            case IMAGE_REQUEST_CODE://这里的requestCode是我自己设置的，就是确定返回到那个Activity的标志
                if (resultCode == RESULT_OK) {//resultcode是setResult里面设置的code值
                    try {
                        Uri selectedImage = data.getData(); //获取系统返回的照片的Uri
                        String[] filePathColumn = {MediaStore.Images.Media.DATA};
                        Cursor cursor = getContentResolver().query(selectedImage,
                                filePathColumn, null, null, null);//从系统表中查询指定Uri对应的照片
                        cursor.moveToFirst();
                        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                        workPath = cursor.getString(columnIndex);  //获取照片路径
                        cursor.close();
                        Bitmap bitmap = BitmapFactory.decodeFile(workPath);
                        if(type == LocalEmbroideryWork.PANO_TYPE){
                            vrPanoramaView.setVisibility(View.VISIBLE);
                            photoIv.setVisibility(View.GONE);
                            addPicture.setVisibility(View.GONE);
                            VrPanoramaView.Options options = new VrPanoramaView.Options();
                            options.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
                            vrPanoramaView.loadImageFromBitmap(bitmap,options);
                        }else {
                            photoIv.setVisibility(View.VISIBLE);
                            vrPanoramaView.setVisibility(View.GONE);
                            addPicture.setVisibility(View.GONE);
                            photoIv.setImageBitmap(bitmap);
                        }

                    } catch (Exception e) {
                        // TODO Auto-generatedcatch block
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @ZbPermissionSuccess(requestCode = STROAGE_PER_REQUEST_CODE)
    public void persimssionSuccess(){
        Intent intent = new Intent(
                Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, IMAGE_REQUEST_CODE);
    }

    @ZbPermissionFail(requestCode = STROAGE_PER_REQUEST_CODE)
    public void permissionFail() {
        Toast.makeText(AddEmbroideryWorkActivity.this,"permission denied!!",Toast.LENGTH_SHORT).show();
    }
}
