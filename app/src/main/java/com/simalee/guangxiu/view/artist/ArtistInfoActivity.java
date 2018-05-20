package com.simalee.guangxiu.view.artist;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.SuperKotlin.pictureviewer.ImagePagerActivity;
import com.SuperKotlin.pictureviewer.PictureConfig;
import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.app.UrlConstants;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.Artist;
import com.simalee.guangxiu.data.entity.EmbroideryWorkItem;
import com.simalee.guangxiu.view.cartoon.GalleryActivity;
import com.simalee.guangxiu.view.cartoon.GalleryAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/10.
 */

public class ArtistInfoActivity extends BaseMVPActivity<ArtistPresenter> implements ArtistContract.ArtistView {
    private static final String TAG = "ArtistInfoActivity";


    private ImageView mArtistAvatarView;
    private TextView mArtistNameView;
    private TextView mArtistAddressView;
    private TextView mArtistContactView;
    private TextView mArtistIntroductionView;
    private TextView mArtistHonorView;
    private RecyclerView mRecyclerView;
    private TextView mEmptyView;

    private GalleryAdapter mGalleryAdapter;
    private List<EmbroideryWorkItem> mEmbroideryWorkItems;

    private String mAvataUrl = null;

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
    public void showArtistList(List<Artist> artistList) {
        //do nothing
    }

    @Override
    public void showArtist(Artist artist) {

        if (artist == null){
            return;
        }
        mArtistNameView.setText(artist.getName());
        mArtistAddressView.setText(artist.getAddress());
        mArtistContactView.setText(artist.getContact());
        mArtistIntroductionView.setText(artist.getIntroduction());
        mArtistHonorView.setText(artist.getHonor());

        mAvataUrl = UrlConstants.BASE_FILE_URL + artist.getAvatar();
        Glide.with(this)
                .load(mAvataUrl)
                .fitCenter()
                .error(R.mipmap.avatar_default)
                .into(mArtistAvatarView);

        if (artist.getWorkList() != null){
            mEmptyView.setVisibility(View.GONE);
            mGalleryAdapter.setEmbroideryWorkItems(artist.getWorkList());
        }else{
            mEmptyView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_artist_info;
    }

    @Override
    protected void initViews() {
        mArtistAvatarView = findViewById(R.id.iv_artist_avatar);
        mArtistNameView = findViewById(R.id.tv_artist_name);
        mArtistAddressView = findViewById(R.id.tv_artist_address);
        mArtistContactView = findViewById(R.id.tv_artist_contact);
        mArtistIntroductionView = findViewById(R.id.tv_artist_introduction);
        mArtistHonorView = findViewById(R.id.tv_artist_honor);
        mEmptyView = findViewById(R.id.tv_work_list_empty);

        mRecyclerView = findViewById(R.id.rv_work_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mEmbroideryWorkItems = new ArrayList<>();
        mGalleryAdapter = new GalleryAdapter(this,mEmbroideryWorkItems);
        mRecyclerView.setAdapter(mGalleryAdapter);
    }

    @Override
    protected void initListeners() {

        mArtistAvatarView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mAvataUrl != null){
                    ArrayList<String> imageList = new ArrayList<>();
                    imageList.add(mAvataUrl);
                    PictureConfig config = new PictureConfig.Builder()
                            .setListData(imageList)//图片数据List<String> list
                            .setPosition(0)//图片下标（从第position张图片开始浏览）
                            .setDownloadPath("artist")//图片下载文件夹地址
                            .setIsShowNumber(false)//是否显示数字下标
                            .needDownload(true)//是否支持图片下载
                            .setPlacrHolder(R.mipmap.avatar_default)//占位符图片（图片加载完成前显示的资源图片，来源drawable或者mipmap）
                            .build();

                    ImagePagerActivity.startActivity(ArtistInfoActivity.this, config);
                }
            }
        });
    }

    @Override
    protected void initData() {
        String artistId = getIntent().getStringExtra("id");
        mPresenter.loadArtistWithId(artistId);
    }

    @Override
    protected void createPresenter() {
        mPresenter = new ArtistPresenter();
        mPresenter.attachView(this);
    }
}
