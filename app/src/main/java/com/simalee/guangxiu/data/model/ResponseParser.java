package com.simalee.guangxiu.data.model;

import com.simalee.guangxiu.data.entity.ArtFeature;
import com.simalee.guangxiu.data.entity.EmbroideryIntroduction;
import com.simalee.guangxiu.data.entity.PergolaIntroduction;
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
     * @param jsonObject
     * @return
     * @throws JSONException
     */
    public static Version parseVersion(JSONObject jsonObject) throws JSONException{
        int versionCode = jsonObject.getInt("data");
        return new Version(versionCode);
    }

    public static SimpleIntroduction parseSimpleIntroduction(JSONObject jsonObject) throws JSONException{
        String backgroundUrl = jsonObject.getString("background");
        String desc = jsonObject.getString("desc");
        return new SimpleIntroduction(desc,backgroundUrl);
    }
    /**
     * @param jsonObject
     * @return
     * @throws JSONException
     */
    public static ArtFeature parseArtFeature(JSONObject jsonObject) throws JSONException{
        ArtFeature artFeature = new ArtFeature();
        artFeature.setItemList(parseItemList(jsonObject));
        return artFeature;
    }


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
    public static List<StitchItem> parseStitichItemList(JSONArray jsonArray) throws JSONException{

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


    public static ThreadIntroduction parseThreadIntroduction(JSONObject jsonObject) throws JSONException{
        ThreadIntroduction introduction = new ThreadIntroduction();
        introduction.setItemList(parseItemList(jsonObject));
        return introduction;
    }

    public static EmbroideryIntroduction parseEmbroideryIntroduction(JSONObject jsonObject) throws JSONException{
        EmbroideryIntroduction introduction = new EmbroideryIntroduction();
        introduction.setItemList(parseItemList(jsonObject));
        return introduction;
    }

    public static StitchInfoDetail parseStitchInfoDetail(JSONObject jsonObject) throws JSONException{
        StitchInfoDetail stitchInfoDetail = new StitchInfoDetail();
        stitchInfoDetail.setItemList(parseItemList(jsonObject));
        return stitchInfoDetail;
    }

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
