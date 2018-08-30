/**
 * Created by midisnake on 30-8-2018.
 */



function initalizeNewOptions(table_id, column_id){
    var input = JSON.parse("{}");
    input["database_id"] = 1;
    var data = postCall(input, "http://localhost:8080/rest/target/tables", "json");
    $.each(data.tables, function () {
        $(table_id).append("<option value='" + this +"'>" + this +"</option>")
    });
    $(table_id).change(function () {
        var input1 = JSON.parse("{}");
        input1[table_id] = $(this).val();
        var columns = postCall(input1, "http://localhost:8080/rest/target/columns", "json");
        $(column_id).empty();
        $(column_id).append("<option value='" + null +"'>" + 'select column' +"</option>");
        $.each(columns.columns, function () {
            $(column_id).append("<option value='" + this +"'>" + this +"</option>")
        })
});


function renderNewBusinessRules(object, table_id){
        let tr = document.createElement("tr"),
            button = document.createElement("button"),
            td = document.createElement("td"),

            table = document.querySelector(table_id).value;

    button.type="submit";
    button.name="generate";
    button.id="generate";
    button.class="btn btn-success";
    button.addEventListener("click", function(){ postCall(
            object,
            "rest/businessRule/generate/" + object["type"],
            "json"
        );
    });

        let status = document.createTextNode(object["STATUS"]),
            type = document.createTextNode(object["type"]),
            name = document.createTextNode(object["NAME"]),
            buttonText = document.createTextNode("Generate Business Rule");
    }

    td.appendChild(name);
    tr.appendChild(td);


    td = document.createElement("td");
    td.appendChild(status);
    tr.appendChild(td);

    td = document.createElement("td");
    td.appendChild(type);
    tr.appendChild(td);

    td = document.createElement("td");
    button.appendChild(buttonText);
    td.appendChild(button);
    tr.appendChild(tr);
}

/**
 * Created by midisnake on 28-8-2018.
 * It's a facade for rendering content
 */


function initalizeNewOptions(_tableMenuId, _columnOptionsId){
    var input = JSON.parse("{}");
    input["database_id"] = 1;
    var data = postCall(input, "http://localhost:8080/rest/target/tables", "json");

    $.each(data.tables, function () {
        $(_tableMenuId).append("<option value='" + this +"'>" + this +"</option>")
    });
    $(_tableMenuId).change(
        function () {
            var input1 = JSON.parse("{}");
            input1["table"] = $(this).val();
            var columns =
                postCall(input1, "http://localhost:8080/rest/target/columns", "json");
            $(_columnOptionsId).empty();
            $(_columnOptionsId).append("<option value='" + null +"'>" + 'select column' +"</option>");
            $.each(columns.columns, function () {
                $(_columnOptionsId).append("<option value='" + this +"'>" + this +"</option>")
            })
        });

};

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

                case "or" :
                    postCal(object, "rest/countries/generate/or", "json");
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
