package com.simalee.guangxiu.view.artist;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.Artist;

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
    private TextView mArtistIntroducitonView;
    private TextView mArtistHonorView;
    private RecyclerView mRecyclerView;

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

//        mArtistNameView.setText(artist.getName());
//        mArtistAddressView.setText(artist.getAddress());
//        mArtistContactView.setText(artist.getContact());
//        mArtistIntroducitonView.setText(artist.getIntroduction());
//        mArtistHonorView.setText(artist.getHonor());
//
//        Glide.with(this)
//                .load(artist.getAvatar())
//                .fitCenter()
//                .error(R.mipmap.avatar_default)
//                .into(mArtistAvatarView);
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
        mArtistIntroducitonView = findViewById(R.id.tv_artist_introduction);
//        mArtistIntroducitonView.setMovementMethod(ScrollingMovementMethod.getInstance());

        mArtistHonorView = findViewById(R.id.tv_artist_honor);
//        mArtistHonorView.setMovementMethod(ScrollingMovementMethod.getInstance());

        // TODO: 2018/5/10 添加作品列表
        mRecyclerView = findViewById(R.id.rv_work_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
    }

    @Override
    protected void initListeners() {

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
