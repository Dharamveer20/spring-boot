import './App.css';
import Counter from './components/counter/Counter';
function App() {
  return (
    <div className="App">
       <Counter/>
    </div>
  );
}

// // First way of using props
// function PropEg(props){
//   // An object named props (can name it anything) with key property1 and property2 and value "Hello" and "World" is received.
//   console.log(props.property1)
//   console.log(props.property2)
// }

// // Another way of using Props
// // Deconstructing the object and storing in a variable
// function PropEg2({property1, property2}){
//   console.log(property1);
//   console.log(property2);
// }
export default App;
