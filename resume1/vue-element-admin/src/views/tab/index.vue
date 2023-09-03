<template>
  <div class="tab-container" style="height: auto">
    <testss></testss>
<!--    <test-ch></test-ch>-->
  </div>

</template>

<script>
import TabPane from './components/TabPane'
import allMessage from "@/views/tab/components/allMessage";
import testCh from "@/views/tab/components/testCh";
import testss from "@/views/tab/components/testss";
export default {
  name: 'Tab',
  components: {allMessage,testCh,testss},
  data() {
    return {


    }
  },

  created() {
  },
  mounted(){
  },
  methods: {

  }
}
</script>

<style scoped>
</style>
