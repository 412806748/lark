package com.lark.xw.business.main.mvp.entity.msg;


import com.chad.library.adapter.base.entity.SectionEntity;

public class MsgSection extends SectionEntity<MsgConversationDatas> {

    public MsgSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public MsgSection(MsgConversationDatas t) {
        super(t);
    }


}
