<template>
    <div class="wrapper-auto">
        <form>
        <p class="title_auto"><b>Авторизация</b></p>
        <div class="login tit">
            <input type="email" placeholder="e-mail"></div>
        <div class="password tit">
            <input type="password" placeholder="Пароль"></div>
        <div class="button_entry">
            <button class="b enter">Авторизироваться</button>
            <button class="b exit">Отмена</button>
        </div>
        </form>
    </div>
</template>

<style lang="sass">
    .wrapper-auto
        width: 477px
        height: 300px
        background: linear-gradient(to bottom, #F36021 12%, #f7ebe6 12%, #f7ebe6 88%)
        border-radius: 40px
        opacity: 0.9
        .title_auto
            font-size: 24px
            color: #ffffff   
            text-align: center
            letter-spacing: 1px
        .tit
            text-align: center
            input
                width: 370px
                height: 40px
                margin-top: 25px
                border: 2px solid #F36021
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
