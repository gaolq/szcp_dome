<template>
  <div>
    <div style="min-width:1000px">
    <Card shadow>



      <!--机构表格-->
      <tree-table expand-key="organName" :expand-type="false"  :loading="loadingTable"  :selectable="false" :columns="columns" :data="data"
                  stripe border show-index>
        <template slot="likes" slot-scope="scope">
          <Button v-if="buttonVerifAuthention('sys:organ:updateOrgan')" type="warning" size="small" @click="editOrganChildButton(scope)" style="margin-right: 5px;">编辑</Button>
          <Button v-if="showDeleteButton(scope)" type="error" size="small" @click="deleteOrganChildButton(scope)" style="margin-right: 5px;">删除</Button>
          <Button  v-if="buttonVerifAuthention('sys:organ:addOrgan')" type="primary" size="small" @click="addOrganChildButton(scope)" style="margin-right: 5px;">添加子机构</Button>

        </template>
      </tree-table>

      <!--添加子机构弹出框-->
      <Modal
        v-model="modalOrganAdd"
        title="添加子机构"
        :mask-closable="false">
        <Form ref="formValidateOrganAdd" :model="formValidateOrganAdd" :rules="ruleValidateOrganAdd" :label-width="80">
          <FormItem label="子机构名" prop="organName">
            <Input v-model.trim="formValidateOrganAdd.organName" placeholder="请输入子机构名"></Input>
          </FormItem>
          <FormItem label="子机构备注" prop="organRemake">
            <Input type="textarea" :autosize="{minRows: 2,maxRows: 5}" v-model="formValidateOrganAdd.organRemake" placeholder="请输入子机构备注"></Input>
          </FormItem>
          <FormItem label="排序" prop="sorting">
            <Input v-model="formValidateOrganAdd.sorting" placeholder="排序(整数)"></Input>
          </FormItem>
        </Form>
        <div slot="footer">
          <Button type="text" size="large" @click="modalOrganAdd=false">取消</Button>
          <Button type="primary" size="large" @click="addOrganChildClick" :loading="loadingModel">确定</Button>
        </div>
      </Modal>
      <!--编辑菜单弹出框-->
      <Modal
        v-model="modalOrganEdit"
        title="编辑菜单"
        :mask-closable="false"
       >
        <Form ref="formValidateOrganEdit" :model="formValidateOrganEdit" :rules="ruleValidateOrganEdit" :label-width="80">
          <FormItem label="子机构名" prop="organName">
            <Input v-model.trim="formValidateOrganEdit.organName" placeholder="请输入子机构名"></Input>
          </FormItem>
          <FormItem label="子机构备注" prop="organRemake">
            <Input type="textarea" :autosize="{minRows: 2,maxRows: 5}" v-model="formValidateOrganEdit.organRemake" placeholder="请输入子机构备注"></Input>
          </FormItem>
          <FormItem label="排序" prop="sorting">
            <Input v-model="formValidateOrganEdit.sorting" placeholder="排序(整数)"></Input>
          </FormItem>
        </Form>

        <div slot="footer">
          <Button type="text" size="large" @click="modalOrganEdit=false">取消</Button>
          <Button type="primary" size="large" @click="editOrganChildClick" :loading="loadingModel">确定</Button>
        </div>
      </Modal>

    </Card>
    </div>
  </div>
</template>

