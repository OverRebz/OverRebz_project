<template>
  <div>
    <div id="char2" ref="chart" :style="{ width: '100%', height: '100%' }"> </div>
  </div>
</template>

<script>
import echarts from 'echarts'

export default {
  name: "wordcloud",
  props: {
    message:{
      type:Object,
      required: true
    }
  },
  mounted() {
    setTimeout(() => {
      this.initCharts(); //初始化
    }, 0);
  },
  beforeDestroy() {
    if (!this.chart) {
      return;
    }
    this.chart.dispose();
    this.chart = null;
  },
  data(){
    return{
    }
  },
  methods:{
    initCharts() {
      console.log(this.message);

      let a = this.$refs.chart;

      let myChart2 = this.$echarts.init(a);
      myChart2.setOption({
        title: {
          //text: "center"
        },
        backgroundColor: "#ffffff",
        tooltip: {},

        series: [
          {
            type: "wordCloud",
            //用来调整词之间的距离
            gridSize: 10,
            // //用来调整字的大小范围

            sizeRange: [14, 60],
            // //用来调整词的旋转方向，，[0,0]--代表着没有角度，也就是词为水平方向，需要设置角度参考注释内容
            rotationRange: [0, 0],
            //随机生成字体颜色
            textStyle: {
              fontFamily: "sans-serif",
              fontWeight: "bold",
              // Color can be a callback function or a color string
              normal:{     color: function () {

                  var colorArr = ['#fda67e', '#81cacc', '#cca8ba', "#88cc81", "#82a0c5", '#fddb7e', '#735ba1', '#bda29a', '#6e7074', '#546570', '#c4ccd3'];

                  return (
                    "rgb(" +
                    [
                      Math.round(Math.random() * 160),
                      Math.round(Math.random() * 160),
                      Math.round(Math.random() * 160),
                    ].join(",") +
                    ")"
                  );
                },},

            },
            emphasis: {
              focus: "self",

              textStyle: {
                shadowBlur: 10,
                shadowColor: "#333",
              },
            },
            //位置相关设置
            left: "center",
            top: "center",
            right: null,
            bottom: null,
            width: "200%",
            height: "200%",
            //数据
            data: this.message,
          },
        ],
      });
      //点击事件
      myChart2.on('click', function (params) {
        alert(params.name);
      });
    },
  }
}
</script>

<style scoped>

</style>
