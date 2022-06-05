import axios from 'axios';
import {store} from "@/store/store";

const storage = {
    async fetch() {
        /* 서버 통신 */
        const arr = [];

        await axios
            .get('/todos')
            .then(res => {
               const jsonData = res.data;

               if(jsonData.length > 0){
                   for(let i = 0 ; i < jsonData.length; i++){
                       console.log(jsonData[i]);
                       arr.push(
                           jsonData[i]
                       );
                   }
               }
            });

        store.state.todoItems = arr;

        return arr;
    },
    fetchName() {
        // 로컬 스토리지의 사용자 이름 가져오기
        if (localStorage.getItem("userName")) {
            const userName = localStorage.getItem("userName");
            return userName;
        }
    }
}

export default storage;