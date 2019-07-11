<template>
    <div class="wrapper_module_window">
        <div class="backgroundMask" @click="changeBlur"></div>
        <div class="container"> 
            <!-- :style="{width: width + 'px', height: height + 'px'}" -->
            <p class="Title">
                <slot name="title"></slot>
            </p>
            <slot name="content"></slot>
        </div>
    </div>
</template>

<script>
export default {
    props:{
        width: {
            type: Number,
            requared: true
        },
        height: {
            type: Number,
            requared: true
        },
    },
    methods:{
		changeBlur(){
			this.$emit("showBlur");
		}
    },
    computed:{
        
    }
}
</script>


<style scoped>
.wrapper_module_window {
    position: fixed;
    top: 0;
    left: 0;
    height: 100vh;
    width: 100vw;
    background: rgba(31,31,31,0.5);
}
.backgroundMask{
    position: absolute;
    height: 100%;
    width: 100%;
    background: rgba(31,31,31,0.5);
}
.container{
    background: #212121;
    border-radius: 8px;
    margin: 100px auto 0;
}
.Title{
    padding: 20px;
    font-size: 27px;
    font-weight: 100;
    color: #ffffff;   
    text-align: left;
    letter-spacing: 2px;
    font-weight: 100;
}
</style>
