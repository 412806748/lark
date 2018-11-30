package com.lark.xw.business.main.mvp.ui.fragment.work.msg;

import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lark.xw.business.R;
import com.lark.xw.business.main.mvp.entity.msg.MsgSection;

import java.util.List;


public class MsgAdapter extends BaseSectionQuickAdapter<MsgSection, BaseViewHolder> {


    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public MsgAdapter(int layoutResId, int sectionHeadResId, List<MsgSection> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    @Override
    protected void convertHead(BaseViewHolder helper, MsgSection item) {
        TextView textView = helper.getView(R.id.id_tv_head_title);
        textView.setText(item.header);
    }

    @Override
    protected void convert(BaseViewHolder helper, MsgSection item) {
        ImageView imageView = helper.getView(R.id.id_img_head);
        TextView tv_title1 = helper.getView(R.id.id_tv_title1);
        TextView tv_title2 = helper.getView(R.id.id_tv_title2);
        TextView tv_msgs_name = helper.getView(R.id.id_tv_msgs_name);
        TextView tv_msgs = helper.getView(R.id.id_tv_msgs);
        TextView tv_time = helper.getView(R.id.id_tv_time);
        TextView img_count = helper.getView(R.id.id_img_count);
        tv_title1.setText(item.t.getTitle());
        tv_title2.setText(item.t.getTitleMsg());
        tv_msgs_name.setText(item.t.getName());
        tv_msgs.setText(item.t.getMsg());
        tv_time.setText(item.t.getTime());
        img_count.setText(item.t.getRemindCount());


    }


}
