package com.simalee.guangxiu.view.technique;

import com.simalee.guangxiu.R;
import com.simalee.guangxiu.base.BasePresenter;
import com.simalee.guangxiu.data.entity.ProcessItem;
import com.simalee.guangxiu.data.entity.TextImageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Sima on 2018/5/23.
 */

public class ProcessPresenter extends BasePresenter<ProcessContract.ProcessView> implements ProcessContract.IProcessPresenter {
    private static final String TAG = "ProcessPresenter";

    public ProcessPresenter(){

    }

    @Override
    public void loadProcessItemList() {
        if (isViewAttached()){
            mView.showLoading();
            mView.showProcessItemList(fakePrecessItemList());
            mView.hideLoading();
        }
    }

    private List<ProcessItem> fakePrecessItemList() {
        List<ProcessItem> result = new ArrayList<>();

        //工序一 设计
        ProcessItem processItem1 = new ProcessItem();
        processItem1.setName("一.设计");

        List<TextImageItem> itemList1 = new ArrayList<>();
        TextImageItem textImageItem1_1 = new TextImageItem();
        textImageItem1_1.setSequence(0);
        textImageItem1_1.setType(TextImageItem.TYPE_TEXT);
        textImageItem1_1.setText("广绣的设计是指刺绣的画稿设计，即进行刺绣前的艺术构思创作，绘画出适合于刺绣的各种题材画稿GX/广绣的题材多样,其风格受到社会风气、人文审美、市场需求等因素影响。随着时代的发展，广绣吸收了多种风格，形成了自己特性。" +
                "GX/虽然刺绣以画稿为基础，但是刺绣又不同于绘画，有其独特的艺术语言，因此在刺绣画稿的设计中，需要立足于刺绣工艺，充分考虑到刺绣的工艺特点。画稿设计出来之后，还需要根据刺绣工艺特点进行二次设计，包括根据刺绣工特殊性对画稿进行修改，确定各部分针法，设计绣纹理和色彩等，只有设计人员和刺绣人员紧密合作，才能设计出优秀的刺绣作品。" +
                "GX/下图为画家梁纪和许炽光在一起设计画稿:");
        itemList1.add(textImageItem1_1);

        TextImageItem textImageItem1_2 = new TextImageItem();
        textImageItem1_2.setSequence(1);
        textImageItem1_2.setType(TextImageItem.TYPE_IMAGE);
        textImageItem1_2.setHeight(0);
        textImageItem1_2.setWidth(0);
        textImageItem1_2.setLocalImageId(R.mipmap.process_1);

        itemList1.add(textImageItem1_2);

        processItem1.setItemList(itemList1);

        result.add(processItem1);

        //工序 二.上稿
        ProcessItem processItem2 = new ProcessItem();
        processItem2.setName("二.上稿");
        //添加描述
        List<TextImageItem> itemList2 = new ArrayList<>();
        TextImageItem textImageItem2_1 = new TextImageItem();
        textImageItem2_1.setSequence(0);
        textImageItem2_1.setType(TextImageItem.TYPE_TEXT);
        textImageItem2_1.setText("上稿是广绣行业的术语，就是把画稿描在绣地上面。一般有三种方法完成上稿的工序。" +
                "GX/图为上稿示意图。");
        itemList2.add(textImageItem2_1);

        TextImageItem textImageItem2_2 = new TextImageItem();
        textImageItem2_2.setSequence(1);
        textImageItem2_2.setType(TextImageItem.TYPE_IMAGE);
        textImageItem2_2.setHeight(0);
        textImageItem2_2.setWidth(0);
        textImageItem2_2.setLocalImageId(R.mipmap.process_2);
        itemList2.add(textImageItem2_2);

        TextImageItem textImageItem2_3 = new TextImageItem();
        textImageItem2_3.setSequence(2);
        textImageItem2_3.setType(TextImageItem.TYPE_TEXT);
        textImageItem2_3.setText("一 是勾稿。在设计好的画稿上，复制一张黑白单线的轮廓稿，成为勾稿。将勾稿。将勾稿贴于已绷好的绣地背面，然后以铅笔或墨笔在绣地正面描出画稿的轮廓线。" +
                "GX/二是过稿。操作时，画稿在下，绣地在上，覆盖整齐后将边缘固定，放在映灯箱（一种内置光管的玻璃台）上，用铅笔或墨笔进行临摹。" +
                "GX/三是电脑喷图。可以通过电脑对画稿进行二次设计后，直接喷染在刺绣的材料上，这样既省时省工，又可以将画稿细节更准确，更精细地描绘出来。");
        itemList2.add(textImageItem2_3);

        processItem2.setItemList(itemList2);
        result.add(processItem2);

        //工序三.上绣架
        ProcessItem processItem3 = new ProcessItem();
        processItem3.setName("三.上绣架");

        List<TextImageItem> itemList3 = new ArrayList<>();
        TextImageItem textImageItem3_1 = new TextImageItem();
        textImageItem3_1.setSequence(0);
        textImageItem3_1.setType(TextImageItem.TYPE_TEXT);
        textImageItem3_1.setText("上绣架指的是将绣地安装在绣花架上。下图为示意图。");
        itemList3.add(textImageItem3_1);

        TextImageItem textImageItem3_2 = new TextImageItem();
        textImageItem3_2.setSequence(1);
        textImageItem3_2.setType(TextImageItem.TYPE_IMAGE);
        textImageItem3_2.setHeight(0);
        textImageItem3_2.setWidth(0);
        textImageItem3_2.setLocalImageId(R.mipmap.process_3);
        itemList3.add(textImageItem3_2);

        TextImageItem textImageItem3_3 = new TextImageItem();
        textImageItem3_3.setSequence(2);
        textImageItem3_3.setType(TextImageItem.TYPE_TEXT);
        textImageItem3_3.setText("上绣架的程序为：。" +
                "GX/第一步 缝柳布：将绣地上下两端用柳布（优选无弹性的白布，防止颜色混染）缝合。" +
                "GX/第二步 入柳：利用柳凿挤压柳条，将柳布平整地安嵌在架身的柳线里。" +
                "GX/第三步 卷架：卷动架身，露出需要进行刺绣的绣地。" +
                "GX/第四步 插横头 分别将两根横头插入架身左右两侧，并用绷钉固紧架身与横头位置，使绣地纵向呈递绷紧状态。" +
                "GX/第五步 缝边竹：选择与展开绣地宽度相近的边竹，用棉线绑紧边竹的一端，缝合边竹与绣地。缝合时注意起落针间的距离相等，并保持在同一个水平线上。" +
                "GX/第六步 绑边带：边带的一端固定在横头上，另一端穿过边竹与绣地之间的间隙，顺着同一方向穿过横头与边竹，使得绣地横向呈现绷紧状态，最后将余下的边带缠绕横头，使其不松落即可。");
        itemList3.add(textImageItem3_3);

        processItem3.setItemList(itemList3);
        result.add(processItem3);

        //工序四.刺绣
        ProcessItem processItem4 = new ProcessItem();
        processItem4.setName("四.刺绣");

        List<TextImageItem> itemList4 = new ArrayList<>();
        TextImageItem textImageItem4_1 = new TextImageItem();
        textImageItem4_1.setSequence(0);
        textImageItem4_1.setType(TextImageItem.TYPE_TEXT);
        textImageItem4_1.setText("刺绣是一种需要长时间坐着的，全神贯注的纯手工劳动，因此刺绣者在刺绣时要注意坐姿，同时要注意刺绣手势的使用，以及剪刀和针线的放置，保持绣地整洁，按照特定的刺绣顺序进行绣制，单纯使用文字无法呈现这一工序流程，您可以通过教学模块的视频教学了解更多刺绣过程需要注意的内容。");
        itemList4.add(textImageItem4_1);

        processItem4.setItemList(itemList4);
        result.add(processItem4);

        //工序五.下绣架
        ProcessItem processItem5 = new ProcessItem();
        processItem5.setName("五.下绣架");

        List<TextImageItem> itemList5 = new ArrayList<>();
        TextImageItem textImageItem5_1 = new TextImageItem();
        textImageItem5_1.setSequence(0);
        textImageItem5_1.setType(TextImageItem.TYPE_TEXT);
        textImageItem5_1.setText("刺绣完成后，将绣好的绣地从花架上取下来，成为下绣架（或落架）。下绣架前需要认真检查绣地是否存在漏绣或不协调的地方，及时做好补漏或修改工作。下绣架要按照上绣架的逆顺序操作：先将绑在横头与边竹的边带拉松，卸掉边竹丝，取下绷钉，卸下横头，取出绣地，拆去边布即可。绣地下架之后，需要妥善存放，避免产生折痕，应及早安装装裱。" +
                "GX/下图为下绣架示意图：");
        itemList5.add(textImageItem5_1);

        TextImageItem textImageItem5_2 = new TextImageItem();
        textImageItem5_2.setSequence(1);
        textImageItem5_2.setType(TextImageItem.TYPE_IMAGE);
        textImageItem5_2.setHeight(0);
        textImageItem5_2.setWidth(0);
        textImageItem5_2.setLocalImageId(R.mipmap.process_5);
        itemList5.add(textImageItem5_2);

        processItem5.setItemList(itemList5);
        result.add(processItem5);


        //工序六.整理
        ProcessItem processItem6 = new ProcessItem();
        processItem6.setName("六.整理");

        List<TextImageItem> itemList6 = new ArrayList<>();
        TextImageItem textImageItem6_1 = new TextImageItem();
        textImageItem6_1.setSequence(0);
        textImageItem6_1.setType(TextImageItem.TYPE_TEXT);
        textImageItem6_1.setText("在绣地进入装裱工序之前，需要对绣地再检查一次，如发现有污损、线头遗留、漏绣等现象，要及时处理。如果表面有折痕，可以用熨斗熨平直，使用熨斗时注意不能用蒸汽来熨烫，根据绣地的厚薄，熨斗的温度适宜在30到50度之间。" +
                "GX/下图为整理的示意图：");
        itemList6.add(textImageItem6_1);

        TextImageItem textImageItem6_2 = new TextImageItem();
        textImageItem6_2.setSequence(1);
        textImageItem6_2.setType(TextImageItem.TYPE_IMAGE);
        textImageItem6_2.setHeight(0);
        textImageItem6_2.setWidth(0);
        textImageItem6_2.setLocalImageId(R.mipmap.process_6);
        itemList6.add(textImageItem6_2);

        processItem6.setItemList(itemList6);
        result.add(processItem6);

        //工序七.装裱
        ProcessItem processItem7 = new ProcessItem();
        processItem7.setName("七.装裱");

        List<TextImageItem> itemList7 = new ArrayList<>();
        TextImageItem textImageItem7_1 = new TextImageItem();
        textImageItem7_1.setSequence(0);
        textImageItem7_1.setType(TextImageItem.TYPE_TEXT);
        textImageItem7_1.setText("此工序主要适用于广绣作品中的画绣。装裱使用的材料有卡纸、背板、玻璃、画框等。" +
                "GX/规格较大的绣画采用有机玻璃,其优点是不易破碎。画框则采用整体平滑、色度均匀的高档红木。" +
                "GX/首先,以尺子丈量绣画画心的规格大小、按照绣画画心的实际尺寸定做卡纸。" +
                "GX/然后,选择被画使用的背板、玻璃、画框等。背板以使用平整不变形的实木板为宜，作防虫防潮处理,之后在背板拟粘贴绣画画心的位置粉上一张白纸,这样使背板的颜色不会反衬到绣画表面,再用环保的胶水涂在白纸上,涂胶水的量要适度,厚薄要均匀。" +
                "GX/绣画粘上背板后,要用手在绣画画心的四周用力拉齐,使整幅绣画画面平整无波纹。拉完后放在适当的地方晾一天,让绣画自然收缩。第二天看看绣画的粘贴情况,不平整的地方继续拉紧拉平。" +
                "GX/绣画画心装进画框时要作最后的清理,检查是否有遗留线头、杂物后再作防水、防潮、防空气进入的处理。用绒布封底,在画框四角安装角码,两边装暗扣,上方装明扣。这样,一幅绣画就装裱完成了。" +
                "GX/下图为装裱示意图：");
        itemList7.add(textImageItem7_1);

        TextImageItem textImageItem7_2 = new TextImageItem();
        textImageItem7_2.setSequence(1);
        textImageItem7_2.setType(TextImageItem.TYPE_IMAGE);
        textImageItem7_2.setHeight(0);
        textImageItem7_2.setWidth(0);
        textImageItem7_2.setLocalImageId(R.mipmap.process_7);
        itemList7.add(textImageItem7_2);

        processItem7.setItemList(itemList7);
        result.add(processItem7);

        return result;
    }

    @Override
    public void loadPreProcess() {
        if (isViewAttached()){
            mView.showPreProcess();
        }
    }

    @Override
    public void loadNextProcess() {
        if (isViewAttached()){
            mView.showNextProcess();
        }
    }
}
