const obj = {
    name : "Dhano",
    address : {
        building : 4,
        area : "N.G Park"
    },
    languages : ["Java","C++","C","Python"],
    printLang : () => {     
        obj.languages.map(
            language => console.log(language)
        )
    }
}
function LearningJavaScriptObject(){
    return(
        <>
        {/* To display object value write inside {} */}
            <div>{obj.name}</div> 
            <div>{obj.address.area}</div>
            <div>{obj.languages[1]}</div>
            <div>{obj.printLang()}</div>
        </>
    )
}
export default LearningJavaScriptObject