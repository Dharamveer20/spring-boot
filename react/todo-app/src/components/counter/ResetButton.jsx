import "./Counter.css";
export default function ResetButton({reset}){
    return(
        <>
            <button className="reset" onClick={reset}>Reset</button>
        </>
    )
}

