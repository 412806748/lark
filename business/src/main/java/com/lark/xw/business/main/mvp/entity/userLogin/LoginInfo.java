package com.lark.xw.business.main.mvp.entity.userLogin;

public class LoginInfo {
    /**
     * message : 登陆成功
     * success : 1
     * data : {"token":"Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjcsInVzZXJuYW1lIjoieGllZGVqaWFuMTExMTExMTEiLCJpc3MiOiJjcm0iLCJpYXQiOjE1NDM0NjIxNjYsImV4cCI6MTU0MzU0ODU2Nn0.NF0gGOxkTMo39_72KuAcuINFDs28YUEOgWTv-6QOjRM","userid":7,"servertime":"2018-11-29 11:29:26","sig":"eJxFkNFugjAUht*F2y3aU2idS7wQ1GQLjBmJTm4aRgvWOehKmRizdx9rMLs835eT8--n6iThZpQpJTnLDHM1dx4d5NxbLDoltWBZYYTuMRBCMEI3*y10I*uqFxgBAewi9C8lF5WRhbSLkwE2suynaLkOnpZhVLerchzwO9rRRQnbzfu*82PPjw1-*3KfLyox-CVtp8e5nKdJGa-9YIwXnOyaIDkWIX6ACWlTqA6vu3Pun1anQ6630Xk2ux3jH8z2*kvuoT7iFAAGaeSnsI0816MYKB14lud1WxlmLkrYR-z8ApPdVWw_"}
     */

    private String message;
    private int success;
    private DataBean data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * token : Bearer eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjcsInVzZXJuYW1lIjoieGllZGVqaWFuMTExMTExMTEiLCJpc3MiOiJjcm0iLCJpYXQiOjE1NDM0NjIxNjYsImV4cCI6MTU0MzU0ODU2Nn0.NF0gGOxkTMo39_72KuAcuINFDs28YUEOgWTv-6QOjRM
         * userid : 7
         * servertime : 2018-11-29 11:29:26
         * sig : eJxFkNFugjAUht*F2y3aU2idS7wQ1GQLjBmJTm4aRgvWOehKmRizdx9rMLs835eT8--n6iThZpQpJTnLDHM1dx4d5NxbLDoltWBZYYTuMRBCMEI3*y10I*uqFxgBAewi9C8lF5WRhbSLkwE2suynaLkOnpZhVLerchzwO9rRRQnbzfu*82PPjw1-*3KfLyox-CVtp8e5nKdJGa-9YIwXnOyaIDkWIX6ACWlTqA6vu3Pun1anQ6630Xk2ux3jH8z2*kvuoT7iFAAGaeSnsI0816MYKB14lud1WxlmLkrYR-z8ApPdVWw_
         */

        private String token;
        private int userid;
        private String servertime;
        private String sig;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }

        public String getServertime() {
            return servertime;
        }

        public void setServertime(String servertime) {
            this.servertime = servertime;
        }

        public String getSig() {
            return sig;
        }

        public void setSig(String sig) {
            this.sig = sig;
        }
    }
}
