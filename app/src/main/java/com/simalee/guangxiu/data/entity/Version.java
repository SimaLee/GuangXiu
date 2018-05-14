package com.simalee.guangxiu.data.entity;

/**
 * Created by Lee Sima on 2018/5/6.
 */

public class Version {

    /**
     *  版本号是展示系统的资料数据更新控制的基础，每一个部分的数据拥有一个
     *  独立的版本号，当应用启动时，会访问服务器得到当前最新的资料数据的版
     *  版本数据，当应用需要访问数据时，首先会判断当前的数据的版本号是否与
     *  服务器上的版本号数据一致：若落后于版本号，则会发起访问请求，在请求
     *  完成后会将新的数据保存到本地吗，同时更新本地数据版本。否则使用本地
     *  数据完成展示。
     */

    int ver_origin;//起源版本号
    int ver_meaning;//寓意版本号
    int ver_phase;//发展过程版本号
    int ver_development;//未来发展版本号
    int ver_art;//艺术特点版本号
    int ver_embroidery;//绣种版本号
    int ver_stitch;//针法版本号
    int ver_thread;//线版本号
    int ver_pergola;//花架版本号
    int ver_desc;//(logo)广绣介绍版本号
    int ver_master;//名家版本号
    int ver_masterdesc;//名家简介版本号
    int ver_masterwork;//名家作品版本号
    int ver_video;//视频教学版本号
    int ver_answer;//答题闯关版本号
    int ver_needle;//针的版本号(与针法不同)

    public Version() {
    }

    @Override
    public String toString() {
        return "Version{" +
                "ver_origin=" + ver_origin +
                ", ver_meaning=" + ver_meaning +
                ", ver_phase=" + ver_phase +
                ", ver_development=" + ver_development +
                ", ver_art=" + ver_art +
                ", ver_embroidery=" + ver_embroidery +
                ", ver_stitch=" + ver_stitch +
                ", ver_thread=" + ver_thread +
                ", ver_pergola=" + ver_pergola +
                ", ver_desc=" + ver_desc +
                ", ver_master=" + ver_master +
                ", ver_masterdesc=" + ver_masterdesc +
                ", ver_masterwork=" + ver_masterwork +
                ", ver_video=" + ver_video +
                ", ver_answer=" + ver_answer +
                ", ver_needle=" + ver_needle +
                '}';
    }

    public int getVer_origin() {
        return ver_origin;
    }

    public void setVer_origin(int ver_origin) {
        this.ver_origin = ver_origin;
    }

    public int getVer_meaning() {
        return ver_meaning;
    }

    public void setVer_meaning(int ver_meaning) {
        this.ver_meaning = ver_meaning;
    }

    public int getVer_phase() {
        return ver_phase;
    }

    public void setVer_phase(int ver_phase) {
        this.ver_phase = ver_phase;
    }

    public int getVer_development() {
        return ver_development;
    }

    public void setVer_development(int ver_development) {
        this.ver_development = ver_development;
    }

    public int getVer_art() {
        return ver_art;
    }

    public void setVer_art(int ver_art) {
        this.ver_art = ver_art;
    }

    public int getVer_embroidery() {
        return ver_embroidery;
    }

    public void setVer_embroidery(int ver_embroidery) {
        this.ver_embroidery = ver_embroidery;
    }

    public int getVer_stitch() {
        return ver_stitch;
    }

    public void setVer_stitch(int ver_stitch) {
        this.ver_stitch = ver_stitch;
    }

    public int getVer_thread() {
        return ver_thread;
    }

    public void setVer_thread(int ver_thread) {
        this.ver_thread = ver_thread;
    }

    public int getVer_pergola() {
        return ver_pergola;
    }

    public void setVer_pergola(int ver_pergola) {
        this.ver_pergola = ver_pergola;
    }

    public int getVer_desc() {
        return ver_desc;
    }

    public void setVer_desc(int ver_desc) {
        this.ver_desc = ver_desc;
    }

    public int getVer_master() {
        return ver_master;
    }

    public void setVer_master(int ver_master) {
        this.ver_master = ver_master;
    }

    public int getVer_masterdesc() {
        return ver_masterdesc;
    }

    public void setVer_masterdesc(int ver_masterdesc) {
        this.ver_masterdesc = ver_masterdesc;
    }

    public int getVer_masterwork() {
        return ver_masterwork;
    }

    public void setVer_masterwork(int ver_masterwork) {
        this.ver_masterwork = ver_masterwork;
    }

    public int getVer_video() {
        return ver_video;
    }

    public void setVer_video(int ver_video) {
        this.ver_video = ver_video;
    }

    public int getVer_answer() {
        return ver_answer;
    }

    public void setVer_answer(int ver_answer) {
        this.ver_answer = ver_answer;
    }

    public int getVer_needle() {
        return ver_needle;
    }

    public void setVer_needle(int ver_needle) {
        this.ver_needle = ver_needle;
    }
}
