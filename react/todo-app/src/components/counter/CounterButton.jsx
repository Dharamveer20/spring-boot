import "./Counter.css"
import { PropTypes } from 'prop-types';

// Jo props receive ho raha hai unka must same as props passed 
export default function CounterButton({ by, incrementCounter, decrementCounter}) {  
/*
    const [count, setCount] = useState(0);

    function incrementCounterFunction() {
        setCount(count + by); // Para => What to do of the count. Here Increment count by "by" which is passed by props 
        incrementCount(by);
    }

    function decrementCounterFunction() {
        setCount(count - by); // Para => What to do of the count. Here Decrement count by "by" which is passed by props
        decrementCounter(by);
    }
*/
    return (
        <div className="Counter">
            {/* See below using count */}
            {/* <span className="count">{count}</span> */}
            <br></br>
            {/* onclick of button calling incrementCounterFunction which increases the count by "by" which is passed by props*/}
            <button
                className="counterButton"
                // onClick={incrementCounterFunction} 
                onClick={() => incrementCounter(by)} // Onclick expects a method to call. Here created an arrow method instead of calling a method
            >+{by}</button>

            <button
                className="counterButton"
                // onClick={decrementCounterFunction} 
                onClick={() => decrementCounter(by)}
            >-{by}</button>
        </div>
    )
}

// Adding Validation/ Constraints to props received.
CounterButton.propTypes = {
    by: PropTypes.number
}
CounterButton.propDefault = {
    by: 5
}