package com.simalee.guangxiu.view.artist;


import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.entity.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/10.
 */

public class ArtistPresenter extends BasePresenter<ArtistContract.ArtistView> implements ArtistContract.IArtistPresenter {

    private static final String TAG = "ArtistPresenter";

    public ArtistPresenter() {

    }

    @Override
    public void loadArtistList() {
        if (isViewAttached()){
            mView.showArtistList(fakeArtistList());
        }
    }

    private List<Artist> fakeArtistList() {
        List<Artist> artistList = new ArrayList<>();
        Artist artist = new Artist();
        artist.setAvatar("");
        artist.setName("李狗蛋");

        artistList.add(artist);
        return artistList;
    }

    @Override
    public void loadArtistWithId(String id) {
        if (isViewAttached()){
            mView.showArtist(fakeArtist());
        }
    }

    private Artist fakeArtist() {

        Artist artist = new Artist();
        artist.setAvatar("");
        artist.setName("李狗蛋");
        artist.setAddress("中国");
        artist.setContact("12457896312");
        return artist;
    }
}
