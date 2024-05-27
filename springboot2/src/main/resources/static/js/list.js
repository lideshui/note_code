new Vue({
    el: "#userList",
    data: {
        userList: []    //用户列表
    },
    methods: {
        findAll: function () {
            var url = "http://localhost:10001/user/findAll";
            var _this = this;
            //发送异步请求获取所有用户数据
            axios.get(url).then(function (response) {
                //console.log(response);
                if(!response.data.status){
                    alert(response.msg);
                    return ;
                }
                _this.userList = response.data.data;
            });
        }
    },
    created(){
        this.findAll();
    }
});