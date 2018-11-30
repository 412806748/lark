package com.lark.xw.business.main.mvp.ui.fragment.work.msg;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lark.xw.business.R;
import com.lark.xw.business.main.mvp.entity.msg.MsgConversationDatas;
import com.lark.xw.business.main.mvp.entity.msg.MsgSection;
import com.lark.xw.core.fragments.LarkFragment;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MsgFragment extends LarkFragment {
    @BindView(R.id.id_refreshLayout)
    RefreshLayout refreshLayout;
    @BindView(R.id.id_work_msg_rlv)
    RecyclerView rlv;


    @Override
    public Object setLayout() {
        return R.layout.fragment_work_msg;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        List<MsgSection> data = new ArrayList<>();
        MsgConversationDatas msgConversationDatas = new MsgConversationDatas();
        msgConversationDatas.setMsg("dadasdad");
        msgConversationDatas.setName("大头");
        msgConversationDatas.setTime("19:12:00");
        msgConversationDatas.setTitleMsg("adasdasrrrr");
        msgConversationDatas.setTitle("[afafe大声道]");
        msgConversationDatas.setRemindCount("10");

        data.add(new MsgSection(true, "计划生育A"));
        data.add(new MsgSection(msgConversationDatas));
        data.add(new MsgSection(msgConversationDatas));
        data.add(new MsgSection(msgConversationDatas));
        data.add(new MsgSection(msgConversationDatas));
        data.add(new MsgSection(msgConversationDatas));
        data.add(new MsgSection(true, "土地财产纠纷"));
        data.add(new MsgSection(msgConversationDatas));
        data.add(new MsgSection(msgConversationDatas));
        data.add(new MsgSection(msgConversationDatas));
        data.add(new MsgSection(msgConversationDatas));
        data.add(new MsgSection(msgConversationDatas));
        MsgAdapter msgAdapter = new MsgAdapter(R.layout.item_work_msg_conversation, R.layout.item_work_msg_head, data);
        rlv.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rlv.setAdapter(msgAdapter);

        msgAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                MsgSection msgSection = msgAdapter.getData().get(position);
                if (!msgSection.isHeader) {
                    Toast.makeText(getContext(), "position：" + position, Toast.LENGTH_SHORT).show();
                    getParentDelegate().getParentDelegate().getSupportDelegate().start(new MsgChatFragment());
                }
                Toast.makeText(getContext(), "position：" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int setTitleBar() {
        return 0;
    }

    @Override
    public int setStatusBarView() {
        return 0;
    }

    @Override
    public void post(Runnable runnable) {

    }


}
