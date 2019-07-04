<template>
    <div class="footer-wrapper">
        <p class="social">Наши социальные сети</p>
        <div class="social_mes">
            <ul class="nav">
                <li><button>vконтакте</button></li>
                <li><button>instagram</button></li>
                <li><button>facebook</button></li>
            </ul>
        </div>

<!--<div class="copy_foot"> 
				©2019 Кинотеатр «Практика» - все права защищены. 
        </div>-->
    </div>
</template>

<style lang="sass">
    .footer-wrapper
        width: 100%
        background-color: #C4C4C4
        height: 200px
        .social
            font-size: 34px
            margin-left:100px
            margin-bottom: 20px
        .nav
            display: flex
            justify-content: center
            li
                margin-right: 100px
                list-style: none
                button
                    margin-top: 20px
                    height: 80px
                    wight: 280px
                    background-color: color
                    color: black
                    font-size: 34px
                    border-radius: 25px
                    padding: 20px
                    text-transform: uppercase
                    &:hover
                        background-color: #8770fa  
</style>
