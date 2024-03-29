package com.example.douban.mvp.contract;

import com.example.douban.app.data.entity.detail.DetailBean;
import com.example.douban.mvp.ui.adapter.detail.DetailMultipleItemAdapter;
import com.jess.arms.mvp.IView;
import com.jess.arms.mvp.IModel;

import io.reactivex.Observable;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 12/03/2019 11:26
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public interface DetailContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View extends IView {
        // 设置动画效果
        void setMotion();

        // 设置标题
        void setTitleBar(String title, String subTitle);

        // 设置图片
        void setPicture(String largeUrl, String mediumUrl);

        // 初始化滑动
        void initSlideShapeTheme(String largeUrl);

        // 填充头部数据
        void setHeadData(DetailBean detailBean);

        // 填充内容数据
        void setDetailAdapter(DetailMultipleItemAdapter detailAdapter);
    }

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model extends IModel {
        // 获取详情页数据
        Observable<DetailBean> getDetail(String id);
    }
}
