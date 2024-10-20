import "./Counter.css"
import CounterButton from "./CounterButton.jsx"
import ResetButton from "./ResetButton.jsx"

import { useState } from 'react';

export default function Counter() {
    const [count, setCount] = useState(0);

    function incrementCounterParentFunction(by){
        setCount(count + by)
    }
    function decrementCounterParentFunction(by){
        setCount(count - by)
    }
    function reset(){
        setCount(0)
    }
    
    return (
        <>
            <span className="totalCount">{count}</span>
            <CounterButton by={1} incrementCounter={incrementCounterParentFunction} decrementCounter={decrementCounterParentFunction}/>
            <CounterButton by={3} incrementCounter={incrementCounterParentFunction} decrementCounter={decrementCounterParentFunction}/>
            <CounterButton by={5} incrementCounter={incrementCounterParentFunction} decrementCounter={decrementCounterParentFunction}/>
            <ResetButton reset={reset}></ResetButton>
        </>
    )
}
