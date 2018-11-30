package com.lark.xw.business.main.mvp.entity.msg;

public class MsgConversationDatas {
    private int headImgType;
    private String title;
    private String titleMsg;
    private String name;
    private String msg;
    private String time;
    private String remindCount;
    private boolean isHead;

    public boolean isHead() {
        return isHead;
    }

    public void setHead(boolean head) {
        isHead = head;
    }

    public int getHeadImgType() {
        return headImgType;
    }

    public void setHeadImgType(int headImgType) {
        this.headImgType = headImgType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleMsg() {
        return titleMsg;
    }

    public void setTitleMsg(String titleMsg) {
        this.titleMsg = titleMsg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRemindCount() {
        return remindCount;
    }

    public void setRemindCount(String remindCount) {
        this.remindCount = remindCount;
    }


}
