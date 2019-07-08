<template>
    <div class="wrapper-auto">
        <div class="wrapper_window">
            <p class="title_auto"><b>Авторизация</b></p>
            <div class="login_password">
                <input type="email" placeholder="e-mail">
                <input type="password" placeholder="Пароль"></div>
            <div class="button_entry">
                <div class="b enter">Авторизироваться</div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    
}
</script>


<style lang="sass">
    .wrapper-auto
        width: 500px
        height: 270px
        background: #212121
        border-radius: 5px
        opacity: 0.7
        .wrapper_window
            padding: 20px
            .title_auto
                font-size: 27px
                color: #ffffff   
                text-align: left
                letter-spacing: 1px
                font-height: light
                input
                    width: 460px
                    height: 45px
                    background: #ffffff
                    opacity: 0.3
                    margin: 10px 0 10px 0
            .button_entry
                float: flex
                .b
                    margin-top: 45px
                    width: 121px
                    height: 35px
                    border-radius: 10px
                    font-size: 12px
                    color: black
                .enter
                    margin-left: 55px
                    margin-right: 125px
                    color: #502090
                    border: 1px solid #502090
                    
                .exit
                    color: #F36021 
                    border: 1px solid #F36021    
</style>
