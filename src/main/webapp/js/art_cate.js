new Vue({
    el: "#app",

    mounted() {
        //当页面加载完成后，发送异步请求，获取数据

        this.selectAll();

        /* var _this = this;

          axios({
              method:"get",
              url:"http://localhost:8080/brand-case/selectAllServlet"
          }).then(function (resp) {
              _this.tableData = resp.data;
          })*/
    },

    methods: {
        // 查询分页数据
        selectAll() {
            /* var _this = this;

                axios({
                    method:"get",
                    url:"http://localhost:8080/brand-case/brand/selectAll"
                }).then(function (resp) {
                    _this.tableData = resp.data;
                })*/

            /*
                var _this = this;

                axios({
                    method:"post",
                    url:"http://localhost:8080/brand-case/brand/selectByPageAndCondition?currentPage="+this.currentPage+"&pageSize="+this.pageSize,
                    data:this.brand
                }).then(function (resp) {

                    //设置表格数据
                    _this.tableData = resp.data.rows; // {rows:[],totalCount:100}
                    //设置总记录数
                    _this.totalCount = resp.data.totalCount;
                })*/

            axios({
                method: "post",
                url:
                    "http://localhost:8080/brand-case/brand/selectByPageAndCondition?currentPage=" +
                    this.currentPage +
                    "&pageSize=" +
                    this.pageSize,
                data: this.brand,
            }).then((resp) => {
                //设置表格数据
                this.tableData = resp.data.rows; // {rows:[],totalCount:100}
                //设置总记录数
                this.totalCount = resp.data.totalCount;
            });
        },

        tableRowClassName({row, rowIndex}) {
            if (rowIndex === 1) {
                return "warning-row";
            } else if (rowIndex === 3) {
                return "success-row";
            }
            return "";
        },
        // 复选框选中后执行的方法
        handleSelectionChange(val) {
            this.multipleSelection = val;

            // console.log(this.multipleSelection)
        },
        // 查询方法
        onSubmit() {
            //console.log(this.brand);
            this.selectAll();
        },
        // 添加数据
        addBrand() {
            //console.log(this.brand);
            var _this = this;

            // 发送ajax请求，添加数据
            axios({
                method: "post",
                url: "http://localhost:8080/brand-case/brand/add",
                data: _this.brand,
            }).then(function (resp) {
                if (resp.data == "success") {
                    //添加成功

                    //关闭窗口
                    _this.dialogVisible = false;

                    // 重新查询数据
                    _this.selectAll();
                    // 弹出消息提示
                    _this.$message({
                        message: "恭喜你，添加成功",
                        type: "success",
                    });
                }
            });
        },

        //分页
        handleSizeChange(val) {
            //console.log(`每页 ${val} 条`);
            // 重新设置每页显示的条数
            this.pageSize = val;
            this.selectAll();
        },
        handleCurrentChange(val) {
            //console.log(`当前页: ${val}`);
            // 重新设置当前页码
            this.currentPage = val;
            this.selectAll();
        },

        // 批量删除
        deleteByIds() {
            //console.log(this.multipleSelection);
            /*
                [
                    {
                        "brandName": "华为",
                        "companyName": "华为技术有限公司",
                        "description": "万物互联",
                        "id": 1,
                        "ordered": 100,
                        "status": 1,
                        "statusStr": "启用"
                    },
                    {
                        "brandName": "小米",
                        "companyName": "小米科技有限公司",
                        "description": "are you ok",
                        "id": 2,
                        "ordered": 50,
                        "status": 1,
                        "statusStr": "启用"
                    },
                    {
                        "brandName": "格力",
                        "companyName": "格力电器股份有限公司",
                        "description": "让世界爱上中国造",
                        "id": 3,
                        "ordered": 30,
                        "status": 1,
                        "statusStr": "启用"
                    }
                ]
                 */

            // 弹出确认提示框

            this.$confirm("此操作将删除该数据, 是否继续?", "提示", {
                confirmButtonText: "确定",
                cancelButtonText: "取消",
                type: "warning",
            })
                .then(() => {
                    //用户点击确认按钮

                    //1. 创建id数组 [1,2,3], 从 this.multipleSelection 获取即可
                    for (let i = 0; i < this.multipleSelection.length; i++) {
                        let selectionElement = this.multipleSelection[i];
                        this.selectedIds[i] = selectionElement.id;
                    }

                    //2. 发送AJAX请求
                    var _this = this;

                    // 发送ajax请求，添加数据
                    axios({
                        method: "post",
                        url: "http://localhost:8080/brand-case/brand/deleteByIds",
                        // data: _this.selectedIds,
                    }).then(function (resp) {
                        if (resp.data == "success") {
                            //删除成功

                            // 重新查询数据
                            _this.selectAll();
                            // 弹出消息提示
                            _this.$message({
                                message: "恭喜你，删除成功",
                                type: "success",
                            });
                        }
                    });
                })
                .catch(() => {
                    //用户点击取消按钮

                    this.$message({
                        type: "info",
                        message: "已取消删除",
                    });
                });
        },
    },
    data() {
        return {
            // 每页显示的条数
            pageSize: 5,
            // 总记录数
            totalCount: 100,
            // 当前页码
            currentPage: 1,
            // 添加数据对话框是否展示的标记
            dialogVisible: false,

            // 品牌模型数据
            brand: {
                status: "",
                brandName: "",
                companyName: "",
                id: "",
                ordered: "",
                description: "",
            },
            // 被选中的id数组
            selectedIds: [],
            // 复选框选中数据集合
            multipleSelection: [],
            // 表格数据
            tableData: [
                {
                    brandName: "华为",
                    companyName: "华为科技有限公司",
                    ordered: "100",
                    status: "1",
                },
                {
                    brandName: "华为",
                    companyName: "华为科技有限公司",
                    ordered: "100",
                    status: "1",
                },
                {
                    brandName: "华为",
                    companyName: "华为科技有限公司",
                    ordered: "100",
                    status: "1",
                },
                {
                    brandName: "华为",
                    companyName: "华为科技有限公司",
                    ordered: "100",
                    status: "1",
                },
            ],
        };
    },
});
