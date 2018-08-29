/**
 * Created by midisnake on 28-8-2018.
 */
var object = JSON.parse("{}");
object["table1"] = document.querySelector("#table").value;
object["table2"] =  document.querySelector("#table").value;
object["column1"] = document.querySelector("#column").value;
object["value1"] = document.querySelector("#value1").value;
object["value2"] = document.querySelector("value2").value;
object["database_id"] = document.querySelector("database_id").value;

function InitPage(){

}

function renderAttributeRangeRule(object){
    // here comes the code
    var tr = document.createElement("tr");

    let td = document.createElement("td");
    let table1 = document.createTextNode(object["table1"]);
    td.appendChild(table1);
    tr.appendChild(td);

    td = document.createElement("td");
    var column1 = document.createTextNode(object["column1"]);
    td.appendChild(column1);
    tr.appendChild(td);

}