<script>
  import { mapActions } from 'vuex'
  import {permsVerifAuthention } from '@/libs/util'
  export default {
    name: 'tree_table_page',
    data() {

      const isInteger = (rule, value, callback) => {
        //console.log(value);
        if(value==null||value==''){
          callback();
        }else{
          if (!Number(value)) {
            callback(new Error('请输入整数'));
          } else {
            const re = /^[0-9]*[1-9][0-9]*$/;
            const rsCheck = re.test(value);
            if (!rsCheck) {
              callback(new Error('请输入正整数'));
            } else {
              callback();
            }
          }
        }

      }
      return {
        //表单
        formValidateOrganAdd: {
          id:'',
          organName: '',
          organRemake: '',
          sorting: '',
          parentId:0
        },
        //表单验证
        ruleValidateOrganAdd: {
          organName: [
            {required: true, message: '请输入机构名', trigger: 'blur'},
            {type: 'string', max: 10, message: '菜单名最长为10个字', trigger: 'blur'},
          ],
          sorting: [
            {required: true, message: '请输入排序', trigger: 'blur'},
            {validator: isInteger,  trigger: 'blur'}
          ],
        },

        //表单
        formValidateOrganEdit: {
          id:'',
          organName: '',
          organRemake: '',
          sorting: '',
          parentId:0
        },
        //表单验证
        ruleValidateOrganEdit: {
          organName: [
            {required: true, message: '请输入机构名', trigger: 'blur'},
            {type: 'string', max: 10, message: '菜单名最长为10个字', trigger: 'blur'},
          ],
          sorting: [
            {required: true, message: '请输入排序', trigger: 'blur'},
            {validator: isInteger,  trigger: 'blur'}
          ],
        },

        //对话框
        modalOrganAdd: false,
        modalOrganEdit: false,
        loadingTable: true,//表格加载转圈
        loadingModel:false,//表单提交按钮转圈
        //表格列
        columns: [
          {
            title: '机构名',
            key: 'organName',
            width: '200'
          },
          {
            title: '备注',
            key: 'organRemake',
            minWidth: '150px'
          },
          {
            title: '排序',
            key: 'sorting'
          },
          {
            title: '操作',
            key: 'likes',
            minWidth: '200px',
            type: 'template',
            template: 'likes'
          }
        ],
        //表格数据
        data: []
      }
    },
    created(){
      //初始化菜单列表
      this.queryList();
    },
    methods: {
      ...mapActions([
        'addOrganChild',
        'getOrganList',
        'deleteOrganById',
        'editOrganById'
      ]),
      buttonVerifAuthention(perms){
        return permsVerifAuthention(perms,this.$store.state.user.authentionList)
      },

      //获取页面菜单列表
      queryList(){
        this.getOrganList().then(res => {

          this.data=res.data;
          this.loadingTable=false;
        })
      },
      //判断是否有删除权限
      showDeleteButton(params){
        return this.$store.state.user.userOrganId != params.row.id && this.buttonVerifAuthention("sys:organ:deleteOrgan");
      },

      //点击添加子菜单按钮
      addOrganChildButton(scope){
        this.formValidateOrganAdd = {
          id:'',
          organName: '',
          organRemake: '',
          sorting: '',
          parentId:0
        };
        this.formValidateOrganAdd.parentId=scope.row.id;
        this.modalOrganAdd=true;
      },
      //添加主菜单提交
      addOrganChildClick(){
        this.handleSubmitAdd('formValidateOrganAdd');
      },
      //表单验证提交
      handleSubmitAdd(name) {
        this.$refs[name].validate((valid) => {
          if (valid) {
            //表单提交
            //console.log(this.formValidate);
            let organ=this.formValidateOrganAdd;
            this.loadingModel=true;//启动提交按钮转圈
            this.addOrganChild({organ}).then(res => {

                this.loadingModel=false;//关闭提交按钮转圈
                this.modalOrganAdd = false;//关闭弹窗
                //情况表单数据
                this.formValidateOrganAdd = {
                  id:'',
                  organName: '',
                  organRemake: '',
                  sorting: '',
                  parentId:0
                };
                //刷新菜单页面
                this.queryList();

            })
          } else {
            this.$Message.error('请按要求填写信息!');
          }
        })
      },


      //删除机构
      deleteOrganChildButton(scope){
          this.$Modal.confirm({
            title: '删除',
            content: '<p>你确认要删除此条信息吗!</p>',
            onOk: () => {
              let organId=scope.row.id;
              this.deleteOrganById({organId}).then(res => {

                  this.$Message.success(res.msg);
                  //刷新菜单页面
                  this.queryList();

              })
            },
            onCancel: () => {
              this.$Message.info('取消删除!');
            }
          });
      },

      //编辑
      editOrganChildButton(scope){
        this.formValidateOrganEdit.id=scope.row.id;
        this.formValidateOrganEdit.organName=scope.row.organName;
        this.formValidateOrganEdit.organRemake=scope.row.organRemake;
        this.formValidateOrganEdit.sorting=scope.row.sorting+'';
        this.formValidateOrganEdit.parentId=scope.row.parentId;
        this.modalOrganEdit=true;
      },

      //编辑菜单提交
      editOrganChildClick(){
        this.handleSubmitEdit('formValidateOrganEdit');
      },
      //表单验证提交
      handleSubmitEdit(name) {
        this.$refs[name].validate((valid) => {
          if (valid) {
            //表单提交
            let organ=this.formValidateOrganEdit;
            this.loadingModel=true;//启动提交按钮转圈
            this.editOrganById({organ}).then(res => {

                this.loadingModel=false;//关闭提交按钮转圈
                this.modalOrganEdit = false;//关闭弹窗
                //情况表单数据
                this.formValidateOrganEdit = {
                  id:'',
                  organName: '',
                  organRemake: '',
                  sorting: '',
                  parentId:0
                };
                //刷新菜单页面
                this.queryList();

            })
          } else {
            this.$Message.error('请按要求填写信息!');
          }
        })
      },
    }
  }
</script>

<style>

</style>
