var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        searchHistory: [],
        tableHeight: 0,
        rules: {
            username: [
                {required: true, message: '名称不能为空', trigger: 'blur'}
            ]
        },
        q: {
            username: ''
        },
        userLevels: [],
        listQuery: {
            page: 1,
            limit: 20,
            title: undefined,
            status: undefined
        },
        total: 0,

    },

    created() {
        this.tableHeight = document.documentElement.clientHeight - (50 + 20 + 50 + 70);
        $(window).resize(() => {
            this.tableHeight = document.documentElement.clientHeight - (50 + 20 + 50 + 70);
        });
        this.getList();
    },
    beforeRouteEnter (to, from, next) {
        next(vm => {
            // 通过 `vm` 访问组件实例
            if (keepAliveList.indexOf(from.path) !== -1) {
                vm.listQuery.page = 1;
                vm.listQuery.limit = 20;
                vm.listQuery.title = undefined;
                vm.listQuery.status = undefined;
                vm.getList();
            }
        });
    },
    methods: {
        handleSizeChange: function(val) {
            this.listQuery.limit = val;
            this.getList();
        },
        handleCurrentChange(val) {
            this.listQuery.page = val;
            this.getList();
        },
        handleSelection(selection, row) {

            console.log(selection);
            var  temp=[];
            for (var i=0; i<selection.length;i++){
                temp.push(selection[i].id);

            }
            this.selectOrders=temp;


        },
        handleSelectionAll(selection) {
            this.selectOrders = selection;
            console.log(selection);
        },
        getList: function(){
            var params = {};
            params.page=this.listQuery.page;
            params.limit=this.listQuery.limit;
            params.sidx="id";
            params.order="desc";
            $.get("../searchhistory/list", params,  function(response){
                console.log(response.page.list);
                vm.searchHistory=response.page.list;
                vm.total=response.page.currPage;
            })

        },

        query: function () {
            vm.reload();
        },

        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.searchHistory = {};


            this.getUserLevels();
        },
        update: function (event) {
            var id = this.selectOrders;
            if (id == null) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
            this.getUserLevels();
        },
        saveOrUpdate: function (event) {
            var url = vm.searchHistory.id == null ? "../searchhistory/save" : "../searchhistory/update";
            $.ajax({
                type: "POST",
                url: url,
                contentType: "application/json",
                data: JSON.stringify(vm.user),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            this.getList();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var ids = getSelectedRows();
            if (ids == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: "../searchhistory/delete",
                    contentType: "application/json",
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                this.getList();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        exportUser: function () {
            exportFile('#rrapp', '../searchhistory/export', {'username': vm.q.username});
        },


        getInfo: function (id) {
            $.get("../searchhistory/info/" + id, function (r) {
                vm.searchHistory = r.searchHistory;
            });
        },


        reload: function (event) {
            vm.showList = true;
            vm.handleReset('formValidate');
        },
        handleSubmit: function (name) {
            this.$refs[name].validate((valid) => {
                if (valid) {
                    alert('submit!');

                } else {
                    console.log('error submit!!');
                    return false;
                }
            });
        },
        handleReset: function (name) {
            this.$refs[name].resetFields();
        }
    }
});