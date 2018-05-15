package com.simalee.guangxiu.data.model;

import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.entity.Artist;
import com.simalee.guangxiu.data.entity.EmbroideryIntroduction;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
import com.simalee.guangxiu.data.entity.QuizItem;
import com.simalee.guangxiu.data.entity.QuizOptionItem;
import com.simalee.guangxiu.data.entity.SimpleIntroduction;
import com.simalee.guangxiu.data.entity.StitchInfoDetail;
import com.simalee.guangxiu.data.entity.StitchIntroduction;
import com.simalee.guangxiu.data.entity.StitchItem;
import com.simalee.guangxiu.data.entity.TextImageItem;
import com.simalee.guangxiu.data.entity.ThreadIntroduction;
import com.simalee.guangxiu.data.entity.ThreadItem;
import com.simalee.guangxiu.data.entity.Version;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/8.
 */

public class ResponseParser {

    private ResponseParser(){

    }

    /**
     * 版本号相关解析
     * @param jsonObject
     * @return
     * @throws JSONException
     */
    public static Version parseVersion(JSONObject jsonObject) throws JSONException{

        Version version = new Version();

        version.setVer_origin(jsonObject.getInt("ver_origin"));
        version.setVer_meaning(jsonObject.getInt("ver_meaning"));
        version.setVer_phase(jsonObject.getInt("ver_phase"));
        version.setVer_development(jsonObject.getInt("ver_development"));
        version.setVer_art(jsonObject.getInt("ver_art"));
        version.setVer_embroidery(jsonObject.getInt("ver_embroidery"));
        version.setVer_stitch(jsonObject.getInt("ver_stitch"));
        version.setVer_thread(jsonObject.getInt("ver_thread"));
        version.setVer_pergola(jsonObject.getInt("ver_pergola"));
        version.setVer_desc(jsonObject.getInt("ver_desc"));
        version.setVer_master(jsonObject.getInt("ver_master"));
        version.setVer_masterdesc(jsonObject.getInt("ver_masterdesc"));
        version.setVer_masterwork(jsonObject.getInt("ver_masterwork"));
        version.setVer_video(jsonObject.getInt("ver_video"));
        version.setVer_answer(jsonObject.getInt("ver_answer"));
        version.setVer_needle(jsonObject.getInt("ver_needle"));

        return version;
    }

    /**
     * 广绣简要介绍解析
     * @param jsonObject
     * @return
     * @throws JSONException
     */
    public static SimpleIntroduction parseSimpleIntroduction(JSONObject jsonObject) throws JSONException{
        String backgroundUrl = jsonObject.getString("background");
        String desc = jsonObject.getString("desc");
        return new SimpleIntroduction(desc,backgroundUrl);
    }
    /**
     * 艺术特点解析
     * @param jsonObject
     * @return
     * @throws JSONException
     */
    public static ArtFeature parseArtFeature(JSONObject jsonObject) throws JSONException{
        ArtFeature artFeature = new ArtFeature();
        artFeature.setItemList(parseItemList(jsonObject));
        return artFeature;
    }


    /**
     * 花架信息解析
     * @param jsonObject
     * @return
     * @throws JSONException
     */
    public static PergolaIntroduction parsePergolaIntroduction(JSONObject jsonObject) throws JSONException{
        PergolaIntroduction introduction = new PergolaIntroduction();
        introduction.setItemList(parseItemList(jsonObject));
        return introduction;
    }

    public static StitchIntroduction parseStitchIntroduction(JSONObject jsonObject) throws JSONException{
        StitchIntroduction introduction = new StitchIntroduction();
        introduction.setItemList(parseItemList(jsonObject));
        return introduction;
    }

    /**
     * 绣线列表解析
     * @param jsonArray
     * @return
     * @throws JSONException
     */
    public static List<ThreadItem> parseThreadList(JSONArray jsonArray) throws JSONException{
        List<ThreadItem> itemList = new ArrayList<>();
        int len = jsonArray.length();
        ThreadItem item ;
        JSONObject jsonObject;
        for ( int i =0; i< len;i++){

            jsonObject = jsonArray.getJSONObject(i);

            item = new ThreadItem();
            item.setId(jsonObject.getString("id"));
            item.setName(jsonObject.getString("name"));
            item.setImage(jsonObject.getString("image"));

            itemList.add(item);
        }
        return itemList;
    }

    /**
     * 针法列表解析
     * @param jsonArray
     * @return
     * @throws JSONException
     */
    public static List<StitchItem> parseStitchItemList(JSONArray jsonArray) throws JSONException{

        List<StitchItem> itemList = new ArrayList<>();
        int len = jsonArray.length();
        StitchItem item ;
        JSONObject jsonObject;
        for ( int i =0; i< len;i++){

            jsonObject = jsonArray.getJSONObject(i);

            item = new StitchItem();
            item.setId(jsonObject.getString("id"));
            item.setName(jsonObject.getString("name"));
            item.setImage(jsonObject.getString("image"));

            itemList.add(item);
        }
        return itemList;
    }

