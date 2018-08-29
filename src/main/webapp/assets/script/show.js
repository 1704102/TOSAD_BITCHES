/**
 * Created by midisnake on 28-8-2018.
 * It's a facade for rendering content
 */
var something = {
    "STATUS": "new",
    "RULE_ID": 1,
    "OPERATOR": "<",
    "VALUE1": 200,
    "TABLE1": "ORDERS",
    "COMPOSITE_ID": 1,
    "COLUMN1": "PERSONAID",
    "type": "acr",
    "NAME": "ORDERS_CNS_ACR_1"
};

function addOptions(object, select_id){
    var input = JSON.parse("{}");
    input["database_id"] = 1;
    var data = postCall(input, "http://localhost:8080/rest/target/tables", "json");
    
    $.each(data.tables, function () {
        $(select_id).append("<option value='" + this +"'>" + this +"</option>")
    });
    $(select_id).change(
        function () {
            var input1 = JSON.parse("{}");
            input1["table"] = $(this).val();
            var columns =
                postCall(input1, "http://localhost:8080/rest/target/columns", "json");

    });
}
function renderNewBusinessRules(object, table_id){
    if(object["STATUS"] == "new"){
        console.log("show.js: " + object["name"]);

        let tr = document.createElement("tr"),
            td = document.createElement("td"),
            button = document.createElement("button");

        button.type = "submit";
        button.name = "generate";
        button.addEventListener("click", function(){
            switch(object["type"]) {
                case "arr" :
                    postCal(object, "rest/countries/generate/arr", "json");
                    break;

                case "acr" :
                    postCal(object, "rest/countries/generate/acr", "json");
                    break;

                case "alr" :
                    postCal(object, "rest/countries/generate/alr", "json");
                    break;

                case "tcp" :
                    postCal(object, "rest/countries/generate/tcp", "json");
                    break;

                case "iec" :
                    postCal(object, "rest/countries/generate/iec", "json");
                    break;
            }
        });
        button.class = "btn btn-success";

        let status = document.createTextNode(object["STATUS"]),
            name = document.createTextNode(object["NAME"]),
            type = document.createTextNode(object["type"]),
            buttonText = document.createTextNode("Generate Business Rule");

        td.appendChild(name);
        tr.appendChild(td);

        td = document.createElement("td");
        td.appendChild(status);
        tr.appendChild(td);

        td = document.createElement("td");
        td.appendChild(type);
        tr.appendChild(td);

        button.appendChild(buttonText);
        tr.appendChild(button);

        document.querySelector(table_id).appendChild(tr);

    }
}
//
//function renderAttributeRangeRule(input){
//    // here comes the code
//    let tr = document.createElement("tr"),
//        td = document.createElement("td");
//
//    let table1 = document.createTextNode(object["table1"]);
//    td.appendChild(table1);
//    tr.appendChild(td);
//
//    td = document.createElement("td");
//    let column1 = document.createTextNode(object["column1"]);
//    td.appendChild(table1);
//    tr.appendChild(td);
//
//
//    td = document.createElement("td");
//    var value1 = document.createTextNode(object["value1"]);
//    td.appendChild(value1);
//    tr.appendChild(td);
//
//    td = document.createElement("td");
//    let column1 = document.createTextNode(object["value2"]);
//    td.appendChild(table1);
//    tr.appendChild(td);
//
//    td = document.createElement("td");
//    let  = document.createTextNode(object[""]);
//    td.appendChild(table1);
//    tr.appendChild(td);
//
//
//}
//
//function renderAttributeCompareRule(input){
//
//}