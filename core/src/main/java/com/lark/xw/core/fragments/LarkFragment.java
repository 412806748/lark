package com.lark.xw.core.fragments;

public abstract class LarkFragment extends PermissionFragment {
    @SuppressWarnings("unchecked")
    public <T extends LarkFragment> T getParentDelegate() {
        return (T) getParentFragment();
    }

}
