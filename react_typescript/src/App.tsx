import { useState } from "react"
import './App.css';

interface TodoList {
    id: number;
    item: string;
    completed: boolean;
}

function App() {

    // @ts-ignore
    const [todoList, setTodoList] = useState<TodoList[]>([
        {
            id: 1,
            item: "할일 1",
            completed: false
        },
        {
            id: 3,
            item: "할일 3",
            completed: false
        }
        ]);

  return (
    <div className="App">
        <h1>React + TypeScript TodoList</h1>
        <div className="todoListContainer">

            {todoList.map((item, idx) => (
                <div key={idx}>
                    <li className="todoContainer">
                        <button>완료</button>
                        <p>{item.item}</p>
                        <div className="buttonContainer">
                            <button type={"button"}>수정</button>
                            <button type="button">삭제</button>
                        </div>
                    </li>
                </div>
            ))}
        </div>
        <div className={"todoCreateContainer"}>
            <form>
                <input type={"text"} placeholder={"할 일을 입력해 주세요."} />
                <button>등록하기</button>
            </form>
        </div>
    </div>
  );
}

export default App;
