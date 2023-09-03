<template>
  <div class="components-container">
    <aside>
      //文档提交显示
<!--      Based on <a class="link-type" href="https://github.com/rowanwins/vue-dropzone"> dropzone </a>.-->
      {{ $t('components.dropzoneTips') }}
    </aside>
    <div class="editor-container">
      <dropzone id="myVueDropzone" url="http://localhost/test/upload" @dropzone-removedFile="dropzoneR" @dropzone-success="dropzoneS" />
    </div>
  </div>
</template>

<script>
import Dropzone from '@/components/Dropzone'
export default {
  name: 'DropzoneDemo',
  components: { Dropzone },
  methods: {
    dropzoneS(file) {
      // this.axios({
      //   url:'http://localhost/test/upload', //此处是你向后端发送数据的地址，根据你自己的地址进行修改
      //   data:file.blob(),
      //   method:"POST",  //设置为POST请求
      //   header:{
      //     'Content-Type':'multipart/form-data' //规定传递的参数格式为json
      //     // 'Content-Type':'application/json' //规定传递的参数格式为json
      //   }
      // }).then(res=>{
      //   console.log('1111111111111111111111111111111111111111111111')
      // })
      console.log(file.size)
      this.$message({ message: 'Upload success', type: 'success' })
    },
    dropzoneR(file) {
      console.log(file)
      this.$message({ message: 'Delete success', type: 'success' })
    }
  }
}
</script>