    /**
     * 解析名家列表
     * @param jsonArray
     * @return
     * @throws JSONException
     */
    public static List<Artist> parseArtistList(JSONArray jsonArray) throws JSONException{
        List<Artist> artistList = new ArrayList<>();

        int len = jsonArray.length();
        Artist tempArtist ;
        JSONObject jsonObject;

        for (int i = 0; i < len; i++) {
            tempArtist = new Artist();
            jsonObject = jsonArray.getJSONObject(i);

            tempArtist.setAvatar(jsonObject.getString("avatar"));
            tempArtist.setId(jsonObject.getString("master_id"));
            tempArtist.setName(jsonObject.getString("name"));

            artistList.add(tempArtist);
        }
        return artistList;
    }

    /**
     * 解析名家信息
     * @param jsonObject
     * @return
     * @throws JSONException
     */
    public static Artist parseArtistInfo(JSONObject jsonObject) throws JSONException{
        Artist artist = new Artist();

        artist.setName(jsonObject.getString("name"));
        artist.setAvatar(jsonObject.getString("avatar"));
        artist.setAddress(jsonObject.getString("address"));
        artist.setContact(jsonObject.getString("contract"));
        artist.setHonor(jsonObject.getString("honor"));
        artist.setIntroduction(jsonObject.getString("introduction"));

        //todo 作品列表解析
        return artist;
    }

    /**
     * 答题模块解析
     * @param jsonArray
     * @return
     * @throws JSONException
     */
    public static List<QuizItem> parseQuizList(JSONArray jsonArray) throws JSONException{
        int len = jsonArray.length();
        List<QuizItem> quizItemList = new ArrayList<>(len);
        QuizItem tempItem;
        JSONObject object;
        for (int i = 0; i < len; i++) {
            object = jsonArray.getJSONObject(i);

            tempItem = new QuizItem();

            tempItem.setId("");//没有返回id
            tempItem.setSequence(object.getInt("seq"));
            tempItem.setQuestion(object.getString("name"));
            tempItem.setImage(object.getString("image"));
            tempItem.setAnswerId(object.getInt("answer"));
            tempItem.setExplanation(object.getString("explanation"));
            tempItem.setOptions(parseQuizOptionList(object));

            quizItemList.add(tempItem);

        }
        return quizItemList;
    }

    private static List<QuizOptionItem> parseQuizOptionList(JSONObject object) throws JSONException{
        //当前只有四个选项
        List<QuizOptionItem> quizOptionItems = new ArrayList<>(4);

        quizOptionItems.add(new QuizOptionItem(0,object.getString("choice_A")));
        quizOptionItems.add(new QuizOptionItem(1,object.getString("choice_B")));
        quizOptionItems.add(new QuizOptionItem(2,object.getString("choice_C")));
        quizOptionItems.add(new QuizOptionItem(3,object.getString("choice_D")));

        return quizOptionItems;
    }

    /**
     * 针介绍 解析
     * @param jsonObject
     * @return
     * @throws JSONException
     */
    public static ThreadIntroduction parseThreadIntroduction(JSONObject jsonObject) throws JSONException{
        ThreadIntroduction introduction = new ThreadIntroduction();
        introduction.setItemList(parseItemList(jsonObject));
        return introduction;
    }

    /**
     * 绣种介绍 解析
     * @param jsonObject
     * @return
     * @throws JSONException
     */
    public static EmbroideryIntroduction parseEmbroideryIntroduction(JSONObject jsonObject) throws JSONException{
        EmbroideryIntroduction introduction = new EmbroideryIntroduction();
        introduction.setItemList(parseItemList(jsonObject));
        return introduction;
    }

    /**
     * 针法介绍 解析
     * @param jsonObject
     * @return
     * @throws JSONException
     */
    public static StitchInfoDetail parseStitchInfoDetail(JSONObject jsonObject) throws JSONException{
        StitchInfoDetail stitchInfoDetail = new StitchInfoDetail();
        stitchInfoDetail.setItemList(parseItemList(jsonObject));
        return stitchInfoDetail;
    }

    /**
     * 图文itemlist 解析
     * @param jsonObject
     * @return
     * @throws JSONException
     */
    private static List<TextImageItem> parseItemList(JSONObject jsonObject) throws JSONException{

        int len = jsonObject.getInt("len");
        JSONArray jsonArray = jsonObject.getJSONArray("item");
        List<TextImageItem> textImageItemList = new ArrayList<>(len);
        TextImageItem textImageItem;
        JSONObject item;
        for (int i = 0; i < len; i++){

            item = jsonArray.getJSONObject(i);

            textImageItem = new TextImageItem();
            textImageItem.setId(item.getString("id"));
            textImageItem.setSequence(item.getInt("seq"));
            textImageItem.setType(item.getInt("type"));
            textImageItem.setText(item.getString("text"));
            textImageItem.setImageurl(item.getString("image"));
            textImageItem.setHeight(item.getInt("height"));
            textImageItem.setWidth(item.getInt("width"));

            textImageItemList.add(textImageItem);
        }
        Collections.sort(textImageItemList);
        return textImageItemList;
    }
}
