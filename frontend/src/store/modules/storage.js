import axios from 'axios';

const storage = {
    fetch() {
        // const arr = [];
        // 로컬 스토리지의 아이템 목록 뿌리기
        // if (localStorage.length > 0) {
        //     for (let i = 0; i < localStorage.length; i++) {
        //         if (
        //             localStorage.key(i) !== "loglevel:webpack-dev-server" &&
        //             localStorage.key(i) !== "csCursors" &&
        //             localStorage.key(i) !== "csPointers" &&
        //             localStorage.key(i) !== "userName"
        //         ) {
        //             console.log(JSON.parse(localStorage.getItem(localStorage.key(i))));
        //             console.log(localStorage.getItem(localStorage.key(i)));
        //             console.log(typeof JSON.parse(localStorage.getItem(localStorage.key(i))));
        //
        //             arr.push(
        //                 JSON.parse(localStorage.getItem(localStorage.key(i)))
        //             );
        //         }
        //     }
        // }

        /* 서버 통신 */
        const test = [];

        axios
            .get('/todos')
            .then(res => {
               const jsonData = res.data;

               if(jsonData.length > 0){
                   for(let i = 0 ; i < jsonData.length; i++){
                       console.log(jsonData[i]);
                       test.push(
                           jsonData[i]
                       );
                   }
               }
            });
        console.log(test);

        return test;
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