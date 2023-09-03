<template>


  <div>

    <button @click="test">测试按钮</button>
    <a>{{this.shuju1}}</a>
  </div>
</template>

<script>
import Dropzone from '@/components/Dropzone'
import test1 from '@/api/test'
export default {
  name: "test",
  components: {Dropzone},
  created() {
    // test1().then(res=>{
    //   console.log(res.data)
    // })
    test1().then(res=>{
      var jsonString = res.data
      var jsonObject = JSON.parse(jsonString)
      this.shuju1=jsonObject
      // this.shuju1=jsonObject
      // console.log(jsonObject)
      // console.log(jsonObject.result.college)
    })

  },
  methods: {
    test() {
      console.log("++++++++++++++++++++++++++++++++++++++++++")
      console.log("测试")
      test1().then(res=>{
        var jsonString = res.data[0].title
        var jsonObject = JSON.parse(jsonString)
        console.log(jsonObject)
        console.log(jsonObject.result.college)
      })
    }
  },
  data(){
    return{
      shuju1:'asdasd'
    }
  }

}
</script>

