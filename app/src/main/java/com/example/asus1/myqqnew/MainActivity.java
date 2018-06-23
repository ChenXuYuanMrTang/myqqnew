package com.example.asus1.myqqnew;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity {

    static int allN = 11;
    //聊天头像11个
    private int[] imagerIds={
            R.drawable.ruanxei, R.drawable.xinsoucun,   R.drawable.qin507,
            R.drawable.dashuju, R.drawable.yiying2ban,  R.drawable.keketaolun,
            R.drawable.renwen,  R.drawable.jidian,      R.drawable.chehua,
            R.drawable.jinengdashai,                    R.drawable.xuejava
    };
    //聊天（群聊）名字
    private String[] qunnames = {
            "软件协会",          "软协2017新手村",    "507寝",
            "“大数据之美”课程","移应2017-2班通知群","咳咳讨论组",
            "人文项目考核(6/11)","奇点软协编码节报名群","活动策划组(7)",
            "移动应用技能大赛", "软测17-阳杰、17...(9)"
    };

    //聊天最新一条消息
    private String[] endxiaoxis = {
            "李俊成:16级的同学赶紧写",       "17-移应2班刘森林:5306有人在吗",             "QQ小冰:日常追了不少剧吧~考验你刷剧...",
            "田金莲:知道的可不可以说一下",   "陶梦琦    13789191305:没有交表的...",      "移应17-1-王鑫:[图片]",
            "蒋鑫:[文件]关于大学生阅读情况调查.pptx",  "计网-1-1:[图片]",                 "开了空调，没注意到窗户",
            "罗武斌:好的",                   "17-计软-张才波:今天不讲课吗"
    };

    //时间
    private String [] timeliao = {
            "下午4:23",   "下午1:55",   "上午11:55",
            "上午10:50",  "昨天",       "星期三",
            "2018-06-04","2018-05-25","2018-05-16",
            "2018-05-01","2018-04-12"
    };


    private void initItemPop(View v, final int i) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.jiatancaidan, null, false);
        final PopupWindow popWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popWindow.setTouchable(true);
        popWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));

        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        popWindow.showAsDropDown(v, 0, 0);
    }private void initItemPop(View v, final char i) {
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.qiehuanzanghao, null, false);
        final PopupWindow popWindow = new PopupWindow(view,
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popWindow.setTouchable(true);
        popWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));

        //设置popupWindow显示的位置，参数依次是参照View，x轴的偏移量，y轴的偏移量
        popWindow.showAsDropDown(v, 0, 0);
    }

    Button jia,touxiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jia = findViewById(R.id.jia);
        touxiang = findViewById(R.id.mytouxiang);

        jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initItemPop(v,1);
            }
        });

//        touxiang.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                initItemPop(v,'0');
//            }
//        });
        touxiang.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
//                Toast.makeText(MainActivity.this, "长按事件监听", 1).show();
//                return false;
                initItemPop(v,'0');
                return false;
            }
        });


        List<Map<String,Object>> listbiao = new ArrayList<Map<String,Object>>();
        for(int i = 0 ; i < allN ; i++){
            Map<String ,Object>listb = new HashMap<String,Object>();
            listb.put("touxiangkuang",imagerIds[i]);
            listb.put("mingchen",qunnames[i]);
            listb.put("endxiaoxi",endxiaoxis[i]);
            listb.put("time",timeliao[i]);
            listbiao.add(listb);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listbiao,
                R.layout.danbiao,
                new String[] {"touxiangkuang","mingchen","endxiaoxi","time"},
                new int[] {R.id.touxiangkuang,R.id.mingchen,R.id.endxiaoxi,R.id.time});
        ListView list = (ListView)findViewById(R.id.liebiao);
        list.setAdapter(simpleAdapter);



//        List<Map<xiaoxi>> listxiaoxi = new ArrayList<map<xiaoxi>>();
//        for(int i = 0 ; i < allN ; i++){
////            Map<String,Object>listItem = new HashMap<>();
////            listItem.put("touxiangkuang",imagerIds[i]);
////            listItem.put("mingchen",qunnames[i]);
////            listItem;
//              xiaoxi xiaodui = new xiaoxi(qunnames[i],endxiaoxis[i],timeliao[i],imagerIds[i]);
//              listxiaoxi.add(xiaodui);
//        }
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listxiaoxi,
//                R.layout.danbiao,
//                new String[] {"touxiangkuang","mingchen","endxiaoxi","time"},
//                new int[] {R.id.touxiangkuang,R.id.mingchen,R.id.endxiaoxi,R.id.time});






    }
    public void test_click(View v){
//        Toast.makeText(MainActivity.this,"布局可被点击！",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,XiaoxiActivity.class);
        startActivity(intent);
    }
}

//class xiaoxi{
//    String nametit ;
//    String endxiaoxi ;
//    String timeriqi;
//    int img;
//    public xiaoxi(){
//        this.nametit = null;
//        this.endxiaoxi = null;
////        Date timeday = new Date();									//获取时间对象
////        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd");	//按指定格式获取时间
////        this.timeriqi =  ft.format(timeday);
//        this.timeriqi = null;
//        this.img =-1;
//    }
//
//    public xiaoxi(String name,String xiaoxi ,String time,int imge){
//        this.nametit = name;
//        this.endxiaoxi = xiaoxi;
//        this.timeriqi = time;
//        this.img = imge;
//    }
//
//    @Override
//    public String toString() {
//        return (nametit+","+endxiaoxi+","+timeriqi);
//    }
//}











