<template>
    <div class="wrapper-User">
        <WrapperCent>
            <div class="Title"><p>Иван Иванов</p></div>
            <form>
                <label for="card" class="Textlabel">Введите номер карты: </label>
                <input type="text" class="usercab Card">
                <label for="balance" class="Textlabel">Сумма пополнения: </label>
                <input type="text" class="usercab Balance">
                     
            </form>
        </WrapperCent>
    </div>
</template>

<script>
import WrapperCent from '@/components/AppWrapperCenter.vue'
export default {
    components: {
        WrapperCent
    }
}
</script>

<style>
.wrapper-User {
    width: 100%;
    height: 800px;
    background: rgba(255,255,255,0.6);
}
.Title {
    background: rgba(48, 47, 47, 0.9);
    color: white;
    font-size: 44px;
    text-align: center;
    border-radius: 0 0 10px 10px;
}
.Textlabel {
    font-size: 28px;
    color: #222;
    display: block;
}
.usercab {
    width: 600px;
    height: 50px;
    border: 1px solid #222;
    background: white;
    padding: 2px 0 2px 15px;
    outline: none;
    margin-bottom: 20px;
}
.usercab:hover {

}
</style>
