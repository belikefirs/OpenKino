<template>
    <div class="wrapper_module_window">
        <div class="backgroundMask" @click="changeBlur"></div>
        <div class="container"> 
            <!-- :style="{width: width + 'px', height: height + 'px'}" -->
            <p class="Title">
                <slot name="title"></slot>
            </p>
            <slot name="content"></slot>
            <slot name="buttons"></slot>        
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
    z-index: 200;
    position: absolute;
    top: 0;
    left: 0;
    height: 100vh;
    width: 100%;
    background: rgba(31,31,31,0.5);
    display: flex;
    justify-content: center;
    align-items: center;
}
.backgroundMask{
    position: fixed;
    height: 100%;
    width: 100%;
    /* background: linear-gradient(#f43,#34f) */
    background: rgba(31,31,31,0.5);
}
.container{
    z-index: 201;
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
    letter-spacing: 1px;
    font-weight: 100;
}
</style>
