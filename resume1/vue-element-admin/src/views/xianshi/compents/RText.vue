<template>
<div>
<!--  {{this.message}}-->
  <el-descriptions title="基本信息">
    <el-descriptions-item label="姓名">{{this.message.name}}</el-descriptions-item>
    <el-descriptions-item label="年龄">{{this.message.age}}</el-descriptions-item>
    <el-descriptions-item label="手机号">{{this.message.phone}}</el-descriptions-item>
    <el-descriptions-item label="邮箱">{{this.message.email}}</el-descriptions-item>
    <el-descriptions-item label="居住地">{{this.message.hometown_address}}</el-descriptions-item>
     <el-descriptions-item label="简历提交时间">{{this.message.resume_parse_time}}</el-descriptions-item>
  </el-descriptions>
  <el-descriptions title="已获证书"  :colon=false>
    <el-descriptions-item v-for="item in this.message.all_cert_objs" >{{item.cert_name}}</el-descriptions-item>
  </el-descriptions>
  <el-descriptions title="教育经历" :colon=false>
    <el-descriptions-item>{{this.message.cont_education}}</el-descriptions-item>
  </el-descriptions>
  <el-descriptions title="工作经历" :column=1>
    <el-descriptions-item v-for="item in this.message.job_exp_objs" >
      开始时间:{{item.start_date}}  结束时间:{{item.end_date}} 公司名称:{{item.job_cpy}}工作内容:{{item.job_content}}
    </el-descriptions-item>
  </el-descriptions>
<el-button @click="test()">cehsi</el-button>
</div>
</template>

<script>
export default {
  name: "RText",
  props:{
    message:{
      type:Object,
      required: true
    }
  },
  methods:{
    test(){
      console.log(this.message)
    }
  }
}
</script>

<style scoped>

</style>
