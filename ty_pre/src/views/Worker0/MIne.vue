<template>
      <li class="nick-name">
                            <div class="label">
                                <p>名字</p>
                            </div>
                            <div class="disable-text">
                                <div class="box" v-show="nicknameShow">
                                    <p>{{nickname}}</p>
                                    <el-button type="text" @click="inputShow()">修改</el-button>
                                </div>
                                <div class="btn" v-show="nicknameInputShow">
                                    <input type="text" :value="nickname">
                                    <el-button @click="nameShow()">取消</el-button>
                                    <el-button type="primary" @click="save()">保存</el-button>
                                </div>
                            </div>
                        </li>

</template>


<script>
export default {
    name: "Mine",
    data () {
        return {
            nickname:'宋佳佳',
            nicknameShow:true,
            nicknameInputShow:false
        }
    },
    methods: {
        inputShow () {
            this.nicknameShow = false;
            this.nicknameInputShow = true;
        },
        nameShow () {
            this.nicknameShow = true;
            this.nicknameInputShow = false;
        },
        save () {
            this.nickname = "";
            this.nameShow()
        }
    }


}

</script>
