package com.simalee.guangxiu.view.artist;


import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.DataManager;
import com.simalee.guangxiu.data.entity.Artist;
import com.simalee.guangxiu.data.model.DataCallback;

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
        mView.showArtistList(fakeArtistList());
//        DataManager.getInstance().getArtistList(new DataCallback<List<Artist>>() {
//            @Override
//            public void onSuccess(List<Artist> data) {
//                if (isViewAttached()){
//                    mView.showArtistList(fakeArtistList());
//                }
//            }
//
//            @Override
//            public void onFailure(String msg) {
//                if (isViewAttached()){
//                    mView.showError();
//                }
//            }
//
//            @Override
//            public void onError() {
//                if (isViewAttached()){
//                    mView.showError();
//                }
//            }
//        });

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
    public void loadArtistWithId(String artistId) {
        DataManager.getInstance().getArtistInfoWithId(artistId, new DataCallback<Artist>() {
            @Override
            public void onSuccess(Artist data) {
                if (isViewAttached()){
                    mView.showArtist(data);
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

    private Artist fakeArtist() {

        Artist artist = new Artist();
        artist.setAvatar("");
        artist.setName("李狗蛋");
        artist.setAddress("中国");
        artist.setContact("12457896312");
        artist.setHonor("（3）2012年10月，作品《纯洁》、《气贯山河》在由广州工艺美术行业协会主办的广州市传统工艺博览会暨第八届广州工艺美术精品评比中分别获得了金奖和银奖。\\n （4）2012年12月，作品《荷趣》、《春晖图》在广州市传统工艺博览会中分别获得金奖和银奖，其中《荷趣》同时在由中国礼品产业协会等主办的第四届中国广州国际工艺品艺术品收藏品及红木文化博览会上，获得首届“中国.金艺奖”国际工艺美术创新设计大奖金奖。");
        artist.setIntroduction("广州广绣第五批非物质文化遗产传承人梁雪珍出生于番禺区新造镇北亭村（现属小谷围）。北亭村自古就有广绣传统，梁雪珍自小受着良好的广绣艺术环境熏陶，从12岁时就开始绣花赚钱，好学而不倦的她，很快就掌握了各种特殊的针法，并运用到刺绣的不同种生活物品上，如：墙壁挂画，戏服，手帕，床单等。至今，梁雪珍的刺绣经验已超过半个世纪，可谓艺海老仙。");
        return artist;
    }
}
