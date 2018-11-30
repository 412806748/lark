package com.lark.xw.business.main.mvp.ui.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.lark.xw.business.R;
import com.lark.xw.core.fragments.LarkFragment;
import com.tencent.imsdk.TIMValueCallBack;
import com.tencent.imsdk.ext.sns.TIMAddFriendRequest;
import com.tencent.imsdk.ext.sns.TIMFriendResult;
import com.tencent.imsdk.ext.sns.TIMFriendshipManagerExt;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AddFriendFragment extends LarkFragment {
    @BindView(R.id.id_ed_add_friend)
    public EditText ed_add;
    @BindView(R.id.id_btn_add_friend)
    public Button btn_add;
    private final static String TAG = "AddFriendFragment";

    @Override
    public Object setLayout() {
        return R.layout.fragment_add_friends;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        addFriend();
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

    public void addFriend() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String friendId = ed_add.getText().toString();
                if (friendId.equals("")) {
                    return;
                }
                List<TIMAddFriendRequest> reqList = new ArrayList<>();
                //添加好友请求
                TIMAddFriendRequest req = new TIMAddFriendRequest(friendId);
                req.setAddrSource("DemoApp");
                req.setAddWording("add me");
                req.setRemark("Cat");
                reqList.add(req);

                //申请添加好友
                TIMFriendshipManagerExt.getInstance().addFriend(reqList, new TIMValueCallBack<List<TIMFriendResult>>() {
                    @SuppressLint("LogNotTimber")
                    @Override
                    public void onError(int code, String desc) {
                        //错误码 code 和错误描述 desc，可用于定位请求失败原因
                        //错误码 code 列表请参见错误码表
                        Log.e(TAG, "addFriend failed: " + code + " desc");
                    }

                    @Override
                    public void onSuccess(List<TIMFriendResult> result) {
                        Log.e(TAG, "addFriend succ");
                        for (TIMFriendResult res : result) {
                            Log.e(TAG, "identifier: " + res.getIdentifer() + " status: " + res.getStatus());
                        }
                    }
                });

            }
        });
    }
}
