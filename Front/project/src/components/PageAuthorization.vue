<template>
    <div class="wrapper-auto">
        <form>
        <p class="title_auto"><b>Авторизация</b></p>
        <div class="login tit">
            <label for="Llogin">Введите e-mail адрес:</label>
            <input type="email"></div>
        <div class="password tit">
            <label for="Ppassword">Введите ваш пароль:</label>
            <input type="password"></div>
        <p class="slip_pass">
            <a href="#">Забыли пароль?</a>
        </p>
        <div class="button_entry">
            <button>Войти</button>
            
        </div>
        </form>
    </div>
</template>

<style lang="sass">
    .wrapper-auto
        width: 300px
        height: 350px
        background: linear-gradient(to top, #E4AF9D 20%, #E4E4D8 50%, #A19887 80%)
        border-radius: 10px
        .title_auto
            font-size: 32px
            text-align: center
            margin-bottom: 30px
            letter-spacing: 1px
        .tit
            label
            letter-spacing: 1px
            font-weight: lighter
            font-size: 20px
            text-align: center
            input
                width: 180px
                height: 30px
                margin-bottom: 25px
        .slip_pass
            text-align: center
            a
                font-size: 18px
                color: black
        .button_entry
            text-align: center
            button
                margin-top: 30px
                width: 120px
                height: 60px
                border-radius: 2px
                font-size: 22px
                color: black
                &:hover
                    background-color: #a1999e
                    border: 1px solid white
                    
</style>
