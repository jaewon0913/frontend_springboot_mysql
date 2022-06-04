<template>
  <div>
    <transition-group name="list" tag="ul">
      <li v-for="(todoItem, index) in propsdata" v-bind:key="todoItem.item" class="shadow">
        <i class="checkBtn fas fa-check" v-bind:class="{checkBtnCompleted: todoItem.completed}"
        v-on:click="toggleComplete(todoItem, index)">
        </i>
        <span v-bind:class="{textCompleted: todoItem.completed}">{{ todoItem.item }}</span>
        <span class="removeBtn" v-on:click="removeTodo(todoItem, index)">
          <i class="fas fa-trash-alt"></i>
        </span>
      </li>
    </transition-group>
  </div>
</template>

<script>
export default {
  // data: function(){
  //   return {
  //     todoItems: []
  //   }
  // },
  // created: function(){
  //   //console.log('created');
  //   if (localStorage.length > 0){
  //     for (var i = 0; i < localStorage.length; i ++){
  //       if (localStorage.key(i) !== 'loglevel:webpack-dev-server'){
  //         this.todoItems.push(JSON.parse(localStorage.getItem(localStorage.key(i))));
  //         //this.todoItems.push(localStorage.key(i));
  //       }
  //       //this.todoItems.push(localStorage.key(i));
  //       //console.log(localStorage.key(i));      
  //     }
  //   }
  // },
  props: ['propsdata'],
  methods: {
    removeTodo: function(todoItem, index){
      //console.log('remove todo');
      //console.log(todoItem + ", " + index);
      this.$emit('removeItem', todoItem, index);
      // localStorage.removeItem(todoItem);
      // this.todoItems.splice(index, 1);
    },
    toggleComplete: function(todoItem, index){
      this.$emit('toggleItem', todoItem, index);
      // todoItem.completed = !todoItem.completed;
      
      //  로컬 스토리지의 데이터를 갱신
      // localStorage.removeItem(todoItem.item);
      // localStorage.setItem(todoItem.item, JSON.stringify(todoItem));
      //console.log(index);
    }
  }
}
</script>

<style scoped>
ul {
  list-style-type: none;
  padding-left: 0px;
  margin-top: 0;
  text-align: left;
}

li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background: white;
  border-radius: 5px;
}

.removeBtn {
  margin-left : auto;
  color: #de4343;
}

.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-right: 5px;
}

.checkBtnCompleted {
  color: #b3adad;
}

.textCompleted {
  text-decoration: line-through;
  color: #b3adad;
}

/* 리스트 아이템 트랜지션 효과 */
.list-enter-active, .list-leave-active {
  transition: all 1s;
}
.list-enter, .list-leave-to /* .list-leave-active below version 2.1.8 */ {
  opacity: 0;
  transform: translateY(30px);
}
</style>