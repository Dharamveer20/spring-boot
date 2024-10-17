import FunctionComponent from './FunctionComponent'
import ClassComponent from './ClassComponent'
import { ThirdFunctionComponent } from './FunctionComponent';
import LearnJsObj from "./LearningJavaScriptObject"

function LearningComponent() {
    return (
        <div>
            <FunctionComponent />
            <ClassComponent />
            <ThirdFunctionComponent></ThirdFunctionComponent>
            <LearnJsObj/>
        </div>
    )
}
export default LearningComponent;

