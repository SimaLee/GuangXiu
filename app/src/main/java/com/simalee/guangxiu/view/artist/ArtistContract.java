package com.simalee.guangxiu.view.artist;

import com.simalee.guangxiu.base.BaseView;
import com.simalee.guangxiu.data.entity.Artist;

import java.util.List;

/**
 * Created by Lee Sima on 2018/5/10.
 */

public interface ArtistContract {
    interface ArtistView extends BaseView{
        void showArtistList(List<Artist> artistList);
        void showArtist(Artist artist);
    }

    interface IArtistPresenter {
        void loadArtistList();
        void loadArtistWithId(String artistId);
    }
}
