<template>
  <div class="inputBox shadow">
    <input type="text" v-model="newTodoItem" v-on:keyup.enter="addTodo">
    <!-- <button v-on:click="addTodo">add</button> -->
    <span class="addContainer" v-on:click="addTodo">
        <i class="fas fa-plus addBtn"></i>
    </span>

    <Modal v-if="showModal" @close="showModal = false">
        <!--
        you can use custom content here to overwrite
        default content
        -->
        <h3 slot="header">
            경고!
            <i class="closeModalBtn fas fa-times" @click="showModal = false"></i>
        </h3>

        <div slot="body">
            아무것도 입력하시지 않으셨습니다.
        </div>
    </Modal>
  </div>
</template>

<script>
import Modal from './common/Modal.vue';

export default {
    data(){
        return {
            newTodoItem: "",
            showModal: false
        }
    },
    methods: {
        addTodo(){
            //console.log(this.newTodoItem);
            //  저장 로직
            if (this.newTodoItem !== ''){
                // this.$emit('이벤트 이름', 인자);
                //this.$emit('addTodoItem', this.newTodoItem);

                const text = this.newTodoItem.trim();
                this.$store.commit('addOnItems', text);
                
                // var obj = {completed: false, item: this.newTodoItem};
                // localStorage.setItem(this.newTodoItem, JSON.stringify(obj));

                //  input 비우기
                //this.newTodoItem = '';
                this.clearInput();
            } else {
                this.showModal = !this.showModal;
            }
        },
        clearInput(){
            this.newTodoItem = '';
        }
    },
    components: {
        Modal
    }
}
</script>

<style scoped>
input:focus {
    outline: none;
}

.inputBox {
    background: white;
    height: 50px;
    line-height: 50px;
    border-radius: 5px;
}

.inputBox input {
    border-style: none;
    font-size: 0.9rem;
}

.addContainer {
    float: right;
    background: linear-gradient(to right, #6478FB, #8763FB);
    display: block;
    width: 3rem;
    border-radius: 0 5px 5px 0;
}

.addBtn {
    color: white;
    vertical-align: middle;
}

.closeModalBtn {
    color: #43b983;
}

</style>