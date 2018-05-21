package com.simalee.guangxiu.view.artist;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BaseMVPActivity;
import com.simalee.guangxiu.data.entity.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/10.
 */

public class ArtistListActivity extends BaseMVPActivity<ArtistPresenter> implements ArtistContract.ArtistView {

    private static final String TAG = "ArtistListActivity";


    private RecyclerView mRecyclerView;
    private ArtistListAdapter mAdapter;

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
        mAdapter.replaceData(artistList);
    }

    @Override
    public void showArtist(Artist artist) {
        //do nothing
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_artist_list;
    }

    @Override
    protected void initViews() {
        mRecyclerView = findViewById(R.id.rv_artist_list);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mAdapter = new ArtistListAdapter(this,new ArrayList<Artist>());
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void initListeners() {
        mAdapter.setItemClickListener(new ArtistListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View nameView,View avatarView, int position, Artist item) {
                Log.d(TAG, "onItemClick: " + item);
                Intent intent = new Intent(ArtistListActivity.this,ArtistInfoActivity.class);
                intent.putExtra("id",item.getId());

                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(ArtistListActivity.this,
                        new Pair<View, String>(avatarView,"iv_avatar"));

                ActivityCompat.startActivity(ArtistListActivity.this,intent,options.toBundle());
                //startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        mPresenter.loadArtistList();
    }

    @Override
    protected void createPresenter() {
        mPresenter = new ArtistPresenter();
        mPresenter.attachView(this);
    }
}
