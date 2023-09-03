<!--<template>-->
<!--  <div id="first-page" class="app-bottem">-->
<!--    <div id="first-page-div" v-for="item in articles" :key="item">-->
<!--      <h1>{{item.result.name}}</h1>-->
<!--      <h2>基本信息</h2>-->
<!--        <p>姓氏：</p><p>{{item.result.surname}}</p>-->
<!--        <p>性别：</p><p>{{item.result.gender}}</p>-->
<!--        <p>年龄：</p><p>{{item.result.age}}</p>-->
<!--    </div>-->
<!--  </div>-->
<template>
  <div id="first-page" class="app-bottem">
    <div id="first-page-div" v-for="item in articles" :key="item">
      <!--    <div ref="print">-->
      <!--    <div style="margin:0 auto;">-->
      <div style="text-align:center;margin-top:10px;">个人简历</div>
      <table class="table table-striped table-bordered" align="center" valign="center">
        <tr>
          <td class="column" colspan="6">基本信息</td>
        </tr>
        <tr>
          <td class="column">姓名</td>
          <td class="value">{{ item.result.name }}</td>
          <td class="column">性别</td>
          <td class="value">{{ item.result.gender }}</td>
          <td class="column">出生年月</td>
          <td class="value">{{ item.result.birthday }}</td>
        </tr>
        <tr>
          <td class="column">民族</td>
          <td class="value">汉</td>
          <td class="column">婚否</td>
          <td class="value"></td>
          <td class="column">政治面貌</td>
          <td class="value">{{ item.result.polit_status }}</td>
        </tr>
        <tr>
          <td class="column">籍贯</td>
          <td class="value">{{ item.result.hometown_address_norm }}</td>
          <td class="column">学历</td>
          <td class="value">{{ item.result.degree }}</td>
          <td class="column">现所在地</td>
          <td class="value"></td>
        </tr>
        <tr>
          <td class="column">毕业院校</td>
          <td class="value" colspan="3">{{ item.result.education_objs[0].edu_college }}</td>
          <td class="column">所在专业</td>
          <td class="value">{{ item.result.education_objs[0].edu_major }}</td>
        </tr>
        <tr>
          <td class="column">电子邮箱</td>
          <td class="value" colspan="3">{{ item.result.email }}</td>
          <td class="column">手机号码</td>
          <td class="value">{{ item.result.phone }}</td>
        </tr>
        <tr>
          <td class="column" colspan="6">教育经历</td>
        </tr>
        <tr>
          <td class="value" colspan="2">起止时间</td>
          <td class="value" colspan="2">毕业院校/教育机构</td>
          <td class="value" colspan="2">专业/课程</td>
        </tr>
        <tr>
          <td class="value" colspan="2">
            {{ item.result.education_objs[0].start_date }}~{{ item.result.education_objs[0].end_date }}
          </td>
          <td class="value" colspan="2">{{ item.result.education_objs[0].edu_college }}</td>
          <td class="value" colspan="2">{{ item.result.education_objs[0].edu_major }}</td>
        </tr>
        <tr>
          <td class="value" colspan="2"></td>
          <td class="value" colspan="2"></td>
          <td class="value" colspan="2"></td>
        </tr>
        <tr>
          <td class="value" colspan="2"></td>
          <td class="value" colspan="2"></td>
          <td class="value" colspan="2"></td>
        </tr>
        <tr>
          <td class="column" colspan="6">工作经历</td>
        </tr>
        <tr>
          <td class="value" colspan="2">起止时间</td>
          <td class="value" colspan="2">公司名称</td>
          <td class="value" colspan="2">职位</td>
        </tr>
        <tr>
          <td v-if="item.result.job_exp_objs.length!==0" class="value" colspan="2">
            {{ item.result.job_exp_objs[0].start_date }}~{{ item.result.job_exp_objs[0].end_date }}
          </td>
          <td v-if="item.result.job_exp_objs.length!==0" class="value" colspan="2">
            {{ item.result.job_exp_objs[0].job_cpy }}
          </td>
          <td v-if="item.result.job_exp_objs.length!==0" class="value" colspan="2">
            {{ item.result.job_exp_objs[0].job_position }}
          </td>
        </tr>
        <tr>
          <td v-if="item.result.job_exp_objs.length>1" class="value" colspan="2">
            {{ item.result.job_exp_objs[1].start_date }}~{{ item.result.job_exp_objs[1].end_date }}
          </td>
          <td v-if="item.result.job_exp_objs.length>1" class="value" colspan="2">
            {{ item.result.job_exp_objs[1].job_cpy }}
          </td>
          <td v-if="item.result.job_exp_objs.length>1" class="value" colspan="2">
            {{ item.result.job_exp_objs[1].job_position }}
          </td>
        </tr>
        <tr>
          <td v-if="item.result.job_exp_objs.length>2" class="value" colspan="2">
            {{ item.result.job_exp_objs[2].start_date }}~{{ item.result.job_exp_objs[2].end_date }}
          </td>
          <td v-if="item.result.job_exp_objs.length>2" class="value" colspan="2">
            {{ item.result.job_exp_objs[2].job_cpy }}
          </td>
          <td v-if="item.result.job_exp_objs.length>2" class="value" colspan="2">
            {{ item.result.job_exp_objs[2].job_position }}
          </td>
        </tr>
        <tr>
          <td class="column">爱好</td>
          <td class="value" colspan="5"></td>
        </tr>
        <tr>
          <td class="column">技能</td>
          <td class="value" colspan="5" style="text-align:left;">
            <li v-for="item1 in item.result.skills_objs">
              {{ item1.skills_name }}
              <br><br><br><br>
            </li>
          </td>
        </tr>
        <tr>
          <td class="column">自我评价</td>
          <td class="value" colspan="5">{{ item.result.cont_hobby }}
            <br><br><br><br>
          </td>
        </tr>
      </table>
    </div>
  </div>
</template>

<style lang="less">
.table {
  border-collapse: collapse;
  border-spacing: 0;
  background-color: transparent;
  display: table;
  width: 100%;
  max-width: 100%;
  width: 800px;
  margin: 0 auto;
}

.table td {
  text-align: center;
  vertical-align: middle;
  font-size: 14px;
  font-family: 'Arial Normal', 'Arial';
  color: #333333;
  padding: 8px 12px;
}

.table-bordered {
  border: 1px solid #ddd;
}

* {
  margin: 0px;
  padding: 0px;
}

.column {
  width: 30px;
  height: 30px;
  border: 1px solid #333;
  background: #f1f1f1;
}

.value {
  width: 70px;
  height: 30px;
  border: 1px solid #333;
}</style>


<script>
import {fetchList, fetchPv, createArticle, updateArticle} from '@/api/article'
import waves from '@/directive/waves' // waves directive
import {parseTime} from '@/utils'
import Pagination from '@/components/Pagination' // secondary package based on el-pagination
import articles from './articles2.json';
import axios from "axios";

export default {
  name: 'FirstPage',
  data() {
    return {
      articles: articles
    }
  },
  methods: {
    methods: {
      // 展示用户列表
      queryUserList() {
        axios.get('http://localhost:9090/user/queryList',).then(res => {
          this.articles = res.articles;
        }).catch(error => {
          console.log(error)
        });
      },
      mounted() {
        // 页面加载就渲染用户列表
        this.queryUserList();
      },
    },
  },
}
</script>
