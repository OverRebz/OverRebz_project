<template>
  <div>
    <div class="filter-container">


    </div>
    <el-table
      :data="this.tData"
      border
      fit
      highlight-current-row
      style="width: 100%;">
      <el-table-column prop="result.name" label="姓名"></el-table-column>
      <el-table-column prop="result.gender" label="性别"></el-table-column>
      <el-table-column prop="result.living_address_norm" label="居住地址"></el-table-column>
      <el-table-column prop="result.cont_job_skill" label="工作技能"></el-table-column>
      <el-table-column prop="result.major" label="专业"></el-table-column>
      <el-table-column prop="result.degree" label="学历"></el-table-column>
      <el-table-column
        prop="result.college" label="毕业大学"></el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="380">
        <el-button type="primary">查看详细信息</el-button>
        <el-button type="success">查看技能</el-button>
        <el-button  type="danger">删除</el-button>
      </el-table-column>
    </el-table>

  </div>
</template>

<script>

import {test3} from "@/api/test";

export default {
  name: "xtest",
  created() {
    test3().then(res => {
      console.log(res)
      this.tData = res.data
    })
  },
  data() {
    return {
      tData: null,
    }
  },
  methods: {}
}
</script>

<style scoped>

</style>
