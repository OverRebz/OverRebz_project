<template>
  <div>
    <div class="filter-container">


    </div>
    <el-table
      :data="this.tData"
      border
      fit
      highlight-current-row
      style="width: 100%;"
      :default-sort = "{prop: 'result.resume_parse_time', order: 'descending'}">
       <el-table-column prop="result.resume_parse_time" label="简历提交时间" sortable width="180px"></el-table-column>
      <el-table-column prop="result.name" label="姓名"></el-table-column>
      <el-table-column prop="result.gender" label="性别"></el-table-column>
      <el-table-column prop="result.living_address_norm" label="居住地址"></el-table-column>
<!--      <el-table-column prop="result.cont_job_skill" label="工作技能"></el-table-column>-->
      <el-table-column prop="result.major" label="专业"></el-table-column>
      <el-table-column prop="result.degree" label="学历"></el-table-column>
      <el-table-column
        prop="result.college" label="毕业大学"></el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="380">
        <template slot-scope="scop">
        <el-button type="primary" @click="showM(scop.row.result)">查看详细信息</el-button>
        <el-button type="success" @click="shows(scop.row.tags)">查看技能</el-button>
        <el-button  type="danger">删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog :visible.sync="dialogFormVisible">
      <RText v-if="dialogFormVisible" :message="this.showmdata"></RText>
    </el-dialog>
    <el-dialog :visible.sync="dialogFormVisible1">
<!--      <pie-chart></pie-chart>-->
      <wordcloud v-if="dialogFormVisible1" :message="this.sData" :style="{width: '100%', height: '350px'}"></wordcloud>
<!--        <couletest></couletest>-->
    </el-dialog>
  </div>
</template>

<script>

import {test3} from "@/api/test";
import PieChart from "@/views/dashboard/admin/components/PieChart";
import wordcloud from "@/views/xianshi/compents/wordcloud";
import Couletest from "@/views/xianshi/compents/couletest";
import RText from "@/views/xianshi/compents/RText";
export default {
  name: "xtest",
  components: {RText, Couletest, PieChart,wordcloud},
  created() {
    test3().then(res => {
      console.log(res)
      this.tData = res.data
    })
  },
  data() {
    return {
      dialogFormVisible:false,
      dialogFormVisible1:false,
      tData: null,
      showmdata:null,
      sData:null
    }
  },
  methods: {
    showM(data){
      console.log(data)
      this.showmdata=data
      this.dialogFormVisible=true
    },
    shows(data){
      console.log(data.skills_tags)
      this.dialogFormVisible1=true
      this.sData=data.skills_tags.map(item=>{
        return{
          name:item.tag_name,
          value:item.tag_weight
        }
      })

    }
  }
}
</script>

<style scoped>

</style>
